<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AccessDenied page</title>
    <script src="resources/vendor/js/bootstrap.js"></script>
    <link href="resources/vendor/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<h4>
    Dear <strong>${user}</strong>, You are not authorized to access this page. Please
    <a href="<c:url value="/logout" />">logout</a></h4>
</body>
</html>