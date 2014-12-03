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
       <a class="button" href="handle_place.htm"><img class="ca-icon" alt="" src="images/add_list.png"> Add place</a>
        <ul>
           
           <h2>Large business</h2>
           <c:forEach items="${business}" var="place">            
            
            <li class="show">
              <a class="title" href="show_place.htm?id=${place.id}&type_place=1"><img class="ca-icon" src="images/bussiness.png">${place.name}-${place.placeDescription} </a> 
		    </li>         
          </c:forEach>   
          
          
          <h2>Museums</h2>
          <c:forEach items="${museum}" var="place">            
            
            <li class="show">
              <a class="title" href="show_place.htm?id=${place.id}&type_place=2"><img class="ca-icon" src="images/museum.png">${place.name}-${place.placeDescription} </a> 
		    </li>          
          </c:forEach>  
          
          <h2>Stadiums</h2>
           <c:forEach items="${stadium}" var="place">            
            
            <li class="show">
              <a class="title" href="show_place.htm?id=${place.id}&type_place=3"><img class="ca-icon" src="images/stadium.png">${place.name}-${place.placeDescription} </a> 
		    </li>          
          </c:forEach>  
          
          
          <h2>Theaters</h2>
         <c:forEach items="${theater}" var="place">            
         	 <li class="show">
              <a class="title" href="show_place.htm?id=${place.id}&type_place=4"><img class="ca-icon" src="images/theater.png">${place.name}-${place.placeDescription} </a> 
		    </li>    
                  
          </c:forEach>  
          
          <h2>Parks</h2>
        <c:forEach items="${park}" var="place">            
            <li class="show">
              <a class="title" href="show_place.htm?id=${place.id}&type_place=5"><img class="ca-icon" src="images/park.png">${place.name}-${place.placeDescription} </a> 
		    </li>  
                  
          </c:forEach>  
          
          <h2>Tourist Attraction</h2>
          <c:forEach items="${tourist}" var="place">            
            
            <li class="show">
              <a class="title" href="show_place.htm?id=${place.id}&type_place=6"><img class="ca-icon" src="images/tourist.png">${place.name}-${place.placeDescription} </a> 
		    </li>        
          </c:forEach>  
          
          <h2>Traditional Market</h2>
           <c:forEach items="${market}" var="place">            
            
             <li class="show">
              <a class="title" href="show_place.htm?id=${place.id}&type_place=7"><img class="ca-icon" src="images/market.png">${place.name}-${place.placeDescription} </a> 
		    </li>        
          </c:forEach>  
          
          <h2>Zoos</h2>
          <c:forEach items="${zoo}" var="place">            
            
            <li class="show">
              <a class="title" href="show_place.htm?id=${place.id}&type_place=8"><img class="ca-icon" src="images/zoo_.png">${place.name}-${place.placeDescription} </a> 
		    </li>         
          </c:forEach>  
          
            
        </ul>     
   </div><!-- Fin de  Contenedor -->
        
</div>

</body>
</html>