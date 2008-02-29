<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@page import="br.usp.poli.pece.ws.WebServicesClient"%>
<%@page import="br.usp.poli.pece.poc.PocIntegracaoInterface"%>
<%@page import="java.util.List"%>
<%@page import="br.usp.poli.pece.bl.Pessoa"%>
<%@page import="br.usp.poli.pece.bl.Usuario"%>
<html>
	<body>
		Lista alunos cadastrados:<br>
		<table border='1'>
		<tr><th>Nome</th><th>Telefone</th></tr>
		<%
			PocIntegracaoInterface alunos = WebServicesClient.getAlunosWS();
			List<Usuario> lista = alunos.consultaUsuarios("");
			for (Usuario aluno : lista) {
				%>
				<tr>
				<td><%= aluno.getNome() %></td>
				<td><%= Long.toString(aluno.getTelefone()) %></td>
				</tr>
				<%
			}
		%>
		</table>
	</body>
</html>
