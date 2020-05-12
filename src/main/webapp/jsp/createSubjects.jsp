<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Create Subject</title>
</head>
<body>

<div>
    <jsp:include page="navbar.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-sm">
            </div>
            <div class="col-sm">
                <h3>New Subject</h3>
                <form action="/subjects/save" method="POST">
                    <div class="form-group">
                        <label for="formGroupExampleInput"></label>
                        <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Name" name="name">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput"></label>
                        <input type="text" class="form-control" id="formGroupExampleInput" placeholder="maxGrade" name="maxGrade">
                    </div>
                    <br>
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary">Save</button>
                </form>
            </div>
            <div class="col-sm">
            </div>
        </div>
    </div>


</div>
</body>
</html>