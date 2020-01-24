<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: thomasoffer
  Date: 1/22/20
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing an Ad"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div id="single-ad-container">
    <div class="card single-ad-card">
        <div class="card-body" id="single-ad-card">
            <h1 class="card-title center rock lightgrey" id="single-ad-title"><c:out value="${ads.title}"/></h1>
            <hr class="single-ad-line">
            <h3 class="card-text lightgrey" id="single-ad-price"><fmt:formatNumber value="${ads.price}" type="currency"/></h3>
            <h4 class="card-text lightgrey" id="single-ad-description"><c:out value="${ads.description}"/></h4>

            <input name="id" value="${ads.id}" type="hidden">
        </div>
    </div>
</div>
<jsp:include page="../partials/footer.jsp"></jsp:include>

</body>
</html>
