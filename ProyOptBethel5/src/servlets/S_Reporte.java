package servlets;

import interfaces.I_Marca;
import interfaces.I_Producto;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanMarca;
import factorias.DAOFactory;

/**
 * Servlet implementation class S_Reporte
 */
@WebServlet("/reporte")
public class S_Reporte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_Reporte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try {
				DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
				I_Marca i_Marca = dao.getMarca();
				Vector<BeanMarca> marcas =i_Marca.listarMarca();
				request.setAttribute("marcas", marcas);
			} catch (Exception e) {
				System.out.println("Error en el servlet de Reportes "+ e.getMessage());
			}
			getServletContext().getRequestDispatcher("/admin/reportes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int marca = Integer.parseInt(request.getParameter("marca"));
			try {
				
				DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
				I_Producto i_Producto= dao.getProducto();
				long cantidad = i_Producto.countByMarca(marca);
				int cantidadInt = Integer.parseInt(cantidad+"");
				long total = i_Producto.countProduct();
				int totalInt = Integer.parseInt(total+"");
				I_Marca i_Marca = dao.getMarca();
				Vector<BeanMarca> marcas =i_Marca.listarMarca();
				System.out.println(cantidadInt+" "+totalInt);
				request.setAttribute("marcas", marcas);
				request.setAttribute("cantidad", cantidadInt);
				request.setAttribute("total", totalInt);
				request.setAttribute("idMarca", marca);
				
			} catch (Exception e) {
				System.out.println("Error en el servlet post de reporte");
			}
			getServletContext().getRequestDispatcher("/admin/help/chart.jsp").forward(request, response);
	}

}
