$().ready(function() {
	getUser();   //获取用户是否登录的信息
	getStrategy(1);
});


// 发起请求，判断当前用户是否登录
function getUser(argument) {
	$.ajax({
//		url: 'data/isLogin.json',
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

// 对后台返回的用户登录信息进行处理
function dealingUserData(data) {
	if(data.isLogin == false){
		var login = "<li><a href='http://localhost:8080/travel/login.jsp'><i class='fa fa-meh-o'> </i>登录</a></li>";
		var register = "<li><a target='_blank' href='http://localhost:8080/travel/register.jsp'><i class='fa fa-plus'> </i>注册</a></li>";
		$('#top-menu').append(login+register);
	}else{
		var personal;
		if(data.content.userRole==1){
			personal = "<li><a href='adminPersonal.jsp'><i class='fa fa-meh-o'> </i>"+data.content.name+"</a></li>";
		}else{
		    personal = "<li><a href='personal.jsp'><i class='fa fa-meh-o'> </i>"+data.content.name+"</a></li>";
		}
		personal += "<li id='logout'><a href='http://localhost:8080/travel/user/logout'><i class='fa fa-sign-out'> </i>注销</a></li>";
		$('#top-menu').append(personal);
	}
	$('#logout').click(function(event) {
		$.ajax({
			url: 'http://localhost:8080/travel/user/logout',
			type: 'post',
			dataType: 'json',
			contentType:'application/json'
		})
		.done(function(data) {
			// 后端跳转页面
		})
		.fail(function() {
			console.log("error");
		})
		.always(function() {
			// console.log("complete");
		});
		
	});
}

// 页面加载后进行异步请求数据
function getStrategy(pageIndex) {
	$.ajax({
//		url: 'data/strategy.json',
		url: 'http://localhost:8080/travel/question/show',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"pageIndex":pageIndex,
			"showLimit":7,
		}),
	})
	.done(function(data) {
		dealingData(data);
	})
	.fail(function() {
		console.log("网页出错");
	})
	.always(function() {
		// console.log("资料加载完成");
	});
}

// 对请求返回的数据进行处理
nowPage = 1; //定义一个全局变量保存当前页面数
function dealingData(data) {
	$("#questionText").children().remove();  //移除上一次的请求的页面
	$.each(data.content, function(index, val) {
		var user = "<div class='head-img'><div class='img-bg'><img src='"+val.questionPersonPicture+"'></div><p>"+val.questionPersonName+"</p><span class='time'>"+val.questionTime+"</span></div>";
		var text = "<div class='question-text'><h3><img src='images/strategy_r.png'>"+val.questionHeader+"</h3><h4>"+val.questionContent+"</h4></div>";
		if(val.questionStatus == true){   //为true时表示已经采纳，否则未采纳
			var num = "<div class='comments-num'><div class='num adopted'><h4>已采纳</h4><h1>"+val.questionAnswerCount+"</h1></div></div>";
		}else{
			var num = "<div class='comments-num'><div class='num'><h4>评论数</h4><h1>"+val.questionAnswerCount+"</h1></div></div>";
		}
		var content = "<li class='row'><a href='strategy-detail.jsp?questionId="+val.questionID+"' class='col-md-offset-1 col-md-10 question'>"+user+text+num+"</a></li>";
		$("#questionText").append(content);
	});
	// 修改切换页面的按钮
	$('#switchPage').children().remove();  //移除原来的按钮
	// 首先判断是否插入上一页按钮
		var pageText = '';  //用于保存插入按钮的相关html
		if(nowPage != 1){
			pageText += "<span class='page' id='lastPage'>上一页</span>";
		}
		// 插入当前选中的按钮
		pageText += "<span class='page' id='nowPage'>"+parseInt(nowPage)+"</span>";
		for(var i = nowPage+1;i < (nowPage+3);i++){
			if(i<data.pageNumber){
				pageText += "<span class='page'>"+parseInt(i)+"</span>";
			}else{
				break;
			}
		}
		if(nowPage != (data.pageNumber - 1) && nowPage != data.pageNumber){
			pageText += "<span class='page' id='morePage'>...</span><span class='page'>"+parseInt(data.pageNumber)+"</span>";
		}else{
			if(nowPage != data.pageNumber){
				pageText += "<span class='page'>"+parseInt(data.pageNumber)+"</span>";
			}
		}
		if(nowPage != data.pageNumber){
		pageText += "<span class='page' id='nextPage'>下一页</span>";
		}
		$("#switchPage").append(pageText);
		//给页面按钮绑定事件
		/*以下为分页按钮切换内容*/
		$('#switchPage').find('.page').click(function(event) {
			var clickPage = nowPage;
			// 判断选中的分页按钮是哪个
			if($(this).is('#lastPage')){        // 点击上一页
				clickPage = nowPage - 1;
			}
			else if($(this).is('#nextPage')){   //点击下一页
				clickPage = nowPage + 1;
			}
			else if($(this).is('#morePage')){   //点击更多页
				if((nowPage + 3)<data.pageNumber){
					clickPage = nowPage + 3;
				}else{
					clickPage = nowPage + 1;
				}
			}
			else if($(this).is('#nowPage')){ //点击当前选中页
				clickPage = nowPage;
			}
			else{  
				clickPage = parseInt($(this).text());  //获取该页的数值
			}
			nowPage = clickPage;   //保存当前点击的页面
			getStrategy(nowPage);	//获取点击页面的数据
		});
}
