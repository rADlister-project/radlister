<%--
  Created by IntelliJ IDEA.
  User: bryanwalsh
  Date: 1/10/20
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a Contact</title>
</head>
<body>

<form action="/AddContact" method="post">

    <label name="firstName">First Name:</label>
    <input type="text" name="firstName" id="firstName">
    <br>
    <label name="lastName">Last Name:</label>
    <input type="text" name="lastName" id="lastName">
    <br>
    <label name="telephone">Telephone Number:</label>
    <input type="text" name="telephone" id="telephone">
    <br>
    <input type="submit">
</form>

</body>
</html>
