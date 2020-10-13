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
 * <p>Java-Klasse für EnergyPantograph complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="EnergyPantograph">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="requiresTSIcompliance" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="compliantTSITypes" type="{https://www.railml.org/schemas/3.1}tTSIPantoHeadTypeList" />
 *       &lt;attribute name="nationalPanHeadTypes" type="{https://www.railml.org/schemas/3.1}tPantoHeadTypeList" />
 *       &lt;attribute name="contactStripMaterials" type="{https://www.railml.org/schemas/3.1}tContactStripMaterialList" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnergyPantograph")
public class EnergyPantograph {

    @XmlAttribute(name = "requiresTSIcompliance")
    protected Boolean requiresTSIcompliance;
    @XmlAttribute(name = "compliantTSITypes")
    protected List<TTSIPantoHeadType> compliantTSITypes;
    @XmlAttribute(name = "nationalPanHeadTypes")
    protected List<TPantoHeadType> nationalPanHeadTypes;
    @XmlAttribute(name = "contactStripMaterials")
    protected List<TContactStripMaterial> contactStripMaterials;

    /**
     * Ruft den Wert der requiresTSIcompliance-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequiresTSIcompliance() {
        return requiresTSIcompliance;
    }

    /**
     * Legt den Wert der requiresTSIcompliance-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequiresTSIcompliance(Boolean value) {
        this.requiresTSIcompliance = value;
    }

    /**
     * Gets the value of the compliantTSITypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the compliantTSITypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompliantTSITypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TTSIPantoHeadType }
     * 
     * 
     */
    public List<TTSIPantoHeadType> getCompliantTSITypes() {
        if (compliantTSITypes == null) {
            compliantTSITypes = new ArrayList<TTSIPantoHeadType>();
        }
        return this.compliantTSITypes;
    }

    /**
     * Gets the value of the nationalPanHeadTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nationalPanHeadTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNationalPanHeadTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TPantoHeadType }
     * 
     * 
     */
    public List<TPantoHeadType> getNationalPanHeadTypes() {
        if (nationalPanHeadTypes == null) {
            nationalPanHeadTypes = new ArrayList<TPantoHeadType>();
        }
        return this.nationalPanHeadTypes;
    }

    /**
     * Gets the value of the contactStripMaterials property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contactStripMaterials property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContactStripMaterials().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TContactStripMaterial }
     * 
     * 
     */
    public List<TContactStripMaterial> getContactStripMaterials() {
        if (contactStripMaterials == null) {
            contactStripMaterials = new ArrayList<TContactStripMaterial>();
        }
        return this.contactStripMaterials;
    }

}
