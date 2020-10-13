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
 * For train traffic control different types of routes are used. Each particular type has its IM specifics which are defined in the operational rules. Here the generic classification is done.
 * 
 * <p>Java-Klasse für GenericRouteType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GenericRouteType">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="genericRouteType" use="required" type="{https://www.railml.org/schemas/3.1}tGenericRouteTypeExt" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericRouteType")
public class GenericRouteType
    extends EntityIL
{

    @XmlAttribute(name = "genericRouteType", required = true)
    protected String genericRouteType;

    /**
     * Ruft den Wert der genericRouteType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenericRouteType() {
        return genericRouteType;
    }

    /**
     * Legt den Wert der genericRouteType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenericRouteType(String value) {
        this.genericRouteType = value;
    }

}
