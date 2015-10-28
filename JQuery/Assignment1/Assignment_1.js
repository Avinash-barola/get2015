function button1Function() {
	document.getElementById("span").style.visibility = "visible";
	document.getElementById("button3").innerHTML='Hide';
}

function button2Function() {
	document.getElementById("span").style.visibility = "hidden";
	document.getElementById("button3").innerHTML='Show';
}

function button3Function() {
	if(document.getElementById("button3").innerHTML=='Hide') {
		button2Function();
	}
	else if(document.getElementById("button3").innerHTML=='Show'){
		button1Function();
	}
}