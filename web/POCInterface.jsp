<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@page import="br.usp.poli.pece.ws.WebServicesClient"%>
<%@page import="br.usp.poli.pece.poc.PocIntegracaoInterface"%>
<%@page import="java.util.List"%>
<%@page import="br.usp.poli.pece.bl.Pessoa"%>
<%@page import="br.usp.poli.pece.db.PessoaDAO"%>
	<body>
		<%		
		Pessoa aluno = new Pessoa();
		aluno.setEndereco(request.getParameter("end_aluno"));
		aluno.setNome(request.getParameter("nome_aluno"));
		aluno.setTelefone(Integer.parseInt(request.getParameter("tel_aluno")));
		
		PessoaDAO.cadastroAluno(aluno);
		%>
		<a href="index.html">Voltar</a>
	</body>
</html>