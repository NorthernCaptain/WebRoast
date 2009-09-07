<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{UnderContruction.page1}" id="page1">
            <ui:html binding="#{UnderContruction.html1}" id="html1">
                <ui:head binding="#{UnderContruction.head1}" id="head1">
                    <ui:link binding="#{UnderContruction.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{UnderContruction.body1}" id="body1" style="background-color: rgb(252, 242, 230); -rave-layout: grid">
                    <ui:form binding="#{UnderContruction.form1}" id="form1">
                        <div style="left: 0px; top: 0px; position: absolute">
                            <jsp:directive.include file="caption.jspf"/>
                        </div>
                        <ui:button action="#{UnderContruction.backButton_action}" binding="#{UnderContruction.backButton}" id="backButton"
                            style="height: 24px; left: 311px; top: 504px; position: absolute; width: 120px" text="Вернуться"/>
                        <h:outputText binding="#{UnderContruction.outputText1}" id="outputText1"
                            style="font-size: 18px; font-weight: bold; left: 216px; top: 120px; position: absolute" value="Страница находится в разработке"/>
                        <h:panelGrid binding="#{UnderContruction.gridPanel1}" id="gridPanel1" style="height: 314px; left: 240px; top: 168px; position: absolute" width="264">
                            <h:graphicImage binding="#{UnderContruction.image1}" id="image1" value="/resources/images/monster.jpg"/>
                        </h:panelGrid>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
