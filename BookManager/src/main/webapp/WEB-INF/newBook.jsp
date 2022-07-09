<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bookTable.css" type="text/css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addBook" method="post">

		<p>Name:</p>
		<input name="name" />
		<p>Author:</p>
		<input name="author" />
		<p>Pages:</p>
		<input name="pages" />
		<p>Description:</p>
		<textarea name="description"></textarea>

		<br /> <input id="submit" type="submit" name="addBook"
			value="+ Add new book">
	</form>

</body>
</html>