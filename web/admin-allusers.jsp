<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Proco | List of All Users</title>
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-old-ie-min.css">
    <![endif]-->
    <!--[if gt IE 8]><!-->
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-min.css">
    <!--<![endif]-->
    <link rel="stylesheet" href="../css/style.css" />
</head>
<body>
<a href="console"><button type="button" class="button-green pure-button">Admin Console</button></a>
<h1>All Users</h1>
<table class="pure-table pure-table-striped">
    <thead>
    <tr>
        <th>Action</th>
        <th>User ID</th>
        <th>User Name</th>
    </tr>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><a href="delete-user?id=${user.userId}">Delete</a></td>
            <td>${user.userId}</td>
            <td>${user.userName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
