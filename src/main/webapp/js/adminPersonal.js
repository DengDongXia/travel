$().ready(function() {
	getAuthorData();  //加载用户信息
});

//加载用户信息,并进行插入页面
// 判断用户是否登陆，加载用户id
var userId;
var name;  //保存用户昵称·
var quote; //保存个性签名
var pic;  //保存头像路径
var email; //保存邮箱
function getAuthorData() {
	$.ajax({
		// url: 'data/isLogin.json',
		url: 'http://localhost:8080/travel/user/isLogin',
		type: 'post',
		dataType: 'json',
	})
	.done(function(data) {
		if(data.isLogin == true){
			userId = data.content.id;  //获取当前用户的id
			name = data.content.name;
			quote = data.content.quote;
			pic = data.content.pictureURL;
			email = data.content.email;
			$("#userPic").append("<img src='"+data.content.pictureURL+"'>");
			var messages="<p class='name'><label>昵称：</label>"+data.content.name+"</p>";
			/*if(data.content.account !=null)
				messages+="<p class='integral'><label>积分：</label><span>"+data.content.account+"</span></p>";*/
			$("#userInfo").append(messages);
			$("#userInfo").append("<p class='integral'><label>个性签名：</label>"+data.content.quote+"</p>");
			getEssay(1);    //加载该用户对应已发表的攻略
		}
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		// console.log("complete");
	});
}

/*// 对两个功能键进行判断
// 当点击文章管理按钮时，触发以下事件
$('#strategy').click(function(event) {
	$('#my-question').removeClass('choose');   //移除.lists中p对应的类choose
	$('#list-content').empty();  //删除id为list-content的元素的所有子节点
	$(this).addClass('choose');     //为当前点击的对象添加类choose
	getEssay(1); //调用该函数，异步请求该用户已发表的攻略
});

// 当点击用户管理按钮时，触发以下事件
$('#my-question').click(function(event) {
	$('#strategy').removeClass('choose');   //移除.lists中p对应的类choose
	$('#list-content').empty();  //删除id为list-content的元素的所有子节点
	$(this).addClass('choose');     //为当前点击的对象添加类choose
	getQuestion(); //调用该函数，查询对应的用户
});*/

/*对三个功能按钮进行修改*/
$('#lists').find('p').click(function(event) {
	if($(this).is('#strategy')){
		$('#lists').find('p').removeClass('choose');   //移除.lists中p对应的类choose
		$('#list-content').empty();  //删除id为list-content的元素的所有子节点
		$(this).addClass('choose');     //为当前点击的对象添加类choose
		getEssay(1); //调用该函数，异步请求该用户已发表的攻略
	}else if($(this).is('#my-question')){
		$('#lists').find('p').removeClass('choose');   //移除.lists中p对应的类choose
		$('#list-content').empty();  //删除id为list-content的元素的所有子节点
		$(this).addClass('choose');     //为当前点击的对象添加类choose
		getQuestion(); //调用该函数，查询对应的用户
	}else{
		$('#lists').find('p').removeClass('choose');   //移除.lists中p对应的类choose
		$('#list-content').empty();  //删除id为list-content的元素的所有子节点
		$(this).addClass('choose');     //为当前点击的对象添加类choose
		getComment(1); //调用该函数，异步请求所有举报的评论
	}
});
/*对三个功能按钮进行修改*/


/*以下为加载文章管理部分*/
//加载文章管理
var nowEssayPage = 1;//用于记录文章的页数
function getEssay(nowPage) {
	$.ajax({
		// url: 'data/personalEssay.json',
		url: 'http://localhost:8080/travel/manager/essay/search',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"showLimit":5,
			"pageIndex": nowPage,
			"condition": null
		}),
	})
	.done(function(data) {
		$("#list-content").children().remove();
		$("#list-content").append("<div class='published contents' id='content'><h4 class='title'>已发布的攻略</h4><div class='custom-made-contents'><ul id='list-bg'></ul></div></div>");
		$.each(data.content, function(index, val) {
			 var link = "<a href='detail.jsp?essayId="+val.eassyID+"'>";
			 var text = link+"<div class='content'><h4>"+val.eassyHeader+"</h4><p><span class='tag'>"+val.eassyCountry+"</span><span>来自 "+val.eassyPersonName+"</span></p></div></a>";
			 var other = "<div class='about'><p><span class='delete audit' id='noPass'>不通过</span><span class='audit' id='pass'>审核通过</span></p>";
			 	other += "<p><label class='authen'><input type='checkbox'> 已得到旅游认证</label></p><p>评论数: <span>"+val.eassyCommentCount+"</span></p></div>";
			 $("#list-bg").append("<li>"+text+other+"</li>");
		});
		/*// 当点击删除按钮时，触发删除事件,将要删除的列表的id传回后台
		$('.delete').click(function(event) {
			deleteEssayObj($(this));
		});*/	
		$('.audit').click(function(event) {
			// 当点击通过按钮时
			if($(this).is('#pass')){
				 auditEssayObj($(this),true);
			}else{
				 auditEssayObj($(this),false);
			}
		});
		
		// 增加按钮
		$('#pageButton').remove();  
		var button = "<p id='pageButton'><span id='firstPage'>首页</span><span id='lastPage'>上一页</span><span id='nextPage'>下一页</span><span id='endPage'>尾页</span>共"+data.pageNumber+"页<p>";
		 $("#list-bg").append(button);
		// 给按钮绑定事件
		$('#pageButton').find('span').click(function(event) {
			if($(this).is('#lastPage')){
				if(nowEssayPage >1){
					nowEssayPage = nowEssayPage - 1;
				}
			}
			else if($(this).is('#nextPage')){
				if(nowEssayPage < data.pageNumber){
					nowEssayPage = nowEssayPage + 1;
				}
			}
			else if($(this).is('#firstPage')){
				nowEssayPage = 1;
			}
			else{
				nowEssayPage = data.pageNumber;
			}
			getEssay(nowEssayPage);
		});
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		// console.log("complete");
	});
}

//审核对应攻略文章的函数
function auditEssayObj(obj,status) {
	var id = getId(obj,'essayId'); //获取文章的id

	var validateObj = $(obj).parents('.about').find("input[type='checkbox']");  //获取认证状态的对象
	var validate = validateObj.is(':checked');
	$.ajax({
		// url: 'data/auditEssay.json',
		url: 'http://localhost:8080/travel/manager/essay/update',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"state":status,
			"validate":validate,
			"id":id
		}),
	})
	.done(function(data) {
		// 判断是否删除成功，如若成功则删除对应的文章
		if(data.essayUpdateResult == true){
			obj.parents('li').remove();
		}else{
			alert("审核失败");
		}

	})
	.fail(function(data) {
		alert("审核失败");
	})
	.always(function() {
		// console.log("complete");
	});
}
/*以上为用户个人攻略文章部分*/


/*以下为用户管理部分*/
//加载该用户管理部分
var nowQuestionPage = 1;//用于记录用户的页数
function getQuestion() {
	$("#list-content").children().remove();
		$("#list-content").append("<div class='published contents' id='question'><h4 class='title'>我的特色定制</h4><div class='custom-made-contents'><p><input type='type' id='condition' placeholder='请输入要搜素的用户的编号或名称'><span id='searchUser'>确定<span></p><ul id='user-info-bg'></ul></div></div>");
		$('#user-info-bg').append("<li class='info-title'><span class='number'>编号</span><span class='user-pic'>头像</span><span class='user-name'>昵称</span><span class='user-status'>状态</span><span class='mark'>积分</span><span class='func'>操作</span></li>");
		// 给搜索框绑定事件
		$('#searchUser').click(function(event) {
			search();   //查找用户
		});
}

// 查找对应的用户
function search() {
	$.ajax({
		// url: 'data/searchUser.json',
		url: 'http://localhost:8080/travel/manager/user/seacher',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"condition": $('#condition').val()
		}),
	})
	.done(function(data) {
		$("#user-info-bg").children().remove();
		$('#user-info-bg').append("<li class='info-title'><span class='number'>编号</span><span class='user-pic'>头像</span><span class='user-name'>昵称</span><span class='user-status'>状态</span><span class='mark'>积分</span><span class='func'>操作</span></li>");
		if(data.live == false){
			$("#user-info-bg").append("<li style='text-align:center;'>暂时没有查到数据</li>");
			return;
		}
		var text = "<span class='number'>"+data.userID+"</span><span class='user-pic'><div class='img-bg' id='userPic'><img src='"+data.userPicture+"'></div></span>";
		    text += "<span class='user-name'>"+data.userName+"</span>";
		    if(data.userStatus == true){
		    	text += "<span class='user-status'>冻结</span>";
		    }else{
		    	text += "<span class='user-status'>正常</span>";
		    }
		    text += "<span class='mark'>"+data.userAccount+"</span><span class='func'>";
		    if(data.userStatus == true){
		    	text += "<label id='chageStatus'>解冻账号</label>";
		    }else{
		    	text += "<label id='chageStatus'>冻结账号</label>";
		    }
			text += "<label id='clear'>积分清零</label></span>";
		$("#user-info-bg").append("<li>"+text+"</li>");
		// 给操作的两个按钮绑定事件
		$('#chageStatus').click(function(event) {
			changeInfo(data,!data.userStatus,data.userAccount);    //改变用户的状态
		});
		$('#clear').click(function(event) {
			changeInfo(data,data.userStatus,0); //积分进行清零
		});
	})
	.fail(function(data) {
		alert("查找出错");
	})
	.always(function() {
		// console.log("complete");
	});
}

// 改变用户信息
function changeInfo(obj,status,clear) {
	$.ajax({
		// url: 'data/auditUserInfo.json',
		url: 'http://localhost:8080/travel/manager/user/update',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"userID":obj.userID,
			"userName":obj.userName,
			"userStatus":status,
			"userAccount":clear,
			"userPicture":obj.userPicture
		}),
	})
	.done(function(data) {
		// 判断是否删除成功，如若成功则删除对应的文章
		if(data.userUpdateResult == true){
			getQuestion();  //重新加载界面
		}else{
			alert("更新出错");
		}

	})
	.fail(function(data) {
		alert("操作出错");
	})
	.always(function() {
		// console.log("complete");
	});
}

// 获取要跳转的地址对应的列表的文章id
function getId(obj,name) {
	var link = obj.parent().parent().parent().find('a').prop('href');  //获取要跳转的地址
	var items = link.split('?');     //将地址从?进行分开
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = items[1].match(reg);  //匹配目标参数
    var id = r[2];      //对应的id值  
    return id;
}


/*以下为加载被举报评论部分管理部分*/
var nowCommentPage = 1;//用于记录页数
function getComment(nowPage) {
	$.ajax({
		//url: 'data/getAccuseComment.json',
		url: 'http://localhost:8080/travel/manager/comment/search',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"showLimit":5,
			"pageIndex": nowPage,
//			"condition": null
		}),
	})
	.done(function(data) {
		$("#list-content").children().remove();
		$("#list-content").append("<div class='published contents' id='content'><h4 class='title'>被举报的评论</h4><div class='custom-made-contents'><ul id='list-bg'></ul></div></div>");
		$.each(data.content, function(index, val) {
			 var link = "<a href='detail.jsp?essayId="+val.essayID+"' id='managerContext'>";
			 var text = link+"<div class='content'><h4>"+val.essayHeader+"</h4></a>";
			 	 text += "<p value='"+val.commentId+"' id='managerComment'>评论内容："+val.commentContext+"</p>";
			 	 text += "</div>";
			 var other = "<div class='about'><p><span class='delete auditComment ' id='noPass'>删除评论</span><span class='auditComment' id='pass'>保留评论</span></p>";
//			 	other += "<br><p><span class='tag'>"+val.time+"</span></p></div>";
			 $("#list-bg").append("<li>"+text+other+"</li>");
		});
		$('.auditComment').click(function(event) {
			// 当点击通过按钮时
			var commentId = $(this).parents('li').find('#managerComment').attr("value");  //获取该评论的id
			if($(this).is('#pass')){
				 changeComment($(this),commentId);      //评论回复为未被举报
			}else{
				 deleteComment($(this),commentId);
			}
		});
		
		// 增加按钮
		$('#pageButton').remove();  
		var button = "<p id='pageButton'><span id='firstPage'>首页</span><span id='lastPage'>上一页</span><span id='nextPage'>下一页</span><span id='endPage'>尾页</span>共"+data.pageNumber+"页<p>";
		 $("#list-bg").append(button);
		// 给按钮绑定事件
		$('#pageButton').find('span').click(function(event) {
			if($(this).is('#lastPage')){
				if(nowCommentPage >1){
					nowCommentPage = nowCommentPage - 1;
				}
			}
			else if($(this).is('#nextPage')){
				if(nowCommentPage < data.pageNumber){
					nowCommentPage = nowCommentPage + 1;
				}
			}
			else if($(this).is('#firstPage')){
				nowCommentPage = 1;
			}
			else{
				nowCommentPage = data.pageNumber;
			}
			getComment(nowCommentPage);
		});
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		// console.log("complete");
	});
}

//删除该评论
function deleteComment(obj,commentId) {
	$.ajax({
//		url: 'data/deleteComment.json',
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
		alert("删除出错");
	})
	.always(function() {
		// console.log("complete");
	});
}

// 恢复评论为正常
function changeComment(obj,commentId) {
	$.ajax({
		// url: 'data/deleteComment.json',
		url: 'http://localhost:8080/travel/manager/comment/correct',
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
			alert("操作失败");
		}
	})
	.fail(function() {
		alert("操作出错");
	})
	.always(function() {
		// console.log("complete");
	});
}

/*以下为加载被举报评论部分管理部分*/

/*修改管理员资料部分*/
// 当点击新增特色定制按钮时，弹出输入遮罩层界面,该代码需放在被处理页面异步加载并渲染完成之后
$('#changeData').click(function(event) {
	$('#changDataBg').show();
});
// 当点击遮罩层时，遮罩层隐藏起来
$('#changDataBg').click(function(event) {
	$(this).hide();
});
// 当点击遮罩层中的表单部分时，遮罩层冒泡事件失效
$('#changeData-bg').click(function(event) {
	event.stopPropagation();    
});

// 点击修改资料按钮时
$('#changeData').click(function(event) {
	//获取用户的资料，并填写到表单中
	$('#email').val(email);
	$('#username').val(name);
	$('#chageQuote').val(quote);
});

//点击修改按钮时，即提交修改的资料时
$('#changeUserData').click(function(event) {
	if($('#email').val() == ''  || $('#username').val() == '' || $('#chageQuote').val() == ''){
		alert("请将表单填写完整再提交");
		return;
	}else{
		if($('#chageUserPic').val() == ''){
			submitForm(pic);   //提交表单
		}else{
			// 上传图片模块
			$.ajaxFileUpload({
					url: 'http://localhost:8080/travel/picture/submit', //用于文件上传的服务器端请求地址
					secureuri: false, //是否需要安全协议，一般设置为false
					fileElementId: 'chageUserPic', //文件上传域的ID
					dataType: 'json', //返回值类型 一般设置为json
					contentType:'application/json',
					data: JSON.stringify({
						"picture": $('#userPic').attr('name'),
					}),
					success: function (data, status)  //服务器成功响应处理函数
					{
						if(data.saveResult == true){
							submitForm(data.pictureURL);   //提交表单
						}else{
							submitForm(pic);   //提交表单
						}
					},
					error: function (data, status, e)//服务器响应失败处理函数
					{
						alert("图片上传失败，表单无法成功提交");
					}
				});
		}
	}
});

// 修改数据传到后台
function submitForm(path) {
	// 将数据传到后台
	$.ajax({
			url: 'http://localhost:8080/travel/manager/update',
			type: 'post',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
				"managerID":userId,
				"email":$('#email').val(),
				"name": $('#username').val(),
				"quote":$('#chageQuote').val(),
				"pictureURL": path
			}),
		})
		.done(function(data) {
			// 判断是否修改成功
			if(data.managerUpdateResult == true){
				alert('修改成功');
				window.location.href = "http://localhost:8080/travel/adminPersonal.jsp";
			}else{
				alert("修改失败");
			}

		})
		.fail(function(data) {
			alert("修改出错");
		})
		.always(function() {
			// console.log("complete");
		});

}
/*修改个人资料部分*/

