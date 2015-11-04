$(document).ready(function() {
	if($(window).width() <= 768 ) {
		alert($(window).width());
		("#span").apend("Grid On Xtra Small Screen");
	}
	else if( $(window).width() <= 992 &&  $(window).width() > 768 ) {
		alert($(window).width());
		("#span").apend("Grid On Small Screen");
	}
	else if( $(window).width() <= 1200 &&  $(window).width() > 992 ) {
		alert($(window).width());
		("#span").apend("Grid On Medium Screen");
	}
	else if( $(window).width() >1200) {
		alert($(window).width());
		("#span").apend("Grid On Large Screen");
	}
});