$().ready(function() {
	console.log($(document).html());
});

$("body").change(function(event) {
	alert();
	var editorText = editor.contentWindow.document.body.innerHTM;
        console.log(editorText);
        	parent.document.getElementById.text(editorText);
});