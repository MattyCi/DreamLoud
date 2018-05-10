<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Bootstrap Mobile First Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>DreamLoud | Profile</title>

    <!-- Stylesheets -->
    <!--
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    -->
    <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="resources/css/style.css"/>
    <link rel="stylesheet" href="resources/css/ionicons.min.css"/>
    <link rel="stylesheet" href="resources/css/font-awesome.min.css"/>
    <link href="resources/css/emoji.css" rel="stylesheet">

    <!--Google Font-->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i,700,700i" rel="stylesheet">

    <!--Favicon-->
    <link rel="shortcut icon" type="image/png" href="images/fav.png"/>
</head>
<body>
<div class="container-fluid row-stretch">
    <div id="page-contents">
        <div class="row row-eq-height hidden-md hidden-lg">
            <div class="col-sm-4 " id="logo-div">
                <a href="#"><img id="logo1" src="./resources/images/dl_logo_2_trans.png" alt="logo"></a>
            </div>
            <div class="col-xs-6 col-sm-4 profile-card">
                <img src="${userAcct.acctPic}" alt="user" class="profile-photo"/>
                <h5><a href="timeline" class="text-white-center">${userAcct.acctFname} ${userAcct.acctLname}</a></h5>
            </div>
            <div class="col-xs-6 col-sm-4 col-md-2">
                <ul class="nav-news-feed">
                    <li><i class="icon ion-home"></i>
                        <div><a href="newsfeed">Home</a></div>
                    </li>
                    <li><i class="icon ion-person"></i>
                        <div><a href="my-profile">My Profile</a></div>
                    </li>
                    <li><i class="icon ion-power"></i>
                        <div><a href="logout">Logout</a></div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="hidden-xs hidden-sm col-md-3 static">
                <a id="logolink" href="#"><img id="logo2" src="./resources/images/dl_logo_2_trans.png" alt="logo"></a>
                <div class="sticky-sidebar">
                    <div class="profile-card">
                        <img src="${acctInfo.acctPic}" alt="user" class="profile-photo"/>
                        <h5>
                            <a href="my-profile" class="text-white-center">${acctInfo.acctFname} ${acctInfo.acctLname}</a>
                        </h5>
                    </div>
                    <div id="chat-block">
                        <div class="title">Dreamers</div>
                        <ul class="online-users list-inline">
                            <c:forEach var="friend" items="${topFriends}">
                                <li>
                                    <a href="newsfeed-messages" title="${friend.acctFname} ${friend.acctLname}"><img src="${friend.acctPic}" alt="user" class="img-responsive profile-photo" />
                                        <span class="online-dot"></span>
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-7 row-stretch">
                <div class="post-content">
                    <div class="post-container">
                       YOOOOOOOO
                    </div>
                </div>
            </div>
            <div class="hidden-xs hidden-sm col-md-2 sticky-sidebar">
                <ul class="nav-news-feed">
                    <li><i class="icon ion-home"></i>
                        <div><a href="newsfeed">Home</a></div>
                    </li>
                    <li><i class="icon ion-person"></i>
                        <div><a href="my-profile">My Profile</a></div>
                    </li>
                    <li><i class="icon ion-power"></i>
                        <div><a href="/logout">Logout</a></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!--preloader-->
<div id="spinner-wrapper">
    <div class="spinner"></div>
</div>

<!-- Scripts
================================================= -->
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCTMXfmDn0VlqWIyoOxK8997L-amWbUPiQ&callback=initMap"></script>
<script src="resources/js/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/jquery.sticky-kit.min.js"></script>
<script src="resources/js/jquery.scrollbar.min.js"></script>
<script src="resources/js/script.js"></script>
</body>
</html>

