package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJsp;
import dao.DAOUsuario;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/salvarUsuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	private DAOUsuario daoUsuario = new DAOUsuario();
      public Usuario() {
        super();
       
    }
	
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		try {
			String acao = request.getParameter("acao");
			String user = request.getParameter("user");
			
	if(acao.equalsIgnoreCase("delete")) {
			daoUsuario.delete(user);
			//ele deleta e lista se tudo ocorrer certo
			RequestDispatcher view = request.getRequestDispatcher("/cadastrarUsuario.jsp");
			request.setAttribute("usuarios", daoUsuario.listar());
			view.forward(request, response);
		} 
	else if(acao.equalsIgnoreCase("editar")) {
		BeanCursoJsp beanCursoJsp = daoUsuario.consultar(user);
		RequestDispatcher view = request.getRequestDispatcher("/cadastrarUsuario.jsp");
		request.setAttribute("user", daoUsuario.consultar(user));
		view.forward(request, response);
		
		
	}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		BeanCursoJsp usuario = new BeanCursoJsp();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		
		try {
			daoUsuario.salvar(usuario);
			RequestDispatcher view = request.getRequestDispatcher("/cadastrarUsuario.jsp");
			request.setAttribute("usuarios", daoUsuario.listar());
			view.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}

}
}
