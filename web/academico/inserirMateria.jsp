<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" type="text/css" href="../css/frame.css" />
        <%@page import="br.usp.poli.pece.db.DAOFactory"%>
		<%@page import="br.usp.poli.pece.db.DataBaseUtil"%>
		<%@page import="br.usp.poli.pece.bl.Curso"%>
		<%@page import="java.util.List"%>
        
        <title>Inserir Disciplina</title>
    </head>
    <body>
        <h2>Preencha os dados abaixo</h2>
	    <form name="cadastramento" action="CadastraMateria" method="POST">
	        Nome:<br/><input type="text" name="nome" value="" size="50"/><br/>
	        Códido da disciplina:<br/><input type="text" name="codDisciplina" value="" size="10" /><br/>
	        Carga horária:<br/><input type="short" name="cargaHoraria" value="" size="4" /><br/>
            Id Professor:<br/><input type="text" name="professor" value="" size="4" /><br/>
	        Descrição:<br/><textarea name="descricao"></textarea><br/>
	        Material de Apoio:<br/><textarea name="material"></textarea><br/>
	        	        Curso:<br/>
	        <select name="codCurso" size="1">
	        <%
	        DataBaseUtil.getSessionFactory().getCurrentSession().beginTransaction();
	        List<Curso> cursos = DAOFactory.getCursoDAO().findAll();
	        
	        for (Curso c : cursos) {
	        %>
	            <option value="<%= c.getCodCurso() %>"><%= c.getNome() %></option>
	        <%
	        
	        DataBaseUtil.getSessionFactory().getCurrentSession().close();
	        }
	        %>
	        </select><br/><br/>
	        <input type="submit" value="Inserir disciplina" name="enviar"/>
        </form>
    </body>
</html>
