<!DOCTYPE html>
<html lang="en">
<head>
    <title>Proco | Test Your IT Knowledge</title>
    <%@include file="includes/styles.jsp" %>
    <link rel="stylesheet" href="css/style.css" />
</head>
  <body>
    <article class="center">
        <h1>Proco</h1>
        <p>Test your knowledge in different IT areas.</p>
        <p>You don't need to register to take a test.</p>
        <a href="test-setup"><button type="submit" class="pure-button button-green">Take a Test</button></a>
        <br>
        <a href="login"><button id="showAnswer" class="pure-button button-orange">Log in</button></a>
    </article>
    <%@include file="includes/footer.jsp" %>

    <!-- REMOVE WHEN LIVE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
    <a href="admin/console">*</a>

  </body>
</html>
