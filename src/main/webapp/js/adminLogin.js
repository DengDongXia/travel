/*登录部分*/
$().ready(function() {
	getPicCode();  //获取图片验证码
});
	// 登录异步获取图片验证码
	$('#getPicVerification').click(function(){
		getPicCode();
	});

	//异步请求图片验证码
	function getPicCode() {
		var xmlhttp;
		xmlhttp=new XMLHttpRequest();
		xmlhttp.open("GET","http://localhost:8080/travel/login/identifyCode",true);
		xmlhttp.responseType = "application/json";
		xmlhttp.onload = function(){
		    if (this.status == 200) {
		        var blob = this.response;
		        var data = "data:image/jpeg;base64,"+$.parseJSON(blob).image;
    			$('#getPicVerification').attr('src', data);
		    }
		}
		xmlhttp.send();
		
	}

  //提交，最终验证。
   $('#registerButton').click(function(){
    $("form :input.required").trigger('blur');    //含有类名为required的文本框都触发验证事件
    var numError = $('form .error').length;
    if(numError){
     return false;
    }

    // 判断是哪一种管理员登录
    var type = $("input[type='radio']:checked").val();
    var url;
    // var url = "data/adminLogin.json";
    var location;
    if(type == 1){   //普通管理员登录
    	url = 'http://localhost:8080/travel/manager/loginCheck';
    	location = "http://localhost:8080/travel/adminPersonal.jsp";
    }else{            //超级管理员登录
    	url = 'http://localhost:8080/travel/manager/superManager/loginCheck';
    	location = "http://localhost:8080/travel/mainAdminPersonal.jsp";
    }
    clickLogin(url,location);
});

function clickLogin(url,location) {
	  $.ajax({
			url: url,
			type: 'POST',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
				email: $("#input-email").val(),
				password: $("#input-password").val(),
				validateCode: $("#verification").val()
			}),
		})
	.done(function(data) {
		var text = "<div class='error form-group'>" ;
			if(data.emailResult == false){
				$("#input-email").find(".error").remove();
				text += "<span>该邮箱尚未注册</span></div>";
				$("#input-email").parent().append(text);
			}else{
				if(data.passwordResult == false){
					$("#input-password").find(".error").remove();
					text += "<span>密码错误</span></div>";
					$("#input-password").parent().append(text);
				}
				else if(data.identifyCodeResult == false){
				    $("#verification").find(".error").remove();
					text += "<span>验证码错误</span></div>";
					$("#verification").parent().append(text);
				}else if(data.accountState == false){
					$("#verification").find(".error").remove();
					text += "<span>该账号已被锁定</span></div>";
					$("#verification").parent().append(text);
				}
				else{
					alert("登录成功！");
					window.location.href= location;
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