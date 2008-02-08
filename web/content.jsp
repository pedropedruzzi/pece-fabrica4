<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@page import="br.usp.poli.pece.ws.WebServicesClient"%>
<%@page import="br.usp.poli.pece.poc.PocIntegracaoInterface"%>
<%@page import="java.util.List"%>
<html>
	<body>
		Revistas cadastradas:<br>
		<%
			PocIntegracaoInterface alunos = WebServicesClient.getAlunosWS();
			List<String> lista = alunos.listaAlunos();
			for (String aluno : lista) {
				%>
				<%= aluno %><br>
				<%
			}
		%>
	</body>
</html>
