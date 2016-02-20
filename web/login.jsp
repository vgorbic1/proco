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
</head>
<body>
<form action="j_security_check" method="post">
    <table>
        <tr><td>user name: </td><td><input type="text" name="j_username"></td></tr>
        <tr><td>password: </td><td><input type="password" name="j_password"></td></tr>
        <tr><td><input type="submit" value="log in"></td></tr>
    </table>
</form>

</body>
</html>
