$(function(){
	tag = true;  //用于记录邮箱是否存在或正确

// 文本框判断部分
  //文本框失去焦点后
  $('form :input').blur(function(){
    var $parent = $(this).parent();
    $parent.find(".error").remove();
    var element = this.value;  //获取元素的值	
    var text_pic = "<div class='error form-group'><img src='images/error.png' alt='错误icon' class='img-rounded'>&nbsp;" ;

    //验证邮件
    if( $(this).is('#input-email') ){
		// var phoneReg = /^1[3|4|5|7|8][0-9]{9}$/;  //手机匹配的正则表达式，第一位是【1】开头，第二位则则有【3,4,5,7,8】，第三位则是【0-9】，第三位之后则是数字【0-9】
		var emailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;  //邮箱匹配的正则表达式
		if (element == "" || element == null) {
			tag = false;
			text = text_pic+"<span>账号不能为空！</span>";
			$parent.append(text+"</div>");   //插入html语句
		}else if(!emailReg.test(element)){
			tag = false;
			text = text_pic+"<span>请输入正确的邮箱！</span>";
			$parent.append(text+"</div>");   //插入html语句
		}else{
			tag = true;			
			$parent.find(".error").remove();    //输入正确后，删除提示语
		}
    }

    //验证密码
    if( $(this).is('#input-password') ){	
		if (element == "" || element == null) {
			text = text_pic+"<span>密码不能为空！</span>";
			$parent.append(text+"</div>");   //插入html语句
		}else if (element.length<6) {
			text = text_pic+"<span>密码长度不能小于6！</span>";
			$parent.append(text+"</div>");   //插入html语句
		}else{
			$parent.find(".error").remove();
		}
    }

 	// 再次确定密码
 	if($(this).is('#re-input-password')){
 		var password2 = $('#input-password').val();
 		console.log(password2);
 		if(element != password2){
 			text = text_pic+"<span>两次输入的密码不一致！</span>";
 			$parent.append(text+"</div>");   //插入html语句
 		}else{
 		$parent.find(".error").remove();
	 	}
 	}

    //验证验证码
    if( $(this).is('#verification') ){	
    	$parent.parent().find(".error").remove();    //由于排版问题，故单独将验证码的错误信息单独插入在其父结点的父结点中
		if (element == "" || element == null) {
			text = text_pic+"<span>验证码不能为空！</span>";
			$parent.parent().append(text+"</div>");   //插入html语句
		}else{
			$parent.parent().find(".error").remove();
		}
    }


  }).keyup(function(){ 
   $(this).triggerHandler("blur");    //键下内容时触发事件
  }).focus(function(){
    $(this).triggerHandler("blur");   //获得焦点时触发事件
  });//end blur

})

