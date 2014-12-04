<jsp:directive.include file="imports_header.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
      <title>Create place</title>
	  <link rel="icon" type="image/ico" href="favicon.ico"/>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="css/estilos_form.css"> <!--Enlazo la hoja de estilos externa-->
	 <link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css">
     
     
     <script type="text/javascript" src="javascript/comprueba.js"></script><!--Enlazo el script externo-->
</head>

<body>
<div id="wrapper">
  <div id="logo">
        <img src="images/logo.png" class="logo-icon">
  </div>

<!-- Contenedor -->
<div id="contenedor">

        <h2>${requestScope.section} place</h2>
        
                <c:if test="${requestScope.error ne null}">
					<h6 class="messageError">${requestScope.error}</h6>
				</c:if>
				
				<c:if test="${requestScope.ok ne null}">
					<h6 class="messageOk">${requestScope.ok}</h6>
				</c:if>
        
        <form method="post"  action="${requestScope.section}_place.htm?id=${place.id}" onsubmit="return valida_envia(this);" name="formulario">


       <!-- Espacio para marcar error de campos obligatorios-->
        <p id="error"> </p>

        <!-- 1 Caja:Type -->
        <div class="caja">

                <label class="titulo">Place Type <span class="requerido" required>*</span></label> <!--Titulo caja-->

					<div>
						<select 
						<%-- 	<c:if test="${requestScope.section == 'create'}">
					                    type="hidden"
				           </c:if> --%>
						     class="requerido required id="  name="placeType">
							<option value="1">LARGE BUSINESS</option>
							<option value="2">MUSEUM</option>
							<option value="4">STADIUM</option>
							<option value="5">THEATER</option>
							<option value="3">PARK</option>
							<option value="6">TOURIST ATTRACTION</option>
							<option value="7">TRADITIONAL MARKET</option>
							<option value="8">ZOO</option>
						</select>

						<div class="clear"></div>
						<!--Para limpiar el float-->
					</div>

        
        </div>
        <!-- Fin de 1 Type -->

        <!-- 2 Caja:Name -->
        <div class="caja" >

            <label class="titulo">Place Name <span class="requerido" required>*</span></label> <!--Titulo caja-->

            <div>
                <span class="izquierda"><!--input y etiqueta de input caja-->
                  <input id="placeName" name="placeName" value="${place.name}" /><br>
                </span>
                
                <span class="error" id="errorDNI"></span> <!--Espacio para indicar el error de esta caja-->

                <div class="clear"></div> <!--Para limpiar el float-->
            </div>

         

        </div>
        <!-- Fin de 2 Caja:Type -->

        <!-- 3 Caja:Descripcion-->
        <div class="caja">

              <label class="titulo" >Place Description</label> <!--Titulo caja-->

              <div>
                  <span class="izquierda" >  <!--input y etiqueta de input caja-->
                    <textarea name="campoDescription" rows="3" cols="50" >${place.description}</textarea>
                  </span>
              </div>

            

        </div>
        <!-- Fin de 3 Caja:Descripcion-->

        <!-- 4 Caja:Capacity-->
        <div class="caja">

              <label class="titulo" >Capacity</span></label> <!--Titulo caja-->

              <div>
                    <span class="izquierda">  <!--input y etiqueta de input caja-->
                       <input id="placeCapacity" name="placeCapacity" value="${place.capacity}" /><br>
                    </span>
                  <span class="error" id="errorCapacity"></span> <!--Espacio para indicar el error de esta caja-->
              </div>

          
        </div>
        <!-- Fin de 4 Caja:Capacity-->

  

        <!-- 5 Caja:Start-->
        <div class="caja">

              <label class="titulo">Start Time<span class="requerido" required>*</span></label> <!--Titulo caja-->

              <div>
                  <span class="izquierda">  <!--input y etiqueta de input caja-->
                    <input id="datetimepicker_mask" name="placeStart" value="${place.start}" /><br>
                  </span>
                  <span class="error" id="errorStart"></span> <!--Espacio para indicar el error de esta caja-->
              </div>

      

        </div>
        <!-- Fin de 5 Caja:Start-->
		
		<!-- 6 Caja:End -->
        <div class="caja">

              <label class="titulo">End Time<span class="requerido" required>*</span></label> <!--Titulo caja-->

              <div>
			  
                  <span class="izquierda">  <!--input y etiqueta de input caja-->
                    <input id="datetimepicker_mask2" name="placeEnd" type="username" value="${place.end}" /><br>
                  </span>

                  <span class="error" id="errorUsername"></span> <!--Espacio para indicar el error de esta caja-->
              </div>

           

        </div>
        <!--Fin de 6 Caja:End -->



		<!-- 7 Caja:Image -->
        <div class="caja">

              <label class="titulo">Image<span class="requerido" required>*</span></label> <!--Titulo caja-->

              <div>
			  
                  <span class="izquierda">  <!--input y etiqueta de input caja-->
                    <input id="placeImage" name="placeImage" type="file" value="" /><br>
                  </span>

                  <span class="error" id="errorUsername"></span> <!--Espacio para indicar el error de esta caja-->
              </div>

           

        </div>
        <!--Fin de 7 Caja:Image -->



        <!-- Boton de enviar-->
        <div class="botones">
                <input id="alta" type="submit" value="Validate &rarr;"/>
        </div>
        <!-- Fin de Boton de enviar-->
        

        </form>
        
<jsp:directive.include file="datepicker.html" />

</div>
</div><!-- Fin de  Contenedor -->
</body>
