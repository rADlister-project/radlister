<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <form method="POST" action="/ads" id="searchForm">
                    <input type="text" name="search" id="search" placeholder="Search" value="<c:out value="${userInput}"></c:out>">
                    <button>Submit</button>
                </form>

            </li>
            <c:if test="${sessionScope.user != null}">
                <li>
                    <a href="/login">profile</a>
                </li>
                <li>
                    <a href="/ads/create">List Your Ad!</a>
                </li>
                <li>
                    <a href="/logout">logout</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.user == null}">
                <li>
                    <a href="/register">Register</a>
                </li>
                <li>
                    <a href="/login">login</a>
                </li>
            </c:if>
        </ul>

<%--        <div class="topnav">--%>
<%--            <div class="navbar-header">--%>
<%--                <a class="navbar-brand" href="/ads">Adlister</a>--%>
<%--            </div>--%>
<%--            <c:if test="${sessionScope.user != null}">--%>
<%--                <li>--%>
<%--                    <a href="/login">profile</a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="/ads/create">List Your Ad!</a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="/logout">logout</a>--%>
<%--                </li>--%>
<%--            </c:if>--%>
<%--            <c:if test="${sessionScope.user == null}">--%>
<%--                <li>--%>
<%--                    <a href="/register">Register</a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="/login">login</a>--%>
<%--                </li>--%>
<%--            </c:if>--%>
<%--            <div class="search-container">--%>
<%--                <form action="/search">--%>
<%--                    <input type="text" placeholder="Search.." name="search">--%>
<%--                    <button type="submit"><i class="fa fa-search"></i></button>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
