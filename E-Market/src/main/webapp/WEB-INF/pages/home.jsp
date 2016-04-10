<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>E-market</title>
    <script src="resources/vendor/js/jquery-2.2.2.js" type="application/javascript"></script>
    <script src="resources/custom/js/CategoryJS.js" type="application/javascript"></script>
</head>
<body>
Some boilerplate text :)
<br/>
<br/>
<br/>
<table id="categories_table" border="1">
    <thead>
    <tr>
        <th>Body type</th>
        <th>Colour</th>
        <th>Engine capacity</th>
        <th>Engine volume</th>
        <th>Max speed</th>
    </tr>
    </thead>
    <tbody id="categoriesTableBody">

    </tbody>
</table>
<br/>
<br/>
<br/>
<table id="products_by_category">
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
</body>
</html>