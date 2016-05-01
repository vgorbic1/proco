<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Proco | Add new question</title>
    <%@include file="includes/styles.jsp" %>
    <link rel="stylesheet" href="../css/style.css" />
</head>
<body>
${message}
<c:remove var="message" scope="session" />
<h1>Add Question</h1>
<form action="question-add-result" method="post" class="pure-form pure-form-stacked">
    <label for="category">Category</label>
    <select name="category" id="category">
        <option value="Java">Java</option>
        <option value="JavaScript">JavaScript</option>
        <option value="PHP">PHP</option>
        <option value="SQL">SQL</option>
    </select>
    <label for="level">Level</label>
    <select name="level" id="level">
        <option value="Basic">Basic</option>
        <option value="Intermediate">Intermediate</option>
        <option value="Advanced">Advanced</option>
    </select>
    <label for="question">Question</label>
    <textarea cols="50" rows="10" name="question" id="question">${inquiry}</textarea>
    <c:remove var="inquiry" scope="session" />
    <label for="answer">Answer</label>
    <textarea cols="50" rows="10" name="answer" id="answer">${answer}</textarea>
    <c:remove var="answer" scope="session" />
    <button type="submit" class="pure-button pure-button-primary">Save</button>
    <a href="questions-all"><button type="button" class="pure-button pure-button-primary">Cancel</button></a>
</form>
<%@include file="includes/footer.jsp" %>
</body>
</html>