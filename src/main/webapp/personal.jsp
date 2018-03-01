<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>所有定制攻略的需求</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href='http://fonts.useso.com/css?family=Roboto' rel='stylesheet:100,300,400,500,600,700,800,900' type='text/css'>
	<link rel="stylesheet" href="fonts/css/font-awesome.min.css">
	<link href="css/common.css" rel='stylesheet' type='text/css' />
	<link href="css/personal.css" rel='stylesheet' type='text/css' />
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
						<li><a class="active" href="personal.jsp"><i class="fa fa-meh-o"> </i>个人中心</a></li>
						<li id='logout'><a href=''><i class='fa fa-sign-out'> </i>注销</a></li>
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
						<div class="col-md-8 info" id="userInfo">
							<!-- <p class="name">昵称：么么么哒</p>
							<p class="integral">
								积分：<span>10</span></p> -->
						</div>
						<!-- <div class="col-md-6"></div> -->
						<div class="col-md-2">
							<a href="write-strategy.jsp">
							<div class="add-strategy">
								<span>发表攻略</span>
							</div>
							</a>
						</div>
				</div>
				<div class="col-md-1"></div>
			</div>
			<!-- 功能部分 -->
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10 all-funtion">
					<div class="col-md-2 lists" id="lists">
						<h5>所有功能</h5>
						<p id="strategy" class="choose">发布的攻略</p>
						<p id="my-question">我的特色定制</p>
					</div>
					<div class="col-md-10 list-content" id="list-content">
						<a href=""></a>
						<!-- <div class="published contents show" id="content">
							<h4 class="title">已发布的攻略</h4>
							<div class="custom-made-contents">
								<ul id="list-bg">
									<li>
										<div class="content">
											<h4>即将去北京玩，求攻略，感激不尽即将去北京玩，求攻略，感激不尽即将去北京玩，求攻略，感激不尽求攻略，感激不尽</h4>
											<p><span class="tag">法国巴黎</span><span>2018.1.18 23:45</span></p>
										</div>
										<div class="about">
											<p><span class="delete">删除</span><span>编辑</span></p>
											<p>评论数: <span>18</span></p>
										</div>
									</li>
									<li>
										<div class="content">
											<h4>即将去北京玩，求攻略，感激不尽即将去北京玩，求攻略，感激不尽即将去北京玩，求攻略，感激不尽求攻略，感激不尽</h4>
											<p><span class="tag">法国巴黎</span><span>2018.1.18 23:45</span></p>
										</div>
										<div class="about">
											<p><span class="delete">删除</span><span>编辑</span></p>
											<p>评论数: <span>18</span></p>
										</div>
									</li>
								</ul>
							</div>
						</div> -->
						<!-- <div class="custom-made contents" id="question">
							<h4 class="title">我的特色定制</h4>
							<div class="custom-made-contents">
								<div id="add-custom-made" class="add-custom-made" title="新增特色定制"></div>
								<ul>
									<li>
										<div class="content">
											<h4>即将去北京玩，求攻略，感激不尽即将去北京玩，求攻略，感激不尽即将去北京玩，求攻略，感激不尽求攻略，感激不尽</h4>
											<h5>需定制的攻略内容，请大家给我一些关于北京美食以及较好的旅游景点的攻略，或者推荐些好东西。。。</h5>
										</div>
										<div class="about">
											<p><span class="delete">删除</span><span>编辑</span></p>
											<p>回答数: <span>18</span></p>
											<p>2018.1.18 23:45</p>
										</div>
									</li>
									<li>
										<div class="content">
											<h4>即将去北京玩，求攻略，感激不尽即将去北京玩，求攻略，感激不尽即将去北京玩，求攻略，感激不尽求攻略，感激不尽</h4>
											<h5>需定制的攻略内容，请大家给我一些关于北京美食以及较好的旅游景点的攻略，或者推荐些好东西。。。</h5>
										</div>
										<div class="about">
											<p><span class="delete">删除</span><span>编辑</span></p>
											<p>回答数: <span>18</span></p>
											<p>2018.1.18 23:45</p>
										</div>
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

		<!-- 遮罩层部分，进行特色定制 -->
		<div id="custom-made-question" class="custom-made-question">
			<div class="form-bg" id="form-bg">
				<div class="form-horizontal">
				<h4>进行特色定制</h4>
				  <div class="form-group">
				    <label for="title" class="col-sm-2 control-label">标题</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="questionTitle" placeholder="请输入定制问题的标题">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="content" class="col-sm-2 control-label">内容</label>
				    <div class="col-sm-10">
				    	<textarea class="form-control" id="questionContent" rows="15"></textarea>
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10 publish">
				      <button type="submit" class="btn btn-default" id="submitQuestion">进行特色定制</button>
				    </div>
				  </div>
				</div>
			</div>
		</div>

		<!-- 遮罩层部分，进行资料修改 -->
		<div id="changDataBg" class="custom-made-question">
			<div class="form-bg" id="changeData-bg">
				<div class="form-horizontal">
				<h4>修改个人资料</h4>
				  <div class="form-group">
				    <label for="title" class="col-sm-2 control-label">昵称</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="username" placeholder="请输入新的昵称">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="title" class="col-sm-2 control-label">个性签名</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="quote" placeholder="请输入新的个性签名">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="title" class="col-sm-2 control-label">头像</label>
				    <div class="col-sm-10">
				      <input type="file" class="form-control" name="userPic" id="userPic">
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
	<script type="text/javascript" src="js/personal.js"></script>
</body>
</html>