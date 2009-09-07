/*
 * PrivProperty.java
 *
 * Created on 14 јпрель 2006 г., 13:39
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package webroast;

import java.io.Serializable;

/**
 *
 * @author Leo
 */
public class PrivProperty implements Serializable{
    
    /** Creates a new instance of PrivProperty */
    public PrivProperty() {
    }

    public PrivProperty(String _name, String _descr, String _action, String _priv)
    {
        name = _name;
        description = _descr;
        action = _action;
        privilege = _priv;
    }

    public PrivProperty(String _name, String _descr, String _action)
    {
        name = _name;
        description = _descr;
        action = _action;
        privilege = "";
    }
    /**
     * Holds value of property name.
     */
    protected String name;

    /**
     * Getter for property name.
     * @return Value of property name.
     */
    public String getName() {

        return this.name;
    }

    /**
     * Setter for property name.
     * @param name New value of property name.
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * Holds value of property description.
     */
    protected String description;

    /**
     * Getter for property description.
     * @return Value of property description.
     */
    public String getDescription() {

        return this.description;
    }

    /**
     * Setter for property description.
     * @param description New value of property description.
     */
    public void setDescription(String description) {

        this.description = description;
    }

    /**
     * Holds value of property action.
     */
    private String action;

    /**
     * Getter for property action.
     * @return Value of property action.
     */
    public String getAction() {

        return this.action;
    }

    /**
     * Setter for property action.
     * @param action New value of property action.
     */
    public void setAction(String action) {

        this.action = action;
    }

    /**
     * Holds value of property privilege.
     */
    private String privilege;

    /**
     * Getter for property privilege.
     * @return Value of property privilege.
     */
    public String getPrivilege() {

        return this.privilege;
    }

    /**
     * Setter for property privilege.
     * @param privilege New value of property privilege.
     */
    public void setPrivilege(String privilege) {

        this.privilege = privilege;
    }
    
}
