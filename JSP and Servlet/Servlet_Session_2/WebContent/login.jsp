<!DOCTYPE HTML>
<HTML>
<head>
<link rel="stylesheet" href="login.css" type="text/css">
<meta charset="ISO-8859-1">
<title>Log In</title>
</head>
<body>
	<form name="LogIn" action="LogIn">
		<div class="container">
			<div class="header">Log In</div>
			<div class="content">
				<table cellspacing="15">
					<tr align="right">
						<td>*User Name:</td>
						<td><input type="text" id="userName"
							placeholder="Enter User Name" name = "userName"></td>
					</tr>
					<tr align="right">
						<td>*Password :</td>
						<td><input type="password" id="pass" placeholder="Enter password" name="pass"></td>
					</tr>
					<tr>
						<td>${a}</td>
					</tr>
					<tr align="center">
						<td colspan="2"><input type="submit" id="submit"></td>
					</tr>
				</table>
				<a href="index.jsp">New User</a>
			</div>
		</div>
	</form>
</body>
</HTML>