<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="adminHome.css"></link>
</head>
<body>
	<header>
		<h1>
			Admin Home
			<div class="headerImage">
				<img src="View/Images/car1.png" height="80px" width="80px"></img>
			</div>
		</h1>
	</header>
	<div class="bar">
		<a href="PageController?type=adminHome">Home</a>
		<a href="AvailableCarController">Search</a> 
		<a href="PageController?type=createCar">Create</a>
		<a href="PageController?type=logout">Logout</a>
	</div>
	<div class="img">
		<table>
		<%
		String email = request.getAttribute("email").toString();
		out.print("<tr><td>E-mail:</td><td>"+ email+"</td></tr>");
		%>
		</table>
	</div>
	</body>
</html>