<head>
	<title>Presentation [index]</title>
</head>
<body>
	<h1>Listing Presentations</h1>

	<table>
		<tr>
			<th>Title</th>
			<th>Context</th>
			<th>Hash</th>
			<th>Active</th>
			<th>Created at</th>
			<th>User</th>
			<th></th>
			<th></th>
			<th></th>
		</tr>

		<c:forEach items="${presentationList}" var="presentation">
			<tr>
				<td>${presentation.title}</td>
				<td>${presentation.context}</td>
				<td>${presentation.hash}</td>
				<td>${presentation.active}</td>
				<td>${presentation.createdAt}</td>
				<td>${presentation.user.name}</td>
				<td><a href="${pageContext.request.contextPath}/presentations/${presentation.id}">show</a></td>
				<td><a href="${pageContext.request.contextPath}/presentations/${presentation.id}/edit">edit</a></td>
				<td>
					<form action="${pageContext.request.contextPath}/presentations/${presentation.id}" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<button type="submit" onclick="return confirm('Are you sure?')">destroy</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<a href="${pageContext.request.contextPath}/presentations/new">New Presentation</a> 
</body>