<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">


</head>
<body style="padding: 100px;">
	<h1>All Books</h1>

	<hr />

	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Language</th>
			<th>Number of Pages</th>
		</tr>
		<c:forEach items="${alltheBooks }" var="book">
		<tr>
			<td>${book.id }</td>
			<td><a href="/books/${book.id}"><h2 style="color: red;">${book.title }</h2></a></td>
			<td>${book.language }</td>
			<td>${book.numberOfPages }</td>
		</tr>
		</c:forEach>
		
	</table>
	
	<a class="btn btn-primary" href="/addbook">Add New Book</a>
	<a class="btn btn-primary" href="/books/new">Add New Book with form:from</a>
</body>
</html>