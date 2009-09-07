<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{Login.login}" id="login">
            <ui:html binding="#{Login.html1}" id="html1" lang="Russian">
                <ui:head binding="#{Login.head1}" id="head1" title="WebRoast Login">
                    <ui:link binding="#{Login.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{Login.body1}" id="body1" style="background-color: rgb(252, 242, 230); -rave-layout: grid">
                    <ui:form binding="#{Login.form1}" id="form1">
                        <div style="height: 101px; left: 1px; top: 0px; position: absolute; width: 952px">
                            <jsp:directive.include file="caption.jspf"/>
                        </div>
                        <ui:button action="#{Login.loginButton_action}" binding="#{Login.loginButton}" id="loginButton"
                            style="height: 24px; left: 407px; top: 336px; position: absolute; width: 96px" text="Войти"/>
                        <h:panelGrid binding="#{Login.gridPanel1}" cellpadding="5" cellspacing="5" columns="2" id="gridPanel1"
                            style="border: 2px solid rgb(255, 157, 41); height: 96px; left: 288px; top: 216px; position: absolute" width="336">
                            <ui:label binding="#{Login.label1}" for="userName" id="label1" requiredIndicator="true" styleClass="LblLev2Txt" text="Оператор:"/>
                            <ui:textField binding="#{Login.userName}" id="userName" required="true" style="height: 24px; width: 216px"/>
                            <ui:label binding="#{Login.label2}" for="userPassword" id="label2" requiredIndicator="true" styleClass="LblLev2Txt" text="Пароль:"/>
                            <ui:passwordField binding="#{Login.userPassword}" id="userPassword" required="true" style="height: 24px; width: 216px"/>
                        </h:panelGrid>
                        <h:panelGrid binding="#{Login.gridPanel2}" columns="2" id="gridPanel2" style="height: 74px; left: 288px; top: 144px; position: absolute" width="192">
                            <h:graphicImage binding="#{Login.image1}" id="image1" value="/resources/images/48/icon-user-keys.png"/>
                            <h:outputText binding="#{Login.outputText1}" id="outputText1" styleClass="LblLev1Txt" value="Вход в систему"/>
                        </h:panelGrid>
                        <ui:messageGroup binding="#{Login.messageGroup1}" id="messageGroup1" style="height: 94px; left: 288px; top: 384px; position: absolute; width: 334px"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
