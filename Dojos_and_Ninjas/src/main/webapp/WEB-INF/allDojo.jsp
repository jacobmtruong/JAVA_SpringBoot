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
<title>All Dojos</title>

</head>
<body>   
	<div style="width: 40%; margin: auto">
		<h1>All Dojos</h1>
		<table class="table">
			<tr>
				<th>Dojo</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${allDojo }" var="dojo">
				<tr>
					<td><a href="/dojo/${dojo.id }">${dojo.name }</a></td>
					<td style="display: flex; justify-around: space-between;">
						<form action="#" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete">
						</form></td>
				</tr>
			</c:forEach>
		</table>
		
		<a href="/create/ninja" class="btn btn-warning">Add New Ninja</a>
		</div>
		
		
</body>
</html>

