/*
 * StringPrivProperty.java
 *
 * Created on 14 јпрель 2006 г., 13:41
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
public class StringPrivProperty extends PrivProperty {
    
    /** Creates a new instance of StringPrivProperty */
    public StringPrivProperty() {
        super();
    }

    /**
     * Holds value of property value.
     */
    private String value;

    /**
     * Getter for property value.
     * @return Value of property value.
     */
    public String getValue() {

        return this.value;
    }

    /**
     * Setter for property value.
     * @param value New value of property value.
     */
    public void setValue(String value) {

        this.value = value;
    }
    
}
