<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="This is social network html5 template available in themeforest......" />
		<meta name="keywords" content="Social Network, Social Media, Make Friends, Newsfeed, Profile Page" />
		<meta name="robots" content="index, follow" />
		<title>Dream Loud</title>

    <!-- Stylesheet -->
		<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
		<link rel="stylesheet" type="text/css" href="resources/css/ionicons.min.css" />
		<link rel="stylesheet" type="text/css" href="resources/css/font-awesome.min.css" />

    <!--Favicon-->
    <link rel="shortcut icon" type="image/png" href="resources/images/fav.png"/>
	</head>
	<body id="noscroll">

    <!-- Landing Page Contents -->
    <div id="lp-register">
    	<div class="container wrapper">
				<div class="row">
					<div class="col-12, hidden-xs">
						<a id="logolink" href="#"><img id="logo-login" src="./resources/images/dl_logo_2_trans.png" alt="logo"></a>
					</div>
				</div>
        <div class="row">
					<div class="col-sm-2">
					</div>
        	<div class="col-sm-4">
            <div class="text">
              <h1>DREAMLOUD</h1>
            	<h2>Unleash Your Dreams, Reach Your Goals, Mobilize Technology!</h2>
            	<p>DreamLoud is an interactive, user-friendly website that strives to help individuals not only create and build relationships, but ultimately helps one another effectively communicate and achieve their dreams and aspirations through the use of blogs.</p>
              <button class="btn-primary">Learn More</button>
            </div>
          </div>
        	<div class="col-sm-4 col-sm-offset-1">
           <div class="reg-form-container, text-left">
                <!--Login-->
                <div id="login">
                  <h3>Login</h3>
                  <p>Log in to your account</p>

                  <!--Login Form-->
                    <form:form action="/loginUser">
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <label for="email_input" class="sr-only">Email</label>
                                <input id='email_input' class="form-control input-group-lg" type="text" name="email" title="Enter Email" placeholder="Email"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <label for="my-password" class="sr-only">Password</label>
                                <input id="my-password" class="form-control input-group-lg" type="password" name="password" title="Enter password" placeholder="Password"/>
                            </div>
                        </div>
                        <p><a href="#">Forgot Password?</a></p>
                        <button type="submit" class="btn-primary">Login Now</button>
                    </form:form>

                    <!--Login Form Ends-->

                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

    <!--preloader-->

    <!-- Scripts -->
    <script src="resources/js/jquery-3.1.1.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/jquery.appear.min.js"></script>
		<script src="resources/js/jquery.incremental-counter.js"></script>
    <script src="resources/js/script.js"></script>

	</body>
</html>
