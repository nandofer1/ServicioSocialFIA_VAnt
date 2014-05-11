package sv.ues.fia.serviciosocialfia;

public class Carreras {

	private int codCarrera;
	private String nombre;
	
	//Constructores
	public Carreras(){
		
	}

	public Carreras(int codCarrera, String nombre) {
		this.codCarrera = codCarrera;
		this.nombre = nombre;
	}
	//FIN de constructores

	public int getCodCarrera() {
		return codCarrera;
	}

	public void setCodCarrera(int codCarrera) {
		this.codCarrera = codCarrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
