package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import beans.BeantTipoProducto;
import interfaces.I_TipoProducto;
import factorias.MySQLDaoFactory;

public class MySQLTipoProductoDAO extends MySQLDaoFactory implements I_TipoProducto{

	@Override
	public Vector<BeantTipoProducto> listarTipoProductos() throws Exception {
		Vector<BeantTipoProducto> tipoProductos = new Vector<BeantTipoProducto>();
		try {
			Connection con = MySQLDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "select * from tipoproducto;";
			ResultSet rs =  stmt.executeQuery(query);
			while(rs.next()){
				BeantTipoProducto tipoProducto = new BeantTipoProducto();
				tipoProducto.setIdTipoProducto(rs.getInt("idTipoProducto"));
				tipoProducto.setNombre(rs.getString("nombre"));
				tipoProducto.setDescripcion(rs.getString("descripcion"));
				tipoProductos.add(tipoProducto);
			}
		} catch (Exception e) {
			System.out.println("Error En Listar Tipo De Producto");
		}
		return tipoProductos;
	}

}
