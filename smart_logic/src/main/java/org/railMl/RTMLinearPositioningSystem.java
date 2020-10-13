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
 * <p>Java-Klasse für RTM_LinearPositioningSystem complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RTM_LinearPositioningSystem">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}RTM_PositioningSystem">
 *       &lt;sequence>
 *         &lt;element name="anchor" type="{https://www.railml.org/schemas/3.1}RTM_LinearAnchorPoint" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="linearReferencingMethod" use="required" type="{https://www.railml.org/schemas/3.1}tLrsMethod" />
 *       &lt;attribute name="startMeasure" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="endMeasure" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="units" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTM_LinearPositioningSystem", propOrder = {
    "anchor"
})
public class RTMLinearPositioningSystem
    extends RTMPositioningSystem
{

    protected List<RTMLinearAnchorPoint> anchor;
    @XmlAttribute(name = "linearReferencingMethod", required = true)
    protected TLrsMethod linearReferencingMethod;
    @XmlAttribute(name = "startMeasure", required = true)
    protected double startMeasure;
    @XmlAttribute(name = "endMeasure", required = true)
    protected double endMeasure;
    @XmlAttribute(name = "units", required = true)
    protected String units;

    /**
     * Gets the value of the anchor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anchor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnchor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RTMLinearAnchorPoint }
     * 
     * 
     */
    public List<RTMLinearAnchorPoint> getAnchor() {
        if (anchor == null) {
            anchor = new ArrayList<RTMLinearAnchorPoint>();
        }
        return this.anchor;
    }

    /**
     * Ruft den Wert der linearReferencingMethod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TLrsMethod }
     *     
     */
    public TLrsMethod getLinearReferencingMethod() {
        return linearReferencingMethod;
    }

    /**
     * Legt den Wert der linearReferencingMethod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TLrsMethod }
     *     
     */
    public void setLinearReferencingMethod(TLrsMethod value) {
        this.linearReferencingMethod = value;
    }

    /**
     * Ruft den Wert der startMeasure-Eigenschaft ab.
     * 
     */
    public double getStartMeasure() {
        return startMeasure;
    }

    /**
     * Legt den Wert der startMeasure-Eigenschaft fest.
     * 
     */
    public void setStartMeasure(double value) {
        this.startMeasure = value;
    }

    /**
     * Ruft den Wert der endMeasure-Eigenschaft ab.
     * 
     */
    public double getEndMeasure() {
        return endMeasure;
    }

    /**
     * Legt den Wert der endMeasure-Eigenschaft fest.
     * 
     */
    public void setEndMeasure(double value) {
        this.endMeasure = value;
    }

    /**
     * Ruft den Wert der units-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnits() {
        return units;
    }

    /**
     * Legt den Wert der units-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnits(String value) {
        this.units = value;
    }

}
