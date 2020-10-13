//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.math.BigDecimal;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für WeightLimit complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="WeightLimit">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}FunctionalInfrastructureEntity">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="axleLoad" type="{https://www.railml.org/schemas/3.1}tWeightTons" />
 *       &lt;attribute name="meterLoad" type="{https://www.railml.org/schemas/3.1}tMeterloadTonsPerMeter" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WeightLimit")
public class WeightLimit
    extends FunctionalInfrastructureEntity
{

    @XmlAttribute(name = "axleLoad")
    protected BigDecimal axleLoad;
    @XmlAttribute(name = "meterLoad")
    protected BigDecimal meterLoad;

    /**
     * Ruft den Wert der axleLoad-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAxleLoad() {
        return axleLoad;
    }

    /**
     * Legt den Wert der axleLoad-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAxleLoad(BigDecimal value) {
        this.axleLoad = value;
    }

    /**
     * Ruft den Wert der meterLoad-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMeterLoad() {
        return meterLoad;
    }

    /**
     * Legt den Wert der meterLoad-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMeterLoad(BigDecimal value) {
        this.meterLoad = value;
    }

}
