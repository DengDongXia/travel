$().ready(function() {
	getUser();   //获取用户是否登录的信息
	getStrategy();
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

// 页面加载后进行异步请求数据
function getStrategy(argument) {
	$.getJSON('data/strategy.json',function(data) {
		dealingData(data);
	});
	// $.getJSON('question/show.json',function(data) {
	// 	dealingData(data);
	// });
}

// 对请求返回的数据进行处理
function dealingData(data) {
	$.each(data, function(index, val) {
		var user = "<div class='head-img'><div class='img-bg'><img src='"+val.questionPersonPicture+"'></div><p>"+val.questionPersonName+"</p><span class='time'>"+val.questionTime+"</span></div>";
		var text = "<div class='question-text'><h3><img src='images/strategy_r.png'>"+val.questionHeader+"</h3><h4>"+val.quesionContent+"</h4></div>";
		if(val.questionStatus == 'true'){   //为true时表示已经采纳，否则未采纳
			var num = "<div class='comments-num'><div class='num adopted'><h4>已采纳</h4><h1>"+val.questionAnswerCount+"</h1></div></div>";
		}else{
			var num = "<div class='comments-num'><div class='num'><h4>评论数</h4><h1>"+val.questionAnswerCount+"</h1></div></div>";
		}
		var content = "<li class='row'><a href='strategy-detail.html?questionId="+val.questionId+"' class='col-md-offset-1 col-md-10 question'>"+user+text+num+"</a></li>";
		$("#questionText").append(content);
	});
}
