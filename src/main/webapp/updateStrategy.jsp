<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>发表攻略的页面</title>
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
						<!-- <li><a href="personal.jsp"><i class="fa fa-meh-o"> </i>个人中心</a></li> -->
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
					<h4>编辑攻略的文章</h4>
					<form class="form-horizontal">
					  <div class="form-group">
					    <label for="title" class="col-sm-2 control-label">标题</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="title" placeholder="请输入攻略的标题">
					    </div>
					  </div>
					   <div class="form-group">
					    <label for="pic" class="col-sm-2 control-label">标题照片</label>
					    <div class="col-sm-10">
						    <input type="file" id="headerpic" name='pic' class="form-control">
					     </div>
					  </div>
					  <div class="form-group">
					    <label for="title" class="col-sm-2 control-label">国家</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="country" placeholder="请输入攻略所描述的国家">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="content" class="col-sm-2 control-label">内容</label>
					    <div class="col-sm-10">
					    	<p><input type="file" id="pic" name='pic' class="form-control submitPic"><span id='submitPic'>上传照片</span></p>
					    	<iframe id="input-iframe" class="form-control" src="" ></iframe>
					    	<textarea id="input-area" class="form-control" rows="15"></textarea>
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10 publish">
					      <button type="button" id="send" class="btn btn-default">发表攻略</button>
					    </div>
					  </div>
					</form>
				</div>
				<div class="col-md-1"></div>
			</div>
			<!-- 功能部分 -->
			<!-- 主要文本框部分 -->

		</div>
		
		<!-- 脚部信息 -->
		<!-- <div class="row"><footer>页脚备注</footer></div> -->
	</div>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="js/updateStrategy.js"></script>
</body>
</html>