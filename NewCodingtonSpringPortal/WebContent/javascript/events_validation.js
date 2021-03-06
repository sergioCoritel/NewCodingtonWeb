
var ie = (document.all);// variable que usaremos para ver si el navegador es internet explorer.

function validate_event(formulario){//funcion que comprueba todos los aspectos requeridos en el ejercicio y se ejecuta al pulsar el botón.	
	limpiar();
	var oblig=true;
	var array = null;
	if(ie){//Si el navegador es internet explorer,declaramos este array.
		array=[formulario.name,formulario.description,
		      formulario.eventType,formulario.ticketPrice,formulario.seatsAvailable];

	}else{//Si es otro navegador, declaramos el siguiente array

		array=new Array(name,description,
				eventType,ticketPrice,seatsAvailable);
	}
	for (var i = 0;i<array.length; i++) {//Comprueba si algún campo obligatorio está vacío.
		aux=EstaVacio(array[i]);
		if(aux==false){//Si algún campo obligatorio está vacío.
			oblig=false;
		}
	}
	if(oblig){//Si no hay campos obligatorios vacíos
		var comp=new Array();
		comp[0]=validarSeats(formulario.seatsAvailable.value);//Llamo a la función que comprueba el número.
		comp[1]=validarName(formulario.name.value);//Llamo a la función que comprueba Username.
		
		comp[2]=validarDescription(formulario.description.value);//Llamo a la función que comprueba el Mail.
		comp[3]=validarEventType(formulario.eventType.value);//Llamo a la función que comprueba la contraseña.
		comp[4]=validarticketPrice(formulario.ticketPrice.value);
	
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
		/*var elemento = document.getElementById("error");
		elemento.innerHTML ="Enter required fields marked *.";*/
		return false;
	}
}

function limpiar(){
	if (ie) {//Al no ser "getElementsByClassName" compatible con Explorer, se utiliza su equivalente, que nos selecciona todos los elementos con clase "error".
		var elementos = document.querySelectorAll(".error");
	}else{//El resto de navegadores si soportan la función "getElementsByClassName".
		var elementos = document.getElementsByClassName("error");//guarda en "elementos" un array con todos los elementos del html que tengan clase "error".
	};

	var i;
	for(i=0;i<elementos.length;i++){//Sustituye el contenido de los elementos con clase "error" por una cadena vacía, haciendo que las frases que anunciaban el error desaparezcan.
		elementos[i].innerHTML ="";

	}
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
	if (valor.length > 5 && valor.length <120){
		return true;

	}
	else{//Si no cumple la longitud requerida
		var elemento = document.getElementById("errorName");
		elemento.innerHTML ="* The name must be less than 120 characters and more than 5";
		return (false);
	}
} 

function validarDescription(valor) {
	if (valor.length > 10 && valor.length <250){
		return true;

	}
	else{//Si no cumple la longitud requerida
		var elemento = document.getElementById("errorDescription");
		elemento.innerHTML ="* The description must be less than 250 characters and more than 10";
		return (false);
	}
} 

function validarType(valor) {
	if (valor.length > 5 && valor.length <50){
		return true;

	}
	else{//Si no cumple la longitud requerida
		var elemento = document.getElementById("errorType");
		elemento.innerHTML ="* The type must be less than 50 characters and more than 5";
		return (false);
	}
}



function validarPrice(valor) {
	var expresionRegular=/\d{1,3}[\.]$\d{2}/;
	if (expresionRegular.test(valor)){// Comprueba que tenga entre 1 y 3 digitos.
		return (true);
	}
	else{//Si no cumple la expresión regular, aparece el mensaje de error.
		var elemento = document.getElementById("errorPrice");
		elemento.innerHTML ="* Wrong price: X.XX / X.XX / XXX.XX";
		return (false);
	}

}

function validarSeats(valor) {
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



function validarStartEnd(valor) {
	var expresionRegular= /\d{4}\/\d{2}\/\d{2}\s\d{2}:\d{2}$/;
	if (expresionRegular.test(valor)){
		return (true);
	}
	else{
		var elemento = document.getElementById("errorStartEnd");
		elemento.innerHTML ="* Wrong: 2014/05/31 23:05";
		return (false);
	}
} 


