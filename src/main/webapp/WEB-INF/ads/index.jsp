<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />


    <div class="main-container welcome-container">
        <h1 class="grey rock"style="margin-bottom: 1em;">Here Are all the Rad ads!</h1>
        <div class="card-container">
            <c:forEach var="ad" items="${ads}">
                <div class="card landing-card" style="width: 18rem; background-color: deeppink">
                    <div class="card-body">
                        <h2 class="card-title lightgrey">${ad.title}</h2>
                        <h4 class="card-text lightgrey">

                            <fmt:formatNumber value="${ad.price}" type="currency" />
                        </h4>
<%--                        <h5 class="card-text teal">${ad.description}</h5>--%>
                        <form action="/singleAd">
                            <input name="adId" value="${ad.id}"type="hidden">
                            <input name="ad" value="${ad}"type="hidden">
                            <button class="btn landingViewBtn rock" style="margin-top: 15px;" type="submit">View</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

<jsp:include page="../partials/footer.jsp"></jsp:include>
</body>
</html>
