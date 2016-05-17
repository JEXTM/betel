package beans;

public class BeanUsuario {
		
	private int idUsuario;
	private String username;
	private String password;
	private String nombre;
	private String apePat;
	private String apeMat;
	private String direccion;
	private String correo;
	private String contacto;
	private int idTipoUsuario;
	private int idTipoDocIdent;
	private String docIdent;
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApePat() {
		return apePat;
	}
	public void setApePat(String apePat) {
		this.apePat = apePat;
	}
	public String getApeMat() {
		return apeMat;
	}
	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	public int getIdTipoDocIdent() {
		return idTipoDocIdent;
	}
	public void setIdTipoDocIdent(int idTipoDocIdent) {
		this.idTipoDocIdent = idTipoDocIdent;
	}
	public String getDocIdent() {
		return docIdent;
	}
	public void setDocIdent(String docIdent) {
		this.docIdent = docIdent;
	}
	public BeanUsuario(int idUsuario, String username, String password,
			String nombre, String apePat, String apeMat, String direccion,
			String correo, String contacto, int idTipoUsuario,
			int idTipoDocIdent, String docIdent) {
		super();
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apePat = apePat;
		this.apeMat = apeMat;
		this.direccion = direccion;
		this.correo = correo;
		this.contacto = contacto;
		this.idTipoUsuario = idTipoUsuario;
		this.idTipoDocIdent = idTipoDocIdent;
		this.docIdent = docIdent;
	}
	
	public BeanUsuario() {
		// TODO Auto-generated constructor stub
	}
}
