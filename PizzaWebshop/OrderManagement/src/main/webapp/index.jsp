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

    <!-- calculate distance-->
    <script type="text/javascript" src="resources/distance.js"></script>

    <!-- change selection-->
    <script type="text/javascript" src="resources/selection.js"></script>
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
                            <span style="display:none" class="text">795 Folsom Ave, Suite 600 San Francisco, CA 94107</span>
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
                    <option data-coords="33.026994;-96.839671">Bread Zeppelin</option>
                    <option data-coords="1.283949;103.858846">Pita Pan</option>
                    <option data-coords="38.908155;-77.032382">Thai Tanic</option>
                    <option data-coords="-27.504370;153.099889">Lord of the Wings</option>
                    <option data-coords="34.139366;-117.575128">Wok this Way</option>
                    <option data-coords="36.067311;-94.165156">Grillenium Falcon</option>
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
                        <ul class="list-group distances">
                            <li class="list-group-item active">
                                <span class="badge" data-coords="33.026994;-96.839671">unknown</span>
                                <span class="text">Bread Zeppelin</span>
                            </li>
                            <li class="list-group-item">
                                <span class="badge" data-coords="1.283949;103.858846">unknown</span>
                                <span class="text">Pita Pan</span>
                            </li>
                            <li class="list-group-item">
                                <span class="badge" data-coords="38.908155;-77.032382">unknown</span>
                                <span class="text">Thai Tanic</span>
                            </li>
                            <li class="list-group-item">
                                <span class="badge" data-coords="-27.504370;153.099889">unknown</span>
                                <span class="text">Lord of the Wings</span>
                            </li>
                            <li class="list-group-item">
                                <span class="badge" data-coords="34.139366;-117.575128">unknown</span>
                                <span class="text">Wok this Way</span>
                            </li>
                            <li class="list-group-item">
                                <span class="badge" data-coords="36.067311;-94.165156">unknown</span>
                                <span class="text">Grillenium Falcon</span>
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
                                <!-- TODO: always select the right restaurant -->
                                <h4 class="media-heading">Bread Zeppelin</h4>
                                Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                                laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                                architecto beatae vitae dicta sunt explicabo.
                            </div>
                        </div>
                        <div class="media">
                            <div class="media-left">
                                <a href="#">
                                    <img class="media-object" src="resources/restaurants.png"/>
                                </a>
                            </div>
                            <div class="media-body">
                                <!-- TODO: always select the right restaurant -->
                                <h4 class="media-heading">Pita Pan</h4>
                                Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                                laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                                architecto beatae vitae dicta sunt explicabo.
                            </div>
                        </div>
                        <div class="media">
                            <div class="media-left">
                                <a href="#">
                                    <img class="media-object" src="resources/restaurants.png"/>
                                </a>
                            </div>
                            <div class="media-body">
                                <!-- TODO: always select the right restaurant -->
                                <h4 class="media-heading">Thai Tanic</h4>
                                Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                                laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                                architecto beatae vitae dicta sunt explicabo.
                            </div>
                        </div>
                        <div class="media">
                            <div class="media-left">
                                <a href="#">
                                    <img class="media-object" src="resources/restaurants.png"/>
                                </a>
                            </div>
                            <div class="media-body">
                                <!-- TODO: always select the right restaurant -->
                                <h4 class="media-heading">Lord of the Wings</h4>
                                Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                                laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                                architecto beatae vitae dicta sunt explicabo.
                            </div>
                        </div>
                        <div class="media">
                            <div class="media-left">
                                <a href="#">
                                    <img class="media-object" src="resources/restaurants.png"/>
                                </a>
                            </div>
                            <div class="media-body">
                                <!-- TODO: always select the right restaurant -->
                                <h4 class="media-heading">Wok this Way</h4>
                                Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                                laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                                architecto beatae vitae dicta sunt explicabo.
                            </div>
                        </div>
                        <div class="media">
                            <div class="media-left">
                                <a href="#">
                                    <img class="media-object" src="resources/restaurants.png"/>
                                </a>
                            </div>
                            <div class="media-body">
                                <!-- TODO: always select the right restaurant -->
                                <h4 class="media-heading">Grillenium Falcon</h4>
                                Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                                laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                                architecto beatae vitae dicta sunt explicabo.
                            </div>
                        </div>
                        <div class="media">
                            <div class="media-left">
                                <a href="#">
                                    <img class="media-object" src="resources/restaurants.png"/>
                                </a>
                            </div>
                            <div class="media-body">
                                <!-- TODO: always select the right restaurant -->
                                <h4 class="media-heading">Bread Zeppelin</h4>
                                Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                                laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                                architecto beatae vitae dicta sunt explicabo.
                            </div>
                        </div>
                        <hr/>
                        <div class="well">The estimated delivery time from "Bread Zeppelin" to your location is <span
                                class="badge duration">unknown</span>.
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="panel panel-default" id="products">
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
                                <h3>Product 1</h3>

                                <p>
                                    Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                                    laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                                    architecto beatae vitae dicta sunt explicabo.
                                </p>

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
                                <h3>Product 2</h3>

                                <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                                    laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                                    architecto beatae vitae dicta sunt explicabo.</p>

                                <p>Price <span class="badge">13,-</span> <a href="#" class="btn btn-default"
                                                                            role="button" style="float: right"><span
                                        class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail">
                            <img src="http://placehold.it/350x200"/>

                            <div class="caption">
                                <h3>Product 3</h3>

                                <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                                    laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                                    architecto beatae vitae dicta sunt explicabo.</p>

                                <p>Price <span class="badge">12,-</span> <a href="#" class="btn btn-default"
                                                                            role="button" style="float: right"><span
                                        class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Shopping Cart</h3>
            </div>
            <div class="panel-body">
                <table class="table">
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Number</th>
                        <th>Price</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Product 1</td>
                        <td>2</td>
                        <td>24,-</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Product 2</td>
                        <td>1</td>
                        <td>13,-</td>
                    </tr>
                    <tr style="font-weight: bold">
                        <td>Total</td>
                        <td></td>
                        <td></td>
                        <td>37,-</td>
                    </tr>
                </table>
            </div>
        </div>
    </form>
</div>
</body>
</html>
