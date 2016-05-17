package interfaces;

import java.util.Vector;

import beans.BeanMarca;

public abstract interface I_Marca {
	
	public Vector<BeanMarca> listarMarca() throws Exception;
	
}
