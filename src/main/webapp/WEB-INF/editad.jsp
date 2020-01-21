<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Edit Ad" />
    </jsp:include>

</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="container">
    <h1>Please EDIT in your information.</h1>
    <form action="/editad" method="post">
        <div class="form-group">
            <label for="editAdTitle">Edit ad title:</label>
            <input type="text" name="editAdTitle" id="editAdTitle" value="${sessionScope.ad.title}">
        </div>
        <div class="form-group">
            <label for="editPrice">Edit price</label>
            <input type="text" name="editPrice" id="editPrice" value="${sessionScope.ad.price}">
        </div>
        <div class="form-group">
            <label for="editAdDescription">Edit description</label>
            <input type="text" name="editAdDescription" id="editAdDescription" value="${sessionScope.ad.description}">
        </div>

        <input type="submit" class="btn btn-primary btn-block">
        <input type="hidden" name="adId" value="${sessionScope.ad.id}">
    </form>

</div>
</body>