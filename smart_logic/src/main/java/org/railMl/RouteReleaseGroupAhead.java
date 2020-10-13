//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * A route section is a partial route situated ahead of a train. In order to prevent that a stopped train locks down the remaining route, such a partial route can be released. Condition for release are expiry of a timer and/or an operator command as prescribed by the IM rules and regulations. This is especially used for ERTMS MA sections.
 * 
 * <p>Java-Klasse für RouteReleaseGroupAhead complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RouteReleaseGroupAhead">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}PartialRoute">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="isAutomatic" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RouteReleaseGroupAhead")
public class RouteReleaseGroupAhead
    extends PartialRoute
{

    @XmlAttribute(name = "isAutomatic")
    protected Boolean isAutomatic;

    /**
     * Ruft den Wert der isAutomatic-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsAutomatic() {
        return isAutomatic;
    }

    /**
     * Legt den Wert der isAutomatic-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsAutomatic(Boolean value) {
        this.isAutomatic = value;
    }

}
