<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    <form action="/logout">
        <button type="submit">Logout</button>
    </form>
        <form action="/edituser">
            <button type="submit">Edit Profile</button>
        </form>
    </div>
    <div class="container">
        <h1>Here are all of your ads!</h1>
        <c:forEach var="ad" items="${ads}">
            <div class="card-body">
                <h5 class="card-title">${ad.title}</h5>
                <p class="card-text">${ad.price}</p>
                <p class="card-text">${ad.description}</p>
                <p class="card-text">
                <form action="/profile" method="post">
                    <input name="id" value="${ad.id}"type="hidden">
                    <button type="submit">Update this ad</button>
                </form>
            </div>
        </c:forEach>
    </div>

</body>
</html>
