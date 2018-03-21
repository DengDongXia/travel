<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>所有定制攻略的需求</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel='stylesheet' type='text/css' href="css/bootstrap.css"/>
	<!-- <link href='http://fonts.useso.com/css?family=Roboto' rel='stylesheet:100,300,400,500,600,700,800,900' type='text/css'> -->
	<link rel="stylesheet" href="fonts/css/font-awesome.min.css">
	<link href="css/common.css" rel='stylesheet' type='text/css' />
	<link href="css/personal.css" rel='stylesheet' type='text/css' />
	<link href="css/mainAdminPersonal.css" rel='stylesheet' type='text/css' />
</head>
<body>
	<div class="container-fluid main">
		<!-- 头部内容 -->
		<div class="row header">
			<div class="col-md-1"></div>
			<div class="col-md-4 header-logo">
			  <div class="logo">
				<a href=""><img src="images/nickoLogo.png" alt=""/></a>
			  </div>
			</div>
			<div class="col-md-6 header-right">
				<div class="top-menu">
					<ul id="top-menu">
						<li><a class="active" href="mainAdminPersonal.jsp"><i class="fa fa-meh-o"> </i>超级管理员中心</a></li>
						<li id='logout'><a href='http://localhost:8080/travel/user/logout'><i class='fa fa-sign-out'> </i>注销</a></li>
					</ul>
				 </div>
			</div>
			<div class="col-md-1"></div>
			<!-- <div class="clearfix"> </div> -->
		</div>

		<!-- 主要内容部分 -->
		<div class="main-content">
			<!-- 功能部分 -->
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10 all-funtion">
					<div class="col-md-2 lists" id="lists">
						<h5>所有功能</h5>
						<p id="strategy" class="choose">查询管理员</p>
						<p id="my-question">新增管理员</p>
					</div>
					<div class="col-md-10 list-content" id="list-content">
						<!-- 用户管理内容 -->
						<!-- <div class="custom-made contents" id="question">
							<h4 class="title">管理员查询</h4>
							<div class="custom-made-contents">
								<ul id="user-info-bg">
									<li class='info-title'><span class='number'>编号</span><span class='user-pic'>头像</span><span class='user-name'>昵称</span><span class='user-status'>状态</span><span class='mark'>个性签名</span><span class='func'>操作</span></li>
									<li><span class='number'>11</span><span class='user-pic'><div class="img-bg" id="userPic"><img src="images/banner4.jpg"></div></span><span class='user-name'>么么哒</span><span class='user-status'>冻结</span><span class='mark'>136</span><span class='func'><label id='chageStatus'>解冻账号</label></span>
									</li>
								</ul>
							</div>
						</div> -->
						<div class='published contents' id='question'>
							<h4 class='title'>查询管理员</h4>
							<div class='custom-made-contents'><p><input type='type' id='condition' placeholder='请输入要搜素的管理员的编号或名称'><span id='searchUser'>确定<span></p>
							<p class='info-title'><span class='number'>编号</span><span class='user-pic'>头像</span><span class='user-name'>昵称</span><span class='user-status'>状态</span><span class='func'>操作</span></p>
								<ul id='user-info-bg'>
									<!-- <li class='info-title'><span class='number'>编号</span><span class='user-pic'>头像</span><span class='user-name'>昵称</span><span class='user-status'>状态</span><span class='func'>操作</span></li>
								 -->
								 </ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
		
		<!-- 脚部信息 -->
		<!-- <div class="row"><footer>页脚备注</footer></div> -->

		<!-- 新增管理员部分 -->
		<div class="addAdminBg" id='changDataBg'>
			<div class="addPanel" id='changDataForm'>
				  <div class="mainLabel form-group">
				  	  <label>新增管理员</label>
				  </div>
				  <div class="form-group">
				      <input type="text" name="email" class="input form-control required" id="input-email" placeholder="邮箱" />
				  </div>
				  <div class="form-group">
				      <input type="text" name="" class="input form-control required" id="input-username" placeholder="昵称" />
				  </div>
				  <div class="form-group">
				      <input type="password" name="" class="input form-control required" id="input-password" placeholder="密码" />
				  </div>
				   <div class="form-group">
				      <input type="text" name="re-password" class="input form-control required" id="input-quote" placeholder="个性签名" />
				  </div>
				  <div class="input form-group">
					  <input type="button" id="add"  class="btn btn-default" value="新增管理员" />
				  </div>
			</div>
		</div>

	</div>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/mainAdminPersonal.js"></script>
</body>
</html>