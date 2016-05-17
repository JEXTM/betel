package servlets;

import interfaces.I_Usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BeanUsuario;
import factorias.DAOFactory;

/**
 * Servlet implementation class S_Login
 */
@WebServlet("/login")
public class S_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("usuario");
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			System.out.println("Fallo En El DesLogeo");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String username = (String) request.getParameter("txtUsername");
				String password = (String) request.getParameter("txtPassword");
				
				try {
					DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
					I_Usuario i_Usuario = dao.getUsuario();
					BeanUsuario usuario = i_Usuario.Login(username, password);
					if (usuario != null) {
						HttpSession sesiones=request.getSession();
						sesiones.setAttribute("usuario", usuario);
//						request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
						response.sendRedirect("admin/home.jsp");
					}else{
						request.setAttribute("mensaje", "Usuario o Contraseña Incorrectos");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				
				} catch (Exception e) {
				System.out.println("Error En El Logeo");
				}
			
		
	}

}
