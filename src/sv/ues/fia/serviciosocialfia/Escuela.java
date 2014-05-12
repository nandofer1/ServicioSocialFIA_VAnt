package sv.ues.fia.serviciosocialfia;

public class Escuela {

	private String codEscuela;
	private String carnetEmpleado;
	private String nombre;
	
	//Constructores
	public Escuela(){
		
	}

	public Escuela(String codEscuela, String carnetEmpleado, String nombre) {
		super();
		this.codEscuela = codEscuela;
		this.carnetEmpleado = carnetEmpleado;
		this.nombre = nombre;
	}
	//FIN de constructores

	public String getCodEscuela() {
		return codEscuela;
	}

	public void setCodEscuela(String codEscuela) {
		this.codEscuela = codEscuela;
	}

	public String getCarnetEmpleado() {
		return carnetEmpleado;
	}

	public void setCarnetEmpleado(String carnetEmpleado) {
		this.carnetEmpleado = carnetEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
