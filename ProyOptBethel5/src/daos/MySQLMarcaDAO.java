package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.BeanMarca;
import interfaces.I_Marca;
import factorias.MySQLDaoFactory;

public class MySQLMarcaDAO extends MySQLDaoFactory implements I_Marca{

	@Override
	public Vector<BeanMarca> listarMarca() throws Exception {
		Vector<BeanMarca> marcas = new Vector<BeanMarca>();
		try {
			Connection con = MySQLDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "select * from marca";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				BeanMarca marca = new BeanMarca();
				marca.setIdMarca(rs.getInt("idMarca"));
				marca.setNombre(rs.getString("nombre"));
				marca.setDescripcion(rs.getString("descripcion"));
				marcas.add(marca);
			}
		} catch (Exception e) {
			System.out.println("Error En listar En el MYSQL");
		}
		
		
		return marcas;
	}

}
