/*
 * MenuPrivs.java
 *
 * Created on 14 јпрель 2006 г., 14:06
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
public class MenuPrivs {
    
    /** Creates a new instance of MenuPrivs */
    public MenuPrivs() {
    }

    /**
     * Holds value of property root.
     */
    private MenuPrivProperty root = new MenuPrivProperty("root", "Root Entry",  "root");

    /**
     * Getter for property root.
     * @return Value of property root.
     */
    public MenuPrivProperty getRoot() {

        return this.root;
    }

    /**
     * Setter for property root.
     * @param root New value of property root.
     */
    public void setRoot(MenuPrivProperty root) {

        this.root = root;
    }

    
    protected boolean addProperty(MenuPrivProperty myRoot, MenuPrivProperty child)
    {
        String parentName = child.getParentName();
        if(myRoot.getName().equals(parentName))
        {
            myRoot.addChild(child);
            return true;
        }
        
        if(myRoot.isHasChildren())
        {
            List children = myRoot.getChildren();
            //go through all children and try to add child to one of them
            for(ListIterator it = children.listIterator(); it.hasNext();)
            {
                if(this.addProperty((MenuPrivProperty)it.next(), child))
                    return true;
            }
        }
        return false;
    }
    
    /**
     * Constructs full tree of avalable menu items
     * @return Value of class MenuPrivProperty.
     */
    public MenuPrivProperty constructFullTree() 
    {        
        return this.root;
    }    

    public boolean addProperty(MenuPrivProperty child) {
        return addProperty(this.root,  child);
    }
}
