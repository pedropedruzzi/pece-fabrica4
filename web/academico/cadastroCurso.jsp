<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" type="text/css" href="../css/frame.css" />
        <title>Cadastro</title>
    </head>
    <body>
        <h2>Preencha os dados abaixo</h2>
	    <form name="cadastramento" action="CadastraCurso" method="POST">
	        Nome:<br/><input type="text" name="nome" value="" size="50"/><br/>
	        C�dido do curso:<br/><input type="text" name="codCurso" value="" size="10" /><br/>
	        Carga hor�ria:<br/><input type="text" name="cargaHoraria" value="" size="4" /><br/>
            Id Professor Coordenador:<br/><input type="text" name="coordenador" value="" size="4" /><br/>
	        Descri��o:<br/><textarea name="descricao"></textarea><br/>
	        
	        <center><input type="submit" value="Enviar" name="enviar"/></center>
        </form>
    </body>
</html>
