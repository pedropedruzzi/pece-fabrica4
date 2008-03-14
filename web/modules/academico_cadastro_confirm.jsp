<!-- 
    Document   : academico_cadastro_confirm
    Created on : 07/03/2008, 00:47:06
    Author     : Leonardo
-->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>  
    <link rel="stylesheet" type="text/css" href="../css/frame.css" />
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
		%>
		<p>
		<%=request.getParameter("senha")%>
		<%=request.getParameter("login")%>
		<%=request.getParameter("nome")%>
		<%=request.getParameter("email")%>
		
		
		<%
		if(!user.cadastraUsuario()){
			out.println(user.ObtemUltimoErro());%>
			<p><a href="academico_main.html">Voltar</a></p>
		<%}
		else {%>
		  	<h2>Cadastro Realizado com sucesso</h2>
      		<p><a href="academico_main.html">Voltar</a></p>
		<%}%>		
      
  </body>
</html>
