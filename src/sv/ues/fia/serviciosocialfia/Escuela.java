package sv.ues.fia.serviciosocialfia;

public class Escuela {

	private int codEscuela;
	private String nombre;
	
	//Constructores
	public Escuela(){
		
	}

	public Escuela(int codEscuela, String nombre) {
		this.codEscuela = codEscuela;
		this.nombre = nombre;
	}
	//FIN de constructores

	public int getCodEscuela() {
		return codEscuela;
	}

	public void setCodEscuela(int codEscuela) {
		this.codEscuela = codEscuela;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
