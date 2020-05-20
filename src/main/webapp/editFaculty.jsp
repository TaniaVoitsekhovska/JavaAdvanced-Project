<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Create Faculty</title>
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
            <h3>Edit faculty</h3>
            <c:forEach items="${faculty}" var="faculty">
                <form:form action="/faculties/save_edited" modelAttribute="facultyDto" method="POST"
                           enctype="multipart/form-data">
                    <spring:bind path="name">
                        <div class="form-group">
                            <label for="formGroupExampleInput">Name</label>
                            <form:input path="name" type="text" id="formGroupExampleInput" class="form-control"
                                        placeholder="name" name="name" autofocus="true" value="${faculty.name}"/>
                            <form:errors path="name" cssClass="error"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="id">
                        <div class="form-group">
                            <form:input type="hidden" path="id" id="formGroupExampleInput3" class="form-control"
                                        placeholder="max grade" name="maxGrade" autofocus="true"
                                        value="${faculty.id}"/>
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
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>