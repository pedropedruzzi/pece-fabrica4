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
		aluno.setEndereco(request.getAttribute("end_aluno").toString());
		aluno.setNome(request.getAttribute("nome_aluno").toString());
		aluno.setTelefone(Integer.parseInt(request.getAttribute("tel_aluno").toString()));
		
		PessoaDAO cadastroAlunoPOC = new PessoaDAO();
		cadastroAlunoPOC.cadastroAluno(aluno);
		%>
	</body>
</html>