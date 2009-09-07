/*
 * RoastMenuPrivs.java
 *
 * Created on 14 ������ 2006 �., 14:38
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package webroast;

/**
 *
 * @author Leo
 */
public class RoastMenuPrivs extends MenuPrivs
{
    
    /** Creates a new instance of RoastMenuPrivs */
    public RoastMenuPrivs() {
        super();
    }
    
    /**
     * Constructs full tree of avalable menu items
     * @return Value of class MenuPrivProperty.
     */
    public MenuPrivProperty constructFullTree() 
    {
        MenuPrivProperty myRoot = new MenuPrivProperty("root", "Root Entry", "root");
        
        addProperty(myRoot, new MenuPrivProperty("root_0mystart", "���������", "MyStart"));

        addProperty(myRoot, new MenuPrivProperty("root_infodir", "����������", "root_infodir"));
        addProperty(myRoot, new MenuPrivProperty("root_infodir_roasts", "�������", "root_infodir_roasts"));
        addProperty(myRoot, new MenuPrivProperty("root_infodir_roastskus", "������� �� �������", "root_infodir_roastskus"));
        
        addProperty(myRoot, new MenuPrivProperty("root_utilsdir", "����������", "root_utilsdir"));
        addProperty(myRoot, new MenuPrivProperty("root_utilsdir_operators", "���������", "root_utilsdir_operators", "manager"));
        addProperty(myRoot, new MenuPrivProperty("root_utilsdir_skus", "������", "root_utilsdir_skus", "manager"));
        addProperty(myRoot, new MenuPrivProperty("root_utilsdir_warehouses", "������", "root_utilsdir_warehouses", "manager"));
        addProperty(myRoot, new MenuPrivProperty("root_utilsdir_webusers", "������������ Web", "webUsers", "admin"));
        addProperty(myRoot, new MenuPrivProperty("root_utilsdir_weblog", "Web ����", "webLogs", "admin"));
        
        return myRoot;
    }    
}
