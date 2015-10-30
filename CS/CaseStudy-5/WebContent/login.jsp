<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function validate()
{
	var email = document.getElementById("email");
	var password = document.getElementById("pass");
	  if(email.value.trim() == "") {
		  alert("Email Cant be Empty.");
		  return false;
	  }
	  else if(password.value.trim() == "" || password.value.length<8) {
		  alert("Password Cant be Empty or less then 8 character.");
		  return false;
	  }
	  else {
			return true;
	  }
}
  
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="carDekho.css"></link>
<title>Insert title here</title>
</head>
<body>
<form name="login" action="AdminLogInController" method = "post">
<div class = "loginbody">
	<div class = "loginheader">
		<h1>
			Admin Log-in
			<div class="headerImage">
				<img src="View/Images/car1.png" height="80px" width="80px"></img>
			</div>
		</h1>
	</div>
	<div class="logIn">
			<h1>Log-In</h1>
			<table class="table">
			<tr><td colspan="2">${message}</td></tr>
				<tr>
					<td>login-id:</td>
					<td height="40px"><input type="text" style="width: 150px" id = "email" name ="email"></td>
				</tr>
				<tr>
					<td>password:</td>
					<td><input type="password" style="width: 150px" id = "pass" name = "password"></td>
					<td>&nbsp;<input type="submit" style="color: blue;width: 70px;" value="Log In" onclick="return validate()"/></td>
				</tr>
			</table>
		</div>
		</div>
		</form>
</body>
</html>