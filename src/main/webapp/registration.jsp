<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <link href="css/registration.css" rel="stylesheet" type="text/css">
    <link href="css/error.css" rel="stylesheet" type="text/css">
    <link href="<c:url value="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>" rel="stylesheet"
          id="bootstrap-css">
    <%--<link href="<c:url value="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"/>" rel="stylesheet" id="bootstrap-css1">--%>

</head>
<body class="security-app">
<jsp:include page="navbar.jsp"/>
<div class="container">
    <form:form method="POST" modelAttribute="userDto" action="${contextPath}/register" class="form-horizontal"
               role="form">
        <h2>Registration</h2>
        <spring:bind path="firstName">
            <div class="form-group">
                <form:label path="firstName" class="col-sm-3 control-label">First Name</form:label>
                <div class="col-sm-9">
                    <form:input path="firstName" type="text" id="firstName" placeholder="First Name"
                                class="form-control"
                                autofocus="true"/>
                    <form:errors path="firstName" cssClass="error"/>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="lastName">
            <div class="form-group">
                <form:label path="lastName" class="col-sm-3 control-label">Last Name</form:label>
                <div class="col-sm-9">
                    <form:input path="lastName" type="text" id="lastName" placeholder="Last Name" class="form-control"
                                autofocus="true"/>
                    <form:errors path="lastName" cssClass="error"/>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="email">
            <div class="form-group">
                <form:label path="email" class="col-sm-3 control-label">Email </form:label>
                <div class="col-sm-9">
                    <form:input path="email" type="email" id="email" placeholder="Email" class="form-control"
                                name="email"/>
                    <form:errors path="email" cssClass="error"/>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="password">
            <div class="form-group">
                <form:label path="password" class="col-sm-3 control-label">Password</form:label>
                <div class="col-sm-9">
                    <form:input path="password" type="password" id="password" placeholder="Password"
                                class="form-control"/>
                    <form:errors path="password" cssClass="error"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="dateOfBirth">
            <div class="form-group">
                <form:label path="dateOfBirth" class="col-sm-3 control-label">Date of Birth</form:label>
                <div class="col-sm-9">
                    <form:input path="dateOfBirth" type="date" id="dateOfBirth" class="form-control"/>
                    <form:errors path="dateOfBirth" cssClass="error"/>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="phoneNumber">
            <div class="form-group">
                <form:label path="phoneNumber" class="col-sm-3 control-label">Phone number </form:label>
                <div class="col-sm-9">
                    <form:input path="phoneNumber" type="phoneNumber" id="phoneNumber" placeholder="Phone number"
                                class="form-control"/>
                    <form:errors path="phoneNumber" cssClass="error"/>
                    <span class="help-block">Your phone number won't be disclosed anywhere </span>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="address">
            <div class="form-group">
                <form:label path="address" class="col-sm-3 control-label">Address </form:label>
                <div class="col-sm-9">
                    <form:input path="address" type="text" id="address" placeholder="Please write your address"
                                class="form-control"/>
                    <form:errors path="address" cssClass="error"/>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="username">
            <div class="form-group">
                <form:label path="username" class="col-sm-3 control-label">Username </form:label>
                <div class="col-sm-9">
                    <form:input path="username" type="text" id="username" placeholder="Username"
                                class="form-control"/>
                    <form:errors path="username" cssClass="error"/>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="gender">
            <div class="form-group">
                <form:label path="gender" class="control-label col-sm-3">Gender</form:label>
                <div class="col-sm-6">
                    <div class="row">
                        <div class="col-sm-4">

                            <form:select path="gender" id="femaleRadio" placeholder="gender">
                                <form:option value="Male"/>
                                <form:option value="Female"/>
                            </form:select>
                            <form:errors path="gender" cssClass="error"/>
                        </div>
                    </div>
                </div>
            </div>
        </spring:bind>
        <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
                <span class="help-block">*All fields are required!</span>
            </div>
        </div>
        <button type="submit" class="btn btn-primary btn-block" id="save">Register</button>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form:form>
</div>
<br>
<jsp:include page="footer.jsp"/>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<%--<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
</body>
</html>