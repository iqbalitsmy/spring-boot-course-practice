<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Simple Signup Page</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: #eef2f7;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.signup-box {
	background: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	width: 320px;
	text-align: center;
}

.signup-box h2 {
	margin-bottom: 20px;
	color: #333;
}

.signup-box input {
	width: 100%;
	padding: 10px;
	margin: 8px 0;
	border: 1px solid #ccc;
	border-radius: 5px;
	outline: none;
}

.signup-box button {
	width: 100%;
	padding: 10px;
	background: #007bff;
	color: white;
	border: none;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
}

.signup-box button:hover {
	background: #0069d9;
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

	<div class="signup-box">
		<h2>Sign Up ${name}</h2>
		<input type="text" id="name" placeholder="Full Name"> <input
			type="email" id="email" placeholder="Email Address"> <input
			type="password" id="password" placeholder="Password"> <input
			type="password" id="confirm" placeholder="Confirm Password">
		<button onclick="signup()">Sign Up</button>
		<div id="message" class="message"></div>
	</div>

	<script>
    function signup() {
      const name = document.getElementById("name").value.trim();
      const email = document.getElementById("email").value.trim();
      const password = document.getElementById("password").value;
      const confirm = document.getElementById("confirm").value;
      const message = document.getElementById("message");

      if (!name || !email || !password || !confirm) {
        message.textContent = "All fields are required.";
        message.className = "message error";
        return;
      }

      if (password !== confirm) {
        message.textContent = "Passwords do not match.";
        message.className = "message error";
        return;
      }

      // Demo: saving signup info in localStorage
      localStorage.setItem("user", JSON.stringify({ name, email, password }));

      message.textContent = "Signup successful!";
      message.className = "message success";
    }
  </script>

</body>
</html>
