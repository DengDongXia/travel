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
	<link href="css/adminPersonal.css" rel='stylesheet' type='text/css' />
</head>
<body>
	<div class="container-fluid main">
		<!-- 头部内容 -->
		<div class="row header">
			<div class="col-md-1"></div>
			<div class="col-md-4 header-logo">
			  <div class="logo">
				<a href="index.jsp"><img src="images/nickoLogo.png" alt=""/></a>
			  </div>
			</div>
			<div class="col-md-6 header-right">
				<div class="top-menu">
					<ul id="top-menu">
						<li><a class="scroll" href="index.jsp"><i class="fa fa-home"></i>首页</a></li>
						<li><a href="strategy.jsp"><i class="fa fa-star"> </i> 特色定制</a></li>
						<li><a class="active" href="adminPersonal.jsp"><i class="fa fa-meh-o"> </i>管理员中心</a></li>
						<li id='logout'><a href='http://localhost:8080/travel/user/logout'><i class='fa fa-sign-out'> </i>注销</a></li>
					</ul>
				 </div>
			</div>
			<div class="col-md-1"></div>
			<!-- <div class="clearfix"> </div> -->
		</div>

		<!-- 主要内容部分 -->
		<div class="main-content">
			<!-- 个人信息部分 -->
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10 personal-info">
						<div class="col-md-2">
							<div class="img-bg" id="userPic">
								<!-- <img src="images/banner4.jpg"> -->
							</div>
							<p id="changeData">修改资料</p>
						</div>
						<div class="col-md-2 info" id="userInfo">
							<!-- <p class="name">昵称：么么么哒</p>
							<p class="integral">
								积分：<span>10</span></p> -->
						</div>
						<!-- <div class="col-md-6"></div>
						<div class="col-md-2">
							<a href="write-strategy.jsp">
							<div class="add-strategy">
								<span>发表攻略</span>
							</div>
							</a>
						</div> -->
				</div>
				<div class="col-md-1"></div>
			</div>
			<!-- 功能部分 -->
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10 all-funtion">
					<div class="col-md-2 lists" id="lists">
						<h5>所有功能</h5>
						<p id="strategy" class="choose">文章管理</p>
						<p id="my-question">用户管理</p>
					</div>
					<div class="col-md-10 list-content" id="list-content">
						<!-- 文章管理部分内容 -->
						<!-- <div class="published contents show" id="content">
							<h4 class="title">文章管理</h4>
							<div class="custom-made-contents">
								<ul id="list-bg">
									<li>
										<a taget="_blank" href='detail.jsp?essayId=1'>
											<div class="content">
												<h4>即将去北京玩，求攻略，感激不尽即将去北京玩，求攻略，感激不尽即将去北京玩，求攻略，感激不尽求攻略，感激不尽</h4>
												<p><span class="tag">法国巴黎</span><span>2018.1.18 23:45</span></p>
											</div>
										</a>
										<div class="about">
											<p><span class='delete' id='noPass'>不通过</span><span id='pass'>审核通过</span></p>
											<p><label class='authen'><input type='checkbox'> 已得到旅游认证</label></p>
											<p>评论数: <span>18</span></p>
										</div>
									</li>
								</ul>
							</div>
						</div> -->
						<!-- 用户管理内容 -->
						<!-- <div class="custom-made contents" id="question">
							<h4 class="title">用户管理</h4>
							<div class="custom-made-contents">
								<ul id="user-info-bg">
									<li class='info-title'><span class='number'>编号</span><span class='user-pic'>头像</span><span class='user-name'>昵称</span><span class='user-status'>状态</span><span class='mark'>积分</span><span class='func'>操作</span></li>
									<li><span class='number'>11</span><span class='user-pic'><div class="img-bg" id="userPic"><img src="images/banner4.jpg"></div></span><span class='user-name'>么么哒</span><span class='user-status'>冻结</span><span class='mark'>136</span><span class='func'><label id='chageStatus'>解冻账号</label><label id='clear'>积分清零</label></span>
									</li>
								</ul>
							</div>
						</div> -->
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
		
		<!-- 脚部信息 -->
		<div class="row"><footer>页脚备注</footer></div>

		<!-- 遮罩层部分，进行资料修改 -->
		<div id="changDataBg" class="custom-made-question">
			<div class="form-bg" id="changeData-bg">
				<div class="form-horizontal">
				<h4>修改个人资料</h4>
				  <div class="form-group">
				    <label for="title" class="col-sm-2 control-label">邮箱</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="email" placeholder="请输入新的邮箱">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="title" class="col-sm-2 control-label">昵称</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="username" placeholder="请输入新的昵称">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="title" class="col-sm-2 control-label">个性签名</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="chageQuote" placeholder="请输入新的个性签名">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="title" class="col-sm-2 control-label">头像</label>
				    <div class="col-sm-10">
				      <input type="file" class="form-control" name="pic" id="chageUserPic">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10 publish">
				      <button type="submit" class="btn btn-default" id="changeUserData">修改</button>
				    </div>
				  </div>
				</div>
			</div>
		</div>

	</div>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="js/adminPersonal.js"></script>
</body>
</html>