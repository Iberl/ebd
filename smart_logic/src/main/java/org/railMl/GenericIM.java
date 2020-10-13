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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The container for the IM specific type definitions.
 * 
 * <p>Java-Klasse für GenericIM complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GenericIM">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *         &lt;element name="ownsSetsOfAssets" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="usesTypes" type="{https://www.railml.org/schemas/3.1}GenericTypes"/>
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
@XmlType(name = "GenericIM", propOrder = {
    "ownsSetsOfAssets",
    "usesTypes"
})
public class GenericIM
    extends EntityIL
{

    protected List<EntityILref> ownsSetsOfAssets;
    @XmlElement(required = true)
    protected GenericTypes usesTypes;

    /**
     * Gets the value of the ownsSetsOfAssets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ownsSetsOfAssets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOwnsSetsOfAssets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getOwnsSetsOfAssets() {
        if (ownsSetsOfAssets == null) {
            ownsSetsOfAssets = new ArrayList<EntityILref>();
        }
        return this.ownsSetsOfAssets;
    }

    /**
     * Ruft den Wert der usesTypes-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GenericTypes }
     *     
     */
    public GenericTypes getUsesTypes() {
        return usesTypes;
    }

    /**
     * Legt den Wert der usesTypes-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericTypes }
     *     
     */
    public void setUsesTypes(GenericTypes value) {
        this.usesTypes = value;
    }

}
