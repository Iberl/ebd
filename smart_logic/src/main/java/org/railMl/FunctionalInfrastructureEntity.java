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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für FunctionalInfrastructureEntity complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FunctionalInfrastructureEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIS">
 *       &lt;sequence>
 *         &lt;element name="designator" type="{https://www.railml.org/schemas/3.1}Designator" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="external" type="{https://www.railml.org/schemas/3.1}External" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "FunctionalInfrastructureEntity", propOrder = {
    "designator",
    "external"
})
@XmlSeeAlso({
    StoppingPlace.class,
    TrackGauge.class,
    Line.class,
    TrackBed.class,
    ElectrificationSection.class,
    DerailerIS.class,
    TrainDetectionElement.class,
    LoadingGauge.class,
    Track.class,
    KeyLockIS.class,
    WeightLimit.class,
    ServiceSection.class,
    RestrictionArea.class,
    TrainProtectionElement.class,
    Platform.class,
    TrackNode.class,
    Balise.class,
    TrainRadio.class,
    OperationalPoint.class,
    SpeedSection.class,
    SignalIS.class,
    XCrossing.class
})
public abstract class FunctionalInfrastructureEntity
    extends EntityIS
{

    protected List<Designator> designator;
    protected List<External> external;

    /**
     * Gets the value of the designator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the designator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDesignator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Designator }
     * 
     * 
     */
    public List<Designator> getDesignator() {
        if (designator == null) {
            designator = new ArrayList<Designator>();
        }
        return this.designator;
    }

    /**
     * Gets the value of the external property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the external property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExternal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link External }
     * 
     * 
     */
    public List<External> getExternal() {
        if (external == null) {
            external = new ArrayList<External>();
        }
        return this.external;
    }

}
