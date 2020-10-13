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
 * Tuple of a track vacancy detection section and its state (occupied, vacant)
 * 
 * <p>Java-Klasse für SectionAndVacancy complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SectionAndVacancy">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}AssetAndState">
 *       &lt;sequence>
 *         &lt;element name="refersToSection" type="{https://www.railml.org/schemas/3.1}EntityILref"/>
 *       &lt;/sequence>
 *       &lt;attribute name="inState" use="required" type="{https://www.railml.org/schemas/3.1}tSectionVacancy" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SectionAndVacancy", propOrder = {
    "refersToSection"
})
public class SectionAndVacancy
    extends AssetAndState
{

    @XmlElement(required = true)
    protected EntityILref refersToSection;
    @XmlAttribute(name = "inState", required = true)
    protected TSectionVacancy inState;

    /**
     * Ruft den Wert der refersToSection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EntityILref }
     *     
     */
    public EntityILref getRefersToSection() {
        return refersToSection;
    }

    /**
     * Legt den Wert der refersToSection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityILref }
     *     
     */
    public void setRefersToSection(EntityILref value) {
        this.refersToSection = value;
    }

    /**
     * Ruft den Wert der inState-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TSectionVacancy }
     *     
     */
    public TSectionVacancy getInState() {
        return inState;
    }

    /**
     * Legt den Wert der inState-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TSectionVacancy }
     *     
     */
    public void setInState(TSectionVacancy value) {
        this.inState = value;
    }

}
