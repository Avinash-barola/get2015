<%@page import="java.util.*"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="availableCars.css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	<%
		Map<Integer,Vehicle> carMap =(Map<Integer,Vehicle>)request.getAttribute("carMap");
	 	Iterator carMapIterator = carMap.entrySet().iterator();
	 	out.println("<tr><th>Vehicle_ID</th><th>Make</th><th>Model</th><th>Deatils</th></tr>");
	    while (carMapIterator.hasNext()) {
	        Map.Entry pair = (Map.Entry)carMapIterator.next();
	        Vehicle vehicle = (Vehicle)pair.getValue();
	        String make = vehicle.getMake();
	 	        out.println("<tr><td>"+pair.getKey() + "</td><td>" + vehicle.getMake()+"</td><td>" + vehicle.getModel()+"</td><td><a href = 'DetailController?vehicleID="+pair.getKey()+"'>Detail</td></tr>");
	    }
	%>
	</table>
</body>
</html>