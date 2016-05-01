<!DOCTYPE html>
<html lang="en">
<head>
    <title>Proco | Test Setup</title>
    <%@include file="includes/styles.jsp" %>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
<article class="center">
<h1>Test Setup</h1>
    <form action="test" class="pure-form pure-form-stacked field-center" method="post">
    <label for="category">Category</label>
    <select name="category" id="category">
        <option value="Java">Java</option>
        <option value="JavaScript">JavaScript</option>
        <option value="PHP">PHP</option>
        <option value="SQL">SQL</option>
    </select>
    <label for="limit">Number of Questions</label>
    <select name="limit" id="limit">
        <option value="10">10</option>
        <option value="20">20</option>
        <option value="30">30</option>
        <option value="40">40</option>
    </select>
    <button type="submit" class="pure-button pure-button-primary">Test Me</button>
    </form>
</article>
<%@include file="includes/footer.jsp" %>
</body>
</html>
