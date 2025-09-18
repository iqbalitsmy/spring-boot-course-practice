 <!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Welcome Page</title>
  <style>
    body {
      margin: 0;
      font-family: 'Arial', sans-serif;
      background: linear-gradient(135deg, #4facfe, #00f2fe);
      color: #fff;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      text-align: center;
    }
    .welcome-container {
      background: rgba(0, 0, 0, 0.4);
      padding: 40px;
      border-radius: 15px;
      box-shadow: 0 8px 16px rgba(0,0,0,0.2);
      max-width: 500px;
      width: 90%;
    }
    h1 {
      font-size: 2.5rem;
      margin-bottom: 15px;
    }
    p {
      font-size: 1.2rem;
      margin-bottom: 25px;
    }
    .btn {
      padding: 12px 25px;
      margin: 10px;
      background: #fff;
      color: #007bff;
      border: none;
      border-radius: 8px;
      font-size: 1rem;
      cursor: pointer;
      transition: 0.3s;
    }
    .btn:hover {
      background: #007bff;
      color: #fff;
    }
  </style>
</head>
<body>

  <div class="welcome-container">
    <h1>Welcome Back ${name }!</h1>
    <p>${result}</p>
    <a class="btn" href="/list-todos">Go to Todo List</a>
  </div>

  <script>
    function goToDashboard() {
      alert("Redirecting to dashboard...");
      // Example redirect (replace with your page)
      window.location.href = "dashboard.html";
    }

    function logout() {
      alert("Logging out...");
      // Example redirect (replace with your login page)
      window.location.href = "login.html";
    }
  </script>

</body>
</html>
 