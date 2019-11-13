<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Person</title>
</head>
<body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ page isErrorPage="true" %>    
<h1>New Ninja</h1>
<form:form modelAttribute="ninja" method="post" action="/ninjas/new">
    <form:label path="dojo">
        Dojo:
        <form:select path="dojo">
        <c:forEach var="x" items="${dojos}" >
                <form:option value="${x.id}">${x.name}</form:option>
            </c:forEach>
        </form:select>
    </form:label><br>
    <form:label path="firstName">
        First Name:
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </form:label><br>
    <form:label path="lastName">
        Last Name:
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </form:label><br>
    <form:label path="age">
        Age:
        <form:errors path="age"/>
        <form:input path="age"/>
    </form:label><br>
    <button>Create</button>
</form:form>
</body>
</html>