package factorias;

import interfaces.I_ComprobanteVenta;
import interfaces.I_Marca;
import interfaces.I_Producto;
import interfaces.I_TipoDocIdent;
import interfaces.I_TipoProducto;
import interfaces.I_TipoUsuario;
import interfaces.I_Usuario;

 
//import interfaces.I_Empleado;   

public abstract class DAOFactory {
	public static final int MYSQL=1;	
	public static final int ORACLE=2;
	public static final int SQLSERVER=3;
	
//	public abstract I_Empleado getEmpleadoDao();
	public abstract I_Usuario getUsuario();
	public abstract I_TipoDocIdent getDocIdent();
	public abstract I_TipoUsuario getTipoUsuario();
	public abstract I_Producto getProducto();
	public abstract I_TipoProducto getTipoProducto();
	public abstract I_Marca getMarca();
	public abstract I_ComprobanteVenta getComprobanteVenta();

	
	public static DAOFactory getDaoFactory(int factory){
		switch (factory) {
		case MYSQL:
			return new MySQLDaoFactory();
		default:
			return null;
		}		
	}
}
