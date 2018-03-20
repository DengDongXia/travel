$().ready(function() {
	getAuthorData();  //加载用户信息
});

//加载用户信息,并进行插入页面
// 判断用户是否登陆，加载用户id,并判断用户是否是超级管理员
function getAuthorData() {
	$.ajax({
		// url: 'data/isLogin.json',
		url: 'http://localhost:8080/travel/user/isLogin',
		type: 'post',
		dataType: 'json',
	})
	.done(function(data) {
		if(data.isLogin != true){
			window.location.href = 'http://localhost:8080/travel/login.jsp';
		}else{
			if(data.content.userRole != 2){
				window.location.href = 'http://localhost:8080/travel/login.jsp';
			}else{
				search(1,''); //获取所有用户
			}
		}
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		// console.log("complete");
	});
}

/*以下为查询管理员部分*/
// 给搜索框绑定事件
$('#searchUser').click(function(event) {
	search(1,$('#condition').val());   //查找用户
});

// 查找对应的管理员
var nowEssayPage = 1;//用于记录的页数
function search(nowPage,condition) {
	$('#user-info-bg').children().remove();
	$.ajax({
		// url: 'data/managerInfos.json',
		url: 'http://localhost:8080/travel/manager/superManager/show',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"pageIndex":nowPage,
			"limit":5,
			"condition":condition
		}),
	})
	.done(function(data) {
		$.each(data.content, function(index, val) {
			var text = "<span class='number'>"+val.managerID+"</span><span class='user-pic'><div class='img-bg' id='userPic'><img src='"+val.managerPicture+"'></div></span>";
		    text += "<span class='user-name'>"+val.managerName+"</span>";
		    if(val.managerStatus == false){
		    	text += "<span class='user-status'>正常</span>";
		    }else{
		    	text += "<span class='user-status'>冻结</span>";
		    }
		    text += "<span class='func'><label id='chageStatus' class='deleteManager'>删除</label></span>";
			$("#user-info-bg").append("<li>"+text+"</li>");
		});
		//为删除按钮绑定事件
		deleteManager();
		addButton(data);  //添加按钮
	})
	.fail(function(data) {
		alert("查找出错");
	})
	.always(function() {
		// console.log("complete");
	});
}

//删除管理员
function deleteManager(){
	$('.deleteManager').click(function(event) {
		var managerId = $(this).parents('li').find('.number').text();//获取管理员id
		var that = $(this);
		$.ajax({
			url: 'http://localhost:8080/travel/manager/superManager/deleteManager',
			type: 'post',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
				"managerId":managerId
			}),
		})
		.done(function(data) {
			// 判断是否删除成功
			if(data.deleteResult == true){
				that.parents("li").remove();   //移除该行
			}else{
				alert("删除失败");
			}
		})
		.fail(function(data) {
			alert("删除出错");
		})
		.always(function() {
			// console.log("complete");
		});
	});
}

//添加按钮
function addButton(data) {
	// 添加按钮
	$('#pageButton').remove();  
	var button = "<p id='pageButton'><span id='firstPage'>首页</span><span id='lastPage'>上一页</span><span id='nextPage'>下一页</span><span id='endPage'>尾页</span>共"+data.pageNumber+"页<p>";
	$("#user-info-bg").append(button);
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
		search(nowEssayPage,$('#condition').val());
	});
}


/*增加管理员部分*/
// 当点击新增管理员按钮时，弹出输入遮罩层界面,该代码需放在被处理页面异步加载并渲染完成之后
$('#my-question').click(function(event) {
	$('#changDataBg').show();
});
// 当点击遮罩层时，遮罩层隐藏起来
$('#changDataBg').click(function(event) {
	$(this).hide();
});
// 当点击遮罩层中的表单部分时，遮罩层冒泡事件失效
$('#changDataForm').click(function(event) {
	event.stopPropagation();    
});

//点击修改按钮时，即提交修改的资料时
$('#add').click(function(event) {
	if($('#input-email').val() == ''  || $('#input-username').val() == '' || $('#input-password').val() == ''){
		alert("请将表单填写完整再提交");
		return;
	}else{
		var emailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;  //邮箱匹配的正则表达式
		if(!emailReg.test($('#input-email').val())){
			alert("请输入正确的邮箱");
			return;
		}
		submitForm();   //提交表单
	}
});

// 修改数据传到后台
function submitForm() {
	// 将数据传到后台
	$.ajax({
			url: 'http://localhost:8080/travel/manager/superManager/addManager',
			type: 'post',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
				"email":$('#input-email').val(),
				"name":$('#input-username').val(),
				"password":$('#input-password').val(),
				"quote":$('#input-quote').val()
			}),
		})
		.done(function(data) {
			// 判断是否修改成功
			if(data.addManagerResult == true){
				alert('添加成功');
				window.location.href = "http://localhost:8080/travel/mainAdminPersonal.jsp";
			}else{
				alert("添加失败，原因："+data.falseResult);
			}

		})
		.fail(function(data) {
			alert("添加出错");
		})
		.always(function() {
			// console.log("complete");
		});

}
/*添加管理员部分*/

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
