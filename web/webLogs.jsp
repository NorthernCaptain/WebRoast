<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{webLogs.page1}" id="page1">
            <ui:html binding="#{webLogs.html1}" id="html1">
                <ui:head binding="#{webLogs.head1}" id="head1">
                    <ui:link binding="#{webLogs.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{webLogs.body1}" id="body1" style="background-color: rgb(252, 242, 230); -rave-layout: grid">
                    <ui:form binding="#{webLogs.form1}" id="form1">
                        <div style="left: 0px; top: 0px; position: absolute">
                            <jsp:directive.include file="caption.jspf"/>
                        </div>
                        <div style="left: 0px; top: 100px; position: absolute">
                            <jsp:directive.include file="NavMenu.jspf"/>
                        </div>
                        <div style="left: 0px; top: 100px; position: absolute">
                            <jsp:directive.include file="UpperMenu.jspf"/>
                        </div>
                        <ui:table augmentTitle="false" binding="#{webLogs.table1}" id="table1" paginationControls="true"
                            style="height: 308px; left: 216px; top: 168px; position: absolute; width: 720px" title="Логи системы WebRoast" width="942">
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
                            <ui:tableRowGroup binding="#{webLogs.tableRowGroup1}" id="tableRowGroup1" sourceData="#{webLogs.v_weblogDataProvider}" sourceVar="currentRow">
                                <ui:tableColumn binding="#{webLogs.tableColumn1}" headerText="Дата" id="tableColumn1" sort="created" width="143">
                                    <ui:staticText binding="#{webLogs.staticText1}" id="staticText1" text="#{currentRow.value['created']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn binding="#{webLogs.tableColumn2}" headerText="Сообщение" id="tableColumn2" sort="msg" width="293">
                                    <ui:staticText binding="#{webLogs.staticText2}" id="staticText2" text="#{currentRow.value['msg']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn binding="#{webLogs.tableColumn3}" headerText="страница" id="tableColumn3" sort="screen_name">
                                    <ui:staticText binding="#{webLogs.staticText3}" id="staticText3" text="#{currentRow.value['screen_name']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn binding="#{webLogs.tableColumn4}" headerText="действие" id="tableColumn4" sort="msg_action">
                                    <ui:staticText binding="#{webLogs.staticText4}" id="staticText4" text="#{currentRow.value['msg_action']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn binding="#{webLogs.tableColumn5}" headerText="логин" id="tableColumn5" sort="user_name">
                                    <ui:staticText binding="#{webLogs.staticText5}" id="staticText5" text="#{currentRow.value['user_name']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn binding="#{webLogs.tableColumn6}" headerText="пользователь" id="tableColumn6" sort="user_full_name">
                                    <ui:staticText binding="#{webLogs.staticText6}" id="staticText6" text="#{currentRow.value['user_full_name']}"/>
                                </ui:tableColumn>
                            </ui:tableRowGroup>
                        </ui:table>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
