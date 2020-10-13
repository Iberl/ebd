//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:05:07 PM CEST 
//


package org.railMl.common;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RTM_AssociatedPositioningSystem complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RTM_AssociatedPositioningSystem">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}RTM_BaseObject">
 *       &lt;sequence>
 *         &lt;element name="intrinsicCoordinate" type="{https://www.railml.org/schemas/3.1}RTM_IntrinsicCoordinate" maxOccurs="unbounded"/>
 *         &lt;element name="isValid" type="{https://www.railml.org/schemas/3.1}RTM_Validity" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="positioningSystemRef" type="{https://www.railml.org/schemas/3.1}tRef" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTM_AssociatedPositioningSystem", propOrder = {
    "intrinsicCoordinate",
    "isValid"
})
public class RTMAssociatedPositioningSystem
    extends RTMBaseObject
{

    @XmlElement(required = true)
    protected List<RTMIntrinsicCoordinate> intrinsicCoordinate;
    protected List<RTMValidity> isValid;
    @XmlAttribute(name = "positioningSystemRef")
    protected String positioningSystemRef;

    /**
     * Gets the value of the intrinsicCoordinate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the intrinsicCoordinate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntrinsicCoordinate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RTMIntrinsicCoordinate }
     * 
     * 
     */
    public List<RTMIntrinsicCoordinate> getIntrinsicCoordinate() {
        if (intrinsicCoordinate == null) {
            intrinsicCoordinate = new ArrayList<RTMIntrinsicCoordinate>();
        }
        return this.intrinsicCoordinate;
    }

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

    /**
     * Ruft den Wert der positioningSystemRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPositioningSystemRef() {
        return positioningSystemRef;
    }

    /**
     * Legt den Wert der positioningSystemRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPositioningSystemRef(String value) {
        this.positioningSystemRef = value;
    }

}
