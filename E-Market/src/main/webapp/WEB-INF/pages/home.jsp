<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>E-market</title>
    <script src="resources/vendor/js/jquery-2.2.2.js" type="application/javascript"></script>
    <script src="resources/custom/js/CategoryJS.js" type="application/javascript"></script>
    <script src="resources/vendor/js/bootstrap.js"></script>
    <link href="resources/vendor/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
Some boilerplate text :)
<br/>
<br/>
<br/>
<div class="col-sm-2">
    <p>Select category of body types:</p>
    <table id="categories_table" border="2">
        <tbody id="categoriesTableBody">
        </tbody>
    </table>
</div>
<br/>
<br/>
<br/>
<div class="col-sm-10">
    <table id="products_by_category" border="2">
        <thead>
        <tr>
            <th>Model</th>
            <th>Year</th>
            <th>Mileage</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody id="products_by_category_id"></tbody>
    </table>
</div>
</body>
</html>