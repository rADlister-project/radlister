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
    <div id="banner" class="container">
        <h1 id="bannerlogo" class="display-4 white rock">Radlister</h1>
        <p class="lead white rock">Rad Ads for a totally tubular life!</p>
    </div>
</div>

<div class="container">
    <h1 class="grey rock">Check out some of our Rad Ads!</h1>
    <c:forEach var="ad" items="${ads}">
        <div class="card-body">
            <h5 class="card-title grey">${ad.title}</h5>
            <p class="card-text grey">${ad.price}</p>
            <p class="card-text grey">${ad.description}</p>
        </div>
        <form action="/singleAd">
            <input name="adId" value="${ad.id}"type="hidden">
            <input name="ad" value="${ad}"type="hidden">
            <button class="btn" type="submit">View this ad</button>
        </form>
    </c:forEach>
</div>





<body>

</body>
</html>

