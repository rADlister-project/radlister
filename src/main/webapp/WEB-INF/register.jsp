<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container register-page">
        <h1 class="rock grey"   >Please fill in your information.</h1>
        <form action="/register" method="post">
            <div class="form-group">
                <label class="register-label grey" for="username">Username</label>
                <input id="username" name="username" class="form-control register-input" type="text" required>
            </div>
            <div class="form-group">
                <label class="register-label grey" for="email">Email</label>
                <input id="email" name="email" class="form-control register-input" type="text" required>
            </div>
            <div class="form-group">
                <label class="register-label grey"for="password">Password</label>
                <input id="password" name="password" class="form-control register-input" type="password" required>
            </div>
            <div class="form-group">
                <label class="register-label grey" for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control register-input" type="password" required>
            </div>
            <input id="register-button" type="submit" class="btn btn-primary btn-block rock">
        </form>
    </div>
</body>
</html>
