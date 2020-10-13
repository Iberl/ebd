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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * The train detector and/or TVD section(s) that deactivates the level crossing. This may be the level crossing tracks, e.g. km 12.809/2, that would appear on signalling plans.
 * 
 * <p>Java-Klasse für LevelCrossingDeactivator complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LevelCrossingDeactivator">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="tvdDetectorRef" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *       &lt;/sequence>
 *       &lt;attribute name="delay" use="required" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LevelCrossingDeactivator", propOrder = {
    "tvdDetectorRef"
})
public class LevelCrossingDeactivator
    extends EntityIL
{

    @XmlElement(required = true)
    protected EntityILref tvdDetectorRef;
    @XmlAttribute(name = "delay", required = true)
    protected Duration delay;

    /**
     * Ruft den Wert der tvdDetectorRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getTvdDetectorRef() {
        return tvdDetectorRef;
    }

    /**
     * Legt den Wert der tvdDetectorRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setTvdDetectorRef(EntityILref value) {
        this.tvdDetectorRef = value;
    }

    /**
     * Ruft den Wert der delay-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDelay() {
        return delay;
    }

    /**
     * Legt den Wert der delay-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDelay(Duration value) {
        this.delay = value;
    }

}
