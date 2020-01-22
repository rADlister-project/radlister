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
    <h1 class="grey rock center">Check out some of our Rad Ads!</h1>
    <div class="main-container">
        <div class="card-container">
    <c:forEach var="ad" items="${ads}">
            <div class="card employer" id="ad" style="width: 200px;">
                <div class="card" style="width: 18rem; background-color: deeppink">
                    <div class="card-body">
                        <h3 class="card-title grey">${ad.title}</h3>
                        <p class="card-text grey">${ad.price}</p>
                        <p class="card-text grey">${ad.description}</p>
                    </div>
                    <form action="/singleAd">
                        <input name="adId" value="${ad.id}"type="hidden">
                        <input name="ad" value="${ad}"type="hidden">
                        <button class="btn" type="submit">View this ad</button>
                    </form>
                </div>
            </div>
    </c:forEach>
        </div>
    </div>






<body>

</body>
</html>

