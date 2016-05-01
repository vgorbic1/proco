<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Proco | Register</title>
    <%@include file="includes/styles.jsp" %>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
    <article class="center">
        <p class="error">${registerMessage}</p>
        <c:remove var="registerMessage" scope="session" />
        <form action="user-register" method="post" class="pure-form pure-form-stacked field-center">
            <label>Username: </label>
            <input type="text" name="username" />
            <label>Password: </label>
            <input type="password" name="password">
            <br />
            <button type="submit" class="pure-button pure-button-primary">register</button>
        </form>
    </article>
    <%@include file="includes/footer.jsp" %>
</body>
</html>
