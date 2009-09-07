/*
 * NavMenu.java
 *
 * Created on 13 јпрель 2006 г., 17:07
 * Copyright Leo
 */
package webroast;

import com.sun.rave.web.ui.appbase.AbstractFragmentBean;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import com.sun.rave.web.ui.component.Tree;
import com.sun.rave.web.ui.component.TreeNode;
import com.sun.rave.web.ui.component.ImageComponent;
import javax.faces.component.html.HtmlOutputText;
import com.sun.rave.web.ui.component.Form;
import javax.faces.component.UIComponent;
import java.util.List;
import java.util.ListIterator;

/**
 * <p>Fragment bean that corresponds to a similarly named JSP page
 * fragment.  This class contains component definitions (and initialization
 * code) for all components that you have defined on this fragment, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class NavMenu extends AbstractFragmentBean {
    // <editor-fold defaultstate="collapsed" desc="Creator-managed Component Definition">
    private int __placeholder;
    
    /**
     * <p>Automatically managed component initialization. <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    private Tree screenTree = null;

    public Tree getScreenTree() {
        if(screenTree == null)
        {
            screenTree = new Tree();
            this.buildScreenTree();
        }
        return screenTree;
    }

    public void setScreenTree(Tree t) {
        this.screenTree = t;
    }

    private HtmlPanelGrid gridPanel1 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel1() {
        return gridPanel1;
    }

    public void setGridPanel1(HtmlPanelGrid hpg) {
        this.gridPanel1 = hpg;
    }

    private HtmlOutputText nodeLbl = new HtmlOutputText();

    public HtmlOutputText getNodeLbl() {
        return nodeLbl;
    }

    public void setNodeLbl(HtmlOutputText hot) {
        this.nodeLbl = hot;
    }
    // </editor-fold>
    
    public NavMenu() {
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1)getBean("RequestBean1");
    }

    /** 
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1)getBean("SessionBean1");
    }

    /** 
     * <p>Callback method that is called whenever a page containing
     * this page fragment is navigated to, either directly via a URL,
     * or indirectly via page navigation.  Override this method to acquire
     * resources that will be needed for event handlers and lifecycle methods.</p>
     * 
     * <p>The default implementation does nothing.</p>
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
            log("NavMenu Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here

    }

    /** 
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called.  Override this
     * method to release resources acquired in the <code>init()</code>
     * resources that will be needed for event handlers and lifecycle methods.</p>
     * 
     * <p>The default implementation does nothing.</p>
     */
    public void destroy() {
    }

    /**
     * A utility method that returns the tree node that corresponds to the
     * currently selected node on the tree. This method searches for the node
     * using the client ID that was passed back to the tree component as a 
     * client cookie. This value will always be present, however the page is
     * submitted.
     */
    private TreeNode getSelectedTreeNode() {
        Tree tree = this.getScreenTree();
        String id = tree.getCookieSelectedTreeNode();
        if (id == null)
            return null;
        id = id.substring(id.lastIndexOf(':') + 1);
        Form frm = null;
        UIComponent obj = this.getGridPanel1().getParent();
        while(obj != null)
        {
            try
            {
                frm = (Form)obj;
                break;
            }
            catch (ClassCastException ex)
            {
                obj = obj.getParent();
            }
        }

        if(frm == null)
            return null;
        return (TreeNode)frm.findComponentById(id);      
    }

    /*
     * Build part of the menu tree according to the give propreties
     * and given Tree node.
     *
     */
    private void buildTreeBranch(TreeNode root_node, MenuPrivProperty root_prop)
    {
        List root_children = root_prop.getChildren();
        List node_children = root_node.getChildren();
        
        if(root_children != null)
        {
            for(ListIterator it = root_children.listIterator();it.hasNext();)
            {
                MenuPrivProperty prop = (MenuPrivProperty)it.next();
                TreeNode node = this.newTreeNode(prop);
                if(prop.isHasChildren())
                {
                    buildTreeBranch(node, prop);                    
                }
                node_children.add(node);
            }
        }        
    }
    
    /*
     * Build full menu tree from MenuPrivs taken from UserData.
     * UserData is stored in our sessionBean and their menu
     * was loaded at login time.
     */
    private void  buildScreenTree()
    {
        UserData usr = this.getSessionBean1().getUser();
        MenuPrivs menu = usr.getRootMenu();
        List root_children = menu.getRoot().getChildren();
        List tree_children = screenTree.getChildren();
        
        if(root_children != null)
        {
            for(ListIterator it = root_children.listIterator();it.hasNext();)
            {
                MenuPrivProperty prop = (MenuPrivProperty)it.next();
                TreeNode node = this.newTreeNode(prop);
                if(prop.isHasChildren())
                {
                    buildTreeBranch(node, prop);                    
                }
                tree_children.add(node);
            }
        }
    }
    
    public String screenTreeNode_action() {
        //TreeNode
        Tree tree = this.getScreenTree();
        String id = tree.getCookieSelectedTreeNode();
        if (id == null)
            return null;

        this.getNodeLbl().setValue(id);
        
        String privName = id.substring(id.lastIndexOf(":")+1);
        
        MenuPrivProperty prop = (MenuPrivProperty)this.getSessionBean1().getUser().getProperty(privName);
        if(prop == null)
            return null;
        return prop.getAction();
    }
   /**
     * Create a new tree node, using the text label provided. IDs for the text
     * node and its image facet are generated automatically. A counter in session
     * scope is used to create unique ID suffixes.
     */
    private TreeNode newTreeNode(MenuPrivProperty prop) {
        javax.faces.el.MethodBinding actionMethodBinding = null;
        TreeNode node = new TreeNode();
        ImageComponent image = new ImageComponent();
        node.setId(prop.getName());
        node.setText(prop.getDescription());
        if (actionMethodBinding == null)
            actionMethodBinding =
                this.getApplication().createMethodBinding("#{NavMenu.screenTreeNode_action}", null);
        node.setAction(actionMethodBinding);
        image.setId("img_" + prop.getName());
        image.setUrl("/resources/images/menutree/"+prop.getName()+".png");
        image.setWidth(16);
        image.setHeight(16);
/*        
        if(prop.isHasChildren())
            image.setIcon("TREE_FOLDER");
        else
            image.setIcon("TREE_DOCUMENT");
*/        
        node.getFacets().put("image", image);
        return node;
    }
}
