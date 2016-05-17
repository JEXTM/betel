package servlets;

import interfaces.I_TipoDocIdent;
import interfaces.I_TipoUsuario;
import interfaces.I_Usuario;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanTipoDocIdent;
import beans.BeanTipoUsuario;
import beans.BeanUsuario;
import factorias.DAOFactory;

/**
 * Servlet implementation class S_Usuario
 */
@WebServlet("/usuario")
public class S_Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_Usuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  action = Integer.parseInt(request.getParameter("action"));
		
		
		if (action==1) {
			//Eliminar Usuario
			int id= Integer.parseInt(request.getParameter("id"));
		try{	
			DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			I_Usuario i_Usuario = dao.getUsuario();
			int rs = i_Usuario.EliminarPersonal(id);
			Vector<BeanUsuario> usuarios = i_Usuario.ListarUsuario();
			I_TipoUsuario i_TipoUsuario = dao.getTipoUsuario();
			Vector<BeanTipoUsuario> tipoUsuarios =i_TipoUsuario.ListarTipoUsuario();
			request.setAttribute("tipoUsuarios", tipoUsuarios);
			I_TipoDocIdent i_TipoDocIdent = dao.getDocIdent();
			Vector<BeanTipoDocIdent> tipoDocIdents = i_TipoDocIdent.listarTipoIdcent();
			request.setAttribute("tipoDocIdents", tipoDocIdents);
			if (rs==1) {
				request.setAttribute("mensaje", "Se Elimino Correctamente");
				request.setAttribute("usuarios", usuarios);
				request.getRequestDispatcher("/admin/listarUsuario.jsp").forward(request, response);
			}else {
				request.setAttribute("mensaje", "No se Pudo Eliminar");
				request.setAttribute("usuarios", usuarios);
				request.getRequestDispatcher("/admin/listarUsuario.jsp").forward(request, response);
			}
		}catch(Exception e){
			System.out.println("Error En eL Servlet Al Eliminar");
		}
			
		}else if(action ==2){
			//Listar
			try{
			DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			I_Usuario i_Usuario = dao.getUsuario();
			Vector<BeanUsuario> usuarios = i_Usuario.ListarUsuario();
			System.out.println(usuarios.size());
			request.setAttribute("usuarios", usuarios);
			I_TipoUsuario i_TipoUsuario = dao.getTipoUsuario();
			Vector<BeanTipoUsuario> tipoUsuarios =i_TipoUsuario.ListarTipoUsuario();
			request.setAttribute("tipoUsuarios", tipoUsuarios);
			I_TipoDocIdent i_TipoDocIdent = dao.getDocIdent();
			Vector<BeanTipoDocIdent> tipoDocIdents = i_TipoDocIdent.listarTipoIdcent();
			request.setAttribute("tipoDocIdents", tipoDocIdents);
			
			request.getRequestDispatcher("/admin/listarUsuario.jsp").forward(request, response);
			
			
			}catch(Exception e){
				System.out.println("Error Al Listar En El Servlet");
			}
		}else if (action ==3) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Agregar Usuario
		try{
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
		
		BeanUsuario usuario = new  BeanUsuario(0, username, password, nombre, apePat, apeMat, direccion, correo, contacto, idTipoUsuario, idTipoDocIdent, docIdent);
		
		DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		I_Usuario i_Usuario = dao.getUsuario();
		int rs = i_Usuario.AgregarPersonal(usuario);
		
		if (rs==1) {
			request.setAttribute("mensaje", "Se Agrego Correctamente");
			request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
		}else{
			request.setAttribute("mensaje", "No Se Puedo Agregar");
			request.getRequestDispatcher("/admin/agregarUsuario.jsp").forward(request, response);
		}
		}catch(Exception e){
			System.out.println("NO SE PUDO AGREGAR" + e.getMessage());
		}
	}

}
