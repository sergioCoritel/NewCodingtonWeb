
var ie = (document.all);// variable que usaremos para ver si el navegador es internet explorer.

function validate_place(formulario){//funcion que comprueba todos los aspectos requeridos en el ejercicio y se ejecuta al pulsar el botón.	

	var oblig=true;
	var array = null;
	if(ie){//Si el navegador es internet explorer,declaramos este array.
		array=[formulario.placeName,formulario.placeDescripcion,
		       formulario.capacity];

	}else{//Si es otro navegador, declaramos el siguiente array

		array=new Array(placeName,placeDescripcion,capacity);
	}
	for (var i = 0;i<array.length; i++) {//Comprueba si algún campo obligatorio está vacío.
		aux=EstaVacio(array[i]);
		if(aux==false){//Si algún campo obligatorio está vacío.
			oblig=false;
		}
	}
	if(oblig){//Si no hay campos obligatorios vacíos
		var comp=new Array();
		comp[0]=validarDescripcion(formulario.placeDescripcion.value);//Llamo a la función que comprueba el número.
		comp[1]=validarName(formulario.placeName.value);//Llamo a la función que comprueba Username.
		comp[2]=validarCapacity(formulario.capacity.value);//Llamo a la función que comprueba el DNI.	
		//el formulario se envia si se valida todo bien
		var j=0;
		for (var i=0;i<comp.length;i++){
			if(comp[i]==false){ j=j+1;}
		}		
		if (j>0) {// Si algun campo es incorrecto.
			return false;
		}else{//Si todos los campos son correctos, llamamos a la función resumen.*/		
			return true;
		}

	}else{//Si algún campo obligatorio está vacío, aparece la frase de error que indica la obligación de rellenar todos los campos.
		var elemento = document.getElementById("error");
		elemento.innerHTML ="Enter required fields marked *.";
		return false;
	}
}

function limpiar(){
	alert ("limpiar");
	if (ie) {//Al no ser "getElementsByClassName" compatible con Explorer, se utiliza su equivalente, que nos selecciona todos los elementos con clase "error".
		var elementos = document.querySelectorAll(".error");
	}else{//El resto de navegadores si soportan la función "getElementsByClassName".
		var elementos = document.getElementsByClassName("error");//guarda en "elementos" un array con todos los elementos del html que tengan clase "error".
	};

	var i;
	for(i=0;i<elementos.length;i++){//Sustituye el contenido de los elementos con clase "error" por una cadena vacía, haciendo que las frases que anunciaban el error desaparezcan.
		elementos[i].innerHTML ="";

	}
	document.getElementById("error").innerHTML="";//Hace lo mismo que el bucle anterior pero con el elemento de id="error".
	var inputs=document.getElementsByTagName("input");//El color del borde del recuadro de los diferentes inputs se pone en gris.
	for(i=0;i<inputs.length;i++){
		inputs[i].style.borderColor="#808080";
	}

}
function EstaVacio(campo){//Comprueba si el campo esta vacio y el borde se ponga rojo en los casos que no se ha rellenado correctamente.
	if(campo.value==""){
		campo.style.borderColor="red"; 		
		return false;
	}else{
		return true;
	}

}


function validarName(valor) {
	if (valor.length > 5 && valor.length <50){
		return true;

	}
	else{//Si no cumple la longitud requerida
		var elemento = document.getElementById("errorName");
		elemento.innerHTML ="* The name must be less than 50 characters and more than 5";
		return (false);
	}
} 

function validarDescription(valor) {
	if (valor.length > 10 && valor.length <250){
		return true;

	}
	else{//Si no cumple la longitud requerida
		var elemento = document.getElementById("errorDescripcion");
		elemento.innerHTML ="* The description must be less than 250 characters and more than 10";
		return (false);
	}
} 





function validarCapacity(valor) {
	//var expresionRegular=/\d{1,3}[\.]$\d{2}/;
	/*if (expresionRegular.test(valor)){// Comprueba que tenga entre 1 y 3 digitos.
		return (true);
	}*/

	var exp = /\d+/;
	if(exp){
		var elemento = document.getElementById("errorSeats");
		elemento.innerHTML ="* Wrong: select a number of seat";
		return (false);
	}
	else {
		return true;
	}

}



