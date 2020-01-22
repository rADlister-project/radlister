<%--
  Created by IntelliJ IDEA.
  User: rogermayer
  Date: 1/21/20
  Time: 9:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Edit User" />
    </jsp:include>

</head>

<head>
    <title>Delete User</title>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="container">
    <h1>Delete ${sessionScope.user.username}'s Account</h1>
    <form action="/deleteuser" method="post">
        <div class="form-group">
            <label for="confirmPassword">Confirm Password</label>
            <input id="confirmPassword" name="confirmPassword" class="form-control" type="password">
        </div>
        <input type="submit" onclick="showConfirmDelete()" class="btn btn-primary btn-block">
        <input type="hidden" name="userId" value="${sessionScope.user.id}">
    </form>

</div>
</body>
</html>