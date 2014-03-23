<section class="row">
  <div class="content-medium">
	<h2 class="subtitle">Join</h2>
  </div>
  
  <div class="content centered center markdown">
  	<form method="post">
      <label for="name">Name: </label>
      <input type="text" name="name" id="name" autofocus="autofocus" tabindex="1">
  	
	  <label for="email">Email: </label>
	  <input type="text" name="email" id="email" tabindex="2">
	
	  <label for="password">Password: <a href="${pageContext.request.contextPath}/forgot" title="forgot password" tabindex="5">forgot password</a></label>
	  <input type="password" name="password" id="password" tabindex="3">
	
	  <input type="submit" title="enter" value="enter" tabindex="4">
	</form>
  </div>

</section>