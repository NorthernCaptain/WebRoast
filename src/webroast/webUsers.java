/*
 * webUsers.java
 *
 * Created on 15 Апрель 2006 г., 16:48
 * Copyright Leo
 */
package webroast;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.Body;
import com.sun.rave.web.ui.component.Form;
import com.sun.rave.web.ui.component.Head;
import com.sun.rave.web.ui.component.Html;
import com.sun.rave.web.ui.component.Link;
import com.sun.rave.web.ui.component.Page;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlOutputText;
import com.sun.data.provider.impl.CachedRowSetDataProvider;
import com.sun.data.provider.impl.TableRowDataProvider;
import com.sun.rave.web.ui.component.Table;
import com.sun.rave.web.ui.component.TableRowGroup;
import com.sun.rave.web.ui.component.TableColumn;
import com.sun.rave.web.ui.component.StaticText;
import com.sun.rave.web.ui.component.Checkbox;
import com.sun.rave.web.ui.component.TextField;
import java.util.HashSet;
import java.util.Set;
import com.sun.rave.web.ui.component.MessageGroup;
import com.sun.rave.web.ui.component.Button;
import java.util.Iterator;
import com.sun.rave.web.ui.component.PasswordField;
import com.sun.rave.web.ui.component.CheckboxGroup;
import com.sun.rave.web.ui.model.MultipleSelectOptionsList;
import com.sun.rave.web.ui.component.Label;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class webUsers extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Creator-managed Component Definition">
    private int __placeholder;
    
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        webusersDataProvider.setCachedRowSet((javax.sql.rowset.CachedRowSet)getValue("#{SessionBean1.webusersRowSet}"));
        addPrivsGroupDefaultOptions.setOptions(new com.sun.rave.web.ui.model.Option[] {new com.sun.rave.web.ui.model.Option("manager", "Менеджер"), new com.sun.rave.web.ui.model.Option("admin", "Админ")});
    }
    
    private Page page1 = new Page();
    
    public Page getPage1() {
        return page1;
    }
    
    public void setPage1(Page p) {
        this.page1 = p;
    }
    
    private Html html1 = new Html();
    
    public Html getHtml1() {
        return html1;
    }
    
    public void setHtml1(Html h) {
        this.html1 = h;
    }
    
    private Head head1 = new Head();
    
    public Head getHead1() {
        return head1;
    }
    
    public void setHead1(Head h) {
        this.head1 = h;
    }
    
    private Link link1 = new Link();
    
    public Link getLink1() {
        return link1;
    }
    
    public void setLink1(Link l) {
        this.link1 = l;
    }
    
    private Body body1 = new Body();
    
    public Body getBody1() {
        return body1;
    }
    
    public void setBody1(Body b) {
        this.body1 = b;
    }
    
    private Form form1 = new Form();
    
    public Form getForm1() {
        return form1;
    }
    
    public void setForm1(Form f) {
        this.form1 = f;
    }

    private HtmlPanelGrid gridPanel1 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel1() {
        return gridPanel1;
    }

    public void setGridPanel1(HtmlPanelGrid hpg) {
        this.gridPanel1 = hpg;
    }

    private HtmlGraphicImage image1 = new HtmlGraphicImage();

    public HtmlGraphicImage getImage1() {
        return image1;
    }

    public void setImage1(HtmlGraphicImage hgi) {
        this.image1 = hgi;
    }

    private HtmlOutputText outputText1 = new HtmlOutputText();

    public HtmlOutputText getOutputText1() {
        return outputText1;
    }

    public void setOutputText1(HtmlOutputText hot) {
        this.outputText1 = hot;
    }

    private CachedRowSetDataProvider webusersDataProvider = new CachedRowSetDataProvider();

    public CachedRowSetDataProvider getWebusersDataProvider() {
        return webusersDataProvider;
    }

    public void setWebusersDataProvider(CachedRowSetDataProvider crsdp) {
        this.webusersDataProvider = crsdp;
    }

    private Table table1 = new Table();

    public Table getTable1() {
        return table1;
    }

    public void setTable1(Table t) {
        this.table1 = t;
    }

    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }

    private TableColumn tableColumn1 = new TableColumn();

    public TableColumn getTableColumn1() {
        return tableColumn1;
    }

    public void setTableColumn1(TableColumn tc) {
        this.tableColumn1 = tc;
    }

    private TableColumn tableColumn2 = new TableColumn();

    public TableColumn getTableColumn2() {
        return tableColumn2;
    }

    public void setTableColumn2(TableColumn tc) {
        this.tableColumn2 = tc;
    }

    private TableColumn tableColumn3 = new TableColumn();

    public TableColumn getTableColumn3() {
        return tableColumn3;
    }

    public void setTableColumn3(TableColumn tc) {
        this.tableColumn3 = tc;
    }

    private Checkbox checkbox1 = new Checkbox();

    public Checkbox getCheckbox1() {
        return checkbox1;
    }

    public void setCheckbox1(Checkbox c) {
        this.checkbox1 = c;
    }

    private TableColumn selectColumn = new TableColumn();

    public TableColumn getSelectColumn() {
        return selectColumn;
    }

    public void setSelectColumn(TableColumn tc) {
        this.selectColumn = tc;
    }

    private Checkbox selectUserCheckBox = new Checkbox();

    public Checkbox getSelectUserCheckBox() {
        return selectUserCheckBox;
    }

    public void setSelectUserCheckBox(Checkbox c) {
        this.selectUserCheckBox = c;
    }

    private TextField textField1 = new TextField();

    public TextField getTextField1() {
        return textField1;
    }

    public void setTextField1(TextField tf) {
        this.textField1 = tf;
    }

    private MessageGroup messageGroup1 = new MessageGroup();

    public MessageGroup getMessageGroup1() {
        return messageGroup1;
    }

    public void setMessageGroup1(MessageGroup mg) {
        this.messageGroup1 = mg;
    }

    private Button commitButton = new Button();

    public Button getCommitButton() {
        return commitButton;
    }

    public void setCommitButton(Button b) {
        this.commitButton = b;
    }

    private Button deleteSelectedButton = new Button();

    public Button getDeleteSelectedButton() {
        return deleteSelectedButton;
    }

    public void setDeleteSelectedButton(Button b) {
        this.deleteSelectedButton = b;
    }

    private HtmlPanelGrid gridPanel2 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel2() {
        return gridPanel2;
    }

    public void setGridPanel2(HtmlPanelGrid hpg) {
        this.gridPanel2 = hpg;
    }

    private HtmlPanelGrid gridPanel3 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel3() {
        return gridPanel3;
    }

    public void setGridPanel3(HtmlPanelGrid hpg) {
        this.gridPanel3 = hpg;
    }

    private Button refreshButton = new Button();

    public Button getRefreshButton() {
        return refreshButton;
    }

    public void setRefreshButton(Button b) {
        this.refreshButton = b;
    }

    private HtmlPanelGrid gridPanel4 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel4() {
        return gridPanel4;
    }

    public void setGridPanel4(HtmlPanelGrid hpg) {
        this.gridPanel4 = hpg;
    }

    private TableColumn tableColumn6 = new TableColumn();

    public TableColumn getTableColumn6() {
        return tableColumn6;
    }

    public void setTableColumn6(TableColumn tc) {
        this.tableColumn6 = tc;
    }

    private Checkbox checkbox2 = new Checkbox();

    public Checkbox getCheckbox2() {
        return checkbox2;
    }

    public void setCheckbox2(Checkbox c) {
        this.checkbox2 = c;
    }

    private TableColumn tableColumn7 = new TableColumn();

    public TableColumn getTableColumn7() {
        return tableColumn7;
    }

    public void setTableColumn7(TableColumn tc) {
        this.tableColumn7 = tc;
    }

    private Checkbox checkbox3 = new Checkbox();

    public Checkbox getCheckbox3() {
        return checkbox3;
    }

    public void setCheckbox3(Checkbox c) {
        this.checkbox3 = c;
    }

    private HtmlPanelGrid gridPanel5 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel5() {
        return gridPanel5;
    }

    public void setGridPanel5(HtmlPanelGrid hpg) {
        this.gridPanel5 = hpg;
    }

    private PasswordField passwordField = new PasswordField();

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(PasswordField pf) {
        this.passwordField = pf;
    }

    private Button passwordSetButton = new Button();

    public Button getPasswordSetButton() {
        return passwordSetButton;
    }

    public void setPasswordSetButton(Button b) {
        this.passwordSetButton = b;
    }

    private HtmlPanelGrid gridPanel6 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel6() {
        return gridPanel6;
    }

    public void setGridPanel6(HtmlPanelGrid hpg) {
        this.gridPanel6 = hpg;
    }

    private TextField textField2 = new TextField();

    public TextField getTextField2() {
        return textField2;
    }

    public void setTextField2(TextField tf) {
        this.textField2 = tf;
    }

    private HtmlPanelGrid gridPanel7 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel7() {
        return gridPanel7;
    }

    public void setGridPanel7(HtmlPanelGrid hpg) {
        this.gridPanel7 = hpg;
    }

    private HtmlPanelGrid gridPanel8 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel8() {
        return gridPanel8;
    }

    public void setGridPanel8(HtmlPanelGrid hpg) {
        this.gridPanel8 = hpg;
    }

    private HtmlPanelGrid gridPanel9 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel9() {
        return gridPanel9;
    }

    public void setGridPanel9(HtmlPanelGrid hpg) {
        this.gridPanel9 = hpg;
    }

    private HtmlPanelGrid gridPanel10 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel10() {
        return gridPanel10;
    }

    public void setGridPanel10(HtmlPanelGrid hpg) {
        this.gridPanel10 = hpg;
    }

    private HtmlGraphicImage image2 = new HtmlGraphicImage();

    public HtmlGraphicImage getImage2() {
        return image2;
    }

    public void setImage2(HtmlGraphicImage hgi) {
        this.image2 = hgi;
    }

    private HtmlOutputText outputText2 = new HtmlOutputText();

    public HtmlOutputText getOutputText2() {
        return outputText2;
    }

    public void setOutputText2(HtmlOutputText hot) {
        this.outputText2 = hot;
    }

    private CheckboxGroup addPrivsGroup = new CheckboxGroup();

    public CheckboxGroup getAddPrivsGroup() {
        return addPrivsGroup;
    }

    public void setAddPrivsGroup(CheckboxGroup cg) {
        this.addPrivsGroup = cg;
    }

    private MultipleSelectOptionsList addPrivsGroupDefaultOptions = new MultipleSelectOptionsList();

    public MultipleSelectOptionsList getAddPrivsGroupDefaultOptions() {
        return addPrivsGroupDefaultOptions;
    }

    public void setAddPrivsGroupDefaultOptions(MultipleSelectOptionsList msol) {
        this.addPrivsGroupDefaultOptions = msol;
    }

    private HtmlPanelGrid gridPanel11 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel11() {
        return gridPanel11;
    }

    public void setGridPanel11(HtmlPanelGrid hpg) {
        this.gridPanel11 = hpg;
    }

    private HtmlPanelGrid gridPanel12 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel12() {
        return gridPanel12;
    }

    public void setGridPanel12(HtmlPanelGrid hpg) {
        this.gridPanel12 = hpg;
    }

    private HtmlPanelGrid gridPanel13 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel13() {
        return gridPanel13;
    }

    public void setGridPanel13(HtmlPanelGrid hpg) {
        this.gridPanel13 = hpg;
    }

    private HtmlPanelGrid gridPanel14 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel14() {
        return gridPanel14;
    }

    public void setGridPanel14(HtmlPanelGrid hpg) {
        this.gridPanel14 = hpg;
    }

    private TextField addNameField = new TextField();

    public TextField getAddNameField() {
        return addNameField;
    }

    public void setAddNameField(TextField tf) {
        this.addNameField = tf;
    }

    private TextField addFullNameField = new TextField();

    public TextField getAddFullNameField() {
        return addFullNameField;
    }

    public void setAddFullNameField(TextField tf) {
        this.addFullNameField = tf;
    }

    private PasswordField addPasswordField = new PasswordField();

    public PasswordField getAddPasswordField() {
        return addPasswordField;
    }

    public void setAddPasswordField(PasswordField pf) {
        this.addPasswordField = pf;
    }

    private StaticText staticText4 = new StaticText();

    public StaticText getStaticText4() {
        return staticText4;
    }

    public void setStaticText4(StaticText st) {
        this.staticText4 = st;
    }

    private Button addUserButton = new Button();

    public Button getAddUserButton() {
        return addUserButton;
    }

    public void setAddUserButton(Button b) {
        this.addUserButton = b;
    }

    private Label label1 = new Label();

    public Label getLabel1() {
        return label1;
    }

    public void setLabel1(Label l) {
        this.label1 = l;
    }

    private Label label2 = new Label();

    public Label getLabel2() {
        return label2;
    }

    public void setLabel2(Label l) {
        this.label2 = l;
    }

    private Label label3 = new Label();

    public Label getLabel3() {
        return label3;
    }

    public void setLabel3(Label l) {
        this.label3 = l;
    }

    private TableColumn tableColumn4 = new TableColumn();

    public TableColumn getTableColumn4() {
        return tableColumn4;
    }

    public void setTableColumn4(TableColumn tc) {
        this.tableColumn4 = tc;
    }

    private StaticText staticText1 = new StaticText();

    public StaticText getStaticText1() {
        return staticText1;
    }

    public void setStaticText1(StaticText st) {
        this.staticText1 = st;
    }

    private TableColumn tableColumn5 = new TableColumn();

    public TableColumn getTableColumn5() {
        return tableColumn5;
    }

    public void setTableColumn5(TableColumn tc) {
        this.tableColumn5 = tc;
    }

    private StaticText staticText2 = new StaticText();

    public StaticText getStaticText2() {
        return staticText2;
    }

    public void setStaticText2(StaticText st) {
        this.staticText2 = st;
    }
    
    // </editor-fold>


    /** 
     * <p>Construct a new Page bean instance.</p>
     */
    public webUsers() {
    }

    /** 
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1)getBean("RequestBean1");
    }


    /** 
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1)getBean("ApplicationBean1");
    }

        /** 
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1)getBean("SessionBean1");
    }


    /** 
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here

        // <editor-fold defaultstate="collapsed" desc="Creator-managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("webUsers Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here

    }

    /** 
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    public void preprocess() {
    }

    /** 
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    public void prerender() {
    }

    /** 
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    public void destroy() {
        webusersDataProvider.close();
    }

   /* The set of RowKeys for rows that have been selected.
   * This set is manipulated by calls to setSelectedTrip(),
   * which will occur when the checkbox of each row is decoded.*/
   Set selectedUsers = new HashSet();
    
    /**
     * Getter for property selectedUser.
     * @return Value of property selectedUser.
     */
    public boolean isSelectedUser() {
       TableRowDataProvider trdp = (TableRowDataProvider) getBean("currentRow");
       if (trdp == null) {
           return false;
       }
       RowKey rowKey = trdp.getTableRow();       
       return selectedUsers.contains(rowKey);
    }

    /**
     * Setter for property selectedUser.
     * @param selectedUser New value of property selectedUser.
     */
    public void setSelectedUser(boolean selectedUser) {
       TableRowDataProvider trdp = (TableRowDataProvider) getBean("currentRow");
       RowKey rowKey = trdp.getTableRow();        
       if (this.selectUserCheckBox.isChecked()) {
           selectedUsers.add(rowKey);
       } else {
           selectedUsers.remove(rowKey);
       }
    }


    public String commitButton_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        try {
           webusersDataProvider.commitChanges(); 
           info("Изменения были успешно внесены в БД"); 
        } catch (Exception e) {
            error("Ошибка при внесении изменений в БД: " + e);
        }
        this.selectedUsers.clear();
        return null;
    }


    public String deleteSelectedButton_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        
        if(selectedUsers.isEmpty())
        {
            error("Ошибка: Для удаления не отмечено ни одного пользователя, используйте колонку 'Отметить'");
            return null;
        }
        
        boolean hasErrors = false;
        Iterator rowKeys = selectedUsers.iterator();
        info("Кол-во пользоватетей для удаления: " + selectedUsers.size());
        while (rowKeys.hasNext()) {         
            RowKey rowKey = (RowKey) rowKeys.next();
            try {
                webusersDataProvider.removeRow(rowKey);
            } catch (Exception e) {
                error("Ошибка: не удается удалить запись [" + rowKey + "]:" 
                        + e.getLocalizedMessage());
                hasErrors = true;
            }
        } 

        this.selectedUsers.clear();
        form1.discardSubmittedValues("UpdateGridVF");

        // do outside loop because commitChanges() invalidates rowkeys
        try {
            webusersDataProvider.commitChanges();
        } catch (Exception ex) {
            error("Ошибка: не удается сделать commit: " + ex.getLocalizedMessage());
            return null;
        }
        if(hasErrors)
            warn("Внимание: удаление произведено с ошибками");
        else
            info("Пользователи успешно удалены");
        return null;
    }


    public String refreshButton_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        try
        {
            webusersDataProvider.refresh();
        }
        catch( Exception e)
        {
            error("Ошибка при обновлении данных из БД: " + e);
        }
        form1.discardSubmittedValues("UpdateGridVF");
        return null;
    }


    public String passwordSetButton_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        String passwd = (String)this.passwordField.getText();
        if(passwd == null || passwd.equals(""))
        {
            error("Ошибка: Пароль не может быть пустым");
            return null;
        }
        if(this.selectedUsers.isEmpty())
        {
            error("Ошибка: Не отмечено ни одного пользователя, используйте колонку 'Отметить'");
            return null;
        }
        
        boolean hasErrors = false;
        Iterator rowKeys = selectedUsers.iterator();
        info("Кол-во записей для изменения пароля: " + selectedUsers.size());
        while (rowKeys.hasNext()) {         
            RowKey rowKey = (RowKey) rowKeys.next();
            try {
                webusersDataProvider.setValue("passwd", rowKey, passwd);
            } catch (Exception e) {
                error("Ошибка: не удается обновить запись [" + rowKey + "]:" 
                        + e.getLocalizedMessage());
                hasErrors = true;
            }
        } 
        this.selectedUsers.clear();
        this.passwordField.setText("");
        form1.discardSubmittedValues("UpdateGridVF");
        
        // do outside loop because commitChanges() invalidates rowkeys
        try {
            webusersDataProvider.commitChanges();
        } catch (Exception ex) {
            error("Ошибка: не удается сделать commit: " + ex.getLocalizedMessage());
            return null;
        }
        if(hasErrors)
            warn("Внимание: обновление пароля произведено с ошибками");
        else
            info("Записи успешно обновлены");

        return null;
    }


    public String addUserButton_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        String uname = (String) this.addNameField.getText();
        String ufullname = (String) this.addFullNameField.getText();
        String upassword = (String) this.addPasswordField.getText();
        String[] selected = (String[]) this.addPrivsGroup.getSelected();

        if(uname == null || ufullname == null || upassword == null)
        {
            error("Ошибка: Поля: Логин, Имя пользователя, Пароль должны быть заполнены!");
            return null;
        }
        
        
        String query = "exec p_web_new_user '" + uname 
                + "', '" + ufullname + "', '" + upassword
                + "', ";

        int is_admin = 0;
        int is_manager = 0;
        
        if(selected != null)
        {
            for(int i=0;i<selected.length;i++)
            {
                if(selected[i].equals("admin"))
                    is_admin = 1;
                if(selected[i].equals("manager"))
                    is_manager = 1;
            }
        }

        query += is_manager + ", " + is_admin;
        //info("SQL: " + query);
        try
        {
            Statement sta=null;
            ResultSet rs=null;
            DataSource ds = null;
            Connection conn = null;
        
            Context initContext = new InitialContext();
            //Context envContext  = (Context)initContext.lookup("java:/comp/env");
            ds = (DataSource)initContext.lookup("jdbc/roast");

            conn = ds.getConnection();
            sta = conn.createStatement();
            sta.execute(query);
            sta.close();
            conn.close();
            
            this.getSessionBean1().DBLog("Админ " 
                    + this.getSessionBean1().getUser().getUserFullName()
                    + ": Cоздан новый пользователь : "
                    + uname + "/" + ufullname, "webUsers","addUser",
                    this.getSessionBean1().getUser().getUserName());

        }
        catch(Exception e)
        {
            error("Ошиибка создания пользователя: " + e);
        }
        form1.discardSubmittedValues("UpdateGridVF");
        webusersDataProvider.refresh();
        this.addNameField.setText("");
        this.addFullNameField.setText("");
        this.addPasswordField.setText("");
        this.addPrivsGroup.setSelected(null);
        return null;
    }

}

