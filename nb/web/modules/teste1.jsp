<?xml version="1.0" encoding="windows-1252"?>
<!-- 
    Document   : teste1
    Created on : 28/03/2008, 09:38:06
    Author     : Leonardo
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=windows-1252" pageEncoding="windows-1252"/>
    <f:view>
        <webuijsf:page binding="#{modules$teste1.page1}" id="page1">
            <webuijsf:html binding="#{modules$teste1.html1}" id="html1">
                <webuijsf:head binding="#{modules$teste1.head1}" id="head1">
                    <webuijsf:link binding="#{modules$teste1.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{modules$teste1.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{modules$teste1.form1}" id="form1">
                        <h:dataTable binding="#{modules$teste1.dataTable1}" headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd"
                            style="position: absolute; left: 216px; top: 216px" value="#{modules$teste1.dataTable1Model}" var="currentRow">
                            <h:column binding="#{modules$teste1.column1}" id="column1">
                                <h:outputText binding="#{modules$teste1.outputText1}" id="outputText1" value="#{currentRow['COLUMN1']}"/>
                                <f:facet name="header">
                                    <h:outputText binding="#{modules$teste1.outputText2}" id="outputText2" value="coluna1"/>
                                </f:facet>
                            </h:column>
                            <h:column binding="#{modules$teste1.column2}" id="column2">
                                <h:outputText binding="#{modules$teste1.outputText3}" id="outputText3" value="#{currentRow['COLUMN2']}"/>
                                <f:facet name="header">
                                    <h:outputText binding="#{modules$teste1.outputText4}" id="outputText4" value="coluna2"/>
                                </f:facet>
                            </h:column>
                            <h:column binding="#{modules$teste1.column3}" id="column3">
                                <h:outputText binding="#{modules$teste1.outputText5}" id="outputText5" value="#{currentRow['COLUMN3']}"/>
                                <f:facet name="header">
                                    <h:outputText binding="#{modules$teste1.outputText6}" id="outputText6" value="coluna3"/>
                                </f:facet>
                            </h:column>
                        </h:dataTable>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
