package br.usp.poli.pece.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.poli.pece.bl.Usuario;
import br.usp.poli.pece.db.DAOFactory;


public class RemoveUsuarioServlet extends TransactionServlet {
	
	private static final long serialVersionUID = 3580375067155554405L;

	@Override
	protected void doGetTransaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long id = Long.parseLong(request.getParameter("id"));
		Usuario u = DAOFactory.getUsuarioDAO().findById(id);
		
		DAOFactory.getUsuarioDAO().makeTransient(u);
	}
	
	@Override
	protected void renderView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// forward to the JSP
		request.getRequestDispatcher("/academico/confirmaOperacao.jsp").forward(request, response);
	}
}
