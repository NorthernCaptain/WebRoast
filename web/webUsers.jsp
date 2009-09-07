<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{webUsers.page1}" id="page1">
            <ui:html binding="#{webUsers.html1}" id="html1">
                <ui:head binding="#{webUsers.head1}" id="head1" title="WebRoast: Управление пользователями информационной системы">
                    <ui:link binding="#{webUsers.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{webUsers.body1}" id="body1" style="background-color: rgb(252, 242, 230); -rave-layout: grid">
                    <ui:form binding="#{webUsers.form1}" id="form1" virtualFormsConfig="AddUserVF | gridPanel7:gridPanel9:gridPanel12:gridPanel13:addNameField gridPanel7:gridPanel9:gridPanel12:gridPanel13:addPasswordField gridPanel7:gridPanel9:gridPanel12:gridPanel13:addFullNameField gridPanel7:gridPanel9:gridPanel12:gridPanel11:addPrivsGroup | gridPanel7:gridPanel10:addUserButton , RefreshVF | | gridPanel2:gridPanel3:refreshButton , UpdateGridVF | gridPanel2:table1:tableRowGroup1:tableColumn6:checkbox2 gridPanel2:table1:tableRowGroup1:tableColumn7:checkbox3 gridPanel2:table1:tableRowGroup1:tableColumn2:textField1 gridPanel2:table1:tableRowGroup1:tableColumn3:checkbox1 gridPanel2:table1:tableRowGroup1:tableColumn1:textField2 | gridPanel2:gridPanel3:commitButton , SelectedVF | gridPanel2:table1:tableRowGroup1:selectColumn:selectUserCheckBox gridPanel2:gridPanel3:gridPanel5:passwordField | gridPanel2:gridPanel3:deleteSelectedButton gridPanel2:gridPanel3:gridPanel5:passwordSetButton">
                        <div style="left: 0px; top: 0px; position: absolute">
                            <jsp:directive.include file="caption.jspf"/>
                        </div>
                        <div style="left: 0px; top: 100px; position: absolute">
                            <jsp:directive.include file="NavMenu.jspf"/>
                        </div>
                        <div style="left: 0px; top: 100px; position: absolute">
                            <jsp:directive.include file="UpperMenu.jspf"/>
                        </div>
                        <h:panelGrid binding="#{webUsers.gridPanel1}" columns="2" id="gridPanel1" style="left: 195px; top: 125px; position: absolute">
                            <h:graphicImage binding="#{webUsers.image1}" id="image1" value="/resources/images/48/icon-user-keys.png"/>
                            <h:outputText binding="#{webUsers.outputText1}" id="outputText1" style="font-size: 18px; font-weight: bold" value="Пользователи WebRoast"/>
                        </h:panelGrid>
                        <ui:messageGroup binding="#{webUsers.messageGroup1}" id="messageGroup1" style="left: 216px; top: 672px; position: absolute; width: 574px"/>
                        <h:panelGrid binding="#{webUsers.gridPanel2}" id="gridPanel2" style="left: 192px; top: 192px; position: absolute">
                            <ui:table binding="#{webUsers.table1}" id="table1" lite="true" paginationControls="true" style="height: 188px"
                                title="Список пользователей" width="855">
                                <script><![CDATA[
/* ----- Functions for Table Preferences Panel ----- */
/*
 * Toggle the table preferences panel open or closed
 */
function togglePreferencesPanel() {
  var table = document.getElementById("form1:table1");
  table.toggleTblePreferencesPanel();
}
/* ----- Functions for Filter Panel ----- */
/*
 * Return true if the filter menu has actually changed,
 * so the corresponding event should be allowed to continue.
 */
function filterMenuChanged() {
  var table = document.getElementById("form1:table1");
  return table.filterMenuChanged();
}
/*
 * Toggle the custom filter panel (if any) open or closed.
 */
function toggleFilterPanel() {
  var table = document.getElementById("form1:table1");
  return table.toggleTableFilterPanel();
}
/* ----- Functions for Table Actions ----- */
/*
 * Initialize all rows of the table when the state
 * of selected rows changes.
 */
function initAllRows() {
  var table = document.getElementById("form1:table1");
  table.initAllRows();
}
/*
 * Set the selected state for the given row groups
 * displayed in the table.  This functionality requires
 * the 'selectId' of the tableColumn to be set.
 *
 * @param rowGroupId HTML element id of the tableRowGroup component
 * @param selected Flag indicating whether components should be selected
 */
function selectGroupRows(rowGroupId, selected) {
  var table = document.getElementById("form1:table1");
  table.selectGroupRows(rowGroupId, selected);
}
/*
 * Disable all table actions if no rows have been selected.
 */
function disableActions() {
  // Determine whether any rows are currently selected
  var table = document.getElementById("form1:table1");
  var disabled = (table.getAllSelectedRowsCount() > 0) ? false : true;
  // Set disabled state for top actions
  document.getElementById("form1:table1:tableActionsTop:deleteTop").setDisabled(disabled);
  // Set disabled state for bottom actions
  document.getElementById("form1:table1:tableActionsBottom:deleteBottom").setDisabled(disabled);
}]]></script>
                                <ui:tableRowGroup binding="#{webUsers.tableRowGroup1}" id="tableRowGroup1" rows="5"
                                    sourceData="#{webUsers.webusersDataProvider}" sourceVar="currentRow">
                                    <ui:tableColumn binding="#{webUsers.selectColumn}" headerText="Отметить" id="selectColumn" width="97">
                                        <ui:checkbox binding="#{webUsers.selectUserCheckBox}" id="selectUserCheckBox" selected="#{webUsers.selectedUser}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn binding="#{webUsers.tableColumn1}" headerText="Логин" id="tableColumn1" sort="name" width="72">
                                        <ui:textField binding="#{webUsers.textField2}" id="textField2" style="width: 96px" text="#{currentRow.value['name']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn binding="#{webUsers.tableColumn2}" headerText="Имя пользователя" id="tableColumn2" sort="full_name" width="199">
                                        <ui:textField binding="#{webUsers.textField1}" id="textField1" style="width: 192px" text="#{currentRow.value['full_name']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn binding="#{webUsers.tableColumn6}" headerText="Админ" id="tableColumn6" sort="is_admin">
                                        <ui:checkbox binding="#{webUsers.checkbox2}" id="checkbox2" selected="#{currentRow.value['is_admin']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn binding="#{webUsers.tableColumn7}" headerText="Менеджер" id="tableColumn7" sort="is_manager" width="65">
                                        <ui:checkbox binding="#{webUsers.checkbox3}" id="checkbox3" selected="#{currentRow.value['is_manager']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn binding="#{webUsers.tableColumn3}" headerText="Запрещен" id="tableColumn3" sort="disabled" width="73">
                                        <ui:checkbox binding="#{webUsers.checkbox1}" id="checkbox1" selected="#{currentRow.value['disabled']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn binding="#{webUsers.tableColumn4}" headerText="Вход" id="tableColumn4" width="83">
                                        <ui:staticText binding="#{webUsers.staticText1}" id="staticText1" text="#{currentRow.value['last_login']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn binding="#{webUsers.tableColumn5}" headerText="Входов" id="tableColumn5" width="200">
                                        <ui:staticText binding="#{webUsers.staticText2}" id="staticText2" text="#{currentRow.value['total_logins']}"/>
                                    </ui:tableColumn>
                                </ui:tableRowGroup>
                            </ui:table>
                            <h:panelGrid binding="#{webUsers.gridPanel3}" columns="6" id="gridPanel3" style="">
                                <ui:button action="#{webUsers.refreshButton_action}" binding="#{webUsers.refreshButton}" id="refreshButton"
                                    style="height: 24px; width: 71px" text="Обновить"/>
                                <h:panelGrid binding="#{webUsers.gridPanel4}" id="gridPanel4" style="height: 22px" width="47"/>
                                <ui:button action="#{webUsers.commitButton_action}" binding="#{webUsers.commitButton}" id="commitButton"
                                    style="height: 24px; width: 119px" text="Внести изменения"/>
                                <ui:button action="#{webUsers.deleteSelectedButton_action}" binding="#{webUsers.deleteSelectedButton}" id="deleteSelectedButton"
                                    style="height: 24px; width: 143px" text="Удалить отмеченное"/>
                                <h:panelGrid binding="#{webUsers.gridPanel6}" id="gridPanel6" style="height: 24px" width="23"/>
                                <h:panelGrid binding="#{webUsers.gridPanel5}" cellspacing="2" columns="2" id="gridPanel5"
                                    style="border: 1px solid #ff9d29; height: 24px" width="287">
                                    <ui:passwordField binding="#{webUsers.passwordField}" id="passwordField" style="height: 24px; width: 120px"/>
                                    <ui:button action="#{webUsers.passwordSetButton_action}" binding="#{webUsers.passwordSetButton}" id="passwordSetButton"
                                        style="height: 24px; width: 143px" text="Установить пароль"/>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid binding="#{webUsers.gridPanel7}" id="gridPanel7"
                            style="border-width: 2px; border-style: solid; border-color: rgb(255, 157, 41) rgb(255, 157, 41) rgb(255, 157, 41) rgb(255, 157, 41); height: 144px; left: 264px; top: 480px; position: absolute" width="576">
                            <h:panelGrid binding="#{webUsers.gridPanel8}" columns="2" id="gridPanel8" style="height: 24px" width="119">
                                <h:graphicImage binding="#{webUsers.image2}" id="image2" value="/resources/images/32/personal.png"/>
                                <h:outputText binding="#{webUsers.outputText2}" id="outputText2" style="font-size: 14px; font-weight: bold" value="Новый Web пользователь"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{webUsers.gridPanel9}" id="gridPanel9" style="width: 100%; height: 100%;">
                                <h:panelGrid binding="#{webUsers.gridPanel12}" columns="3" id="gridPanel12" style="width: 100%; height: 100%;">
                                    <h:panelGrid binding="#{webUsers.gridPanel14}" id="gridPanel14" width="143">
                                        <ui:label binding="#{webUsers.label1}" for="addNameField" id="label1" requiredIndicator="true" text="Логин:"/>
                                        <ui:label binding="#{webUsers.label2}" for="addFullNameField" id="label2" requiredIndicator="true" text="Имя пользователя:"/>
                                        <ui:label binding="#{webUsers.label3}" for="addPasswordField" id="label3" requiredIndicator="true" text="Пароль:"/>
                                    </h:panelGrid>
                                    <h:panelGrid binding="#{webUsers.gridPanel13}" id="gridPanel13" style="">
                                        <ui:textField binding="#{webUsers.addNameField}" id="addNameField" style="width: 240px"/>
                                        <ui:textField binding="#{webUsers.addFullNameField}" id="addFullNameField" style="width: 240px"/>
                                        <ui:passwordField binding="#{webUsers.addPasswordField}" id="addPasswordField" style="width: 240px"/>
                                    </h:panelGrid>
                                    <h:panelGrid binding="#{webUsers.gridPanel11}" id="gridPanel11" style="height: 100%; width: 100%">
                                        <ui:staticText binding="#{webUsers.staticText4}" id="staticText4" style="font-weight: bold; text-decoration: underline" text="Права доступа"/>
                                        <ui:checkboxGroup binding="#{webUsers.addPrivsGroup}" id="addPrivsGroup" items="#{webUsers.addPrivsGroupDefaultOptions.options}"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{webUsers.gridPanel10}" id="gridPanel10" style="height: 26px; width: 100%">
                                <ui:button action="#{webUsers.addUserButton_action}" binding="#{webUsers.addUserButton}" id="addUserButton"
                                    style="height: 24px; width: 95px" text="Добавить"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
