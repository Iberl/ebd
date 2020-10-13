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
 * <p>Java-Klasse für RTM_UnorderedCollection complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RTM_UnorderedCollection">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}RTM_ElementPartCollection">
 *       &lt;sequence>
 *         &lt;element name="elementPart" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTM_UnorderedCollection", propOrder = {
    "elementPart"
})
public class RTMUnorderedCollection
    extends RTMElementPartCollection
{

    @XmlElement(required = true)
    protected List<TElementWithIDref> elementPart;

    /**
     * Gets the value of the elementPart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elementPart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElementPart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TElementWithIDref }
     * 
     * 
     */
    public List<TElementWithIDref> getElementPart() {
        if (elementPart == null) {
            elementPart = new ArrayList<TElementWithIDref>();
        }
        return this.elementPart;
    }

}
