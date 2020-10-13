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
 * This is the root element of any railML file.
 * 
 * <p>Java-Klasse für railML complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="railML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="metadata" type="{https://www.railml.org/schemas/3.1}Metadata" minOccurs="0"/>
 *         &lt;element name="common" type="{https://www.railml.org/schemas/3.1}Common" minOccurs="0"/>
 *         &lt;element name="infrastructure" type="{https://www.railml.org/schemas/3.1}Infrastructure" minOccurs="0"/>
 *         &lt;element name="interlocking" type="{https://www.railml.org/schemas/3.1}Interlocking" minOccurs="0"/>
 *         &lt;element name="rollingstock" type="{https://www.railml.org/schemas/3.1}Rollingstock" minOccurs="0"/>
 *         &lt;element name="timetable" type="{https://www.railml.org/schemas/3.1}Timetable" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attGroup ref="{https://www.railml.org/schemas/3.1}aRailML"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "railML", propOrder = {

})
public class RailML {

    protected Metadata metadata;
    protected Common common;
    protected Infrastructure infrastructure;
    protected Interlocking interlocking;
    protected Rollingstock rollingstock;
    protected Timetable timetable;
    @XmlAttribute(name = "version", required = true)
    protected String version;

    /**
     * Ruft den Wert der metadata-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Metadata }
     *     
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * Legt den Wert der metadata-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Metadata }
     *     
     */
    public void setMetadata(Metadata value) {
        this.metadata = value;
    }

    /**
     * Ruft den Wert der common-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Common }
     *     
     */
    public Common getCommon() {
        return common;
    }

    /**
     * Legt den Wert der common-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Common }
     *     
     */
    public void setCommon(Common value) {
        this.common = value;
    }

    /**
     * Ruft den Wert der infrastructure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Infrastructure }
     *     
     */
    public Infrastructure getInfrastructure() {
        return infrastructure;
    }

    /**
     * Legt den Wert der infrastructure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Infrastructure }
     *     
     */
    public void setInfrastructure(Infrastructure value) {
        this.infrastructure = value;
    }

    /**
     * Ruft den Wert der interlocking-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Interlocking }
     *     
     */
    public Interlocking getInterlocking() {
        return interlocking;
    }

    /**
     * Legt den Wert der interlocking-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Interlocking }
     *     
     */
    public void setInterlocking(Interlocking value) {
        this.interlocking = value;
    }

    /**
     * Ruft den Wert der rollingstock-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Rollingstock }
     *     
     */
    public Rollingstock getRollingstock() {
        return rollingstock;
    }

    /**
     * Legt den Wert der rollingstock-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Rollingstock }
     *     
     */
    public void setRollingstock(Rollingstock value) {
        this.rollingstock = value;
    }

    /**
     * Ruft den Wert der timetable-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Timetable }
     *     
     */
    public Timetable getTimetable() {
        return timetable;
    }

    /**
     * Legt den Wert der timetable-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Timetable }
     *     
     */
    public void setTimetable(Timetable value) {
        this.timetable = value;
    }

    /**
     * Ruft den Wert der version-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Legt den Wert der version-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
