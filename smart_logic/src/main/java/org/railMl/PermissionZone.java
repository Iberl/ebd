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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * A restricted area inside a station which can be controlled from a different controller as the rest of the station
 * 
 * <p>Java-Klasse für PermissionZone complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PermissionZone">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}TrackAsset">
 *       &lt;sequence>
 *         &lt;element name="canBeControlledBy" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded"/>
 *         &lt;element name="controlledElement" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded"/>
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
@XmlType(name = "PermissionZone", propOrder = {
    "canBeControlledBy",
    "controlledElement"
})
public class PermissionZone
    extends TrackAsset
{

    @XmlElement(required = true)
    protected List<EntityILref> canBeControlledBy;
    @XmlElement(required = true)
    protected List<EntityILref> controlledElement;

    /**
     * Gets the value of the canBeControlledBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the canBeControlledBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCanBeControlledBy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getCanBeControlledBy() {
        if (canBeControlledBy == null) {
            canBeControlledBy = new ArrayList<EntityILref>();
        }
        return this.canBeControlledBy;
    }

    /**
     * Gets the value of the controlledElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controlledElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControlledElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getControlledElement() {
        if (controlledElement == null) {
            controlledElement = new ArrayList<EntityILref>();
        }
        return this.controlledElement;
    }

}
