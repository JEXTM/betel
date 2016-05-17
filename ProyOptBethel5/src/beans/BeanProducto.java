package beans;

public class BeanProducto {
	private int idProducto;
	private String nomProd;
	private String descripcion;
	private double precio;
	private int stock;
	private String fotoProducto;
	private String sku;
	private int idMarca;
	private int idTipoProducto;
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNomProd() {
		return nomProd;
	}
	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getFotoProducto() {
		return fotoProducto;
	}
	public void setFotoProducto(String fotoProducto) {
		this.fotoProducto = fotoProducto;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public int getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	public int getIdTipoProducto() {
		return idTipoProducto;
	}
	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}
	
	public BeanProducto() {
		// TODO Auto-generated constructor stub
	}
	public BeanProducto(int idProducto, String nomProd, String descripcion,
			double precio, int stock, String fotoProducto, String sku,
			int idMarca, int idTipoProducto) {
		super();
		this.idProducto = idProducto;
		this.nomProd = nomProd;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.fotoProducto = fotoProducto;
		this.sku = sku;
		this.idMarca = idMarca;
		this.idTipoProducto = idTipoProducto;
	}
	
	
}
