var ie = (document.all);
function valida_pass(formulario){
	limpiar();//llama a la funci�n limpiar
	var oblig=true;
	if(oblig){
		if(validarPassword(formulario.campoPassword.value, formulario.campoComprobarPassword.value)==true)
		{
			formulario.submit();
			return true;
		}
		else{
			return false;
		}
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

function validarPassword(pass1,pass2) {
	var expresionRegular=/\d{6,10}$/;
	if (expresionRegular.test(pass1)){// Comprueba que tenga entre 6 y 10 dígitos.
		if(pass1!=pass2){//Si no son iguales, sale el mensaje de error indicando que son diferentes.
			var elemento = document.getElementById("errorPassword");
			elemento.innerHTML ="*Passwords are different.";
			return (false);
		}else{
			return (true);
		}

	}
	else{//Si no cumple la longitud requerida
		var elemento = document.getElementById("errorPassword");
		elemento.innerHTML ="*The password must be between 6 and 10 characters.";
		return (false);
	}
}	