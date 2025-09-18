<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<title>Add Todo</title>
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

/* Container */
.container {
	max-width: 500px;
	margin: 50px auto;
	padding: 25px;
	background: #fff;
	border-radius: 8px;
	box-shadow: 0px 2px 6px rgba(0, 0, 0, 0.1);
}

h2 {
	margin-bottom: 20px;
}

form {
	display: flex;
	flex-direction: column;
}

label {
	margin: 10px 0 5px;
}

input {
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

button {
	margin-top: 20px;
	padding: 10px;
	background: #007bff;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

button:hover {
	background: #0056b3;
}
</style>
</head>
<body>

	<!-- Navbar -->
	<div class="navbar">
		<div class="brand">${name}</div>
		<div class="links">
			<a href="/">Home</a> <a href="/list-todos">Todos</a>
		</div>
		<a href="/logout">Logout</a>
	</div>

	<!-- Add Todo Form -->
	<div class="container">
		<h2>Add New Todo</h2>
		<form:form method="post" modelAttribute="todo">
			<fieldset>
				<label for="description">Description</label>
				<form:input path="description" id="description" required="true" />
				<form:errors path="description" />
			</fieldset>
			<fieldset>
				<label for="targetDate">Target Date</label>
				<form:input path="targetDate" id="targetDate" required="true" />
				<form:errors path="targetDate" />
			</fieldset>

			<form:input type="hidden" path="id" id="" />
			<form:input type="hidden" path="done" id="" />
			<button type="submit">Add Todo</button>
		</form:form>
	</div>

</body>
</html>
