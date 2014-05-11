package sv.ues.fia.serviciosocialfia;

public class Tutor {

	private String codigoTutor;
	private String nombre;
	private String apellido;
	private String sexo;
	
	//Constructores
	public Tutor(){
		
	}

	public Tutor(String codigoTutor, String nombre, String apellido, String sexo) {
		this.codigoTutor = codigoTutor;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
	}
	//FIN de constructores

	public String getCodigoTutor() {
		return codigoTutor;
	}

	public void setCodigoTutor(String codigoTutor) {
		this.codigoTutor = codigoTutor;
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
	

}
