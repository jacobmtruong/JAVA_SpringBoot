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
<title>Create New Ninja</title>
</head>
<body>
	   
	<div
		style="width: 30%; padding: 30px; margin: auto; margin-top: 50px; border: 2px solid black;">
		<h1>New Ninja</h1>
		<form:form action="/create_ninja" method="post" modelAttribute="ninja">
			<p>
				<form:errors path="firstName" />
			</p>
			<p>
				<form:errors path="lastName" />
			</p>
			<p>
				<form:errors path="age" />
			</p>
			<p>
				<form:errors path="dojo" />
			</p>
			<p>
				<form:label path="firstName">First name: </form:label>
				<form:input path="firstName" />
			</p>
			<p>
				<form:label path="lastName">Last name: </form:label>
				<form:input path="lastName" />
			</p>
			<p>
				<form:label path="age">Age: </form:label>
				<form:input path="age" />
			</p>

			<!-- ------ SELECT TAG FROM DB ------ -->

			<p>
				<form:label path="dojo">Location: </form:label>
				<form:select path="dojo">
					<c:forEach items="${allDojos }" var="dojo">
						<c:if test="${dojo.ninjas.size() < 3}">
							<form:option value="${dojo}">
								<c:out value="${dojo.name}"></c:out>
							</form:option>
						</c:if>
					</c:forEach>
				</form:select>
			</p>


			<input type="submit" value="Submit">
		</form:form>
	</div>
</body>
</html>

