
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="card" style="width: 18rem; background-color: deeppink">
    <div class="card-body">
        <h3 class="card-title"><c:out value="${ads.title}"/></h3>
        <p class="card-text"><c:out value="${ads.price}"/></p>
        <p class="card-text"><c:out value="${ads.description}"/></p>
        <p class="card-text">
            <input name="id" value="${ads.id}"type="hidden">
    </div>
</div>
</body>
</html>
