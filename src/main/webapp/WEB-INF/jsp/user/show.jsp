<head>
	<title>User [show]</title>
</head>
<body>
	<p>
		<b>Name:</b>
		${user.name}
	</p>
	<p>
		<b>Email:</b>
		${user.email}
	</p>
	<p>
		<b>Password:</b>
		${user.password}
	</p>
	<p>
		<b>Active:</b>
		${user.active}
	</p>
	<p>
		<b>Created at:</b>
		${user.createdAt}
	</p>

	<a href="${pageContext.request.contextPath}/users/${user.id}/edit">Edit</a>
	<a href="${pageContext.request.contextPath}/users">Back</a>
</body>