
var ViewLayerss = function(Reccity) {
    var recocity = Reccity;
    var reccountry = document.getElementsByClassName('reccity');
    for (var i =0; i<reccountry.length;i++) {
       	if(reccountry[i].style.display === 'inline-block') {
    		reccountry[i].style.display = 'none';
    	}
    }
	document.getElementById(recocity).style.display = 'inline-block';
}

var ViewLayersss = function(Explain) {
    var explaines = Explain;
    var explainnamess = document.getElementsByClassName('explain');
    for (var i =0; i<explainnamess.length;i++) {
       	if(explainnamess[i].style.display === 'inline-block') {
    		explainnamess[i].style.display = 'none';
    	}
    }
	document.getElementById(explaines).style.display = 'inline-block';
}

var ViewLayerssss = function(Explains) {
    var explainess = Explains;
    var explainss = document.getElementsByClassName('explains');
    for (var i =0; i<explainss.length;i++) {
       	if(explainss[i].style.display === 'inline-block') {
    		explainss[i].style.display = 'none';
    	}
    }
	document.getElementById(explainess).style.display = 'inline-block';
}
/*function initMap() {

            const map = new google.maps.Map(document.getElementById("map"), {
				mapId: "4d7ece8ee77fe4c0", 
                zoom: 9,
                center: { lat: 35.69762851732002, lng: 139.76252747648775 },
				panControl: false, 
  				zoomControl: false,
  				mapTypeControl: false,
 				scaleControl: false,
 				streetViewControl: false,
 				overviewMapControl: false
            });
            for (var i = 0; i < locations.length; i++) {
                var marker = new google.maps.Marker({
                    map: map,
                    label: locations[i].place,
                    position: new google.maps.LatLng(locations[i].lat, locations[i].lng),
                });
            }

        }
        const locations = [
            { place:"1", lat: 35.71511998200324, lng: 139.79663127499435 },
            { place:"2", lat: 37.547263, lng: 127.074181 },
        ];
       */