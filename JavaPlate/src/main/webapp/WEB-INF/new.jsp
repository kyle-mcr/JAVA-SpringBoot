<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/signin.css" rel="stylesheet"/>
    <title>New Page</title>
</head>
<body>
	<div class="container1">
	<h1>Add a movie!</h1>
    	<p><form:errors path="movie.*"/></p>
    
    <form:form method="POST" action="/new" modelAttribute="movie">
        <p>
            <form:label path="title"></form:label>
            <form:input type="text" placeholder="Title" path="title"/>
        </p>
        <p>
            <form:label path="description"></form:label>
            <form:input type="text" placeholder="Description" path="description"/>
        </p>
        
        <input class="button" type="submit" value="Add"/>
    </form:form>
    	<a href="/home">Go Back</a>
    </div>
</body>
</html>