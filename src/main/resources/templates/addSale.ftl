<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Новая продажа</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="./home">Sales accounting</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="./home">Продажи<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="products">Товары</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="suppliers">Поставщики</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="buyers">Покупатели</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="analytics">Аналитика</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<div style="margin-top: 20px;" class="container" align="center">
    <div class="out" align="center">
        <div class="page-header">
            <h1>Новая продажа</h1>
        </div>
    </div>

    <form name="sale" action="/addSale" method="post">

        <div style="width:500px; margin-top: 5px;'" class="form-group">
            <select class="form-control" id="buyer", name="buyer">
                <option  selected disabled value=''>Покупатель</option>
                <#list model["buyerList"] as buyer>
                    <option value="${buyer.buyerId}">${buyer}</option>
                </#list>
            </select>
        </div>

        <div style="width:500px; margin-top: 5px;'" class="form-group">
            <select class="form-control" id="personal", name="personal">
                <option  selected disabled value=''>Продавец</option>
                <#list model["personalList"] as personal>
                    <option value="${personal.personalId}">${personal}</option>
                </#list>
            </select>
        </div>

        <div style="width:500px; margin-top: 5px;'" class="form-group">
            <select class="custom-select" multiple id="products" name="products" size="6">
                <option selected disabled value=''>Товары</option>
                <#list model["productList"] as product>
                    <option value="${product.productId}">${product}</option>
                </#list>
            </select>
        </div>

        <div style = "margin-top: 5px;">
            <input type="submit" value="Принять" class="btn btn-success aligntop">
        </div>

        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</body>
</html>