//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:06:07 PM CEST 
//


package org.railMl.rtm4rail;

import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r RTM_Relation complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RTM_Relation">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}RTM_NetworkResource">
 *       &lt;sequence>
 *         &lt;element name="elementA" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" form="qualified"/>
 *         &lt;element name="elementB" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" form="qualified"/>
 *       &lt;/sequence>
 *       &lt;attribute name="navigability" type="{https://www.railml.org/schemas/3.1}tNavigability" />
 *       &lt;attribute name="positionOnA" type="{https://www.railml.org/schemas/3.1}tUsage" />
 *       &lt;attribute name="positionOnB" type="{https://www.railml.org/schemas/3.1}tUsage" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTM_Relation", propOrder = {
    "elementA",
    "elementB"
})
public class RTMRelation
    extends RTMNetworkResource
{

    @XmlElement(required = true)
    protected TElementWithIDref elementA;
    @XmlElement(required = true)
    protected TElementWithIDref elementB;
    @XmlAttribute(name = "navigability")
    protected TNavigability navigability;
    @XmlAttribute(name = "positionOnA")
    protected BigInteger positionOnA;
    @XmlAttribute(name = "positionOnB")
    protected BigInteger positionOnB;

    /**
     * Ruft den Wert der elementA-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TElementWithIDref }
     *     
     */
    public TElementWithIDref getElementA() {
        return elementA;
    }

    /**
     * Legt den Wert der elementA-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TElementWithIDref }
     *     
     */
    public void setElementA(TElementWithIDref value) {
        this.elementA = value;
    }

    /**
     * Ruft den Wert der elementB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TElementWithIDref }
     *     
     */
    public TElementWithIDref getElementB() {
        return elementB;
    }

    /**
     * Legt den Wert der elementB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TElementWithIDref }
     *     
     */
    public void setElementB(TElementWithIDref value) {
        this.elementB = value;
    }

    /**
     * Ruft den Wert der navigability-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TNavigability }
     *     
     */
    public TNavigability getNavigability() {
        return navigability;
    }

    /**
     * Legt den Wert der navigability-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TNavigability }
     *     
     */
    public void setNavigability(TNavigability value) {
        this.navigability = value;
    }

    /**
     * Ruft den Wert der positionOnA-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPositionOnA() {
        return positionOnA;
    }

    /**
     * Legt den Wert der positionOnA-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPositionOnA(BigInteger value) {
        this.positionOnA = value;
    }

    /**
     * Ruft den Wert der positionOnB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPositionOnB() {
        return positionOnB;
    }

    /**
     * Legt den Wert der positionOnB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPositionOnB(BigInteger value) {
        this.positionOnB = value;
    }

}
