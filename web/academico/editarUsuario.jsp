<%@page import="br.usp.poli.pece.bl.Usuario"%>
<%@page import="java.text.DateFormat"%>
<%@page import="br.usp.poli.pece.bl.Util"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" type="text/css" href="../css/frame.css" />
        <title>Cadastro</title>
    </head>
    <body>
        <h2>Altere os campos e clique em Atualizar</h2>
        <%
        final DateFormat df = Util.getDateFormat();
        final Usuario u = (Usuario) request.getAttribute("usuario");
        %>
	    <form name="cadastramento" action="../academico/CadastraUsuario" method="POST">
	        <input type="hidden" name="id" value="<%= u.getId() %>" />
	        Nome:<br/><input type="text" name="nome" value="<%= Util.fieldValue(u.getNome()) %>" size="50"/><br/>
	        Email:<br/><input type="text" name="email" value="<%= Util.fieldValue(u.getEmail()) %>" size="50" /><br/>
	        Login:<br/><input type="text" name="login" value="<%= Util.fieldValue(u.getLogin()) %>" size="20" /><br/>
	        Senha:<br/><input type="password" name="senha" value="<%= Util.fieldValue(u.getSenha()) %>" size="20" /><br/>
	        RG:<br/><input type="text" name="RG" value="<%= Util.fieldValue(u.getRg()) %>" size="20" /><br/>
	        Data Exp.:<br/><input type="text" name="DataExpRg" value="<%= df.format(u.getDataExpRg()) %>" size="20" /><br/>
	        CPF:<br/><input type="text" name="cpf" value="<%= Util.fieldValue(u.getCpf()) %>" size="20" /><br/>
	        Data de Nascimento<br/><input type="text" name="data_nascimento" value="<%= df.format(u.getDataNascimento()) %>" size="20" /><br/>
	        Local Nascimento<br/><input type="text" name="local_nascimento" value="<%= Util.fieldValue(u.getLocalNascimento()) %>" size="20" /><br/>
	        Nome Mae:<br/><input type="text" name="nome_mae" value="<%= Util.fieldValue(u.getNomeMae()) %>" size="20" /><br/>
	        Endereço:<br/><input type="text" name="endereco" value="<%= Util.fieldValue(u.getRuaEndereco()) %>" size="20" /><br/>
	        CEP:<br/><input type="text" name="cep" value="<%= Util.fieldValue(u.getCep()) %>" size="20" /><br/>
	        Cidade:<br/><input type="text" name="cidade" value="<%= Util.fieldValue(u.getCidade()) %>" size="20" /><br/>
	        UF:<br/><input type="text" name="uf" value="<%= Util.fieldValue(u.getUf()) %>" size="20" /><br/>
	        Telefone:<br/><input type="text" name="telefone" value="<%= u.getTelefone() %>" size="20" /><br/>
	        Celular:<br/><input type="text" name="celular" value="<%= u.getCelular() %>" size="20" /><br/>
	        
	        <center><input type="submit" value="update" name="Atualizar"/></center>
        </form>
    </body>
</html>
