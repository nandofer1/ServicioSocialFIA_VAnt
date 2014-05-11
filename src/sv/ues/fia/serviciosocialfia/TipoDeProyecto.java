package sv.ues.fia.serviciosocialfia;

public class TipoDeProyecto {

	private String idTipoProyecto;
	private String modalidadProyecto;
	
	//Constructores
	public TipoDeProyecto(){
		
	}

	public TipoDeProyecto(String idTipoProyecto, String modalidadProyecto) {
		this.idTipoProyecto = idTipoProyecto;
		this.modalidadProyecto = modalidadProyecto;
	}
	//FIN de constructores


	public String getIdTipoProyecto() {
		return idTipoProyecto;
	}

	public void setIdTipoProyecto(String idTipoProyecto) {
		this.idTipoProyecto = idTipoProyecto;
	}

	public String getModalidadProyecto() {
		return modalidadProyecto;
	}

	public void setModalidadProyecto(String modalidadProyecto) {
		this.modalidadProyecto = modalidadProyecto;
	}
	
}
