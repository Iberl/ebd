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
 * A controller is an individual terminal, commonly a workstation, that can control the interlocking. The controller is normally situated in a control centre. railML provides a logical link between an interlocking and the individual controller. The user can attach useful data to this link, such as addresses that may be granted control over this IL. railML will not define the nature of the addresses, i.e IP-addresses or hexadecimal address of terminals that communicate with the IL via some serial bus. The protocol (IP, UDP, serial, parallel) is irrelevant to railML. Note that a Control Centre (DE: Leitstelle, FR: Poste de controle, NL: VL-post) is likely to control multiple interlockings and vice versa, one interlocking can be controlled from multiple control centres, an n:m relation. This implies that a control centre can have multiple controllers, defined as a terminal from which a signal man controls an interlocking. The IL is unaware of the Control Centre but aware of the controller.
 * 
 * <p>Java-Klasse für Controller complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Controller">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="controlledAssets" type="{https://www.railml.org/schemas/3.1}ControlledAssets"/>
 *         &lt;element name="itineraries" type="{https://www.railml.org/schemas/3.1}Itineraries" minOccurs="0"/>
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
@XmlType(name = "Controller", propOrder = {
    "controlledAssets",
    "itineraries"
})
public class Controller
    extends EntityIL
{

    @XmlElement(required = true)
    protected ControlledAssets controlledAssets;
    protected Itineraries itineraries;

    /**
     * Ruft den Wert der controlledAssets-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ControlledAssets }
     *     
     */
    public ControlledAssets getControlledAssets() {
        return controlledAssets;
    }

    /**
     * Legt den Wert der controlledAssets-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ControlledAssets }
     *     
     */
    public void setControlledAssets(ControlledAssets value) {
        this.controlledAssets = value;
    }

    /**
     * Ruft den Wert der itineraries-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Itineraries }
     *     
     */
    public Itineraries getItineraries() {
        return itineraries;
    }

    /**
     * Legt den Wert der itineraries-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Itineraries }
     *     
     */
    public void setItineraries(Itineraries value) {
        this.itineraries = value;
    }

}
