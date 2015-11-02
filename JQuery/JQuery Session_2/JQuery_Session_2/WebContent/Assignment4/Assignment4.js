$(document).ready(function(){
	$("#name").change(function(){
		var text = "Name:"+$("#name").val();
		$('#name').css('background', 'yellow');
	       setTimeout(function () {
	           $('#name').css('background', 'white').focus();
	       }, 300);
		text +="<br>";
		$("div").append(text);
	});
	
	$("#age").change(function(){
		var text = "Age:"+$("#age").val();
		$('#age').css('background', 'yellow');
	       setTimeout(function () {
	           $('#age').css('background', 'white').focus();
	       }, 300);
		text +="<br>";
		$("div").append(text);
	});
	
	$("#address").change(function(){
		var text = "Address:"+$("#address").val();
		$('#address').css('background', 'yellow');
	       setTimeout(function () {
	           $('#address').css('background', 'white').focus();
	       }, 300);
		text +="<br>";
		$("div").append(text);
	});
});

