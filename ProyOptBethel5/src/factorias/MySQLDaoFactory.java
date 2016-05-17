package factorias;


//import interfaces.I_Empleado;    


import interfaces.I_ComprobanteVenta;
import interfaces.I_Marca;
import interfaces.I_Producto;
import interfaces.I_TipoDocIdent;
import interfaces.I_TipoProducto;
import interfaces.I_TipoUsuario;
import interfaces.I_Usuario;

import java.sql.Connection; 
import java.sql.DriverManager;

import daos.MySQLComprobanteVentaDAO;
import daos.MySQLMarcaDAO;
import daos.MySQLTipoDocIdent;
import daos.MySQLTipoProductoDAO;
import daos.MySQLTipoUsuario;
import daos.MySQLUSuarioDAO;
import daos.MySqlProductoDAO;

//import daos.MySqlEmpleadoDao;


public class MySQLDaoFactory extends DAOFactory{

	public static Connection obtenerConexion(){
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String urldb="jdbc:mysql://localhost:3306/OptBethel";
			String userdb="JEXTM";
			String passdb="jextm";
			/*String urldb ="jdbc:mysql://mysql9340-klarck.jl.serv.net.mx/bethel";
			String userdb = "jhony"; String passdb ="jhony";*/
			con=DriverManager.getConnection(urldb, userdb, passdb);
		} catch (Exception e) {			
			System.out.print("fallo en obtenerConexion");
		}
		return con;
	}
	/*
	@Override
	public I_Empleado getEmpleadoDao() {
		return new MySqlEmpleadoDao();
		
	}*/
	
	public I_Usuario getUsuario(){
		return new MySQLUSuarioDAO();
	}

	@Override
	public I_TipoDocIdent getDocIdent() {
		// TODO Auto-generated method stub
		return new MySQLTipoDocIdent();
	}

	@Override
	public I_TipoUsuario getTipoUsuario() {
		// TODO Auto-generated method stub
		return new MySQLTipoUsuario();
	}

	@Override
	public I_Producto getProducto() {
		// TODO Auto-generated method stub
		return new MySqlProductoDAO();
	}

	@Override
	public I_TipoProducto getTipoProducto() {
		// TODO Auto-generated method stub
		return new MySQLTipoProductoDAO();
	}

	@Override
	public I_Marca getMarca() {
		// TODO Auto-generated method stub
		return new MySQLMarcaDAO();
	}

	@Override
	public I_ComprobanteVenta getComprobanteVenta() {
		// TODO Auto-generated method stub
		return new MySQLComprobanteVentaDAO();
	}
	

}
