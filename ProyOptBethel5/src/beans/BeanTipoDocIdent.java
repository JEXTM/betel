package beans;

public class BeanTipoDocIdent {
	
	private int idTipoDocIdent;
	private String nombre;
	private String descripcion;
	public int getIdTipoDocIdent() {
		return idTipoDocIdent;
	}
	public void setIdTipoDocIdent(int idTipoDocIdent) {
		this.idTipoDocIdent = idTipoDocIdent;
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
	public BeanTipoDocIdent(int idTipoDocIdent, String nombre,
			String descripcion) {
		super();
		this.idTipoDocIdent = idTipoDocIdent;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public BeanTipoDocIdent() {
		// TODO Auto-generated constructor stub
	}

}
