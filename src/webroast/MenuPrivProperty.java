/*
 * MenuPrivProperty.java
 *
 * Created on 14 јпрель 2006 г., 13:50
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package webroast;

import java.util.*;
/**
 *
 * @author Leo
 */
public class MenuPrivProperty extends PrivProperty {
    
    /** Creates a new instance of MenuPrivProperty */
    public MenuPrivProperty() {
        super();
    }

    public MenuPrivProperty(String _name, 
                String _descr, 
                String _action, 
                String _priv)
    {
        super(_name, _descr,  _action, _priv);
    }
    
    public MenuPrivProperty(String _name, 
                String _descr, 
                String _action)
    {
        super(_name, _descr,  _action);
    }
    
    /**
     * Holds value of property hasChildren.
     */
    private boolean hasChildren = false;

    /**
     * Getter for property hasChildren.
     * @return Value of property hasChildren.
     */
    public boolean isHasChildren() {

        return this.hasChildren;
    }

    /**
     * Setter for property hasChildren.
     * @param hasChildren New value of property hasChildren.
     */
    public void setHasChildren(boolean hasChildren) {

        this.hasChildren = hasChildren;
    }

    /**
     * Holds value of property children.
     */
    private List children;

    /**
     * Getter for property children.
     * @return Value of property children.
     */
    public List getChildren() {

        return this.children;
    }

    /**
     * Setter for property children.
     * @param children New value of property children.
     */
    public void setChildren(List children) {

        this.children = children;
        this.hasChildren = this.children != null;
    }
    
    public void addChild(MenuPrivProperty child)
    {
        if(this.children == null)
        {
            this.children = new LinkedList();
            this.hasChildren = true;
        }
        this.children.add(child);
    }    


    /**
     * Construct parent name from our one by cutting last word
     * separated by '-'
     * @return Name of the parent menu
     */
    public String getParentName() {
        
        return name.substring(0, name.lastIndexOf('_'));        
    }

}
