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
	<!-- <link href="css/strategy.css" rel='stylesheet' type='text/css' /> -->
	<link href="css/strategy-detail.css" rel='stylesheet' type='text/css' />
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
						<li><a href="strategy.jsp"><i class="fa fa-star"> </i> 特色定制</a></li>
					</ul>
				 </div>
			</div>
			<div class="col-md-1"></div>
		</div>

		<!-- 所有定制攻略的要求 -->
		<div class="custom-made">
			<h3 class="content-title">特色定制</h3>
			<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10 question">
						<div class="head-img">
							<div class="img-bg" id="userPic">
								<!-- <img src="images/banner4.jpg"> -->
							</div>
							<!-- <span class="name">么么么哒</span>
							<span class="time">2018.1.22 14:10</span> -->
						</div>
						<div class="question-text" id="question-text">
							<!-- <h3><img src="images/strategy_r.png">即将去北京玩，求攻略，感激不尽即将去北京玩，求攻略，感激不尽即将去北京玩，求攻略，感激不尽求攻略，感激不尽</h3>
							<h4>需定制的攻略内容，请大家给我一些关于北京美食以及较好的旅游景点的攻略，或者推荐些好东西。。。需定制的攻略内容，请大家给我一些关于北京美食以及较好的旅游景点的攻略，或者推荐些好东西。。。需定制的攻略内容，请大家给我一些关于北京美食以及较好的旅游景点的攻略，或者推荐些好东西。。。</h4> -->
						</div>
						<div class="other-text">
							<span>评论数</span><!-- <span class="num">18</span> -->
						</div>
						<div class="input">
							<!-- <form > -->
								<textarea id="strategy-text"
								placeholder="提供你的攻略，也许正合小主的心意哦"></textarea>
								<p><button id="offer">发表评论</button></p>
							<!-- </form> -->
						</div>
					</div>
					<div class="col-md-1"></div>
				</div>
			</div>


			<div class="offer-strategy">
				<ul class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10 question" id="comments">
						<h3>所有攻略</h3>
						<!-- <li>
							<div class="head-img">
								<div class="img-bg">
									<img src="images/banner4.jpg">
								</div>
								<span class="name">么么么哒</span>
							</div>
							<div class="question-text">
								<p>提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略</p>
								<p class="time">2018.1.22 14:10</p>
							</div>
						</li>

						<li>
							<div class="head-img">
								<div class="img-bg">
									<img src="images/banner4.jpg">
								</div>
								<span class="name">么么么哒</span>
							</div>
							<div class="question-text">
								<p>提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略</p>
								<p class="time">2018.1.22 14:10</p>
							</div>
						</li>

						<li>
							<div class="head-img">
								<div class="img-bg">
									<img src="images/banner4.jpg">
								</div>
								<span class="name">么么么哒</span>
							</div>
							<div class="question-text">
								<p>提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略</p>
								<p class="time">2018.1.22 14:10</p>
							</div>
						</li> -->
					</div>
					<div class="col-md-1"></div>
				</ul>
			</div>
			

<!-- 
			<div class="offer-strategy">
				<h3>所有攻略</h3>
				<ul>
					<li class="row">
						<div class="col-md-1"></div>
						<div class="col-md-10 question">
							<div class="all-strategy">
								<div class="head-img">
									<div class="img-bg">
										<img src="images/banner4.jpg">
									</div>
									<span class="name">么么么哒</span>
								</div>
								<div class="question-text">
									<h5>提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略提供的攻略</h5>
									<h5 class="time">2018.1.22 14:10</h5>
								</div>
							</div>
							
						</div>
						<div class="col-md-1"></div>
					</li>
				</ul>
			</div> -->
			
		
		</div>
		<!-- <div class="row"><footer>页脚备注</footer></div> -->
	</div>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/strategy-detail.js"></script>
</body>
</html>