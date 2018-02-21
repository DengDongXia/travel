<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>登录--Nicko--景点旅游推荐论坛系统</title>
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
					<form action="user/loginCheck.jsp" method="post">
						  <div class="mainLabel form-group">
						  	  <label>登录</label>
						  </div>
						  <div class="form-group">
						      <input type="text" class="input form-control required" id="input-email" placeholder="邮箱" /> 
						  </div>
						  <div class="form-group">
						      <input type="password" class="input form-control required" id="input-password" placeholder="密码" />
						  </div>
						  <div class="form-group">
						      <div class="input">
							      <input type="text" id="verification" class="verificationInput form-control required"  placeholder="验证码">
							      <img src="" alt="图片验证码" id="getPicVerification" class=" verificationInput form-control">
						      </div>
						  </div>
						  <div class="input form-group">
							  <input type="button" id="registerButton"  class="btn btn-default" value="登录" />
						  </div>
						  <div id="loginImmediately" class="form-group">
							  <a href="http://localhost:8080/travel/register.jsp"><label>立即注册</label></a>
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
<script src="js/login.js"></script>
</body>
</html>