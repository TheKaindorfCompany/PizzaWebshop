function calcDistance(origin, destination, outputDest) {

    var x, y;
    origin = origin.split(';');
    x = parseFloat(origin[0]);
    y = parseFloat(origin[1]);
    var service = new google.maps.DistanceMatrixService();
    origin = new google.maps.LatLng(x, y);
    service.getDistanceMatrix(
        {
            origins: [origin],
            destinations: [destination],
            travelMode: google.maps.TravelMode.DRIVING,
            avoidHighways: false,
            avoidTolls: false
        },
        callback
    );

    function callback(response, status) {
        if (status == "OK" && response.rows[0].elements[0].distance != null) {
            outputDest.innerHTML = response.rows[0].elements[0].distance.text;
        }
    }
}

function calcDuration(origin, destination, outputTime) {

    var x, y;
    origin = origin.split(';');
    x = parseFloat(origin[0]);
    y = parseFloat(origin[1]);
    var service = new google.maps.DistanceMatrixService();
    origin = new google.maps.LatLng(x, y);
    service.getDistanceMatrix(
        {
            origins: [origin],
            destinations: [destination],
            travelMode: google.maps.TravelMode.DRIVING,
            avoidHighways: false,
            avoidTolls: false
        },
        callback
    );

    function callback(response, status) {
        if (status == "OK") {
            outputTime.html(response.rows[0].elements[0].duration.text);
        } else {
            alert("Error: " + status);
        }
    }
}

$(function () {
    $(".distances li .badge ").each(function () {
        calcDistance($(this).attr("data-coords"), $('#address .text').text(), this);
    });
    calcDuration($(".distances li.active .badge").attr("data-coords"), $('#address .text').text(), $(".duration"));
});

$(document).load(function () {
    $('#restaurants').change();
})