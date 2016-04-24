<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Proco | Test statistics for ${user.userName}</title>
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
<p>${statMessage}</p>
<c:remove var="statMessage" scope="session" />
    <h2>Test statistics for ${user.userName}</h2>
    <table class="pure-table pure-table-striped">
        <thead>
        <tr>
            <th>Date / Time</th>
            <th>Category</th>
            <th>Questions Asked</th>
            <th>Correct Answers</th>
            <th>Incorrect Answers</th>
        </tr>
        <tbody>
        <c:forEach items="${challenges}" var="challenge">
            <tr>
                <td><fmt:formatDate value="${challenge.date}" pattern="yyyy-MM-dd HH:mm" /></td>
                <td>${challenge.category}</td>
                <td>${challenge.totalQuestions}</td>
                <td>${challenge.correctQuestions}</td>
                <td>${challenge.totalQuestions - challenge.correctQuestions}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form class="pure-form pure-form-stacked" action="test-setup">
        <button type="submit" class="pure-button pure-button-primary">Take another test</button>
    </form>
</body>
</html>
