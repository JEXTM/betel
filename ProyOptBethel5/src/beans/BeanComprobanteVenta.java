package beans;

public class BeanComprobanteVenta {
	private int idComprobante;
	private String numComp;
	private String fechaEmision;
	private String tipoCompV;
	private int idVendedor;
	private int idCliente;
	public int getIdComprobante() {
		return idComprobante;
	}
	public void setIdComprobante(int idComprobante) {
		this.idComprobante = idComprobante;
	}
	public String getNumComp() {
		return numComp;
	}
	public void setNumComp(String numComp) {
		this.numComp = numComp;
	}
	public String getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public String getTipoCompV() {
		return tipoCompV;
	}
	public void setTipoCompV(String tipoCompV) {
		this.tipoCompV = tipoCompV;
	}
	public int getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public BeanComprobanteVenta(int idComprobante, String numComp,
			String fechaEmision, String tipoCompV, int idVendedor, int idCliente) {
		super();
		this.idComprobante = idComprobante;
		this.numComp = numComp;
		this.fechaEmision = fechaEmision;
		this.tipoCompV = tipoCompV;
		this.idVendedor = idVendedor;
		this.idCliente = idCliente;
	}
	public BeanComprobanteVenta() {
	}
}
