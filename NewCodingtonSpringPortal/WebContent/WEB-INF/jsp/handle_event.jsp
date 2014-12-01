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
		<c:if test="${requestScope.error ne null}">
			<h6 class="messageError">${requestScope.error}</h6>
		</c:if>
		<c:if test="${requestScope.ok ne null}">
			<h6 class="messageOk">${requestScope.ok}</h6>
		</c:if>


		<jsp:directive.include file="left_menu.htm" />
		<jsp:directive.include file="top_right_menu.htm" />
		<!-- Contenedor -->
		<div id="contenedor">
			<form method="post" action="new_event.htm"
				onsubmit="return valida_envia(this);" name="formulario">
				<ul>
					<li>
						<p class="text-profile">Name</p> <input id="name" name="name"
						type="text" value="${event.eventName}" />
					</li>

					<li>
						<p class="text-profile">Description</p> <input id="description"
						name="description" type="text" value="${event.description}" />
					</li>

					<li>
						<p class="text-profile">Start</p> <input id="start" name="start"
						type="text" value="${event.start}" />
					</li>

					<li>
						<p class="text-profile">End</p> <input id="end" name="end"
						type="text" value="${event.end}" />
					</li>

					<li>
						<p class="text-profile">Type</p> <input id="eventType"
						name="eventType" type="text" value="${event.eventType}" />
					</li>

					<li>
						<p class="text-profile">Ticket Price</p> <input id="ticketPrice"
						name="ticketPrice" type="text" value="${event.ticketPrice}" />
					</li>

					<li>
						<p class="text-profile">Available Seats</p> <input
						id="seatsAvailable" name="seatsAvailable" type="text"
						value="${event.seatsAvailable}" />
					</li>

					<li>
						<p class="text-profile">Place</p> <Select id="place" name="place">
							<option value="" id="placeVacio" selected="selected"
								title="Select a feed"></option>
							<option title="" disabled="">Large Bussiness</option>
							<c:forEach items="${largeBusiness}" var="place">
								<option value="${place.id}">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${place.name}</option>
							</c:forEach>
							<option disabled="">Museum</option>
							<c:forEach items="${museum}" var="place">
								<option value="${place.id}">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${place.name}</option>
							</c:forEach>
							<option disabled="">Park</option>
							<c:forEach items="${park}" var="place">
								<option value="${place.id}">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${place.name}</option>
							</c:forEach>
							<option disabled="">Stadium</option>
							<c:forEach items="${stadium}" var="place">
								<option value="${place.id}">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${place.name}</option>
							</c:forEach>
							<option disabled="">Theater</option>
							<c:forEach items="${theater}" var="place">
								<option value="${place.id}">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${place.name}</option>
							</c:forEach>
							<option disabled="">Tourist Attraction</option>
							<c:forEach items="${touristAttraction}" var="place">
								<option value="${place.id}">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${place.name}</option>
							</c:forEach>
							<option disabled="">Traditional Market</option>
							<c:forEach items="${traditionalMarket}" var="place">
								<option value="${place.id}">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${place.name}</option>
							</c:forEach>
							<option disabled="">Zoo</option>
							<c:forEach items="${zoo}" var="place">
								<option value="${place.id}">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${place.name}</option>
							</c:forEach>
					</Select>
					</li>

				</ul>


				<!-- Boton de enviar-->
				<div class="botones">
					<div class="button">
						<a href="new_event.htm">Create</a>
					</div>
				</div>
				<!-- Fin de Boton de enviar-->

			</form>

		</div>
		
		
</body>
</html>