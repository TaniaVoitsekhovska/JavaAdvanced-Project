<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Speciality "${speciality.title}" </title>
    <link href="/css/createLook.css" rel="stylesheet" type="text/css">
    <link href="/css/error.css" rel="stylesheet" type="text/css">

</head>
<body class="security-app" style="background-color: darksalmon">

<jsp:include page="navbar.jsp"/>

<h2>Application for "${speciality.title}"</h2>
<h3> Total mark is "${speciality.totalGrade}"</h3>
    <div class="container" align="middle">
        <div class="row col-md-6 col-md-offset-2 custyle">
            <table class="table table-striped custab">
                <thead>
                <tr>
                    <th>Subject</th>
                    <th>Max grade</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${subjects}" var="subject">
                    <tr class="table">
                        <td><c:out value="${subject.name}"/></td>
                        <td><c:out value="${subject.maxGrade}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <br>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>