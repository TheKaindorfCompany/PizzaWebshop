var initialize;
var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var geocoder = new google.maps.Geocoder();
initialize = function () {
    var coords, map, mapOptions, marker, markerHome;
    var home =
    {
        lat: 47.05,
        lng: 15.27
    };
    geocoder.geocode({'address': $('#address .text').text()}, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            home = results[0].geometry.location;
            map.setCenter(home);
            markerHome = new google.maps.Marker({
                position: home,
                map: map,
                icon: 'resources/home.png'
            });
        } else {
            alert("Geocode was not successful for the following reason: " + status);
        }
    });

    coords = $('#restaurants option:selected').attr('data-coords').split(';');

    mapOptions = {
        zoom: 13,
        center: new google.maps.LatLng(coords[0], coords[1])
    };

    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

    var rendererOptions = {
        map: map,
        suppressMarkers: true
    };
    directionsDisplay = new google.maps.DirectionsRenderer(rendererOptions);

    marker = new google.maps.Marker({
        position: map.getCenter(),
        map: map,
        icon: 'resources/restaurants.png'
    });

    google.maps.event.addListener(marker, 'click', function () {
        map.setZoom(8);
        map.setCenter(marker.getPosition());
    });

    $('#restaurants').change(function () {
        var coords;
        var x, y;
        coords = $('#restaurants option:selected').attr('data-coords').split(';');
        x = parseFloat(coords[0]);
        y = parseFloat(coords[1]);
        map.setCenter({
            lat: x,
            lng: y
        });
        marker.setPosition({
            lat: x,
            lng: y
        });
        var request = {
            origin: new google.maps.LatLng(x, y),
            destination: home,
            provideRouteAlternatives: false,
            travelMode: google.maps.TravelMode.DRIVING
        };
        directionsService.route(request, function (result, status) {
            if (status == google.maps.DirectionsStatus.OK) {
                directionsDisplay.setDirections(result);
                $('.badge.duration').text(result.routes[0].legs[0].duration.text);
            }
        });
        $('.badge.duration').text('unknown');
    });
};

google.maps.event.addDomListener(window, 'load', initialize);