package sv.ues.fia.serviciosocialfia;

public class Bitacora {

	private String idBitacora;
	private String idExpediente;
	private String idProyecto;
	private String codigoTutor;
	private int cantidadHoras;
	private String fechaActividad;
	private String estadoActividad;
	private String fechaAutorizado;
	private String horaInicio;
	private String horaFin;
	private float valorActividad;
	private float precioTrabajo;
	
	//Constructores
	public Bitacora(){
		
	}
	
	public Bitacora(String idBitacora, String idExpediente, String idProyecto,
			String codigoTutor, int cantidadHoras, String fechaActividad,
			String estadoActividad, String fechaAutorizado, String horaInicio,
			String horaFin, float valorActividad, float precioTrabajo) {
		super();
		this.idBitacora = idBitacora;
		this.idExpediente = idExpediente;
		this.idProyecto = idProyecto;
		this.codigoTutor = codigoTutor;
		this.cantidadHoras = cantidadHoras;
		this.fechaActividad = fechaActividad;
		this.estadoActividad = estadoActividad;
		this.fechaAutorizado = fechaAutorizado;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.valorActividad = valorActividad;
		this.precioTrabajo = precioTrabajo;
	}
	//FIN de constructores

	public String getIdBitacora() {
		return idBitacora;
	}

	public void setIdBitacora(String idBitacora) {
		this.idBitacora = idBitacora;
	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public String getFechaActividad() {
		return fechaActividad;
	}

	public void setFechaActividad(String fechaActividad) {
		this.fechaActividad = fechaActividad;
	}

	public String getEstadoActividad() {
		return estadoActividad;
	}

	public void setEstadoActividad(String estadoActividad) {
		this.estadoActividad = estadoActividad;
	}

	public String getFechaAutorizado() {
		return fechaAutorizado;
	}

	public void setFechaAutorizado(String fechaAutorizado) {
		this.fechaAutorizado = fechaAutorizado;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public float getValorActividad() {
		return valorActividad;
	}

	public void setValorActividad(float valorActividad) {
		this.valorActividad = valorActividad;
	}

	public float getPrecioTrabajo() {
		return precioTrabajo;
	}

	public void setPrecioTrabajo(float precioTrabajo) {
		this.precioTrabajo = precioTrabajo;
	}

	public String getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(String idExpediente) {
		this.idExpediente = idExpediente;
	}

	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getCodigoTutor() {
		return codigoTutor;
	}

	public void setCodigoTutor(String codigoTutor) {
		this.codigoTutor = codigoTutor;
	}
	
	
}
