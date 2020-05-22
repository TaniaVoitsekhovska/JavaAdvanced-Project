<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Cabinet</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/4.4.95/css/materialdesignicons.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">
    <link href="/css/cabinet.css" rel="stylesheet" type="text/css">
    <link href="/css/app.css" rel="stylesheet" type="text/css">
</head>
<body class="login security-app">
<jsp:include page="navbar.jsp"/>
<div class="main-panel">
    <div class="container">


        <div class="row">
            <div class="col-md-4 grid-margin stretch-card">
                <div class="card">
                    <div class="profile-card">
                        <div>
                            <div>
                                <div class="text-center">
                                    <c:choose>
                                    <c:when test="${user.image ne null}">
                                        <img src="data:image/png;base64, ${user.image}"
                                             class="avatar img-circle img-thumbnail" alt="avatar">
                                    </c:when>
                                            <c:otherwise>
                                                <img src="img/avatar.jpg" alt="profile card">
                                            </c:otherwise>
                                    </c:choose>
                                </div>
                                </hr><br>
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${userPhoto.photo ne null}">--%>
                                    <%--<div>--%>
                                    <%--<img class="d-block w-100" src="data:image/png;base64, ${userPhoto.photo}"--%>
                                    <%--alt="userPhoto">--%>
                                    <%--</div>--%>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>
                                    <%--<img src="img/avatar.jpg" alt="profile card">--%>
                                    <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                            </div>
                                <%--<div class="user-image">--%>
                                <%--<img src=""--%>
                                <%--class="img ">--%>
                                <%--</div>--%>
                        </div>

                    </div>
                </div>
            </div>

            <div class="col-md-8 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <p class="card-title font-weight-bold">Welcome <a style="color: crimson">${user.username}</a> to
                            your cabinet ) </p>
                        <hr>
                        <p class="card-description">User Information</p>
                        <ul class="about">
                            <li class="about-items"><i class="mdi mdi-account icon-sm "></i><span
                                    class="about-item-name">First Name:</span><span
                                    class="about-item-detail">${user.firstName}</span></li>
                            <li class="about-items"><i class="mdi mdi-account icon-sm "></i><span
                                    class="about-item-name">Last Name:</span>
                                <span class="about-item-detail">${user.lastName}</span></li>
                            <li class="about-items"><i class="mdi mdi-mail-ru icon-sm "></i><span
                                    class="about-item-name">username:</span><span
                                    class="about-item-detail">${user.username}</span>
                            </li>
                        </ul>
                        <p class="card-description">Contact Information</p>
                        <ul class="about">
                            <li class="about-items"><i class="mdi mdi-phone icon-sm "></i>
                                <span class="about-item-name">Phone:</span><span
                                        class="about-item-detail">${user.phoneNumber}</span>
                            </li>
                            <li class="about-items"><i class="mdi mdi-map-marker icon-sm "></i><span
                                    class="about-item-name">Address:</span><span
                                    class="about-item-detail">${user.address}</span></li>
                            <li class="about-items"><i class="mdi mdi-email-outline icon-sm "></i><span
                                    class="about-item-name">Email:</span><span
                                    class="about-item-detail">${user.email}</span></li>
                        </ul>
                        <p class="card-description">Basic Information</p>
                        <ul class="about">
                            <li class="about-items"><i class="mdi mdi-cake icon-sm "></i>
                                <span class="about-item-name">Birthday:</span><span
                                        class="about-item-detail">${user.dateOfBirth}</span></li>
                            <li class="about-items"><i class="mdi mdi-account icon-sm "></i><span
                                    class="about-item-name">Gender:</span><span
                                    class="about-item-detail">${user.gender}</span></li>


                        </ul>
                        <div>
                            <a class='btn btn-info btn-xs' href="/cabinet/edit"><span
                                    class="glyphicon glyphicon-edit"></span>Edit</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<br>
<jsp:include page="footer.jsp"/>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>