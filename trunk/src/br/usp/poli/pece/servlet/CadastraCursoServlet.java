package br.usp.poli.pece.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.poli.pece.bl.Curso;
import br.usp.poli.pece.db.DAOFactory;


public class CadastraCursoServlet extends TransactionServlet {
	
	private static final long serialVersionUID = 8321055504672825786L;

	@Override
	protected void doPostTransaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Curso c = new Curso();
		
		c.setNome(request.getParameter("nome"));
		c.setCodCurso(request.getParameter("codCurso"));
		c.setCargaHoraria(Short.parseShort(request.getParameter("cargaHoraria")));
		c.setDescricao(request.getParameter("descricao"));
		
		long idCoordenador = Long.parseLong(request.getParameter("coordenador"));

		c.setCoordenador(DAOFactory.getProfessorDAO().findById(idCoordenador));
		
		DAOFactory.getCursoDAO().makePersistent(c);
	}
	
	@Override
	protected void renderView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// forward to the JSP
		request.getRequestDispatcher("/academico/confirmaOperacao.jsp").forward(request, response);
	}
}
