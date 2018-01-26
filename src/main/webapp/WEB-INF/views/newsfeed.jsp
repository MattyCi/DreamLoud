<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="This is social network html5 template available in themeforest......"/>
    <meta name="keywords" content="Social Network, Social Media, Make Friends, Newsfeed, Profile Page"/>
    <meta name="robots" content="index, follow"/>
    <title>News Feed | Check what your friends are doing</title>

    <!-- Stylesheets -->
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
<c:set var="userAcct" value="${acctInfo}"/>
<div id="page-contents">
    <div class="container">
        <div class="row">
            <!-- Newsfeed Common Side Bar Left -->
            <div class="col-md-3">
                <a id="logolink" href="#"><img id="logo" src="./resources/images/dl_logo_2_trans.png" alt="logo"></a>
                <div class="sticky-sidebar">
                    <div class="profile-card">
                        <img src="${userAcct.acctPic}" alt="user" class="profile-photo"/>
                        <h5><a href="timeline" class="text-white-center">${userAcct.acctFname} ${userAcct.acctLname}</a></h5>
                    </div>
                    <!--profile card ends-->
                    <div id="chat-block">
                        <div class="title">Dreamers</div>
                        <ul class="online-users list-inline">
                            <li><a href="newsfeed-messages" title="Linda Lohan"><img src="http://placehold.it/300x300"
                                                                                     alt="user"
                                                                                     class="img-responsive profile-photo"/><span
                                    class="online-dot"></span></a></li>
                            <li><a href="newsfeed-messages" title="Sophia Lee"><img src="http://placehold.it/300x300"
                                                                                    alt="user"
                                                                                    class="img-responsive profile-photo"/><span
                                    class="online-dot"></span></a></li>
                            <li><a href="newsfeed-messages" title="John Doe"><img src="http://placehold.it/300x300"
                                                                                  alt="user"
                                                                                  class="img-responsive profile-photo"/><span
                                    class="online-dot"></span></a></li>
                            <li><a href="newsfeed-messages" title="Alexis Clark"><img src="http://placehold.it/300x300"
                                                                                      alt="user"
                                                                                      class="img-responsive profile-photo"/><span
                                    class="online-dot"></span></a></li>
                            <li><a href="newsfeed-messages" title="James Carter"><img src="http://placehold.it/300x300"
                                                                                      alt="user"
                                                                                      class="img-responsive profile-photo"/><span
                                    class="online-dot"></span></a></li>
                            <li><a href="newsfeed-messages" title="Robert Cook"><img src="http://placehold.it/300x300"
                                                                                     alt="user"
                                                                                     class="img-responsive profile-photo"/><span
                                    class="online-dot"></span></a></li>
                        </ul>
                    </div>
                    <!--chat block ends-->
                </div>
            </div>
            <div class="col-md-7">

                <!-- Removing Post Create Box
    <div class="create-post">
        <div class="row">
            <div class="col-md-7 col-sm-7">
          <div class="form-group">
            <img src="http://placehold.it/300x300" alt="" class="profile-photo-md" />
            <textarea name="texts" id="exampleTextarea" cols="30" rows="1" class="form-control" placeholder="Write what you wish"></textarea>
          </div>
        </div>
            <div class="col-md-5 col-sm-5">
          <div class="tools">
            <ul class="publishing-tools list-inline">
              <li><a href="#"><i class="ion-compose"></i></a></li>
              <li><a href="#"><i class="ion-images"></i></a></li>
              <li><a href="#"><i class="ion-ios-videocam"></i></a></li>
              <li><a href="#"><i class="ion-map"></i></a></li>
            </ul>
            <button class="btn btn-primary pull-right">Publish</button>
          </div>
        </div>
        </div>
    </div>
                -->

                <!-- Post Content -->
                <!-- Start of Post -->
                <div class="post-content">
                    <div class="post-container">
                        <div>
									<span class="text-dream"><a href="timeline" class="profile-link"><i
                                            class="ion-code-working"></i> Become a Programmer</a>
									<span class="text-dream-follow"><a href="#"><i class="ion-ios-cloud-outline"></i>Follow</a></span></span>
                            <p class="text-muted-small">52 Dreamers</p>
                            <div class="line-divider-half"></div>
                        </div>
                        <img src="http://placehold.it/300x300" alt="user" class="profile-photo-md pull-left"/>
                        <div class="post-detail">
                            <div class="user-info">
                                <h5><a href="timeline" class="profile-link">Kyle Jones</a></h5>
                                <p class="text-muted">January 12 at 2:15 p.m.</p>
                            </div>
                            <div class="line-divider"></div>
                            <div class="post-text">
                                <p>My dream has always been to join group XYZ but I'm not sure which route I should
                                    take. Where should I start?</p>
                            </div>
                            <div class="line-divider"></div>
                            <div class="post-comment">
                                <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm"/>
                                <p><a href="timeline" class="profile-link">Aaron Board </a>You should probably just give
                                    up. </p>
                            </div>
                            <div class="show-more">
                                <a class="text-muted-center" onclick="showcomment()" href="#"><i
                                        class="fa fa-angle-down" aria-hidden="true"></i> Show More</a>
                            </div>
                            <div class="hide-comment">
                                <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm"/>
                                <p><a href="timeline" class="profile-link">Matt Ciaravino </a>like in 50 seconds for
                                    good luck </p>
                            </div>
                            <div class="line-divider"></div>
                            <div class="post-comment">
                                <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm"/>
                                <input type="text" class="form-control" placeholder="Reply">
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End of Post -->
                <div class="post-content">
                    <div class="post-container">
                        <div>
									<span class="text-dream"><a href="timeline" class="profile-link"><i
                                            class="ion-code-working"></i> Become a Programmer</a>
									<span class="text-dream-follow"><a href="#"><i class="ion-ios-cloud-outline"></i>Follow</a></span></span>
                            <p class="text-muted-small">52 Dreamers</p>
                            <div class="line-divider-half"></div>
                        </div>
                        <img src="http://placehold.it/300x300" alt="user" class="profile-photo-md pull-left"/>
                        <div class="post-detail">
                            <div class="user-info">
                                <h5><a href="timeline" class="profile-link">Kyle Jones</a></h5>
                                <p class="text-muted">January 12 at 2:15 p.m.</p>
                            </div>
                            <div class="line-divider"></div>
                            <div class="post-text">
                                <p>My dream has always been to join group XYZ but I'm not sure which route I should
                                    take. Where should I start?</p>
                            </div>
                            <div class="line-divider"></div>
                            <div class="post-comment">
                                <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm"/>
                                <p><a href="timeline" class="profile-link">Aaron Board </a>You should probably just give
                                    up. </p>
                            </div>
                            <div class="show-more">
                                <a class="text-muted-center" onclick="showcomment()" href="#"><i
                                        class="fa fa-angle-down" aria-hidden="true"></i> Show More</a>
                            </div>
                            <div class="hide-comment">
                                <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm"/>
                                <p><a href="timeline" class="profile-link">Matt Ciaravino </a>like in 50 seconds for
                                    good luck </p>
                            </div>
                            <div class="line-divider"></div>
                            <div class="post-comment">
                                <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm"/>
                                <input type="text" class="form-control" placeholder="Reply">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="post-content">
                    <div class="post-container">
                        <div>
									<span class="text-dream"><a href="timeline" class="profile-link"><i
                                            class="ion-code-working"></i> Become a Programmer</a>
									<span class="text-dream-follow"><a href="#"><i class="ion-ios-cloud-outline"></i>Follow</a></span></span>
                            <p class="text-muted-small">52 Dreamers</p>
                            <div class="line-divider-half"></div>
                        </div>
                        <img src="http://placehold.it/300x300" alt="user" class="profile-photo-md pull-left"/>
                        <div class="post-detail">
                            <div class="user-info">
                                <h5><a href="timeline" class="profile-link">Kyle Jones</a></h5>
                                <p class="text-muted">January 12 at 2:15 p.m.</p>
                            </div>
                            <div class="line-divider"></div>
                            <div class="post-text">
                                <p>My dream has always been to join group XYZ but I'm not sure which route I should
                                    take. Where should I start?</p>
                            </div>
                            <div class="line-divider"></div>
                            <div class="post-comment">
                                <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm"/>
                                <p><a href="timeline" class="profile-link">Aaron Board </a>You should probably just give
                                    up. </p>
                            </div>
                            <div class="show-more">
                                <a class="text-muted-center" onclick="showcomment()" href="#"><i
                                        class="fa fa-angle-down" aria-hidden="true"></i> Show More</a>
                            </div>
                            <div class="hide-comment">
                                <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm"/>
                                <p><a href="timeline" class="profile-link">Matt Ciaravino </a>like in 50 seconds for
                                    good luck </p>
                            </div>
                            <div class="line-divider"></div>
                            <div class="post-comment">
                                <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm"/>
                                <input type="text" class="form-control" placeholder="Reply">
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <div class="col-md-2 sticky-sidebar">
                <ul class="nav-news-feed">
                    <li><i class="icon ion-home"></i>
                        <div><a href="newsfeed">Home</a></div>
                    </li>
                    <li><i class="icon ion-person"></i>
                        <div><a href="newsfeed-friends">My Profile</a></div>
                    </li>
                    <li><i class="icon ion-power"></i>
                        <div><a href="newsfeed-people-nearby">Logout</a></div>
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
