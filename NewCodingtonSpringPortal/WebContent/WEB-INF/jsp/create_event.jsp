<jsp:directive.include file="imports_header.jsp" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html lang="es">
<head>
      <title>CREATE EVENT</title>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="css/estilos_event.css"> <!--Enlazo la hoja de estilos externa-->
      <link rel="icon" type="image/ico" href="favicon.ico"/>
      <script type="text/javascript" src="javascript/comprueba.js"></script><!--Enlazo el script externo-->
</head>

<body>
<div id="wrapper">

		<jsp:directive.include file="left_menu.htm" />
		<jsp:directive.include file="top_right_menu.htm" />

<!-- Contenedor -->
<div id="contenedor">

        <h2>CREATE EVENT</h2>


        <form method="post"  action="" onsubmit="return valida_envia(this);" name="formulario" enctype="multipart/form-data" >

       <!-- Espacio para marcar error de campos obligatorios-->
        <p id="error"> </p>

        <!-- 1 Caja:nombre -->
        <div class="caja">

                <label class="titulo">Event Name<span class="requerido" required>*</span></label> <!--Titulo caja-->

                <div>
                    <span class="izquierda">  <!--input y etiqueta de input caja-->
                      <input class="requerido" required id="campoNombre" name="campoNombre" value="" /><br>
                    </span>

                    <div class="clear"></div> <!--Para limpiar el float-->
                </div>

        
        </div>
        <!-- Fin de 1 Caja:nombre -->

        <!-- 2 Caja:Descripcion -->
        <div class="caja" >

            <label class="titulo">Event Description<span class="requerido" required>*</span></label> <!--Titulo caja-->

            <div>
                <span class="izquierda"><!--input y etiqueta de input caja-->
                  <input id="campoDescripcion" name="campoDescription" value="" /><br>
                </span>
                
                <span class="error" id="errorDescripcion"></span> <!--Espacio para indicar el error de esta caja-->

                <div class="clear"></div> <!--Para limpiar el float-->
            </div>

         

        </div>
        <!-- Fin de 2 Caja:Descripcion -->

        <!-- 3 Caja:Start-->
        <div class="caja">

              <label class="titulo" >Start Time<span class="requerido" required>*</span></label> <!--Titulo caja-->

              <div>
                  <span class="izquierda" >  <!--input y etiqueta de input caja-->
                    <input id="campoStart" name="campoStart" value="" /><br>
                  </span>

                  <span class="error" id="errorStart"></span> <!--Espacio para indicar el error de esta caja-->

                  <div class="clear"></div> <!--Para limpiar el float-->
              </div>

            

        </div>
        <!-- Fin de 3 Caja:Start-->

        <!-- 4 Caja:End-->
        <div class="caja">

              <label class="titulo" >End Time<span class="requerido" required>*</span></label> <!--Titulo caja-->

              <div>
                    <span class="izquierda">  <!--input y etiqueta de input caja-->
                       <input id="campoEnd" name="campoEnd" value="" /><br>
                    </span>
                  <span class="error" id="errorEnd"></span> <!--Espacio para indicar el error de esta caja-->

                  <div class="clear"></div> <!--Para limpiar el float-->
              </div>

          
        </div>
        <!-- Fin de 4 Caja:End-->

  

        <!-- 5 Caja:Type-->
        <div class="caja">

              <label class="titulo">Event Type<span class="requerido" required>*</span></label> <!--Titulo caja-->

              <div>
                  <span class="izquierda">  <!--input y etiqueta de input caja-->
                    <input id="campoType" name="campoType" value="" /><br>
                  </span>

                  <span class="error" id="errorType"></span> <!--Espacio para indicar el error de esta caja-->

                  <div class="clear"></div> <!--Para limpiar el float-->
              </div>

      

        </div>
        <!-- Fin de 5 Caja:Type-->
		
		<!-- 6 Caja:Price -->
        <div class="caja">

              <label class="titulo">Ticket Price<span class="requerido" required>*</span></label> <!--Titulo caja-->

              <div>
			  
                  <span class="izquierda">  <!--input y etiqueta de input caja-->
                    <input id="campoPrice" name="campoPrice" value="" /><br>
                  </span>

                  <span class="error" id="errorPrice"></span> <!--Espacio para indicar el error de esta caja-->

                  <div class="clear"></div> <!--Para limpiar el float-->
              </div>

           

        </div>
        <!--Fin de 6 Caja:Price -->

        <!-- 7 Caja:Seats-->
        <div class="caja" >
              <label class="titulo" >Total Seats<span class="requerido" required>*</span></label> <!--Titulo caja-->

              <div>

                  <span class="izquierda"> <!--input y etiqueta de input caja-->
                    <input id="campoSeats" name="campoSeats" value="" /><br>
                  </span>


                  <span class="error" id="errorSeats"></span> <!--Espacio para indicar el error de esta caja-->

                  <div class="clear"></div> <!--Para limpiar el float-->
              </div>

        </div>
        <!--Fin de 7 Caja:Seats -->

        <!-- Boton de enviar-->
        <div class="botones">
                <input id="alta" type="submit" value="Validate &rarr;"/>
        </div>
        <!-- Fin de Boton de enviar-->

        </form>

</div>
</div><!-- Fin de  Contenedor -->
</div>

</body>
</html>