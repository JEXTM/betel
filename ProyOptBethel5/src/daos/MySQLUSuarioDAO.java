package daos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.BeanUsuario;
import factorias.MySQLDaoFactory;
import interfaces.I_Usuario;

public class MySQLUSuarioDAO extends MySQLDaoFactory implements I_Usuario{

	@Override
	public BeanUsuario Login(String username, String password) throws Exception {
		BeanUsuario usuario = null;
		try {
			Connection con = MySQLDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "select username, password from usuario where username= '"+username+"' and password= '"+password+"';";
			ResultSet rs =  stmt.executeQuery(query);
			if (rs.next()) {
				usuario = new BeanUsuario();
				usuario.setUsername(rs.getString("username"));
				usuario.setPassword(rs.getString("password"));
			}
			
		} catch (Exception e) {
			System.out.println("Fallo En Validar");
		}
		

		
		return usuario;
	}

	@Override
	public int AgregarPersonal(BeanUsuario usuario)throws Exception {
		int rs=0;
		try {
			Connection con = MySQLDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "INSERT INTO usuario(username,password,nombre,apePat,apeMat,direccion,correo,contacto,"
					+ "idTipoUsuario,idTipoDocIdent,docIdent) VALUES "
					+ "('"+usuario.getUsername()+"','"+usuario.getPassword()+"','"+usuario.getNombre()+"','"+usuario.getApePat()
					+"','"+usuario.getApeMat()+"','"+usuario.getDireccion()+"','"+usuario.getCorreo()+"','"+usuario.getContacto()+
					"','"+usuario.getIdTipoUsuario()+"','"+usuario.getIdTipoDocIdent()+"','"+usuario.getDocIdent()+"');";
			 rs =  stmt.executeUpdate(query);
		
		} catch (Exception e) {
			System.out.println("Fallo En Ingresar Usuario");
		}
		return rs;
	}

	@Override
	public int ModificarPersonal(int id, BeanUsuario usuario)throws Exception {
		int rs=0;
				try {
					Connection con = MySQLDaoFactory.obtenerConexion();
					Statement stmt = con.createStatement();
					String query = "UPDATE usuario SET username='"+usuario.getUsername()+"',password='"+usuario.getPassword()+"',nombre='"+usuario.getNombre()+"', apePat='"+usuario.getApePat()+"', apeMat='"+usuario.getApeMat()+"',direccion='"+usuario.getDireccion()+"',correo='"+usuario.getCorreo()+"',contacto='"+usuario.getContacto()+"', idTipoUsuario='"+usuario.getIdTipoUsuario()+"', idTipoDocIdent='"+usuario.getIdTipoDocIdent()+"', docIdent='"+usuario.getDocIdent()+"' WHERE idUsuario='"+id+"';";
					 rs =  stmt.executeUpdate(query);
				} catch (Exception e) {
					System.out.println("ERROR AL MODIFICAR"+e.getMessage());
				}
				
		return rs;
	}

	@Override
	public BeanUsuario BuscarPersonal(int id) throws Exception{
		// TODO Auto-generated method stub
		BeanUsuario usuario = null;
		try {
			Connection con = MySQLDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "select * from usuario where idUsuario="+id+";";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				usuario = new BeanUsuario();
				usuario.setIdUsuario(id);
				usuario.setUsername(rs.getString("username"));
				usuario.setPassword(rs.getString("password"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApePat(rs.getString("apePat"));
				usuario.setApeMat(rs.getString("apeMat"));
				usuario.setDireccion(rs.getString("direccion"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setContacto(rs.getString("contacto"));
				usuario.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
				usuario.setIdTipoDocIdent(rs.getInt("idTipoDocIdent"));
				usuario.setDocIdent(rs.getString("docIdent"));
			}
		} catch (Exception e) {
			System.out.println("Error Al Buscar Personal");
		}
		return usuario;
	}

	@Override
	public Vector<BeanUsuario> ListarUsuario() throws Exception {
		Vector<BeanUsuario> usuarios = new Vector<BeanUsuario>();
		try {
			Connection con = MySQLDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "select * from usuario;";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				BeanUsuario usuario = new BeanUsuario();
				usuario = new BeanUsuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setUsername(rs.getString("username"));
				usuario.setPassword(rs.getString("password"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApePat(rs.getString("apePat"));
				usuario.setApeMat(rs.getString("apeMat"));
				usuario.setDireccion(rs.getString("direccion"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setContacto(rs.getString("contacto"));
				usuario.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
				usuario.setIdTipoDocIdent(rs.getInt("idTipoDocIdent"));
				usuario.setDocIdent(rs.getString("docIdent"));
				usuarios.add(usuario);
			}
		} catch (Exception e) {
			System.out.println("Error Al Listar Personal");
		}
		return usuarios;
	}

	@Override
	public int EliminarPersonal(int id) throws Exception {
		int rs=0;
		try {
			Connection con = MySQLDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query="delete from usuario where idUsuario="+id+";";
			rs = stmt.executeUpdate(query);
		}catch(Exception e){
			System.out.println("ERROR EN EL MYSQL AL ELIMINAR");
		}
		return 	rs;
	}

	@Override
	public Vector<BeanUsuario> listarClientes() throws Exception {
		Vector<BeanUsuario> usuarios = new Vector<BeanUsuario>();
		try {
			Connection con = MySQLDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "select * from usuario where idTipoUsuario=1;";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				BeanUsuario usuario = new BeanUsuario();
				usuario = new BeanUsuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setUsername(rs.getString("username"));
				usuario.setPassword(rs.getString("password"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApePat(rs.getString("apePat"));
				usuario.setApeMat(rs.getString("apeMat"));
				usuario.setDireccion(rs.getString("direccion"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setContacto(rs.getString("contacto"));
				usuario.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
				usuario.setIdTipoDocIdent(rs.getInt("idTipoDocIdent"));
				usuario.setDocIdent(rs.getString("docIdent"));
				usuarios.add(usuario);
			}
		} catch (Exception e) {
			System.out.println("Error Al Listar Clientes");
		}
		return usuarios;
	}

	@Override
	public Vector<BeanUsuario> listarVendedores() throws Exception {
		Vector<BeanUsuario> usuarios = new Vector<BeanUsuario>();
		try {
			Connection con = MySQLDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "select * from usuario where idTipoUsuario=2;";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				BeanUsuario usuario = new BeanUsuario();
				usuario = new BeanUsuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setUsername(rs.getString("username"));
				usuario.setPassword(rs.getString("password"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApePat(rs.getString("apePat"));
				usuario.setApeMat(rs.getString("apeMat"));
				usuario.setDireccion(rs.getString("direccion"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setContacto(rs.getString("contacto"));
				usuario.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
				usuario.setIdTipoDocIdent(rs.getInt("idTipoDocIdent"));
				usuario.setDocIdent(rs.getString("docIdent"));
				usuarios.add(usuario);
			}
		} catch (Exception e) {
			System.out.println("Error Al Listar Vendedores");
		}
		return usuarios;
	}

	@Override
	public BeanUsuario buscarPorDocumento(String documento) throws Exception {
		BeanUsuario usuario = null;
		try {
			Connection con = MySQLDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "select * from usuario where docIdent="+documento+";";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				usuario = new BeanUsuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setUsername(rs.getString("username"));
				usuario.setPassword(rs.getString("password"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApePat(rs.getString("apePat"));
				usuario.setApeMat(rs.getString("apeMat"));
				usuario.setDireccion(rs.getString("direccion"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setContacto(rs.getString("contacto"));
				usuario.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
				usuario.setIdTipoDocIdent(rs.getInt("idTipoDocIdent"));
				usuario.setDocIdent(rs.getString("docIdent"));
			}
		} catch (Exception e) {
			System.out.println("Error EN EL MYSQL al Buscar Por Documento");
		}
		
		return usuario;
	}

	

}
