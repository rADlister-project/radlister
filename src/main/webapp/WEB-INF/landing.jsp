<%--
  Created by IntelliJ IDEA.
  User: bryanwalsh
  Date: 1/20/20
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="RadLister - Rad Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp"/>

<div class="jumbotron jumbotron-fluid">
    <div id="banner" class="container">
        <h1 id="bannerlogo" class="display-4 white rock">Radlister</h1>
        <p class="lead white rock">Rad Ads for a totally tubular life!</p>
    </div>
</div>
<div class="main-container welcome-container container">
    <h1 class="grey rock " style="margin-top: 2%; margin-bottom: 5%">Check out some of our Rad Ads!</h1>
    <div class="card-container">
        <c:forEach var="ad" items="${ads}">
            <div class="card landing-card" style="width: 18rem; background-color: deeppink">
                <div class="card-body">
                    <h2 class="card-title lightgrey">${ad.title}</h2>
                    <h4 class="card-text lightgrey">
                        <fmt:formatNumber value="${ad.price}" type="currency"/>
                    </h4>
                        <%--                        <h3 class="card-text grey">${ad.price}</h3>--%>
                        <%--                        <p class="card-text grey">${ad.description}</p>--%>
                    <form action="/singleAd">
                        <input name="adId" value="${ad.id}" type="hidden">
                        <input name="ad" value="${ad}" type="hidden">
                        <button class="btn landingViewBtn rock" type="submit" style="margin-top:15px;">View</button>
                    </form>
                </div>

            </div>
        </c:forEach>
    </div>
</div>

<jsp:include page="partials/footer.jsp"></jsp:include>
</body>
</html>

