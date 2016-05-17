package interfaces;

import java.util.Vector;  

import beans.BeanProducto;

public abstract interface I_Producto {
	public Vector<BeanProducto> listarTodos()throws Exception;
	public Vector<BeanProducto> listarTodosActivos()throws Exception;
	public boolean eliminar(int id)throws Exception;
	public boolean agregar(BeanProducto producto)throws Exception;
	public BeanProducto seleccionarPorId(int id)throws Exception;
	public boolean actualizar(BeanProducto producto) throws Exception;
	public BeanProducto seleccionarPorSku(String sku)throws Exception;
	public long countByMarca(int marca)throws Exception;
	public long countProduct()throws Exception;
	
}
