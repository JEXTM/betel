package interfaces;

import java.util.Vector;

import beans.BeantTipoProducto;

public  abstract interface I_TipoProducto {

	public Vector<BeantTipoProducto> listarTipoProductos() throws Exception;
	
}
