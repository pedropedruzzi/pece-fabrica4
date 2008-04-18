<%@page contentType="text/html; charset=ISO-8859-1" %>
<%@page import="br.usp.poli.pece.bl.Usuario"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" type="text/css" href="../css/frame.css" />
        <link rel="stylesheet" type="text/css" href="../css/academico.css" />
    </head>
    <body>
        <%
        Usuario usuario = (Usuario)request.getAttribute("usuario");
        %>
        <h2>O usuário '<%= usuario.getNome() %>' foi cadastrado/atualizado com sucesso!</h2><br>
        <a href="../modules/academico_main.html">Voltar</a>
    </body>
</html>
