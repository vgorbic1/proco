<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Proco | Edit question</title>
    <%@include file="includes/styles.jsp" %>
    <link rel="stylesheet" href="../css/style.css" />
</head>
<body>
<c:choose>
    <c:when test="${success}">
        ${message}
        <c:remove var="message" scope="session" />
        <c:remove var="success" scope="session" />
        <a href="questions-all">
            <button type="button" class="pure-button pure-button-primary">All Questions</button>
        </a>
    </c:when>
    <c:otherwise>
        ${message}
<c:remove var="message" scope="session" />
<h1>Edit Question</h1>
<form action="question-update" method="post" class="pure-form pure-form-stacked">
    <label for="category">Category</label>
    <select name="category" id="category">
        <option value="Java" ${editQuestion.category == "Java" ? 'selected="selected"' : ''}>Java</option>
        <option value="JavaScript" ${editQuestion.category == "JavaScript" ? 'selected="selected"' : ''}>JavaScript</option>
        <option value="PHP" ${editQuestion.category == "PHP" ? 'selected="selected"' : ''}>PHP</option>
        <option value="SQL" ${editQuestion.category == "SQL" ? 'selected="selected"' : ''}>SQL</option>
    </select>
    <label for="level">Level</label>
    <select name="level" id="level">
        <option value="Basic" ${editQuestion.level == "Basic" ? 'selected="selected"' : ''}>Basic</option>
        <option value="Intermediate" ${editQuestion.level == "Intermediate" ? 'selected="selected"' : ''}>Intermediate</option>
        <option value="Advanced" ${editQuestion.level == "Advanced" ? 'selected="selected"' : ''}>Advanced</option>
    </select>
    <label for="question">Question</label>
    <textarea cols="50" rows="10" name="question" id="question">${editQuestion.inquiry}</textarea>
    <label for="answer">Answer</label>
    <textarea cols="50" rows="10" name="answer" id="answer">${editQuestion.answer}</textarea>
    <button type="submit" class="pure-button pure-button-primary">Save</button>
    <a href="questions-all"><button type="button" class="pure-button pure-button-primary">Cancel</button></a>
</form>
    </c:otherwise>
</c:choose>
<%@include file="includes/footer.jsp" %>
</body>
</html>