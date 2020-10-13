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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * A partial route is a subset of TVD sections within the route. This subset can be used, e.g. for release if the conditions prescribed by the IM rules are fulfilled.
 * 
 * <p>Java-Klasse für PartialRoute complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PartialRoute">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="hasTvdSection" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="delay" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="typicalDelay" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartialRoute", propOrder = {
    "hasTvdSection"
})
@XmlSeeAlso({
    RouteReleaseGroupRear.class,
    RouteReleaseGroupAhead.class
})
public abstract class PartialRoute
    extends EntityIL
{

    protected List<EntityILref> hasTvdSection;
    @XmlAttribute(name = "delay")
    protected Duration delay;
    @XmlAttribute(name = "typicalDelay")
    protected Duration typicalDelay;

    /**
     * Gets the value of the hasTvdSection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasTvdSection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasTvdSection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getHasTvdSection() {
        if (hasTvdSection == null) {
            hasTvdSection = new ArrayList<EntityILref>();
        }
        return this.hasTvdSection;
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

    /**
     * Ruft den Wert der typicalDelay-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getTypicalDelay() {
        return typicalDelay;
    }

    /**
     * Legt den Wert der typicalDelay-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setTypicalDelay(Duration value) {
        this.typicalDelay = value;
    }

}
