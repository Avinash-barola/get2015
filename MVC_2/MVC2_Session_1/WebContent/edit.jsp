<%@page import="model.Employee"%>
<%@page import="helper.EmployeeCache"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="CSS/registration.css" rel="stylesheet">
		<title>
		Metacube Software Pvt. Ltd.
		</title>
	</head>
<body>
	<header>MetaCube</header>
		<div class="bar"><a href="Controller?type=Home">Home</a>&nbsp;&nbsp;<a href="Controller?type=Registration">Registration</a></div>
	<%
		int id = Integer.parseInt(request.getAttribute("id").toString());
		EmployeeCache employeeCache = EmployeeCache.getInstance();
		Employee employee = employeeCache.getEmployeeForId(id);
		out.print("<form action = 'UpdateEmployee'>");
		out.print("<table border='1' cellpadding='10'>");
		out.print("<tr><td>Name<td><input type='text' name='name' value="+employee.getName()+">");
		out.print("<tr><td>Email<td><input type='text' name='email' value="+employee.getEmail()+">");
		out.print("<tr><td>Id<td><input type='Number' name='id' readonly value="+employee.getId()+">");
		out.print("<tr><td>Age<td><input type='Number' name='age' value="+employee.getAge()+">");
		out.print("<tr><td>Registration Date<td><input type='text' readonly name='date' readonly value='"+employee.getRegistrationDate()+"'>");
		out.print("<tr><td colspan='2' align='center'><input type='submit' value='Update'>");
		out.print("</table>");
		out.print("</form>");
	%>
</body>
</html>