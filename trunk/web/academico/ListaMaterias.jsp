<%@page contentType="text/html; charset=ISO-8859-1" %>
<%@page import="br.usp.poli.pece.bl.Disciplina"%>
<%@page import="java.util.List"%>
<%@page import="br.usp.poli.pece.db.DAOFactory"%>
<%@page import="br.usp.poli.pece.db.DataBaseUtil"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" type="text/css" href="../css/frame.css" />
        <link rel="stylesheet" type="text/css" href="../css/academico.css" />
    </head>
    <body>
        <table border='1'>
            <tr>
                <th>Cod</th>
                <th>Disciplina</th>
                <th>Descrição</th>
            </tr>
            
            <%
            DataBaseUtil.getSessionFactory().getCurrentSession().beginTransaction();
            List<Disciplina> materia = DAOFactory.getDisciplinaDAO().findAll();
            for (Disciplina disciplina : materia) {
            %>
            <tr>
                <td><%= disciplina.getCodDisciplina() %></td>
                <td><%= disciplina.getNome() %></td>
                <td><%= disciplina.getDescricao() %></td>

            </tr>
            <%
            }
            DataBaseUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
            %>
        </table>
    </body>
</html>