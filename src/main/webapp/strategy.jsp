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
	<link href="css/strategy.css" rel='stylesheet' type='text/css' />
</head>
<body>
	<div class="container-fluid">
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
						<li><a class="active" href="strategy.jsp"><i class="fa fa-star"> </i> 特色定制</a></li>
						<!-- <li><a href="personal.html"><i class="fa fa-meh-o"> </i>个人中心</a></li>
						<li><a href="login.html"><i class="fa fa-meh-o"> </i>登录</a></li>
						<li><a target="_blank" href="register.html"><i class="fa fa-plus"> </i>注册</a></li>
						<div class="clearfix"></div> -->
					</ul>
				 </div>
			</div>
			<div class="col-md-1"></div>
			<!-- <div class="clearfix"> </div> -->
		</div>

		<!-- 所有定制攻略的要求 -->
		<div class="all-question">
			<h3 class="content-title">定制攻略</h3>
				<ul class="question-bg" id="questionText">
					<!-- 以下被注释部分由ajax异步请求返回 -->
					<!-- <li class="row">
						<a href="strategy-detail.html" class="col-md-offset-1 col-md-10 question">
							<div class="head-img">
								<div class="img-bg">
									<img src="images/banner4.jpg">
								</div>
								<p>么么么哒</p>
								<span class="time">2018.1.22 14:10</span>
							</div>
							<div class="question-text">
								<h3><img src="images/strategy_r.png">即将去北京玩，求攻略，感激不尽即将去北京玩，求攻略，感激不尽即将去北京玩，求攻略，感激不尽</h3>
								<h4>需定制的攻略内容，请大家给我一些关于北京美食以及较好的旅游景点的攻略，或者推荐些好东西。。。</h4>
							</div>
							<div class="comments-num">
								<div class="num"><h4>评论数</h4><h1>18</h1></div>
							</div>
						</a>
					</li>
					<li class="row">
						<a href="strategy-detail.html" class="col-md-offset-1 col-md-10 question">
							<div class="head-img">
								<div class="img-bg">
									<img src="images/banner4.jpg">
								</div>
								<p>么么么哒</p>
								<span class="time">2018.1.22 14:10</span>
							</div>
							<div class="question-text">
								<h3><img src="images/strategy_r.png">即将去北京玩，求攻略，感激不尽即将去北京玩，求攻略，感激不尽即将去北京玩，求攻略，感激不尽</h3>
								<h4>需定制的攻略内容，请大家给我一些关于北京美食以及较好的旅游景点的攻略，或者推荐些好东西。。。</h4>
							</div>
							<div class="comments-num">
								<div class="num adopted"><h4>已采纳</h4><h1>18</h1></div>
							</div>
						</a>
					</li> -->
					
				</ul>
		</div>
		<!-- 切换页面 -->
		<div id="switchPage">
			<!-- <span class="page" id="lastPage">上一页</span>
			<span class="page" id="nowPage">1</span>
			<span class="page">2</span>
			<span class="page">3</span>
			<span id="morePage">...</span>
			<span class="page">10</span>
			<span class="page" id="nextPage">下一页</span> -->
		</div>
		<!-- <div class="row"><footer>页脚备注</footer></div> -->
	</div>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/strategy.js"></script>
</body>
</html>