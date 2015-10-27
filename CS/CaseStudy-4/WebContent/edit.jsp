<%@page import="java.util.*"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="edit.css"></link>
<script type="text/javascript">
function validate() {
	if(document.getElementById("createdBy").value=="") {
		alert("Created By Cant be empty");
		return false;
	}
	else if(document.getElementById("make").value=="") {
		alert("Make can't be empty");
		return false;
	}
	else if(document.getElementById("model").value=="") {
		alert("Model can't be empty");
		return false;
	}
	else if(document.getElementById("engine").value=="") {
		alert("Engine In CC can't be empty");
		return false;
	}
	else if(document.getElementById("fcapacity").value=="") {
		alert("Fuel Capacity can't be empty");
		return false;
	}
	else if(document.getElementById("milage").value=="") {
		alert("Milage can't be empty");
		return false;
	}
	else if(document.getElementById("showroomprice").value=="") {
		alert("Show Room Price can't be empty");
		return false;
	}
	else if(document.getElementById("tax").value=="") {
		alert("Tax can't be empty");
		return false;
	}
	else if(document.getElementById("price").value=="") {
		alert("On Road Price can't be empty");
		return false;
	}
	else if(document.getElementById("time").value=="") {
		alert("Created Time can't be empty");
		return false;
	}
	else {
		alert("Car Edited Successfully.");
		return true;
	}
}
</script>
<title>Insert title here</title>
</head>
<body>
<form action="UpdateController">
<%!Vehicle vehicle = null; %>
	<header>Edit Car</header>
	<div class = "tableContainer">
		<table>
		<% 
		Map<Integer,Vehicle> carMap =(Map<Integer,Vehicle>)request.getAttribute("carMap");
	 	Iterator carMapIterator = carMap.entrySet().iterator();
 		Map.Entry pair = null;
    	while (carMapIterator.hasNext()) {
        	 pair = (Map.Entry)carMapIterator.next();
        	vehicle = (Vehicle)pair.getValue();
    	}
    	String isAC="",isPS="",isAK="";
    	if(((Car)vehicle).isAC()) {
    		//System.out.println("ACYESS"+((Car)vehicle).isAC());
    		isAC = "checked";
    	}
    	if(((Car)vehicle).isAccessoryKit()) {
    		//System.out.println("AKYESSS"+((Car)vehicle).isPowerSteering());
    		isAK = "checked";
    	}
    	if(((Car)vehicle).isPowerSteering()) {
    		//System.out.println("PSYESSS"+((Car)vehicle).isAccessoryKit());
    		isPS = "checked";
    	}
	 	out.print("<tr><td>Vehicle_ID</td><td><input type = 'text' readonly='readonly' name = 'vehicleID' value = "+pair.getKey()+"></input></td>");
	 	out.print("<tr><td>Make</td><td><input type = 'text' name = 'make' readonly='readonly' value = "+vehicle.getMake()+"></input></td>");
	 	out.print("<tr><td>Model</td><td><input type = 'text' name='model' readonly='readonly' value = "+vehicle.getModel()+"></input></td>");
	 	out.print("<tr><td>Created By</td><td><input type = 'text' name='createdBy' value = "+vehicle.getCreated_By()+"></input></td>");
	 	out.print("<tr><td>Created Time</td><td><input type = 'date' name='' value = "+vehicle.getCreated_Time()+"></input></td>");
	 	out.print("<tr><td>Engine In CC</td><td><input name = 'engineInCC' type = 'number' value = "+vehicle.getEnginInCC()+"></input></td>");
	 	out.print("<tr><td>Fuel Capacity</td><td><input name = 'fuelCapacity' type = 'number' value = "+vehicle.getFuelCapacity()+"></input></td>");
	 	out.print("<tr><td>Milage</td><td><input type = 'number' name = 'milage' value = "+vehicle.getMilage()+"></input></td>");
	 	out.print("<tr><td>Price</td><td><input type = 'number' name ='showRoomPrice' value = "+vehicle.getPrice()+"></input></td>");
	 	out.print("<tr><td>Road Tax</td><td><input type = 'number' name='tax'  value = "+vehicle.getRoadTax()+"></input></td>");
	 	out.print("<tr><td>Accessory Kit</td><td><input type='checkbox' name='ak'id = 'ak'  name ='ak' value = 'ak'"+isAK+"></td></tr>");
	 	out.print("<tr><td>Power Steering</td><td><input type='checkbox' name='ps' id = 'ps'  name ='ps' value = 'ps'"+isPS+"></td></tr>");
	 	out.print("<tr><td>AC</td><td><input type='checkbox' id = 'ac'  name ='ac' value = 'ac'"+isAC+"></td></tr>");
	  %>
	  	<tr><td colspan="2"><input type="submit" onclick="return validate()" value="Update"></td></tr>
		</table>
		<input type="checkbox" >
	</div>
	</form>
</body>
</html>