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
        <div class="page-header">
            <h1>Restaurants & Products
                <small>Order your Pizzas here</small>
            </h1>
        </div>

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

        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Distance & Details</h3>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-6 col-md-4">
                        <!-- TODO: calculate automatically via distance api -->
                        <ul class="list-group">
                            <li class="list-group-item active">
                                <span class="badge">3 km</span>
                                Bread Zeppelin
                            </li>
                            <li class="list-group-item">
                                <span class="badge">14 km</span>
                                Pita Pan
                            </li>
                            <li class="list-group-item">
                                <span class="badge">11 km</span>
                                Thai Tanic
                            </li>
                            <li class="list-group-item">
                                <span class="badge">22 km</span>
                                Lord of the Wings
                            </li>
                            <li class="list-group-item">
                                <span class="badge">17 km</span>
                                Wok this Way
                            </li>
                            <li class="list-group-item">
                                <span class="badge">14 km</span>
                                Grillenium Falcon
                            </li>
                        </ul>
                    </div>
                    <div class="col-sm-6 col-md-8">
                        <div class="media">
                            <div class="media-left">
                                <a href="#">
                                    <img class="media-object" src="resources/restaurants.png"/>
                                </a>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">Bread Zeppelin</h4>
                                Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                                laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                                architecto beatae vitae dicta sunt explicabo.
                            </div>
                        </div>
                        <hr/>
                        <div class="well">The estimated delivery time is <span class="badge">12 minutes</span>.</div>
                    </div>
                </div>
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">
                <!-- TODO: add restaurant name to title -->
                <h3 class="panel-title">Products</h3>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail">
                            <img src="http://placehold.it/350x200"/>

                            <div class="caption">
                                <h3>Thumbnail label</h3>

                                <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                                    laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                                    architecto beatae vitae dicta sunt explicabo.</p>

                                <p>
                                    Price <span class="badge">12,-</span>
                                    <a href="#" class="btn btn-default" role="button" style="float: right">
                                        <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
                                    </a>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail">
                            <img src="http://placehold.it/350x200"/>

                            <div class="caption">
                                <h3>Thumbnail label</h3>

                                <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                                    laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                                    architecto beatae vitae dicta sunt explicabo.</p>

                                <p>Price <span class="badge">12,-</span> <a href="#" class="btn btn-default"
                                                                            role="button" style="float: right"><span
                                        class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail">
                            <img src="http://placehold.it/350x200"/>

                            <div class="caption">
                                <h3>Thumbnail label</h3>

                                <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                                    laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                                    architecto beatae vitae dicta sunt explicabo.</p>

                                <p>Price <span class="badge">12,-</span> <a href="#" class="btn btn-default"
                                                                            role="button" style="float: right"><span
                                        class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
