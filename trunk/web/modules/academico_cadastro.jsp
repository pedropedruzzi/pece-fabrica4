<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" type="text/css" href="../css/frame.css" />
        <title>Cadastro</title>
    </head>
    <body>
        <h2>Preencha os dados abaixo</h2>
	    <form name="cadastramento" action="../academico/CadastraUsuario" method="POST">
	        Tipo de cadastro: <select name="tipo">
	            <option value="Funcionario">Funcionário</option>
	            <option value="Professor">Professor</option>
	            <option value="Aluno" selected>Aluno</option>
	        </select><br/>
	        
	        Nome:<br/><input type="text" name="nome" value="" size="50"/><br/>
	        Email:<br/><input type="text" name="email" value="" size="50" /><br/>
	        Login:<br/><input type="text" name="login" value="" size="20" /><br/>
	        Senha:<br/><input type="password" name="senha" value="" size="20" /><br/>
	        RG:<br/><input type="text" name="RG" value="" size="20" /><br/>
	        Data Exp.:<br/><input type="text" name="DataExpRg" value="" size="20" /><br/>
	        CPF:<br/><input type="text" name="cpf" value="" size="20" /><br/>
	        Data de Nascimento<br/><input type="text" name="data_nascimento" value="" size="20" /><br/>
	        Local Nascimento<br/><input type="text" name="local_nascimento" value="" size="20" /><br/>
	        Nome Mae:<br/><input type="text" name="nome_mae" value="" size="20" /><br/>
	        Endereço:<br/><input type="text" name="endereco" value="" size="20" /><br/>
	        CEP:<br/><input type="text" name="cep" value="" size="20" /><br/>
	        Cidade:<br/><input type="text" name="cidade" value="" size="20" /><br/>
	        UF:<br/><input type="text" name="uf" value="" size="20" /><br/>
	        Telefone:<br/><input type="text" name="telefone" value="" size="20" /><br/>
	        Celular:<br/><input type="text" name="celular" value="" size="20" /><br/>
	        
	        <center><input type="submit" value="Enviar" name="enviar"/></center>
        </form>
    </body>
</html>
