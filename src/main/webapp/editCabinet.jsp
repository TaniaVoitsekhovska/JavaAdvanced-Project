<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Cabinet</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/error.css" rel="stylesheet" type="text/css">
</head>
<body class="login security-app">
<jsp:include page="navbar.jsp"/>

<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-sm-10"><h1>User name</h1></div>
    </div>
    <div class="row">
        <div class="col-sm-9">

            <div class="tab-content">
                <div class="tab-pane active" id="home">
                    <hr>
                    <br>
                    <form:form class="form" modelAttribute="user" action="/cabinet/edit" method="POST"
                               enctype="multipart/form-data">
                        <h6>Upload an image...</h6>
                        <form:input path="file" type="file" class="form-control text-center center-block file-upload"/>

                        <spring:bind path="firstName">
                            <div class="col-xs-6">
                                <form:label path="firstName"><h3>First name</h3></form:label>
                                <form:input path="firstName" type="text" class="form-control" name="firstName"
                                            placeholder="first name" title="enter your first name if any."
                                            value="${user.firstName}"/>
                                <form:errors path="firstName" cssClass="error"/>
                            </div>
                            </div>
                        </spring:bind>
                        <spring:bind path="lastName">
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <form:label path="lastName"><h3>Last name</h3></form:label>
                                    <form:input path="lastName" type="text" class="form-control" name="lastName"
                                                placeholder="last name" title="enter your last name if any."
                                                value="${user.lastName}"/>
                                    <form:errors path="lastName" cssClass="error"/>
                                </div>
                            </div>
                        </spring:bind>
                        <spring:bind path="phoneNumber">
                            <div class="form-group">

                                <div class="col-xs-6">
                                    <form:label path="phoneNumber"><h3>Phone</h3></form:label>
                                    <form:input path="phoneNumber" type="text" class="form-control" name="phoneNumber"
                                                placeholder="enter phone" title="enter your phone number if any."
                                                value="${user.phoneNumber}"/>
                                    <form:errors path="phoneNumber" cssClass="error"/>
                                </div>
                            </div>
                        </spring:bind>
                        <spring:bind path="dateOfBirth">
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <form:label path="dateOfBirth"><h3>Date of birth</h3></form:label>
                                    <form:input path="dateOfBirth" type="date" class="form-control" name="dateOfBirth"
                                                placeholder="enter birthday" title="enter your birthday."
                                                value="${user.dateOfBirth}"/>
                                    <form:errors path="dateOfBirth" cssClass="error"/>
                                </div>
                            </div>
                            <div class="form-group">
                        </spring:bind>
                        <spring:bind path="email">
                            <div class="col-xs-6">
                                <%--<form:label path="email"><h3>Email</h3></form:label>--%>
                                <form:input  path="email" type="hidden" class="form-control" name="email"
                                            placeholder="you@email.com"
                                            title="enter your email." value="${user.email}"/>
                                <%--<form:errors path="email" cssClass="error"/>--%>
                            </div>
                            </div>
                            <div class="form-group">
                        </spring:bind>
                        <spring:bind path="address">
                            <div class="col-xs-6">
                                <form:label path="address"><h3>Location</h3></form:label>
                                <form:input path="address" type="text" class="form-control" name="address"
                                            placeholder="somewhere" title="enter a location" value="${user.address}"/>
                                <form:errors path="address" cssClass="error"/>
                            </div>
                            </div>
                            <div class="form-group">
                        </spring:bind>
                        <spring:bind path="username">
                            <div class="col-xs-6">
                                <form:label path="username"><h3>Location</h3></form:label>
                                <form:input path="username" type="text" class="form-control" name="username"
                                            placeholder="username" title="enter username" value="${user.username}"/>
                                <form:errors path="username" cssClass="error"/>
                            </div>
                            </div>
                            <div class="form-group">
                        </spring:bind>
                        <spring:bind path="gender">
                            <div class="col-xs-6">
                                <form:label path="gender"><h3>Sex</h3></form:label>
                                <form:select path="gender" type="text" class="form-control" name="gender"
                                             placeholder="gender" title="enter gender" value="${user.gender}">
                                    <form:option value="Male"/>
                                    <form:option value="Female"/>
                                </form:select>
                                <form:errors path="gender" cssClass="error"/>
                            </div>
                            </div>
                            <div class="form-group">
                        </spring:bind>
                        <%--<spring:bind path="password">--%>
                            <%--<div class="col-xs-6">--%>
                                <%--<form:label path="password"><h3>Password(enter one more time or new)</h3></form:label>--%>
                                <%--<form:input path="password" type="password" class="form-control"--%>
                                            <%--value="${user.password}"/>--%>
                                <%--<form:errors path="password" cssClass="error"/>--%>
                            <%--</div>--%>
                            <%--</div>--%>
                        <%--</spring:bind>--%>
                        <spring:bind path="id">
                            <div class="form-group">
                                <form:input type="hidden" path="id" id="formGroupExampleInput3" class="form-control"
                                            placeholder="max grade" name="maxGrade" autofocus="true"
                                            value="${user.id}"/>
                            </div>
                        </spring:bind>
                        <div class="form-group">
                        </div>
                        <div class="form-group">
                            <div class="col-xs-12">
                                <br>
                                <button class="btn btn-lg btn-success" href="/cabinet" type="submit">
                                    <i
                                            class="glyphicon glyphicon-ok-sign"></i> Edit
                                </button>
                            </div>
                        </div>
                    </form:form>

                </div><!--/tab-pane-->
                <div class="tab-pane" id="messages">
                </div>
            </div>
        </div><!--/col-9-->
    </div><!--/row-->
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>