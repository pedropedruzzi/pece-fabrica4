<%@page import="br.usp.poli.pece.bl.Aluno"%>
<%@page import="java.util.List"%>

<%@page import="br.usp.poli.pece.db.UsuarioDAO"%>
<%@page import="br.usp.poli.pece.db.DAOFactory"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/frame.css" />
        <link rel="stylesheet" type="text/css" href="../css/academico.css" />
    </head>
    <body>
        <table border='1'>
            <tr>
                <th>Nome</th>
                <th>Data</th>
                <th>Matrícula</th>
                <th>RG</th>
                <th>CPF</th>
            </tr>
            <%
            List<Aluno> lista = DAOFactory.getAlunoDAO().findAll();
            for (Aluno aluno : lista) {
            %>
            <tr>
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
