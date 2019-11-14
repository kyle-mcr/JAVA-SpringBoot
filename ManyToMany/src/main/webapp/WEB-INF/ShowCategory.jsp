<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="css/style.css">
<h1>${category.name}</h1>

<div>
    <h3>Products:</h3>
    <ul>
    <%--loop over products--%>
        <c:forEach var="product" items="${category.products}" >
            <li><a href="/products/${product.id}">${product.name}</a></li>

        </c:forEach>
    </ul>
</div>
<div>
    <form method="post" action="/categories/addproduct">
        <input type="hidden" value="${category.id}" name="categoryId">
        <select name="productVal" >
            <c:forEach items="${products}" var="product">
                <option value="${product.id}">${product.name}</option>
            </c:forEach>
        </select>
        <button>Add Category</button>
    </form>
</div>
