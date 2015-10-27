<%@page import="java.util.*"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Detail.css"></link>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!Vehicle vehicle = null; %>
	<div class="image"><img src="View/Images/bmw1series.jpg" width="100%" height="100%"></div>
	<div class="detail"><h1>Details</h1>
	<table>
	 <tr>
	 <th>Make</th><th>Model</th><th>Engine In CC</th><th>Fuel Capacity</th><th>Milage</th><th>ex-Showroom Price</th><th>Edit</th>
	 </tr>
	 <%
		Map<Integer,Vehicle> carMap =(Map<Integer,Vehicle>)request.getAttribute("carMap");
	 	Iterator carMapIterator = carMap.entrySet().iterator();
 		Map.Entry pair = null;
 		System.out.println("A"+carMap.size());
    	while (carMapIterator.hasNext()) {
        	pair = (Map.Entry)carMapIterator.next();
        	vehicle = (Vehicle)pair.getValue();
    	}
	 	out.print("<tr><td>"+vehicle.getMake()+"</td><td>"+vehicle.getModel()+"</td><td>"+vehicle.getEnginInCC()+"</td><td>"+vehicle.getFuelCapacity()+"</td><td>"+vehicle.getMilage()+"</td><td>"+vehicle.getPrice()+"</td><td><a href = 'EditController?vehicleID="+pair.getKey()+"'>Edit</a></td></tr>");
	  %>
	  <a href="EditController">Edit</a>
	</table>
	<p></p>
	<div class = "box">
	<h1>Economy</h1>
	<table>
	<tr><td>Milage</td><td><%vehicle.getMilage(); %></td></tr>
	<tr><td>Service Cost</td><td>---</td></tr>
	</table>
	</div>
	<div class = "box">
	<h1>Performance</h1>
	<table>
	<tr><td>Engine</td><td><%vehicle.getEnginInCC(); %>></td></tr>
	<tr><td>BHP</td><td>148</td></tr>
	</table>
	</div>
	<div class = "box">
	<h1>Comfort</h1>
	<table>
	<tr><td>Power Steering</td><td><%((Car)vehicle).isPowerSteering(); %></td></tr>
	<tr><td>Rear AC vent</td><td><%((Car)vehicle).isPowerSteering(); %></td></tr>
	</table>
	</div>
	<div class = "box">
	<h1>Safty</h1>
	<table>
	<tr><td>Accessory Kit</td><td><%((Car)vehicle).isAccessoryKit(); %></td></tr>
	<tr><td>Driver Air Bag</td><td>--</td></tr>
	</table>
	</div>
	</div>
	<div class="slide">
	<marquee direction="left" width="100%" height="100%"><img src="View/Images/bmw1seriesslide.jpg" height="300px" border="40px"></marquee>
	</div>
</body>
</html>