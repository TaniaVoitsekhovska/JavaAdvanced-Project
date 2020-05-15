<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Create Faculty</title>
    <link href="/css/app.css" rel="stylesheet" type="text/css">

</head>
<body class="security-app">
<jsp:include page="navbar.jsp"/>

<div class="container" style="margin-top: 100px">
    <div class="row">
        <div class="col-sm">
        </div>
        <div class="col-sm">
            <h3>New speciality</h3>
            <form:form action="/faculty/save" modelAttribute="faculty" method="POST"
                       enctype="multipart/form-data">
                <spring:bind path="name">
                    <div class="form-group">
                        <label for="formGroupExampleInput">Name</label>
                        <form:input path="name" type="text" id="formGroupExampleInput" class="form-control"
                                    placeholder="name"
                                    name="name" autofocus="true"/>
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


<h2>All faculties</h2>
    <div class="container" align="middle">
        <div class="row col-md-6 col-md-offset-2 custyle">
            <table class="table table-striped custab">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th class="text-center">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${faculties}" var="faculty">
                    <tr class="table" >
                        <td><c:out value="${faculty.id}"/></td>
                        <td><c:out value="${faculty.name}"/></td>
                        <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span
                                class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span
                                class="glyphicon glyphicon-remove"></span> Del</a></td>
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