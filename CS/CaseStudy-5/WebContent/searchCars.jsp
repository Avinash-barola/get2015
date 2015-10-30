<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<script>
	function validate() {
		if(document.getElementById("make").value == "Select Make") {
			alert("Please Select A Valid Make");
			return false;
		}
		else {
			return true;
		}
	}
</script>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="availableCars.css"></link>
<title>Insert title here</title>
</head>
<body>
	<header><h1>Search Your Car</h1></header>
	<div class="anime">
	<marquee direction="left" width="100%" height="100%"><img src="View/Images/searchCarImage.jpg" width="300px" height="200px"></marquee>
	</div>
	<form action = SearchedCarController>
	<div class="searchBox">
	<h1 style="margin-left:40px ">Search By Make</h1>
			<div class="margin"></div>
				<select class="leftSpace" id="make" onchange="setModals()" name = make><option>Select Make</option>
				<%
					List<String> makeList = (List<String>)request.getAttribute("makeList");
				if(makeList.size()>0) {
					Iterator<String> makeListIterotor = makeList.iterator();
					while(makeListIterotor.hasNext()) {
						String make = makeListIterotor.next();
						out.print("<option value='"+make+"'>"+make+"</option>");
					}
				}
				%>
				</select>
				<input type="submit" style="margin-left: 120px ;margin-top: 20px;" onclick="return validate()" value = "Search">
				<%
					if(makeList.size() == 0) {
						out.println("<div class='messege'><br><p>No cars Available now new cars will be added soon:</p></div>");
					}	
				%>
	</div>
	</form>
</body>
</html>
