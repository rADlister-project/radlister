<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container welcome-container">
        <h1 class="rock grey">Create a new Ad</h1>
        <form action="/ads/create" method="post" id="create-form">
            <div class="form-group">
                <label class="create-label grey" for="title">Title</label>
                <input id="title" name="title" class="form-control create-input" type="text">
            </div>
            <div class="form-group">
                <label class="create-label grey" for="price">Price</label>
                <input id="price" name="price" class="form-control create-input" type="number">
            </div>
            <div class="form-group">
                <label class="create-label grey" for="description">Description</label>
                <textarea id="description" name="description" class="form-control create-input" form="create-form" type="text"></textarea>
            </div>
<%--            <div class="form-group">--%>
<%--                &lt;%&ndash;Checkboxes only send a value if they are checked, thus in servlets we can verfiy them by comparing them against null&ndash;%&gt;--%>
<%--                <label  class="label2" for="checkbox1">For Sale</label>--%>
<%--                <input type="checkbox" name="checkbox1" id="checkbox1" value="1">--%>
<%--                <label  class="label2" for="checkbox2">Free Stuff</label>--%>
<%--                <input type="checkbox" name="checkbox2" id="checkbox2" value="2">--%>
<%--                <label  class="label2" for="checkbox3">Help Wanted</label>--%>
<%--                <input type="checkbox" name="checkbox3" id="checkbox3" value="3">--%>
<%--                <label  class="label2" for="checkbox4">Gigs</label>--%>
<%--                <input type="checkbox" name="checkbox4" id="checkbox4" value="4">--%>
<%--                <label  class="label2" for="checkbox5">Services</label>--%>
<%--                <input type="checkbox" name="checkbox5" id="checkbox5" value="5">--%>
<%--                <label  class="label2" for="checkbox6">Housing</label>--%>
<%--                <input type="checkbox" name="checkbox6" id="checkbox6" value="6">--%>
<%--                <label  class="label2" for="checkbox7">Community</label>--%>
<%--                <input type="checkbox" name="checkbox7" id="checkbox7" value="7">--%>
<%--            </div>--%>
            <input id="create-button" type="submit" class="btn btn-block rock">
        </form>
    </div>
<jsp:include page="../partials/footer.jsp"></jsp:include>
</body>
</html>
