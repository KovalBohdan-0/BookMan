<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/loginStyles.css" type="text/css">
<title>BookingWeb</title>
</head>
<body>
	<div class="loginForm">
		<form action="books" method="post">
			<h1 align="center">Welcome</h1>
			<br> <br> <input type="text" class="input" name="email"
				placeholder="Email"> <br> <input type="password"
				class="input" name="password" placeholder="Password"> <br>
			<div align="center">
				<input type="submit" class="submit" value="Log in"> <br>
			</div>
		</form>
		<div align="center">
			<h4>Or</h4>
			<form action="sign-up" method="get">
				<input type="submit" class="submit" value="Sign up">
			</form>
		</div>
	</div>
</body>
</html>