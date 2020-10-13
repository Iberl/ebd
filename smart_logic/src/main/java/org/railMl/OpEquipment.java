//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für OpEquipment complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="OpEquipment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ownsPlatform" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ownsTrack" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ownsSignal" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ownsStoppingPlace" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ownsServiceSection" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="numberOfStationTracks" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpEquipment", propOrder = {
    "ownsPlatform",
    "ownsTrack",
    "ownsSignal",
    "ownsStoppingPlace",
    "ownsServiceSection"
})
public class OpEquipment {

    protected List<TElementWithIDref> ownsPlatform;
    protected List<TElementWithIDref> ownsTrack;
    protected List<TElementWithIDref> ownsSignal;
    protected List<TElementWithIDref> ownsStoppingPlace;
    protected List<TElementWithIDref> ownsServiceSection;
    @XmlAttribute(name = "numberOfStationTracks")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger numberOfStationTracks;

    /**
     * Gets the value of the ownsPlatform property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ownsPlatform property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOwnsPlatform().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getOwnsPlatform() {
        if (ownsPlatform == null) {
            ownsPlatform = new ArrayList<TElementWithIDref>();
        }
        return this.ownsPlatform;
    }

    /**
     * Gets the value of the ownsTrack property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ownsTrack property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOwnsTrack().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getOwnsTrack() {
        if (ownsTrack == null) {
            ownsTrack = new ArrayList<TElementWithIDref>();
        }
        return this.ownsTrack;
    }

    /**
     * Gets the value of the ownsSignal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ownsSignal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOwnsSignal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getOwnsSignal() {
        if (ownsSignal == null) {
            ownsSignal = new ArrayList<TElementWithIDref>();
        }
        return this.ownsSignal;
    }

    /**
     * Gets the value of the ownsStoppingPlace property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ownsStoppingPlace property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOwnsStoppingPlace().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getOwnsStoppingPlace() {
        if (ownsStoppingPlace == null) {
            ownsStoppingPlace = new ArrayList<TElementWithIDref>();
        }
        return this.ownsStoppingPlace;
    }

    /**
     * Gets the value of the ownsServiceSection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ownsServiceSection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOwnsServiceSection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getOwnsServiceSection() {
        if (ownsServiceSection == null) {
            ownsServiceSection = new ArrayList<TElementWithIDref>();
        }
        return this.ownsServiceSection;
    }

    /**
     * Ruft den Wert der numberOfStationTracks-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfStationTracks() {
        return numberOfStationTracks;
    }

    /**
     * Legt den Wert der numberOfStationTracks-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfStationTracks(BigInteger value) {
        this.numberOfStationTracks = value;
    }

}
