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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r LocalOperationAreas complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LocalOperationAreas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="localOperationArea" type="{https://www.railml.org/schemas/3.1}LocalOperationArea" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocalOperationAreas", propOrder = {
    "localOperationArea"
})
public class LocalOperationAreas {

    @XmlElement(required = true)
    protected List<LocalOperationArea> localOperationArea;

    /**
     * Gets the value of the localOperationArea property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the localOperationArea property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocalOperationArea().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocalOperationArea }
     * 
     * 
     */
    public List<LocalOperationArea> getLocalOperationArea() {
        if (localOperationArea == null) {
            localOperationArea = new ArrayList<LocalOperationArea>();
        }
        return this.localOperationArea;
    }

}