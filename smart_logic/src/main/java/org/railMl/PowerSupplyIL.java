//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Interlocking specific features of the power supply
 * 
 * <p>Java-Klasse für PowerSupplyIL complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PowerSupplyIL">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="numberOfSimultaneousSwitchingActuators" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="signalVoltageMode" type="{https://www.railml.org/schemas/3.1}tSignalVoltageModes" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PowerSupplyIL")
public class PowerSupplyIL
    extends EntityIL
{

    @XmlAttribute(name = "numberOfSimultaneousSwitchingActuators")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfSimultaneousSwitchingActuators;
    @XmlAttribute(name = "signalVoltageMode")
    protected TSignalVoltageModes signalVoltageMode;

    /**
     * Ruft den Wert der numberOfSimultaneousSwitchingActuators-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfSimultaneousSwitchingActuators() {
        return numberOfSimultaneousSwitchingActuators;
    }

    /**
     * Legt den Wert der numberOfSimultaneousSwitchingActuators-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfSimultaneousSwitchingActuators(BigInteger value) {
        this.numberOfSimultaneousSwitchingActuators = value;
    }

    /**
     * Ruft den Wert der signalVoltageMode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TSignalVoltageModes }
     *     
     */
    public TSignalVoltageModes getSignalVoltageMode() {
        return signalVoltageMode;
    }

    /**
     * Legt den Wert der signalVoltageMode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TSignalVoltageModes }
     *     
     */
    public void setSignalVoltageMode(TSignalVoltageModes value) {
        this.signalVoltageMode = value;
    }

}
