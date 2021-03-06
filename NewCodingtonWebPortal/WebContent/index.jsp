<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<!--META-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login Form</title>
<link rel="icon" type="image/ico" href="favicon.ico" />

<!--STYLESHEETS-->
<link href="css/login.css" rel="stylesheet" type="text/css" />

<!--SCRIPTS-->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<!--Slider-in icons-->
<script type="text/javascript">
	$(document).ready(function() {
		$(".username").focus(function() {
			$(".user-icon").css("left", "-48px");
		});
		$(".username").blur(function() {
			$(".user-icon").css("left", "0px");
		});

		$(".password").focus(function() {
			$(".pass-icon").css("left", "-48px");
		});
		$(".password").blur(function() {
			$(".pass-icon").css("left", "0px");
		});
	});
</script>

</head>
<body>
	<header>
	<div id="logo">
		<img src="images/logo.png" class="logo-icon">
	</div>
	</header>

	<!--WRAPPER-->
	<div id="wrapper">

		<!--SLIDE-IN ICONS-->
		<div class="user-icon"></div>
		<div class="pass-icon"></div>
		<!--END SLIDE-IN ICONS-->

		<!--LOGIN FORM-->
		<form name="login-form" class="login-form" action="" method="post">

			<!--HEADER-->
			<div class="header">
				<!--TITLE-->
				<h1>Welcome</h1>
				<!--END TITLE-->
				<!--DESCRIPTION-->
				<span>Enter your Login</span>
				<!--END DESCRIPTION-->
				<c:if test="${requestScope.error ne null}">
					<span class="messageError">"${requestScope.error}"</span>
				</c:if>
			</div>
			<!--END HEADER-->

			<!--CONTENT-->
			<div class="content">
				<!--USERNAME-->
				<input name="username" type="text" class="input username"
					value="Username" onfocus="this.value=''" required="required" />
				<!--END USERNAME-->
				<!--PASSWORD-->
				<input name="password" type="password" class="input password"
					value="Password" onfocus="this.value=''" required="required" />
				<!--END PASSWORD-->
			</div>
			<!--END CONTENT-->

			<!--FOOTER-->
			<div class="footer">
				<!--LOGIN BUTTON-->
				<input type="submit" name="submit" value="Login" class="button"
					formaction="login.do" />
				<!--END LOGIN BUTTON-->
				<!--REGISTER BUTTON-->
				<a class="register" href="register.do"> Register </a>
				<!--END REGISTER BUTTON-->
			</div>
			<!--END FOOTER-->

		</form>
		<!--END LOGIN FORM-->

	</div>
	<!--END WRAPPER-->

	<!--GRADIENT-->
	<div class="gradient"></div>
	<!--END GRADIENT-->

</body>
</html>