var ViewLayer = function(cityA) {
    var city = cityA;
    var country = document.getElementsByClassName('photo');
    for (var i =0; i<country.length;i++) {
       	if(country[i].style.display === 'inline-block') {
    		country[i].style.display = 'none';
    	}
    }
	document.getElementById(city).style.display = 'inline-block';
}
