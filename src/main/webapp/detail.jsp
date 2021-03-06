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
	<link href="css/detail.css" rel='stylesheet' type='text/css' />
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
						<!-- <li><a href="personal.jsp"><i class="fa fa-meh-o"> </i>个人中心</a></li>
						<li><a href="login.jsp"><i class="fa fa-meh-o"> </i>登录</a></li>
						<li><a target="_blank" href="register.jsp"><i class="fa fa-plus"> </i>注册</a></li> -->
					</ul>
				 </div>
			</div>
			<div class="col-md-1"></div>
		</div>

		<!-- 攻略详情 -->
		<div class="row">
			<div class="col-md-12 main-img-bg">
				<p id='headerPic'><!-- <img src="images/banner7.jpg"> --></p>
				<div class="author">		
					<div class="img-bg" id="authorPicture">
						<!-- <img src="images/banner4.jpg"> -->
					</div>
					<span>作者：</span><!-- <span>么么么哒</span> -->
				</div>
			</div>
		</div>
		<div class="row content">
			<div class="col-md-1"></div>
			<div class="col-md-3 comment">
				<div class="input">
					<h4>评论</h4>
					<!-- <form> -->
						<input type="text" name="input-comment" placeholder="发表评论" id="comment-input"><button id="send">提交</button>
					<!-- </form> -->
				</div>
				<div class="all-comment">
					<ul id="comments">
						<h4>评论内容</h4>
						<!-- <li>
							<span>么么么哒：</span>
							<span>评论内容评论内容评论内容评论内容评论内容</span>
						</li>
						<li>
							<span>么么么哒：</span>
							<span>评论内容评论内容评论内容论内容评论内容评论内容论内容评论内容评论内容评论内容评论内容</span>
						</li>
						<li>
							<span>么么么哒：</span>
							<span>评论内容评论内容评论内容评论内容评论内容</span>
						</li>
						<li>
							<span>么么么哒：</span>
							<span>评论内容评论内容评论内容论内容评论内容评论内容论内容评论内容评论内容评论内容评论内容</span>
						</li> -->
					</ul>
					<div class="get-comment" id="getCommentButton">
						<span id="last">上一页</span>
						<span id="next">下一页</span>
					</div>
				</div>
				
			</div>
			<div class="col-md-7 strategy-content">
				<div class="about-strategy" id="eassayTag">
					<!-- <span class="tag">法国巴黎</span><span>2018.1.23 9:57</span> -->
				</div>
				<div class="strategy-text" id="eassayContent">		
					<!-- <h3>攻略文章标题</h3>	
					<h4>攻略文章内容攻略文章内容，攻略文章内容攻略文章内容攻略文章内容攻略文章内容攻略，文章内容攻略文章内容攻略文章内容攻略文章内容攻略文章内！容攻略文章内容攻略文章内容攻略文章内容攻略文章内容...</h4>
					<img src="images/banner6.jpg" alt="攻略所示图片">	 -->			
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>

		<div class="row"><footer>页脚备注</footer></div>
	</div>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/detail.js"></script>
</body>
</html>