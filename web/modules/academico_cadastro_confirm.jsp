<html>
    
    <head>  
        <link rel="stylesheet" type="text/css" href="../css/frame.css" />
        <link rel="stylesheet" type="text/css" href="../css/academico.css" />
        <%@page import="br.usp.poli.pece.bl.Usuario"%>
        <%@page import="br.usp.poli.pece.bl.Aluno"%>
        <%@page import="java.text.SimpleDateFormat"%>
    </head>
    <body>
        <%
            Usuario user = new Usuario();
            SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy");
            user.setSenha(request.getParameter("senha"));
            user.setLogin(request.getParameter("login"));
            user.setNome(request.getParameter("nome"));
            user.setEmail(request.getParameter("email"));
            user.setDataExpRg(dma.parse(request.getParameter("DataExpRg")));
            user.setCpf(Long.parseLong(request.getParameter("cpf")));        
            user.setDataNascimento(dma.parse(request.getParameter("data_nascimento")));
            
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
