//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r SignalEtcs complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SignalEtcs">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}SignalX">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="srsVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignalEtcs")
public class SignalEtcs
    extends SignalX
{

    @XmlAttribute(name = "srsVersion")
    protected String srsVersion;

    /**
     * Ruft den Wert der srsVersion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrsVersion() {
        return srsVersion;
    }

    /**
     * Legt den Wert der srsVersion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrsVersion(String value) {
        this.srsVersion = value;
    }

}