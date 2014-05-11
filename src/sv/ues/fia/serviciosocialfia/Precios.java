package sv.ues.fia.serviciosocialfia;

public class Precios {

	private String Correlativo;
	private float precio;
	private String fechaInicialApliPre;
	private String fechaFinalApliPre;
	private String  observacion;
	
	//Constructores
	public Precios(){
		
	}

	public Precios(String correlativo, float precio,
			String fechaInicialApliPre, String fechaFinalApliPre,
			String observacion) {
		Correlativo = correlativo;
		this.precio = precio;
		this.fechaInicialApliPre = fechaInicialApliPre;
		this.fechaFinalApliPre = fechaFinalApliPre;
		this.observacion = observacion;
	}
	//FIN de constructores

	public String getCorrelativo() {
		return Correlativo;
	}

	public void setCorrelativo(String correlativo) {
		Correlativo = correlativo;
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
