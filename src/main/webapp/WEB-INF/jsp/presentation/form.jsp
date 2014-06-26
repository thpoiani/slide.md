<c:if test="${not empty errors}">
	<c:forEach items="${errors}" var="error">
		${error.category} - ${error.message}<br />
	</c:forEach>
</c:if>

<form action="${pageContext.request.contextPath}/presentations" method="post">
  
	<c:if test="${not empty presentation.id}">
		<input type="hidden" name="presentation.id" value="${presentation.id}"/>
		<input type="hidden" name="_method" value="put"/>
	</c:if>

	<div class="field">
		Title:<br />
	
		<input type="text" name="presentation.title" value="${presentation.title}"/>
	</div>
	
	<div class="field">
		Context:<br />
	
		<input type="text" name="presentation.context" value="${presentation.context}"/>
	</div>
	
	<div class="field">
		Active:<br />
	
		<input type="text" name="presentation.active" value="${presentation.active}"/>
	</div>
	
	<div class="field">
		Created at:<br />
	
		<input type="text" name="presentation.createdAt" value="${presentation.createdAt}"/>
	</div>
	
	<div class="field">
		User:<br />
		<select name="presentation.user.id">
		  <c:forEach var="user" items="${userList}">
		    <option value="${user.id}" <c:if test = "${presentation.user.id == user.id}">selected="true"</c:if>>
		      ${user.id}
			</option>
		  </c:forEach>
		</select>
	</div>
	
  <div class="actions">
	  <button type="submit">send</button>
	</div>
</form>

<a href="${pageContext.request.contextPath}/presentations">Back</a>
