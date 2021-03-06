<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
      <title>Create place</title>
	  <link rel="icon" type="image/ico" href="favicon.ico"/>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="css/estilos_form.css"> <!--Enlazo la hoja de estilos externa-->
      <script type="text/javascript" src="comprueba.js"></script><!--Enlazo el script externo-->
</head>

<body>
<div id="wrapper">
  <div id="logo">
        <img src="images/logo.png" class="logo-icon">
  </div>

		<div id="rightTopMenuContainer">
			<ul class="rightTopMenu">
				<li id="leftTab">&nbsp;</li>
				<li><a href="welcome.do" class="active">home</a></li>
				<li><a href="about.do">About</a></li>
				<li><a href="profile.do">Profile</a></li>
				<li class="last"><a href="lo
				gout.do">Logout <%
   					 out.println(session.getAttribute("username"));
				%>
				</a></li>
				<li id="rightTab">&nbsp;</li>
				<div class="clear"></div>
			</ul>
		</div>
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

        <h2>CREATE PLACE</h2>


        <form method="post"  action="" onsubmit="return valida_envia(this);" name="formulario" enctype="multipart/form-data" >

       <!-- Espacio para marcar error de campos obligatorios-->
        <p id="error"> </p>

        <!-- 1 Caja:Name -->
        <div class="caja">

                <label class="titulo">Place Name<span class="requerido" required>*</span></label> <!--Titulo caja-->

                <div>
                    <span class="izquierda">  <!--input y etiqueta de input caja-->
                      <input class="requerido" required id="campoName" name="campoName" value="" /><br>
                    </span>

                    <span class="error" id="errorName"></span> <!--Espacio para indicar el error de esta caja-->

                    <div class="clear"></div> <!--Para limpiar el float-->
                </div>

        
        </div>
        <!-- Fin de 1 Caja:Name -->

        <!-- 2 Caja:Descripcion -->
        <div class="caja" >

            <label class="titulo">Place Description<span class="requerido" required>*</span></label> <!--Titulo caja-->

            <div>
                <span class="izquierda"><!--input y etiqueta de input caja-->
                  <input id="campoDescripcion" name="campoDescription" value="" /><br>
                </span>
                
                <span class="error" id="errorDescripcion"></span> <!--Espacio para indicar el error de esta caja-->

                <div class="clear"></div> <!--Para limpiar el float-->
            </div>

         

        </div>
        <!-- Fin de 2 Caja:Descripcion -->

        <!-- 3 Caja:Capacity-->
        <div class="caja">

              <label class="titulo" >Capacity<span class="requerido" required>*</span></label> <!--Titulo caja-->

              <div>
                  <span class="izquierda" >  <!--input y etiqueta de input caja-->
                    <input id="campoCapacity" name="campoCapacity" value="" /><br>
                  </span>

                  <span class="error" id="errorCapacity"></span> <!--Espacio para indicar el error de esta caja-->

                  <div class="clear"></div> <!--Para limpiar el float-->
              </div>

        </div>
        <!-- Fin de 3 Caja:Capacity-->

        <!-- 4 Caja:Start-->
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
        <!-- Fin de 4 Caja:Start-->

        <!-- 5 Caja:End-->
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
        <!-- Fin de 5 Caja:End-->

  

        <!-- 6 Caja:Image-->
        <div class="caja">

              <label class="titulo">Image<span class="requerido" required>*</span></label> <!--Titulo caja-->

              <div>
                  <span class="izquierda">  <!--input y etiqueta de input caja-->
                    <input id="campoImage" name="campoImage" value="" /><br>
                  </span>

                  <span class="error" id="errorImage"></span> <!--Espacio para indicar el error de esta caja-->

                  <div class="clear"></div> <!--Para limpiar el float-->
              </div>

      

        </div>
        <!-- Fin de 5 Caja:Image-->
		
		

        <!-- Boton de enviar-->
        <div class="botones">
                <input id="alta" type="submit" value="Validate &rarr;"/>
        </div>
        <!-- Fin de Boton de enviar-->

        </form>

</div>
</div><!-- Fin de  Contenedor -->
</body>
</html>