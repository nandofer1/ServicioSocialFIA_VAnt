package sv.ues.fia.serviciosocialfia;

public class TipoDeTrabajo {

	private String idTipoTrabajo;
	private String nombreTipo;
	
	//Constructores
	public TipoDeTrabajo(){
		
	}

	public TipoDeTrabajo(String idTipoTrabajo, String nombreTipo) {
		this.idTipoTrabajo = idTipoTrabajo;
		this.nombreTipo = nombreTipo;
	}
	//FIN de los constructores

	public String getIdTipoTrabajo() {
		return idTipoTrabajo;
	}

	public void setIdTipoTrabajo(String idTipoTrabajo) {
		this.idTipoTrabajo = idTipoTrabajo;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	
	
}
