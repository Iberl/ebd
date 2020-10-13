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
 * Area used for local shunting movements without routes. Movable elements within the area might be operated from onsite panels. These areas are predefined for parts of a station.
 * 
 * <p>Java-Klasse für LocalOperationArea complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LocalOperationArea">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}RestrictedArea">
 *       &lt;sequence>
 *         &lt;element name="deactivationKey" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="switchInPosition" type="{https://www.railml.org/schemas/3.1}SwitchInPosition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="derailerInPosition" type="{https://www.railml.org/schemas/3.1}DerailerInPosition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="crossingInPosition" type="{https://www.railml.org/schemas/3.1}CrossingInPosition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="detectorInState" type="{https://www.railml.org/schemas/3.1}DetectorInState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="signalWithAspect" type="{https://www.railml.org/schemas/3.1}SignalWithAspect" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="keyLockInState" type="{https://www.railml.org/schemas/3.1}KeyLockInState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="levelCrossingInState" type="{https://www.railml.org/schemas/3.1}LevelCrossingInState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="releasedForLocalOperation" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "LocalOperationArea", propOrder = {
    "deactivationKey",
    "switchInPosition",
    "derailerInPosition",
    "crossingInPosition",
    "detectorInState",
    "signalWithAspect",
    "keyLockInState",
    "levelCrossingInState",
    "releasedForLocalOperation"
})
public class LocalOperationArea
    extends RestrictedArea
{

    protected List<EntityILref> deactivationKey;
    protected List<SwitchInPosition> switchInPosition;
    protected List<DerailerInPosition> derailerInPosition;
    protected List<CrossingInPosition> crossingInPosition;
    protected List<DetectorInState> detectorInState;
    protected List<SignalWithAspect> signalWithAspect;
    protected List<KeyLockInState> keyLockInState;
    protected List<LevelCrossingInState> levelCrossingInState;
    protected List<EntityILref> releasedForLocalOperation;

    /**
     * Gets the value of the deactivationKey property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deactivationKey property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeactivationKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getDeactivationKey() {
        if (deactivationKey == null) {
            deactivationKey = new ArrayList<EntityILref>();
        }
        return this.deactivationKey;
    }

    /**
     * Gets the value of the switchInPosition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the switchInPosition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSwitchInPosition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SwitchInPosition }
     * 
     * 
     */
    public List<SwitchInPosition> getSwitchInPosition() {
        if (switchInPosition == null) {
            switchInPosition = new ArrayList<SwitchInPosition>();
        }
        return this.switchInPosition;
    }

    /**
     * Gets the value of the derailerInPosition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the derailerInPosition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDerailerInPosition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DerailerInPosition }
     * 
     * 
     */
    public List<DerailerInPosition> getDerailerInPosition() {
        if (derailerInPosition == null) {
            derailerInPosition = new ArrayList<DerailerInPosition>();
        }
        return this.derailerInPosition;
    }

    /**
     * Gets the value of the crossingInPosition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the crossingInPosition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCrossingInPosition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CrossingInPosition }
     * 
     * 
     */
    public List<CrossingInPosition> getCrossingInPosition() {
        if (crossingInPosition == null) {
            crossingInPosition = new ArrayList<CrossingInPosition>();
        }
        return this.crossingInPosition;
    }

    /**
     * Gets the value of the detectorInState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detectorInState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetectorInState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetectorInState }
     * 
     * 
     */
    public List<DetectorInState> getDetectorInState() {
        if (detectorInState == null) {
            detectorInState = new ArrayList<DetectorInState>();
        }
        return this.detectorInState;
    }

    /**
     * Gets the value of the signalWithAspect property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signalWithAspect property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignalWithAspect().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignalWithAspect }
     * 
     * 
     */
    public List<SignalWithAspect> getSignalWithAspect() {
        if (signalWithAspect == null) {
            signalWithAspect = new ArrayList<SignalWithAspect>();
        }
        return this.signalWithAspect;
    }

    /**
     * Gets the value of the keyLockInState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyLockInState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyLockInState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyLockInState }
     * 
     * 
     */
    public List<KeyLockInState> getKeyLockInState() {
        if (keyLockInState == null) {
            keyLockInState = new ArrayList<KeyLockInState>();
        }
        return this.keyLockInState;
    }

    /**
     * Gets the value of the levelCrossingInState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the levelCrossingInState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLevelCrossingInState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LevelCrossingInState }
     * 
     * 
     */
    public List<LevelCrossingInState> getLevelCrossingInState() {
        if (levelCrossingInState == null) {
            levelCrossingInState = new ArrayList<LevelCrossingInState>();
        }
        return this.levelCrossingInState;
    }

    /**
     * Gets the value of the releasedForLocalOperation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the releasedForLocalOperation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReleasedForLocalOperation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getReleasedForLocalOperation() {
        if (releasedForLocalOperation == null) {
            releasedForLocalOperation = new ArrayList<EntityILref>();
        }
        return this.releasedForLocalOperation;
    }

}
