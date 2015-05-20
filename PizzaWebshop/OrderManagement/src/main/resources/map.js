var initialize;
initialize = function () {
    var coords, map, mapOptions, marker, markerHome;

    coords = $('#restaurants option:selected').attr('data-coords').split(';');

    mapOptions = {
        zoom: 13,
        center: new google.maps.LatLng(coords[0], coords[1])
    };

    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

    marker = new google.maps.Marker({
        position: map.getCenter(),
        map: map,
        icon: 'resources/restaurants.png'
    });

    markerHome = new google.maps.Marker({
        position: {
            lat: 47.05,
            lng: 15.27
        },
        map: map,
        icon: 'resources/home.png'
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
    });
};

google.maps.event.addDomListener(window, 'load', initialize);