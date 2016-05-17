package interfaces;

import java.util.Vector;

import beans.BeanComprobanteVenta;

public abstract interface I_ComprobanteVenta{
	public int agregarComprobanteVenta(BeanComprobanteVenta comprobanteVenta)throws Exception;
	public Vector<BeanComprobanteVenta> listarComprobanteVenta()throws Exception;
	public BeanComprobanteVenta buscarComprobanteVenta(int id)throws Exception;
}
