<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Proco | Test Setup</title>
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
<h1>Test Setup</h1>
<form action="test" class="pure-form pure-form-stacked" method="post">
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
</body>
</html>
