<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Edit Ad"/>
    </jsp:include>

</head>
<body>
<jsp:include page="partials/navbar.jsp"/>
<div class="container">
    <h1>Please EDIT in your information.</h1>
    <form action="/EditAd" method="post">
        <div class="form-group">
            <label for="editAdTitle">Edit ad title:</label>
            <input type="text" name="editAdTitle" id="editAdTitle" value="${adTitle}" required>
        </div>
        <div class="form-group">
            <label for="editAdPrice">Edit price</label>
            <input type="number" name="editAdPrice" id="editAdPrice" value="${adPrice}" required>
        </div>
        <div class="form-group">
            <label for="editAdDescription">Edit description</label>
            <input type="text" name="editAdDescription" id="editAdDescription" value="${adDescription}" required>
        </div>
        <input type="hidden" name="adId" value="${adId}" required>

        <input type="submit" class="btn btn-primary btn-block">
    </form>

</div>
</body>
</html>