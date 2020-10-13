//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * CombinedRoute is a concatenation of single routes providing a continuous path for traffic movement which the interlocking can activate by one action.
 * As itinerary it is a list of routes describing the train path trough a network.
 * 
 * <p>Java-Klasse für CombinedRoute complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CombinedRoute">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="comboEntry" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="comboExit" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="containsRoute" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CombinedRoute", propOrder = {
    "comboEntry",
    "comboExit",
    "containsRoute"
})
public class CombinedRoute
    extends EntityIL
{

    @XmlElement(required = true)
    protected EntityILref comboEntry;
    @XmlElement(required = true)
    protected EntityILref comboExit;
    @XmlElement(required = true)
    protected List<EntityILref> containsRoute;

    /**
     * Ruft den Wert der comboEntry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getComboEntry() {
        return comboEntry;
    }

    /**
     * Legt den Wert der comboEntry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setComboEntry(EntityILref value) {
        this.comboEntry = value;
    }

    /**
     * Ruft den Wert der comboExit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getComboExit() {
        return comboExit;
    }

    /**
     * Legt den Wert der comboExit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setComboExit(EntityILref value) {
        this.comboExit = value;
    }

    /**
     * Gets the value of the containsRoute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the containsRoute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContainsRoute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getContainsRoute() {
        if (containsRoute == null) {
            containsRoute = new ArrayList<EntityILref>();
        }
        return this.containsRoute;
    }

}
