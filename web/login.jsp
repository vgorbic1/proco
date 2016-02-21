<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 2/20/2016
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
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
<form action="j_security_check" method="post" class="pure-form pure-form-stacked">
    <label>user name: </label>
    <input type="text" name="j_username" />
    <label>password: </label>
    <input type="password" name="j_password">
    <br />
    <input type="submit" class="pure-button" value="log in">
</form>

</body>
</html>
