$().ready(function() {
	getUser();  //获取用户信息
});

// 发起请求，判断当前用户是否登录
var isLogin; //记录用户的登录状态
function getUser(argument) {
	$.ajax({
		// url: 'data/isLogin.jso	',
		url: 'http://localhost:8080/travel/user/isLogin',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
	})
	.done(function(data) {
		isLogin = data.isLogin;
		dealingUserData(data);
		getEssay();    //获取文章详情
		getComments(1);  //获取该文章的评论
		/*if(data.isLogin == true ){
			dealingUserData(data);
			getEssay();    //获取文章详情
			getComments(1);  //获取该文章的评论
		}else{
			window.location.href = 'http://localhost:8080/travel/login.jsp';
		}*/
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		// console.log("complete");
	});
	
}

// 对后台返回的用户登录信息进行处理
var userRole; //记录登录的用户的的身份
var userId; //记录用户id
function dealingUserData(data) {
	if(data.isLogin == false){
		var login = "<li><a href='http://localhost:8080/travel/login.jsp'><i class='fa fa-meh-o'> </i>登录</a></li>";
		var register = "<li><a target='_blank' href='http://localhost:8080/travel/register.jsp'><i class='fa fa-plus'> </i>注册</a></li>";
		$('#top-menu').append(login+register);
	}else{
		userRole = data.content.userRole;   //1表示为管理员
		userId = data.content.id;
		var personal;
		if(data.content.userRole==1){
			personal = "<li><a href='adminPersonal.jsp'><i class='fa fa-meh-o'> </i>"+data.content.name+"</a></li>";
		}else{
		    personal = "<li><a href='personal.jsp'><i class='fa fa-meh-o'> </i>"+data.content.name+"</a></li>";
		}
//		var personal = "<li><a href='personal.jsp'><i class='fa fa-meh-o'> </i>"+data.content.name+"</a></li>";
		personal += "<li id='logout'><a href='http://localhost:8080/travel/user/logout'><i class='fa fa-sign-out'> </i>注销</a></li>";
		$('#top-menu').append(personal);
	}
}

// 页面加载后进行异步请求文章数据
function getEssay() {
	$.ajax({
		// url: 'data/detail.json',
		url: 'http://localhost:8080/travel/essay/getEssayDetails',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"essayID": getUrlEssayId('essayId')
		}),
	})
	.done(function(data) {
		dealingEssayData(data);
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
}

//获取url中的参数
function getUrlEssayId(name) {
   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
   var r = window.location.search.substr(1).match(reg);  //匹配目标参数
   // alert(r[1]);
   if (r != null) return unescape(r[2]); return null; //返回参数值,即questionId的值
}

// 对请求返回的数据进行处理
function dealingEssayData(data) {
	// 插入文章标题图片
	$('#headerPic').append('<img src="'+data.essayPictureURL+'">');
	// 插入文章作者信息
	$("#authorPicture").append("<img src='"+data.personPictureURL+"'>");
	// $("#authorPicture").parent().append("<span>"+data.eassayPersonName+"</span>");
//	$("#authorPicture").parent().append("<span>么么哒（缺接口）</span>");
	// 插入文章具体信息
	$("#eassayTag").append("<span class='tag'>"+data.country+"</span><span>"+data.time+"</span>");
	// 当文章已进行认证时
	if(data.validate == true){
		$("#eassayTag").append("<span class='tag authen'>已认证</span>")
	}
	$("#eassayContent").append("<h3>"+data.essayHeader+"</h3>"+data.context);
	// 插入评论信息

}

/*以下为评论部分内容*/
// 页面加载后进行异步请求文章评论数据
function getComments(nowPage) {
	$('#comments').find('li').remove();   //移除原来的评论
	$('#getCommentButton').find('label').remove();
	$.ajax({
		// url: 'data/eassayComment.json',
		url: 'http://localhost:8080/travel/comments/essay',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"essayID": getUrlEssayId('essayId'),
			"pageIndex":nowPage,
			"showLimit":5
		}),
	})
	.done(function(data) {
		dealingCommentData(data);
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
}

//处理返回的全部评论信息
var sumPage;  //记录评论的总页数
function dealingCommentData(data) {
	$.each(data.content, function(index, val) {
		var text = "<p><span>"+val.commentPersonName+": </span><span>"+val.commentContext+"</span></p>";
		// 当用户为管理员时
		if(userRole == 1){
			text += "<p class='commentOtherInfo'><span id='commentID'>"+val.commentID+"</span><span class='delete'>删除</span><span class='date'>"+val.commentDate+"<span></p>";
		}else if(userRole == 3){
			// text += "<p class='commentOtherInfo'><span id='commentID'>"+val.commentID+"</span><span class='date'>"+val.commentDate+"<span></p>";
			text += "<p class='commentOtherInfo'><span id='commentID'>"+val.commentID+"</span><span class='tip'>举报</span><span class='date'>"+val.commentDate+"<span></p>";
		}	
		$("#comments").append("<li>"+text+"</li>");
	});
	$('#getCommentButton').append("<label>共"+data.pageNumber+"页</label>");
	sumPage = data.pageNumber;  //记录总页数
	// 给删除键绑定事件
	$('.delete').click(function(event) {
		var commentId = $(this).parents('li').find('#commentID').text();   //获取该评论id号
		deleteComment($(this),commentId); //删除该评论
	});
	// 给举报键绑定举报事件
	$('.tip').click(function(event) {
		var commentId = $(this).parents('li').find('#commentID').text();   //获取该评论id号
		accussComment($(this),commentId);  //举报该评论
	});
	
}

//删除该评论
function deleteComment(obj,commentId) {
	$.ajax({
		// url: 'data/deleteComment.json',
		url: 'http://localhost:8080/travel/manager/comment/delete',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"commentID":commentId
		}),
	})
	.done(function(data) {
		if(data.commentDeleteResult == true){
			obj.parents('li').remove();  //移除这条评论
		}else{
			alert("删除失败");
		}
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
}

// 给页面按钮绑定事件
var nowPage = 1;  //记录当前页号
$('#getCommentButton').find('span').click(function(event) {
	if($(this).is('#next')){
		if(nowPage != sumPage){
			nowPage = nowPage + 1;
		}else{
			nowPage = sumPage;
		}
	}else{
		if(nowPage != 1){
			nowPage = nowPage - 1;
		}else{
			nowPage = 1;
		}
	}
	getComments(nowPage);
});

 //举报该评论
function accussComment(obj,commentId){
	$.ajax({
//		url: 'data/deleteComment.json',
		 url: 'http://localhost:8080/travel/comments/complain',
		type: 'POST',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"commentID":commentId
		}),
	})
	.done(function(data) {
		if(data.complainResult == true){
			alert("举报成功");
//			obj.parents('li').remove();  //移除这条评论
		}else{
			alert("举报失败");
		}
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
}

/*以上为评论部分内容*/

// 评论输入框获得焦点后，触发一下函数
$('#comment-input').focus(function(event) {
	if(isLogin == false){
		$('#comment-input').blur();
		alert("请先登录再进行评论");
		window.location.href = "http://localhost:8080/travel/login.jsp";
	}
});

//点击提交评论按钮
$("#send").click(function() {
	/*			// 获取当前评论时间
				var myDate = new Date();
				//获取当前年
				var year=myDate.getFullYear();
				//获取当前月
				var month=myDate.getMonth()+1;
				//获取当前日
				var date=myDate.getDate(); */
				$.ajax({
					// url: 'data/deleteComment.json',
					url: 'http://localhost:8080/travel/comments/add',
					type: 'post',
					dataType: 'json',
					contentType:'application/json',
					data: JSON.stringify({
						"userID":userId,
						"essayID":getUrlEssayId('essayId'),
						"context": $("#comment-input").val(),
	/*					"time":year+":"+month+":"+date,*/
					}),
				})
				.done(function(data) {
					if(data.commentsResult == true){
						alert("评论成功");
						$('#comment-input').val('');  //设置文本框为空
						getComments(1);
					}else{
						alert("评论失败");
					}
				})
				.fail(function() {
					console.log("error");
				})
				.always(function() {
					console.log("complete");
				});
			});


