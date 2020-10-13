//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * List of Track Assets that are connected to a specific IL. This list would typically be kept in one or more separate files. This approach allows the IM to split the assets under control of a specific interlocking into different areas. Each area would be allocated a list of Track Assets Connected to the IL. This supports for instance a scenario in which an interlocking is split into several smaller ones during a resignalling project.
 * 
 * <p>Java-Klasse für TrackAssetConnectedToIL complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TrackAssetConnectedToIL">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="connectedTrackAsset" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *       &lt;/sequence>
 *       &lt;attribute name="extentOfControl" type="{https://www.railml.org/schemas/3.1}tExtentOfControl" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackAssetConnectedToIL", propOrder = {
    "connectedTrackAsset"
})
public class TrackAssetConnectedToIL
    extends EntityIL
{

    @XmlElement(required = true)
    protected EntityILref connectedTrackAsset;
    @XmlAttribute(name = "extentOfControl")
    protected TExtentOfControl extentOfControl;

    /**
     * Ruft den Wert der connectedTrackAsset-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getConnectedTrackAsset() {
        return connectedTrackAsset;
    }

    /**
     * Legt den Wert der connectedTrackAsset-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setConnectedTrackAsset(EntityILref value) {
        this.connectedTrackAsset = value;
    }

    /**
     * Ruft den Wert der extentOfControl-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TExtentOfControl }
     *     
     */
    public TExtentOfControl getExtentOfControl() {
        return extentOfControl;
    }

    /**
     * Legt den Wert der extentOfControl-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TExtentOfControl }
     *     
     */
    public void setExtentOfControl(TExtentOfControl value) {
        this.extentOfControl = value;
    }

}
