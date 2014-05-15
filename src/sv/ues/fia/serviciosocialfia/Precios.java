package sv.ues.fia.serviciosocialfia;

public class Precios {

	private String correlativo;
	private String idBitacora;
	private String idTipoDeTrabajo;
	private float precio;
	private String fechaInicialApliPre;
	private String fechaFinalApliPre;
	private String  observacion;
	
	//Constructores
	public Precios(){
		
	}

	public Precios(String correlativo, String idBitacora,
			String idTipoDeTrabajo, float precio, String fechaInicialApliPre,
			String fechaFinalApliPre, String observacion) {
		super();
		this.correlativo = correlativo;
		this.idBitacora = idBitacora;
		this.idTipoDeTrabajo = idTipoDeTrabajo;
		this.precio = precio;
		this.fechaInicialApliPre = fechaInicialApliPre;
		this.fechaFinalApliPre = fechaFinalApliPre;
		this.observacion = observacion;
	}
	//FIN de constructores

	public String getCorrelativo() {
		return correlativo;
	}

	public void setCorrelativo(String correlativo) {
		this.correlativo = correlativo;
	}

	public String getIdBitacora() {
		return idBitacora;
	}

	public void setIdBitacora(String idBitacora) {
		this.idBitacora = idBitacora;
	}

	public String getIdTipoDeTrabajo() {
		return idTipoDeTrabajo;
	}

	public void setIdTipoDeTrabajo(String idTipoDeTrabajo) {
		this.idTipoDeTrabajo = idTipoDeTrabajo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getFechaInicialApliPre() {
		return fechaInicialApliPre;
	}

	public void setFechaInicialApliPre(String fechaInicialApliPre) {
		this.fechaInicialApliPre = fechaInicialApliPre;
	}

	public String getFechaFinalApliPre() {
		return fechaFinalApliPre;
	}

	public void setFechaFinalApliPre(String fechaFinalApliPre) {
		this.fechaFinalApliPre = fechaFinalApliPre;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
}
