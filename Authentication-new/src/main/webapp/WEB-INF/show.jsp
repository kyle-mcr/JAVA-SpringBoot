<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
</head>
<body>
	<div class="container">
    	<h1>${movie.title }</h1>
    	<p>${movie.description }</p>
    	<p>${movie.creator.firstName } ${movie.creator.lastName }</p>
    	<p>${movie.likers.size()}</p>
    	<a href="/home">Go Back</a>
    </div>
</body>
</html>