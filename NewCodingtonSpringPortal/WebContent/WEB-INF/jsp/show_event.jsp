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
				src=${event.place.image}>
					<h4>${event.eventName}</h4>
			<ul>
			
				<li class="show">
					<p class="text-profile">Description:
					<span>${event.description}</span>
					</p>
				</li>

				<li class="show">
					<p class="text-profile">Start:
					<span>${event.start}</span>
					</p>
				</li>

				<li class="show">
					<p class="text-profile">End:
					<span>${event.end}</span>
					</p>
				</li>

				<li class="show">
					<p class="text-profile">Type:
					<span>${event.eventType}</span>
					</p>
				</li>

				<li class="show">
					<p class="text-profile">Ticket Price:
					<span>${event.ticketPrice}</span>
					</p>
				</li>

				<li class="show">
					<p class="text-profile">Available Seats:
					<span>${event.seatsAvailable}</span>
					</p>
				</li>

				<li class="show">
					<p class="text-profile">Total Seats:
					<span>${event.seatsTotal}</span>
					</p>
				</li>

				<li class="show"><p class="text-profile">Place:
					<span>${event.place.name}</span>
					</p>
				</li>
				<li class="show"><p class="text-profile">Place description:
					<span>${event.place.placeDescription}</span>
					</p>
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
				<div><a class="button" href="formupdate_event.htm?id=${event.eventId}"><img class="ca-icon" alt="" src="images/edit_list.png">Update</a></div>
				<div><a class="button" href="delete_event.htm?id=${event.eventId}"><img class="ca-icon" alt="" src="images/delete_list.png">Delete</a></div>
			</c:if>
		</div>
		<!-- Fin de  Contenedor -->

	</div>

</body>
</html>