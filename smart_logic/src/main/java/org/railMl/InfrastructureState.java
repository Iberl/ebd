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
 * <p>Java-Klasse für InfrastructureState complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="InfrastructureState">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}StatesBaseElement">
 *       &lt;sequence>
 *         &lt;element name="elementState" type="{https://www.railml.org/schemas/3.1}ElementState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="validityTime" type="{https://www.railml.org/schemas/3.1}Period" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="value" type="{https://www.railml.org/schemas/3.1}tInfrastructureStateExt" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfrastructureState", propOrder = {
    "elementState",
    "validityTime"
})
public class InfrastructureState
    extends StatesBaseElement
{

    protected List<ElementState> elementState;
    protected List<Period> validityTime;
    @XmlAttribute(name = "value")
    protected String value;

    /**
     * Gets the value of the elementState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elementState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElementState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementState }
     * 
     * 
     */
    public List<ElementState> getElementState() {
        if (elementState == null) {
            elementState = new ArrayList<ElementState>();
        }
        return this.elementState;
    }

    /**
     * Gets the value of the validityTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the validityTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValidityTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Period }
     * 
     * 
     */
    public List<Period> getValidityTime() {
        if (validityTime == null) {
            validityTime = new ArrayList<Period>();
        }
        return this.validityTime;
    }

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

}
