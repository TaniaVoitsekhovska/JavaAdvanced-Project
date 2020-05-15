<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Create Subject</title>
    <link href="/css/app.css" rel="stylesheet" type="text/css">
    <link href="<c:url value="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>" rel="stylesheet"
          id="bootstrap-css">
</head>
<body class="security-app">
<jsp:include page="navbar.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <form action="#" method="get">
                <div class="input-group">
                    <input class="form-control" id="system-search" name="q" placeholder="Search for" required>
                    <span class="input-group-btn">
                        <button type="submit" class="btn btn-default"><i
                                class="glyphicon glyphicon-search"></i></button>
                    </span>
                </div>
            </form>
        </div>
        <div class="col-md-9">
            <table class="table table-list-search user-list">
                <thead>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Email</th>
                    <th>Date of birth</th>
                    <th>Gender</th>
                    <th>Address</th>
                    <th>Username</th>
                    <%--<th>Email Verification</th>--%>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.lastName}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.dateOfBirth}"/></td>
                    <td><c:out value="${user.gender}"/></td>
                    <td><c:out value="${user.address}"/></td>
                    <td><c:out value="${user.username}"/></td>
                    <%--<td><c:out value="${user.isEmailVerified}"/></td>--%>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="js/usersList.js"></script>
</body>
</html>