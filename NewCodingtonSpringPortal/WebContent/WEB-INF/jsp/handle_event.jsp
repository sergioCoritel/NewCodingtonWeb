<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:directive.include file="imports_header.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html lang="es">
<head>
<title>New Codington Portal</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/estilos_event.css">
<!--Enlazo la hoja de estilos externa-->
<link rel="icon" type="image/ico" href="favicon.ico" />
<script type="text/javascript" src="javascript/comprueba.js"></script>
<!--Enlazo el script externo-->
</head>

<body>
	<div id="wrapper">
		<jsp:directive.include file="left_menu.htm" />
		<jsp:directive.include file="top_right_menu.htm" />
		<!-- Contenedor -->
		<div id="contenedor">
		 <form method="post"  action="validate_register.do" onsubmit="return valida_envia(this);" name="formulario">
			<ul>
				<li>
					<p class="text-profile">Name</p>
					 <input id="name" name="name" type="text" value="${event.eventName}" />
				</li>

				<li>
					<p class="text-profile">Description</p>
					 <input id="description" name="description" type="text" value="${event.description}" />
				</li>

				<li>
					<p class="text-profile">Start</p>
					 <input id="start" name="start" type="text" value="${event.start}" />
				</li>

				<li>
					<p class="text-profile">End</p>
					 <input id="end" name="end" type="text" value="${event.end}" />
				</li>

				<li>
					<p class="text-profile">Type</p>
					 <input id="eventType" name="eventType" type="text" value="${event.eventType}" />
				</li>

				<li>
					<p class="text-profile">Ticket Price</p>
					 <input id="ticketPrice" name="ticketPrice" type="text" value="${event.ticketPrice}" />
				</li>

				<li>
					<p class="text-profile">Available Seats</p>
					 <input id="seatsAvailable" name="seatsAvailable" type="text" value="${event.seatsAvailable}" />
				</li>

				<li>
					<p class="text-profile">Total Seats</p>
					 <input id="seatsTotal" name="seatsTotal" type="text" value="${event.seatsTotal}" />
				</li>

			</ul>

			
        <!-- Boton de enviar-->
        <div class="botones">
                <input id="alta" type="submit" value="Validate &rarr;"/>
        </div>
        <!-- Fin de Boton de enviar-->

        </form>

	</div>

</body>
</html>