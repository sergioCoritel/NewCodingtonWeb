<jsp:directive.include file="imports_header.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
 <title>Update form</title>
	  <link rel="icon" type="image/ico" href="favicon.ico"/>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="css/estilos_form.css"> <!--Enlazo la hoja de estilos externa-->
      <script type="text/javascript" src="javascript/comprueba.js"></script><!--Enlazo el script externo-->
</head>
<body>
<div id="wrapper">
  <div id="logo">
        <img src="images/logo.png" class="logo-icon">
  </div>

<!-- Contenedor -->
<div id="contenedor">

        <h2>UPDATE FORM</h2>


        <form method="post"  action="update_info_user.htm?id=${sessionScope.user.userId}" name="formulario">


       <!-- Espacio para marcar error de campos obligatorios-->
        <p id="error"> </p>

        <!-- 1 Caja:nombre y apellidos -->
        <div class="caja">

                <label class="titulo">First and Last Name <span class="requerido" required>*</span></label> <!--Titulo caja-->

                <div>
                    <span class="izquierda">  <!--input y etiqueta de input caja-->
                      <input class="requerido"  id="campoNombre" name="campoNombre" value="${sessionScope.user.firstName}" required/><br>
                      <label>First Name</label>
                    </span>

                    <span class="derecha">  <!--input y etiqueta de input caja-->
                      <input id="campoApellidos" name="campoApellidos" value="${sessionScope.user.lastName}" /><br>
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
                  <input id="campoDNI" name="campoDNI" value="${sessionScope.user.dni}" /><br>
                </span>
                
                <span class="error" id="errorDNI"></span> <!--Espacio para indicar el error de esta caja-->

                <div class="clear"></div> <!--Para limpiar el float-->
            </div>

         

        </div>
        <!-- Fin de 2 Caja:DNI -->

        <!-- 4 Caja:Direccion-->
        <div class="caja">

              <label class="titulo" >Address</label> <!--Titulo caja-->

              <div>
                  <span class="izquierda" >  <!--input y etiqueta de input caja-->
                    <input id="campoDomicilio" name="campoDomicilio" value="${sessionScope.user.address}" /><br>
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
                       <input id="campoTelefono" name="campoTelefono" value="${sessionScope.user.phoneNumber}" /><br>
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
                    <input id="campoMail" name="campoMail" value="${sessionScope.user.email}" /><br>
                  </span>
                  <span class="error" id="errorMail"></span> <!--Espacio para indicar el error de esta caja-->
              </div>

      

        </div>
        <!-- Fin de 7 Caja:Mail-->
				      
        <!-- Boton de enviar-->
        <div class="botones">
                <input id="alta" type="submit" value="Update &rarr;"/>
        </div>
        <!-- Fin de Boton de enviar-->

        </form>

</div>
</div><!-- Fin de  Contenedor -->
</body>
</html>