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
 * <p>Java-Klasse für XCrossing complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="XCrossing">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}FunctionalInfrastructureEntity">
 *       &lt;sequence>
 *         &lt;element name="crossesElement" type="{https://www.railml.org/schemas/3.1}CrossedElement" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XCrossing", propOrder = {
    "crossesElement"
})
@XmlSeeAlso({
    UnderCrossing.class,
    LevelCrossingIS.class,
    OverCrossing.class
})
public abstract class XCrossing
    extends FunctionalInfrastructureEntity
{

    protected List<CrossedElement> crossesElement;

    /**
     * Gets the value of the crossesElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the crossesElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCrossesElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CrossedElement }
     * 
     * 
     */
    public List<CrossedElement> getCrossesElement() {
        if (crossesElement == null) {
            crossesElement = new ArrayList<CrossedElement>();
        }
        return this.crossesElement;
    }

}
