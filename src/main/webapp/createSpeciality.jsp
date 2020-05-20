<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Create Speciality</title>
    <link href="/css/createLook.css" rel="stylesheet" type="text/css">
    <link href="/css/error.css" rel="stylesheet" type="text/css">
</head>
<body class="security-app">

<jsp:include page="navbar.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-sm">
        </div>
        <div class="col-sm">
            <h3>New speciality</h3>
            <form:form action="/specialities/save" modelAttribute="specialityDto" method="POST"
                       enctype="multipart/form-data">
                <spring:bind path="title">
                    <div class="form-group">
                        <label for="formGroupExampleInput">Title</label>
                        <form:input path="title" type="text" id="formGroupExampleInput" class="form-control"
                                    placeholder="title"
                                    name="title" autofocus="true"/>
                        <form:errors path="title" cssClass="error"/>
                    </div>
                </spring:bind>
                <spring:bind path="enrollmentPlan">
                    <div class="form-group">
                        <label for="formGroupExampleInput2">Enrollment plan</label>
                        <form:input path="enrollmentPlan" type="number" id="formGroupExampleInput2" class="form-control"
                                    placeholder="enrollment plan" name="enrollmentPlan" autofocus="true"/>
                        <form:errors path="enrollmentPlan" cssClass="error"/>
                    </div>
                </spring:bind>

                <br>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <button type="submit" class="btn btn-primary">Save</button>
            </form:form>
        </div>
        <div class="col-sm">
        </div>
    </div>
</div>
<br>
<h2>All specialities</h2>
<div class="container" align="middle">
    <div class="row col-md-6 col-md-offset-2 custyle">
        <table class="table table-striped custab">
            <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Enrollment Plan</th>
                <th class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${specialities}" var="speciality">
                <tr class="table">
                    <td><c:out value="${speciality.id}"/></td>
                    <td><c:out value="${speciality.title}"/></td>
                    <td><c:out value="${speciality.enrollmentPlan}"/></td>
                    <td class="text-center">
                        <a class='btn btn-info btn-xs' href="/specialities/edit/${speciality.id}"><span
                                class="glyphicon glyphicon-edit"></span> Edit</a>
                        <a href="/specialities/delete/${speciality.id}" class="btn btn-danger btn-xs"
                           onclick="if (confirm('Are you sure you want to delete?'))
                               form.action='/Config?pg=FIBiller&amp;cmd=delete'; else return false;">
                            <span class="glyphicon glyphicon-remove"></span> Del</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>