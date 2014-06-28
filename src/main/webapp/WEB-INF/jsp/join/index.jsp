<content tag="controller">join</content>

<section class="row">
  <div class="content-medium">
    <h2 class="subtitle">Join</h2>
  </div>

  <div class="content centered">
    <div class="form">
      <form action="${pageContext.request.contextPath}/users" method="post">
        <label for="name">Name</label>
        <input type="text" name="user.name" id="name" autofocus tabindex="1">

        <label for="email">Email</label>
        <input type="text" name="user.email" id="email" tabindex="2">

        <label for="password">Password</label>
        <input type="password" name="user.password" id="password" tabindex="3">

        <div class="right">
          <input class="button" type="submit" title="join" value="join" tabindex="4">
        </div>
      </form>

      <c:if test="${not empty errors}">
      <div class="error">
        <c:forEach items="${errors}" var="error">
        <p>${error.category} <small>${error.message}</small></p>
        </c:forEach>
      </div>
      </c:if>
    </div>
  </div>
</section>