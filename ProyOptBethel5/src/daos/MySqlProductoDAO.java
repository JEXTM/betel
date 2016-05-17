package daos;

import java.sql.Connection;  
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.BeanProducto;


import interfaces.I_Producto;
import factorias.MySQLDaoFactory;

public class MySqlProductoDAO extends MySQLDaoFactory implements I_Producto {

	@Override
	public Vector<BeanProducto> listarTodos() throws Exception {
		Vector<BeanProducto> productos=new Vector<BeanProducto>();
		try {
			Connection con = MySqlProductoDAO.obtenerConexion();
			Statement stmt = con.createStatement();
			String query ="select * from producto;";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				BeanProducto producto = new BeanProducto();
				producto.setIdProducto(rs.getInt("idProducto"));
				producto.setNomProd(rs.getString("nomProd"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setStock(rs.getInt("stock"));
				producto.setFotoProducto(rs.getString("fotoProducto"));
				producto.setSku(rs.getString("sku"));
				producto.setIdMarca(rs.getInt("idMarca"));
				producto.setIdTipoProducto(rs.getInt("idTipoProducto"));
				productos.add(producto);
			}
		} catch (Exception e) {
			System.out.println("Error Al Listar Producto En el Mysql");
		}
		return productos;
	}

	@Override
	public boolean eliminar(int id) throws Exception {
		boolean flag = false;
		
		try {
			Connection con = MySqlProductoDAO.obtenerConexion();
			Statement stmt = con.createStatement();
			String query ="delete from producto where idProducto="+id+";";
			int rs = stmt.executeUpdate(query);
			if (rs==1) {
					flag= true;
			}
			
		} catch (Exception e) {
			System.out.println("Error Al Eliminar Producto En el Mysql");
		}
		return flag;
	}

	@Override
	public boolean agregar(BeanProducto producto) throws Exception {
		boolean flag = false;
		try {
			Connection con = MySQLDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query="INSERT INTO producto (nomProd,descripcion,precio,stock,fotoProducto,sku,idMarca,idTipoProducto) VALUES ('"+producto.getNomProd()+"', '"+producto.getDescripcion()+"', "+producto.getPrecio()+", "+producto.getStock()+", '"+producto.getFotoProducto()+"', '"+producto.getSku()+"', "+producto.getIdMarca()+", "+producto.getIdTipoProducto()+");";
			int rs = stmt.executeUpdate(query);
			if (rs==1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Erorr En el MYSQL DE AGREGAR Producto");
		}
		
		return flag;
	}

	@Override
	public BeanProducto seleccionarPorId(int id) throws Exception {
		BeanProducto producto = null;
		try {
			Connection con = MySqlProductoDAO.obtenerConexion();
			Statement stmt = con.createStatement();
			String query ="select * from producto where idProducto="+id+";";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				producto = new BeanProducto();
				producto.setIdProducto(rs.getInt("idProducto"));
				producto.setNomProd(rs.getString("nomProd"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setStock(rs.getInt("stock"));
				producto.setFotoProducto(rs.getString("fotoProducto"));
				producto.setSku(rs.getString("sku"));
				producto.setIdMarca(rs.getInt("idMarca"));
				producto.setIdTipoProducto((rs.getInt("idTipoProducto")));			
			}
		} catch (Exception e) {
			System.out.println("Error Al Buscar Producto En el Mysql");
		}
		
		return producto;
	}

	@Override
	public boolean actualizar(BeanProducto producto) throws Exception {
		boolean flag = false;
		try {
			Connection con = MySQLDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query="UPDATE producto SET nomProd='"+producto.getNomProd()+"', descripcion='"+producto.getDescripcion()+"', precio='"+producto.getPrecio()+"', stock='"+producto.getStock()+"', fotoProducto='"+producto.getFotoProducto()+"', sku='"+producto.getSku()+"', idMarca='"+producto.getIdMarca()+"', idTipoProducto='"+producto.getIdTipoProducto()+"' WHERE idProducto='"+producto.getIdProducto()+"';";
			int rs = stmt.executeUpdate(query);
			if (rs==1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Erorr En el MYSQL DE Actualizar Producto");
		}
		
		return flag;
	}

	@Override
	public Vector<BeanProducto> listarTodosActivos() throws Exception {
		Vector<BeanProducto> productos=new Vector<BeanProducto>();
		
		return productos;
	}

	@Override
	public BeanProducto seleccionarPorSku(String sku) throws Exception {
		BeanProducto producto= null;
		try {
			Connection con = MySqlProductoDAO.obtenerConexion();
			Statement stmt = con.createStatement();
			String query ="select * from producto where sku="+sku+";";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				producto = new BeanProducto();
				producto.setIdProducto(rs.getInt("idProducto"));
				producto.setNomProd(rs.getString("nomProd"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setStock(rs.getInt("stock"));
				producto.setFotoProducto(rs.getString("fotoProducto"));
				producto.setSku(rs.getString("sku"));
				producto.setIdMarca(rs.getInt("idMarca"));
				producto.setIdTipoProducto((rs.getInt("idTipoProducto")));			
			}
		} catch (Exception e) {
			System.out.println("Error En EL MYSQL DE BUSCAR POR SKU");
		}
		return producto;
	}

	@Override
	public long countByMarca(int marca) throws Exception {
		long result = 0;
			try {
				Connection con = MySQLDaoFactory.obtenerConexion();
				Statement stmt = con.createStatement();
				String query = "select count(*) cantidad from producto where idMarca ="+marca+";";
				ResultSet rs = stmt.executeQuery(query);
				if (rs.next()) {
					result = rs.getInt("cantidad");
				}else{
					System.out.println("No existen productos con esa Marca");
				}
			} catch (Exception e) {
				System.out.println("Error en el Producto DAO");
			}
		return result;
	}

	@Override
	public long countProduct() throws Exception {
		long result = 0;
		try{
		Connection con = MySQLDaoFactory.obtenerConexion();
		Statement stmt = con.createStatement();
		String query = "select count(*) cantidad from producto;";
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {
			result = rs.getInt("cantidad");
		}
		}catch(Exception e){
			System.out.println("Error en el MYSQLDAO de countProcuto"+e.getMessage());
		}
		return result;
	}
}
