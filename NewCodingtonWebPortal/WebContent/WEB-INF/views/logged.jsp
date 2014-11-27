<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
<title>Home</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="estilos_home.css">
<!--Enlazo la hoja de estilos externa-->
<link rel="icon" type="image/ico" href="favicon.ico" />
<script type="text/javascript" src="comprueba.js"></script>
<!--Enlazo el script externo-->
</head>

<body>
	<div id="wrapper">
		<div id="logo">
			<img src="images/logo.png" class="logo-icon">
		</div>
		<div id="title">Home</div>
		<div class="clear"></div>

		<div id="LeftMenu">
			<div class="headerMenu">NORTH TOWER</div>

			<div class="categoria">
				<img src="images/bussiness.png" class="ca-icon"> <a
					href="large_business.html">LARGE BUSSINESS</a>
			</div>

			<div class="categoria">
				<img src="images/museum.png" class="ca-icon"> <a
					href="museum.html">MUSEUM</a>
			</div>

			<div class="categoria">
				<img src="images/stadium.png" class="ca-icon"> <a
					href="stadium.html">STADIUM</a>
			</div>

			<div class="categoria">
				<img src="images/theater.png" class="ca-icon"> <a
					href="theater.html">THEATER</a>
			</div>

			<div class="headerMenu">SOUTH TOWER</div>

			<div class="categoria">
				<img src="images/park.png" class="ca-icon"> <a
					href="park.html">PARK</a>
			</div>

			<div class="categoria">
				<img src="images/tourist.png" class="ca-icon"> <a
					href="tourist_attraction.html">TOURIST ATTRACTION</a>
			</div>

			<div class="categoria">
				<img src="images/market.png" class="ca-icon"> <a
					href="traditional_market.html">TRADITIONAL MARKET</a>
			</div>

			<div class="categoria">
				<img src="images/zoo_.png" class="ca-icon"> <a href="zoo.html">ZOO</a>
			</div>

			<div class="clear"></div>
		</div>

		<div id="rightTopMenuContainer">
			<ul class="rightTopMenu">
				<li id="leftTab">&nbsp;</li>
				<li><a href="welcome.do" class="active">home</a></li>
				<li><a href="about.do">About</a></li>
				<li><a href="profile.do">Profile</a></li>
				<li class="last"><a href="lo
				gout.do">Logout <%
   					 out.println(session.getAttribute("username"));
				%>
				</a></li>
				<li id="rightTab">&nbsp;</li>
				<div class="clear"></div>
			</ul>
		</div>

		<!-- Contenedor -->
		<div id="contenedor">

			<h1>Welcome to the website of New Codington</h1>

			<img src="images/home.png" />

		</div>
		<!-- Fin de  Contenedor -->

	</div>

</body>
</html>