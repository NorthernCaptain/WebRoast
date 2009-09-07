<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{MyStart.page1}" id="page1">
            <ui:html binding="#{MyStart.html1}" id="html1">
                <ui:head binding="#{MyStart.head1}" id="head1" title="WebRoast: Общая информация">
                    <ui:link binding="#{MyStart.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{MyStart.body1}" id="body1" style="background-color: rgb(252, 242, 230); -rave-layout: grid">
                    <ui:form binding="#{MyStart.form1}" id="form1">
                        <div style="height: 99px; left: 0px; top: 0px; position: absolute; width: 864px">
                            <jsp:directive.include file="caption.jspf"/>
                        </div>
                        <div style="height: 24px; left: 0px; top: 100px; position: absolute; width: 863px">
                            <jsp:directive.include file="UpperMenu.jspf"/>
                        </div>
                        <div style="height: 378px; left: 0px; top: 100px; position: absolute; width: 166px">
                            <jsp:directive.include file="NavMenu.jspf"/>
                        </div>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
