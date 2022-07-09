<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bookTable.css" type="text/css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addBook" method="post">
		<input type="submit" name="addBook" value="+ Add new book">
	</form>
	<br />
	<table id="books">
		<tr>
			<th>Name</th>
			<th>Author</th>
			<th>Pages</th>
			<th>Description</th>
		</tr>
		<c:forEach var="book" items="${books}">
			<tr>
				<td><c:out value="${book.getName()}" /></td>
				<td><c:out value="${book.getAuthor()}" /></td>
				<td><c:out value="${book.getPagesCount()}" /></td>
				<td><c:out value="${book.getDescription()}" /></td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>