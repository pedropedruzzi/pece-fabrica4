<%@page contentType="text/html; charset=ISO-8859-1" %>
<%@page import="br.usp.poli.pece.bl.Aluno"%>
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
                <th>Id</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Login</th>
                <th>RG</th>
                <th>CPF</th>
            </tr>
            <%
            List<Aluno> alunos = (List<Aluno>) request.getAttribute("alunos");
            for (Aluno aluno : alunos) {
            %>
            <tr>
                <td><%= aluno.getId() %></td>
                <td><%= aluno.getNome() %></td>
                <td><%= aluno.getEmail() %></td>
                <td><%= aluno.getLogin() %></td>
                <td><%= aluno.getRg() %></td>
                <td><%= aluno.getCpf() %></td>
            </tr>
            <%
            }
            %>
        </table>
    </body>
</html>


