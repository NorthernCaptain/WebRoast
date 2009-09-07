/*
 * SessionBean1.java
 *
 * Created on 16 Апрель 2006 г., 12:15
 * Copyright Leo
 */
package webroast;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import javax.faces.FacesException;
import com.sun.sql.rowset.CachedRowSetXImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 */
public class SessionBean1 extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Creator-managed Component Definition">
    private int __placeholder;
    
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        webusersRowSet.setDataSourceName("java:comp/env/jdbc/roast");
        webusersRowSet.setCommand("SELECT ALL dbo.webUsers.id, \n                    dbo.webUsers.name, \n                    dbo.webUsers.full_name, \n                    dbo.webUsers.passwd, \n                    dbo.webUsers.disabled, \n                    dbo.webUsers.is_admin, \n                    dbo.webUsers.is_manager, \n                    dbo.webUsers.last_login, \n                    dbo.webUsers.total_logins \nFROM dbo.webUsers\nWHERE dbo.webUsers.is_template = 0\nORDER BY dbo.webUsers.full_name ASC ");
        webusersRowSet.setTableName("webUsers");
        v_weblogRowSet.setDataSourceName("java:comp/env/jdbc/roast");
        v_weblogRowSet.setCommand("SELECT * FROM dbo.v_webLog");
        v_weblogRowSet.setTableName("v_webLog");
    }

    private CachedRowSetXImpl webusersRowSet = new CachedRowSetXImpl();

    public CachedRowSetXImpl getWebusersRowSet() {
        return webusersRowSet;
    }

    public void setWebusersRowSet(CachedRowSetXImpl crsxi) {
        this.webusersRowSet = crsxi;
    }

    private CachedRowSetXImpl v_weblogRowSet = new CachedRowSetXImpl();

    public CachedRowSetXImpl getV_weblogRowSet() {
        return v_weblogRowSet;
    }

    public void setV_weblogRowSet(CachedRowSetXImpl crsxi) {
        this.v_weblogRowSet = crsxi;
    }
    // </editor-fold>


    /** 
     * <p>Construct a new session data bean instance.</p>
     */
    public SessionBean1() {
    }

    /** 
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1)getBean("ApplicationBean1");
    }


    /** 
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     * 
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
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
            log("SessionBean1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here

    }

    /** 
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     * 
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    public void passivate() {
    }

    /** 
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     * 
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    public void activate() {
    }

    /** 
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     * 
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    public void destroy() {
    }

    /**
     * Holds value of property userName.
     */
    private String userName;

    /**
     * Getter for property userName.
     * @return Value of property userName.
     */
    public String getUserName() {

        return this.userName;
    }

    /**
     * Setter for property userName.
     * @param userName New value of property userName.
     */
    public void setUserName(String userName) {

        this.userName = userName;
    }

    /**
     * Holds value of property user.
     */
    private UserData user;

    /**
     * Getter for property user.
     * @return Value of property user.
     */
    public UserData getUser() {

        return this.user;
    }

    /**
     * Setter for property user.
     * @param user New value of property user.
     */
    public void setUser(UserData user) {

        this.user = user;
      if(user != null)
          setUserName(user.getUserName());
      else
          setUserName(""); 
    }

    public final void DBLog(String msg, String screen, String action, String sValue) {
        
        int user_id = 0;
        
        if(this.user != null)
        {
            user_id = this.user.getUserId();
        }
        
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
            conn.setAutoCommit(true);
            sta = conn.createStatement();
            sta.executeUpdate("insert into webLog(user_id, msg, screen_name, msg_action, sValue) "
                        + "values (" + user_id + ", '"
                        + msg + "', '"
                        + screen + "', '"
                        + action + "', '"
                        + sValue + "')");
            sta.close();
            conn.close();
        }
        catch(Exception e)
        {
            //Просто игнорируем - не получилось - не беда
        }
        
    }
}
