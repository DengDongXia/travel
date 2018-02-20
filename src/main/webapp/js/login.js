/*登录部分*/
	// 登录异步获取图片验证码
	$('#getPicVerification').click(function(){
		getPicCode();
	});

	//异步请求图片验证码
	function getPicCode(argument) {
		$.ajax({
			url: '/login/identifyCode',
			type: 'POST',
			dataType: 'json',
			// data: {param1: 'value1'},
		})
		.done(function(data) {
			$('#getPicVerification').attr('src', data.image);
		})
		.fail(function() {
			console.log("error");
		})
		.always(function() {
			console.log("complete");
		});
		
	}

  //提交，最终验证。
   $('#registerButton').click(function(){
    $("form :input.required").trigger('blur');    //含有类名为required的文本框都触发验证事件
    var numError = $('form .error').length;
    if(numError){
     return false;
    }

    $.ajax({
			url: '/loginCheck',
			type: 'POST',
			dataType: 'json',
			data: JSON.stringify({
				email: $("#input-email").val(),
				password: $("#input-password").val(),
				validateCode: $("#verification").val()
			}),
		})
	.done(function(data) {
		var text = "<div class='error form-group'>" ;
			if(data.emailResult == 'false'){
				$("#input-email").find(".error").remove();
				text += "<span>该邮箱尚未注册</span></div>";
				$("#input-email").parent().append(text);
			}else{
				if(data.passwordResult == 'false'){
					$("#input-password").find(".error").remove();
					text += "<span>密码错误</span></div>";
					$("#input-password").parent().append(text);
				}
				else if(data.identifyCodeResult == 'false'){
				    $("#verification").find(".error").remove();
					text += "<span>验证码错误</span></div>";
					$("#verification").parent().append(text);
				}else if(data.accountState == 'false'){
					$("#verification").find(".error").remove();
					text += "<span>该账号已被锁定</span></div>";
					$("#verification").parent().append(text);
				}
				else{
					location.href="../index.jsp";
					alert("登录成功！录成功");
				}
			}
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		// console.log("complete");
	});
});