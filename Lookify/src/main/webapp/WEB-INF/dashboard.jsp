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
<title>Lookify</title>
</head>
<body>
	<div
		style="display: flex; justify-content: space-between; width: 70%; margin: auto;">
		<div
			style="display: flex; justify-content: space-between; gap: 200px;">
			<h2>
				<a href="/addPage">Add New Song</a>
			</h2>
			<h2>
				<a href="#">Top Songs</a>
			</h2>
		</div>
		<div style="display: flex; justify-content: space-between;">
			<input type="text" placeholder="artist name" /> <input type="submit"
				value="Search Artists" />
		</div>
	</div>
	<div style="width: 50%; margin: auto; margin-top: 100px;'">
		<table class="table">
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${allSongs}" var="song">
				<tr>
					<td>${song.title }</td>
					<td>${song.rating }</td>
					<td>
						<form action="/delete/${song.id}" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>

