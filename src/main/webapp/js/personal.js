$().ready(function() {
	getAuthorData();  //加载用户信息
});

//加载用户信息,并进行插入页面
// 判断用户是否登陆，加载用户id
var userId;
var name;  //保存用户昵称·
var quote; //保存个性签名
var pic;  //保存头像路径
var account;   //保存用户的积分 
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
			account = data.content.account;
			getUserData(userId);
			getEssay(1);    //加载该用户对应已发表的攻略
		}else{
			alert("请先登录");
			windon.location.href="http://localhost:8080/travel/login.jsp";
		}
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		// console.log("complete");
	});
}

// 通过UserId获取该用户更多的信息
function getUserData(id) {
	$.ajax({
		// url: 'data/isLogin.json',
		url: 'http://localhost:8080/travel/user/isLogin',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			condition: id
		}),
	})
	.done(function(data) {
			$("#userPic").append("<img src='"+data.content.pictureURL+"'>");
			$("#userInfo").append("<p class='name'><label>昵称：</label>"+data.content.name+"</p><p class='integral'>积分：<span>"+data.content.account+"</span></p> </p>");
			$("#userInfo").append("<p class='integral'><label>个性签名：</label>"+data.content.quote+"</p>");
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		// console.log("complete");
	});
}


// 对两个功能键进行判断
// 当点击发布的攻略按钮时，触发以下事件
$('#strategy').click(function(event) {
	$('#my-question').removeClass('choose');   //移除.lists中p对应的类choose
	$('#list-content').empty();  //删除id为list-content的元素的所有子节点
	$(this).addClass('choose');     //为当前点击的对象添加类choose
	getEssay(1); //调用该函数，异步请求该用户已发表的攻略
});

// 当点击我的特色定制按钮时，触发以下事件
$('#my-question').click(function(event) {
	$('#strategy').removeClass('choose');   //移除.lists中p对应的类choose
	$('#list-content').empty();  //删除id为list-content的元素的所有子节点
	$(this).addClass('choose');     //为当前点击的对象添加类choose
	getQuestion(1); //调用该函数，异步请求该用户已进行的特色定制
});

/*以下为用户个人攻略文章部分*/
//加载该用户对应已发表的攻略
var nowEssayPage = 1;//用于记录个人文章攻略的页数
function getEssay(nowPage) {
	$.ajax({
		// url: 'data/personalEssay.json',
		url: 'http://localhost:8080/travel/person/essay',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"userID":userId,
			"showLimit":5,
			"pageIndex": nowPage
		}),
	})
	.done(function(data) {
		$("#list-content").children().remove();
		$("#list-content").append("<div class='published contents' id='content'><h4 class='title'>已发布的攻略</h4><div class='custom-made-contents'><ul id='list-bg'></ul></div></div>");
		$.each(data.content, function(index, val) {
			 var link = "<a href='detail.jsp?essayId="+val.essayID+"'>";
			 var text = link+"<div class='content'><h4>"+val.essayHeader+"</h4><p><span class='tag'>"+val.essayCountry+"</span><span>来自 "+val.essayPersonName+"</span></p></div></a>";
			 var other = "<div class='about'><p><span class='delete' id='delete'>删除</span><a target='_blank' href='updateStrategy.jsp?essayId="+val.essayID+"'><span class='edit'>编辑</span></a></p><p>评论数: <span>"+val.commentCount+"</span></p></div>";
			 $("#list-bg").append("<li>"+text+other+"</li>");
		});
		// 当点击删除按钮时，触发删除事件,将要删除的列表的id传回后台
		$('.delete').click(function(event) {
			deleteEssayObj($(this));
		});	
		// 增加按钮
			$('#pageButton').remove();  
			var button = "<p id='pageButton'><span id='firstPage'>首页</span><span id='lastPage'>上一页</span><span id='nextPage'>下一页</span><span id='endPage'>尾页</span>共"+data.pageNumber+"页<p>";
			 $("#list-bg").append(button);
			// 给按钮绑定时间
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

// 删除对应攻略文章的函数
function deleteEssayObj(obj) {
	var id = getId(obj,'essayId'); //获取文章的id
	$.ajax({
		// url: 'data/delete.json',
		url: 'http://localhost:8080/travel/essay/delete',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"userID":userId,
			"essayID":id
		}),
	})
	.done(function(data) {
		// 判断是否删除成功，如若成功则删除对应的文章
		if(data.essayDeleteResult == true){
			obj.parent().parent().parent().remove();
			//重新请求个人文章
			getEssay(1);
		}else{
			alert("删除失败");
		}

	})
	.fail(function(data) {
		alert("删除失败");
	})
	.always(function() {
		// console.log("complete");
	});
}
/*以上为用户个人攻略文章部分*/


/*以下为用户个人提问部分*/
//加载该用户对应已发表的特色定制
var nowQuestionPage = 1;//用于记录个人文章攻略的页数
function getQuestion(nowPage) {
	$.ajax({
		// url: 'data/personalQuestion.json',
		url: 'http://localhost:8080/travel/person/question',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"userID":userId,
			"showLimit":5,
			"pageIndex": nowPage
		}),
	})
	.done(function(data) {
		$("#list-content").children().remove();
		$("#list-content").append("<div class='published contents' id='question'><h4 class='title'>我的特色定制</h4><div class='custom-made-contents'><div id='add' class='add-custom-made' title='新增特色定制'></div><ul id='list-bg'></ul></div></div>");
		$.each(data.content, function(index, val) {
			 var link = "<a href='strategy-detail.jsp?questionId="+val.questionID+"'>";
			 var text=link+"<div class='content'><h4>"+val.questionHeader+"</h4><h5>"+val.questionContent+"</h5></div></a>";
			 var other = "<div class='about'><p><span class='delete' id='delete'>删除</span><a target='_blank' href='updateQuestion.jsp?questionId="+val.questionID+"'><span class='edit'>编辑</span></a></p><p>回答数: <span>"+val.questionAnswerCount+"</span></p><p>"+val.questionTime+"</p></div>";
			 $("#list-bg").append("<li>"+text+other+"</li>");
		});
		// 当点击新增特色定制按钮时，弹出输入遮罩层界面,该代码需放在被处理页面异步加载并渲染完成之后
		$('#add').click(function(event) {
			$('#custom-made-question').show();
		});
		// 当点击遮罩层时，遮罩层隐藏起来
		$('#custom-made-question').click(function(event) {
			$(this).hide();
		});
		// 当点击遮罩层中的表单部分时，遮罩层冒泡事件失效
		$('#form-bg').click(function(event) {
			event.stopPropagation();    
		});

		// 当点击删除按钮时，触发删除事件,将要删除的列表的id传回后台
		$('.delete').click(function(event) {
			deleteQuestionObj($(this));
		});

		/*// 当点击编辑按钮时，跳转到进行特色定制的页面,将要编辑的列表的id传回后台
		$('.edit').click(function(event) {
			editQuestionObj($(this));
		});*/

		// 增加按钮
			$('#pageButton').remove();  
			var button = "<p id='pageButton'><span id='firstPage'>首页</span><span id='lastPage'>上一页</span><span id='nextPage'>下一页</span><span id='endPage'>尾页</span>共"+data.pageNumber+"页<p>";
			 $("#list-bg").append(button);
			// 给按钮绑定时间
			$('#pageButton').find('span').click(function(event) {
				if($(this).is('#lastPage')){
					if(nowQuestionPage >1){
						nowQuestionPage = nowQuestionPage - 1;
					}
				}
				else if($(this).is('#nextPage')){
					if(nowQuestionPage < data.pageNumber){
						nowQuestionPage = nowQuestionPage + 1;
					}
				}
				else if($(this).is('#firstPage')){
					nowQuestionPage = 1;
				}
				else{	
					nowQuestionPage = data.pageNumber;
				}
				getQuestion(nowQuestionPage);
			});
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		// console.log("complete");
	});
}

// 删除对应提问（特色定制）的函数
function deleteQuestionObj(obj) {
	var id = getId(obj,'questionId'); //获取该提问的id
	$.ajax({
		// url: 'data/questionDelete.json',
		url: 'http://localhost:8080/travel/question/delete',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"userID":userId,
			"questionID":id
		}),
	})
	.done(function(data) {
		// 判断是否删除成功，如若成功则删除对应的文章
		if(data.questionDeleteResult == true){
			obj.parent().parent().parent().remove();
			//重新请求特色定制
			getQuestion(1);
		}else{
			alert("删除失败");
		}

	})
	.fail(function(data) {
		alert("删除失败");
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

/*提交问题（特色定制）*/
$('#submitQuestion').click(function(event) {
	//判断积分是否足够用于发布特色定制
	if(account<50){
		alert("你的积分不足50，无权发表特色定制");
		return;
	}
	// 判断每个文本框是否有内容
	if($('#questionTitle').val() == '' || $('#questionContent').val() == ''){
		alert("请将要进行的特色定制的标题和内容均填上");
	}else{
		$.ajax({
			// url: 'data/addQuestionRes.json',
			url: 'http://localhost:8080/travel/question/add',
			type: 'post',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
				"userID":userId,
				"context":$('#questionContent').val(),
				"header":$('#questionTitle').val()
			}),
		})
		.done(function(data) {
			// 判断是否删除成功，如若成功则删除对应的文章
			if(data.questionAddResult == true){
				window.location.href = "http://localhost:8080/travel/personal.jsp";
			/*	$('#custom-made-question').hide();
				getQuestion(1); //加载该用户对应已发表的特色定制
*/			}else{
				alert("发表出错");
			}

		})
		.fail(function(data) {
			alert("发表出错");
		})
		.always(function() {
			// console.log("complete");
		});
	}
});
/*提交问题（特色定制）*/

/*修改个人资料部分*/
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
	$('#username').val(name);
	$('#quote').val(quote);
});

//点击修改按钮时
$('#changeUserData').click(function(event) {
	if($('#username').val() == '' || $('#quote').val() == ''){
		alert("请将表单填写完整再提交");
		return;
	}
	if($('#pic').val() == ''){
		submitForm(pic);   //提交表单
	}else{
		// 上传图片模块
		$.ajaxFileUpload({
				url: 'http://localhost:8080/travel/picture/submit', //用于文件上传的服务器端请求地址
				secureuri: false, //是否需要安全协议，一般设置为false
				fileElementId: 'pic', //文件上传域的ID
				dataType: 'json', //返回值类型 一般设置为json
				contentType:'application/json',
				data: JSON.stringify({
					"picture": $('#pic').attr('name'),
				}),
				success: function (data, status)  //服务器成功响应处理函数
				{
					if(data.saveResult == true){
						submitForm(data.pictureURL);   //提交表单
					}else{
						submitForm(data.pictureURL);   //提交表单
					}
				},
				error: function (data, status, e)//服务器响应失败处理函数
				{
					alert("图片上传失败，表单无法成功提交");
				}
			});
	}
});

function submitForm(pic) {
	// 将数据传到后台
	$.ajax({
			url: 'http://localhost:8080/travel/user/updatePersonMessage',
			type: 'post',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
				"userId":userId,
				"name": $('#username').val(),
				"quote":$('#quote').val(),
				"pictureURL": pic
			}),
		})
		.done(function(data) {
			// 判断是否修改成功
			if(data.updateResult == true){
				alert('修改成功');
				window.location.href = "http://localhost:8080/travel/personal.jsp";
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

/*点击注销按钮，触发注销事件*/
/*$('#logout').click(function(event) {
	$.ajax({
			url: 'http://localhost:8080/travel/user/logout',
			type: 'post',
			dataType: 'json',
			contentType:'application/json',
		})
		.done(function(data) {
			// 页面后端跳转
		})
		.fail(function(data) {
			alert("注销失败");
		})
		.always(function() {
			// console.log("complete");
		});
});*/
/*点击注销按钮，触发注销事件*/
