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
<title>Read Share</title>
</head>
<body>
	<div
		style="width: 50%; margin: auto; margin-top: 100px; display: flex; flex-direction: column; gap: 70px;">
		<div style="display: flex; justify-content: space-between;">
			<h1>${thisBook.title }</h1>
			<a href="/welcome">Back to the shelves</a>
		</div>
		<c:choose>
			<c:when test="${user_id == thisBook.user.id }">
				<h3>You read ${thisBook.title } by ${thisBook.author }</h3>
				<h4>Here are your thoughts:</h4>
			</c:when>

			<c:otherwise>
				<h3>${thisBook.user.name } reads ${thisBook.title } by
					${thisBook.author }</h3>
				<h4>Here are ${thisBook.user.name }'s thoughts:</h4>
			</c:otherwise>
		</c:choose>
		
		<div
			style="width: 60%; background-color: yellow; padding: 20px; border-radius: 20px; border: 2px solid black;">
			<h5>${thisBook.thought }</h5>
			<c:if test="${user_id == thisBook.user.id }">
				<a href="/edit/book/${thisBook.id }" class="btn btn-info"
					style="float: right; margin-top: 20px;">Edit</a>
			</c:if>
		</div>
	</div>
</body>
</html>

