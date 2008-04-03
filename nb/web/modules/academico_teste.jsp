<?xml version="1.0" encoding="windows-1252"?>
<!-- 
    Document   : academico_teste
    Created on : 28/03/2008, 10:49:14
    Author     : Leonardo
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=windows-1252" pageEncoding="windows-1252"/>
    <f:view>
        <webuijsf:page binding="#{modules$academico_teste.page1}" id="page1">
            <webuijsf:html binding="#{modules$academico_teste.html1}" id="html1">
                <webuijsf:head binding="#{modules$academico_teste.head1}" id="head1">
                    <webuijsf:link binding="#{modules$academico_teste.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{modules$academico_teste.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{modules$academico_teste.form1}" id="form1">
                        <h:dataTable binding="#{modules$academico_teste.dataTable1}" headerClass="list-header" id="dataTable1"
                            rowClasses="list-row-even,list-row-odd" style="left: 24px; top: 72px; position: absolute"
                            value="#{modules$academico_teste.dataTable1Model}" var="currentRow">
                            <h:column binding="#{modules$academico_teste.coluna1}" id="coluna1">
                                <h:outputText binding="#{modules$academico_teste.outputText7}" id="outputText7"/>
                                <f:facet name="header">
                                    <h:outputText binding="#{modules$academico_teste.outputText8}" id="outputText8" value="coluna1"/>
                                </f:facet>
                            </h:column>
                        </h:dataTable>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
