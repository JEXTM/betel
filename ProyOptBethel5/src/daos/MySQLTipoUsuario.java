package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.BeanTipoUsuario;
import interfaces.I_TipoUsuario;
import factorias.MySQLDaoFactory;

public class MySQLTipoUsuario extends MySQLDaoFactory implements I_TipoUsuario{

	@Override
	public Vector<BeanTipoUsuario> ListarTipoUsuario() throws Exception {
		Vector<BeanTipoUsuario> tipoUsuarios = new Vector<BeanTipoUsuario>();
		
		try {
			Connection con = MySQLDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "select * from tipousuario;";
			ResultSet rs =  stmt.executeQuery(query);
			while(rs.next()){
				BeanTipoUsuario tipo = new BeanTipoUsuario();
				tipo.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
				tipo.setNombre(rs.getString("nombre"));
				tipo.setDescripcion(rs.getString("descripcion"));
				tipoUsuarios.add(tipo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error Al Listar Tipo Usuario");
		}
		
		return tipoUsuarios;
	}

}
