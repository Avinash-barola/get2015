
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="CSS/registration.css" rel="stylesheet">
		<script src ="javascript.js" type="text/javascript" >
		</script>
		<title>
		Metacube Software Pvt. Ltd.
		</title>
	</head>
	<body>
		<header>MetaCube</header>
		<div class="bar"><a href="Controller?type=Home">Home</a>&nbsp;&nbsp;<a href="Controller?type=ListEmployee">Employee List</a></div>
		<form action="Registration">
		<table cellpadding="10">
			<tr>
				<td>${message}</td>
			</tr>
			<tr>
				<td>Name : </td><td><input type="text" placeholder="Enter Name Here" name="name" required="required"></td>
			</tr>
			<tr>
				<td>Email : </td><td><input type="text" placeholder="Enter Email Here"  name="email" required="required"></td>
			</tr>
			<tr>
				<td>ID : </td><td><input type="number" placeholder="Enter ID Here" name="id" required="required"></td>
			</tr>
			<tr>
				<td>Age : </td><td><input type="number" placeholder="Enter Age Here" name="age" required="required"></td>
			</tr>
			<tr>
				<td>Date : </td><td><input type="date" placeholder="Enter Date Here" name="date" required="required"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"></td>
			</tr>
		</table>
		</form>
	</body>
</html>