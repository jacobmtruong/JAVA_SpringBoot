<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>One Book</title>
</head>
<body style="padding: 100px;">
	<h1>${onebook.title }</h1>
	<ul>
		<li>${onebook.description }</li>
		<li>${onebook.language }</li>
		<li>${onebook.numberOfPages }</li>
	</ul>
</body>
</html>