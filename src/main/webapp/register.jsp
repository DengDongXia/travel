<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>注册--Nicko--景点旅游推荐论坛系统</title>
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href='http://fonts.useso.com/css?family=Roboto' rel='stylesheet:100,300,400,500,600,700,800,900' type='text/css'>
	<link rel="stylesheet" href="fonts/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/register-login.css">
</head>
<body>
<div class="container-fluid">
	<div class="row">
		 <div class="col-md-3">
		 </div>	
		 <div class="col-md-6 register-form">
			 <div class="panel panel-default">
				<div class="login-main panel-body">
					<form action="user/register" method="post">
						  <div class="mainLabel form-group">
						  	  <label>注册</label>
						  </div>
						  <div class="form-group">
						      <input type="text" name="email" class="input form-control required" id="input-email" placeholder="邮箱" />
						       
						  </div>
						  <div class="form-group">
						      <input typpassworde="password" name="" class="input form-control required" id="input-password" placeholder="密码" />
						  </div>
						   <div class="form-group">
						      <input type="password" name="re-password" class="input form-control required" id="re-input-password" placeholder="确定密码" />
						  </div>
						  <div class="form-group"  id="tag">
						      <div class="input">
							      <input type="text" name="identifyCode" id="verification" class="verificationInput form-control required"  placeholder="验证码">
							      <button type="button" id="getVerification" class=" verificationInput form-control">获取邮箱验证码</button>
						      </div>
						  </div>
						  <div class="input form-group">
							  <input type="button" id="registerButton"  class="btn btn-default" value="注册" />
						  </div>
						  <div id="loginImmediately" class="form-group">
							  <a href="http://localhost:8080/travel/login.jsp"><label>立即登录</label></a>
						  </div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-md-3"></div>
	</div>
</div>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script src="js/register-login.js"></script>
<script src="js/register.js"></script>
</body>
</html>