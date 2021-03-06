<!DOCTYPE html>
<html>
<head lang="en">
    <title>Product Managment</title>
    <meta charset="UTF-8">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
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
                $('#tableIngredientList').html(dat);
            });
        }

        function addNewProduct() {
            var name = document.getElementById("prodName").value;
            var prize = document.getElementById("prodPrice").value;
            var amount = document.getElementById("prodAmount").value;

            if (name == "") {
                alert("NO name!");
            }
            else if (prize == "") {
                alert("No Price");
                return null;
            }
            else if (amount == "") {
                alert("No amount!");
                return null;
            }
            var url = "IngredientServlet?art=2&name="+name+"&price="+prize+"&amount="+amount;

            $.get(url, function(dat, status) {
                $('#tableIngredientList').html(dat);

                $('#prodName').val("");
                $('#prodAmount').val("");
                $('#prodPrice').val("");
            });
        }

        function editIngredient(name) {
            var elements = document.getElementsByName(name);
            for (var i=0; i < elements.length; i++) {
                elements[i].readOnly = false;
            }
            $('#btn'+name).html("Speichern");
            var index = document.getElementById("btn"+name).name;
            $('#btn'+name).attr("onClick", "onBearbeiten('" + name +"', '"+index+"')");
        }

        function onBearbeiten(name, index) {
            var id = index.split(" ")[1];
            var name = document.getElementById('inp ' + id + ' Name').value;
            var price = document.getElementById('inp ' + id + ' Price').value;

            var url = "IngredientServlet?art=3&name="+name+"&price="+price + "&index="+index;
            $.get(url, function(data, status) {
                var elements = document.getElementsByName(name);
                for (var i=0; i < elements.length; i++) {
                    elements[i].readOnly = true;
                }
                $('#divStatus').html('<div class="alert alert-success" id="divSuccessAnzeige" role="alert">Erfolgreich upgedatet</div>');
                setTimeout(function()
                {$('#divSuccessAnzeige').remove()}
                        , 4000);
                $('#btnTest').html("Bearbeiten");
            });
        }

        function erhoeheMenge(id) {
            var newAmount = window.prompt('How many new ingredients did you buy/consumed (- for fewer ingredients)?');
            var url = "IngredientServlet?art=5&id="+id+"&amount="+newAmount;

            $.get(url, function(data, status) {
               $('#tableIngredientList').html(data);

                setTimeout(function()
                        {$('#divSuccessAnzeige').remove()}
                        , 4000);
            });
        }
    </script>
</head>
<body onload="getIngredients()">
<ul class="nav nav-tabs">
    <li role="presentation"><a href="#">Home</a></li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Product Managment <span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu">
            <li><a href="index.jsp" class="active">Ingredients</a></li>
            <li><a href="ProductManagment.jsp">Produtcts</a></li>
        </ul>
    </li>
</ul>
<div id='divStatus'></div>
<h1>Product Managment</h1>

<div class="col-sm-4">
    <table border="0">
        <tr>
            <td>
                <button class="btn" onclick="getIngredients()">Show Ingredients</button>
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
                        <label>Name of Ingredient</label>
                        <input type="text" class="form-control" aria-label="" placeholder="Ingredient Name" id="prodName">
                    </div>
                    <div class="input-group">
                        <label>Price of Ingredient</label>
                        <input type="text" class="form-control" aria-label="" placeholder="Price" id="prodPrice">
                    </div>
                    <div class="input-group">
                        <label>Amount of Ingredient</label>
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

    <table id="tableIngredientList" class="table">

    </table>



</div>



</body>
</html>