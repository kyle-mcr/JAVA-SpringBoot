<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="css/style.css">

<h1>New Category</h1>
<form:form action="/categories/new" method="post" modelAttribute="category">
    <form:label path="name">
        Name:
        <form:errors path="name"/>
        <form:input path="name"/>
    </form:label><br>
    <button>Create</button>

</form:form>