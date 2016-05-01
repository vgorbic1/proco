<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Proco | List of All Questions for a Certain Category</title>
    <%@include file="includes/styles.jsp" %>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
<c:choose>
    <c:when test="${number > totalNumberOfQuestions}">
        <h1>Results:</h1>
        <table class="pure-table pure-table-striped">
            <thead>
            <tr>
                <th>Number</th>
                <th>Level</th>
                <th>Question</th>
                <th>Answer</th>
                <th>Result</th>
            </tr>
            <tbody>
            <c:forEach items="${results}" var="result"><tr>
                <td>${result.questionNumber}</td>
                <td>${result.level}</td>
                <td>${result.inquiry}</td>
                <td>${result.answer}</td>
                <td>${result.result}</td>
            </tr></c:forEach>
            </tbody>
        </table>
        <form action="test-save" method="post">
            <button type="submit" class="pure-button pure-button-primary">Save Results</button>
        </form>
        <%@include file="includes/books.jsp" %>
        <a href="test-setup"><button type="button" class="pure-button pure-button-primary">Test me again</button></a>
    </c:when>
    <c:otherwise>
        <p>Category: ${question.category}</p>
        <p>Question ${number} of ${totalNumberOfQuestions}</p>
        <h2>Question</h2>
        <div id="test-question">${question.inquiry}</div>
        <button id="showAnswer" class="pure-button pure-button-primary">Show Answer</button>
        <div id="hide-answer">
            <h2>Answer</h2>
            <div id="test-answer">${question.answer}</div>
            <form action="test" method="post">
                <button type="submit" class="pure-button pure-button-primary" name="correct">That is what I thought!</button>
                <button type="submit" class="pure-button pure-button-primary" name="incorrect">Oops, I forgot about it.</button>
            </form>
        </div>
    </c:otherwise>
</c:choose>
<%@include file="includes/footer.jsp" %>
</body>
</html>
<script>
    document.getElementById('showAnswer').onclick = function() {
        document.getElementById('hide-answer').style.display='block';
    }
</script>