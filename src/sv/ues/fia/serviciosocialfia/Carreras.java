package sv.ues.fia.serviciosocialfia;

public class Carreras {

	private String codCarrera;
	private String codEscuela;
	private String nombre;
	
	//Constructores
	public Carreras(){
		
	}

	public Carreras(String codCarrera, String codEscuela, String nombre) {
		super();
		this.codCarrera = codCarrera;
		this.codEscuela = codEscuela;
		this.nombre = nombre;
	}
	//FIN de constructores
	
	public String getCodCarrera() {
		return codCarrera;
	}

	public void setCodCarrera(String codCarrera) {
		this.codCarrera = codCarrera;
	}

	public String getCodEscuela() {
		return codEscuela;
	}

	public void setCodEscuela(String codEscuela) {
		this.codEscuela = codEscuela;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	
	
}
