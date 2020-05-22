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
                </spring:bind>

                </div>
                <label class="input-group-text" for="inputGroupSelect01">Select Subjects</label>
                <br>

                <select name="subjects" class="custom-select" id="inputGroupSelect01">
                    <c:forEach items="${subjects}" var="subject">
                        <option value="${subject.id}"><c:out value="${subject.name}"></c:out></option>
                    </c:forEach>
                </select>

                <select name="subjects" class="custom-select" id="inputGroupSelect02">
                    <c:forEach items="${subjects}" var="subject">
                        <option value="${subject.id}"><c:out value="${subject.name}"></c:out></option>
                    </c:forEach>
                </select><br>
                <select name="subjects" class="custom-select" id="inputGroupSelect03">
                    <c:forEach items="${subjects}" var="subject">
                        <option value="${subject.id}"><c:out value="${subject.name}"></c:out></option>
                    </c:forEach>
                </select><br>
                <select name="subjects" class="custom-select" id="inputGroupSelect04">
                    <c:forEach items="${subjects}" var="subject">
                        <option value="${subject.id}"><c:out value="${subject.name}"></c:out></option>
                    </c:forEach>
                </select><br>
                <select name="subjects" class="custom-select" id="inputGroupSelect05">
                    <c:forEach items="${subjects}" var="subject">
                        <option value="${subject.id}"><c:out value="${subject.name}"></c:out></option>
                    </c:forEach>
                </select>
                <br>
                <br>
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
    <div class="row col-md-13 col-md-offset-4 custyle">
        <table class="table table-striped custab">
            <thead>
            <tr>
                <th>Title</th>
                <th>Subject 1</th>
                <th>Subject 2</th>
                <th>Subject 3</th>
                <th>Subject 4</th>
                <th>Subject 5</th>
                <th>Total Mark</th>
                <th class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${specialities}" var="speciality">
                <tr class="table">
                    <td><c:out value="${speciality.title}"/></td>
                    <c:forEach items="${speciality.subjects}" var="subject">
                        <td><c:out value="${subject.name}"/></td>
                    </c:forEach>
                    <td><c:out value="${speciality.totalGrade}"/></td>
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