<!DOCTYPE html>
<html lang="en">
<head>
    <title>Proco | Login</title>
    <%@include file="includes/styles.jsp" %>
    <link rel="stylesheet" href="../css/style.css" />
</head>
<body>
<article class="center">
<form action="j_security_check" method="post" class="pure-form pure-form-stacked field-center">
    <input type="text" name="j_username" placeholder="user name"/>
    <input type="password" name="j_password" placeholder="password">
    <button type="submit" class="pure-button pure-button-primary">log in</button>
</form>
</article>
<%@include file="includes/footer.jsp" %>
</body>
</html>