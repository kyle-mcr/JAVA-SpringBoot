<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
        <link href="/other.css" rel="stylesheet"/>
    <title>Edit Page</title>
</head>
<body>
	<div class="container1">
	<h1>Edit! </h1>
	<h2>${idea.content }</h2>
    	<p><form:errors path="idea.*"/></p>
    
    <form:form method="POST" action="/edit/${idea.id}" modelAttribute="idea">
        <p>
            <form:label path="content">Content:</form:label>
            <form:input type="text" path="content"/>
        </p>
     
        <input class="button" type="submit" value="Edit"/>
    </form:form>
    	<a href="/home">Go Back</a>
    </div>
</body>
</html>