<%@page contentType="text/html; charset=ISO-8859-1" %>
<%@page import="br.usp.poli.pece.bl.Usuario"%>
<%@page import="java.util.List"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" type="text/css" href="../css/frame.css" />
        <link rel="stylesheet" type="text/css" href="../css/academico.css" />
    </head>
    <body>
        <table border='1'>
            <tr>
                <th>Tipo</th>
                <th>Id</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Login</th>
                <th>RG</th>
                <th>CPF</th>
            </tr>
            <%
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
            for (Usuario usuario : usuarios) {
            	String link = "AlteraUsuario?id=" + usuario.getId();
            %>
            <tr>
                <td><a href="<%= link %>"><%= usuario.getClass().getSimpleName() %></a></td>
                <td><a href="<%= link %>"><%= usuario.getId() %></a></td>
                <td><a href="<%= link %>"><%= usuario.getNome() %></a></td>
                <td><a href="<%= link %>"><%= usuario.getEmail() %></a></td>
                <td><a href="<%= link %>"><%= usuario.getLogin() %></a></td>
                <td><a href="<%= link %>"><%= usuario.getRg() %></a></td>
                <td><a href="<%= link %>"><%= usuario.getCpf() %></a></td>
            </tr>
            <%
            }
            %>
        </table>
    </body>
</html>


