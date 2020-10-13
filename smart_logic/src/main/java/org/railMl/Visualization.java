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
 * <p>Java-Klasse für Visualization complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Visualization">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}VisualizationBaseElement">
 *       &lt;sequence>
 *         &lt;element name="spotElementProjection" type="{https://www.railml.org/schemas/3.1}SpotProjection" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="linearElementProjection" type="{https://www.railml.org/schemas/3.1}LinearProjection" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="areaElementProjection" type="{https://www.railml.org/schemas/3.1}AreaProjection" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="positioningSystemRef" type="{https://www.railml.org/schemas/3.1}tRef" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Visualization", propOrder = {
    "spotElementProjection",
    "linearElementProjection",
    "areaElementProjection"
})
public class Visualization
    extends VisualizationBaseElement
{

    protected List<SpotProjection> spotElementProjection;
    protected List<LinearProjection> linearElementProjection;
    protected List<AreaProjection> areaElementProjection;
    @XmlAttribute(name = "positioningSystemRef")
    protected String positioningSystemRef;

    /**
     * Gets the value of the spotElementProjection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the spotElementProjection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpotElementProjection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpotProjection }
     * 
     * 
     */
    public List<SpotProjection> getSpotElementProjection() {
        if (spotElementProjection == null) {
            spotElementProjection = new ArrayList<SpotProjection>();
        }
        return this.spotElementProjection;
    }

    /**
     * Gets the value of the linearElementProjection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linearElementProjection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinearElementProjection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinearProjection }
     * 
     * 
     */
    public List<LinearProjection> getLinearElementProjection() {
        if (linearElementProjection == null) {
            linearElementProjection = new ArrayList<LinearProjection>();
        }
        return this.linearElementProjection;
    }

    /**
     * Gets the value of the areaElementProjection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the areaElementProjection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAreaElementProjection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AreaProjection }
     * 
     * 
     */
    public List<AreaProjection> getAreaElementProjection() {
        if (areaElementProjection == null) {
            areaElementProjection = new ArrayList<AreaProjection>();
        }
        return this.areaElementProjection;
    }

    /**
     * Ruft den Wert der positioningSystemRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPositioningSystemRef() {
        return positioningSystemRef;
    }

    /**
     * Legt den Wert der positioningSystemRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPositioningSystemRef(String value) {
        this.positioningSystemRef = value;
    }

}
