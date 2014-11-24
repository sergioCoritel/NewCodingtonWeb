<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
      <title>Registration form</title>
	  <link rel="icon" type="image/ico" href="favicon.ico"/>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="estilos.css"> <!--Enlazo la hoja de estilos externa-->
      <script type="text/javascript" src="comprueba.js"></script><!--Enlazo el script externo-->
</head>

<body>
<div id="wrapper">
  <h1 id="webname">New<br><span>Codington</span></h1>
<!--
  <div id="LeftMenu">
             
        <div class="categoria">
          <a href="controlador.php?cat=7">MUSEOS</a>
        </div>

             <div class="categoria">
          <a href="controlador.php?cat=7">MUSEOS</a>
        </div>
             <div class="categoria">
          <a href="controlador.php?cat=7">MUSEOS</a>
        </div>
             <div class="categoria">
          <a href="controlador.php?cat=7">MUSEOS</a>
        </div>
             <div class="categoria">
          <a href="controlador.php?cat=7">MUSEOS</a>
        </div>
        -->
       
        <div id="clear"></div>
</div>
<!-- Contenedor -->
<div id="contenedor">

        <h2>Registration form</h2>


        <form method="post"  action="formuser" onsubmit="return valida_envia(this);" name="formulario" >

       <!-- Espacio para marcar error de campos obligatorios-->
        <p id="error"> </p>

        <!-- 1 Caja:nombre y apellidos -->
        <div class="caja">

                <label class="titulo">First and Last Name <span class="requerido" required>*</span></label> <!--Titulo caja-->

                <div>
                    <span class="izquierda">  <!--input y etiqueta de input caja-->
                      <input class="requerido" required id="campoNombre" name="campoNombre" value="" /><br>
                      <label>First Name</label>
                    </span>

                    <span class="derecha">  <!--input y etiqueta de input caja-->
                      <input id="campoApellidos" name="campoApellidos" value="" /><br>
                      <label >Last name</label>
                    </span>

                    <div class="clear"></div> <!--Para limpiar el float-->
                </div>

        
        </div>
        <!-- Fin de 1 Caja:nombre y apellidos -->

        <!-- 2 Caja:DNI -->
        <div class="caja" >

            <label class="titulo">DNI <span class="requerido" required>*</span></label> <!--Titulo caja-->

            <div>
                <span class="izquierda"><!--input y etiqueta de input caja-->
                  <input id="campoDNI" name="campoDNI" value="" /><br>
                </span>
                
                <span class="error" id="errorDNI"></span> <!--Espacio para indicar el error de esta caja-->

                <div class="clear"></div> <!--Para limpiar el float-->
            </div>

         

        </div>
        <!-- Fin de 2 Caja:DNI -->

        <!-- 4 Caja:Direccion-->
        <div class="caja">

              <label class="titulo" >Address</span></label> <!--Titulo caja-->

              <div>
                  <span class="izquierda" >  <!--input y etiqueta de input caja-->
                    <input id="campoDomicilio" name="campoDomicilio" value="" /><br>
                    <label>Street, number, floor, door</label>
                  </span>
              </div>

            

        </div>
        <!-- Fin de 4 Caja:Direccion-->

        <!-- 6 Caja:Telefono-->
        <div class="caja">

              <label class="titulo" >Phone Number</span></label> <!--Titulo caja-->

              <div>
                    <span class="izquierda">  <!--input y etiqueta de input caja-->
                       <input id="campoTelefono" name="campoTelefono" value="" /><br>
                       <label>Ex: 00+Code Country+Number. 0034925224018</label>
                    </span>
                  <span class="error" id="errorTelefono"></span> <!--Espacio para indicar el error de esta caja-->
              </div>

          
        </div>
        <!-- Fin de 6 Caja:Telefono-->

  

        <!-- 7 Caja:Mail-->
        <div class="caja">

              <label class="titulo">Mail<span class="requerido" required>*</span></label> <!--Titulo caja-->

              <div>
                  <span class="izquierda">  <!--input y etiqueta de input caja-->
                    <input id="campoMail" name="campoMail" value="" /><br>
                  </span>
                  <span class="error" id="errorMail"></span> <!--Espacio para indicar el error de esta caja-->
              </div>

      

        </div>
        <!-- Fin de 7 Caja:Mail-->
		
		<!-- 3 Caja:Username -->
        <div class="caja">

              <label class="titulo">User Name<span class="requerido" required>*</span></label> <!--Titulo caja-->

              <div>
			  
                  <span class="izquierda">  <!--input y etiqueta de input caja-->
                    <input id="campoUsername" name="campoUsername" type="username" value="" /><br>
                  </span>

                  <span class="error" id="errorUsername"></span> <!--Espacio para indicar el error de esta caja-->
              </div>

           

        </div>
        <!--Fin de 3 caja -->

        <!-- 8 Caja:Contraseñas-->
        <div class="caja" >
              <label class="titulo" >Password <span class="requerido" required>*</span></label> <!--Titulo caja-->

              <div>

                  <span class="izquierda"> <!--input y etiqueta de input caja-->
                    <input id="campoPassword" name="campoPassword" type="password" value="" /><br>
                    <label>Password</label>
                  </span>

                  <span class="derecha">  <!--input y etiqueta de input caja-->
                    <input id="campoComprobarPassword" name="campoComprobarPassword" type="password" value="" /><br>
                    <label >Repeat Password</label>
                  </span>

                  <span class="error" id="errorPassword"></span> <!--Espacio para indicar el error de esta caja-->

                  <div class="clear"></div> <!--Para limpiar el float-->
              </div>

        </div>
        <!-- 8 Caja:Contraseñas-->

        <!-- Boton de enviar-->
        <div class="botones">
                <input id="alta" type="submit" value="Validate &rarr" formaction="formuser"/>
        </div>
        <!-- Fin de Boton de enviar-->

        </form>

</div>
</div><!-- Fin de  Contenedor -->
</body>
</html>