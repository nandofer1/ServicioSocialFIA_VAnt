package sv.ues.fia.serviciosocialfia;

public class Informe {

	private int codInforme;
	private String fechaEntrega;
	private String fechaAutorizacion;
	private String objetivoAlcanzado;
	private String comentarios;
	private String tipoInforme;
	private String estado;
	
	//Constructores
	public Informe(){
		
	}

	public Informe(int codInforme, String fechaEntrega,
			String fechaAutorizacion, String objetivoAlcanzado,
			String comentarios, String tipoInforme, String estado) {
		this.codInforme = codInforme;
		this.fechaEntrega = fechaEntrega;
		this.fechaAutorizacion = fechaAutorizacion;
		this.objetivoAlcanzado = objetivoAlcanzado;
		this.comentarios = comentarios;
		this.tipoInforme = tipoInforme;
		this.estado = estado;
	}
	//FIN de constructores

	public int getCodInforme() {
		return codInforme;
	}

	public void setCodInforme(int codInforme) {
		this.codInforme = codInforme;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getFechaAutorizacion() {
		return fechaAutorizacion;
	}

	public void setFechaAutorizacion(String fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}

	public String getObjetivoAlcanzado() {
		return objetivoAlcanzado;
	}

	public void setObjetivoAlcanzado(String objetivoAlcanzado) {
		this.objetivoAlcanzado = objetivoAlcanzado;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getTipoInforme() {
		return tipoInforme;
	}

	public void setTipoInforme(String tipoInforme) {
		this.tipoInforme = tipoInforme;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
