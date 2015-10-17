<%@page import="model.Employee"%>
<%@page import="helper.EmployeeCache"%>
<%@page import="java.util.*"%>
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
		out.print("<table border='1' cellpadding='10'>");
		out.print("<tr><th>Name<th>Email<th>Id<th>Details<th>Edit</tr>");
		List<Employee> employeeList = (List<Employee>)request.getAttribute("employeeList");
		for( Employee employee : employeeList) {
			out.print("<tr>");
			out.print("<td>"+employee.getName());
			out.print("<td>"+employee.getEmail());
			out.print("<td>"+employee.getId());
			out.print("<td><a href='Controller?type=Detail&id="+employee.getId()+"'>View Details</a>");
			out.print("<td><a href='Controller?type=Edit&id="+employee.getId()+"'>Edit Details</a>");
			out.print("</tr>");
		}
		out.print("</table>");
	%>
</body>
</html>