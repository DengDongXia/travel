$().ready(function($) {	
	// ajdustImg();
	// alert("1");
	getUser();   //获取用户是否登录的信息
	getData();
	// ajdustText();
	
});

$().ready(function() {
	// alert();
	changeImg();
});

// 自动调整图片大小
// function ajdustImg() {
// 	var imgs = $(".img-part img");
// 	var maxH = $(".img-part")[0];
// 	for (var i = 0; i <= imgs.length - 1; i++) {
// 		// alert(imgs[i].height());
// 		 var w = imgs[i].width( );
// 		 var h = imgs[i].height();
// 		 alert(w+":"+h);
// 		 if(h< w && h < maxH){
// 		 	// img.css("height":maxH+"px","width":"auto");
// 		 }		
// 	}	
		
// }

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
	},function() {
		$(this).find("img").stop().animate({width:"100%"}, 1000);
	});
}

// 发起请求，判断当前用户是否登录
function getUser(argument) {
	$.ajax({
		url: 'data/userdata.json',
		type: 'post',
		dataType: 'json',
	})
	.done(function(data) {
		dealingUserData(data);
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
	
}

// 对后台返回的用户登录信息进行处理
function dealingUserData(data) {
	if(data[0].userId == null || data[0].userId == ''){
		var login = "<li><a href='login.html'><i class='fa fa-meh-o'> </i>登录</a></li>";
		var register = "<li><a target='_blank' href='register.html'><i class='fa fa-plus'> </i>注册</a></li>";
		$('#top-menu').append(login+register);
	}else{
		if(data[0].userName == null || data[0].userName == ''){
			var personal = "<li><a href='personal.html'><i class='fa fa-meh-o'> </i>个人中心</a></li>";
		}else{
			var personal = "<li><a href='personal.html'><i class='fa fa-meh-o'> </i>"+data[0].userName+"</a></li>";
		}
		$('#top-menu').append(personal);
	}
}

// 发起请求，获取后台数据
function getData() {
	$.ajax({
		url: 'data/index.json',
		type: 'post',
		dataType: 'json',
		// data: {param1: 'value1'},
	})
	.done(function(data) {
		setData(data);
		console.log("success");
	})
	.fail(function() {
		console.log("网页出错");
	})
	.always(function() {
		console.log("资料加载完成");
	});
	
}

//数据处理
function setData(data) {
	var ul = $(".tip-bg");
	$.each(data, function(index, val) {
		var imgPart = "<div class='img-part'><img src='"+val.src+"' alt='攻略一图片'/><h2 class='get'>查看攻略</h2></div> ";
		var textPart = "<div class='tip-text'><h3>"+val.h3+"</h3><h4>"+val.h4+"</h4></div>";
		var liPart = "<li class='tip-content'><a href='detail.html?essayId="+val.id+"'><div class='tip'>"+imgPart+textPart+"</div></a></li>";
		ul.append(liPart);
	});
	// 获取所有.tip下的图片，当加载完时，调用调整函数
	/*var tipImgs = $(".tip img");
	$.each(tipImgs, function(index, val) {
		 // val.onload = function{
		 // 	ajdustText();
		 // }
	});*/
}
