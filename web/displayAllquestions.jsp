<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/head.jsp" />
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
        <c:forEach items="${questions}" var="question">
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
