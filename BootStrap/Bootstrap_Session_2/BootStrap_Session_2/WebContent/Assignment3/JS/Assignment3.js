var i = 0;
var j = 0;
var movieData = [ {
					MovieTitle : 'PK',
					Genre : 'Comedy',
					Director : 'RajKumar'
				}, {
					MovieTitle : 'Shandar',
					Genre : 'Comedy',
					Director : 'RajKumar2'
				}, {
					MovieTitle : 'KKPK',
					Genre : 'Comedy',
					Director : 'RajKumar3'
				}, {
					MovieTitle : 'DDLJ',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'POTC',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'Dhoom 1',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'Dhoom 2',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'Dhoom 3',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'Golmal 1',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'Golmal 2',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'Golmal 3',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'Shapit',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'Raz',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'Hate Story',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'PKP',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'Bajarngi Bhaijan',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'Robot',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'Zazba',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'Gangajal',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'Baby',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'Holiday',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'Special 26',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				}, {
					MovieTitle : 'Gabbar is back',
					Genre : 'Comedy',
					Director : 'RajKumar4'
				} ];
function addTable() {
	$("#movieTable tr").remove();
	var table = $("#movieTable").children();
	table.append("<tr><td>MovieTitle</td><td>Genre</td><td>Director</td>");
	for(i=j;i<=(j+5);i++) {
		table.append('<tr><td>' + movieData[i].MovieTitle + '</td><td>'
				+ movieData[i].Genre + '</td><td>' + movieData[i].Director
				+ '</td></tr>');
	}
	j = 0;
	table.append("<tr><td colspan='3'><ul class ='pagination' id='page'><li><a href = '#' onclick='addTable()'>1</a></li><li><a href = '#' onclick='addTable2()'>2</a></li><li><a href = '#' onclick='addTable3()'>3</a></li><li><a href = '#' onclick='addTable4()'>4</a></li></ul></td></tr>");
}

function addTable2() {
	j = 5;
	addTable();
}

function addTable3() {
	j = 10;
	addTable();
}

function addTable4() {
	j = 15;
	addTable();
}

function search() {
	var table = "";
	table.html = "";
	table = $('#movieTable').children();
	var movieName = $.trim($('#searchMovie').val().toUpperCase());
	for (var i = 0; i < movieData.length; i++) {
		if (movieName == movieData[i].MovieTitle) {
			table.html('<tr><td>' + movieData[i].MovieTitle + '</td><td>'
					+ movieData[i].Genre + '</td><td>' + movieData[i].Director
					+ '</td></tr>');
			return;
		}
	}
	alert("No Movie");
}