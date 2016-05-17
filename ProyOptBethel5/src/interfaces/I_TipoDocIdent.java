package interfaces;


import java.util.Vector;

import beans.BeanTipoDocIdent;

public abstract interface I_TipoDocIdent {
	
	public Vector<BeanTipoDocIdent> listarTipoIdcent() throws Exception;

}
