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
<title>Login & Registration</title>

</head>
<body>
	<div style="width: 80%; margin: auto; margin-top: 100px;">
		<h1>Book Club</h1>
		<h5>A place for friends to share thought on books</h5>
	</div>
	<div style="display: flex; width: 80%; margin: auto;">
		   
		<div
			style="width: 30%; padding: 30px; margin: auto; margin-top: 50px; border: 2px solid black;">
			<form:form action="/register_user" method="post"
				modelAttribute="newUser">
				<h1>Register New User</h1>
				<p>
					<form:errors path="name" />
				</p>
				<p>
					<form:errors path="email" />
				</p>
				<p>
					<form:errors path="password" />
				</p>
				<p>
					<form:errors path="confirm" />
				</p>
				<p>
					<form:label path="name">Name: </form:label>
					<form:input path="name" type="text" />
				</p>
				<p>
					<form:label path="email">Email: </form:label>
					<form:input path="email" type="email" />
				</p>

				<p>
					<form:label path="password">Password: </form:label>
					<form:input path="password" type="password" />
				</p>
				<p>
					<form:label path="confirm">Confirm Password: </form:label>
					<form:input path="confirm" type="password" />
				</p>

				<input type="submit" value="Submit">

			</form:form>
		</div>
		   
		<div
			style="width: 30%; padding: 30px; margin: auto; margin-top: 50px; border: 2px solid black;">
			<form:form action="/login_user" method="post"
				modelAttribute="loginUser">
				<h1>User Login</h1>
				<p>
					<form:errors path="email" />
				</p>
				<p>
					<form:errors path="password" />
				</p>
				<p>
					<form:label path="email">Email: </form:label>
					<form:input path="email" type="text" />
				</p>

				<p>
					<form:label path="password">Password: </form:label>
					<form:input path="password" type="password" />
				</p>

				<input type="submit" value="Submit">
			</form:form>
		</div>



	</div>
</body>
</html>

