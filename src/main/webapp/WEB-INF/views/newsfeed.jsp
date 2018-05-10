<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<div id="page-contents">
    <div class="container">
        <div class="row">
            <!-- Newsfeed Common Side Bar Left -->
            <div class="col-md-3">
                <a id="logolink" href="#"><img id="logo" src="./resources/images/dl_logo_2_trans.png" alt="logo"></a>
                <div class="sticky-sidebar">
                    <div class="profile-card">
                        <img src="${userAcct.acctPic}" alt="user" class="profile-photo"/>
                        <h5>
                            <a href="timeline" class="text-white-center">${userAcct.acctFname} ${userAcct.acctLname}</a>
                        </h5>
                    </div>
                    <!--profile card ends-->
                    <div id="chat-block">
                        <div class="title">Dreamers</div>
                        <ul class="online-users list-inline">
                            <c:forEach var="friend" items="${topFriends}">
                                <li>
                                    <a href="newsfeed-messages" title="Linda Lohan">
                                        <img src="resources/images/profiles/PF1.jpg" alt="user" class="img-responsive profile-photo"/>
                                        <span class="online-dot"></span>
                                    </a>
                                </li>
                            </c:forEach>
                            <li><a href="newsfeed-messages" title="Sophia Lee"><img src="resources/images/profiles/PF2.png"
                                                                                    alt="user"
                                                                                    class="img-responsive profile-photo"/><span
                                    class="online-dot"></span></a></li>
                            <li><a href="newsfeed-messages" title="John Doe"><img src="resources/images/profiles/PF3.jpeg"
                                                                                  alt="user"
                                                                                  class="img-responsive profile-photo"/><span
                                    class="online-dot"></span></a></li>
                            <li><a href="newsfeed-messages" title="Alexis Clark"><img src="resources/images/profiles/PF4.jpeg"
                                                                                      alt="user"
                                                                                      class="img-responsive profile-photo"/><span
                                    class="online-dot"></span></a></li>
                            <li><a href="newsfeed-messages" title="James Carter"><img src="resources/images/profiles/PF5.jpg"
                                                                                      alt="user"
                                                                                      class="img-responsive profile-photo"/><span
                                    class="online-dot"></span></a></li>
                            <li><a href="newsfeed-messages" title="Robert Cook"><img src="resources/images/profiles/PF6.jpg"
                                                                                     alt="user"
                                                                                     class="img-responsive profile-photo"/><span
                                    class="online-dot"></span></a></li>
                        </ul>
                    </div>
                    <!--chat block ends-->
                </div>
            </div>
            <div class="col-md-7">

                <!-- Post Content -->
                <!-- Start of Post -->
                <c:forEach var="post" items="${dreamPosts}">
                    <div class="post-content">
                        <div class="post-container" id="${post.postId}">
                            <div>
                                <p id="followMessage">${followMessage}</p>
									<span class="text-dream"><a href="/dream?dreamId=${post.dreamId}" class="profile-link"><i
                                            class="ion-code-working"></i> ${post.dreamName}</a>
                                        <c:choose>
                                            <c:when test="${!post.followingDream}">
                                                    <span class="text-dream-follow">
                                                        <i class="ion-ios-cloud-outline"></i>
                                                            <a href="/followDream?dreamId=${post.dreamId}">
                                                            Follow
                                                            </a>
                                                    </span>
                                            </c:when>
                                            <c:otherwise>
                                                    <span class="text-dream-follow">
                                                        <i class="ion-ios-cloud-outline"></i>
                                                            <a href="/unfollowDream?dreamId=${post.dreamId}">
                                                            Unfollow
                                                            </a>
                                                    </span>
                                            </c:otherwise>
                                        </c:choose>
                                    </span>
                                <p class="text-muted-small">${post.numberOfFollowers} Dreamers</p>
                                <div class="line-divider-half"></div>
                            </div>
                            <img src="${post.userPic}" alt="user" class="profile-photo-md pull-left"/>
                            <div class="post-detail">
                                <div class="user-info">
                                    <h5><a href="timeline" class="profile-link">${post.userName}</a></h5>
                                    <%--<p class="text-muted">January 12 at 2:15 p.m.</p>--%>
                                    <p class="text-muted">${post.postDate}</p>
                                </div>
                                <div class="line-divider"></div>
                                <div class="post-text">
                                    <p>${post.content}</p>
                                </div>
                                <c:forEach var="comment" items="${post.comments}" varStatus="status" >
                                    <div class="line-divider"></div>
                                    <c:if test="${status.index == 0}">
                                        <div class="post-comment">
                                            <img src="${comment.acctPictureUrl}" alt="" class="profile-photo-sm"/>
                                            <p><a href="timeline" class="profile-link">${comment.username}</a>: ${comment.content}</p>
                                        </div>
                                    </c:if>
                                    <c:if test="${status.index ==1}">
                                        <div class="show-more">
                                            <a class="text-muted-center" onclick="showcomment(${post.postId})"><i
                                                    class="fa fa-angle-down" aria-hidden="true"></i> Show More</a>
                                        </div>
                                    </c:if>
                                    <div class="hide-comment">
                                        <img src="${comment.acctPictureUrl}" alt="" class="profile-photo-sm"/>
                                        <p><a href="timeline" class="profile-link">${comment.username}</a>: ${comment.content}</p>
                                    </div>
                                </c:forEach>
                                <div class="post-comment">
                                    <img src="${acctInfo.acctPic}" alt="" class="profile-photo-sm">
                                    <form:form action="/postComment">
                                        <input type="hidden" name="postId" value="${post.postId}">
                                        <input type="hidden" name="userId" value="${acctInfo.acctId}">
                                        <input type="text" name="commentContent" class="form-control" placeholder="Post a comment">
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End of Post -->
                </c:forEach>


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
                        <div><a href="/logout">Logout</a></div>
                    </li>
                </ul>
            </div>
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
