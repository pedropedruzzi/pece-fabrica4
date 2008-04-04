<html>
    
    <head>  
        <link rel="stylesheet" type="text/css" href="../css/frame.css" />
        <link rel="stylesheet" type="text/css" href="../css/academico.css" />
        <title>Confirmação de Cadastro</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@page import="br.usp.poli.pece.bl.Usuario"%>
        <%@page import="br.usp.poli.pece.bl.Aluno"%>
    </head>
    <body>
        <%
            Aluno user = new Aluno();
            user.setSenha(request.getParameter("senha"));
            user.setLogin(request.getParameter("login"));
            user.setNome(request.getParameter("nome"));
            user.setEmail(request.getParameter("email"));
            if (!user.cadastraUsuario()) {
                out.println(user.ObtemUltimoErro());
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
