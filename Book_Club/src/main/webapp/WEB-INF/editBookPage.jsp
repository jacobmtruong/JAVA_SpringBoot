<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Edit Book</title>
</head>
<body>
      	<div
			style="width: 30%; padding: 30px; margin: auto; margin-top: 50px; border: 2px solid black;">
			<form:form action="/edit/${editBook.id }" method="post"
				modelAttribute="editBook">
				
				<input type="hidden" name="_method" value="put">
				<h1>Change your Entry</h1>
				<p>
					<form:errors path="title" />
				</p>
				<p>
					<form:errors path="author" />
				</p>
				<p>
					<form:errors path="thought" />
				</p>
				<p>
					<form:label path="title">Title: </form:label>
					<form:input path="title" type="text" />
				</p>
				<p>
					<form:label path="author">Author: </form:label>
					<form:input path="author" type="text" />
				</p>

				<p>
					<form:label path="thought">My thoughts : </form:label>
					<form:input path="thought" type="textarea" />
				</p>
				
				<form:input type="hidden" path="user" value="${user_id}"/>

				<input type="submit" value="Submit">

			</form:form>
		</div>
</body>
</body>
</html>

