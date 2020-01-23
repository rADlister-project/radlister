<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand teal rock" href="/ads">Radlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">

            <c:if test="${sessionScope.user != null}">
                <li>
                    <a href="/login" class="teal rock navlink">profile</a>
                </li>
                <li>
                    <a href="/ads/create" class="teal rock navlink">List Your Ad!</a>
                </li>
                <li>
                    <a href="/logout" class="teal rock navlink">logout</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.user == null}">
                <li>
                    <a href="/register" class="teal rock navlink">Register</a>
                </li>
                <li>
                    <a href="/login" class="teal rock navlink">login</a>
                </li>
            </c:if>
            <li>
                <form method="POST" action="/ads" id="searchForm">
                    <input type="text" name="search" id="searchBar" placeholder="Search" value="<c:out value="${userInput}"></c:out>">
                    <button id="searchButton">Submit</button>
                </form>

            </li>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
