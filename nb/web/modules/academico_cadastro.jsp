

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/frame.css" />
        <link rel="stylesheet" type="text/css" href="../css/academico.css" />
        <title>Cadastro</title>
    </head>
    <body>
        <h2>Preencha os dados abaixo</h2>
        <form name="cadastramento" action="academico_cadastro_confirm.jsp" method="POST">
        <p>Tipo de cadastro: <select name="tipo" size="1">
            <option>Funcionário</option>
            <option>Professor</option>
            <option selected>Aluno</option>
        </select>
        <p class="academico">Nome: <input type="text" name="nome" value="" size="50"/></p>
        <p>Email: <input type="text" name="email" value="" size="50" /></p>
        <p>Login: <input type="text" name="login" value="" size="20" /></p>
        <p>Senha: <input type="password" name="senha" value="" size="20" /></p>
        <p>RG: <input type="text" name="RG" value="" size="20" /></p>
        <p>Data Exp.: <input type="text" name="DataExpRg" value="" size="20" /></p>
        <p>CPF: <input type="text" name="cpf" value="" size="20" /></p>
        <p>Data de Nascimento <input type="text" name="data_nascimento" value="" size="20" /></p>
        <p>Local Nascimento <input type="text" name="local_nascimento" value="" size="20" /></p>
        <p>Nome Mae <input type="text" name="nome_mae" value="" size="20" /></p>
        <p>Endereço<input type="text" name="endereco" value="" size="20" /></p>
        <p>CEP <input type="text" name="cep" value="" size="20" /></p>
        <p>Cidade <input type="text" name="cidade" value="" size="20" /></p>
        <p>UF <input type="text" name="uf" value="" size="20" /></p>
        <p>Telefone <input type="text" name="telefone" value="" size="20" /></p>
        <p>Celular <input type="text" name="celular" value="" size="20" /></p>
        
        <p align="center"><input type="submit" value="Enviar" name="enviar"/></p>
    </body>
</html>
