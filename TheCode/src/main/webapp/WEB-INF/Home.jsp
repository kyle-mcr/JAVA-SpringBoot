<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<h1>What is the code?</h1>
<form method="POST" action="/guess">
    <input type="text" name="guess">
    <button>Try Code</button>
</form>
<h2><c:out value="${error}"/></h2>
</body>
</html>