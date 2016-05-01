<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Proco | User deleted</title>
    <%@include file="includes/styles.jsp" %>
    <link rel="stylesheet" href="../css/style.css" />
</head>
<body>
<article class="center">
<p class="success">User was successfully deleted</p>
<a href="console"><button type="button" class="button-green pure-button">Admin Console</button></a>
<a href="users-all"><button type="button" class="pure-button pure-button-primary">All Users</button></a>
</article>
<%@include file="includes/footer.jsp" %>
</body>
</html>
