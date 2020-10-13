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
import javax.xml.datatype.Duration;


/**
 * A device, also known as key lock (de: Schlüsselschalter) situated near the track. It is used to request local control of a (group of) track assets from the interlocking. Commonly, staff requests local control from the interlocking via this device. Once granted, the key can be removed upon which the (group of) track asset is no longer under interlocking control. In reverse, the interlocking takes back control when the key is inserted and staff acknowledged relinquishing control. Note that the lock is a track asset defined in infrastructure namespace. The interlocking reads the state of the lock and returns permission to remove the key, i.e. levelOfControl=fullControl. A combined lock has a master lock that controls a set of slave locks. Slave locks may have to be released in a well-defined sequence.
 * 
 * <p>Java-Klasse für KeyLockIL complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="KeyLockIL">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}LogicalDevice">
 *       &lt;sequence>
 *         &lt;element name="acceptsKey" type="{https://www.railml.org/schemas/3.1}EntityILref" minOccurs="0"/>
 *         &lt;element name="hasTvdSection" type="{https://www.railml.org/schemas/3.1}EntityILref" minOccurs="0"/>
 *         &lt;element name="hasSlaveLock" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="hasAutomaticKeyRelease" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="hasAutomaticKeyLock" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="keyRequestTime" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="keyAuthoriseTime" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeyLockIL", propOrder = {
    "acceptsKey",
    "hasTvdSection",
    "hasSlaveLock"
})
public class KeyLockIL
    extends LogicalDevice
{

    protected EntityILref acceptsKey;
    protected EntityILref hasTvdSection;
    protected List<EntityILref> hasSlaveLock;
    @XmlAttribute(name = "hasAutomaticKeyRelease")
    protected Boolean hasAutomaticKeyRelease;
    @XmlAttribute(name = "hasAutomaticKeyLock")
    protected Boolean hasAutomaticKeyLock;
    @XmlAttribute(name = "keyRequestTime")
    protected Duration keyRequestTime;
    @XmlAttribute(name = "keyAuthoriseTime")
    protected Duration keyAuthoriseTime;

    /**
     * Ruft den Wert der acceptsKey-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getAcceptsKey() {
        return acceptsKey;
    }

    /**
     * Legt den Wert der acceptsKey-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setAcceptsKey(EntityILref value) {
        this.acceptsKey = value;
    }

    /**
     * Ruft den Wert der hasTvdSection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getHasTvdSection() {
        return hasTvdSection;
    }

    /**
     * Legt den Wert der hasTvdSection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setHasTvdSection(EntityILref value) {
        this.hasTvdSection = value;
    }

    /**
     * Gets the value of the hasSlaveLock property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasSlaveLock property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasSlaveLock().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getHasSlaveLock() {
        if (hasSlaveLock == null) {
            hasSlaveLock = new ArrayList<EntityILref>();
        }
        return this.hasSlaveLock;
    }

    /**
     * Ruft den Wert der hasAutomaticKeyRelease-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasAutomaticKeyRelease() {
        return hasAutomaticKeyRelease;
    }

    /**
     * Legt den Wert der hasAutomaticKeyRelease-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasAutomaticKeyRelease(Boolean value) {
        this.hasAutomaticKeyRelease = value;
    }

    /**
     * Ruft den Wert der hasAutomaticKeyLock-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasAutomaticKeyLock() {
        return hasAutomaticKeyLock;
    }

    /**
     * Legt den Wert der hasAutomaticKeyLock-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasAutomaticKeyLock(Boolean value) {
        this.hasAutomaticKeyLock = value;
    }

    /**
     * Ruft den Wert der keyRequestTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getKeyRequestTime() {
        return keyRequestTime;
    }

    /**
     * Legt den Wert der keyRequestTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setKeyRequestTime(Duration value) {
        this.keyRequestTime = value;
    }

    /**
     * Ruft den Wert der keyAuthoriseTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getKeyAuthoriseTime() {
        return keyAuthoriseTime;
    }

    /**
     * Legt den Wert der keyAuthoriseTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setKeyAuthoriseTime(Duration value) {
        this.keyAuthoriseTime = value;
    }

}
