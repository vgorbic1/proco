<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Proco | List of All Questions</title>
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
<a href="question-add"><button type="button" class="pure-button pure-button-primary">Add Question</button></a>
<h1>All Questions</h1>
    <table class="pure-table pure-table-striped">
        <thead>
            <tr>
                <th>Action</th>
                <th>Number</th>
                <th>Category</th>
                <th>Level</th>
                <th>Question</th>
                <th>Answer</th>
            </tr>
        <tbody>
        <c:forEach items="${questions}" var="question">
            <tr>
                <td><a href="edit-question?id=${question.questionId}">Edit</a></td>
                <td>${question.questionId}</td>
                <td>${question.category}</td>
                <td>${question.level}</td>
                <td>${question.inquiry}</td>
                <td>${question.answer}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="question-add"><button type="button" class="pure-button pure-button-primary">Add Question</button></a>
</body>
</html>
