<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Proco | User Login</title>
    <%@include file="includes/styles.jsp" %>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
    <article class="center">
        <p class="error">${loginMessage}</p>
        <c:remove var="loginMessage" scope="session" />
        <form action="user-login" method="post" class="pure-form pure-form-stacked field-center" >
            <input type="text" name="username" placeholder="user name" />
            <input type="password" name="password" placeholder="password" />
        <button type="submit" class="pure-button pure-button-primary">log in</button>
        </form>
        <p>or <a href="register">register</a></p>
    </article>
    <%@include file="includes/footer.jsp" %>
</body>
</html>

