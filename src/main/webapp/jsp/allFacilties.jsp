<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Faculties</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>

<h2>All Faculties</h2>

<c:forEach items="${faculties}" var="faculties">

    <div class="container">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">${faculty.name}</h5>
                <a href="/periodical/${faculty.id}" class="card-link">Card link</a>
            </div>
        </div>
    </div>
</c:forEach>
</body>
</html>