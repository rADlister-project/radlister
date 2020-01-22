<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand teal rock" href="/ads">Radlister</a>
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
                    <a href="/login" class="teal rock">profile</a>
                </li>
                <li>
                    <a href="/ads/create" class="teal rock">List Your Ad!</a>
                </li>
                <li>
                    <a href="/logout" class="teal rock">logout</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.user == null}">
                <li>
                    <a href="/register" class="teal rock">Register</a>
                </li>
                <li>
                    <a href="/login" class="teal rock">login</a>
                </li>
            </c:if>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
