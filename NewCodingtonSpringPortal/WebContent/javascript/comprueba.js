
var ie = (document.all);// variable que usaremos para ver si el navegador es internet explorer.

function valida_envia(formulario){//funcion que comprueba todos los aspectos requeridos en el ejercicio y se ejecuta al pulsar el botón.
	//limpiar();//llama a la función limpiar
	var oblig=true;
	if(ie){//Si el navegador es internet explorer,declaramos este array.
		var array=[formulario.campoNombre,formulario.campoApellidos,
		           formulario.campoDNI,formulario.campoMail,formulario.campoUsername,formulario.campoPassword,formulario.campoComprobarPassword];

	}else{//Si es otro navegador, declaramos el siguiente array

		var array=new Array(campoNombre,campoApellidos,
				campoDNI,campoMail,campoUsername,campoPassword,campoComprobarPassword);
	}
	for (var i = 0;i<array.length; i++) {//Comprueba si algún campo obligatorio está vacío.
		aux=EstaVacio(array[i]);
		if(aux==false){//Si algún campo obligatorio está vacío.
			oblig=false;
		}
	}
	if(oblig==true){//Si no hay campos obligatorios vacíos
		var comp=new Array();
		comp[0]=validarNumero(formulario.campoTelefono.value);//Llamo a la función que comprueba el número.
		comp[1]=validarUsername(formulario.campoUsername.value);//Llamo a la función que comprueba Username.
		comp[1]=validarDNI(formulario.campoDNI.value);//Llamo a la función que comprueba el DNI.
		comp[2]=validarMail(formulario.campoMail.value);//Llamo a la función que comprueba el Mail.
		comp[4]=validarPassword(formulario.campoPassword.value,formulario.campoComprobarPassword.value);//Llamo a la función que comprueba la contraseña.
		//el formulario se envia si se valida todo bien
		j=0;
		for (var i=0;i<comp.length;i++){
			if(comp[i]==false){ var j=j+1;}
		}
		if (j>0) {// Si algún campo es incorrecto.
			resumen();
			return false;
		}else{//Si todos los campos son correctos, llamamos a la función resumen.

			return true;

		}

	}else{//Si algún campo obligatorio está vacío, aparece la frase de error que indica la obligación de rellenar todos los campos.
		var elemento = document.getElementById("error");
		elemento.innerHTML ="Enter required fields marked *.";
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


function validarUsername(valor) {
	if(Username!=""){
		var numero=parseInt(valor);//Pasa el valor de string a entero.
		if (numero<120 && numero>6){ //Si es menor que 120 y mayor que 6, comprobación exitosa.
			return (true);
		}
		else{
			var elemento = document.getElementById("errorUsername");//Si es mayor que 120 aparece frase de error.
			elemento.innerHTML ="* Nickname between 6 - 120 characteres.";
			return (false);
		}
	}else{return true;}
} 

function convertDni(dni){
	String dniNumeric = "";

	for(var i=0; i<=9; i++){
		if(dni.charAt(i) != '.'){
			dniNumeric += dni.charAt(i);
		}
	}
	return Integer.parseInt(dniNumeric);
}

function letterDNI(dni) {
	String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
	return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
}


function validarDNI(dni) {
	/*var numero
	var letra
	var letras
	var expresion_regular_dni

	expresion_regular_dni = /\d{8}[a-zA-Z]$/; //El valor introducido debe constar de ocho numeros y una letra.

	if(expresion_regular_dni.test (dni) == true){//Si se cumple la expresión regular, comprueba si la letra es correcta.
		numero = dni.substr(0,dni.length-1); //Extrae parte del string desde el caracter cero hasta el tamaño-1.
		letra = dni.substr(dni.length-1,1);//Extrae parte del string desde el penultimo caracter hasta el ultimo,es dcir, el ultimo que es la letra.
		numero = numero % 23; //Divide el numero entre 23 y sale la posicion del caracter de la letra dentro del conjuto de letras que hay.
		letras='TRWAGMYFPDXBNJZSQVHLCKET';
		letras=letras.substring(numero,numero+1); 
		if (letras!=letra) {
			var elemento = document.getElementById("errorDNI");
			elemento.innerHTML ="*DNI wrong , the letter of the NIF does not correspond.";
			return (false);
		}else{
			return true;
		}
	}else{//Si no cumple la expresión regular, sale el mensaje de error.
		var elemento = document.getElementById("errorDNI");
		elemento.innerHTML ="*DNI wrong , invalid format.";
		return false;
	}*/

	Pattern pattern;
	Matcher matcher = null;
	boolean checkDniCorrect = false;

	if (dni != null){
		pattern = Pattern.compile("\\d{2}.\\d{3}.\\d{3}-[[a-hA-H]||[j-nJ-N]||[p-tP-T]||[v-zV-Z]]");
		matcher = pattern.matcher(dni);

		if (matcher.matches()) {					//Structure DNI correct
			int numericDni = convertDni(dni);
			String letter = letterDNI(numericDni);
			if(letter.charAt(8) == Character.toUpperCase(dni.charAt(11)))		//Compara las letras de la conversion (mod23) con la del Dni introducido (la convertimos a mayusculas)
				true;
		}
		else{//Si no cumple la expresión regular, sale el mensaje de error.
			var elemento = document.getElementById("errorDNI");
			elemento.innerHTML ="*DNI wrong , invalid format: XX.XXX.XXX-L";
			return false;
		}
	}

	else{
		
		var elemento = document.getElementById("errorDNI");
		elemento.innerHTML ="*DNI wrong , invalid format: XX.XXX.XXX-L";
		return false;
	}
}






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
function cursor(caja){//Si tenemos el cursor sobre un apartado del formulario.
	document.getElementById(caja).style.visibility="visible";//La ayuda se hace visible
	document.getElementById(caja).style.position="fixed";
	document.getElementById(caja).style.left=event.clientX+"px";//La posición es fija respecto de las coordenadas X e Y del cursor.Las coordenadas son tomadas respecto de la ventana.
	document.getElementById(caja).style.top=(event.clientY)+"px";
}
function salida(caja){//Si el cursor sale de un apartado del formulario.
	document.getElementById(caja).style.visibility="hidden";//Oculta la ayuda correspondiente a ese apartado.
}
function resumen(){//Si las comprobaciones son correctas

	var w=window.open ("", "resultado",'width=300,height=400');//Se abre una ventana con determinada altura y anchura.

	w.document.open();
	var windowHTML =
		"<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>\n" +
		"<html>\n" +
		"<head> <link rel='stylesheet' type='text/css' href='estilos.css'></head>\n" +
		"<body>\n";
	w.document.write(windowHTML);//En dicha ventana escribimos los diferentes valores de los campos introducidos en el formulario.
	w.document.write("<h1>Form data.</h1>");
	w.document.write('First Name: '+formulario.campoNombre.value+'<br>');
	w.document.write('Last Name: '+formulario.campoApellidos.value+'<br>');
	w.document.write('DNI: '+formulario.campoDNI.value+'<br>');
	w.document.write('Address: '+formulario.campoDomicilio.value+'<br>');
	w.document.write('Phone Number: '+formulario.campoTelefono.value+'<br>');
	w.document.write('User Name: '+formulario.campoUsername.value+'<br>');
	w.document.write('Password: '+formulario.campoPassword.value+'<br>');
	w.document.write('Repeat Password: '+formulario.campoComprobarPassword.value+'<br>');
	w.document.write(
	"</body></html>");
	w.document.close();

}