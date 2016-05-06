<!DOCTYPE html>
<html lang="en">
<head>
    <title>Proco | Admin Console</title>
    <%@include file="includes/styles.jsp" %>
    <link rel="stylesheet" href="../css/style.css" />
</head>
<body>
<article class="center">
<h1>Administrator's Console</h1>
<a href="questions-all"><button type="button" class="button-green pure-button">All Questions</button></a>
<a href="question-add"><button type="button" class="button-green pure-button">Add Question</button></a>
<br />
<a href="users-all"><button type="button" class="button-orange pure-button">All Users</button></a>
<br />
<a href="books-all"><button type="button" class="button-maroon pure-button">All Books</button></a>
<a href="book-add"><button type="button" class="button-maroon pure-button">Add Books</button></a>
<br />
<a href="../test-setup"><button type="button" class="button-blue pure-button">Take a Test</button></a>
</article>
<%@include file="includes/footer.jsp" %>
</body>
</html>