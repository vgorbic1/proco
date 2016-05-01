<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Proco | List of All Users</title>
    <%@include file="includes/styles.jsp" %>
    <link rel="stylesheet" href="../css/style.css" />
</head>
<body>
<article class="center">
<a href="console"><button type="button" class="button-green pure-button">Admin Console</button></a>
<h1>All Users</h1>
<table class="pure-table pure-table-striped table-center">
    <thead>
    <tr>
        <th>Action</th>
        <th>User Name</th>
    </tr>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <c:choose>
                <c:when test="${user.userId == 1 || user.userId == 2}">
                    <td> - </td>
                </c:when>
                <c:otherwise>
                    <td><a href="delete-user?id=${user.userId}">Delete</a></td>
                </c:otherwise>
            </c:choose>
            <td>${user.userName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</article>
<%@include file="includes/footer.jsp" %>
</body>
</html>
