<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/signin.css" rel="stylesheet"/>
    <title>Show Page</title>
</head>
<body>
	<div class="container1">
    	<h1>Idea: ${idea.content }</h1>
    	<p>Created By: ${idea.creator.firstName } ${idea.creator.lastName }</p>
    	<p>Number of Likes:${idea.likers.size()}</p>
    	<a href="/home">Go Back</a>
    	</div>

</body>
</html>