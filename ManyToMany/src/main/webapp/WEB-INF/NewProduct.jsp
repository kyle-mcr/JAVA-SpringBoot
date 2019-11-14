<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="css/style.css">
<h1>New Product</h1>
<form:form action="/products/new" method="post" modelAttribute="product" cssClass="test">
    <form:label path="name">
        Name:
        <form:errors path="name"/>
        <form:input path="name"/>
    </form:label><br>
    <form:label path="description">
        Description:
        <form:errors path="description"/>
        <form:textarea path="description" cols="30" rows="4"/>
    </form:label><br>
    <form:label path="price">
        Price:
        <form:errors path="price"/>
        <form:input path="price"/>
    </form:label><br>
    <button>Create</button>
</form:form>
