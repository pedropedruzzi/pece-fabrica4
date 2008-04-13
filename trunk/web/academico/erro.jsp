<%@page contentType="text/html; charset=ISO-8859-1" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" type="text/css" href="../css/frame.css" />
        <link rel="stylesheet" type="text/css" href="../css/academico.css" />
    </head>
    <body>
        <b>Atenção!<br/>O seguinte erro ocorreu ao processar sua requisição:</b><br/><%= request.getAttribute("erro") %><br/><br/>
        Por favor, contate o administrador do sistema.<br/><br/><br/>
        <a href="javascript:history.back()">Voltar</a>
    </body>
</html>
