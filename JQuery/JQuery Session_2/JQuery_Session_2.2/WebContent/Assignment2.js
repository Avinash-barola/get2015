$(document).ready(init);

function init() {
	$('#employeeList').change(getEmployeeData);
}
function getEmployeeData() {
	var name = $("#employeeList").val();
	$.ajax({
		type : "GET",
		url : "EmployeeController",
		data : {
			name : name
		},
		datatype : "html",
		success : function(data) {
			$("#details").html(data);
		}
	});
}
