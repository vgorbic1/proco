<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Proco | Question deleted</title>
    <%@include file="includes/styles.jsp" %>
    <link rel="stylesheet" href="../css/style.css" />
</head>
<body>
<p class="success">Question was successfully deleted</p>
<a href="console"><button type="button" class="button-green pure-button">Admin Console</button></a>
<a href="question-add"><button type="button" class="pure-button pure-button-primary">Add Question</button></a>
<a href="questions-all"><button type="button" class="pure-button pure-button-primary">All Questions</button></a>
<%@include file="includes/footer.jsp" %>
</body>
</html>
