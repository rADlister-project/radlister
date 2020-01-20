<%--
  Created by IntelliJ IDEA.
  User: bryanwalsh
  Date: 1/20/20
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="RadLister - Rad Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />

<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4 rock">Radlister</h1>
        <p class="lead rock">Rad Ads for a totally tubular life!</p>
    </div>
</div>

<div class="container">
    <h1>Check out some of our Rad Ads!</h1>
    <c:forEach var="ad" items="${ads}">
        <div class="card-body">
            <h5 class="card-title">${ad.title}</h5>
            <p class="card-text">${ad.price}</p>
            <p class="card-text">${ad.description}</p>
        </div>
    </c:forEach>
</div>




<body>

</body>
</html>
