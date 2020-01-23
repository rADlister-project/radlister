<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container login-page">
    <h1 class="rock grey">Please Log In</h1>
    <form action="/login" method="POST">
        <div class="form-group">
            <label class="login-label grey" for="username">Username</label>
            <input id="username" name="username" class="form-control login-input" type="text" required>
        </div>
        <div class="form-group">
            <label class="login-label grey" for="password">Password</label>
            <input id="password" name="password" class="form-control login-input" type="password" required>
        </div>
        <input type="submit" class="btn btn-block rock" id="login-button" value="Log In">
    </form>
</div>
<jsp:include page="partials/footer.jsp"></jsp:include>
</body>
</html>
