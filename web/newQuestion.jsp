<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/head.jsp" />
<body>
${message}
<c:remove var="message" scope="session" />
<h1>Create a new question</h1>
<form action="question-new" method="post" class="pure-form pure-form-stacked">
    <label for="category">Category</label>
    <select name="category" id="category">
        <option value="java">Java</option>
        <option value="javascript">JavaScript</option>
        <option value="php">PHP</option>
    </select>
    <label for="level">Level</label>
    <select name="level" id="level">
        <option value="basic">Basic</option>
        <option value="intermediate">Intermediate</option>
        <option value="advanced">Advanced</option>
    </select>
    <label for="question">Question</label>
    <textarea cols="50" rows="15" name="question" id="question">${inquiry}</textarea>
    <c:remove var="inquiry" scope="session" />
    <label for="answer">Answer</label>
    <textarea cols="50" rows="15" name="answer" id="answer">${answer}</textarea>
    <c:remove var="answer" scope="session" />
    <button type="submit" class="pure-button">Save</button>
</form>
</body>
</html>