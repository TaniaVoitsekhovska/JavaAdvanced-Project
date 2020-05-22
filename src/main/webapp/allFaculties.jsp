<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>

</head>
<body style="background-color: lightpink">
<jsp:include page="navbar.jsp"/>
<div class="container" style="margin-top: 70px">

    <c:forEach items="faculties" var="faculty">
        <h2>"${faculties[0].name}"</h2>
        <br>
        <div class="row form-group product-chooser">
            <c:forEach items="specialities1" var="speciality" varStatus="loop">
                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                    <div class="product-chooser-item selected">
                        <div class="col-xs-8 col-sm-8 col-md-12 col-lg-12">
                            <span hidden> "${specialities1[0].id}"</span>
                            <h4>"${specialities1[0].title}"</h4>
                            <br>
                            <span class="description">The table below contains a list of courses that are currently
                                open to applications and use the standard graduate application form. </span>
                            <a class="nav-link"  href="/apply/speciality/${specialities1[0].id}">View more</a>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                    <div class="product-chooser-item selected">
                        <div class="col-xs-8 col-sm-8 col-md-12 col-lg-12">
                            <span hidden> "${specialities1[1].id}"</span>
                            <h4>"${specialities1[1].title}"</h4>
                            <br>
                            <span class="description">The table below contains a list of courses that are currently
                                open to applications and use the standard graduate application form. </span>
                            <a class="nav-link"  href="/apply/speciality/${specialities1[1].id}">View more</a>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                    <div class="product-chooser-item selected">
                        <div class="col-xs-8 col-sm-8 col-md-12 col-lg-12">
                            <span hidden> "${specialities1[2].id}"</span>
                            <h4>"${specialities1[2].title}"</h4>
                            <br>
                            <span class="description">The table below contains a list of courses that are currently
                                open to applications and use the standard graduate application form. </span>
                            <a class="nav-link"  href="/apply/speciality/${specialities1[2].id}">View more</a>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <br>
        <br>
        <h2>"${faculties[1].name}"</h2>
        <br>
        <div class="row form-group product-chooser">
            <c:forEach items="specialities2" var="speciality" varStatus="loop">
                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                    <div class="product-chooser-item selected">
                        <div class="col-xs-8 col-sm-8 col-md-12 col-lg-12">
                            <span hidden> "${specialities2[0].id}"</span>
                            <h4>"${specialities2[0].title}"</h4>
                            <br>
                            <span class="description">The table below contains a list of courses that are currently
                                open to applications and use the standard graduate application form. </span>
                            <a class="nav-link"  href="/apply/speciality/${specialities2[0].id}">View more</a>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                    <div class="product-chooser-item selected">
                        <div class="col-xs-8 col-sm-8 col-md-12 col-lg-12">
                            <span hidden> "${specialities2[1].id}"</span>
                            <h4>"${specialities2[1].title}"</h4>
                            <br>
                            <span class="description">The table below contains a list of courses that are currently
                                open to applications and use the standard graduate application form. </span>
                            <a class="nav-link"  href="/apply/speciality/${specialities2[1].id}">View more</a>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                    <div class="product-chooser-item selected">
                        <div class="col-xs-8 col-sm-8 col-md-12 col-lg-12">
                            <span hidden> "${specialities2[2].id}"</span>
                            <h4>"${specialities2[2].title}"</h4>
                            <br>
                            <span class="description">The table below contains a list of courses that are currently
                                open to applications and use the standard graduate application form. </span>
                            <a class="nav-link"  href="/apply/speciality/${specialities2[2].id}">View more</a>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <br>
        <br>
        <h2>"${faculties[2].name}"</h2>
        <br>
        <div class="row form-group product-chooser">
            <c:forEach items="specialities3" var="speciality" varStatus="loop">
                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                    <div class="product-chooser-item selected">
                        <div class="col-xs-8 col-sm-8 col-md-12 col-lg-12">
                            <span hidden> "${specialities3[0].id}"</span>
                            <h4>"${specialities3[0].title}"</h4>
                            <br>
                            <span class="description">The table below contains a list of courses that are currently
                                open to applications and use the standard graduate application form. </span>
                            <a class="nav-link"  href="/apply/speciality/${specialities3[0].id}">View more</a>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                    <div class="product-chooser-item selected">
                        <div class="col-xs-8 col-sm-8 col-md-12 col-lg-12">
                            <span hidden> "${specialities3[1].id}"</span>
                            <h4>"${specialities3[1].title}"</h4>
                            <br>
                            <span class="description">The table below contains a list of courses that are currently
                                open to applications and use the standard graduate application form. </span>
                            <a class="nav-link"  href="/apply/speciality/${specialities3[1].id}">View more</a>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                    <div class="product-chooser-item selected">
                        <div class="col-xs-8 col-sm-8 col-md-12 col-lg-12">
                            <span hidden> "${specialities3[2].id}"</span>
                            <h4>"${specialities3[2].title}"</h4>
                            <br>
                            <span class="description">The table below contains a list of courses that are currently
                                open to applications and use the standard graduate application form. </span>
                            <a class="nav-link"  href="/apply/speciality/${specialities3[2].id}">View more</a>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:forEach>


</div>
<br>
<br>

<jsp:include page="footer.jsp"/>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</body>
</html>

