<jsp:directive.include file="imports_header.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="es">
<head>
<title>Profile</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/estilos_event.css"> 
<!--Enlazo la hoja de estilos externa-->
<link rel="icon" type="image/ico" href="favicon.ico"/>
<script type="text/javascript" src="comprueba.js"></script>
<!--Enlazo el script externo-->
</head>

<body>
<div id="wrapper">
  
   <jsp:directive.include file="left_menu.htm" />
   <jsp:directive.include file="top_right_menu.htm" />  
   
   <!-- Contenedor -->
   <div id="contenedor">
       
	   <img src="images/profile.png" class="data-prof">
	   
	   <ul class="event">
	   
	        <li>  
			         <p class = "text-profile">User Name</p>
               <div class = "profile">${sessionScope.user.userName}
               </div>
          </li>
		   
          <li>
               <p class = "text-profile">First Name</p>
               <div class = "profile">${sessionScope.user.firstName}
               </div>
		      </li> 

          <li>  
               <p class = "text-profile">Last Name</p>
               <div class = "profile">${sessionScope.user.lastName}
               </div>
          </li>
		  
		   <li>  
			         <p class = "text-profile">DNI</p>
               <div class = "profile">${sessionScope.user.dni}
               </div>
          </li>

          <li>  
               <p class = "text-profile">Address</p>
               <div class = "profile">${sessionScope.user.address}
               </div>
          </li>

          <li>  
               <p class = "text-profile">Phone Number</p>
               <div class = "profile">${sessionScope.user.phoneNumber}
               </div>
          </li>

          <li>  
               <p class = "text-profile">Mail</p>
               <div class = "profile">${sessionScope.user.email}
               </div>
          </li>
			
      </ul>
      
      <div class="button"><a href="change_info.htm?id=${sessionScope.user.userId}">Edit profile</a></div>

	  <div class="button"><a href="change_pass.htm?id=${sessionScope.user.userId}">Change password</a></div>     
        
   </div>
   <!-- Fin de  Contenedor -->
        
</div>

</body>
</html>