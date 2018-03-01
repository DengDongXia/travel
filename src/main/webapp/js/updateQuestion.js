$().ready(function() {
	getStatus();    //获取用户的登录状态
});

// 获取用户的登录状态
var userId;
function getStatus() {
	$.ajax({
		// url: "data/isLogin.json",
		url: 'http://localhost:8080/travel/user/isLogin',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		// data: JSON.stringify({}),
	})
	.done(function(data) {
		if(data.isLogin == false){
			window.location.href = 'http://localhost:8080/travel/login.jsp';
		}else{
			getQuestionData();   //获取该特色定制的内容
			userId = data.content.id;  //保存用户id
		}
	})
	.fail(function(data) {
		alert("获取该特色定制的内容出错");
	})
	.always(function() {
		// console.log("complete");
	});
}

//获取该特色定制的内容
function getQuestionData() {
	var id = getUrlQuestionId('questionId'); //获取该提问的id
	$.ajax({
		// url: "data/questionDetail.json",
		url: 'http://localhost:8080/travel/question/getDetail',
		type: 'post',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"questionID":id
		}),
	})
	.done(function(data) {
		// 将返回的内容添加到文本框中
		$('#questionTitle').val(data.questionHeader);
		$('#questionContent').val(data.questionContent);
	})
	.fail(function(data) {
		alert("获取该特色定制的内容出错");
	})
	.always(function() {
		// console.log("complete");
	});
}

//获取url中的参数
function getUrlQuestionId(name) {
   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
   var r = window.location.search.substr(1).match(reg);  //匹配目标参数
   if (r != null) return unescape(r[2]); return null; //返回参数值,即questionId的值
}


/*提交问题（特色定制）*/
$('#submitQuestion').click(function(event) {
	if($('#questionTitle').val() == '' || $('#questionContent').val() == ''){
		alert("请将要进行的特色定制的标题和内容均填上");
	}else{
		$.ajax({
			// url: 'data/updateQuestion.json',
			url: 'http://localhost:8080/travel/question/updateSave',
			type: 'post',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
				"userID":userId,
				"questionID": getUrlQuestionId('questionId'),
				"questionHeader":$('#questionTitle').val(),
				"context":$('#questionContent').val()
			}),
		})
		.done(function(data) {
			// 判断是否删除成功，如若成功则删除对应的文章
			if(data.questionUpdateSaveResult == true){
				alert("更新成功");
				window.location.href = 'http://localhost:8080/travel/personal.jsp';
			}else{
				alert("更新出错");
			}

		})
		.fail(function(data) {
			alert("更新出错");
		})
		.always(function() {
			// console.log("complete");
		});
	}
});
/*提交问题（特色定制）*/

