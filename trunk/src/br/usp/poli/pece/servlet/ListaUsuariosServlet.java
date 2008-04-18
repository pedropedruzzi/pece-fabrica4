package br.usp.poli.pece.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;

import br.usp.poli.pece.db.DAOFactory;


public class ListaUsuariosServlet extends TransactionServlet {
	
	private static final long serialVersionUID = 6860602090481369781L;

	@Override
	protected void doGetTransaction(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		String tipo = request.getParameter("tipo");
		List<?> usuarios = null;
		
		if (tipo == null) {
			usuarios = DAOFactory.getUsuarioDAO().findAll();
		} else if (tipo.equals("Aluno")) {
			usuarios = DAOFactory.getAlunoDAO().findAll();
		} else if (tipo.equals("Professor")) {
			usuarios = DAOFactory.getProfessorDAO().findAll();
		} else if (tipo.equals("Funcionario")) {
			usuarios = DAOFactory.getFuncionarioDAO().findAll();
		} else {
			throw new RuntimeException("Tipo de usuário desconhecido");
		}
		
		Hibernate.initialize(usuarios);
		
		request.setAttribute("usuarios", usuarios);
	}
	
	@Override
	protected void renderView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// forward to the JSP
		request.getRequestDispatcher("/academico/listaUsuarios.jsp").forward(request, response);
	}
}
