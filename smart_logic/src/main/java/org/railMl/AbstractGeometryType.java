//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * All geometry elements are derived directly or indirectly from this abstract supertype. A geometry element may have an identifying attribute (gml:id), one or more names (elements identifier and name) and a description (elements description and descriptionReference) . It may be associated with a spatial reference system (attribute group gml:SRSReferenceGroup).
 * 
 * <p>Java-Klasse für AbstractGeometryType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractGeometryType">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1/gml}AbstractGMLType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{https://www.railml.org/schemas/3.1/gml}SRSReferenceGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractGeometryType", namespace = "https://www.railml.org/schemas/3.1/gml")
@XmlSeeAlso({
    AbstractGeometricPrimitiveType.class
})
public abstract class AbstractGeometryType
    extends AbstractGMLType
{

    @XmlAttribute(name = "srsDimension")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger srsDimension;
    @XmlAttribute(name = "srsName")
    @XmlSchemaType(name = "anyURI")
    protected String srsName;
    @XmlAttribute(name = "axisLabels")
    protected String axisLabels;
    @XmlAttribute(name = "uomLabels")
    protected String uomLabels;

    /**
     * Ruft den Wert der srsDimension-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSrsDimension() {
        return srsDimension;
    }

    /**
     * Legt den Wert der srsDimension-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSrsDimension(BigInteger value) {
        this.srsDimension = value;
    }

    /**
     * Ruft den Wert der srsName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrsName() {
        return srsName;
    }

    /**
     * Legt den Wert der srsName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrsName(String value) {
        this.srsName = value;
    }

    /**
     * Ruft den Wert der axisLabels-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAxisLabels() {
        return axisLabels;
    }

    /**
     * Legt den Wert der axisLabels-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAxisLabels(String value) {
        this.axisLabels = value;
    }

    /**
     * Ruft den Wert der uomLabels-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUomLabels() {
        return uomLabels;
    }

    /**
     * Legt den Wert der uomLabels-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUomLabels(String value) {
        this.uomLabels = value;
    }

}
