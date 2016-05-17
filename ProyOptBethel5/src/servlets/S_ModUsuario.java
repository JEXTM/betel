package servlets;

import factorias.DAOFactory;
import interfaces.I_Usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanUsuario;

/**
 * Servlet implementation class S_ModUsuario
 */
@WebServlet("/modUsuario")
public class S_ModUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_ModUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			I_Usuario i_Usuario = dao.getUsuario();
			BeanUsuario usuario = i_Usuario.BuscarPersonal(id);
			request.setAttribute("usuarioMOD", usuario);
			
			request.getRequestDispatcher("admin/modificarUsuario.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			System.out.println("Error Al Modificar En EL Servlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			int id = Integer.parseInt(request.getParameter("idUsuario"));
			String username = (String) request.getParameter("username");
			String password = (String) request.getParameter("password");
			String nombre = (String) request.getParameter("nombre");
			String apePat = (String) request.getParameter("apePat");
			String apeMat = (String) request.getParameter("apeMat");
			String direccion = (String) request.getParameter("direccion");
			String correo = (String) request.getParameter("correo");
			String contacto = (String) request.getParameter("contacto");
			int idTipoUsuario = Integer.parseInt(request.getParameter("tipoUsu"));
			int idTipoDocIdent = Integer.parseInt(request.getParameter("tipoDoc"));
			String docIdent = (String)request.getParameter("docIdent");
			
			BeanUsuario usuario = new  BeanUsuario(id, username, password, nombre, apePat, apeMat, direccion, correo, contacto, idTipoUsuario, idTipoDocIdent, docIdent);
			
			DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			I_Usuario i_Usuario = dao.getUsuario();
			int rs = i_Usuario.ModificarPersonal(id, usuario);
			
			if (rs==1) {
				request.setAttribute("mensaje", "Se Modifico Correctamente");
				request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
			}else{
				request.setAttribute("mensaje", "No Se Puedo Agregar");
				request.getRequestDispatcher("/admin/modificarUsuario.jsp").forward(request, response);
			}
			}catch(Exception e){
				System.out.println("NO SE PUDO Modificar" + e.getMessage());
			}

	}

}
