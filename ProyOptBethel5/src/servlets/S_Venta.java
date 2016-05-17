package servlets;

import interfaces.I_Usuario;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanUsuario;
import factorias.DAOFactory;

/**
 * Servlet implementation class S_Venta
 */
@WebServlet("/venta")
public class S_Venta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_Venta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			try {
				DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
				I_Usuario i_Usuario = dao.getUsuario();
				Vector<BeanUsuario> clientes = i_Usuario.listarClientes();
				request.setAttribute("clientes", clientes);
				Vector<BeanUsuario> vendedores = i_Usuario.listarVendedores();
				request.setAttribute("vendedores", vendedores);
				request.getServletContext().getRequestDispatcher("/admin/agregarVenta.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println("Error En El Servlet De Venta");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
