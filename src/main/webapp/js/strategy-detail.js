$().ready(function() {
	getUser();   //获取用户是否登录的信息
	getQuestionText();     //获取当前问题的详细内容
	getQuestionAnswer(1);  //获取该问题的所有回答的列表的第一页
});

// 发起请求，判断当前用户是否登录
function getUser(argument) {
	$.ajax({
		// url: 'data/isLogin.json',
		url: 'http://localhost:8080/travel/user/isLogin',
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
		// console.log("complete");
	});
	
}

var loginTag;//作为一个标记，保存用户是否已登录的信息
var userId; //记录userId
// 对后台返回的用户登录信息进行处理
function dealingUserData(data) {
	if(data.isLogin == false){
		var login = "<li><a href='http://localhost:8080/travel/login.jsp'><i class='fa fa-meh-o'> </i>登录</a></li>";
		var register = "<li><a target='_blank' href='http://localhost:8080/travel/register.jsp'><i class='fa fa-plus'> </i>注册</a></li>";
		$('#top-menu').append(login+register);
	}else{
		var personal = "<li><a href='personal.jsp'><i class='fa fa-meh-o'> </i>"+data.content.name+"</a></li>";
		personal += "<li id='logout'><a href=''><i class='fa fa-sign-out'> </i>注销</a></li>";
		$('#top-menu').append(personal);
		userId = data.content.id;
	}
	loginTag = data.isLogin; //记录用户的当前状态，用于判断是否已登录
	$('#logout').click(function(event) {
		$.ajax({
			url: 'http://localhost:8080/travel/user/logout',
			type: 'post',
			dataType: 'json',
		})
		.done(function(data) {
			// 后端跳转页面
		})
		.fail(function() {
			alert("注销出错");
		})
		.always(function() {
			// console.log("complete");
		});
		
	});
}

//获取json文件，即特色定制的问题详细内容，并插入页面
function getQuestionText() {
	//将文章id异步传到后台，进行相关处理后，返回对应的文章
	$.ajax({
		// url: 'data/questionDetail.json',
		url: 'http://localhost:8080/travel/question/getDetail',
		type: 'get',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			questionID: parseInt(getUrlQuestionId('questionId'))
		}),
	})
	.done(function(data) {
		$("#userPic").append("<img src='"+data.questionPersonPicture+"''>");
		$("#userPic").parent().append("<span class='name'>"+data.questionPersonName+"</span>");
		$("#userPic").parent().append("<span class='time'>"+data.questionTime+"</span>");
		// 插入问题具体信息
		$("#question-text").append("<h3><img src='images/strategy_r.png'>"+data.questionHeader+"</h3><h4>"+data.questionContent+"</h4>");
		$("#question-text").next().append("<span class='num'>"+data.questionAnswerCount+"</span>");
		if(data.questionStatus == true){
			var answer = "<p class='accept'><img src='images/accept.png' alt='接纳的图标'>已解决<span class='answerTime'>"+data.questionAnswerTime+"</span></p>";
			answer += "<p class='answer'><a href='"+data.questionAnswerPersonURL+"'>"+data.questionAnswerPersonName+":</a><span>"+data.questionAnswerContent+"</span></p>";
			$("#question-text").append(answer);
		}
	})
}

//获取url中的参数
function getUrlQuestionId(name) {
   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
   var r = window.location.search.substr(1).match(reg);  //匹配目标参数
   if (r != null) return unescape(r[2]); return null; //返回参数值,即questionId的值
}

//获取问题对应的提问回答部分
page = 1;  //记录当前评论所在的页号
function getQuestionAnswer(nowPage) {
	$.ajax({
			// url: 'data/questionComment.json',
			url: 'http://localhost:8080/travel/answer/show',
			type: 'get',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
				questionID : parseInt(getUrlQuestionId('questionId')),
				pageIndex : nowPage,
				showLimit : 5
			}),
	})
	.done(function(data) {
		$("#comments").children().remove();
		if(data.content.length > 0){
			$.each(data.content, function(index, val) {
				var user ="<div class='head-img'><div class='img-bg'><img src='"+val.commentUserPic+"'></div><span class='name'>"+val.commentUser+"</span></div>"; 
				var question = "<div class='question-text'><p>"+val.commentContent+"</p><p class='time'>"+val.commentTime+"</p></div>";
				$("#comments").append("<li>"+user+question+"</li>");
			});
			if(data.content.length > 5){
				$('#pageButton').remove();  
				var button = "<p id='pageButton'><span id='lastPage'>上一页</span><span id='nextPage'>下一页</span><p>";
				$("#comments").append(button);
				// 给按钮绑定时间
				$('#pageButton').find('span').click(function(event) {
					if($(this).is('#lastPage')){
						if(page >1){
							page = page - 1;
							getQuestionAnswer(page);
						}
					}else{
						// if(page < sumPage){
							page = page + 1;
							getQuestionAnswer(page);
						// }
					}
				});
			}
		}else{
			$("#comments").append("<p class='notComment'>暂时没有评论</p>");
		}
	})
	.fail(function() {
		alert("获取评论出错");
	})
	.always(function() {
		// console.log("complete");
	});
}


//判断用户是否已经登录，已登录则允许评论
$('#strategy-text').focus(function(event) {
	if(loginTag == false){
		location.href="http://localhost:8080/travel/login.jsp";
	}		
});

// 发表攻略后，进行提交
$("#offer").click(function() {
	if($("#strategy-text").val() == ''){
		alert("请先输入评论内容再提交");
	}else{
		$.ajax({
			url: 'http://localhost:8080/travel/answer/add',
			type: 'get',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
				context : $("#strategy-text").val(),   //将对应评论的内容传过去
				userID : userId,          //将进行评论的用户的id传过去
				questionID : parseInt(getUrlQuestionId('questionId'))
			}),
		})
		.done(function(data) {
			if(data.answerResult == true){
				alert("评论完成");
			}else{
				alert("评论出错");
			}
		})
		.fail(function() {
			alert("评论出错");
		})
		.always(function() {
			// console.log("complete");
		});
		
	}
});
