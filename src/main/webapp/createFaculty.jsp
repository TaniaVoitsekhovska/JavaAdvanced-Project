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
            <h3>New faculty</h3>
            <form:form action="/faculty/save" modelAttribute="facultyDto" method="POST"
                       enctype="multipart/form-data">
                <spring:bind path="name">
                    <div class="form-group">
                        <label for="formGroupExampleInput">Name</label>
                        <form:input path="name" type="text" id="formGroupExampleInput" class="form-control"
                                    placeholder="name"
                                    name="name" autofocus="true"/>
                        <form:errors path="name" cssClass="error"/>
                    </div>
                </spring:bind>
                <br>
                <select name="specialities" class="custom-select" id="inputGroupSelect02">
                    <c:forEach items="${specialities}" var="speciality">
                        <option value="${speciality.id}"><c:out value="${speciality.title}"></c:out></option>
                    </c:forEach>
                </select><br>
                <select name="specialities" class="custom-select" id="inputGroupSelect02">
                    <c:forEach items="${specialities}" var="speciality">
                        <option value="${speciality.id}"><c:out value="${speciality.title}"></c:out></option>
                    </c:forEach>
                </select><br>
                <select name="specialities" class="custom-select" id="inputGroupSelect02">
                    <c:forEach items="${specialities}" var="speciality">
                        <option value="${speciality.id}"><c:out value="${speciality.title}"></c:out></option>
                    </c:forEach>
                </select><br>
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


<h2>All faculties</h2>
<div class="container" align="middle">
    <div class="row col-md-6 col-md-offset-2 custyle">
        <table class="table table-striped custab">
            <thead>
            <tr>
                <th>Name</th>
                <th>Speciality 1</th>
                <th>Speciality 2</th>
                <th>Speciality 3</th>
                <th class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${faculties}" var="faculty">
                <tr class="table">
                    <td><c:out value="${faculty.name}"/></td>
                    <c:forEach items="${faculty.specialities}" var="speciality">
                        <td><c:out value="${speciality.title}"/></td>
                    </c:forEach>

                    <td class="text-center">
                        <a class='btn btn-info btn-xs' href="/faculties/edit/${faculty.id}">
                            <span class="glyphicon glyphicon-edit"></span> Edit</a>
                        <a href="/faculties/delete/${faculty.id}" class="btn btn-danger btn-xs"
                           onclick="if (confirm('Are you sure you want to delete?'))
                               form.action='/Config?pg=FIBiller&amp;cmd=delete'; else return false;"><span
                                class="glyphicon glyphicon-remove"></span> Del</a>
                    </td>
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