package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.BeanTipoDocIdent;
import interfaces.I_TipoDocIdent;
import factorias.MySQLDaoFactory;

public class MySQLTipoDocIdent extends MySQLDaoFactory implements I_TipoDocIdent{

	@Override
	public Vector<BeanTipoDocIdent> listarTipoIdcent() throws Exception {
		Vector<BeanTipoDocIdent> tipoDocIdent = new Vector<BeanTipoDocIdent>();
		try {
			Connection con = MySQLDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "select * from tipodocident;";
			ResultSet rs =  stmt.executeQuery(query);
			while(rs.next()){
				BeanTipoDocIdent bean = new BeanTipoDocIdent();
				bean.setIdTipoDocIdent(rs.getInt("idtipodocident"));
				bean.setNombre(rs.getString("nombre"));
				bean.setDescripcion(rs.getString("descripcion"));
				tipoDocIdent.add(bean);
			}
		} catch (Exception e) {
			System.out.println("Error En Listar Tipo De Documento");
		}
		return tipoDocIdent;
	}


	
}
