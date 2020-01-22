<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container d-flex">
    <h1>Welcome, ${sessionScope.user.username}!</h1>
    <form action="/logout">
        <button type="submit">Logout</button>
    </form>
    <form action="/edituser">
        <button type="submit">Edit Profile</button>
    </form>
    <form action="/confirmDelete" method="post">
        <button type="submit">Delete Profile</button>
    </form>
</div>
<div class="container">
    <h1>Here are all of your ads!</h1>
    <c:forEach var="ad" items="${ads}">

        <div class="card text-center" style="width:400px">
            <img class="card-img-top" src="img_avatar1.png" alt="Card image">
            <h4 class="card-title">Title: ${ad.title}</h4>
            <p class="card-text">Price: $${ad.price}</p>
            <p class="card-text">Decription: ${ad.description}</p>
<%--                <a href="#" class="btn btn-primary">See Profile</a>--%>
            <input name="id" value="${ad.id}" type="hidden">
            <div class="card-buttons d-flex">
                <form action="/profile" method="post">
                    <input name="adTitle" value="${ad.title}" type="hidden">
                    <input name="adPrice" value="${ad.price}" type="hidden">
                    <input name="adDescription" value="${ad.description}" type="hidden">
                    <button class="btn-primary" type="submit">Edit this ad</button>
                </form>
                <form action="/deleteAdConfirm" method="post">
                    <input name="adId" value="${ad.id}" type="hidden">
                    <input name="ad" value="${ad}" type="hidden">
                    <button class="btn-danger" type="submit">Delete this ad</button>
                </form>
                <form action="/singleAd">
                <input name="adId" value="${ad.id}"type="hidden">
                <input name="ad" value="${ad}"type="hidden">
                <button type="submit">View this ad</button>
                </form>
            </div>

        </div>
<%--        </div>--%>

<%--        <div class="card-body text-center">--%>
<%--            <h5 class="card-title">${ad.title}</h5>--%>
<%--            <p class="card-text">${ad.price}</p>--%>
<%--            <p class="card-text">${ad.description}</p>--%>
<%--            <p class="card-text">--%>
<%--                <input name="id" value="${ad.id}" type="hidden">--%>

<%--            <div class="card-buttons">--%>
<%--                <form action="/profile" method="post">--%>
<%--                    <input name="adTitle" value="${ad.title}" type="hidden">--%>
<%--                    <input name="adPrice" value="${ad.price}" type="hidden">--%>
<%--                    <input name="adDescription" value="${ad.description}" type="hidden">--%>
<%--                    <button class="btn-primary" type="submit">Edit this ad</button>--%>
<%--                </form>--%>
<%--                <form action="/deleteAdConfirm" method="post">--%>
<%--                    <input name="adId" value="${ad.id}" type="hidden">--%>
<%--                    <input name="ad" value="${ad}" type="hidden">--%>
<%--                    <button class="btn-danger" type="submit">Delete this ad</button>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
    </c:forEach>
</div>

</body>
</html>
