<%@page contentType="text/html; charset=ISO-8859-1" %>
<%@page import="br.usp.poli.pece.db.UsuarioDAO"%>
<%@page import="br.usp.poli.pece.bl.Aluno"%>
<%@page import="br.usp.poli.pece.bl.Matricula"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" type="text/css" href="../css/frame.css" />
        <link rel="stylesheet" type="text/css" href="../css/academico.css" />
    </head>
    <body>
        <%
        	long idAluno = Integer.parseInt(request.getParameter("idAluno"));
        	int codCurso = Integer.parseInt(request.getParameter("codCurso"));
        	
        	if (Matricula.realizaMatricula(idAluno, codCurso)) {
        %>
        <p><a href="academico_main.html">Voltar</a></p>
        <%
            } else {
        %>
        <h2>Cadastro Realizado com sucesso</h2>
        <p><a href="academico_main.html">Voltar</a></p>
        <%
            }
        %>		
        
    </body>
</html>
