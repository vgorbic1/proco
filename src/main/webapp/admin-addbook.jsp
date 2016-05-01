<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Proco | Add new book</title>
    <%@include file="includes/styles.jsp" %>
    <link rel="stylesheet" href="../css/style.css" />
</head>
<body>
<article class="center">
<p>${message}</p>
<c:remove var="message" scope="session" />
<h1>Add Book</h1>
<form action="book-add-result" method="post" class="pure-form pure-form-stacked field-center">
    <label for="category">Category</label>
    <select name="category" id="category">
        <option value="Java">Java</option>
        <option value="JavaScript">JavaScript</option>
        <option value="PHP">PHP</option>
        <option value="SQL">SQL</option>
    </select>
    <label>ISBN 10 or ISBN 13</label>
    <input type="text" name="isbn" />
    <button type="submit" class="pure-button pure-button-primary">Save</button>
    <a href="books-all"><button type="button" class="pure-button pure-button-primary">Cancel</button></a>
</form>
    <p><a href="http://isbndb.com" target="_blank">ISBNdb</a> provides book information. Please check that the
    ISBNdb has registered the ISBN you are about to enter.</p>
</article>
<%@include file="includes/footer.jsp" %>
</body>
</html>