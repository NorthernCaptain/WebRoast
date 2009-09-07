<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{root_utilsdir_operators.page1}" id="page1">
            <ui:html binding="#{root_utilsdir_operators.html1}" id="html1">
                <ui:head binding="#{root_utilsdir_operators.head1}" id="head1">
                    <ui:link binding="#{root_utilsdir_operators.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{root_utilsdir_operators.body1}" id="body1" style="background-color: rgb(252, 242, 230); -rave-layout: grid">
                    <ui:form binding="#{root_utilsdir_operators.form1}" id="form1">
                        <div style="left: 0px; top: 0px; position: absolute">
                            <jsp:directive.include file="caption.jspf"/>
                        </div>
                        <div style="left: 0px; top: 100px; position: absolute">
                            <jsp:directive.include file="UpperMenu.jspf"/>
                        </div>
                        <div style="left: 0px; top: 100px; position: absolute">
                            <jsp:directive.include file="NavMenu.jspf"/>
                        </div>
                        <h:panelGrid binding="#{root_utilsdir_operators.gridPanel1}" columns="2" id="gridPanel1" style="left: 195px; top: 125px; position: absolute">
                            <h:graphicImage binding="#{root_utilsdir_operators.image1}" id="image1" value="/resources/images/48/personal.png"/>
                            <h:outputText binding="#{root_utilsdir_operators.outputText1}" id="outputText1" style="font-size: 18px; font-weight: bold" value="Операторы обжарки"/>
                        </h:panelGrid>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
