<%-- 
    Document   : teste
    Created on : 28/03/2008, 09:09:40
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%@page import="br.usp.poli.pece.bl.Usuario"%>
        <%@page import="br.usp.poli.pece.bl.Aluno"%>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>

<f:view>
    <h:form>
        <h1><h:outputText value="List"/></h1>
        <h:dataTable value="#{arrayOrCollectionOf}" var="item">
        </h:dataTable>
    </h:form>
</f:view>


    </body>
</html>
