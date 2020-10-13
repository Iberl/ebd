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
 * <p>Java-Klasse für TrainDetectionElement complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TrainDetectionElement">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}FunctionalInfrastructureEntity">
 *       &lt;sequence>
 *         &lt;element name="limitsTrainDetectionElement" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="2" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{https://www.railml.org/schemas/3.1}aTrainDetectionElement"/>
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
@XmlType(name = "TrainDetectionElement", propOrder = {
    "limitsTrainDetectionElement"
})
public class TrainDetectionElement
    extends FunctionalInfrastructureEntity
{

    protected List<TElementWithIDref> limitsTrainDetectionElement;
    @XmlAttribute(name = "basedOnTemplate")
    protected String basedOnTemplate;
    @XmlAttribute(name = "type", required = true)
    protected TTrainDetectionElementType type;
    @XmlAttribute(name = "detectedObject")
    protected TDetectedObject detectedObject;
    @XmlAttribute(name = "detectorMedium")
    protected TDetectorMedium detectorMedium;
    @XmlAttribute(name = "layout")
    protected TDetectorLayout layout;

    /**
     * Gets the value of the limitsTrainDetectionElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the limitsTrainDetectionElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLimitsTrainDetectionElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getLimitsTrainDetectionElement() {
        if (limitsTrainDetectionElement == null) {
            limitsTrainDetectionElement = new ArrayList<TElementWithIDref>();
        }
        return this.limitsTrainDetectionElement;
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

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TTrainDetectionElementType }
     *     
     */
    public TTrainDetectionElementType getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TTrainDetectionElementType }
     *     
     */
    public void setType(TTrainDetectionElementType value) {
        this.type = value;
    }

    /**
     * Ruft den Wert der detectedObject-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TDetectedObject }
     *     
     */
    public TDetectedObject getDetectedObject() {
        return detectedObject;
    }

    /**
     * Legt den Wert der detectedObject-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TDetectedObject }
     *     
     */
    public void setDetectedObject(TDetectedObject value) {
        this.detectedObject = value;
    }

    /**
     * Ruft den Wert der detectorMedium-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TDetectorMedium }
     *     
     */
    public TDetectorMedium getDetectorMedium() {
        return detectorMedium;
    }

    /**
     * Legt den Wert der detectorMedium-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TDetectorMedium }
     *     
     */
    public void setDetectorMedium(TDetectorMedium value) {
        this.detectorMedium = value;
    }

    /**
     * Ruft den Wert der layout-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TDetectorLayout }
     *     
     */
    public TDetectorLayout getLayout() {
        return layout;
    }

    /**
     * Legt den Wert der layout-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TDetectorLayout }
     *     
     */
    public void setLayout(TDetectorLayout value) {
        this.layout = value;
    }

}
