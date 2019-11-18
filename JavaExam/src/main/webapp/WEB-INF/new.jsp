<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/other.css" rel="stylesheet"/>
    <title>New Page</title>
</head>
<body>
	<div class="container1">
	<h1>Add an Idea!</h1>
    	<p><form:errors path="idea.*"/></p>
    
    <form:form method="POST" action="/new" modelAttribute="idea">
        <p>
            <form:label path="content"></form:label>
            <form:input type="text" placeholder="Content" path="content"/>
        </p>
        
        <input class="button" type="submit" value="Add"/>
    </form:form>
    	<a href="/home">Go Back</a>
    </div>
</body>
</html>