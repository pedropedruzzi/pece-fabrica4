package br.usp.poli.pece.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.poli.pece.bl.Matricula;


public class MatriculaAlunoServlet extends TransactionServlet {

	private static final long serialVersionUID = -2639353468010813756L;

	@Override
	protected void doPostTransaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long idAluno = Integer.parseInt(request.getParameter("idAluno"));
		long idCurso = Integer.parseInt(request.getParameter("idCurso"));

		Matricula.realizaMatricula(idAluno, idCurso);
	}

	@Override
	protected void renderView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// forward to the JSP
		request.getRequestDispatcher("/academico/confirmaOperacao.jsp").forward(request, response);
	}
}
