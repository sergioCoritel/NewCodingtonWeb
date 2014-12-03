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
				<li class="show">
					<p class="text-profile">Name</p>
					<div class="profile">${place.name}</div>
				</li>

				<li class="show">
					<p class="text-profile">Capacity</p>
					<div class="profile">${place.capacity}</div>
				</li>

				<li class="show">
					<p class="text-profile">Place Description</p>
					<div class="profile">${place.placeDescription}</div>
				</li>

				<li class="show">
					<p class="text-profile">start</p>
					<div class="profile">${place.start}</div>
				</li>

				<li class="show">
					<p class="text-profile">End</p>
					<div class="profile">${place.end}</div>
				</li>

				<li class="show">
					<p class="text-profile">Zone</p>
					<div class="profile">${place.zone}</div>
				</li>

				<li class="show">
					<p class="text-profile">Image</p>
					<div class="profile">${place.image}</div>
				</li>


			</ul>
			
			<c:if test="${sessionScope.user.isAdmin}">
				<div class="button"><a href="update_place.htm?id=${place.id}&type=${place.placeType}"><img class="ca-icon" alt="" src="images/edit_list.png">Update</a></div>
				<div class="button"><a href="delete_place.htm?id=${place.id}"><img class="ca-icon" alt="" src="images/delete_list.png">Delete</a></div>
			</c:if>
		</div>
		<!-- Fin de  Contenedor -->

	</div>

</body>
</html>