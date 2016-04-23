<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Proco | Questions search results</title>
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
<header>
    <a href="console"><button type="button" class="button-green pure-button">Admin Console</button></a>
    <a href="question-add"><button type="button" class="pure-button pure-button-primary">Add Question</button></a>
</header>
<article>
<c:choose>
    <c:when test="${result}">
    <h1>Search Results for "${searchTerm}"</h1>
    <div id="search">
        <form action="search-questions" method="get" class="pure-form">
            <input type="text" name="searchTerm" /> in
            <select name="column">
                <option value="category">Category</option>
                <option value="level">Level</option>
                <option value="inquiry">Question</option>
                <option value="answer">Answer</option>
            </select>
            <button type="submit" class="pure-button pure-button-primary">Search</button>
        </form>
    </div>
    <table class="pure-table pure-table-striped">
        <thead>
        <tr>
            <th>Action</th>
            <th>Category</th>
            <th>Level</th>
            <th>Question</th>
            <th>Answer</th>
        </tr>
        <tbody>
        <c:forEach items="${searchQuestions}" var="searchQuestion">
            <tr>
                <td>
                    <a href="edit-question?id=${searchQuestion.questionId}">Edit</a>
                    <a href="delete-question?id=${searchQuestion.questionId}">Delete</a>
                </td>
                <td>${searchQuestion.category}</td>
                <td>${searchQuestion.level}</td>
                <td>${searchQuestion.inquiry}</td>
                <td>${searchQuestion.answer}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <ul class="pagination">
        <li>
            <a href="/admin/search-questions?page=1&searchTerm=${searchTerm}&column=${searchColumn}">First</a>
        </li>
        <c:forEach var="i" begin="${beginPage}" end="${endPage}" >
            <li>
                <a href="/admin/search-questions?page=${i}&searchTerm=${searchTerm}&column=${searchColumn}"
                    ${(page == i) ? 'class="active"' : ''}>${i}</a>
            </li>
        </c:forEach>
        <li>
            <a href="/admin/search-questions?page=${totalPages}&searchTerm=${searchTerm}&column=${searchColumn}">Last</a>
        </li>
    </ul>
        </c:when>
    <c:otherwise>
        <h1>No records found for "${searchTerm}"</h1>
        <div id="search">
            <form action="search-questions" method="get" class="pure-form">
                <input type="text" name="searchTerm" /> in
                <select name="column">
                    <option value="category">Category</option>
                    <option value="level">Level</option>
                    <option value="inquiry">Question</option>
                    <option value="answer">Answer</option>
                </select>
                <button type="submit" class="pure-button pure-button-primary">Search</button>
            </form>
        </div>
    </c:otherwise>
</c:choose>
</article>
<footer>
    <p>&copy; 2016 by Vladislav Gorbich</p>
</footer>
</body>
</html>
