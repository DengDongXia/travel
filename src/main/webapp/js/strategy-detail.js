$().ready(function() {
	getUser();   //获取用户是否登录的信息
	getQuestionText();
	getQuestionAnswer();
});

// 发起请求，判断当前用户是否登录
function getUser(argument) {
	$.ajax({
		url: 'data/userdata.json',
		type: 'post',
		dataType: 'json',
	})
	.done(function(data) {
		dealingUserData(data);
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
	
}

// 对后台返回的用户登录信息进行处理
function dealingUserData(data) {
	if(data[0].userId == null || data[0].userId == ''){
		var login = "<li><a href='login.html'><i class='fa fa-meh-o'> </i>登录</a></li>";
		var register = "<li><a target='_blank' href='register.html'><i class='fa fa-plus'> </i>注册</a></li>";
		$('#top-menu').append(login+register);
	}else{
		if(data[0].userName == null || data[0].userName == ''){
			var personal = "<li><a href='personal.html'><i class='fa fa-meh-o'> </i>个人中心</a></li>";
		}else{
			var personal = "<li><a href='personal.html'><i class='fa fa-meh-o'> </i>"+data[0].userName+"</a></li>";
		}
		$('#top-menu').append(personal);
	}
}

//获取json文件，即特色定制的问题详细内容，并插入页面
function getQuestionText() {
	/*//将文章id异步传到后台，进行相关处理后，返回对应的文章
	$.ajax({
		url: 'question/detail.json',
		type: 'get)',
		dataType: 'json',
		data: {questionId: getUrlQuestionId('questionId')},
	})
	.done(function() {
		$("#userPic").append("<img src='"+data[0].questionPersonPicture+"''>");
		$("#userPic").parent().append("<span class='name'>"+data[0].questionPersonName+"</span>");
		$("#userPic").parent().append("<span class='time'>"+data[0].questionTime+"</span>");
		// 插入问题具体信息
		$("#question-text").append("<h3><img src='images/strategy_r.png'>"+data[0].questionHeader+"</h3><h4>"+data[0].quesionContent+"</h4>");
		$("#question-text").next().append("<span class='num'>"+data[0].questionAnswerCount+"</span>");
	})

	//获取url中的参数
       function getUrlQuestionId(name) {
           var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
           var r = window.location.search.substr(1).match(reg);  //匹配目标参数
           if (r != null) return unescape(r[2]); return null; //返回参数值,即questionId的值
       }*/

	// 未连接后台时
	$.getJSON('data/questionDetail.json',function(data) {
		// 插入用户的相关信息
		$("#userPic").append("<img src='"+data[0].questionPersonPicture+"''>");
		$("#userPic").parent().append("<span class='name'>"+data[0].questionPersonName+"</span>");
		$("#userPic").parent().append("<span class='time'>"+data[0].questionTime+"</span>");
		// 插入问题具体信息
		$("#question-text").append("<h3><img src='images/strategy_r.png'>"+data[0].questionHeader+"</h3><h4>"+data[0].quesionContent+"</h4>");
		$("#question-text").next().append("<span class='num'>"+data[0].questionAnswerCount+"</span>");
	});

}

//获取问题对应的评论部分
function getQuestionAnswer(argument) {
	$.getJSON('data/questionComment.json', function(data) {
		$.each(data, function(index, val) {
			var user ="<div class='head-img'><div class='img-bg'><img src='"+val.commentUserPic+"'></div><span class='name'>"+val.commentUser+"</span></div>"; 
			var question = "<div class='question-text'><p>"+val.commentContent+"</p><p class='time'>"+val.commentTime+"</p></div>";
			$("#comments").append("<li>"+user+question+"</li>");
		});
	});
}

$('#strategy-text').focus(function(event) {
	$.ajax({
		url: 'data/userdata.json',
		type: 'post',
		dataType: 'json',
	})
	.done(function(data) {
		if(data[0].userId == null || data[0].userId == ''){
			window.location.href = "login.html";
		}else{
			// 发表攻略后，进行提交
			$("#offer").click(function() {
				$.get('comments/picture/submit',{
													//将对应评论的用户id传过去
					comment : $("#strategy-text").val(),   //将对应评论的内容传过去
					userId : data[0].userId          //将进行评论的用户的id传过去
				}, function(data) {  //回调函数对返回的值进行插入
					var user ="<div class='head-img'><div class='img-bg'><img src='"+data[0].commentUserPic+"'></div><span class='name'>"+data[0].commentUser+"</span></div>"; 
					var question = "<div class='question-text'><p>"+data[0].commentContent+"</p><p class='time'>"+data[0].commentTime+"</p></div>";
					$("#comments").append("<li>"+user+question+"</li>");
				});
			});

		}
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
	
});
