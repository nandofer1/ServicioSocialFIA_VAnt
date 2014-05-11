package sv.ues.fia.serviciosocialfia;

public class Beneficiario {

	private String idBeneficiario;
	private String nombreOrganizacion;
	private String nombreRepresentante;
	private String apellidoRepresentante;
	private int telefBeneficiario;
	private String direccionBeneficiario;
	private String mail;
	
	//Constructores
	public Beneficiario(){
		
	}

	public Beneficiario(String idBeneficiario, String nombreOrganizacion,
			String nombreRepresentante, String apellidoRepresentante,
			int telefBeneficiario, String direccionBeneficiario, String mail) {
		this.idBeneficiario = idBeneficiario;
		this.nombreOrganizacion = nombreOrganizacion;
		this.nombreRepresentante = nombreRepresentante;
		this.apellidoRepresentante = apellidoRepresentante;
		this.telefBeneficiario = telefBeneficiario;
		this.direccionBeneficiario = direccionBeneficiario;
		this.mail = mail;
	}
	//FIN de Constructores

	public String getIdBeneficiario() {
		return idBeneficiario;
	}

	public void setIdBeneficiario(String idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}

	public String getNombreOrganizacion() {
		return nombreOrganizacion;
	}

	public void setNombreOrganizacion(String nombreOrganizacion) {
		this.nombreOrganizacion = nombreOrganizacion;
	}

	public String getNombreRepresentante() {
		return nombreRepresentante;
	}

	public void setNombreRepresentante(String nombreRepresentante) {
		this.nombreRepresentante = nombreRepresentante;
	}

	public String getApellidoRepresentante() {
		return apellidoRepresentante;
	}

	public void setApellidoRepresentante(String apellidoRepresentante) {
		this.apellidoRepresentante = apellidoRepresentante;
	}

	public int getTelefBeneficiario() {
		return telefBeneficiario;
	}

	public void setTelefBeneficiario(int telefBeneficiario) {
		this.telefBeneficiario = telefBeneficiario;
	}

	public String getDireccionBeneficiario() {
		return direccionBeneficiario;
	}

	public void setDireccionBeneficiario(String direccionBeneficiario) {
		this.direccionBeneficiario = direccionBeneficiario;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
