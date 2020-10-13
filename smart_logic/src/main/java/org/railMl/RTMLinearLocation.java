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
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RTM_LinearLocation complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RTM_LinearLocation">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}RTM_EntityLocation">
 *       &lt;sequence>
 *         &lt;element name="associatedNetElement" type="{https://www.railml.org/schemas/3.1}RTM_AssociatedNetElement" maxOccurs="unbounded"/>
 *         &lt;element name="linearCoordinate" type="{https://www.railml.org/schemas/3.1}RTM_LinearCoordinate" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="geometricCoordinate" type="{https://www.railml.org/schemas/3.1}RTM_GeometricCoordinate" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="applicationDirection" type="{https://www.railml.org/schemas/3.1}tApplicationDirection" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTM_LinearLocation", propOrder = {
    "associatedNetElement",
    "linearCoordinate",
    "geometricCoordinate"
})
public class RTMLinearLocation
    extends RTMEntityLocation
{

    @XmlElement(required = true)
    protected List<RTMAssociatedNetElement> associatedNetElement;
    protected List<RTMLinearCoordinate> linearCoordinate;
    protected List<RTMGeometricCoordinate> geometricCoordinate;
    @XmlAttribute(name = "applicationDirection")
    protected TApplicationDirection applicationDirection;

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
    public List<RTMAssociatedNetElement> getAssociatedNetElement() {
        if (associatedNetElement == null) {
            associatedNetElement = new ArrayList<RTMAssociatedNetElement>();
        }
        return this.associatedNetElement;
    }

    /**
     * Gets the value of the linearCoordinate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linearCoordinate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinearCoordinate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RTMLinearCoordinate }
     * 
     * 
     */
    public List<RTMLinearCoordinate> getLinearCoordinate() {
        if (linearCoordinate == null) {
            linearCoordinate = new ArrayList<RTMLinearCoordinate>();
        }
        return this.linearCoordinate;
    }

    /**
     * Gets the value of the geometricCoordinate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geometricCoordinate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeometricCoordinate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RTMGeometricCoordinate }
     * 
     * 
     */
    public List<RTMGeometricCoordinate> getGeometricCoordinate() {
        if (geometricCoordinate == null) {
            geometricCoordinate = new ArrayList<RTMGeometricCoordinate>();
        }
        return this.geometricCoordinate;
    }

    /**
     * Ruft den Wert der applicationDirection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TApplicationDirection }
     *     
     */
    public TApplicationDirection getApplicationDirection() {
        return applicationDirection;
    }

    /**
     * Legt den Wert der applicationDirection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TApplicationDirection }
     *     
     */
    public void setApplicationDirection(TApplicationDirection value) {
        this.applicationDirection = value;
    }

}
