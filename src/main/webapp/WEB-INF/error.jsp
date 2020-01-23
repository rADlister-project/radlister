<%--
  Created by IntelliJ IDEA.
  User: thomasoffer
  Date: 1/23/20
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="ERROR!" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="jumbotron jumbotron-fluid">
    <div id="banner" class="container">
        <h1 id="bannerlogo" class="display-4 white rock">Radlister</h1>
        <p class="lead white rock">Rad Ads for a totally tubular life!</p>
    </div>
</div>
<div class="card" style="width: 18rem; background-color: deeppink">
    <div class="card-body">
        <h3 class="card-title">ERROR!</h3>
        <p class="card-text">There was an Error!</p>
        <p class="card-text">Please try again!</p>
        <p class="card-text">
    </div>
</div>
<jsp:include page="partials/footer.jsp"></jsp:include>
</body>
</html>
