<%@page import="br.usp.poli.pece.bl.Curso"%>
<%@page import="br.usp.poli.pece.db.DAOFactory"%>
<%@page import="br.usp.poli.pece.db.DataBaseUtil"%>
<%@page import="java.util.List"%>
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
            DataBaseUtil.getSessionFactory().getCurrentSession().beginTransaction();
            List<Curso> cursos = DAOFactory.getCursoDAO().findAll();
            for (Curso curso : cursos) {
            %>
            <tr>
                <td><%= curso.getCodCurso() %></td>
                <td><%= curso.getNome() %></td>
                <td><%= curso.getCargaHoraria() %></td>
                <td><%= curso.getCoordenador().getNome() %></td>
            </tr>
            <%
            }
            DataBaseUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
            %>
        </table>
    </body>
</html>
