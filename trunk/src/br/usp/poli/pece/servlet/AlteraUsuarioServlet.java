package br.usp.poli.pece.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;

import br.usp.poli.pece.bl.Usuario;
import br.usp.poli.pece.db.DAOFactory;


public class AlteraUsuarioServlet extends TransactionServlet {
	
	private static final long serialVersionUID = 3580375067155554405L;

	@Override
	protected void doGetTransaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long id = Long.parseLong(request.getParameter("id"));
		Usuario u = DAOFactory.getUsuarioDAO().findById(id);
		
		System.out.println(request.getParameter("Update"));
		
		Hibernate.initialize(u);
		request.setAttribute("usuario", u);
	}
	
	@Override
	protected void renderView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// forward to the JSP
		request.getRequestDispatcher("/academico/editarUsuario.jsp").forward(request, response);
	}
}
