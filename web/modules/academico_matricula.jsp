<%@page contentType="text/html; charset=ISO-8859-1" %>
<%@page import="br.usp.poli.pece.db.DAOFactory"%>
<%@page import="br.usp.poli.pece.db.DataBaseUtil"%>
<%@page import="br.usp.poli.pece.bl.Curso"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" type="text/css" href="../css/frame.css" />
        <link rel="stylesheet" type="text/css" href="../css/academico.css" />
        <title>Matricula</title>
    </head>
    <body>
        <h2>Preencha os dados abaixo</h2>
	    <form name="cadastramento" action="../academico/MatriculaAluno" method="post">
	        Id Aluno:<br/>
	        <input type="text" name="idAluno" value="" size="10"/><br/><br/>
	        
	        Curso:<br/>
	        <select name="codCurso" size="1">
	        <%
	        DataBaseUtil.getSessionFactory().getCurrentSession().beginTransaction();
	        List<Curso> cursos = DAOFactory.getCursoDAO().findAll();
	        
	        for (Curso c : cursos) {
	        %>
	            <option value="<%= c.getCodCurso() %>"><%= c.getNome() %></option>
	        <%
	        
	        DataBaseUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
	        }
	        %>
	        </select><br/><br/>
	        <input type="submit" value="Efetuar Matrícula" name="enviar"/>
        </form>
    </body>
</html>
