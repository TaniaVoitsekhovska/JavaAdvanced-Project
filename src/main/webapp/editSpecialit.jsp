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
            <h3>Edit speciality</h3>
            <c:forEach items="${speciality}" var="speciality">
                <form:form action="/specialities/save_edited" modelAttribute="specialityDto" method="POST"
                           enctype="multipart/form-data">
                    <spring:bind path="title">
                        <div class="form-group">
                            <label for="formGroupExampleInput">Title</label>
                            <form:input path="title" type="text" id="formGroupExampleInput" class="form-control"
                                        placeholder="title" name="title" autofocus="true" value="${speciality.title}"/>
                            <form:errors path="title" cssClass="error"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="enrollmentPlan">
                        <div class="form-group">
                            <label for="formGroupExampleInput2">Enrollment plan</label>
                            <form:input path="enrollmentPlan" type="number" id="formGroupExampleInput2"
                                        class="form-control"
                                        placeholder="enrollment plan" name="enrollmentPlan" autofocus="true"
                                        value="${speciality.enrollmentPlan}"/>
                            <form:errors path="enrollmentPlan" cssClass="error"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="id">
                        <div class="form-group">
                            <form:input type="hidden" path="id" id="formGroupExampleInput3" class="form-control"
                                        placeholder="max grade" name="maxGrade" autofocus="true"
                                        value="${speciality.id}"/>
                        </div>
                    </spring:bind>

                    <br>
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary">Save</button>
                </form:form>
            </c:forEach>
        </div>
        <div class="col-sm">
        </div>
    </div>
</div>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>