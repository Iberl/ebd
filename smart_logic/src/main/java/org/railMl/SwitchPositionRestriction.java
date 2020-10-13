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
 * For some relations between movable elements restrictions apply concerning the combination of both elements positions.
 * 
 * <p>Java-Klasse für SwitchPositionRestriction complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SwitchPositionRestriction">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="relatedSwitchInPosition" type="{https://www.railml.org/schemas/3.1}SwitchAndPosition" minOccurs="0"/>
 *         &lt;element name="relatedDerailerInPosition" type="{https://www.railml.org/schemas/3.1}DerailerAndPosition" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="restrictedPosition" use="required" type="{https://www.railml.org/schemas/3.1}tSwitchPosition" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SwitchPositionRestriction", propOrder = {
    "relatedSwitchInPosition",
    "relatedDerailerInPosition"
})
public class SwitchPositionRestriction
    extends EntityIL
{

    protected SwitchAndPosition relatedSwitchInPosition;
    protected DerailerAndPosition relatedDerailerInPosition;
    @XmlAttribute(name = "restrictedPosition", required = true)
    protected TSwitchPosition restrictedPosition;

    /**
     * Ruft den Wert der relatedSwitchInPosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SwitchAndPosition }
     *     
     */
    public SwitchAndPosition getRelatedSwitchInPosition() {
        return relatedSwitchInPosition;
    }

    /**
     * Legt den Wert der relatedSwitchInPosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SwitchAndPosition }
     *     
     */
    public void setRelatedSwitchInPosition(SwitchAndPosition value) {
        this.relatedSwitchInPosition = value;
    }

    /**
     * Ruft den Wert der relatedDerailerInPosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DerailerAndPosition }
     *     
     */
    public DerailerAndPosition getRelatedDerailerInPosition() {
        return relatedDerailerInPosition;
    }

    /**
     * Legt den Wert der relatedDerailerInPosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DerailerAndPosition }
     *     
     */
    public void setRelatedDerailerInPosition(DerailerAndPosition value) {
        this.relatedDerailerInPosition = value;
    }

    /**
     * Ruft den Wert der restrictedPosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TSwitchPosition }
     *     
     */
    public TSwitchPosition getRestrictedPosition() {
        return restrictedPosition;
    }

    /**
     * Legt den Wert der restrictedPosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TSwitchPosition }
     *     
     */
    public void setRestrictedPosition(TSwitchPosition value) {
        this.restrictedPosition = value;
    }

}
