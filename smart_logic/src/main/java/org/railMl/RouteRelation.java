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
import jakarta.xml.bind.annotation.XmlType;


/**
 * A route relation states the conditions that must be fulfilled for a given signal to be open. Note that these relations may well be captured in a control table. Therefore, the use is optional.
 * 
 * <p>Java-Klasse für RouteRelation complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RouteRelation">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="requiredSwitchPosition" type="{https://www.railml.org/schemas/3.1}SwitchAndGivenPosition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="requiredDerailerPosition" type="{https://www.railml.org/schemas/3.1}DerailerAndGivenPosition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="requiredCrossingPosition" type="{https://www.railml.org/schemas/3.1}CrossingAndGivenPosition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="requiredDetectorState" type="{https://www.railml.org/schemas/3.1}DetectorAndGivenState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="requiredSignalAspect" type="{https://www.railml.org/schemas/3.1}SignalAndGivenAspect" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="requiredSectionState" type="{https://www.railml.org/schemas/3.1}SectionAndGivenVacancy" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="requiredKeyLockState" type="{https://www.railml.org/schemas/3.1}LockAndGivenState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="requiredLevelCrossingState" type="{https://www.railml.org/schemas/3.1}LevelCrossingAndGivenState" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "RouteRelation", propOrder = {
    "requiredSwitchPosition",
    "requiredDerailerPosition",
    "requiredCrossingPosition",
    "requiredDetectorState",
    "requiredSignalAspect",
    "requiredSectionState",
    "requiredKeyLockState",
    "requiredLevelCrossingState"
})
public class RouteRelation
    extends EntityIL
{

    protected List<SwitchAndGivenPosition> requiredSwitchPosition;
    protected List<DerailerAndGivenPosition> requiredDerailerPosition;
    protected List<CrossingAndGivenPosition> requiredCrossingPosition;
    protected List<DetectorAndGivenState> requiredDetectorState;
    protected List<SignalAndGivenAspect> requiredSignalAspect;
    protected List<SectionAndGivenVacancy> requiredSectionState;
    protected List<LockAndGivenState> requiredKeyLockState;
    protected List<LevelCrossingAndGivenState> requiredLevelCrossingState;

    /**
     * Gets the value of the requiredSwitchPosition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requiredSwitchPosition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequiredSwitchPosition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SwitchAndGivenPosition }
     * 
     * 
     */
    public List<SwitchAndGivenPosition> getRequiredSwitchPosition() {
        if (requiredSwitchPosition == null) {
            requiredSwitchPosition = new ArrayList<SwitchAndGivenPosition>();
        }
        return this.requiredSwitchPosition;
    }

    /**
     * Gets the value of the requiredDerailerPosition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requiredDerailerPosition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequiredDerailerPosition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DerailerAndGivenPosition }
     * 
     * 
     */
    public List<DerailerAndGivenPosition> getRequiredDerailerPosition() {
        if (requiredDerailerPosition == null) {
            requiredDerailerPosition = new ArrayList<DerailerAndGivenPosition>();
        }
        return this.requiredDerailerPosition;
    }

    /**
     * Gets the value of the requiredCrossingPosition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requiredCrossingPosition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequiredCrossingPosition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CrossingAndGivenPosition }
     * 
     * 
     */
    public List<CrossingAndGivenPosition> getRequiredCrossingPosition() {
        if (requiredCrossingPosition == null) {
            requiredCrossingPosition = new ArrayList<CrossingAndGivenPosition>();
        }
        return this.requiredCrossingPosition;
    }

    /**
     * Gets the value of the requiredDetectorState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requiredDetectorState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequiredDetectorState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetectorAndGivenState }
     * 
     * 
     */
    public List<DetectorAndGivenState> getRequiredDetectorState() {
        if (requiredDetectorState == null) {
            requiredDetectorState = new ArrayList<DetectorAndGivenState>();
        }
        return this.requiredDetectorState;
    }

    /**
     * Gets the value of the requiredSignalAspect property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requiredSignalAspect property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequiredSignalAspect().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignalAndGivenAspect }
     * 
     * 
     */
    public List<SignalAndGivenAspect> getRequiredSignalAspect() {
        if (requiredSignalAspect == null) {
            requiredSignalAspect = new ArrayList<SignalAndGivenAspect>();
        }
        return this.requiredSignalAspect;
    }

    /**
     * Gets the value of the requiredSectionState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requiredSectionState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequiredSectionState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SectionAndGivenVacancy }
     * 
     * 
     */
    public List<SectionAndGivenVacancy> getRequiredSectionState() {
        if (requiredSectionState == null) {
            requiredSectionState = new ArrayList<SectionAndGivenVacancy>();
        }
        return this.requiredSectionState;
    }

    /**
     * Gets the value of the requiredKeyLockState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requiredKeyLockState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequiredKeyLockState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LockAndGivenState }
     * 
     * 
     */
    public List<LockAndGivenState> getRequiredKeyLockState() {
        if (requiredKeyLockState == null) {
            requiredKeyLockState = new ArrayList<LockAndGivenState>();
        }
        return this.requiredKeyLockState;
    }

    /**
     * Gets the value of the requiredLevelCrossingState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requiredLevelCrossingState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequiredLevelCrossingState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LevelCrossingAndGivenState }
     * 
     * 
     */
    public List<LevelCrossingAndGivenState> getRequiredLevelCrossingState() {
        if (requiredLevelCrossingState == null) {
            requiredLevelCrossingState = new ArrayList<LevelCrossingAndGivenState>();
        }
        return this.requiredLevelCrossingState;
    }

}
