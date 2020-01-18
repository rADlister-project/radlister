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
    <title>Edit A User</title>
</head>
<body>
<form action="/EditUser" method="post">

    <label for="editUserName">User Name:</label>
    <input type="text" name="editUserName" id="editUserName" value="${editUser.firstName}">
    <br>
    <label for="updateLastName">Last Name:</label>
    <input type="text" name="updateLastName" id="updateLastName" value="${editEmail.email}">
    <br>
    <label for="updateTelephone">Telephone Number:</label>
    <input type="text" name="updateTelephone" id="updateTelephone" value="${editPassword.password}">
    <br>
    <input type="hidden" name="id" value="${editUser.id}">
    <button type="submit">Edit User</button>
</form>
</body>
</html>
