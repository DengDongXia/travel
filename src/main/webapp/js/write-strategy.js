$().ready(function() {
	getUser();   //获取用户是否登录的信息
	startEdit();  //设置iframe为可编辑的函数
});

// 发起请求，判断当前用户是否登录
var isLogin; //记录用户的登录状态
function getUser() {
	$.ajax({
		// url: 'data/isLogin.json',
		url: 'http://localhost:8080/travel/user/isLogin',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
	})
	.done(function(data) {
		isLogin = data.isLogin;
		if(data.isLogin == true ){
			dealingUserData(data);
		}else{
			window.location.href = 'http://localhost:8080/travel/login.jsp';
		}
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
		var personal = "<li><a href='personal.jsp'><i class='fa fa-meh-o'> </i>"+data.content.name+"</a></li>";
		personal += "<li id='logout'><a href=''><i class='fa fa-sign-out'> </i>注销</a></li>";
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

// 令iframe为可编辑
var editor = document.getElementById("input-iframe");
function startEdit(){
        // var editor = $("#input-iframe");  //此语句不起效，不知为何
        editor.contentWindow.document.designMode = "on";
        $(document).change(function(event) {
			var editorText = editor.contentWindow.document.body.innerHTML;
		    $("#input-area").text(editorText);
		});

}

/*点击上传照片按钮时*/
$('#submitPic').click(function(event) {
	 $('#pic').click();
	 $('#pic').change(function(event) {
 		// 上传图片模块
		$.ajaxFileUpload({
			// url: 'data/picture.json',
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
					setPic(data.pictureURL);
				}else{
					alert("上传出错");
				}
			},
			error: function (data, status, e)//服务器响应失败处理函数
			{
				alert("图片上传失败");
			}
		});
	 });
});

//将服务器返回的图片插入文本框
function setPic(pic) {
	editor.contentWindow.document.body.innerHTML += "<img src='"+pic+"' alt='用户上传的图片'>";
}
/*点击上传照片按钮时*/

//点击发表攻略按钮时触发事件
$('#send').click(function(event) {
	// alert($('#input-iframe').contents().find("body").html());
	var inputContent = $('#input-iframe').contents().find("body").html();
	$('#input-area').val(inputContent);    //设置textarea的内容
	if($('#title').val() == '' || $('#headerpic').val() == '' || $('#country').val() == '' || $('#input-area').val() == ''){
		alert("请将表单填写完整");
	}else{
		submitPic();
	}
});

// 提交标题图片
function submitPic() {
	// 上传图片模块
		$.ajaxFileUpload({
			// url: 'data/picture.json',
			url: 'http://localhost:8080/travel/picture/submit', //用于文件上传的服务器端请求地址
			secureuri: false, //是否需要安全协议，一般设置为false
			fileElementId: 'headerpic', //文件上传域的ID
			dataType: 'json', //返回值类型 一般设置为json
			contentType:'application/json',
			data: JSON.stringify({
				"picture": $('#headerpic').attr('name'),
			}),
			success: function (data, status)  //服务器成功响应处理函数
			{
				if(data.saveResult == true){
					addEassay(data.pictureURL);
				}else{
					alert("上传标题图片出错，发表失败");
				}
			},
			error: function (data, status, e)//服务器响应失败处理函数
			{
				alert("图片上传失败");
			}
		});
}

// 提交表单
function addEassay(pic) {
	$.ajax({
		// url: 'data/isLogin.json',
		url: 'http://localhost:8080/travel/essay/addEssay',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"userID":userId,
			"country":$('#country').val(),
			"essayHeader":$('#title').val(),
			"pictureURL":pic,
			"context":$('#input-area').val()
		}),
	})
	.done(function(data) {
//		isLogin = data.isLogin;
		if(isLogin == true ){
			alert("文章添加成功");
			window.location.href='http://localhost:8080/travel/personal.jsp';
			dealingUserData(data);
		}else{
			window.location.href = 'http://localhost:8080/travel/login.jsp';
		}
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		// console.log("complete");
	});
	
}