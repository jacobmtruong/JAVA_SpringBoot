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
<title>Add New Song</title>
</head>
<body>
	<div style="width: 50%; padding: 30px; margin: auto; margin-top: 50px; border: 2px solid black;">
		<h1>Add a New Song</h1>
		<form:form action="/add" method="post" modelAttribute="song">
			<p>
				<form:errors path="title" />
			</p>
			<p>
				<form:errors path="artist" />
			</p>
			<p>
				<form:errors path="rating" />
			</p>
			<p>
				<form:label path="title">Title: </form:label>
				<form:input path="title" />
			</p>

			<p>
				<form:label path="artist">Artist: </form:label>
				<form:input path="artist" />
			</p>
			<p>
				<form:label path="rating">Rating (1 - 10): </form:label>
				<form:input type="number" path="rating" />
			</p>
			<input type="submit" value="Submit">
		</form:form>
</body>
</html>

