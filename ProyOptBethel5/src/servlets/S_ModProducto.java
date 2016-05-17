package servlets;

import factorias.DAOFactory;
import interfaces.I_Marca;
import interfaces.I_Producto;
import interfaces.I_TipoProducto;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanMarca;
import beans.BeanProducto;
import beans.BeantTipoProducto;

/**
 * Servlet implementation class S_ModProducto
 */
@WebServlet("/modProducto")
public class S_ModProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_ModProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idProducto"));
		
		try {
			DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			I_Producto i_Producto= dao.getProducto();
			BeanProducto producto = i_Producto.seleccionarPorId(id);
			request.setAttribute("productoMOD", producto);
			I_TipoProducto i_TipoProducto = dao.getTipoProducto();
			Vector<BeantTipoProducto> tipoProductos = i_TipoProducto.listarTipoProductos();
			request.setAttribute("tipoProductos", tipoProductos);
			I_Marca i_Marca = dao.getMarca();
			Vector<BeanMarca> marcas = i_Marca.listarMarca();
			request.setAttribute("marcas", marcas);
			
			request.getRequestDispatcher("admin/modificarProducto.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("Error En el Servlet Al Listar EL Modificar");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idProducto"));
		String nombre =(String) request.getParameter("nomProd");
		String descripcion =(String) request.getParameter("descripcion");
		double precio = Double.parseDouble(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		String fotoProducto = (String)request.getParameter("fotoProducto");
		String sku = (String)request.getParameter("sku");
		int idMarca = Integer.parseInt(request.getParameter("idMarca"));
		int idTipoProducto = Integer.parseInt(request.getParameter("idTipoProducto"));
		System.out.println(nombre+","+descripcion+","+precio+","+stock+","+fotoProducto+","+sku+","+idMarca+","+idTipoProducto+"!");
		BeanProducto producto = new BeanProducto(id, nombre, descripcion, precio, stock, fotoProducto, sku, idMarca, idTipoProducto);
		
		try {
			DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			I_Producto i_Producto = dao.getProducto();
			boolean flag = i_Producto.actualizar(producto);
			if (flag) {
				request.setAttribute("mensaje", "Producto Modificado Correctamente");
				request.getRequestDispatcher("admin/home.jsp").forward(request, response);
			}else{
				request.setAttribute("mensaje", "No Se Pudo Modificar");
				I_TipoProducto i_TipoProducto = dao.getTipoProducto();
				Vector<BeantTipoProducto> tipoProductos = i_TipoProducto.listarTipoProductos();
				request.setAttribute("tipoProductos", tipoProductos);
				I_Marca i_Marca = dao.getMarca();
				Vector<BeanMarca> marcas = i_Marca.listarMarca();
				request.setAttribute("marcas", marcas);
				request.setAttribute("productoMOD", producto);
				request.getRequestDispatcher("admin/modificarProducto.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("Error En el Servlet Al Modificar Producto");
		}
		
	}

}
