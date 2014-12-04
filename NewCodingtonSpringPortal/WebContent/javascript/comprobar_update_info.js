var ie = (document.all);// variable que usaremos para ver si el navegador es internet explorer.

function valida_info(formulario){//funcion que comprueba todos los aspectos requeridos en el ejercicio y se ejecuta al pulsar el botón.
	limpiar();//llama a la funci�n limpiar
	var respuesta=true;
	var oblig=true;
	if(oblig){
		if(validarNumero(formulario.campoTelefono.value)==false)
			respuesta=false;
		if(validarDNI(formulario.campoDNI.value)==false)
			respuesta=false;
		if(validarMail(formulario.campoMail.value)==false)
			respuesta=false;
	}
	
	if(respuesta == true){
		formulario.submit();
		return true;
	}
	else{
		if(respuesta == false)
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

function validarNumero(valor) {
	if(valor!=""){
		var expresionRegular=/[0]{2}[0-9]{8,18}/;//El numero debe empezar por 6 o 9 y estar seguido de 8 digitos.
		if (expresionRegular.test(valor)){//Si el valor del campo cumple la expresión regular.
			return (true);
		}
		else{//Si no cumple la expresión regular, muestra la frase de error.
			var elemento = document.getElementById("errorTelefono");
			elemento.innerHTML ="* The Phone is incorrect.";
			return (false);
		}
	}else{return true;}
}

function validarMail(valor) {
	var expresionRegular= /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.([a-zA-Z]{2,4})+$/;//El nombre de ususario de la direccion de email puede constar de letras, numeros , puntos, guines y guiones bajos.Luego, un arroba, y el servidor viene determinado por la misma expresión que antes pero sin guiones bajos.El dominio puede tener de dos hasta 4 letras.Puede haber más de un dominio.
	if (expresionRegular.test(valor)){
		return (true);
	}
	else{//Si no cumple la expresión regular, aparece el mensaje de error.
		var elemento = document.getElementById("errorMail");
		elemento.innerHTML ="*Wrong Mail: example@example.com";
		return (false);
	}
} 

function validarDNI(valor) {
	var numero;
	var letra;
	var letras;
	var dni;
	var expresion_regular_dni;
	expresion_regular_dni = /\d{2}[\.]\d{3}[\.]\d{3}-[a-zA-Z]$/; 
	dni = valor.replace(".", "");
	dni = dni.replace(".", "");
	dni = dni.replace("-", "");
	if(expresion_regular_dni.test (valor) == true){
		numero = dni.substr(0,dni.length-1); //Extrae parte del string desde el caracter cero hasta el tamaño-1.
		letra = dni.substr(dni.length-1,1);//Extrae parte del string desde el penultimo caracter hasta el ultimo,es dcir, el ultimo que es la letra.
		numero = numero % 23; //Divide el numero entre 23 y sale la posicion del caracter de la letra dentro del conjuto de letras que hay.	letras='TRWAGMYFPDXBNJZSQVHLCKET';
		letras='TRWAGMYFPDXBNJZSQVHLCKET';
		letras=letras.substring(numero,numero+1); 
		if (letras!=letra) {
			var elemento = document.getElementById("errorDNI");
			elemento.innerHTML ="*DNI wrong , the letter of the DNI does not correspond.";
			return (false);
		}
	}else{//Si no cumple la expresión regular, sale el mensaje de error.
		var elemento = document.getElementById("errorDNI");
		elemento.innerHTML ="*DNI wrong , invalid format.";
		return false;
	}
	return true;
}