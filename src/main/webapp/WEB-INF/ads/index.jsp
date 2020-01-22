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


    <h1 class="grey rock center">Here Are all the Rad ads!</h1>
    <div class="main-container">
        <div class="card-container">
            <c:forEach var="ad" items="${ads}">
                <div class="card" style="width: 18rem; background-color: #FDFF02">
                    <div class="card-body">
                        <h2 class="card-title teal">${ad.title}</h2>
                        <h4 class="card-text teal">
                            <fmt:formatNumber value="${ad.price}" type="currency" />
                        </h4>
                        <h5 class="card-text teal">${ad.description}</h5>
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


</body>
</html>
