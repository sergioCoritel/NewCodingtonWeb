<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="es">
<head>
      <title>About</title>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="css/estilos_event.css"> <!--Enlazo la hoja de estilos externa-->
	  <link rel="icon" type="image/ico" href="favicon.ico"/>
      <script type="text/javascript" src="comprueba.js"></script><!--Enlazo el script externo-->
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
					href="list_events.do?type=business">LARGE BUSSINESS</a>
			</div>

			<div class="categoria">
				<img src="images/museum.png" class="ca-icon"> <a
					href="list_events.do?type=museum">MUSEUM</a>
			</div>

			<div class="categoria">
				<img src="images/stadium.png" class="ca-icon"> <a
					href="list_events.do?type=stadium">STADIUM</a>
			</div>

			<div class="categoria">
				<img src="images/theater.png" class="ca-icon"> <a
					href="list_events.do?type=theater">THEATER</a>
			</div>

			<div class="headerMenu">SOUTH TOWER</div>

			<div class="categoria">
				<img src="images/park.png" class="ca-icon"> <a
					href="list_events.do?type=park">PARK</a>
			</div>

			<div class="categoria">
				<img src="images/tourist.png" class="ca-icon"> <a
					href="list_events.do?type=tourist">TOURIST ATTRACTION</a>
			</div>

			<div class="categoria">
				<img src="images/market.png" class="ca-icon"> <a
					href="list_events.do?type=market">TRADITIONAL MARKET</a>
			</div>

			<div class="categoria">
				<img src="images/zoo_.png" class="ca-icon"> 
				<a href="list_events.do?type=zoo">ZOO</a>
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
       
        <ul class="event">
           
            <li>
              <div class = "about">
              <h2>About New Codington</h2>
               <p>  New Condington City is a new city built in the south of New Codignton Country. This city has two parts: north and south. There are four different types of places in each part. In the north, large business, museum, stadium and theater; while in the south, park, zoo, tourist atracttion and traditional market.<br>
			   In this website, we can register and unregister in any type of events that occurs in any place. <br>
			   For any suggestion or question, please contact with us. </p> 
              </div>
		    </li> 

            <li>
              <div class = "about">
              <h2>About Creators' Web</h2>
              <p>  Website created by :
                <ol class = "names">
			               <li>Alonso Jiménez, Pedro</li>
                     <li>Andrés García, Sergio </li>
                     <li>De Miguel Pérez, Beatriz</li>
                     <li>García Pérez, Juan Manuel</li>
                     <li>Guerrero Santana,Esther</li>
                     <li>Salcedo Ortiz, Marloon</li>
                     <li>Sanmiguel, Agustín</li>
					           <li>Soria Gallego, Juan</li>
                </ol>
              </p> 
              </div>
			</li>
			
        </ul>     
   </div><!-- Fin de  Contenedor -->
        
</div>

</body>
</html>