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
            %>
            <tr>
                <td><%= usuario.getClass().getName() %></td>
                <td><%= usuario.getId() %></td>
                <td><%= usuario.getNome() %></td>
                <td><%= usuario.getEmail() %></td>
                <td><%= usuario.getLogin() %></td>
                <td><%= usuario.getRg() %></td>
                <td><%= usuario.getCpf() %></td>
            </tr>
            <%
            }
            %>
        </table>
    </body>
</html>


