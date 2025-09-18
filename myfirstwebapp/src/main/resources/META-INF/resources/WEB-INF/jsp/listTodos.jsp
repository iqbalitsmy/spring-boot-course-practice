<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<title>Todos Page</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	background: #f9f9f9;
}

/* Navbar */
.navbar {
	background: #f8f9fa;
	padding: 15px 20px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	border-bottom: 1px solid #ddd;
}

.navbar .links a {
	margin: 0 10px;
	text-decoration: none;
	color: #333;
}

.navbar button {
	border: none;
	background: none;
	color: #007bff;
	font-weight: bold;
	cursor: pointer;
}

/* Content */
.container {
	max-width: 800px;
	margin: 30px auto;
	padding: 20px;
	background: #fff;
	border-radius: 8px;
	box-shadow: 0px 2px 6px rgba(0, 0, 0, 0.1);
}

h2 {
	margin-bottom: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 1rem;
}

th, td {
	padding: 12px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	font-weight: bold;
}

.btn {
	padding: 6px 14px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 14px;
}

.btn-update {
	background: #28a745;
	color: #fff;
}

.btn-delete {
	background: #ffc107;
	color: #fff;
}

.btn-add {
	background: #28a745;
	color: #fff;
}
</style>
</head>
<body>

	<div class="navbar">
		<div class="brand">${name}</div>
		<div class="links">
			<a href="/">Home</a> <a href="/list-todos">Todos</a>
		</div>
		<a href="/logout">Logout</a>
	</div>
	<!-- Main Content -->
	<div class="container">
		<h2>Your Todos</h2>
		<table>
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it Done?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a href="update-todo?id=${todo.id}"
							class="btn btn-update">Update</a></td>
						<td><a href="delete-todo?id=${todo.id}"
							class="btn btn-delete">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a href="/add-todo" class="btn btn-add">Add Todo</a>
		</div>
	</div>

	<script>
		// Update todo status
		function updateTodo(index) {
			todos[index].done = !todos[index].done;
			renderTodos();
		}

		// Delete todo
		function deleteTodo(index) {
			todos.splice(index, 1);
			renderTodos();
		}
	</script>
</body>
</html>
