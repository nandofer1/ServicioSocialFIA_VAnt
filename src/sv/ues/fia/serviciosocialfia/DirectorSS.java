package sv.ues.fia.serviciosocialfia;

public class DirectorSS {

	private String carnet;
	private String codEscuela;
	private String nombre;
	private String apellido;
	private String sexo;
	private String fechaInicio;
	private String fechaFin;
	
	//Constructores
	public DirectorSS(){
		
	}

	public DirectorSS(String carnet, String codEscuela, String nombre,
			String apellido, String sexo, String fechaInicio, String fechaFin) {
		super();
		this.carnet = carnet;
		this.codEscuela = codEscuela;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	//FIN de constructores

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

	public String getCodEscuela() {
		return codEscuela;
	}

	public void setCodEscuela(String codEscuela) {
		this.codEscuela = codEscuela;
	}
	

}
