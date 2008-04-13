package br.usp.poli.pece.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import br.usp.poli.pece.db.DataBaseUtil;


public abstract class TransactionServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6381958335959098816L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		final Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		
		// Pega uma sessão, e inicia uma transação
		try {
			dbs.beginTransaction();
		} catch (Exception e) {
			System.err.println("Erro ao iniciar uma sessão! Provavelmente" +
					" uma sessão anterior não foi corretamente finalizada.");
			e.printStackTrace();
			dbs.close();
			return;
		}
		
		// Executa a subclasse e, se tudo der certo, comita a transacao
		try {
			doPostTransaction(request, response);

			dbs.getTransaction().commit();
		}
		catch (Exception e) {
			dbs.getTransaction().rollback();
			
			// TODO: handle runtime exception, forwarding to error page, or whatever
			
			try {
				request.setAttribute("erro", e.getMessage());
				// forward to error page
				request.getRequestDispatcher("/academico/erro.jsp").forward(request, response);
			} catch (Exception e2) { }
			
			return;
		}
		
		// renderiza a view!
		try {
			renderView(request, response);
		} catch (Exception e) {
			System.err.println("Erro ao renderizar a view!");
			e.printStackTrace();
			try {
				request.setAttribute("erro", e.getMessage());
				// forward to error page
				request.getRequestDispatcher("/academico/erro.jsp").forward(request, response);
			} catch (Exception e2) { }
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		final Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		
		// Pega uma sessão, e inicia uma transação
		try {
			dbs.beginTransaction();
		} catch (Exception e) {
			System.err.println("Erro ao iniciar uma sessão! Provavelmente" +
					" uma sessão anterior não foi corretamente finalizada.");
			e.printStackTrace();
			dbs.close();
			return;
		}
		
		// Executa a subclasse e, se tudo der certo, comita a transacao
		try {
			doGetTransaction(request, response);

			dbs.getTransaction().commit();
		}
		catch (Exception e) {
			dbs.getTransaction().rollback();
			
			// TODO: handle runtime exception, forwarding to error page, or whatever
			
			try {
				request.setAttribute("erro", e.getMessage());
				// forward to error page
				request.getRequestDispatcher("/academico/erro.jsp").forward(request, response);
			} catch (Exception e2) { }
			
			return;
		}
		
		// renderiza a view!
		try {
			renderView(request, response);
		} catch (Exception e) {
			System.err.println("Erro ao renderizar a view!");
			e.printStackTrace();
			try {
				request.setAttribute("erro", e.getMessage());
				// forward to error page
				request.getRequestDispatcher("/academico/erro.jsp").forward(request, response);
			} catch (Exception e2) { }
		}
	}

	protected abstract void renderView(HttpServletRequest request, HttpServletResponse response) throws Exception;

	protected void doGetTransaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		super.doGet(request, response);
	}

	protected void doPostTransaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		super.doPost(request, response);
	}
}
