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
<title>Create a New Dojo</title>
</head>
<body>
	   
	<div>

		<div
			style="width: 30%; padding: 30px; margin: auto; margin-top: 50px; border: 2px solid black;">
			<h1>New Dojo</h1>
			<form:form action="/create_dojo" method="post" modelAttribute="dojo">
				<p>
					<form:errors path="name" />
				</p>
				<p>
					<form:label path="name">Dojo name: </form:label>
					<form:input path="name" />
				</p>
				<input type="submit" value="Submit">
			</form:form>
		</div>
	</div>
</body>
</html>

