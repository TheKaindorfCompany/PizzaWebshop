<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <!--JQuery CDN-->
    <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <!-- Google Maps -->
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true"></script>

    <!-- Custom Map Js -->
    <script type="text/javascript" src="resources/map.js"></script>

    <!-- Custom Css -->
    <link rel="stylesheet" href="resources/map.css"/>

    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
</head>

<body>
<div class="container">
    <form>
        <h1>Order Process</h1>

        <div class="row">

            <div class="col-md-6">
                <label for="address">Address</label>
                <div class="row">
                    <div class="col-md-6">
                        <address id="address">
                            <!-- TODO: insert address from db -->
                            795 Folsom Ave, Suite 600<br>
                            San Francisco, CA 94107<br>
                        </address>
                    </div>
                    <div class="col-md-6">
                        <button type="button" class="btn btn-warning">Not your address?</button>
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <label for="restaurants">Restaurant</label>
                <select class="form-control" id="restaurants">
                    <!-- TODO: get data-coords from db -->
                    <option data-coords="47.04;15.27">Bread Zeppelin</option>
                    <option data-coords="48.04;15.27">Pita Pan</option>
                    <option data-coords="49.04;15.27">Thai Tanic</option>
                    <option data-coords="50.04;15.27">Lord of the Wings</option>
                    <option data-coords="51.04;15.27">Wok this way</option>
                    <option data-coords="52.04;15.27">Grillenium Falcon</option>
                </select>
            </div>
        </div>
        <div id="map-canvas"></div>
    </form>
</div>
</body>
</html>
