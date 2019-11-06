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
<h1>Hello!</h1>
<h2>Welcome, <c:out value="${dojoName}"/> Cohort</h2>
<p><a href="/date">Show me the date</a></p>
<p><a href="/time">Show me the time</a></p>
</body>
</html>