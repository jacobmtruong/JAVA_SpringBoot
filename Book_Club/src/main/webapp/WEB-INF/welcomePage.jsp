<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<title>Welcome User</title>

</head>
<body>
	<div style="width: 70%; margin: auto; margin-top: 100px">
		<div style="display: flex; justify-content: space-between;">
			<h1>Welcome, ${name}</h1>
			<div>
				<a href="/add/book" class="btn btn-primary">+ Add a Book to my
					shelf</a> <a href="/logout" class="btn btn-warning">Logout</a>
			</div>
		</div>
		<div style="margin-top: 100px;">
			<table class="table">
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>

				<c:forEach items="${allTheBooks}" var="book">
					<tr class="table-info">
						<td>${book.id }</td>
						<td><a href="/view/book/${book.id}">${book.title }</a></td>
						<td>${book.author }</td>
						<td>${book.user.name}</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>

