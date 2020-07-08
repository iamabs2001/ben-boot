<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> update </title>
</head>
<body>
		<h1> Update Details </h1>
	<form action="/saveUpdates/${id}" method="post">
		<input type="hidden" name="id2" value="${id}">
		<input type="text" placeholder="username" name="name" value="${name}"><br>
		<input type="password" placeholder="password" name="pass" value="${pass}"><br>
		<input type="submit"> 
	</form>
</body>
</html>