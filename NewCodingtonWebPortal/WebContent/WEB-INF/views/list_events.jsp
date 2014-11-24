
<!-- Author: Sergio Morán Blanco -->

<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
 <head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
	
	<title>NewCodington | Home</title>
	
	<link href="css/General.css" type="text/css" rel="stylesheet">	
	<link href="css/Home.css" type="text/css" rel="stylesheet">	
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
	<script type="text/javascript" src="js/resize.js"></script> 
 </head>

 <body>
 	<div class="body">
	 	<div class="header">	 		
	 		<div class="homeTitle">
	 			<h1>HOME</h1>
	 			
	 			<c:if test="${sessionScope.visitor.admin ne false}">
	   				<a href="catalog.do"><button class="updateButton">Administrar</button></a>
				</c:if>	
	 			
 			</div>

	 		<div class="profile">
	 			<span><c:out value="${sessionScope.visitor.firstName} ${sessionScope.visitor.lastName}"></c:out></span>
	 			<br/>
	 			<span><c:out value="${sessionScope.visitor.userName}"></c:out> (<a href="logout.do">logout</a>)</span>
	 			<br/>	 			
	 			<br/>


	 			<span>Actualizar datos <a class="profileButton" href="personalInfo.do">personales</a> / <a class="profileButton" href="accountInfo.do">cuenta</a></span>
	 			<br/>
 				<br/>	 			
	 		</div>	 		 		
	 	</div> 	

	 	<div class="body">	 		
	 		<div class="events">
	 			<h3>Eventos</h3>
	 			<form class="searcher" action="searchEventByName.do">	 				
		 			<input class="searchInput" type="text" name="eventName" placeholder="Buscador...">
		 			<input class="searchButton" type="submit" value="Buscar">			 				 		
	 			</form>
	 			
	 			<span class="order">Orden alfabetico <a href="order.do?order=true">ascendente</a>/<a href="order.do?order=false">descendente</a>.</span>
	 			
		 		<ul>
		 			<c:forEach items="${events}" var="event">						
						<li>
	 						<div class="event">
								<h3 class="eventName"><c:out value="${event.name}"/></h3>
								<br/>
								<br/>
								
								<div class="eventInfo">
									<p><b>Ubicación:</b> <c:out value="${event.place}" /></p>
									<p><b>Duración:</b> <c:out value="${event.duration}" /></p>
									<p><b>Aforo:</b> <c:out value="${event.seatsAEvent}" /></p>
									<p><b>Tipo:</b> <c:out value="${event.eventType}" /></p>
								</div>								
								
								<p class="eventDescription"><c:out value="${event.description}"/></p>
								
								<c:if test="${(requestScope.error ne null) && (requestScope.eventError == event.eventId)}">
	   								<p class="messageError">"${requestScope.error}"</p>
								</c:if>	
								<br/>
								<br/>
								
								<a href="eventReg.do?eventId=${event.eventId}"><button class="eventButton">Registrarse</button></a>																							
	 						</div>
	 					</li>						
					</c:forEach>	 					 				
		 		</ul>
	 		</div>

	 		<div class="myEvents">
	 			<h3>Mis eventos</h3>
		 		<ul>
	 				<c:forEach items="${sessionScope.visitorEvents}" var="event">						
						<li>
	 						<div class="event">
								<h3 class="eventName"><c:out value="${event.name}"/></h3>
								<br/>
																
								<div class="myEventInfo">
									<p><b>Ubicación:</b> <c:out value="${event.place}"/></p>																														
								</div>
								<br/>
								
								<a href="eventUnreg.do?eventId=${event.eventId}"><button class="myEventButton">Desregistrarse</button></a>						
	 						</div>
	 					</li>
 					</c:forEach>	
		 		</ul>
	 		</div>
	 	</div> 	
 	</div>
 </body>
</html>