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
	<h1>Movies You Like</h1>
    	<table>
    	<thead>
    	<tr>
    	<th>Title</th>
    	<th>Description</th>
    	<th>Poster</th>
    	<th>Actions</th>
    	<th>Likes</th>
    	</tr>
    	</thead>
    	<tbody>
    	<c:forEach items="${movies}" var = "movie">
    	<c:if test="${movie.likers.contains(user) == true }">
    	<tr>
    	<td><a href="/show/${movie.id }">${movie.title }</a></td>
    	<td>${movie.description }</td>
    	<td>${movie.creator.firstName } ${movie.creator.lastName }</td>
    	<c:if test="${movie.creator.id == user.id }">
	    	<td>
	    	<a href="/edit/${movie.id }">Edit</a> | 
	    	<a href="/delete/${movie.id }">Delete</a>
	    	</td>
    	</c:if>
    	<c:if test="${movie.creator.id != user.id }">
	    	<c:if test="${movie.likers.contains(user) == true }">
	    	<td>
	    		<a href="/unlike/${movie.id }">Unlike</a>
	    	</td>
    	</c:if>
    	</c:if>
    	<td>${movie.likers.size() }</td>
    	</tr>
    	</c:if>
    	</c:forEach>
    	<c:forEach items="${movies}" var = "movie">
    	<c:if test="${movie.creator == user }">
    	<tr>
    	<td><a href="/show/${movie.id }">${movie.title }</a></td>
    	<td>${movie.description }</td>
    	<td>${movie.creator.firstName } ${movie.creator.lastName }</td>
    	<c:if test="${movie.creator.id == user.id }">
	    	<td>
	    	<a href="/edit/${movie.id }">Edit</a> | 
	    	<a href="/delete/${movie.id }">Delete</a>
	    	</td>
    	</c:if>
    	<c:if test="${movie.creator.id != user.id }">
	    	<td>
	    	<p>do unlike later</p>
	    	</td>
    	</c:if>
    	<td>${movie.likers.size() }</td>
    	</tr>
    	</c:if>
    	</c:forEach>
    	</tbody>
    	</table>  
    	<a href="/new">Post a Movie</a>
    </div>
    <div class="container2">
    	<table>
    	<thead>
    	<tr>
    	<th>Title</th>
    	<th>Description</th>
    	<th>Poster</th>
    	<th>Actions</th>
    	<th>Likes</th>
    	</tr>
    	</thead>
    	<tbody>
    	<c:forEach items="${movies}" var = "movie">
    	<c:if test="${movie.likers.contains(user) == false}">
    	<c:if test="${movie.creator != user }">
    	<tr>
    	<td><a href="/show/${movie.id }">${movie.title }</a></td>
    	<td>${movie.description }</td>
    	<td>${movie.creator.firstName } ${movie.creator.lastName }</td>
    	<c:if test="${movie.creator.id == user.id }">
	    	<td>
	    	<a href="/edit/${movie.id }">Edit</a> | 
	    	<a href="/delete/${movie.id }">Delete</a>
	    	</td>
    	</c:if>
    	<c:if test="${movie.creator.id != user.id }">
    	<c:if test="${movie.likers.contains(user) == false }">
	    	<td>
	    		<a href="/like/${movie.id }">Like</a>
	    	</td>
    	</c:if>
    	<c:if test="${movie.likers.contains(user) == true }">
	    	<td>
	    		<a href="/unlike/${movie.id }">Unlike</a>
	    	</td>
    	</c:if>
    	</c:if>
    	<td>${movie.likers.size() }</td>
    	
    	</c:if>
    	</c:if>
    	</c:forEach>
    	</tbody>
    	    	    	<a href="/new">Post a Movie</a>
    	    	<a href="/logout">Logout</a>
    	</table>  

    	
    </div>
</body>
</html>