<jsp:directive.include file="imports_header.jsp" />
<!DOCTYPE HTML>
<html lang="es-ES">
<head>
<title>New Codington Portal</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/estilos_event.css">
 <link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css">
<!--Enlazo la hoja de estilos externa-->
<link rel="icon" type="image/ico" href="favicon.ico" />
<script type="text/javascript" src="javascript/events_validation.js"></script>
<!--Enlazo el script externo-->
</head>

<body>
	<div id="wrapper">

		<jsp:directive.include file="left_menu.htm" />
		<jsp:directive.include file="top_right_menu.htm" />
		<!-- Contenedor -->
		<div id="contenedor">

			<form method="post" name="formulario"
				action="${requestScope.action}_event.htm?id=${event.eventId}"
				onsubmit="return validate_event(this);">

				<!-- Espacio para marcar error de campos obligatorios
				<p id="error"></p>-->
				<c:if test="${requestScope.error ne null}">
					<h6 class="messageError">${requestScope.error}</h6>
				</c:if>
				<c:if test="${requestScope.ok ne null}">
					<h6 class="messageOk">${requestScope.ok}</h6>
				</c:if>

				<ul>
					<li>
						<p class="text-profile">Name</p> <input id="name" name="name"
						type="text" value="${event.eventName}" /> <span class="error"
						id="errorName"></span>
					</li>

					<li>

						<p class="text-profile">Description</p> 
						<textarea id="description" name="description" rows="3" cols="50" >${event.description}</textarea>
						<span class="error" id="errorDescription"></span>

					</li>

					<li>
						<p class="text-profile">
							Start <span class="error" id="errorStart"></span>
						</p> <input id="datetimepicker_mask" name="start" type="text" value="${event.start}" />

					</li>

					<li>
						<p class="text-profile">End</p> <input id="datetimepicker_mask2" name="end"
						type="text" value="${event.end}" /> <span class="error"
						id="errorEnd"></span>

					</li>

					<li>
						<p class="text-profile">Type</p> <input id="eventType"
						name="eventType" type="text" value="${event.eventType}" /> <span
						class="error" id="errorType"></span>
					</li>

					<li>
						<p class="text-profile">Ticket Price</p> <input id="ticketPrice"
						name="ticketPrice" type="number" value="${event.ticketPrice}" />
						<span class="error" id="errorPrice"></span>
					</li>


					<li>
						<c:if test="${requestScope.action !='update'}">
							<p class="text-profile">Available Seats</p> 
						</c:if>
						<input id="seatsAvailable" name="seatsAvailable" 
						
						
						<c:if test="${requestScope.action=='update'}">
								type="hidden"
						</c:if>
			
						
						value="${event.seatsAvailable}" />
						<span class="error" id="errorSeats"></span>
					</li>

					<li>
						<p class="text-profile">Place</p> <Select id="place" name="place">
							<option title="" disabled="">Large Bussiness</option>
							<c:forEach items="${largeBusiness}" var="place">
								<option value="${place.id}"
									<c:if test="${place.id == event.place.id}">
									selected = "selected"
								</c:if>>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${place.name}</option>
							</c:forEach>
							<option disabled="">Museum</option>
							<c:forEach items="${museum}" var="place">
								<option value="${place.id}"
									<c:if test="${place.id == event.place.id}">
									selected = "selected"
								</c:if>>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${place.name}</option>
							</c:forEach>
							<option disabled="">Park</option>
							<c:forEach items="${park}" var="place">
								<option value="${place.id}"
									<c:if test="${place.id == event.place.id}">
									selected = "selected"
								</c:if>>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${place.name}</option>
							</c:forEach>
							<option disabled="">Stadium</option>
							<c:forEach items="${stadium}" var="place">
								<option value="${place.id}"
									<c:if test="${place.id == event.place.id}">
									selected = "selected"
								</c:if>>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${place.name}</option>
							</c:forEach>
							<option disabled="">Theater</option>
							<c:forEach items="${theater}" var="place">
								<option value="${place.id}"
									<c:if test="${place.id == event.place.id}">
									selected = "selected"
								</c:if>>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${place.name}</option>
							</c:forEach>
							<option disabled="">Tourist Attraction</option>
							<c:forEach items="${touristAttraction}" var="place">
								<option value="${place.id}"
									<c:if test="${place.id == event.place.id}">
									selected = "selected"
								</c:if>>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${place.name}</option>
							</c:forEach>
							<option disabled="">Traditional Market</option>
							<c:forEach items="${traditionalMarket}" var="place">
								<option value="${place.id}"
									<c:if test="${place.id == event.place.id}">
									selected = "selected"
								</c:if>>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${place.name}</option>
							</c:forEach>
							<option disabled="">Zoo</option>
							<c:forEach items="${zoo}" var="place">
								<option value="${place.id}"
									<c:if test="${place.id == event.place.id}">
									selected = "selected"
								</c:if>>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${place.name}</option>
							</c:forEach>
					</Select>
					</li>
					<br>

					<div class="button">
						<input id="alta" type="submit" value="${requestScope.action}" />
					</div>

		</div>

		</ul>

		</form>
		
		<jsp:directive.include file="datepicker.html" />

	</div>
	</div>
</body>
</html>