$().ready(function() {
	getUser();   //获取用户是否登录的信息
	startEdit();  //设置iframe为可编辑的函数
});

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
		var personal = "<li><a href='personal.html'><i class='fa fa-meh-o'> </i>"+data[0].userName+"</a></li>";
		$('#top-menu').append(personal);
}

function startEdit(){
        var editor = document.getElementById("input-iframe");
        // var editor = $("#input-iframe");  //此语句不起效，不知为何
        editor.contentWindow.document.designMode = "on";

}

$(document).change(function(event) {
	alert();
	var editorText = editor.contentWindow.document.body.innerHTM;
        alert(editorText);
        	$("#input-area").text(editorText);
});


/*$('#input-iframe').contents().find("body").change(function(event) {
	alert();
	var editorText = editor.contentWindow.document.body.innerHTM;
        alert(editorText);
        	$("#input-area").text(editorText);
});*/

$(function(){
    $("#myIframeId").on("load", function(event){
        $("body",this.contentDocument).focus(function(){
            alert("你倒是给点反应啊....");
        });
    });
});

//点击发表攻略按钮时触发事件
$('#send').click(function(event) {
	alert($('#input-iframe').contents().find("body").html());
	var inputContent = $('#input-iframe').contents().find("body").html();
	$('#input-area').val(inputContent);


});