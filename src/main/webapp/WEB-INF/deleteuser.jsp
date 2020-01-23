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
        <jsp:param name="title" value="Delete User"/>
    </jsp:include>

</head>

<body>
<jsp:include page="partials/navbar.jsp"/>
<div class="container welcome-container">
    <h1 class="rock grey">Delete ${sessionScope.user.username}'s Account</h1>
    <form action="/deleteuser" method="post">
        <div class="form-group">
            <label class="register-label grey" for="confirmPassword">Confirm Password</label>
            <input id="confirmPassword" name="confirmPassword" class="form-control register-input" type="password">
            <input type="submit" onclick="showConfirmDelete()" class="btn btn-block profile-delete-btn btn-space-fix">
            <input type="hidden" name="userId" value="${sessionScope.user.id}">
        </div>

    </form>

</div>
</body>
</html>