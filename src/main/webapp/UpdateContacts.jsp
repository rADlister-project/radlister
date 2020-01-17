<%--
  Created by IntelliJ IDEA.
  User: bryanwalsh
  Date: 1/10/20
  Time: 13:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a Contact</title>
</head>
<body>

<form action="/UpdateContact" method="post">

    <label for="updateFirstName">First Name:</label>
    <input type="text" name="updateFirstName" id="updateFirstName" value="${updateContact.firstName}">
    <br>
    <label for="updateLastName">Last Name:</label>
    <input type="text" name="updateLastName" id="updateLastName" value="${updateContact.lastName}">
    <br>
    <label for="updateTelephone">Telephone Number:</label>
    <input type="text" name="updateTelephone" id="updateTelephone" value="${updateContact.telephone}">
    <br>
    <input type="hidden" name="id" value="${updateContact.id}">
    <button type="submit">Edit Contact</button>
</form>

</body>
</html>
