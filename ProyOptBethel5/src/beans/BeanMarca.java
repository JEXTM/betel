package beans;

public class BeanMarca {
	private int idMarca;
	private String nombre;
	private String descripcion;
	public int getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
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
	public BeanMarca(int idMarca, String nombre, String descripcion) {
		super();
		this.idMarca = idMarca;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public BeanMarca() {
		// TODO Auto-generated constructor stub
	}
}
