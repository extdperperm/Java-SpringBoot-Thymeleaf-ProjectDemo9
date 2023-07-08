package es.dsw.models;


public class Resultado {

	private String MsgMensaje;
	private boolean Error;
	
	public boolean isError() {
		return Error;
	}
	public void setError(boolean error) {
		Error = error;
	}

	private String Cif;
	private String NomEmpresa;
	private int Antiguedad;
	

	public Resultado() {
		this.Error = false;
		this.MsgMensaje = "";
		this.Cif = "";
		this.NomEmpresa = "";
		this.Antiguedad = -1;
	}
	public String getCif() {
		return Cif;
	}
	public String getNomEmpresa() {
		return NomEmpresa;
	}
	public int getAntiguedad() {
		return Antiguedad;
	}
	public void setCif(String cif) {
		Cif = cif;
	}
	public void setNomEmpresa(String nomEmpresa) {
		NomEmpresa = nomEmpresa;
	}
	public void setAntiguedad(int antiguedad) {
		Antiguedad = antiguedad;
	}
	public String getMsgMensaje() {
		return MsgMensaje;
	}

	public void setMsgMensaje(String _MsgMensaje) {
		MsgMensaje = _MsgMensaje;
	}
	
	
}
