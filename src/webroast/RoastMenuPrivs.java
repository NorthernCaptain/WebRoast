/*
 * RoastMenuPrivs.java
 *
 * Created on 14 Апрель 2006 г., 14:38
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
        
        addProperty(myRoot, new MenuPrivProperty("root_0mystart", "Стартовая", "MyStart"));

        addProperty(myRoot, new MenuPrivProperty("root_infodir", "Информация", "root_infodir"));
        addProperty(myRoot, new MenuPrivProperty("root_infodir_roasts", "Обжарки", "root_infodir_roasts"));
        addProperty(myRoot, new MenuPrivProperty("root_infodir_roastskus", "Обжарки по товарам", "root_infodir_roastskus"));
        
        addProperty(myRoot, new MenuPrivProperty("root_utilsdir", "Управление", "root_utilsdir"));
        addProperty(myRoot, new MenuPrivProperty("root_utilsdir_operators", "Операторы", "root_utilsdir_operators", "manager"));
        addProperty(myRoot, new MenuPrivProperty("root_utilsdir_skus", "Товары", "root_utilsdir_skus", "manager"));
        addProperty(myRoot, new MenuPrivProperty("root_utilsdir_warehouses", "Склады", "root_utilsdir_warehouses", "manager"));
        addProperty(myRoot, new MenuPrivProperty("root_utilsdir_webusers", "Пользователи Web", "webUsers", "admin"));
        addProperty(myRoot, new MenuPrivProperty("root_utilsdir_weblog", "Web логи", "webLogs", "admin"));
        
        return myRoot;
    }    
}
