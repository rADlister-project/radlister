<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container welcome-container">
    <h1 class="rock grey">Welcome, ${sessionScope.user.username}!</h1>
    <div class="profile-btn-edit-container" >
        <form action="/edituser">
            <button class="profile-edit-btn rock" type="submit">Edit Profile</button>
        </form>
        <form action="/confirmDelete">
            <button class="profile-delete-btn rock" type="submit">Delete Profile</button>
        </form>
    </div>
</div>
<div class="container">
    <h1 id="ad-heading" class="rock grey">Here are all of your ads!</h1>
    <div class="card-container">

        <c:forEach var="ad" items="${ads}">
            <div class="card profile-card" style="width: 18rem; background-color: deeppink">
                <div class="card-body">
                    <h2 class="card-title lightgrey">${ad.title}</h2>
                    <h3 class="card-text lightgrey"><fmt:formatNumber value="${ad.price}" type="currency"/></h3>
                        <%--                    <h5 class="card-text lightgrey">${ad.description}</h5>--%>
                    <input name="id" value="${ad.id}" type="hidden">
                    <div class="profile-btn-container">
                        <form action="/EditAd">
                            <input name="adTitle" value="${ad.title}" type="hidden">
                            <input name="adPrice" value="${ad.price}" type="hidden">
                            <input name="adDescription" value="${ad.description}" type="hidden">
                            <input name="adId" value="${ad.id}" type="hidden">
                            <button class="edit-btn rock" type="submit">Edit</button>
                        </form>
                        <form action="/deleteAdConfirm" method="post">
                            <input name="adId" value="${ad.id}" type="hidden">
                            <input name="ad" value="${ad}" type="hidden">
                            <button class="btn-danger delete-btn rock " type="submit">Delete</button>
                        </form>
                        <form action="/singleAd">
                            <input name="adId" value="${ad.id}" type="hidden">
                            <input name="ad" value="${ad}" type="hidden">
                            <button class="profile-view-btn rock" type="submit">View</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>