<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Simple Login Page</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: #f0f2f5;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.login-box {
	background: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	width: 300px;
	text-align: center;
}

.login-box h2 {
	margin-bottom: 20px;
	color: #333;
}

.login-box input {
	width: 100%;
	padding: 10px;
	margin: 8px 0;
	border: 1px solid #ccc;
	border-radius: 5px;
	outline: none;
}

.login-box button {
	width: 100%;
	padding: 10px;
	background: #4CAF50;
	color: white;
	border: none;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
}

.login-box button:hover {
	background: #45a049;
}

.message {
	margin-top: 15px;
	font-size: 14px;
}

.success {
	color: green;
}

.error {
	color: red;
}
</style>
</head>
<body>

	<div class="login-box">
		<form method="post">
			<h2>Welcome Back</h2>
			<input type="text" id="username" name="name" placeholder="Enter Username">
			<input type="password" id="password" name="password" placeholder="Enter Password">
			<button type="submit">Login</button>
			<div id="message" class="message"></div>
		</form>
	</div>

	<script>
		function login() {
			//e.preventDefault(); // stop form from refreshing
			const user = document.getElementById("username").value.trim();
			const pass = document.getElementById("password").value;
			const message = document.getElementById("message");

			// Demo username and password
			const demoUser = "admin";
			const demoPass = "1234";

			if (user === demoUser && pass === demoPass) {
				message.textContent = "Login successful!";
				message.className = "message success";
			} else {
				message.textContent = "Invalid username or password.";
				message.className = "message error";
			}
		}
	</script>

</body>
</html>
