<%--
  Created by IntelliJ IDEA.
  User: rogermayer
  Date: 1/21/20
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Delete Ad Confirm" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="container">
    <h1>Delete Ad${ad.title}?</h1>
    <form action="/deletead" method="post">
        <input type="submit" onclick="showConfirmDeleteAd()" class="btn btn-danger btn-block">
        <input type="hidden" name="adId" value="${adId}">
    </form>

</div>
</body>
</html>
