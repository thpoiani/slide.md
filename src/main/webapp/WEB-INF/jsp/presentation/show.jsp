<head>
	<title>Presentation [show]</title>
</head>
<body>
	<p>
		<b>Title:</b>
		${presentation.title}
	</p>
	<p>
		<b>Context:</b>
		${presentation.context}
	</p>
	<p>
		<b>Active:</b>
		${presentation.active}
	</p>
	<p>
		<b>Created at:</b>
		${presentation.createdAt}
	</p>
	<p>
		<b>User:</b>
		${presentation.user}
	</p>

	<a href="${pageContext.request.contextPath}/presentations/${presentation.id}/edit">Edit</a>
	<a href="${pageContext.request.contextPath}/presentations">Back</a>
</body>