<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Proco | Register</title>
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
<p>${registerMessage}</p>
<c:remove var="registerMessage" scope="session" />
<form action="user-register" method="post" class="pure-form pure-form-stacked">
    <label>username: </label>
    <input type="text" name="username" />
    <label>password: </label>
    <input type="password" name="password">
    <br />
    <button type="submit" class="pure-button pure-button-primary">register</button>
</form>
</body>
</html>
