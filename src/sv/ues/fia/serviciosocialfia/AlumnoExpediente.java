package sv.ues.fia.serviciosocialfia;

public class AlumnoExpediente {
	private String idExpediente;
	private String carnetEmpleado;
	private String carnet;
	private String nombre;
	private String apellido;
	private String sexo;
	private String fechaInicioServicio;
	private String fechaFinServicio;
	private String estado;
	private String telefono;
	private String email;
	private String observaciones;
	private float valorServicio;
	private int horasAcumula;
	private String fechaAcumula;
	private String idBitacora;
	private String codCarrera;
	
	//Constructores
	public AlumnoExpediente(){
			
	}
	
	public AlumnoExpediente(String idExpediente, String carnetEmpleado,
			String carnet, String nombre, String apellido, String sexo,
			String fechaInicioServicio, String fechaFinServicio, String estado,
			String telefono, String email, String observaciones,
			float valorServicio, int horasAcumula, String fechaAcumula,
			String idBitacora, String codCarrera) {
		super();
		this.idExpediente = idExpediente;
		this.carnetEmpleado = carnetEmpleado;
		this.carnet = carnet;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.fechaInicioServicio = fechaInicioServicio;
		this.fechaFinServicio = fechaFinServicio;
		this.estado = estado;
		this.telefono = telefono;
		this.email = email;
		this.observaciones = observaciones;
		this.valorServicio = valorServicio;
		this.horasAcumula = horasAcumula;
		this.fechaAcumula = fechaAcumula;
		this.idBitacora = idBitacora;
		this.codCarrera = codCarrera;
	}
	//FIN de constructores
	
	public String getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(String idExpediente) {
		this.idExpediente = idExpediente;
	}

	public String getCarnetEmpleado() {
		return carnetEmpleado;
	}

	public void setCarnetEmpleado(String carnetEmpleado) {
		this.carnetEmpleado = carnetEmpleado;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaInicioServicio() {
		return fechaInicioServicio;
	}

	public void setFechaInicioServicio(String fechaInicioServicio) {
		this.fechaInicioServicio = fechaInicioServicio;
	}

	public String getFechaFinServicio() {
		return fechaFinServicio;
	}

	public void setFechaFinServicio(String fechaFinServicio) {
		this.fechaFinServicio = fechaFinServicio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public float getValorServicio() {
		return valorServicio;
	}

	public void setValorServicio(float valorServicio) {
		this.valorServicio = valorServicio;
	}

	public int getHorasAcumula() {
		return horasAcumula;
	}

	public void setHorasAcumula(int horasAcumula) {
		this.horasAcumula = horasAcumula;
	}

	public String getFechaAcumula() {
		return fechaAcumula;
	}

	public void setFechaAcumula(String fechaAcumula) {
		this.fechaAcumula = fechaAcumula;
	}

	public String getIdBitacora() {
		return idBitacora;
	}

	public void setIdBitacora(String idBitacora) {
		this.idBitacora = idBitacora;
	}

	public String getCodCarrera() {
		return codCarrera;
	}

	public void setCodCarrera(String codCarrera) {
		this.codCarrera = codCarrera;
	}
	

}
