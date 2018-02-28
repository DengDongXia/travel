$().ready(function($) {	
	getUser();   //获取用户是否登录的信息
});

function getUser() {
	$.ajax({
		// url: 'data/isLogin.json',
		url: 'http://localhost:8080/travel/user/isLogin',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
	})
	.done(function(data) {
		isLogin = data.isLogin;
		if(data.isLogin == true ){
			dealingUserData(data);
			getData(1);	//获取第一页的数据
		}else{
			window.location.href = 'http://localhost:8080/travel/login.jsp';
		}
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		// console.log("complete");
	});
	
}

// 对后台返回的用户登录信息进行处理
var userRole; //记录登录的用户的的身份
var userId; //记录用户id
function dealingUserData(data) {
	if(data.isLogin == false){
		var login = "<li><a href='http://localhost:8080/travel/login.jsp'><i class='fa fa-meh-o'> </i>登录</a></li>";
		var register = "<li><a target='_blank' href='http://localhost:8080/travel/register.jsp'><i class='fa fa-plus'> </i>注册</a></li>";
		$('#top-menu').append(login+register);
	}else{
		userRole = data.content.userRole;   //1表示为管理员
		userId = data.content.id;
		var personal = "<li><a href='personal.jsp'><i class='fa fa-meh-o'> </i>"+data.content.name+"</a></li>";
		personal += "<li id='logout'><a href=''><i class='fa fa-sign-out'> </i>注销</a></li>";
		$('#top-menu').append(personal);
	}
	$('#logout').click(function(event) {
		$.ajax({
			url: 'http://localhost:8080/travel/user/logout',
			type: 'post',
			dataType: 'json',
			contentType:'application/json'
		})
		.done(function(data) {
			// 后端跳转页面
		})
		.fail(function() {
			console.log("error");
		})
		.always(function() {
			// console.log("complete");
		});
		
	});
}

// 自动调整文本框背景大小
function ajdustText() {
	var h = $(".img-part").css("height");
	var maxH = $(".img-part").css("max-height");
	if(h < maxH) $(".tip-text").css("height",h);
	else $(".tip-text").css("height",maxH);
}

// 悬停图片，改变图片大小
function changeImg() {
	// 鼠标悬停在图片上，图片逐渐变大
	$(".img-part").hover(function (){
		$(this).find("img").animate({width:"105%"}, 2000);
		ajdustText();
	},function() {
		$(this).find("img").stop().animate({width:"100%"}, 1000);
		ajdustText();
	});
}

// 发起请求，获取后台数据
function getData(pageIndex) {
	$.ajax({
		// url: 'data/index.json',
		url: 'http://localhost:8080/travel/essay/show',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"pageIndex":pageIndex,
			"showLimit":7,
		}),
	})
	.done(function(data) {
		setData(data);
		// console.log("success");
	})
	.fail(function() {
		console.log("网页出错");
	})
	.always(function() {
		// console.log("资料加载完成");
	});
	
}

//数据处理
nowPage = 1; //定义一个全局变量保存当前页面数
function setData(data) {
	var ul = $(".tip-bg");
	ul.children().remove();  //移除上一次的请求的页面
	// 插入所有文章
	$.each(data.content, function(index, val) {
		var imgPart ="";
		if(val.eassyState == true){
			imgPart += "<span class='authen'>已认证</span>";
		}
		    imgPart += "<div class='img-part'><img src='"+val.eassyPicture+"' alt='攻略一图片'/><h2 class='get'>查看攻略</h2></div> ";
		var textPart = "<div class='tip-text'><h3>"+val.eassyHeader+"</h3><h4>"+val.eassyContent+"</h4></div>";
		var other = "<div class='otherInfo'><span>地区："+val.eassyCountry+"</span><span>来自："+val.eassyPersonName+"</span><span>评论数："+val.eassyCommentCount+"</span></div>";
		var liPart = "<li class='tip-content'><a href='detail.jsp?essayId="+val.eassyID+"'><div class='tip'>"+imgPart+textPart+"</div>"+other+"</a></li>";
		ul.append(liPart);
	});
	// 修改切换页面的按钮
	$('#switchPage').children().remove();  //移除原来的按钮
	// 首先判断是否插入上一页按钮
		var pageText = '';  //用于保存插入按钮的相关html
		if(nowPage != 1){
			pageText += "<span class='page' id='lastPage'>上一页</span>";
		}
		// 插入当前选中的按钮
		pageText += "<span class='page' id='nowPage'>"+parseInt(nowPage)+"</span>";
		for(var i = nowPage+1;i < (nowPage+3);i++){
			if(i<data.pageNumber){
				pageText += "<span class='page'>"+parseInt(i)+"</span>";
			}else{
				break;
			}
		}
		if(nowPage != (data.pageNumber - 1) && nowPage != data.pageNumber){
			pageText += "<span class='page' id='morePage'>...</span><span class='page'>"+parseInt(data.pageNumber)+"</span>";
		}else{
			if(nowPage != data.pageNumber){
				pageText += "<span class='page'>"+parseInt(data.pageNumber)+"</span>";
			}
		}
		if(nowPage != data.pageNumber){
		pageText += "<span class='page' id='nextPage'>下一页</span>";
		}
		$("#switchPage").append(pageText);
		//给页面按钮绑定事件
		/*以下为分页按钮切换内容*/
		$('#switchPage').find('.page').click(function(event) {
			var clickPage = nowPage;
			// 判断选中的分页按钮是哪个
			if($(this).is('#lastPage')){        // 点击上一页
				clickPage = nowPage - 1;
			}
			else if($(this).is('#nextPage')){   //点击下一页
				clickPage = nowPage + 1;
			}
			else if($(this).is('#morePage')){   //点击更多页
				if((nowPage + 3)<data.pageNumber){
					clickPage = nowPage + 3;
				}else{
					clickPage = nowPage + 1;
				}
			}
			else if($(this).is('#nowPage')){ //点击当前选中页
				clickPage = nowPage;
			}
			else{  
				clickPage = parseInt($(this).text());  //获取该页的数值
			}
			nowPage = clickPage;   //保存当前点击的页面
			getData(nowPage);	//获取点击页面的数据
		});
	changeImg();
}
