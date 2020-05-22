<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Apply</title>
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
            <h3>Your application</h3>
            <form:form action="/apply" modelAttribute="application" method="POST" enctype="multipart/form-data">

                    <div class="form-group">
                        <label>Select speciality</label>
                        <select name="speciality" class="custom-select" id="inputGroupSelect01">
                            <c:forEach items="${specialities}" var="special">

                                <option value="${special.id}"><c:out value="${special.title}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>

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


<br>
<jsp:include page="footer.jsp"/>
</body>
</html>