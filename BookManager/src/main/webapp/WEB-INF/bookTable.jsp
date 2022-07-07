<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bookTable.css" type="text/css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table id="customers">
		<tr>
			<th>Name</th>
			<th>Author</th>
			<th>Pages</th>
			<th>Description</th>
		</tr>
		<tr>
			<td>Alfreds Futterkiste</td>
			<td>Maria Anders</td>
			<td>Germany</td>
		</tr>
		<c:forEach var="book" items="${books}">
			<td>
				<c:out value="${books.name}" />
				<c:out value="${books.author}" />
				<c:out value="${books.pagesCount}" />
				<c:out value="${books.description}" />
			</td>
		</c:forEach>

	</table>


</body>
</html>