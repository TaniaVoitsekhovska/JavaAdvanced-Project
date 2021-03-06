<!DOCTYPE html>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-grey fixed-top bg-dark">
    <a class="navbar-brand" href="/"><spring:message code="welcome"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <li class="nav-item">
                    <a class="nav-link" href="/faculties/create">Create faculty </a>
                </li>
            </security:authorize>
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="/specialities/create">Create speciality </a>
                    </li>
                </security:authorize>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <li class="nav-item">
                    <a class="nav-link" href="/subjects/create">Create subject </a>
                </li>
            </security:authorize>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <li class="nav-item">
                    <a class="nav-link" href="/allUsers">User list </a>
                </li>
            </security:authorize>
                <security:authorize access="hasRole('ROLE_USER')">
            <li class="nav-item">
                <a class="nav-link" href="/cabinet"><spring:message code="cabinet"/></a>
            </li>
                </security:authorize>
            <security:authorize access="hasRole('ROLE_USER')">
                <li class="nav-item">
                    <a class="nav-link" href="/apply">Apply</a>
                </li>
            </security:authorize>
        </ul>
        <security:authorize access="isAuthenticated()">
            <security:authentication property="principal.username" />
            <form action="/logout" method="post">
                <input type="submit" class="btn btn-outline-success ml-2 my-2 my-sm-0" value="<spring:message code="logout"/>"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>

        </security:authorize>
        <div class="mr-2">
            <select id="locates">
                <option value="en">En</option>
                <option value="ua">Ua</option>
            </select>
        </div>
        <security:authorize access="!isAuthenticated()">
            <a href="/login" class="btn btn-outline-success my-2 my-sm-0">Log in</a>
        </security:authorize>
        <security:authorize access="!isAuthenticated()">
            <a href="/registration" class="btn btn-outline-success ml-2 my-2 my-sm-0">Sign up</a>
        </security:authorize>

    </div>
</nav>
<script src="/js/lang.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>