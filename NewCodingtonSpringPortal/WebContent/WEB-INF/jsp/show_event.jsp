<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:directive.include file="imports_header.jsp" />
<!DOCTYPE HTML>
<html lang="es-ES">
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
			<img class="event-large-image" alt=""
				src="http://agilisenergy.com/tinseltown/wp-content/uploads/2013/01/building-icon-free-analysis.png">
			<ul>
				<li>
					<p class="text-profile">Name</p>
					<div class="profile">${event.eventName}</div>
				</li>

				<li>
					<p class="text-profile">Description</p>
					<div class="profile">${event.description}</div>
				</li>

				<li>
					<p class="text-profile">Start</p>
					<div class="profile">${event.start}</div>
				</li>

				<li>
					<p class="text-profile">End</p>
					<div class="profile">${event.end}</div>
				</li>

				<li>
					<p class="text-profile">Type</p>
					<div class="profile">${event.eventType}</div>
				</li>

				<li>
					<p class="text-profile">Ticket Price</p>
					<div class="profile">${event.ticketPrice}</div>
				</li>

				<li>
					<p class="text-profile">Available Seats</p>
					<div class="profile">${event.seatsAvailable}</div>
				</li>

				<li>
					<p class="text-profile">Total Seats</p>
					<div class="profile">${event.seatsTotal}</div>
				</li>

				<li><p class="text-profile">Place</p>
					<div class="profile">${event.place.name}</div>
				</li>
				<li><p class="text-profile">Place description</p>
					<div class="profile">${event.place.placeDescription}</div>
				</li>

			</ul>
			
			<c:if test="${!sessionScope.user.isAdmin}">
				<c:if test="${!isRegister}">
				<div class="button"><a href="register_event.htm?id=${event.eventId}">Register</a></div>
				</c:if>
				<c:if test="${isRegister}">
				<div class="button"><a href="unregister_event.htm?id=${event.eventId}">Unregister</a></div>
				</c:if>
			</c:if>
			
			<c:if test="${sessionScope.user.isAdmin}">
				<div class="button"><a href="update_event.htm?id=${event.eventId}">Update</a></div>
				<div class="button"><a href="delete_event.htm?id=${event.eventId}">Delete</a></div>
			</c:if>
		</div>
		<!-- Fin de  Contenedor -->

	</div>

</body>
</html>