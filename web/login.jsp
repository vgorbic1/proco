<jsp:include page="includes/head.jsp" />
<body>
<div id="app">
<form action="j_security_check" method="post" class="pure-form pure-form-stacked">
    <label>user name: </label>
    <input type="text" name="j_username" />
    <label>password: </label>
    <input type="password" name="j_password">
    <br />
    <button type="submit" class="pure-button">log in</button>
</form>
</div>
</body>
</html>
