package beans;

public class BeanTipoUsuario {
	
	private int idTipoUsuario;
	private String nombre;
	private String descripcion;
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
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
	public BeanTipoUsuario(int idTipoUsuario, String nombre, String descripcion) {
		super();
		this.idTipoUsuario = idTipoUsuario;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public BeanTipoUsuario() {
		// TODO Auto-generated constructor stub
	}

}
