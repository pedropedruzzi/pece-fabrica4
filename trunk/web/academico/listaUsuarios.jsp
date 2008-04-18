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
    <script type="text/javascript">
	<!--
	function del(id) {
		var answer = confirm("Você tem certeza que deseja excluir este usuário?")
        if (answer) {
            location.href = "RemoveUsuario?id=" + id
	    }
    }
	
	// -->
	</script>
        <table border='1'>
            <tr>
                <th>Tipo</th>
                <th>Id</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Login</th>
                <th>RG</th>
                <th>CPF</th>
                <th></th>
            </tr>
            
           	<select name="TipoUsuario">
				<option>Professor</option>
				<option>Aluno</option>
			</select>
			
            <%
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
            for (Usuario usuario : usuarios) {
            	String edit = "AlteraUsuario?id=" + usuario.getId();
            %>
            <tr>
                <td><a href="<%= edit %>"><%= usuario.getClass().getSimpleName() %></a></td>
                <td><a href="<%= edit %>"><%= usuario.getId() %></a></td>
                <td><a href="<%= edit %>"><%= usuario.getNome() %></a></td>
                <td><a href="<%= edit %>"><%= usuario.getEmail() %></a></td>
                <td><a href="<%= edit %>"><%= usuario.getLogin() %></a></td>
                <td><a href="<%= edit %>"><%= usuario.getRg() %></a></td>
                <td><a href="<%= edit %>"><%= usuario.getCpf() %></a></td>
                <td><a href="javascript:del(<%= usuario.getId() %>)"><small>(excluir)</small></a></td>
            </tr>
            <%
            }
            %>
        </table>
    </body>
</html>


