package interfaces;

import java.util.Vector;

import beans.BeanUsuario;

public abstract interface I_Usuario {
	
	public BeanUsuario Login(String username, String password) throws Exception;
	public int AgregarPersonal(BeanUsuario usuario) throws Exception;
	public int ModificarPersonal(int id,BeanUsuario usuario) throws Exception;
	public BeanUsuario BuscarPersonal(int id) throws Exception;
	public Vector<BeanUsuario> ListarUsuario() throws Exception;
	public int EliminarPersonal(int id) throws Exception;
	public Vector<BeanUsuario> listarClientes() throws Exception;
	public Vector<BeanUsuario> listarVendedores() throws  Exception;
	public BeanUsuario buscarPorDocumento(String documento)throws Exception;

}
