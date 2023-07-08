package es.dsw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.dsw.models.Resultado;

@Controller
public class MainController {

	@GetMapping(value= {"/", "/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping(value= {"/loggin"})
	public String loggin() {
		return "loggin";
	}
	
	@GetMapping(value= {"/ayuda"})
	public String ayuda() {
		return "ayuda";
	}
	
	@PostMapping(value = "/ejemplo1", produces="application/json")
	@ResponseBody
	public Resultado ejemplo1(@RequestParam(name="organizacion", defaultValue = "") String empresa, @RequestParam(name="cif", defaultValue = "") String cif, @RequestParam(name="antiguedad", required=false, defaultValue = "-1") int antiguedad) {
				String RespuestaError = "";
				Resultado objResultado = new Resultado();
				
				if (empresa.equals("")) {
					RespuestaError = RespuestaError + "Organización, ";
				}
				
				if (cif.equals("")) {
					RespuestaError = RespuestaError + "Cif, ";
				}
				
				if (antiguedad < 0) {
					RespuestaError = RespuestaError + "Antiguedad, ";
				}
				
				if (!RespuestaError.equals("")) {
					objResultado.setError(true);
					RespuestaError = "Faltan campos por rellenar: " + RespuestaError+"end";
					RespuestaError = RespuestaError.replace(", end", "");
				}
				
				objResultado.setMsgMensaje(RespuestaError);
				objResultado.setAntiguedad(antiguedad);
				objResultado.setCif(cif);
				objResultado.setNomEmpresa(empresa);
				
				return objResultado;	    
	} 

}
