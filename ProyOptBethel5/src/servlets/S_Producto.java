package servlets;

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
import factorias.DAOFactory;

/**
 * Servlet implementation class S_Producto
 */
@WebServlet("/producto")
public class S_Producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_Producto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int action = Integer.parseInt(request.getParameter("action"));
		
		if (action==1) {
			//Lleva la form de agregar Producto
			try {
				DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
				I_TipoProducto i_TipoProducto = dao.getTipoProducto();
				Vector<BeantTipoProducto> tipoProductos = i_TipoProducto.listarTipoProductos();
				request.setAttribute("tipoProductos", tipoProductos);
				I_Marca i_Marca = dao.getMarca();
				Vector<BeanMarca> marcas = i_Marca.listarMarca();
				request.setAttribute("marcas", marcas);
				
				request.getRequestDispatcher("admin/agregarProducto.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println("Error En el Servlet De Producto");
			}
		}else if(action==2){
//			Lista Productos
			try{
			DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			I_TipoProducto i_TipoProducto = dao.getTipoProducto();
			Vector<BeantTipoProducto> tipoProductos = i_TipoProducto.listarTipoProductos();
			request.setAttribute("tipoProductos", tipoProductos);
			I_Marca i_Marca = dao.getMarca();
			Vector<BeanMarca> marcas = i_Marca.listarMarca();
			request.setAttribute("marcas", marcas);
			I_Producto i_Producto  = dao.getProducto();
			Vector<BeanProducto> productos = i_Producto.listarTodos();
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("admin/listarProducto.jsp").forward(request, response);
			}catch(Exception e){
				System.out.println("Error en el Servlet Al Listar Productos");
			}
		}else{
//			Elimina Productos
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
				I_Producto i_Producto = dao.getProducto();
				boolean flag = i_Producto.eliminar(id);
				I_TipoProducto i_TipoProducto = dao.getTipoProducto();
				Vector<BeantTipoProducto> tipoProductos = i_TipoProducto.listarTipoProductos();
				request.setAttribute("tipoProductos", tipoProductos);
				I_Marca i_Marca = dao.getMarca();
				Vector<BeanMarca> marcas = i_Marca.listarMarca();
				request.setAttribute("marcas", marcas);
				Vector<BeanProducto> productos = i_Producto.listarTodos();
				if (flag) {
					request.setAttribute("mensaje", "Eliminado Correctamente");
					request.setAttribute("productos", productos);
					request.getRequestDispatcher("/admin/listarProducto.jsp").forward(request, response);
				}else{
					request.setAttribute("mensaje", "No se Pudo Eliminar");
					request.setAttribute("productos", productos);
					request.getRequestDispatcher("/admin/listarProducto.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre =(String) request.getParameter("nomProd");
		String descripcion =(String) request.getParameter("descripcion");
		double precio = Double.parseDouble(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		String fotoProducto = (String)request.getParameter("fotoProducto");
		String sku = (String)request.getParameter("sku");
		int idMarca = Integer.parseInt(request.getParameter("idMarca"));
		int idTipoProducto = Integer.parseInt(request.getParameter("idTipoProducto"));
		
		System.out.println(nombre+","+descripcion+","+precio+","+stock+","+fotoProducto+","+sku+","+idMarca+","+idTipoProducto+"°°°");
		
		BeanProducto producto = new  BeanProducto(0, nombre, descripcion, precio, stock, fotoProducto, sku, idMarca, idTipoProducto);
		
		try {
			DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			I_Producto i_Producto = dao.getProducto();
			boolean flag = i_Producto.agregar(producto);
			if (flag) {
				request.setAttribute("mensaje", "Producto agregado Correctamente");
				request.getRequestDispatcher("admin/home.jsp").forward(request, response);
			}else{
				request.setAttribute("mensaje", "No Se Pudo Agregar");
				I_TipoProducto i_TipoProducto = dao.getTipoProducto();
				Vector<BeantTipoProducto> tipoProductos = i_TipoProducto.listarTipoProductos();
				request.setAttribute("tipoProductos", tipoProductos);
				I_Marca i_Marca = dao.getMarca();
				Vector<BeanMarca> marcas = i_Marca.listarMarca();
				request.setAttribute("marcas", marcas);
				request.getRequestDispatcher("admin/agregarProducto.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("Error En el Servlet Al Agregar Producto");
		}

			
	}

}
