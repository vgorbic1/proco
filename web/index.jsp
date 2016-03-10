<jsp:include page="includes/head.jsp" />
  <body>
    <div id="app">
     <h1>Proco</h1>
      <p>Test your knowledge in different IT areas.</p>
      <div id="login">
        <form class="pure-form pure-form-stacked" action="/login" method="post">
          <input type="text" placeholder="username" />
          <input type="password" placeholder="password" />
          <br />
          <button type="submit" class="pure-button">log in</button>
        </form>
      </div>
      <div id="register">
        <a href="/register.jsp">Register</a>
      </div>
    </div>
  </body>
</html>
