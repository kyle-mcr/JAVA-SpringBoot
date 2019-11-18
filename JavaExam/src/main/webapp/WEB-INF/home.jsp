<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/other.css" rel="stylesheet"/>
    <title>Home Page</title>
</head>
<body>
	<div class="container2">
	
	<h1>Welcome, ${user.firstName }</h1>
	<h2>Ideas:</h2>
    	<table class="table">
    	<thead>
    	<tr>
    	<th>Ideas</th>
    	<th>Created By:</th>
    	<th>Actions</th>
    	<th>Likes</th>
    	</tr>
    	</thead>
    	<tbody>
    	
    	<c:forEach items="${ideas}" var = "idea">
    	<tr>
    	<td><a href="/show/${idea.id }">${idea.content }</a></td>
    	<td>${idea.creator.firstName } ${idea.creator.lastName }</td>
    	<c:if test="${idea.creator.id == user.id }">
	    	<td>
	    	<a href="/edit/${idea.id }">Edit</a>
	    	<a href="/delete/${idea.id }">Delete</a>
	    	</td>
    	</c:if>
    <c:if test="${idea.creator.id != user.id }">
    	<c:if test="${idea.likers.contains(user) == false }">
	    	<td>
	    		<a href="/like/${idea.id }">Like</a>
	    	</td>
    	</c:if>
    	<c:if test="${idea.likers.contains(user) == true }">
	    	<td>
	    		<a href="/unlike/${idea.id }">Unlike</a>
	    	</td>
    	</c:if>
    	</c:if>
    	<td>${idea.likers.size() }</td>
    	</tr>
    	</c:forEach>
    	
    	</tbody>
    	</table>  
    	<a href="/new">Create an Idea!</a>
<a href="/logout">Logout</a>
</div>
</body>
</html>