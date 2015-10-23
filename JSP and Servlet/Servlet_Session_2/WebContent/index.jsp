<!DOCTYPE HTML>
<HTML>
<head>
<link rel="stylesheet" href="registration.css" type="text/css">
<script type="text/javascript" src = "registration.js">
</script>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form name="registration" action="Registration">
		<div class="container">
			<div class="header">Registration</div>
			<div class="content">
				<table cellspacing="15">
					<tr align="right">
						<td>*First Name :</td>
						<td><input type="text" id="fname"
							placeholder="Enter First Name" name = "fname"></td>
					</tr>
					<tr align="right">
						<td>*Last Name :</td>
						<td><input type="text" id="lname" placeholder="Enter Last Name" name="lname"></td>
					</tr>
					<tr align="right">
						<td>*Password :</td>
						<td><input type="password" id="pass" placeholder="Enter password" name="pass"></td>
					</tr>
					<tr align="right">
						<td>*Re-enter Password :</td>
						<td><input type="password" id="repass" placeholder="Enter password" name="repass"></td>
					</tr>
					<tr align="right">
						<td>*Age :</td>
						<td><input type="number" id="age" placeholder="Enter Your Age" name ="age"></td>
					</tr>
					<tr align="right">
						<td>*Select Your State :</td>
						<td><select style="width: 175px" onchange="setCities()" id="state" name="state">
								<option>Select State</option>
								<option value="Rajasthan">Rajasthan</option>
								<option value="MP">Madhya Pradesh</option>
								<option value="UP">Uttar Pradesh</option>
								<option value="Maharastra">Maharastra</option>
						</select></td>
					</tr>
					<tr align="right" >
						<td>*Choose Your City : </td>
						<td>
								<select style="width: 175px" id="city" name="city">
								<option>Select City</option>
								</select>
						</td>
					</tr>
					<tr align="right">
						<td>*Address Line 1 : </td>
						<td><textarea rows="3" cols="22" placeholder="Enter Address Here"></textarea></td>
					</tr>
					<tr align="center">
						<td colspan="2"><input type="checkbox" onchange="enable()" id="cb">I accept all terms and condition</td>
					</tr>
					<tr align="center">
						<td colspan="2"><input type="submit" disabled id="submit" placeholder="Click"></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</HTML>