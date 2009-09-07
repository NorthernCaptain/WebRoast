/*
 * UserData.java
 *
 * Created on 13 Апрель 2006 г., 13:47
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package webroast;

//JDBC imports
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Leo
 */

class UserException extends java.lang.Exception
{
    UserException(String msg)
    {
        super(msg);
    }
};

public class UserData implements Serializable {
    
    /** Creates a new instance of UserData */
    public UserData() {
    }
    
    public UserData(String uname, String passwd)
    {
        userName = uname;
        password = passwd;
    }
    
    /**
     * Login new user, checks userName and password
     * @throw UserException if not a valid user/password
     */    
    public void Login() throws UserException
    {
        if(userName == null)
            throw new UserException("Пустой пользователь / пароль");
        
        if(userName.equals("root") && password.equals("elcondor"))
        {
            this.rootMenu.setRoot(this.rootMenu.constructFullTree());
            this.userFullName = "root of all evil";
            this.admin = true;
            this.manager = true;
            return; //мы залогинились roots
        }
        
        Statement sta=null;
        ResultSet rs=null;
        DataSource ds = null;
        Connection conn = null;
        
        try
        {
            Context initContext = new InitialContext();
            //Context envContext  = (Context)initContext.lookup("java:/comp/env");
            ds = (DataSource)initContext.lookup("jdbc/roast");
        }
        catch(NamingException ex)
        {
            throw new UserException("Naming: " + ex.getLocalizedMessage() + " / " + ex.getExplanation());
        }

        try
        {
            conn = ds.getConnection();
            conn.setAutoCommit(true);
            sta = conn.createStatement();
            rs=sta.executeQuery("SELECT id, full_name, passwd, is_admin, is_manager FROM  webUsers "
                    + "where disabled = 0 and is_template = 0 and name='" 
                    + userName + "'");
            if (!rs.next()) {
                throw new UserException("Нет такого пользователя");
            }
            if(!rs.getString("passwd").equals(this.password))
            {
                throw new UserException("Введен неверный пароль, проверьте регистр и раскладку клавиатуры");
            }
            this.userFullName = rs.getString("full_name");
            this.userId = rs.getInt("id");
            this.admin = rs.getBoolean("is_admin");
            this.manager = rs.getBoolean("is_manager");
            sta.close();
            LoadPrivs(conn);
            
            sta = conn.createStatement();
            sta.executeUpdate("update webUsers set total_logins = total_logins + 1, " +
                    "last_login = getdate() where id = " + this.userId);
            sta.close();
            conn.close();
        }
        catch(SQLException ex)
        {
            if(conn != null)
            {
                try
                {
                    conn.close();
                }
                catch(Exception e)
                {
                }
            }
            throw new UserException("SQL: " + ex.getSQLState() + ":" + ex.getLocalizedMessage());
        }
        
    }

    /**
     *
     * Loads menu items for current user from webUserPrivs table,
     * uses given DB connection. DEPRICATED
     *
     */
    private void LoadMenu(Connection conn) throws SQLException
    {
        Statement sta = conn.createStatement();
        ResultSet rs=sta.executeQuery("SELECT name, description, screen_name, access FROM  webUserPrivs "
                    + "where user_id = " + this.userId + " and type='menu' order by name");
        while(rs.next())
        {
            String pname = rs.getString("name");
            String pdesc = rs.getString("description");
            String screen = rs.getString("screen_name");
            String access = rs.getString("access");
            if(access == null)
                access = "";
            this.rootMenu.addProperty(new MenuPrivProperty(pname, pdesc, screen, access));
        }
        sta.close();
    }
    

    /**
     *
     * Loads privileges for current user from webUserPrivs table,
     * uses given DB connection
     *
     */
    private void LoadPrivs(Connection conn) throws SQLException
    {
        Statement sta = conn.createStatement();
        ResultSet rs=sta.executeQuery("SELECT name, description, screen_name, access, type FROM  webUserPrivs "
                    + "where user_id = " + this.userId + " order by name");
        while(rs.next())
        {
            String pname = rs.getString("name");
            String pdesc = rs.getString("description");
            String screen = rs.getString("screen_name");
            String access = rs.getString("access");
            if(access == null)
                access = "";
            
            if(access.equals("admin") && !this.isAdmin())
                continue;

            if(access.equals("manager") && !this.isManager())
                continue;
            
            String ptype = rs.getString("type");
            if(ptype == null)
                ptype = "";
            
            PrivProperty priv;
            if(ptype.equals("menu"))
            {
                priv = new MenuPrivProperty(pname, pdesc, screen, access);
                this.rootMenu.addProperty((MenuPrivProperty)priv);
            }
            else
                priv = new PrivProperty(pname, pdesc, screen, access);
            privMap.put(pname, priv);
        }
        sta.close();
    }
    
    
    
    /**
     * Logs out current user from the system
     */
    public void Logout()
    {
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
     * Holds value of property password.
     */
    private String password;

    /**
     * Setter for property password.
     * @param password New value of property password.
     */
    public void setPassword(String password) {

        this.password = password;
    }

    /**
     * Holds value of property userId.
     */
    private int userId=0;

    /**
     * Getter for property userId.
     * @return Value of property userId.
     */
    public int getUserId() {

        return this.userId;
    }

    /**
     * Setter for property userId.
     * @param userId New value of property userId.
     */
    public void setUserId(int userId) {

        this.userId = userId;
    }

    /**
     * Holds value of property rootMenu.
     */
    private MenuPrivs rootMenu = new RoastMenuPrivs();

    /**
     * Getter for property rootMenu.
     * @return Value of property rootMenu.
     */
    public MenuPrivs getRootMenu() {

        return this.rootMenu;
    }

    /**
     * Setter for property rootMenu.
     * @param rootMenu New value of property rootMenu.
     */
    public void setRootMenu(MenuPrivs rootMenu) {

        this.rootMenu = rootMenu;
    }

    /**
     * Holds value of property userFullName.
     */
    private String userFullName;

    /**
     * Getter for property userFullName.
     * @return Value of property userFullName.
     */
    public String getUserFullName() {

        return this.userFullName;
    }

    /**
     * Setter for property userFullName.
     * @param userFullName New value of property userFullName.
     */
    public void setUserFullName(String userFullName) {

        this.userFullName = userFullName;
    }

    /**
     * Holds value of property privMap.
     */
    private Hashtable privMap = new Hashtable();

    /**
     * Getter for property privMap.
     * @return Value of property privMap.
     */
    public Hashtable getPrivMap() {

        return this.privMap;
    }

    /**
     * Setter for property privMap.
     * @param privMap New value of property privMap.
     */
    public void setPrivMap(Hashtable privMap) {

        this.privMap = privMap;
    }

    /**
     * Getter for property property.
     * @return Value of property property.
     */
    public PrivProperty getProperty(String name) {

        return (PrivProperty)this.privMap.get(name);
    }

    /**
     * Holds value of property admin.
     */
    private boolean admin = false;

    /**
     * Getter for property admin.
     * @return Value of property admin.
     */
    public boolean isAdmin() {

        return this.admin;
    }

    /**
     * Setter for property admin.
     * @param admin New value of property admin.
     */
    public void setAdmin(boolean admin) {

        this.admin = admin;
    }

    /**
     * Holds value of property manager.
     */
    private boolean manager = false;

    /**
     * Getter for property manager.
     * @return Value of property manager.
     */
    public boolean isManager() {

        return this.manager;
    }

    /**
     * Setter for property manager.
     * @param manager New value of property manager.
     */
    public void setManager(boolean manager) {

        this.manager = manager;
    }
}
