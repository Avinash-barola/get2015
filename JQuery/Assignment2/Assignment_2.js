$(document).ready(function() {
	$("#button1").click(function() {
		$("#span").show();
		$("#button3").html("Hide");
	});
	$("#button2").click(function() {
		$("#span").hide();
		$("#button3").html("Show");
	});
	$("#button3").click(function () {
	   if( $("#button3").html()=="Hide") {
		   $("#button2").click();
	   }
	   else if($("#button3").text()=="Show") {
		   $("#button1").click();
	   }
	});
});

