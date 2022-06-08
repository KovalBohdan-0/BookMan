<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create account</title>
<link rel="stylesheet" href="css/loginStyles.css" type="text/css">
</head>
<body>
	<form action="sign-up" method="post">
		<div class="loginForm">
			<h1>Create your account</h1>
			<br> <input type="text" name="userName" class="input"
				placeholder="Username" />
			<h6 class="registrationError">${usernameError}</h6>
			<input type="text" name="email" class="input" placeholder="Email" />
			<h6 class="registrationError">${emailError}</h6>
			<input type="password" name="password" class="input"
			 	placeholder="Password" />
			<h6 class="registrationError">${passwordError}</h6>
			<input type="password" name="repeatedPassword" class="input"
			 	placeholder="Repeat your password" />
			<h6 class="registrationError">${repeatedPasswordError}</h6>
			<br> <input type="submit" class="submit" value="Create" />
		</div>
	</form>
</body>
</html>