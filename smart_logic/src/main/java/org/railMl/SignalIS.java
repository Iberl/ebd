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
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SignalIS complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SignalIS">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}FunctionalInfrastructureEntity">
 *       &lt;sequence>
 *         &lt;element name="isAnnouncementSignal" type="{https://www.railml.org/schemas/3.1}SignalAnnouncement" minOccurs="0"/>
 *         &lt;element name="isCatenarySignal" type="{https://www.railml.org/schemas/3.1}SignalCatenary" minOccurs="0"/>
 *         &lt;element name="isDangerSignal" type="{https://www.railml.org/schemas/3.1}SignalDanger" minOccurs="0"/>
 *         &lt;element name="isEtcsSignal" type="{https://www.railml.org/schemas/3.1}SignalEtcs" minOccurs="0"/>
 *         &lt;element name="isInformationSignal" type="{https://www.railml.org/schemas/3.1}SignalInformation" minOccurs="0"/>
 *         &lt;element name="isLevelCrossingSignal" type="{https://www.railml.org/schemas/3.1}SignalLevelCrossing" minOccurs="0"/>
 *         &lt;element name="isMilepost" type="{https://www.railml.org/schemas/3.1}SignalMilepost" minOccurs="0"/>
 *         &lt;element name="isSpeedSignal" type="{https://www.railml.org/schemas/3.1}SignalSpeed" minOccurs="0"/>
 *         &lt;element name="isStopPost" type="{https://www.railml.org/schemas/3.1}SignalStopPost" minOccurs="0"/>
 *         &lt;element name="isTrainMovementSignal" type="{https://www.railml.org/schemas/3.1}SignalTrainMovement" minOccurs="0"/>
 *         &lt;element name="isTrainRadioSignal" type="{https://www.railml.org/schemas/3.1}SignalRadio" minOccurs="0"/>
 *         &lt;element name="isVehicleEquipmentSignal" type="{https://www.railml.org/schemas/3.1}SignalVehicleEquipment" minOccurs="0"/>
 *         &lt;element name="connectedWithBaliseGroup" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="signalConstruction" type="{https://www.railml.org/schemas/3.1}SignalConstruction" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="isSwitchable" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="belongsToParent" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;attribute name="basedOnTemplate" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignalIS", propOrder = {
    "isAnnouncementSignal",
    "isCatenarySignal",
    "isDangerSignal",
    "isEtcsSignal",
    "isInformationSignal",
    "isLevelCrossingSignal",
    "isMilepost",
    "isSpeedSignal",
    "isStopPost",
    "isTrainMovementSignal",
    "isTrainRadioSignal",
    "isVehicleEquipmentSignal",
    "connectedWithBaliseGroup",
    "signalConstruction"
})
public class SignalIS
    extends FunctionalInfrastructureEntity
{

    protected SignalAnnouncement isAnnouncementSignal;
    protected SignalCatenary isCatenarySignal;
    protected SignalDanger isDangerSignal;
    protected SignalEtcs isEtcsSignal;
    protected SignalInformation isInformationSignal;
    protected SignalLevelCrossing isLevelCrossingSignal;
    protected SignalMilepost isMilepost;
    protected SignalSpeed isSpeedSignal;
    protected SignalStopPost isStopPost;
    protected SignalTrainMovement isTrainMovementSignal;
    protected SignalRadio isTrainRadioSignal;
    protected SignalVehicleEquipment isVehicleEquipmentSignal;
    protected List<TElementWithIDref> connectedWithBaliseGroup;
    protected SignalConstruction signalConstruction;
    @XmlAttribute(name = "isSwitchable")
    protected Boolean isSwitchable;
    @XmlAttribute(name = "belongsToParent")
    protected String belongsToParent;
    @XmlAttribute(name = "basedOnTemplate")
    protected String basedOnTemplate;

    /**
     * Ruft den Wert der isAnnouncementSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalAnnouncement }
     *     
     */
    public SignalAnnouncement getIsAnnouncementSignal() {
        return isAnnouncementSignal;
    }

    /**
     * Legt den Wert der isAnnouncementSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalAnnouncement }
     *     
     */
    public void setIsAnnouncementSignal(SignalAnnouncement value) {
        this.isAnnouncementSignal = value;
    }

    /**
     * Ruft den Wert der isCatenarySignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalCatenary }
     *     
     */
    public SignalCatenary getIsCatenarySignal() {
        return isCatenarySignal;
    }

    /**
     * Legt den Wert der isCatenarySignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalCatenary }
     *     
     */
    public void setIsCatenarySignal(SignalCatenary value) {
        this.isCatenarySignal = value;
    }

    /**
     * Ruft den Wert der isDangerSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalDanger }
     *     
     */
    public SignalDanger getIsDangerSignal() {
        return isDangerSignal;
    }

    /**
     * Legt den Wert der isDangerSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalDanger }
     *     
     */
    public void setIsDangerSignal(SignalDanger value) {
        this.isDangerSignal = value;
    }

    /**
     * Ruft den Wert der isEtcsSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalEtcs }
     *     
     */
    public SignalEtcs getIsEtcsSignal() {
        return isEtcsSignal;
    }

    /**
     * Legt den Wert der isEtcsSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalEtcs }
     *     
     */
    public void setIsEtcsSignal(SignalEtcs value) {
        this.isEtcsSignal = value;
    }

    /**
     * Ruft den Wert der isInformationSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalInformation }
     *     
     */
    public SignalInformation getIsInformationSignal() {
        return isInformationSignal;
    }

    /**
     * Legt den Wert der isInformationSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalInformation }
     *     
     */
    public void setIsInformationSignal(SignalInformation value) {
        this.isInformationSignal = value;
    }

    /**
     * Ruft den Wert der isLevelCrossingSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalLevelCrossing }
     *     
     */
    public SignalLevelCrossing getIsLevelCrossingSignal() {
        return isLevelCrossingSignal;
    }

    /**
     * Legt den Wert der isLevelCrossingSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalLevelCrossing }
     *     
     */
    public void setIsLevelCrossingSignal(SignalLevelCrossing value) {
        this.isLevelCrossingSignal = value;
    }

    /**
     * Ruft den Wert der isMilepost-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalMilepost }
     *     
     */
    public SignalMilepost getIsMilepost() {
        return isMilepost;
    }

    /**
     * Legt den Wert der isMilepost-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalMilepost }
     *     
     */
    public void setIsMilepost(SignalMilepost value) {
        this.isMilepost = value;
    }

    /**
     * Ruft den Wert der isSpeedSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalSpeed }
     *     
     */
    public SignalSpeed getIsSpeedSignal() {
        return isSpeedSignal;
    }

    /**
     * Legt den Wert der isSpeedSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalSpeed }
     *     
     */
    public void setIsSpeedSignal(SignalSpeed value) {
        this.isSpeedSignal = value;
    }

    /**
     * Ruft den Wert der isStopPost-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalStopPost }
     *     
     */
    public SignalStopPost getIsStopPost() {
        return isStopPost;
    }

    /**
     * Legt den Wert der isStopPost-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalStopPost }
     *     
     */
    public void setIsStopPost(SignalStopPost value) {
        this.isStopPost = value;
    }

    /**
     * Ruft den Wert der isTrainMovementSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalTrainMovement }
     *     
     */
    public SignalTrainMovement getIsTrainMovementSignal() {
        return isTrainMovementSignal;
    }

    /**
     * Legt den Wert der isTrainMovementSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalTrainMovement }
     *     
     */
    public void setIsTrainMovementSignal(SignalTrainMovement value) {
        this.isTrainMovementSignal = value;
    }

    /**
     * Ruft den Wert der isTrainRadioSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalRadio }
     *     
     */
    public SignalRadio getIsTrainRadioSignal() {
        return isTrainRadioSignal;
    }

    /**
     * Legt den Wert der isTrainRadioSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalRadio }
     *     
     */
    public void setIsTrainRadioSignal(SignalRadio value) {
        this.isTrainRadioSignal = value;
    }

    /**
     * Ruft den Wert der isVehicleEquipmentSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalVehicleEquipment }
     *     
     */
    public SignalVehicleEquipment getIsVehicleEquipmentSignal() {
        return isVehicleEquipmentSignal;
    }

    /**
     * Legt den Wert der isVehicleEquipmentSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalVehicleEquipment }
     *     
     */
    public void setIsVehicleEquipmentSignal(SignalVehicleEquipment value) {
        this.isVehicleEquipmentSignal = value;
    }

    /**
     * Gets the value of the connectedWithBaliseGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the connectedWithBaliseGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConnectedWithBaliseGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getConnectedWithBaliseGroup() {
        if (connectedWithBaliseGroup == null) {
            connectedWithBaliseGroup = new ArrayList<TElementWithIDref>();
        }
        return this.connectedWithBaliseGroup;
    }

    /**
     * Ruft den Wert der signalConstruction-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalConstruction }
     *     
     */
    public SignalConstruction getSignalConstruction() {
        return signalConstruction;
    }

    /**
     * Legt den Wert der signalConstruction-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalConstruction }
     *     
     */
    public void setSignalConstruction(SignalConstruction value) {
        this.signalConstruction = value;
    }

    /**
     * Ruft den Wert der isSwitchable-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsSwitchable() {
        return isSwitchable;
    }

    /**
     * Legt den Wert der isSwitchable-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsSwitchable(Boolean value) {
        this.isSwitchable = value;
    }

    /**
     * Ruft den Wert der belongsToParent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBelongsToParent() {
        return belongsToParent;
    }

    /**
     * Legt den Wert der belongsToParent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBelongsToParent(String value) {
        this.belongsToParent = value;
    }

    /**
     * Ruft den Wert der basedOnTemplate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBasedOnTemplate() {
        return basedOnTemplate;
    }

    /**
     * Legt den Wert der basedOnTemplate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBasedOnTemplate(String value) {
        this.basedOnTemplate = value;
    }

}
