//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:06:07 PM CEST 
//


package org.railMl.rtm4rail;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * This is the top level element for the common model.
 * 
 * <p>Java-Klasse für Common complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Common">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}tElementWithID">
 *       &lt;sequence>
 *         &lt;element name="electrificationSystems" type="{https://www.railml.org/schemas/3.1}ElectrificationSystems" minOccurs="0"/>
 *         &lt;element name="organizationalUnits" type="{https://www.railml.org/schemas/3.1}OrganizationalUnits" minOccurs="0"/>
 *         &lt;element name="speedProfiles" type="{https://www.railml.org/schemas/3.1}SpeedProfiles" minOccurs="0"/>
 *         &lt;element name="positioning" type="{https://www.railml.org/schemas/3.1}PositioningSystems" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Common", propOrder = {
    "electrificationSystems",
    "organizationalUnits",
    "speedProfiles",
    "positioning"
})
public class Common
    extends TElementWithID
{

    protected ElectrificationSystems electrificationSystems;
    protected OrganizationalUnits organizationalUnits;
    protected SpeedProfiles speedProfiles;
    protected PositioningSystems positioning;

    /**
     * Ruft den Wert der electrificationSystems-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ElectrificationSystems }
     *     
     */
    public ElectrificationSystems getElectrificationSystems() {
        return electrificationSystems;
    }

    /**
     * Legt den Wert der electrificationSystems-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ElectrificationSystems }
     *     
     */
    public void setElectrificationSystems(ElectrificationSystems value) {
        this.electrificationSystems = value;
    }

    /**
     * Ruft den Wert der organizationalUnits-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationalUnits }
     *     
     */
    public OrganizationalUnits getOrganizationalUnits() {
        return organizationalUnits;
    }

    /**
     * Legt den Wert der organizationalUnits-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationalUnits }
     *     
     */
    public void setOrganizationalUnits(OrganizationalUnits value) {
        this.organizationalUnits = value;
    }

    /**
     * Ruft den Wert der speedProfiles-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpeedProfiles }
     *     
     */
    public SpeedProfiles getSpeedProfiles() {
        return speedProfiles;
    }

    /**
     * Legt den Wert der speedProfiles-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedProfiles }
     *     
     */
    public void setSpeedProfiles(SpeedProfiles value) {
        this.speedProfiles = value;
    }

    /**
     * Ruft den Wert der positioning-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PositioningSystems }
     *     
     */
    public PositioningSystems getPositioning() {
        return positioning;
    }

    /**
     * Legt den Wert der positioning-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PositioningSystems }
     *     
     */
    public void setPositioning(PositioningSystems value) {
        this.positioning = value;
    }

}
