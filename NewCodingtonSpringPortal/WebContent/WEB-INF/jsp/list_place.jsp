<jsp:directive.include file="imports_header.jsp" />
<!DOCTYPE HTML>
<html lang="es-ES">
<head>
      <title>New Codington Portal</title>
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
       <a class="button" href="handle_place.htm">Add place</a>
        <ul class="place">
           
           <h2>Large business</h2>
           <c:forEach items="${business}" var="place">            
            
            <li>
              <a href="show_place.htm?id=${place.id}&type_place=1"> <div class="place-image"> <img src="images/place_museum.jpg"></div></a>
              <div class="place-body">
              <a class="place-title" href="show_place.htm?id=${place.id}&type_place=1">${place.name}</a><br>
              <a class="place-description" href="show_place.htm?id=${place.id}&type_place=1">${place.placeDescription} </a> 
              </div>
		        </li>         
          </c:forEach>   
          
          
          <h2>Museums</h2>
          <c:forEach items="${museum}" var="place">            
            
            <li>
              <a href="show_place.htm?id=${place.id}&type_place=2"> <div class="place-image"> <img src="images/place_museum.jpg"></div></a>
              <div class="place-body">
              <a class="place-title" href="show_place.htm?id=${place.id}&type_place=2">${place.name}</a><br>
              <a class="place-description" href="show_place.htm?id=${place.id}&type_place=2">${place.placeDescription} </a> 
              </div>
		        </li>         
          </c:forEach>  
          
          <h2>Stadiums</h2>
           <c:forEach items="${stadium}" var="place">            
            
            <li>
              <a href="show_place.htm?id=${place.id}&type_place=3"> <div class="place-image"> <img src="images/place_museum.jpg"></div></a>
              <div class="place-body">
              <a class="place-title" href="show_place.htm?id=${place.id}&type_place=3">${place.name}</a><br>
              <a class="place-description" href="show_place.htm?id=${place.id}&type_place=3">${place.placeDescription} </a> 
              </div>
		        </li>         
          </c:forEach>  
          
          
          <h2>Theaters</h2>
         <c:forEach items="${theater}" var="place">            
            
            <li>
              <a href="show_place.htm?id=${place.id}&type_place=4"> <div class="place-image"> <img src="images/place_museum.jpg"></div></a>
              <div class="place-body">
              <a class="place-title" href="show_place.htm?id=${place.id}&type_place=4">${place.name}</a><br>
              <a class="place-description" href="show_place.htm?id=${place.id}&type_place=4">${place.placeDescription} </a> 
              </div>
		        </li>         
          </c:forEach>  
          
          <h2>Parks</h2>
        <c:forEach items="${park}" var="place">            
            
            <li>
              <a href="show_place.htm?id=${place.id}&type_place=5"> <div class="place-image"> <img src="images/place_museum.jpg"></div></a>
              <div class="place-body">
              <a class="place-title" href="show_place.htm?id=${place.id}&type_place=5">${place.name}</a><br>
              <a class="place-description" href="show_place.htm?id=${place.id}&type_place=5">${place.placeDescription} </a> 
              </div>
		        </li>         
          </c:forEach>  
          
          <h2>Tourist Attraction</h2>
          <c:forEach items="${tourist}" var="place">            
            
            <li>
              <a href="show_place.htm?id=${place.id}&type_place=6"> <div class="place-image"> <img src="images/place_museum.jpg"></div></a>
              <div class="place-body">
              <a class="place-title" href="show_place.htm?id=${place.id}&type_place=6">${place.name}</a><br>
              <a class="place-description" href="show_place.htm?id=${place.id}&type_place=6">${place.placeDescription} </a> 
              </div>
		        </li>         
          </c:forEach>  
          
          <h2>Traditional Market</h2>
           <c:forEach items="${market}" var="place">            
            
            <li>
              <a href="show_place.htm?id=${place.id}&type_place=7"> <div class="place-image"> <img src="images/place_museum.jpg"></div></a>
              <div class="place-body">
              <a class="place-title" href="show_place.htm?id=${place.id}&type_place=7">${place.name}</a><br>
              <a class="place-description" href="show_place.htm?id=${place.id}&type_place=7">${place.placeDescription} </a> 
              </div>
		        </li>         
          </c:forEach>  
          
          <h2>Zoos</h2>
          <c:forEach items="${zoo}" var="place">            
            
            <li>
              <a href="show_place.htm?id=${place.id}&type_place=8"> <div class="place-image"> <img src="images/place_museum.jpg"></div></a>
              <div class="place-body">
              <a class="place-title" href="show_place.htm?id=${place.id}&type_place=8">${place.name}</a><br>
              <a class="place-description" href="show_place.htm?id=${place.id}&type_place=8">${place.placeDescription} </a> 
              </div>
		        </li>         
          </c:forEach>  
          
            
        </ul>     
   </div><!-- Fin de  Contenedor -->
        
</div>

</body>
</html>