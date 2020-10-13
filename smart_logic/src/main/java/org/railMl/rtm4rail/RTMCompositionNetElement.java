//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:06:07 PM CEST 
//


package org.railMl.rtm4rail;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RTM_CompositionNetElement complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RTM_CompositionNetElement">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}RTM_NetElement">
 *       &lt;sequence>
 *         &lt;element name="elementCollectionUnordered" type="{https://www.railml.org/schemas/3.1}RTM_UnorderedCollection" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="elementCollectionOrdered" type="{https://www.railml.org/schemas/3.1}RTM_OrderedCollection" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTM_CompositionNetElement", propOrder = {
    "elementCollectionUnordered",
    "elementCollectionOrdered"
})
@XmlSeeAlso({
    RTMPositioningNetElement.class
})
public class RTMCompositionNetElement
    extends RTMNetElement
{

    protected List<RTMUnorderedCollection> elementCollectionUnordered;
    protected List<RTMOrderedCollection> elementCollectionOrdered;

    /**
     * Gets the value of the elementCollectionUnordered property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elementCollectionUnordered property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElementCollectionUnordered().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RTMUnorderedCollection }
     * 
     * 
     */
    public List<RTMUnorderedCollection> getElementCollectionUnordered() {
        if (elementCollectionUnordered == null) {
            elementCollectionUnordered = new ArrayList<RTMUnorderedCollection>();
        }
        return this.elementCollectionUnordered;
    }

    /**
     * Gets the value of the elementCollectionOrdered property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elementCollectionOrdered property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElementCollectionOrdered().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RTMOrderedCollection }
     * 
     * 
     */
    public List<RTMOrderedCollection> getElementCollectionOrdered() {
        if (elementCollectionOrdered == null) {
            elementCollectionOrdered = new ArrayList<RTMOrderedCollection>();
        }
        return this.elementCollectionOrdered;
    }

}
