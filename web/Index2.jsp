<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- 
    Document   : Index2
    Created on : 29/02/2008, 10:53:20
    Author     : labsoft_adm
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="ISO-8859-1"/>
    <f:view>
        <webuijsf:page binding="#{Index2.page1}" id="page1">
            <webuijsf:html binding="#{Index2.html1}" id="html1">
                <webuijsf:head binding="#{Index2.head1}" id="head1">
                    <webuijsf:link binding="#{Index2.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{Index2.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{Index2.form1}" id="form1"/>
                    <webuijsf:form binding="#{Index2.form2}" id="form2" style="height: 72px; left: 168px; top: 72px; position: absolute; width: 216px" target="POCInterface.jsp">
                        <webuijsf:button binding="#{Index2.button1}" id="button1" style="position: absolute; left: 144px; top: 48px" text="Botão"/>
                        <webuijsf:textField binding="#{Index2.textField1}" id="textField1" style="position: absolute; left: 144px; top: 0px" text="nome_aluno"/>
                        <webuijsf:textField binding="#{Index2.textField2}" id="textField2" style="left: 144px; top: 24px; position: absolute" text="end_aluno"/>
                        <webuijsf:staticText binding="#{Index2.staticText1}" id="staticText1" style="left: 72px; top: 0px; position: absolute" text="Nome:"/>
                        <webuijsf:staticText binding="#{Index2.staticText2}" id="staticText2" style="left: 72px; top: 24px; position: absolute" text="Endereco:"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
