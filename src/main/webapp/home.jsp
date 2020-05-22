<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="welcome"/></title>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/carousel/">
    <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/home.css" rel="stylesheet" type="text/css">
</head>
<body class="security-app">
<header>
    <jsp:include page="navbar.jsp"/>
</header>

<main role="main">

    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="first-slide"
                     src="img/front1.jpg"
                     alt="First slide">
                <div class="container">
                    <div class="carousel-caption text-left">
                        <h1></h1>

                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img class="second-slide"
                     src="img/front2.jpg"
                     alt="Second slide">
                <div class="container">
                    <div class="carousel-caption">
                        <h1></h1>

                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img class="third-slide"
                     src="img/front3.jpg"
                     alt="Third slide">
                <div class="container">
                    <div class="carousel-caption text-right">
                        <h1></h1>

                    </div>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>


    <div class="container marketing">

        <div class="row">
            <div class="col-lg-4">
                <img class="rounded-circle"
                     src="img/faculty1.gif"
                     alt="Generic placeholder image" width="140" height="140">
                <h2>Our faculty</h2>
                <span class="description">Applications are still being accepted for entry in September 2020
                                and some courses have reopened to accept new applications.</span>
                <p><a class="btn btn-secondary" href="/allFaculties" role="button">View details &raquo;</a></p>
            </div>
            <div class="col-lg-4">
                <img class="rounded-circle"
                     src="img/faculty2.png"
                     alt="Generic placeholder image" width="140" height="140">
                <h2>Our faculty</h2>
                <span class="description">Applications are still being accepted for entry in September 2020
                                and some courses have reopened to accept new applications.</span>
                <p><a class="btn btn-secondary" href="/allFaculties" role="button">View details &raquo;</a></p>
            </div>
            <div class="col-lg-4">
                <img class="rounded-circle"
                     src="img/faculty3.jpg"
                     alt="Generic placeholder image" width="140" height="140">
                <h2>Our faculty</h2>
                <span class="description">Applications are still being accepted for entry in September 2020
                                and some courses have reopened to accept new applications.</span>
                <p><a class="btn btn-secondary" href="/allFaculties" role="button">View details &raquo;</a></p>
            </div>
        </div>

    </div>

    <jsp:include page="footer.jsp"/>
</main>
</body>
</html>