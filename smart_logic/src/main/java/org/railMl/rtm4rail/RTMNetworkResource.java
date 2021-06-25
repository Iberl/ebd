//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:06:07 PM CEST 
//


package org.railMl.rtm4rail;

import java.util.ArrayList;
import java.util.List;

import de.ibw.rtm.intf.IRTMNetworkResource;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RTM_NetworkResource complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RTM_NetworkResource">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}RTM_NamedResource">
 *       &lt;sequence>
 *         &lt;element name="isValid" type="{https://www.railml.org/schemas/3.1}RTM_Validity" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTM_NetworkResource", propOrder = {
    "isValid"
})
@XmlSeeAlso({
    RTMRelation.class,
    RTMNetEntity.class,
    RTMNetElement.class
})
public class RTMNetworkResource
    extends RTMNamedResource implements IRTMNetworkResource
{

    protected List<RTMValidity> isValid;

    /**
     * Gets the value of the isValid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the isValid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIsValid().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RTMValidity }
     * 
     * 
     */
    public List<RTMValidity> getIsValid() {
        if (isValid == null) {
            isValid = new ArrayList<RTMValidity>();
        }
        return this.isValid;
    }

}
