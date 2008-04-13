package br.usp.poli.pece.servlet;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.poli.pece.bl.Aluno;
import br.usp.poli.pece.bl.Funcionario;
import br.usp.poli.pece.bl.Professor;
import br.usp.poli.pece.bl.Usuario;


public class CadastraUsuarioServlet extends TransactionServlet {
	private static final long serialVersionUID = 6251531527946259992L;

	@Override
	protected void doPostTransaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy");

		String tipo = request.getParameter("tipo");
		Usuario user = null;

		if (tipo.equals("Aluno")) {
			user = new Aluno();
		} else if (tipo.equals("Professor")) {
			user = new Professor();
		} else if (tipo.equals("Funcionario")) {
			user = new Funcionario();
		} else {
			throw new RuntimeException("Tipo de usuário desconhecido");
		}

		user.setSenha(request.getParameter("senha"));
		user.setLogin(request.getParameter("login"));
		user.setNome(request.getParameter("nome"));
		user.setEmail(request.getParameter("email"));
		user.setDataExpRg(dma.parse(request.getParameter("DataExpRg")));
		user.setCpf(Long.parseLong(request.getParameter("cpf")));        
		user.setDataNascimento(dma.parse(request.getParameter("data_nascimento")));

		user.persist();

		// passa o usuario cadastrado caso a view queria mostrar algo
		request.setAttribute("usuario", user);
	}
	
	@Override
	protected void renderView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// forward to the JSP
		request.getRequestDispatcher("/academico/cadastroOk.jsp").forward(request, response);
	}
}
