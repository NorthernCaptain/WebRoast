/*
 * UpperMenu.java
 *
 * Created on 13 Апрель 2006 г., 16:25
 * Copyright Leo
 */
package webroast;

import com.sun.rave.web.ui.appbase.AbstractFragmentBean;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlOutputText;
import com.sun.rave.web.ui.component.Label;
import com.sun.rave.web.ui.component.StaticText;
import com.sun.rave.web.ui.component.ImageHyperlink;

/**
 * <p>Fragment bean that corresponds to a similarly named JSP page
 * fragment.  This class contains component definitions (and initialization
 * code) for all components that you have defined on this fragment, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class UpperMenu extends AbstractFragmentBean {
    // <editor-fold defaultstate="collapsed" desc="Creator-managed Component Definition">
    private int __placeholder;
    
    /**
     * <p>Automatically managed component initialization. <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    private HtmlPanelGrid gridPanel1 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel1() {
        return gridPanel1;
    }

    public void setGridPanel1(HtmlPanelGrid hpg) {
        this.gridPanel1 = hpg;
    }

    private HtmlPanelGrid gridPanel2 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel2() {
        return gridPanel2;
    }

    public void setGridPanel2(HtmlPanelGrid hpg) {
        this.gridPanel2 = hpg;
    }

    private HtmlOutputText userNameLbl = new HtmlOutputText();

    public HtmlOutputText getUserNameLbl() {
        return userNameLbl;
    }

    public void setUserNameLbl(HtmlOutputText hot) {
        this.userNameLbl = hot;
    }

    private ImageHyperlink homeLink = new ImageHyperlink();

    public ImageHyperlink getHomeLink() {
        return homeLink;
    }

    public void setHomeLink(ImageHyperlink ih) {
        this.homeLink = ih;
    }

    private ImageHyperlink logoutLink = new ImageHyperlink();

    public ImageHyperlink getLogoutLink() {
        return logoutLink;
    }

    public void setLogoutLink(ImageHyperlink ih) {
        this.logoutLink = ih;
    }

    private ImageHyperlink newUserLink = new ImageHyperlink();

    public ImageHyperlink getNewUserLink() {
        return newUserLink;
    }

    public void setNewUserLink(ImageHyperlink ih) {
        this.newUserLink = ih;
    }
    // </editor-fold>
    
    public UpperMenu() {
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
            log("UpperMenu Initialization Failure", e);
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


    public String logoutLink_action() {
        // TODO: Replace with your code
        UserData usr = getSessionBean1().getUser();
        getSessionBean1().setUser(null);
        if(usr!=null)
        {
            this.getSessionBean1().DBLog("Выход: выход из системы, пользователь: "
                        + usr.getUserFullName(),"Logout","loggedOut",usr.getUserName());
            usr.Logout();
        }
        return "loggedOut";
    }


    public String homeLink_action() {
        // TODO: Replace with your code
        
        return "home";
    }
}
