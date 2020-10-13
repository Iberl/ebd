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
 * Iness definition:
 * The route conflict table identifies the routes that may never be simultaneously allocated, due to utilisation of common track elements.
 * 
 * <p>Java-Klasse für ConflictingRoute complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ConflictingRoute">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="refersToRoute" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="conflictsWithRoute" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded"/>
 *         &lt;element name="reasonForConflict" type="{https://www.railml.org/schemas/3.1}ConflictReason" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "ConflictingRoute", propOrder = {
    "refersToRoute",
    "conflictsWithRoute",
    "reasonForConflict"
})
public class ConflictingRoute
    extends EntityIL
{

    @XmlElement(required = true)
    protected EntityILref refersToRoute;
    @XmlElement(required = true)
    protected List<EntityILref> conflictsWithRoute;
    protected List<ConflictReason> reasonForConflict;

    /**
     * Ruft den Wert der refersToRoute-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getRefersToRoute() {
        return refersToRoute;
    }

    /**
     * Legt den Wert der refersToRoute-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setRefersToRoute(EntityILref value) {
        this.refersToRoute = value;
    }

    /**
     * Gets the value of the conflictsWithRoute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conflictsWithRoute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConflictsWithRoute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getConflictsWithRoute() {
        if (conflictsWithRoute == null) {
            conflictsWithRoute = new ArrayList<EntityILref>();
        }
        return this.conflictsWithRoute;
    }

    /**
     * Gets the value of the reasonForConflict property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reasonForConflict property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReasonForConflict().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConflictReason }
     * 
     * 
     */
    public List<ConflictReason> getReasonForConflict() {
        if (reasonForConflict == null) {
            reasonForConflict = new ArrayList<ConflictReason>();
        }
        return this.reasonForConflict;
    }

}
