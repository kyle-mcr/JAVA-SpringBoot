<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<h1>What is the code?</h1>
<form method="POST" action="/results">
    <input type="text" name="name">
  <select name="location">
  <option value="San Jose">San Jose</option>
  <option value="LA">LA</option>
  <option value="Seattle">Seattle</option>
  <option value="Chicago">Chicago</option>
  </select>
<select name="language">
  <option value="Python">Python</option>
  <option value="Java">Java</option>
  <option value="Angular">Angular</option>
  <option value="Javascript">Javascript</option>
</select>
 <input type="text" name="comment">
    <button>Button</button>
</form>

</body>
</html>