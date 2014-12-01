<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:directive.include file="imports_header.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html lang="es">
<head>
<title>Create place</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/estilos_form.css">
<!--Enlazo la hoja de estilos externa-->
<link rel="icon" type="image/ico" href="favicon.ico" />
<script type="text/javascript" src="javascript/comprueba.js"></script>
<!--Enlazo el script externo-->
</head>

<body>
	<div id="wrapper">
		<div id="logo">
			<img src="images/logo.png" class="logo-icon">
		</div>

		<jsp:directive.include file="top_right_menu.htm" />


		<!-- Contenedor -->
		<div id="contenedor">

			<h2>CREATE PLACE</h2>


			<form method="post" enctype="multipart/form-data"
				action="new_place.htm" onsubmit="return valida_envia(this);"
				name="formulario" enctype="multipart/form-data">

				<!-- Espacio para marcar error de campos obligatorios-->
				<p id="error"></p>


				<!-- 1 Caja:Type -->
				<div class="caja">

					<label class="titulo">Place Type<span class="requerido"
						required>*</span></label>
					<!--Titulo caja-->

					<div>
						<select class="requerido required id=" campoType" name="placeType" type="text">
							<option value="1">LARGE BUSINESS</option>
							<option value="2">MUSEUM</option>
							<option value="3">STADIUM</option>
							<option value="4">THEATER</option>
							<option value="5">PARK</option>
							<option value="6">TOURIST ATTRACTION</option>
							<option value="7">TRADITIONAL MARKET</option>
							<option value="8">ZOO</option>
						</select>

						<div class="clear"></div>
						<!--Para limpiar el float-->
					</div>


				</div>
				<!-- Fin de 1 Caja:Type -->


				<!-- 2 Caja:Name -->
				<div class="caja">

					<label class="titulo">Place Name<span class="requerido"
						required>*</span></label>
					<!--Titulo caja-->

					<div>
						<span class="izquierda"> <!--input y etiqueta de input caja-->
							<input class="requerido" required id="campoName" name="placeName"
							value="${place.id}" }" type = "place"/><br>
						</span> <span class="error" id="errorName"></span>
						<!--Espacio para indicar el error de esta caja-->

						<div class="clear"></div>
						<!--Para limpiar el float-->
					</div>


				</div>
				<!-- Fin de 2 Caja:Name -->

				<!-- 3 Caja:Descripcion -->
				<div class="caja">

					<label class="titulo">Place Description<span
						class="requerido" required>*</span></label>
					<!--Titulo caja-->

					<div>
						<span class="izquierda">
							<!--input y etiqueta de input caja--> <input
							id="campoDescripcion" name="placeDescription"
							value="${place.placeDescription}" /><br>
						</span> <span class="error" id="errorDescripcion"></span>
						<!--Espacio para indicar el error de esta caja-->

						<div class="clear"></div>
						<!--Para limpiar el float-->
					</div>



				</div>
				<!-- Fin de 3 Caja:Descripcion -->

				<!-- 4 Caja:Capacity-->
				<div class="caja">

					<label class="titulo">Capacity<span class="requerido"
						required>*</span></label>
					<!--Titulo caja-->

					<div>
						<span class="izquierda"> <!--input y etiqueta de input caja-->
							<input id="campoCapacity" name="placeCapacity"
							value="${place.capacity}" /><br>
						</span> <span class="error" id="errorCapacity"></span>
						<!--Espacio para indicar el error de esta caja-->

						<div class="clear"></div>
						<!--Para limpiar el float-->
					</div>

				</div>
				<!-- Fin de 4 Caja:Capacity-->

				<!-- 5 Caja:Start-->
				<div class="caja">

					<label class="titulo">Start Time<span class="requerido"
						required>*</span></label>
					<!--Titulo caja-->

					<div>
						<span class="izquierda"> <!--input y etiqueta de input caja-->
							<input id="campoStart" name="placeStart" value="${place.start}" /><br>
						</span> <span class="error" id="errorStart"></span>
						<!--Espacio para indicar el error de esta caja-->

						<div class="clear"></div>
						<!--Para limpiar el float-->
					</div>



				</div>
				<!-- Fin de 5 Caja:Start-->

				<!-- 6 Caja:End-->
				<div class="caja">

					<label class="titulo">End Time<span class="requerido"
						required>*</span></label>
					<!--Titulo caja-->

					<div>
						<span class="izquierda"> <!--input y etiqueta de input caja-->
							<input id="campoEnd" name="placeEnd" value="${place.end}" /><br>
						</span> <span class="error" id="errorEnd"></span>
						<!--Espacio para indicar el error de esta caja-->

						<div class="clear"></div>
						<!--Para limpiar el float-->
					</div>


				</div>
				<!-- Fin de 6 Caja:End-->



				<!-- 7 Caja:Image-->
				<div class="caja">

					<label class="titulo">Image<span class="requerido">*</span></label>
					<!--Titulo caja-->

					<div>
						<span class="izquierda"> <!--input y etiqueta de input caja-->
							<input type="file" id="campoImage" name="placeImage"
							value="${place.image}" required /><br>
						</span> <span class="error" id="errorImage"></span>
						<!--Espacio para indicar el error de esta caja-->

						<div class="clear"></div>
						<!--Para limpiar el float-->
					</div>

				</div>
				<!-- Fin de 7 Caja:Image-->



				<!-- Boton de enviar-->
				<div class="botones">
					<input id="alta" type="submit" value="Validate &rarr;" />
				</div>
				<!-- Fin de Boton de enviar-->

			</form>

		</div>
	</div>
	<!-- Fin de  Contenedor -->
</body>
</html>