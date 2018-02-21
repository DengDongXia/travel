$().ready(function($) {	
	getUser();   //获取用户是否登录的信息
	getData(1);	//获取第一页的数据
});

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

// 发起请求，判断当前用户是否登录
function getUser(argument) {
	$.ajax({
		url: 'http://localhost:8080/travel/user/isLogin',
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
		// console.log("complete");
	});
	
}

// 对后台返回的用户登录信息进行处理
function dealingUserData(data) {
	if(data.isLogin == false){
		var login = "<li><a href='login.html'><i class='fa fa-meh-o'> </i>登录</a></li>";
		var register = "<li><a target='_blank' href='register.html'><i class='fa fa-plus'> </i>注册</a></li>";
		$('#top-menu').append(login+register);
	}else{
		var personal = "<li><a href='personal.html'><i class='fa fa-meh-o'> </i>"+data.content.name+"</a></li>";
		personal += "<li><a href=''><i class='fa fa-sign-out'> </i>注销</a></li>";
		$('#top-menu').append(personal);
	}
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
	$.each(data.content, function(index, val) {
		var imgPart = "<div class='img-part'><img src='"+val.eassyPicture+"' alt='攻略一图片'/><h2 class='get'>查看攻略</h2></div> ";
		var textPart = "<div class='tip-text'><h3>"+val.eassyHeader+"</h3><h4>"+val.eassyContent+"</h4></div>";
		var liPart = "<li class='tip-content'><a href='detail.html?essayId="+val.eassyID+"'><div class='tip'>"+imgPart+textPart+"</div></a></li>";
		ul.append(liPart);
	});
	// 修改切换页面的按钮
	$('#switchPage').children().remove();  //移除原来的按钮
	// 首先判断是否插入上一页按钮
		var pageText = '';  //用于保存插入按钮的相关html
		if(nowPage != 1){
			pageText += "<span class='page' id='lastPage'>上一页</span>";
		}
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


/*以下为按钮切换页面*/

/*以上为按钮切换页面*/