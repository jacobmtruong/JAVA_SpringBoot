<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a New Book</title>
</head>
<body style="padding: 100px;">
	<h1>Add a New Book to the Collection</h1>
	<hr/>
	<form action="/create" method="post">
		<h3>Title: </h3>
		<input name="title" placeholder="title"><br>
		
		<h3>description: </h3>
		<input name="description" placeholder="description"><br>
		
		<h3>Language: </h3>
		<input name="language" placeholder="language"><br>
		
		<h3>Number of Pages: </h3>
		<input name="numberOfPages" placeholder="Number of Pages"><br>
	
		<input type="submit" style="margin-top: 30px">
	</form>
</body>
</html>