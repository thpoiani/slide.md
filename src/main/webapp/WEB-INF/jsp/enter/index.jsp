<content tag="controller">enter</content>

<section class="row">
  <div class="content-medium">
  <h2 class="subtitle">Enter</h2>
  </div>

  <div class="content centered">
    <div class="form">
      <form action="${pageContext.request.contextPath}/users/auth" method="post">
        <label for="email">Email: </label>
        <input type="text" name="user.email" id="email" autofocus tabindex="1">

        <label for="password">Password: <a href="${pageContext.request.contextPath}/forgot" title="forgot password" tabindex="4">forgot password</a></label>
        <input type="password" name="user.password" id="password" tabindex="2">

        <div class="right">
          <input class="button" type="submit" title="enter" value="enter" tabindex="3">
        </div>
      </form>
    </div>
  </div>

</section>
