//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:06:07 PM CEST 
//


package org.railMl.rtm4rail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RTM_AreaLocation complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RTM_AreaLocation">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}RTM_EntityLocation">
 *       &lt;sequence>
 *         &lt;element name="associatedNetElement" type="{https://www.railml.org/schemas/3.1}RTM_AssociatedNetElement" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTM_AreaLocation", propOrder = {
    "associatedNetElement"
})
public class RTMAreaLocation
    extends RTMBaseObject implements de.ibw.rtm.intf.IRTMAreaLocation {

    @XmlElement(required = true)
    protected List<RTMAssociatedNetElement> associatedNetElement;

    /**
     * Gets the value of the associatedNetElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the associatedNetElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssociatedNetElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RTMAssociatedNetElement }
     * 
     * 
     */
    @Override
    public List<RTMAssociatedNetElement> getAssociatedNetElement() {
        if (associatedNetElement == null) {
            associatedNetElement = new ArrayList<RTMAssociatedNetElement>();
        }
        return this.associatedNetElement;
    }

}
