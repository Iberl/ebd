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
 * For operational purpose of the interlocking some elements are grouped together. This allows e.g. commanding them with only one command.
 * 
 * <p>Java-Klasse für ElementGroup complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ElementGroup">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="groupType" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="refersToMember" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded"/>
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
@XmlType(name = "ElementGroup", propOrder = {
    "groupType",
    "refersToMember"
})
public class ElementGroup
    extends EntityIL
{

    @XmlElement(required = true)
    protected EntityILref groupType;
    @XmlElement(required = true)
    protected List<EntityILref> refersToMember;

    /**
     * Ruft den Wert der groupType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getGroupType() {
        return groupType;
    }

    /**
     * Legt den Wert der groupType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setGroupType(EntityILref value) {
        this.groupType = value;
    }

    /**
     * Gets the value of the refersToMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refersToMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefersToMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getRefersToMember() {
        if (refersToMember == null) {
            refersToMember = new ArrayList<EntityILref>();
        }
        return this.refersToMember;
    }

}
