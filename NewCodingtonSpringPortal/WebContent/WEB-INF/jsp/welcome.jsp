<jsp:directive.include file="imports_header.jsp" />
<!DOCTYPE HTML>
<html lang="es-ES">
<head>
<title>Home</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/estilos_home.css">
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

			<h1>Welcome to the website of New Codington</h1>
			
                <c:if test="${requestScope.error ne null}">
					<h6 class="messageError">${requestScope.error}</h6>
				</c:if>
				
				<c:if test="${requestScope.ok ne null}">
					<h6 class="messageOk">${requestScope.ok}</h6>
				</c:if>
				
			<img src="images/home.png" />

		</div>
		<!-- Fin de  Contenedor -->

	</div>

</body>
</html>