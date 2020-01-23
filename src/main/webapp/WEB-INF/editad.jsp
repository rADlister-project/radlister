<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Edit Ad"/>
    </jsp:include>

</head>
<body>
<jsp:include page="partials/navbar.jsp"/>
<div class="container welcome-container">
    <h1 class="rock grey">Please EDIT in your information.</h1>
    <form action="/EditAd" method="post" id="editAd">
        <div class="form-group">
            <label class="edit-label grey" for="editAdTitle">Edit ad title</label>
            <input class="form-control edit-input" type="text" name="editAdTitle" id="editAdTitle" value="${adTitle}" required>
        </div>
        <div class="form-group">
            <label class="edit-label grey" for="editAdPrice">Edit price</label>
            <input class="form-control edit-input" type="number" name="editAdPrice" id="editAdPrice" value="${adPrice}" required>
        </div>
        <div class="form-group">
            <label class="edit-label grey" for="editAdDescription">Edit description</label>
            <textarea class="form-control edit-input" type="text" name="editAdDescription" form="editAd" id="editAdDescription" value="${adDescription}" required></textarea>
        </div>
        <input type="hidden" name="adId" value="${adId}" required>

        <input type="submit" class="btn edit-btn btn-block rock btn-space-fix">
    </form>

</div>
<jsp:include page="partials/footer.jsp"></jsp:include>
</body>
</html>