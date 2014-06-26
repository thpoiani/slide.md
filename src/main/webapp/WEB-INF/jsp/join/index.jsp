<content tag="controller">join</content>

<section class="row">
  <div class="content-medium">
  <h2 class="subtitle">Join</h2>
  </div>

  <div class="content centered">
    <div class="form">
      <form method="post">
        <label for="name">Name: </label>
        <input type="text" name="name" id="name" autofocus tabindex="1">

        <label for="email">Email: </label>
        <input type="text" name="email" id="email" tabindex="2">

        <label for="password">Password: <a href="${pageContext.request.contextPath}/forgot" title="forgot password" tabindex="5">forgot password</a></label>
        <input type="password" name="password" id="password" tabindex="3">

        <div class="right">
          <input class="button" type="submit" title="join" value="join" tabindex="4">
        </div>
      </form>
    </div>
  </div>
</section>