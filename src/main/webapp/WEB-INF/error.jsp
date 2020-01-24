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
        <h1 id="bannerlogo" class="display-4 mb-5 white rock">Radlister</h1>
        <p class="lead white rock">Rad Ads for a totally tubular life!</p>
    </div>
</div>
<div class="card" id="error-card">
    <div class="card-body">
        <h1 class="card-title grey rock" id="error-head">Woah, something went wrong!</h1>
        <h2 class="card-text grey rock" >Please try again!</h2>
        <h3 class="card-text grey">We're sure it's not you, it's us! Okay... it was probably you, but we'll take the hit this time!</h3>
    </div>
</div>
<jsp:include page="partials/footer.jsp"></jsp:include>
</body>
</html>
