//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Overlap is set in lockstep with the route. The interlocking releases the overlap when it is safe to presume that an approaching train will not overrun a closed destination signal. When the train occupied the last section (or destination area), an overlap release timer starts running. The timer value is defined by operational rules and the approaching speed. Upon expiry, the interlocking releases the overlap. Overlap is released together with the route or after expiration of the release timer. Overlap is released after a defined time in a timer that starts from a timerTriggerPoint.
 * 
 * <p>Java-Klasse f�r OverlapRelease complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="OverlapRelease">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="releaseTriggerSection" type="{https://www.railml.org/schemas/3.1}EntityILref" minOccurs="0"/>
 *         &lt;element name="overlapReleaseTimer" type="{https://www.railml.org/schemas/3.1}OverlapReleaseTimer" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OverlapRelease", propOrder = {
    "releaseTriggerSection",
    "overlapReleaseTimer"
})
public class OverlapRelease
    extends EntityIL
{

    protected EntityILref releaseTriggerSection;
    @XmlElement(required = true)
    protected List<OverlapReleaseTimer> overlapReleaseTimer;

    /**
     * Ruft den Wert der releaseTriggerSection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getReleaseTriggerSection() {
        return releaseTriggerSection;
    }

    /**
     * Legt den Wert der releaseTriggerSection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setReleaseTriggerSection(EntityILref value) {
        this.releaseTriggerSection = value;
    }

    /**
     * Gets the value of the overlapReleaseTimer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the overlapReleaseTimer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOverlapReleaseTimer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OverlapReleaseTimer }
     * 
     * 
     */
    public List<OverlapReleaseTimer> getOverlapReleaseTimer() {
        if (overlapReleaseTimer == null) {
            overlapReleaseTimer = new ArrayList<OverlapReleaseTimer>();
        }
        return this.overlapReleaseTimer;
    }

}
