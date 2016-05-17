package beans;

public class BeantTipoProducto {
	
	private int idTipoProducto;
	private String nombre;
	private String descripcion;
	public int getIdTipoProducto() {
		return idTipoProducto;
	}
	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
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
	public BeantTipoProducto(int idTipoProducto, String nombre,
			String descripcion) {
		super();
		this.idTipoProducto = idTipoProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	 
	public BeantTipoProducto() {
		// TODO Auto-generated constructor stub
	}

}
