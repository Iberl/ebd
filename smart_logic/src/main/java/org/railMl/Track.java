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
 * A Track is defined by a railway section between two switches/crossings or between a switch/crossing and a buffer stop.
 * 
 * <p>Java-Klasse für Track complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Track">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}FunctionalInfrastructureEntity">
 *       &lt;sequence>
 *         &lt;element name="trackBegin" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" minOccurs="0"/>
 *         &lt;element name="trackEnd" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" minOccurs="0"/>
 *         &lt;element name="length" type="{https://www.railml.org/schemas/3.1}Length" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{https://www.railml.org/schemas/3.1}tTrackType" />
 *       &lt;attribute name="infrastructureManagerRef" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;attribute name="mainDirection" type="{https://www.railml.org/schemas/3.1}tExtendedDirection" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Track", propOrder = {
    "trackBegin",
    "trackEnd",
    "length"
})
public class Track
    extends FunctionalInfrastructureEntity
{

    protected TElementWithIDref trackBegin;
    protected TElementWithIDref trackEnd;
    @XmlElement(required = true)
    protected List<Length> length;
    @XmlAttribute(name = "type", required = true)
    protected TTrackType type;
    @XmlAttribute(name = "infrastructureManagerRef")
    protected String infrastructureManagerRef;
    @XmlAttribute(name = "mainDirection")
    protected TExtendedDirection mainDirection;

    /**
     * Ruft den Wert der trackBegin-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TElementWithIDref }
     *     
     */
    public TElementWithIDref getTrackBegin() {
        return trackBegin;
    }

    /**
     * Legt den Wert der trackBegin-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TElementWithIDref }
     *     
     */
    public void setTrackBegin(TElementWithIDref value) {
        this.trackBegin = value;
    }

    /**
     * Ruft den Wert der trackEnd-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TElementWithIDref }
     *     
     */
    public TElementWithIDref getTrackEnd() {
        return trackEnd;
    }

    /**
     * Legt den Wert der trackEnd-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TElementWithIDref }
     *     
     */
    public void setTrackEnd(TElementWithIDref value) {
        this.trackEnd = value;
    }

    /**
     * Gets the value of the length property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the length property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLength().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Length }
     * 
     * 
     */
    public List<Length> getLength() {
        if (length == null) {
            length = new ArrayList<Length>();
        }
        return this.length;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TTrackType }
     *     
     */
    public TTrackType getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TTrackType }
     *     
     */
    public void setType(TTrackType value) {
        this.type = value;
    }

    /**
     * Ruft den Wert der infrastructureManagerRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfrastructureManagerRef() {
        return infrastructureManagerRef;
    }

    /**
     * Legt den Wert der infrastructureManagerRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfrastructureManagerRef(String value) {
        this.infrastructureManagerRef = value;
    }

    /**
     * Ruft den Wert der mainDirection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TExtendedDirection }
     *     
     */
    public TExtendedDirection getMainDirection() {
        return mainDirection;
    }

    /**
     * Legt den Wert der mainDirection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TExtendedDirection }
     *     
     */
    public void setMainDirection(TExtendedDirection value) {
        this.mainDirection = value;
    }

}
