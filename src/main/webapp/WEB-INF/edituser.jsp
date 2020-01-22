<%--
  Created by IntelliJ IDEA.
  User: rogermayer
  Date: 1/18/20
  Time: 2:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Edit User" />
    </jsp:include>

</head>
<body>

<%--<form action="/edituser" method="post">--%>
<%--    <input type="hidden" name="userId" value="${sessionScope.user.id}">--%>

<%--    <label for="editUserName">Edit User Name:</label>--%>
<%--    <input type="text" name="editUserName" id="editUserName" value="${sessionScope.user.username}">--%>
<%--    <br>--%>
<%--    <label for="editEmail">Edit Email</label>--%>
<%--    <input type="text" name="editEmail" id="editEmail" value="${sessionScope.user.email}">--%>
<%--    <br>--%>
<%--    <label for="editPassword">Edit Password</label>--%>
<%--    <input type="password" name="editPassword" id="editPassword" placeholder="password">--%>
<%--    <br>--%>
<%--    <input type="hidden" name="id" value="${editUser.id}">--%>
<%--    <button type="submit">Edit User</button>--%>
<%--</form>--%>

<jsp:include page="partials/navbar.jsp" />
<div class="container">
    <h1>Please EDIT in your information.</h1>
    <form action="/edituser" method="post">
        <div class="form-group">
            <label for="editUserName">Edit User Name:</label>
            <input type="text" name="editUserName" id="editUserName" value="${sessionScope.user.username}">
        </div>
        <div class="form-group">
            <label for="editEmail">Edit Email</label>
            <input type="text" name="editEmail" id="editEmail" value="${sessionScope.user.email}">
        </div>
        <div class="form-group">
            <label for="editPassword">Edit Password</label>
            <input type="password" name="editPassword" id="editPassword" placeholder="password">
        </div>
        <div class="form-group">
            <label for="confirmPassword">Confirm Password</label>
            <input id="confirmPassword" name="confirmPassword" class="form-control" type="password">
        </div>
        <input type="submit" class="btn btn-primary btn-block">
        <input type="hidden" name="userId" value="${sessionScope.user.id}">
    </form>

</div>
</body>
</html>
