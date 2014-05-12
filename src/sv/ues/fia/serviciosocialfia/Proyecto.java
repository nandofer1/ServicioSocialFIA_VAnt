package sv.ues.fia.serviciosocialfia;

public class Proyecto {

	private String idProyecto;
	private String idBeneficiario;
	private String carnetEmpleado;
	private String idExpediente;
	private String idTipoProyecto;
	private String nombre;
	private String descripcion;
	private float duracion;
	private String fechaInicio;
	private String fechaFin;
	private String estado;
	private String valor;
	
	//Constructores
	public Proyecto(){
		
	}
	
	public Proyecto(String idProyecto, String idBeneficiario,
			String carnetEmpleado, String idExpediente, String idTipoProyecto,
			String nombre, String descripcion, float duracion,
			String fechaInicio, String fechaFin, String estado, String valor) {
		super();
		this.idProyecto = idProyecto;
		this.idBeneficiario = idBeneficiario;
		this.carnetEmpleado = carnetEmpleado;
		this.idExpediente = idExpediente;
		this.idTipoProyecto = idTipoProyecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.valor = valor;
	}
	//FIN de constructores


	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getIdBeneficiario() {
		return idBeneficiario;
	}

	public void setIdBeneficiario(String idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}

	public String getCarnetEmpleado() {
		return carnetEmpleado;
	}

	public void setCarnetEmpleado(String carnetEmpleado) {
		this.carnetEmpleado = carnetEmpleado;
	}

	public String getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(String idExpediente) {
		this.idExpediente = idExpediente;
	}

	public String getIdTipoProyecto() {
		return idTipoProyecto;
	}

	public void setIdTipoProyecto(String idTipoProyecto) {
		this.idTipoProyecto = idTipoProyecto;
	}
	
}
