<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="carDekho.css"></link>
<script type="text/javascript">
function isValid() {
	var id = document.getElementById("id").value;
	var pass = document.getElementById("pass").value;
	if(id != "admin@carDekho.com" && pass != "123") {
		document.getElementById("id").value = "";
		 document.getElementById("pass").value = "";
		alert("Wrong Id and Password");
		}
	else {
		location.href='adminHome.jsp';
	}
}
</script>
</head>
<body>
	<div class="leftContainer">
		<marquee direction="up" width="100%" height="100%">
			<img src="View/Images/smallcar.jpg" width="80px" height="100px">
		</marquee>
	</div>
	<div class="rightContainer2">
		<marquee direction="down" width="100%" height="100%">
			<img src="View/Images/advertisement.jpg" width="140px" height="150px">
			<img src="View/Images/ad2.jpg" width="200px" height="150px">
			<img src="View/Images/weloveads.jpg" width="200px" height="150px">
		</marquee>
	</div>
	<header>
		<h1>CarDekho.com
			<div class="headerImage">
				<img src="View/Images/car1.png" height="80px" width="80px"></img>
			</div>
		</h1>
	<p>one step ahead....</p>
	</header>
		<div class="bar">
			<a href="PageController?type=CarDekho">Home</a> 
			<a href="AvailableCarController">Search</a>
			<a href="PageController?type=login">Login</a>
	</div>
	<div class="anime">
		<img src="View/Images/car1.jpg" class="top"> 
		<img src="View/Images/car2.jpg" class=top>
	</div>
	<div class="rightContainer">
		<div class="exitingOffer">
			<h2>Today's Offer</h2>
			<img src="View/Images/audi8.jpg" width="100%" height="50%">
			<table>
				<tr>
					<td width="200px" height="40px">Brand</td>
					<td>Audi 8</td>
				</tr>
				<tr>
					<td height="40px"><font color="orange">Price*</font></td>
					<td><font color="orange">22.35L</font></td>
				</tr>
				<tr>
					<td>Launch Date</td>
					<td>12-October-15</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="footer">
		<a href="PageController?type=contactUs"><font color="black">About Us</font></a>
		<a href= "PageController?type=aboutUs" onclick="">&nbsp;&nbsp;<font color="black">Contact Us</font></a>
	</div>
</body>
</html>