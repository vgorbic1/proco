<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Proco | List of All Books</title>
    <%@include file="includes/styles.jsp" %>
    <link rel="stylesheet" href="../css/style.css" />
</head>
<body>
<article class="center">
    <a href="console"><button type="button" class="button-green pure-button">Admin Console</button></a>
    <a href="book-add"><button type="button" class="pure-button pure-button-primary">Add Book</button></a>
    <h1>All Books</h1>
    <table class="pure-table pure-table-striped table-center">
        <thead>
        <tr>
            <th>Action</th>
            <th>Category</th>
            <th>ISBN</th>
        </tr>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>
                    <a href="book-delete?id=${book.bookId}">Delete</a>
                </td>
                <td>${book.category}</td>
                <td>${book.isbn}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</article>
<%@include file="includes/footer.jsp" %>
</body>
</html>