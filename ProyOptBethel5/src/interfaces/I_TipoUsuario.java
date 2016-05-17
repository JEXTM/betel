package interfaces;

import java.util.Vector;

import beans.BeanTipoUsuario;

public abstract interface I_TipoUsuario {
	
	public Vector<BeanTipoUsuario>  ListarTipoUsuario() throws Exception;

}
