<%--  @taglib prefix="f" url="http://java.sun.com/jsf/core" --%>
<%--  @taglib prefix="h" url="http://java.sun.com/jsf/html" --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/frame.css" />
        <title>Cadastro</title>
    </head>
    <body>
        <h2>Preencha os dados abaixo</h2>
        <form name="cadastramento" action="academico_cadastro_confirm.jsp" method="POST">
            <p>Tipo de cadastro: <select name="tipo" size="1">
                    <option selected> </option>
                    <option>Funcionário</option>
                    <option>Professor</option>
                    <option>Aluno</option>
                    </select>
            <p>Nome: <input type="text" name="nome" value="" size="50"/></p>
            <p>Email: <input type="text" name="email" value="" size="50" /></p>
            <p>Login: <input type="text" name="login" value="" size="20" /></p>
            <p>Senha: <input type="password" name="senha" value="" size="20" /></p>
            <p>CPF: <input type="text" name="cpf" value="" size="20" /></p>
            <p align="center"><input type="submit" value="Enviar" name="enviar"/></p>
            
        </form>
    </body>
</html>
