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
 * A line is a sequence of one or more line sections forming a route, which connects operational points and which may consist of several tracks used for regular railway operation.
 * 
 * <p>Java-Klasse für Line complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Line">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}FunctionalInfrastructureEntity">
 *       &lt;sequence>
 *         &lt;element name="beginsInOP" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" minOccurs="0"/>
 *         &lt;element name="endsInOP" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" minOccurs="0"/>
 *         &lt;element name="length" type="{https://www.railml.org/schemas/3.1}Length" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lineTrafficCode" type="{https://www.railml.org/schemas/3.1}LineTrafficCode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lineCombinedTransportCode" type="{https://www.railml.org/schemas/3.1}LineCombinedTransportCode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lineLayout" type="{https://www.railml.org/schemas/3.1}LineLayout" minOccurs="0"/>
 *         &lt;element name="linePerformance" type="{https://www.railml.org/schemas/3.1}LinePerformance" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="infrastructureManagerRef" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;attribute name="lineCategory" type="{https://www.railml.org/schemas/3.1}tLineCategoryExt" />
 *       &lt;attribute name="lineType" type="{https://www.railml.org/schemas/3.1}tLineType" />
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
@XmlType(name = "Line", propOrder = {
    "beginsInOP",
    "endsInOP",
    "length",
    "lineTrafficCode",
    "lineCombinedTransportCode",
    "lineLayout",
    "linePerformance"
})
public class Line
    extends FunctionalInfrastructureEntity
{

    protected TElementWithIDref beginsInOP;
    protected TElementWithIDref endsInOP;
    protected List<Length> length;
    protected List<LineTrafficCode> lineTrafficCode;
    protected List<LineCombinedTransportCode> lineCombinedTransportCode;
    protected LineLayout lineLayout;
    protected LinePerformance linePerformance;
    @XmlAttribute(name = "infrastructureManagerRef")
    protected String infrastructureManagerRef;
    @XmlAttribute(name = "lineCategory")
    protected String lineCategory;
    @XmlAttribute(name = "lineType")
    protected TLineType lineType;
    @XmlAttribute(name = "belongsToParent")
    protected String belongsToParent;
    @XmlAttribute(name = "basedOnTemplate")
    protected String basedOnTemplate;

    /**
     * Ruft den Wert der beginsInOP-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TElementWithIDref }
     *     
     */
    public TElementWithIDref getBeginsInOP() {
        return beginsInOP;
    }

    /**
     * Legt den Wert der beginsInOP-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TElementWithIDref }
     *     
     */
    public void setBeginsInOP(TElementWithIDref value) {
        this.beginsInOP = value;
    }

    /**
     * Ruft den Wert der endsInOP-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TElementWithIDref }
     *     
     */
    public TElementWithIDref getEndsInOP() {
        return endsInOP;
    }

    /**
     * Legt den Wert der endsInOP-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TElementWithIDref }
     *     
     */
    public void setEndsInOP(TElementWithIDref value) {
        this.endsInOP = value;
    }

    /**
     * Gets the value of the length property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the length property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLength().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Length }
     * 
     * 
     */
    public List<Length> getLength() {
        if (length == null) {
            length = new ArrayList<Length>();
        }
        return this.length;
    }

    /**
     * Gets the value of the lineTrafficCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineTrafficCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineTrafficCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineTrafficCode }
     * 
     * 
     */
    public List<LineTrafficCode> getLineTrafficCode() {
        if (lineTrafficCode == null) {
            lineTrafficCode = new ArrayList<LineTrafficCode>();
        }
        return this.lineTrafficCode;
    }

    /**
     * Gets the value of the lineCombinedTransportCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineCombinedTransportCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineCombinedTransportCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineCombinedTransportCode }
     * 
     * 
     */
    public List<LineCombinedTransportCode> getLineCombinedTransportCode() {
        if (lineCombinedTransportCode == null) {
            lineCombinedTransportCode = new ArrayList<LineCombinedTransportCode>();
        }
        return this.lineCombinedTransportCode;
    }

    /**
     * Ruft den Wert der lineLayout-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LineLayout }
     *     
     */
    public LineLayout getLineLayout() {
        return lineLayout;
    }

    /**
     * Legt den Wert der lineLayout-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LineLayout }
     *     
     */
    public void setLineLayout(LineLayout value) {
        this.lineLayout = value;
    }

    /**
     * Ruft den Wert der linePerformance-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LinePerformance }
     *     
     */
    public LinePerformance getLinePerformance() {
        return linePerformance;
    }

    /**
     * Legt den Wert der linePerformance-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LinePerformance }
     *     
     */
    public void setLinePerformance(LinePerformance value) {
        this.linePerformance = value;
    }

    /**
     * Ruft den Wert der infrastructureManagerRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfrastructureManagerRef() {
        return infrastructureManagerRef;
    }

    /**
     * Legt den Wert der infrastructureManagerRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfrastructureManagerRef(String value) {
        this.infrastructureManagerRef = value;
    }

    /**
     * Ruft den Wert der lineCategory-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineCategory() {
        return lineCategory;
    }

    /**
     * Legt den Wert der lineCategory-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineCategory(String value) {
        this.lineCategory = value;
    }

    /**
     * Ruft den Wert der lineType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TLineType }
     *     
     */
    public TLineType getLineType() {
        return lineType;
    }

    /**
     * Legt den Wert der lineType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TLineType }
     *     
     */
    public void setLineType(TLineType value) {
        this.lineType = value;
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
