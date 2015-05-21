<!DOCTYPE html>
<html>
<head lang="en">
    <title>Product Managment</title>
    <meta charset="UTF-8">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <title>Product Managment</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <script>
        //function that takes the ingredients list
        function getIngredients() {
            var url = "IngredientServlet?art=1";
            $.get(url, function(dat, status) {
                $('#tableProductList').html(dat);
            });
        }

        function addNewProduct() {
            var name = document.getElementById("prodName").value;
            var prize = document.getElementById("prodPrice").value;
            var amount = document.getElementById("prodAmount").value;

            var url = "IngredientServlet?art=2&name="+name+"&price="+prize+"&amount="+amount;

            $.get(url, function(dat, status) {
                $('#tableProductList').html(dat);
            });
        }

    </script>
</head>
<body onload="getIngredients()">
<ul class="nav nav-tabs">
    <li role="presentation"><a href="#">Home</a></li>
    <li role="presentation" class="active"><a href="#">Product Managment</a></li>
</ul>
<h1>Product Managment</h1>

<div class="col-sm-4">
    <table border="0">
        <tr>
            <td>
                <button class="btn" onclick="getIngredients()">Show Ingredients</button>
            </td>
            <td>
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for Restaurant" name="srch-term" id="srch-term">
                    <div class="input-group-btn">
                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                    </div>
                </div>
            </td>
            <td>
                <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collAddProd" aria-expanded="false" aria-controls="collapseExample">
                    Add Ingredient
                </button>
            </td>
        </tr>
    </table>

    <div class="collapse" id="collAddProd">
        <div class="well">
            <div class="row">
                <div class="col-lg-6">
                    <div class="input-group">
                        <label>Name of Product</label>
                        <input type="text" class="form-control" aria-label="" placeholder="Productname" id="prodName">
                    </div>
                    <div class="input-group">
                        <label>Price of Product</label>
                        <input type="text" class="form-control" aria-label="" placeholder="Price" id="prodPrice">
                    </div>
                    <div class="input-group">
                        <label>Amount of Product</label>
                        <input type="text" class="form-control" aria-label="" placeholder="Amount" id="prodAmount">
                    </div>

                    <div class="row">
                        <div class="col-lg-3">
                            <button id="btnAdd" class="btn btn-primary" onclick="addNewProduct()">Add</button>
                            <button id="btnCancel" class="btn btn-primary">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <table id="tableProductList" class="table">

    </table>



</div>



</body>
</html>