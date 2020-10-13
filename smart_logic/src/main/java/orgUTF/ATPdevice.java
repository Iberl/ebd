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
 * a minimal stub that merely creates a link between ATP and signals. The ATP state mostly derives from a signal at the entry of the ATP section. In some cases, the state can be a function of the aspect of both entry- and exit-signal. Note the need to include virtual signals where ATP changes the signalled speed. A changed speed is often accompanied by a passive trackside speed sign in order to synchronise wayside speed signalling with cabin speed signalling.
 * Not with railML3.1
 * 
 * <p>Java-Klasse für ATPdevice complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ATPdevice">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}TrackAsset">
 *       &lt;sequence>
 *         &lt;element name="atpType" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="device" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *         &lt;element name="exitSignal" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="2"/>
 *         &lt;element name="entrySignal" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="2"/>
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
@XmlType(name = "ATPdevice", propOrder = {
    "atpType",
    "device",
    "exitSignal",
    "entrySignal"
})
public abstract class ATPdevice
    extends TrackAsset
{

    @XmlElement(required = true)
    protected EntityILref atpType;
    @XmlElement(required = true)
    protected EntityILref device;
    @XmlElement(required = true)
    protected List<EntityILref> exitSignal;
    @XmlElement(required = true)
    protected List<EntityILref> entrySignal;

    /**
     * Ruft den Wert der atpType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getAtpType() {
        return atpType;
    }

    /**
     * Legt den Wert der atpType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setAtpType(EntityILref value) {
        this.atpType = value;
    }

    /**
     * Ruft den Wert der device-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getDevice() {
        return device;
    }

    /**
     * Legt den Wert der device-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setDevice(EntityILref value) {
        this.device = value;
    }

    /**
     * Gets the value of the exitSignal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exitSignal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExitSignal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getExitSignal() {
        if (exitSignal == null) {
            exitSignal = new ArrayList<EntityILref>();
        }
        return this.exitSignal;
    }

    /**
     * Gets the value of the entrySignal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entrySignal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntrySignal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getEntrySignal() {
        if (entrySignal == null) {
            entrySignal = new ArrayList<EntityILref>();
        }
        return this.entrySignal;
    }

}
