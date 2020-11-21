//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:06:07 PM CEST 
//


package org.railMl.rtm4rail;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RTM_LevelNetwork complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RTM_LevelNetwork">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}RTM_BaseObject">
 *       &lt;sequence>
 *         &lt;element name="networkResource" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="descriptionLevel" type="{https://www.railml.org/schemas/3.1}tDescriptionLevel" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTM_LevelNetwork", propOrder = {
    "networkResource"
})
public class RTMLevelNetwork
    extends RTMBaseObject
{

    protected List<TElementWithIDref> networkResource;
    @XmlAttribute(name = "descriptionLevel")
    protected TDescriptionLevel descriptionLevel;

    /**
     * Gets the value of the networkResource property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the networkResource property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetworkResource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getNetworkResource() {
        if (networkResource == null) {
            networkResource = new ArrayList<TElementWithIDref>();
        }
        return this.networkResource;
    }

    /**
     * Ruft den Wert der descriptionLevel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TDescriptionLevel }
     *     
     */
    public TDescriptionLevel getDescriptionLevel() {
        return descriptionLevel;
    }

    /**
     * Legt den Wert der descriptionLevel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TDescriptionLevel }
     *     
     */
    public void setDescriptionLevel(TDescriptionLevel value) {
        this.descriptionLevel = value;
    }

}
