<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <title>Registration page</title>
    <script src="resources/vendor/js/jquery-2.2.2.js" type="application/javascript"></script>
    <script src="resources/vendor/js/bootstrap.js"></script>
    <link href="resources/vendor/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<div class="container">
    <form:form method="POST" modelAttribute="user" action="registration.createnew" enctype="utf8" role="form-horizontal">

        <div class="form-group">
            <form:input type="text" path="username" id="username" class="form-control" placeholder="Enter username"/>
            <form:errors path="username"/>
        </div>

        <div class="form-group">
            <form:input type="text" path="email" id="email" class="form-control" placeholder="Enter email"/>
            <form:errors path="email"/>
        </div>

        <div class="form-group">
            <form:input type="text" path="password" id="password" class="form-control" placeholder="Enter password"/>
            <form:errors path="password"/>
        </div>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <button type="submit" class="btn btn-primary btn-block">Register</button>

    </form:form>
</div>
</body>

</html>