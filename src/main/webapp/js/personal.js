$().ready(function() {
	getAuthorData();  //加载用户信息
	getEssay();    //加载该用户对应已发表的攻略
	// getQuestion(); //加载该用户对应已发表的特色定制
});

//加载用户信息,并进行插入页面
function getAuthorData() {
	$.getJSON('data/userdata.json', function(data) {
		// 图标菜单处更新
		uId = data[0].userId;
		var personal = "<li><a href='personal.html' class='active'><i class='fa fa-meh-o'> </i>"+data[0].userName+"</a></li>";
		$('#top-menu').append(personal);
		// 插入用户的资料
		$("#userPic").append("<img src='"+data[0].personPicture+"'>");
		$("#userInfo").append("<p class='name'>昵称："+data[0].userName+"</p><p class='integral'>积分：<span>"+data[0].integration+"</span></p>");
	});
}

// 对两个功能键进行判断
// 当点击发布的攻略按钮时，触发以下事件
$('#strategy').click(function(event) {
	$('#my-question').removeClass('choose');   //移除.lists中p对应的类choose
	$('#list-content').empty();  //删除id为list-content的元素的所有子节点
	$(this).addClass('choose');     //为当前点击的对象添加类choose
	getEssay(); //调用该函数，异步请求该用户已发表的攻略
});

// 当点击我的特色定制按钮时，触发以下事件
$('#my-question').click(function(event) {
	$('#strategy').removeClass('choose');   //移除.lists中p对应的类choose
	$('#list-content').empty();  //删除id为list-content的元素的所有子节点
	$(this).addClass('choose');     //为当前点击的对象添加类choose
	getQuestion(); //调用该函数，异步请求该用户已进行的特色定制
});

//加载该用户对应已发表的攻略
function getEssay() {
	$.getJSON('data/personalEssay.json', function(data) {
		$("#list-content").append("<div class='published contents' id='content'><h4 class='title'>已发布的攻略</h4><div class='custom-made-contents'><ul id='list-bg'></ul></div></div>");
		$.each(data, function(index, val) {
			 var link = "<a href='detail.html?essayId="+val.essayId+"'>";
			 var text = link+"<div class='content'><h4>"+val.essayContent+"</h4><p><span class='tag'>"+val.essayTag+"</span><span>"+val.essayTime+"</span></p></div></a>";
			 var other = "<div class='about'><p><span class='delete' id='delete'>删除</span><span>编辑</span></p><p>评论数: <span>"+val.essayCount+"</span></p></div>";
			 $("#list-bg").append("<li>"+text+other+"</li>");
		});
		// 当点击删除按钮时，触发删除事件,将要删除的列表的id传回后台

		$('.delete').click(function(event) {
			deleteObj($(this),'essayId');
		});
	});
}

//加载该用户对应已发表的特色定制
function getQuestion() {
	$.getJSON('data/personalQuestion.json', function(data) {
		$("#list-content").append("<div class='published contents' id='question'><h4 class='title'>我的特色定制</h4><div class='custom-made-contents'><div id='add' class='add-custom-made' title='新增特色定制'></div><ul id='list-bg'></ul></div></div>");
		$.each(data, function(index, val) {
			 var link = "<a href='strategy-detail.html?questionId="+val.questionId+"'>";
			 var text=link+"<div class='content'><h4>"+val.questionHeader+"</h4><h5>"+val.questionContent+"</h5></div></a>";
			 var other = "<div class='about'><p><span class='delete' id='delete'>删除</span><span>编辑</span></p><p>回答数: <span>"+val.questionCount+"</span></p><p>"+val.questionTime+"</p></div>";
			 $("#list-bg").append("<li>"+text+other+"</li>");
		});
		// 当点击新增特色定制按钮时，弹出输入遮罩层界面,该代码需放在被处理页面异步加载并渲染完成之后
		$('#add').click(function(event) {
			$('#custom-made-question').show();
		});
		// 当点击遮罩层时，遮罩层隐藏起来
		$('#custom-made-question').click(function(event) {
			$(this).hide();
		});
		// 当点击遮罩层中的表单部分时，遮罩层冒泡事件失效
		$('#form-bg').click(function(event) {
			event.stopPropagation();    
		});

		// 当点击删除按钮时，触发删除事件,将要删除的列表的id传回后台
		$('.delete').click(function(event) {
			deleteObj($(this),'questionId');
		});

	});
}

// 获取要跳转的地址对应的列表的id
function getId(obj,name) {
	var link = obj.parent().parent().parent().find('a').prop('href');  //获取要跳转的地址
	var items = link.split('?');     //将地址从?进行分开
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = items[1].match(reg);  //匹配目标参数
    var id = r[2];      //对应的id值  
    return id;
}

// 删除对应文章的函数
function deleteObj(obj,idType) {
	var id = getId(obj,idType);
			$.ajax({
				url: 'data/delete.json',
				// url: 'essay/delete.json',
				type: 'post',
				dataType: 'json',
				data: {id: id,userId:uId}
			})
			.done(function(data) {
				// 判断是否删除成功，如若成功则删除对应的文章
				if(data[0].result == "true"){
					obj.parent().parent().parent().remove();
				}else{
					alert("删除失败");
				}

			})
			.fail(function(data) {
				alert("删除失败");
			})
			.always(function() {
				console.log("complete");
			});
}