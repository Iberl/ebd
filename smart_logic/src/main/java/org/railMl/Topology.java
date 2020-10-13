//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * This is the top level element for railML3 topology model.
 * 
 * <p>Java-Klasse für Topology complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Topology">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="netElements" type="{https://www.railml.org/schemas/3.1}NetElements"/>
 *         &lt;element name="netRelations" type="{https://www.railml.org/schemas/3.1}NetRelations" minOccurs="0"/>
 *         &lt;element name="networks" type="{https://www.railml.org/schemas/3.1}Networks"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Topology", propOrder = {
    "netElements",
    "netRelations",
    "networks"
})
public class Topology {

    @XmlElement(required = true)
    protected NetElements netElements;
    protected NetRelations netRelations;
    @XmlElement(required = true)
    protected Networks networks;

    /**
     * Ruft den Wert der netElements-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NetElements }
     *     
     */
    public NetElements getNetElements() {
        return netElements;
    }

    /**
     * Legt den Wert der netElements-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NetElements }
     *     
     */
    public void setNetElements(NetElements value) {
        this.netElements = value;
    }

    /**
     * Ruft den Wert der netRelations-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NetRelations }
     *     
     */
    public NetRelations getNetRelations() {
        return netRelations;
    }

    /**
     * Legt den Wert der netRelations-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NetRelations }
     *     
     */
    public void setNetRelations(NetRelations value) {
        this.netRelations = value;
    }

    /**
     * Ruft den Wert der networks-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Networks }
     *     
     */
    public Networks getNetworks() {
        return networks;
    }

    /**
     * Legt den Wert der networks-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Networks }
     *     
     */
    public void setNetworks(Networks value) {
        this.networks = value;
    }

}
