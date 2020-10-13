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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RTM_LocatedNetEntity complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RTM_LocatedNetEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}RTM_NetEntity">
 *       &lt;sequence>
 *         &lt;element name="areaLocation" type="{https://www.railml.org/schemas/3.1}RTM_AreaLocation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="linearLocation" type="{https://www.railml.org/schemas/3.1}RTM_LinearLocation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="spotLocation" type="{https://www.railml.org/schemas/3.1}RTM_SpotLocation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTM_LocatedNetEntity", propOrder = {
    "areaLocation",
    "linearLocation",
    "spotLocation"
})
@XmlSeeAlso({
    EntityIS.class
})
public class RTMLocatedNetEntity
    extends RTMNetEntity
{

    protected List<RTMAreaLocation> areaLocation;
    protected List<RTMLinearLocation> linearLocation;
    protected List<RTMSpotLocation> spotLocation;

    /**
     * Gets the value of the areaLocation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the areaLocation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAreaLocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RTMAreaLocation }
     * 
     * 
     */
    public List<RTMAreaLocation> getAreaLocation() {
        if (areaLocation == null) {
            areaLocation = new ArrayList<RTMAreaLocation>();
        }
        return this.areaLocation;
    }

    /**
     * Gets the value of the linearLocation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linearLocation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinearLocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RTMLinearLocation }
     * 
     * 
     */
    public List<RTMLinearLocation> getLinearLocation() {
        if (linearLocation == null) {
            linearLocation = new ArrayList<RTMLinearLocation>();
        }
        return this.linearLocation;
    }

    /**
     * Gets the value of the spotLocation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the spotLocation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpotLocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RTMSpotLocation }
     * 
     * 
     */
    public List<RTMSpotLocation> getSpotLocation() {
        if (spotLocation == null) {
            spotLocation = new ArrayList<RTMSpotLocation>();
        }
        return this.spotLocation;
    }

}
