package sv.ues.fia.serviciosocialfia;

public class TipoDeTrabajo {

	private String idBitacora;
	private String idTipoTrabajo;
	private String correlativo;
	private String nombreTipo;
	
	//Constructores
	public TipoDeTrabajo(){
		
	}
	
	public TipoDeTrabajo(String idBitacora, String idTipoTrabajo,
			String correlativo, String nombreTipo) {
		super();
		this.idBitacora = idBitacora;
		this.idTipoTrabajo = idTipoTrabajo;
		this.correlativo = correlativo;
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

	public String getIdBitacora() {
		return idBitacora;
	}

	public void setIdBitacora(String idBitacora) {
		this.idBitacora = idBitacora;
	}

	public String getCorrelativo() {
		return correlativo;
	}

	public void setCorrelativo(String correlativo) {
		this.correlativo = correlativo;
	}
	
	
}
