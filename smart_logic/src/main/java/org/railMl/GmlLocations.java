//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r GmlLocations complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GmlLocations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lineString" type="{https://www.railml.org/schemas/3.1}LineTypeCoordinate" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="point" type="{https://www.railml.org/schemas/3.1}PointTypeCoordinate" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GmlLocations", propOrder = {
    "lineString",
    "point"
})
public class GmlLocations {

    protected List<LineTypeCoordinate> lineString;
    protected List<PointTypeCoordinate> point;

    /**
     * Gets the value of the lineString property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineString property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineString().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineTypeCoordinate }
     * 
     * 
     */
    public List<LineTypeCoordinate> getLineString() {
        if (lineString == null) {
            lineString = new ArrayList<LineTypeCoordinate>();
        }
        return this.lineString;
    }

    /**
     * Gets the value of the point property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the point property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PointTypeCoordinate }
     * 
     * 
     */
    public List<PointTypeCoordinate> getPoint() {
        if (point == null) {
            point = new ArrayList<PointTypeCoordinate>();
        }
        return this.point;
    }

}
