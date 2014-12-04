<jsp:directive.include file="imports_header.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
 <title>Update form</title>
	  <link rel="icon" type="image/ico" href="favicon.ico"/>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="css/estilos_form.css"> <!--Enlazo la hoja de estilos externa-->
      <script type="text/javascript" src="javascript/comprobar_password.js"></script><!--Enlazo el script externo-->
</head>
<body>
<div id="wrapper">
  <div id="logo">
        <img src="images/logo.png" class="logo-icon">
  </div>

<!-- Contenedor -->
<div id="contenedor">

        <h2>UPDATE FORM</h2>


        <form method="post"  action="update_pass_user.htm?id=${sessionScope.user.userId}"  name="formulario" onsubmit="return valida_pass(this);">


       <!-- Espacio para marcar error de campos obligatorios-->
        <p id="error"> </p>

       
        <!-- 8 Caja:Contraseñas-->
        <div class="caja" >
              <label class="titulo" >Password <span class="requerido" required>*</span></label> <!--Titulo caja-->

              <div>

                  <span class="izquierda"> <!--input y etiqueta de input caja-->
                    <input id="campoPassword" name="campoPassword" type="password" value="" /><br>
                    <label>New Password</label>
                  </span>

                  <span class="derecha">  <!--input y etiqueta de input caja-->
                    <input id="campoComprobarPassword" name="campoComprobarPassword" type="password" value="" /><br>
                    <label >Repeat New Password</label>
                  </span>

                  <span class="error" id="errorPassword"></span> <!--Espacio para indicar el error de esta caja-->

                  <div class="clear"></div> <!--Para limpiar el float-->
              </div>

        </div>
        <!-- 8 Caja:Contraseñas-->

        <!-- Boton de enviar-->
        <div class="botones">
                <input id="update_pass" type="submit" value="Update &rarr;"/>
        </div>
        <!-- Fin de Boton de enviar-->

        </form>

</div>
</div><!-- Fin de  Contenedor -->

</body>
</html>