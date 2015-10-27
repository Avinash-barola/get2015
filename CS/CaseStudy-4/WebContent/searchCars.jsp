
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
<form action = SearchedCarController>
	<div class="heading"><h1>Available Cars</h1></div>
	<div class="searchBox">
		<header>
			<h2>Search</h2>
			<p>Your New Car Is Here</p>
			<div class="margin"></div>
				<select class="leftSpace" id="make" onchange="setModals()" name = make><option>Select Make</option>
				<%
					List<String> makeList = (List<String>)request.getAttribute("makeList");
					Iterator<String> makeListIterotor = makeList.iterator();
					while(makeListIterotor.hasNext()) {
						String make = makeListIterotor.next();
						out.print("<option value='"+make+"'>"+make+"</option>");
					}
				%>
				</select>
				<input type="submit" style="margin-left: 120px ;margin-top: 20px;" onclick="return validate()" value = "Search"></button>
		</header>
	</div>
	</form>
</body>
</html>
