package br.usp.poli.pece.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;

import br.usp.poli.pece.bl.Aluno;
import br.usp.poli.pece.db.DAOFactory;


public class ListaAlunosServlet extends TransactionServlet {
	
	private static final long serialVersionUID = 6860602090481369781L;

	@Override
	protected void doGetTransaction(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		List<Aluno> alunos = DAOFactory.getAlunoDAO().findAll();
		Hibernate.initialize(alunos);
		
		request.setAttribute("alunos", alunos);
	}
	
	@Override
	protected void renderView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// forward to the JSP
		request.getRequestDispatcher("/academico/listaAlunos.jsp").forward(request, response);
	}
}
