/*注册部分*/	
	/*异步获取邮箱验证码*/
	//注册Ajax异步请求发送验证码,向后台传输手机号或者邮箱
	$('#getVerification').click(function(){
		getIdentifyCode();
	});

	// 发起请求，获取后台数据，发送邮箱验证码
	function getIdentifyCode() {
		$.ajax({
			url: "http://localhost:8080/travel/user/emailIdentifyCode",
			// url: "http://localhost:8080/travel/user/emailIdentifyCode",
			type:  "POST",
			contentType:"application/json",
			dataType: 'json',
			async: true,
			data: JSON.stringify({email : $('#input-email').val()})
		})
		.done(function(data) {
			setData(data);
		})
	}

	// 处理data的函数
	function setData(da) {
		
		if(da.getIdentifyCodeResult == true){
			 	setTip(1);   //传入1表示发送成功
		}else{
			 	setTip(0);   //传入0表示发送失败
		}
	}

	//设置插入的文本的函数
	function setTip(num) {
		$("#tag").find(".error").remove();	
	    var text = "<div class='error form-group'><img src='images/error.png' alt='错误icon' class='img-rounded'>&nbsp;" ;
		switch(num){
			case 0 :
				text += "<span>邮箱获取验证码失败，请检查邮箱格式是否正确</span></div>";
				$("#tag").append(text);
				break;
			case 1 :
				countDown($("#getVerification"));
				break;
		}
		
	}

	// 倒计时函数封装
	//当后台异步返回邮箱发送成功时，调用该函数
	function countDown(obj) {
		var sec = 60;              //倒计时60s
			obj.text(sec+'s后重新发送');
			obj.addClass("sended");           //添加类名sended
			obj.attr("disabled",true);        //按钮不可用
			timer = setInterval(function(){
				sec--;                            //秒数自减1
				$("#getVerification").text(sec+'s后重新发送');  //设置按钮文本
				if(sec == 0){                     //如果倒计时结束
					clearInterval(timer);         //清除定时器
					$("#getVerification").attr("disabled",false);      //恢复可用
					$("#getVerification").text('重新发送');  //设置按钮文本
				}
			},1000);
	}

  //提交，最终验证。
   $('#registerButton').click(function(){
    $("form :input.required").trigger('blur');    //含有类名为required的文本框都触发验证事件
    var numError = $('form .error').length;
    if(numError){
     return false;
    } 
    // 异步提交表单数据
    $.ajax({
    	url: 'http://localhost:8080/travel/user/register',
    	type: 'POST',
    	dataType: 'json',
    	contentType:'application/json',
    	data: JSON.stringify({
    		email: $("#input-email").val(),
			password: $("#input-password").val(),
			repeatePassword: $("#re-input-password").val(),
			emailValidateCode: $("#verification").val()
		}),
    })
    .done(function(data) {
    	if(data.identifyCodeResult == true && data.existEmail == true && data.password == true){
				alert("注册成功！");
				location.href = "http://localhost:8080/travel/login.jsp";   //当后端注册成功后,返回true,跳转到登录界面
			}else{
				if(data.existEmail == false){
					$("#tag").find(".error").remove();	
				    var text = "<div class='error form-group'><span>邮箱已存在</span></div>" ;
					$("#tag").append(text);
				}
				else if(data.password == false){
					$("#tag").find(".error").remove();	
				    var text = "<div class='error form-group'><span>请确认密码的一致性</span></div>" ;
					$("#tag").append(text);
				}
				else if(data.identifyCodeResult == false){
					$("#tag").find(".error").remove();	
				    var text = "<div class='error form-group'><span>验证码错误</span></div>" ;
					$("#tag").append(text);
				}
			}
    })
    .fail(function() {
    	// console.log("error");
    })
    .always(function() {
    	// console.log("complete");
    });
});
