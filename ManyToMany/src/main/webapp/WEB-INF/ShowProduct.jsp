<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="css/style.css">
<h1>${product.name}</h1>

<div>
    <h3>Categories</h3>
    <ul>
    <%--loop over categories--%>
        <c:forEach items="${product.categories}" var="cat">

            <li><a href="/categories/${cat.id}">${cat.name}</a></li>
        </c:forEach>
    </ul>
</div>
<div>
    <form method="post" action="/products/addcategory">
        <input type="hidden" value="${product.id}" name="productId">
        <select name="categoryVal" >
            <c:forEach items="${categories}" var="category">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
        <button>Add Category</button>
    </form>

</div>