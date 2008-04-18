<%@page import="br.usp.poli.pece.bl.Curso"%>
<%@page import="java.util.List"%>

<%@page import="br.usp.poli.pece.db.CursoDAO"%>
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
                <th>Cod</th>
                <th>Nome</th>
                <th>Carga</th>
                <th>Coordenador</th>
            </tr>
            <%
            List<Curso> lista = (List<Curso>) request.getAttribute("cursos");
            for (Curso curso : lista) {
            %>
            <tr>
                <td><%= curso.getCodCurso() %></td>
                <td><%= curso.getNome() %></td>
                <td><%= curso.getCargaHoraria() %></td>
                <td><%= curso.getCoordenador() %></td>
            </tr>
            <%
            }
            %>
        </table>
    </body>
</html>
