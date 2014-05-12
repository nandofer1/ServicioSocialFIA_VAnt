package sv.ues.fia.serviciosocialfia;

public class Informe {

	private String codigoTutor;
	private String idExpediente;
	private int corrInforme;
	private String fechaEntrega;
	private String fechaAutorizacion;
	private String objetivoAlcanzado;
	private String comentarios;
	private String tipoInforme;
	private String estado;
	
	//Constructores
	public Informe(){
		
	}

	public Informe(String codigoTutor, String idExpediente, int corrInforme,
			String fechaEntrega, String fechaAutorizacion,
			String objetivoAlcanzado, String comentarios, String tipoInforme,
			String estado) {
		super();
		this.codigoTutor = codigoTutor;
		this.idExpediente = idExpediente;
		this.corrInforme = corrInforme;
		this.fechaEntrega = fechaEntrega;
		this.fechaAutorizacion = fechaAutorizacion;
		this.objetivoAlcanzado = objetivoAlcanzado;
		this.comentarios = comentarios;
		this.tipoInforme = tipoInforme;
		this.estado = estado;
	}
	//FIN de constructores

	public String getCodigoTutor() {
		return codigoTutor;
	}

	public void setCodigoTutor(String codigoTutor) {
		this.codigoTutor = codigoTutor;
	}

	public String getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(String idExpediente) {
		this.idExpediente = idExpediente;
	}

	public int getCorrInforme() {
		return corrInforme;
	}

	public void setCorrInforme(int corrInforme) {
		this.corrInforme = corrInforme;
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
