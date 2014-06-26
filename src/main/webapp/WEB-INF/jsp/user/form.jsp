<c:if test="${not empty errors}">
	<c:forEach items="${errors}" var="error">
		${error.category} - ${error.message}<br />
	</c:forEach>
</c:if>

<form action="${pageContext.request.contextPath}/users" method="post">
  
	<c:if test="${not empty user.id}">
		<input type="hidden" name="user.id" value="${user.id}"/>
		<input type="hidden" name="_method" value="put"/>
	</c:if>

	<div class="field">
		Name:<br />
	
		<input type="text" name="user.name" value="${user.name}"/>
	</div>
	
	<div class="field">
		Email:<br />
	
		<input type="text" name="user.email" value="${user.email}"/>
	</div>
	
	<div class="field">
		Password:<br />
	
		<input type="text" name="user.password" value="${user.password}"/>
	</div>
	
	<div class="field">
		Active:<br />
	
		<input type="text" name="user.active" value="${user.active}"/>
	</div>
	
	<div class="field">
		Created at:<br />
	
		<input type="text" name="user.createdAt" value="${user.createdAt}"/>
	</div>
	
  <div class="actions">
	  <button type="submit">send</button>
	</div>
</form>

<a href="${pageContext.request.contextPath}/users">Back</a>
