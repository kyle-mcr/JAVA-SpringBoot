<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/signin.css" rel="stylesheet"/>
    <title>Registration Page</title>
</head>
<body>
	<div class="container1">
    <h1>Register!</h1>
    
    <p><form:errors path="user.*"/></p>
    
    <form:form method="POST" action="/register" modelAttribute="user">
        <p>
            <form:label path="firstName"></form:label>
            <form:input type="text" placeholder="First Name" path="firstName"/>
        </p>
        <p>
            <form:label path="lastName"></form:label>
            <form:input type="text" placeholder="Last Name" path="lastName"/>
        </p>
        <p>
            <form:label path="email"></form:label>
            <form:input type="email" placeholder="Email" path="email"/>
        </p>
        <p>
            <form:label path="password"></form:label>
            <form:password placeholder="Password" path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation"></form:label>
            <form:password placeholder="Confirm Password" path="passwordConfirmation"/>
        </p>
        <input class="button" type="submit" value="Register!"/>
    </form:form>
    </div>
    <div class="container2">
    <h1>Login</h1>
    <p>${error}</p>
    <form method="post" action="/login">
        <p>
            <label for="email"></label>
            <input type="text" placeholder="Email" id="email" name="email_l"/>
        </p>
        <p>
            <label for="password"></label>
            <input type="password" placeholder="Password" id="password" name="password_l"/>
        </p>
        <input class="button" type="submit" value="Login!"/>
    </form>    
    </div>
</body>
</html>