
//Evento Ready de JQuery, que sobrecarga todos los eventos onClick de interes. 
 $(document).ready(function(){
	

	
	$("#F1BtnSend").on("click",function() {
	 	Ejemplo1();
	});
	
})




//La diferencia con el ejemplo anterior 3, es que la petición es por GET y se obtiene en JSON la respuesta de un objeto más complejo (serializado desde el back-end)
function Ejemplo1(){
 
 //Se recogen los datos del formulario.
 var data_organizacion = $('#F1organizacion').val();
 var data_cif = $('#F1cif').val();
 var data_antiguedad = $('#F1antiguedad').val();

 //Se recoge los datos del token de seguridad de Java Spring Security. (Ver línea 12 y 13 de home.jsp)
 let token = $("meta[name='_csrf']").attr("content");
 let header = $("meta[name='_csrf_header']").attr("content");
		
 //Se reinicia la capa donde se cargará la respuesta. El método html de jquery permite cargar html de forma dinámica en un contenedor.
 $('#CapaEjemplo1').html('');

 //Se invoca a la función ajax de jquery.
	$.ajax({
		url     : './ejemplo1',
		dataType:"json",
        method  : 'POST',
        data    : {organizacion:data_organizacion, cif:data_cif, antiguedad:data_antiguedad},
		//Se añade a la cabecera http. Prueba a quitar esta línea y veras que se genera error ¡¡
	    beforeSend: request => request.setRequestHeader(header, token),
	    success : function(data){
					var error=data.error;
                    var mensaje = data.msgMensaje;
                 
                    if(error){
        		         $('#CapaEjemplo1').html('<p style="color: red;">Error. ' + mensaje + '</p>');
                    }else{
                         $('#CapaEjemplo1').html('<p>Los datos recibidos son:<br>'+
                         							 '<b>Empresa</b>: ' + data.nomEmpresa + '<br>'+
                         							 '<b>Cif</b>: ' + data.cif+ '<br>' +
                         							 '<b>Antiguedad</b>: ' + data.antiguedad + '<br>' +
                         '</p>');
                    }
                  },
        error   : function(){ //function(jqXHR, exception){
                    $('#CapaEjemplo1').html('<p>Ha ocurrido un error fatal.</p>');
                  }
    });
}

