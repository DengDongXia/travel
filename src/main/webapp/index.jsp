<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<title>Nicko--景点旅游推荐论坛系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Realist Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href='http://fonts.useso.com/css?family=Roboto' rel='stylesheet:100,300,400,500,600,700,800,900' type='text/css'>
	<link rel="stylesheet" href="fonts/css/font-awesome.min.css">
	<link href="css/index.css" rel='stylesheet' type='text/css' />
	<link href="css/common.css" rel='stylesheet' type='text/css' />
</head>
<body>
	<div class="container-fluid">
		<!-- 头部内容 -->
		<div class="row header">
			<div class="col-md-1"></div>
			<div class="col-md-4 header-logo">
			  <div class="logo">
				<a href="index.html"><img src="images/nickoLogo.png" alt=""/></a>
			  </div>
			</div>
			<div class="col-md-6 header-right">
				<div class="top-menu">
					<ul id="top-menu">
						<li><a class="active scroll" href="index.html"><i class="fa fa-home"></i>首页</a></li>
						<li><a href="strategy.html"><i class="fa fa-star"> </i> 特色定制</a></li>
						<!-- <li><a href="personal.html"><i class="fa fa-meh-o"> </i>个人中心</a></li>
						<li><a href="login.html"><i class="fa fa-meh-o"> </i>登录</a></li>
						<li><a target="_blank" href="register.html"><i class="fa fa-plus"> </i>注册</a></li> -->
					</ul>
				 </div>
			</div>
			<div class="col-md-1"></div>
			<!-- <div class="clearfix"> </div> -->
		</div>
		<!-- 轮播图内容 -->
		<!-- <div class="row">
			<div class="slider">
			  <div class="slider-text">
				  <h1>世 界 无 奇 不 有</h1>
				  <h2>唯 独 没 有 你</h2>
			  </div>
			  <div class="callbacks_container">
			      <ul class="rslides" id="slider">
			        <li><img src="images/banner4.jpg" class="img-responsive" alt=""/>
			          <div class="banner_desc">		        
					</li>
			        <li><img src="images/banner5.jpg" class="img-responsive" alt=""/>
			         <div class="banner_desc">
			        </li>
			        <li><img src="images/banner6.jpg" class="img-responsive" alt=""/>
			          <div class="banner_desc">
			        </li>
			      </ul>
				</div>
			</div>
		</div>
 -->
		<!-- 所有攻略 -->
		<div class="row all-tips">
			<h3 class="content-title">所有攻略</h3>
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<ul class="tip-bg">
					<!-- 注释部分应由ajax请求获取 -->
					<!-- <li class="tip-content">
						<a href="detail.html">
							<div class="tip">
								<div class="img-part">
									<img src="images/tip1.jpeg">
									<h2 class="get">查看攻略</h2>
								</div>
								<div class="tip-text">
									<h3>印度——给岁月以文明，而不是给文明以岁月...</h3>
									<h4>“为什么去印度？”
				这大概是我定下印度行程之后被无数人质疑的问题。
				或许是出于双子座天生泛滥的好奇心；
				或许是对于异域风的执着迷恋...</h4>
								</div>									
							</div>
						</a>
					</li> -->
					
				</ul>
			</div>
			<div class="col-md-1"></div>

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
		<div class="row"><footer>页脚备注</footer></div>
	</div>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
</body>
</html>