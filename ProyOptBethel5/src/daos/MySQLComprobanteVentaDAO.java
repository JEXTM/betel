package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.BeanComprobanteVenta;
import interfaces.I_ComprobanteVenta;
import factorias.MySQLDaoFactory;

public class MySQLComprobanteVentaDAO extends MySQLDaoFactory implements I_ComprobanteVenta{

	@Override
	public int agregarComprobanteVenta(BeanComprobanteVenta comprobanteVenta)throws Exception {
		int flag=0;
		try {
			Connection con = MySQLDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query="INSERT INTO comprobanteventa(idComprobante,numComp,fechaEmision,tipoCompV,idVendedor,"
					+ "idCliente)VALUES('"+comprobanteVenta.getIdComprobante()+"', '"+comprobanteVenta.getNumComp()+"', '"+comprobanteVenta.getFechaEmision()+"', '"+comprobanteVenta.getTipoCompV()+"', '"+comprobanteVenta.getIdVendedor()+"', '"+comprobanteVenta.getIdCliente()+"');";
			flag = stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("ERROR EN EL MYSQL DE AGREGAR COMPROBANTE");
		}
		return flag;
	}

	@Override
	public Vector<BeanComprobanteVenta> listarComprobanteVenta()throws Exception {
		Vector<BeanComprobanteVenta> beanComprobanteVentas = new Vector<BeanComprobanteVenta>();
		try {
			Connection con = MySQLDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query="select * from comprobanteventa";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				BeanComprobanteVenta comprobanteVenta = new BeanComprobanteVenta();
				comprobanteVenta.setIdCliente(rs.getInt("idComprobante"));
				comprobanteVenta.setNumComp(rs.getString("numComp"));
				comprobanteVenta.setFechaEmision(rs.getString("fechaEmision"));
				comprobanteVenta.setTipoCompV(rs.getString("tipoCompV"));
				comprobanteVenta.setIdVendedor(rs.getInt("idVendedor"));
				comprobanteVenta.setIdCliente(rs.getInt("idCliente"));
				beanComprobanteVentas.add(comprobanteVenta);
			}
		} catch (Exception e) {
			System.out.println("Error En El MYSQL DE LISTAR COMPROBANTE");
		}
		return beanComprobanteVentas;
	}

	@Override
	public BeanComprobanteVenta buscarComprobanteVenta(int id)throws Exception {
		BeanComprobanteVenta comprobanteVenta = null;
		try {
			Connection con = MySQLDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query="select * from comprobanteventa where idComprobante="+id;
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				comprobanteVenta = new BeanComprobanteVenta();
				comprobanteVenta.setIdCliente(rs.getInt("idComprobante"));
				comprobanteVenta.setNumComp(rs.getString("numComp"));
				comprobanteVenta.setFechaEmision(rs.getString("fechaEmision"));
				comprobanteVenta.setTipoCompV(rs.getString("tipoCompV"));
				comprobanteVenta.setIdVendedor(rs.getInt("idVendedor"));
				comprobanteVenta.setIdCliente(rs.getInt("idCliente"));
			}
		} catch (Exception e) {
			System.out.println("Error En el MYSQL De Buscar Comprobante");
		}
		return comprobanteVenta;
	}

}
