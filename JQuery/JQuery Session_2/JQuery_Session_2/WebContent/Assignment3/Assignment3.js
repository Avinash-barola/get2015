$(function(){
    $("#start").click(function(){
    	$("div").animate({marginLeft:'+=200px'},"slow");
    });

    $("#back").click(function() {
    	$("div").animate({marginLeft:'-=200px'},"slow");
    });
    
    $("#stop").click(function() {
    	$("div").stop();
    });
    
    $("#left").click(function() {
    	$("div").animate({marginLeft:'-=50px'},"slow");
    });
    
    $("#right").click(function() {
    	$("div").animate({marginLeft:'+=50px'},"slow");
    });
    
    $("#top").click(function() {
    	$("div").animate({marginTop:'-=50px'},"slow");
    });
    
    $("#bottom").click(function() {
    	$("div").animate({marginTop:'+=50px'},"slow");
    });
});