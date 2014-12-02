<jsp:directive.include file="imports_header.jsp" />
<!DOCTYPE HTML>
<html lang="es-ES">
<head>
      <title>New Codington Portal</title>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="css/estilos_event.css"> <!--Enlazo la hoja de estilos externa-->
      <link rel="icon" type="image/ico" href="favicon.ico"/>
      <script type="text/javascript" src="javascript/comprueba.js"></script><!--Enlazo el script externo-->
</head>

<body>
<div id="wrapper">

		<jsp:directive.include file="left_menu.htm" />
		<jsp:directive.include file="top_right_menu.htm" />

   <!-- Contenedor -->
   <div id="contenedor">
       
        <ul class="event">
           
           <c:forEach items="${myevents}" var="event">            
            
            <li>
              <a href="show_event.htm?id=${event.eventId}"> <div class="event-image"> <img src="images/event_museum.jpg"></div></a>
              <div class="event-body">
              <a class="event-title" href="show_event.htm?id=${event.eventId}">${event.eventName}</a><br>
              <a class="event-description" href="show_event.htm?id=${event.eventId}">${event.description} </a> 
              </div>
		        </li>         
          </c:forEach>             
          
            
        </ul>     
   </div><!-- Fin de  Contenedor -->
        
</div>

</body>
</html>