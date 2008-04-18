<%@page contentType="text/html; charset=ISO-8859-1" %>
<%@page import="br.usp.poli.pece.bl.Matricula"%>
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
                <th>Matrícula</th>
                <th>Id Aluno</th>
                <th>Nome</th>
                <th>Status</th>
            </tr>
            <%
            List<Matricula> alunos = (List<Matricula>) request.getAttribute("matriculas");
            for (Matricula matricula : matriculas) {
            %>
            <tr>
                <td><%= matricula.getNumero() %></td>
                <td><%= matricula.getAluno().getId() %></td>
                <td><%= matricula.getAluno().getNome() %></td>
                <td><%= matricula.getStatus() %></td>
            </tr>
            <%
            }
            %>
        </table>
    </body>
</html>



