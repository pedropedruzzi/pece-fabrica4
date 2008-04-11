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
            user.setCpf(Long.parseLong(request.getParameter("cpf"));        
            user.setDataNascimento(dma.parse(request.getParameter("data_nascimento")))
            
        <p>CPF: <input type="text" name="cpf" value="" size="20" /></p>
        <p>Data de Nascimento <input type="text" name="data_nascimento" value="" size="20" /></p>
        <p>Local Nascimento <input type="text" name="local_nascimento" value="" size="20" /></p>
        <p>Nome Mae <input type="text" name="nome_mae" value="" size="20" /></p>
        <p>Endereço<input type="text" name="endereco" value="" size="20" /></p>
        <p>CEP <input type="text" name="cep" value="" size="20" /></p>
        <p>Cidade <input type="text" name="cidade" value="" size="20" /></p>
        <p>UF <input type="text" name="uf" value="" size="20" /></p>
        <p>Telefone <input type="text" name="telefone" value="" size="20" /></p>
        <p>Celular <input type="text" name="celular" value="" size="20" /></p>
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
