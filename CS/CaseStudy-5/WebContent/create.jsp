<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="create.css"></link>
<script type="text/javascript">
function validate() {
	if(document.getElementById("createdBy").value == "") {
		alert("Created By cant be empty");
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
	else if(document.getElementById("time").value=="") {
		alert("Created Time can't be empty");
		return false;
	}
	else {
		
		return true;
	}
}
</script>
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>
			<div class="headerImage">
				<img src="View/Images/car1.png" height="80px" width="80px"></img>
			</div>Create A New Car
		</h1>
	</header>
	<div class = "bar">
		<a href=PageController?type=logOut>logout</a>
		<a href=AvailableCarController>search</a>
		<a href=PageController?type=adminHome>Home</a>
	</div>
	<div class = "tableContainer">
		<form name="createController" action="CreateController">
			<table>
				<tr>
					<th>Attribute</th><th>Value</th>
				</tr>
				<tr>
					<td>Created_By</td>
					<td ><input type="text" placeholder="Enter Make" id = "createdBy" name ="createdBy"></td>
				</tr>
				<tr>
					<td>Make</td>
					<td ><input type="text" placeholder="Enter Make" id = "make" name ="make"></td>
				</tr>
				<tr>
					<td>Model</td>
					<td><input type="text" placeholder="Enter Model" id = "model" name ="model"></td>
				</tr>
				<tr>
					<td>EngineInCC</td>
					<td><input type="number" placeholder="Enter EngineInCC" id = "engine" name ="engineInCC"></td>
				</tr>
				<tr>
					<td>Fuel Capacity</td>
					<td><input type="number" placeholder="Enter Fuel Capacity" id = "fcapacity" name ="fuelCapacity"></td>
				</tr>
				<tr>
					<td>Milage</td>
					<td><input type="number" placeholder="Enter Milage" id = "milage" name ="milage"></td>
				</tr>
				<tr>
					<td>Ex-ShowRoom Price</td>
					<td><input type="number" placeholder="Enter Ex-ShowRoom Price" id = "showroomprice" name ="showRoomPrice"></td>
				</tr>
				<tr>
					<td>Road Tax</td>
					<td><input type="number" placeholder="Enter Road Tax" id = "tax" name ="tax"></td>
				</tr>
				<tr>
					<td>Created Time</td>
					<td><input type="date" placeholder="Enter Created Time" id = "time" style="width: 170px;" name ="createdTime"></td>
				</tr>
				<tr>
					<td>AC</td>
					<td><input type="checkbox" id = "ac"  name ="ac" value="ac"></td>
				</tr>
				<tr>
					<td>Accessory Kit</td>
					<td><input type="checkbox" id = "ak"  name ="ak" value = "ak"></td>
				</tr>
				<tr>
					<td>Power Steering</td>
					<td><input type="checkbox" id = "ps"  name ="ps" value = "ps"></td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit" onclick="return validate()">Create</button></td>
				</tr>
				<tr>
					<td colspan="2">${message}</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>