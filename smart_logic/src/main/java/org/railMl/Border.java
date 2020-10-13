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
import jakarta.xml.bind.annotation.XmlType;


/**
 * A border point is used to separate the railway network due to different reasons. Typical examples are country borders, the change of owning infrastructure manager or the border of a station.
 * 
 * <p>Java-Klasse für Border complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Border">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}TrackNode">
 *       &lt;sequence>
 *         &lt;element name="markedByInfrastructureElement" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="isOpenEnd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="externalRef" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" use="required" type="{https://www.railml.org/schemas/3.1}tBorderTypeExt" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Border", propOrder = {
    "markedByInfrastructureElement"
})
public class Border
    extends TrackNode
{

    protected List<TElementWithIDref> markedByInfrastructureElement;
    @XmlAttribute(name = "isOpenEnd")
    protected Boolean isOpenEnd;
    @XmlAttribute(name = "externalRef")
    protected String externalRef;
    @XmlAttribute(name = "type", required = true)
    protected String type;

    /**
     * Gets the value of the markedByInfrastructureElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the markedByInfrastructureElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMarkedByInfrastructureElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getMarkedByInfrastructureElement() {
        if (markedByInfrastructureElement == null) {
            markedByInfrastructureElement = new ArrayList<TElementWithIDref>();
        }
        return this.markedByInfrastructureElement;
    }

    /**
     * Ruft den Wert der isOpenEnd-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOpenEnd() {
        return isOpenEnd;
    }

    /**
     * Legt den Wert der isOpenEnd-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOpenEnd(Boolean value) {
        this.isOpenEnd = value;
    }

    /**
     * Ruft den Wert der externalRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalRef() {
        return externalRef;
    }

    /**
     * Legt den Wert der externalRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalRef(String value) {
        this.externalRef = value;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
