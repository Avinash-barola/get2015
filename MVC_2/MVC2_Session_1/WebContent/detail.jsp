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
		out.print("<table border='1' cellpadding='10'>");
		out.print("<tr><th>Name<th>Email<th>Id<th>Age<th>Registration Date</tr>");
		out.print("<tr>");
		out.print("<td>"+employee.getName());
		out.print("<td>"+employee.getEmail());
		out.print("<td>"+employee.getId());
		out.print("<td>"+employee.getAge());
		out.print("<td>"+employee.getRegistrationDate());
		out.print("</tr>");
		out.print("</table>");
	%>
</body>
</html>