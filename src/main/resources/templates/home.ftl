<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Продажи</title>
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
                <a class="nav-link" href="./home">Продажи <span class="sr-only">(current)</span></a>
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
<div style="margin-top: 20px;">
<div class="out"  align="left">
    <div class="page-header">
        <h1>Продажи</h1>
    </div>
</div>
    <div class="bottom"> <a href="./addSale" class="btn btn-success"   role="button"><span style="margin-right: 5px;" class="glyphicon glyphicon-plus"></span>Новий запис</a></div>

    <table class="table table-striped table-hover table-condensed table-bordered">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Название</th>
        <th scope="col">Количество</th>
        <th scope="col">Сумма</th>
        <th scope="col">Покупатель</th>
        <th scope="col">Продавец</th>
        <th scope="col">Дата</th>
        <th scope="col">Операции</th>
    </tr>
    </thead>
    <tbody>
    <#list model["saleList"] as sale>
    <tr>
        <th scope="row">${sale_index + 1}</th>
        <td>${sale.name}</td>
        <td>${sale.qty}</td>
        <td>${sale.sum}</td>
        <td>${sale.buyer}</td>
        <td>${sale.personal}</td>
        <td>${sale.dateTime}</td>
        <td align="right" class="warning">
            <a href="./updateSale?id=${sale.saleId}" class="btn btn-xs btn-warning"  role="button"><span style="margin-right: 5px"></span>Редагувати</a>
            <a href="./deleteSale?id=${sale.saleId}" class="btn btn-xs btn-danger"  role="button"><span style="margin-right: 5px"></span>Видалити</a>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>