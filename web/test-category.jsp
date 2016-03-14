<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Proco | List of All Questions for a Certain Category</title>
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-old-ie-min.css">
    <![endif]-->
    <!--[if gt IE 8]><!-->
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-min.css">
    <!--<![endif]-->
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
<table class="pure-table">
    <thead>
    <tr>
        <th>Number</th>
        <th>Category</th>
        <th>Level</th>
        <th>Question</th>
        <th>Answer</th>
    </tr>
    <tbody>
    <c:forEach items="${questionsCategory}" var="question">
        <tr>
            <td>${question.questionId}</td>
            <td>${question.category}</td>
            <td>${question.level}</td>
            <td>${question.inquiry}</td>
            <td>${question.answer}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
