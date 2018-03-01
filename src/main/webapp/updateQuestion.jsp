<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>特色定制修改的页面</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href='http://fonts.useso.com/css?family=Roboto' rel='stylesheet:100,300,400,500,600,700,800,900' type='text/css'>
	<link rel="stylesheet" href="fonts/css/font-awesome.min.css">
	<link href="css/common.css" rel='stylesheet' type='text/css' />
	<link href="css/write-strategy.css" rel='stylesheet' type='text/css' />
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
						<li><a href="personal.jsp"><i class="fa fa-meh-o"> </i>个人中心</a></li>
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
				<div class="col-md-10 form-bg">
					<div class="form-bg" id="form-bg">
						<div class="form-horizontal">
						<h4>修改特色定制</h4>
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
						      <button type="submit" class="btn btn-default" id="submitQuestion">修改</button>
						    </div>
						  </div>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
			<!-- 功能部分 -->
			<!-- 主要文本框部分 -->

		</div>
		
		<!-- 脚部信息 -->
		<div class="row"><footer>页脚备注</footer></div>
	</div>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/updateQuestion.js"></script>
</body>
</html>