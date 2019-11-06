<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
<h1>Hello</h1>
<h2>Welcome,</h2>
<h3> it's <c:out value="${day}"/><c:out value="${num}"/><c:out value="${month}"/><c:out value="${year}"/></h3>
</body>
</html>