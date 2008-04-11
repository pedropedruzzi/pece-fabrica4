<%@page import="br.usp.poli.pece.bl.Professor"%>
<%@page import="br.usp.poli.pece.bl.Funcionario"%>
<%@page import="br.usp.poli.pece.bl.Usuario"%>
<%@page import="br.usp.poli.pece.bl.Aluno"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>
    
    <head>  
        <link rel="stylesheet" type="text/css" href="../css/frame.css" />
        <link rel="stylesheet" type="text/css" href="../css/academico.css" />
    </head>
    <body>
        <%
        try {
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
            
            if (!user.cadastraUsuario()) throw new RuntimeException(user.ObtemUltimoErro());
        } catch (Exception e) {
        	e.printStackTrace();
	        %>
	        O seguinte erro ocorreu ao tentar realizar o cadastro: <%= e.getMessage() %><br>
	        Por favor, entre em contato com o administrador do sistema.
	        <p><a href="academico_main.html">Voltar</a></p>
	        <%
	        return;
        }
        %>
        <h2>Cadastro Realizado com sucesso</h2>
        <p><a href="academico_main.html">Voltar</a></p>
        
    </body>
</html>
