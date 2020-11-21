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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RTM_Network complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RTM_Network">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}RTM_NamedResource">
 *       &lt;sequence>
 *         &lt;element name="level" type="{https://www.railml.org/schemas/3.1}RTM_LevelNetwork" maxOccurs="unbounded"/>
 *         &lt;element name="networkResource" type="{https://www.railml.org/schemas/3.1}RTM_NetworkResource" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTM_Network", propOrder = {
    "level",
    "networkResource"
})
public abstract class RTMNetwork
    extends RTMNamedResource
{

    @XmlElement(required = true)
    protected List<RTMLevelNetwork> level;
    protected List<RTMNetworkResource> networkResource;

    /**
     * Gets the value of the level property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the level property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLevel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RTMLevelNetwork }
     * 
     * 
     */
    public List<RTMLevelNetwork> getLevel() {
        if (level == null) {
            level = new ArrayList<RTMLevelNetwork>();
        }
        return this.level;
    }

    /**
     * Gets the value of the networkResource property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the networkResource property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetworkResource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RTMNetworkResource }
     * 
     * 
     */
    public List<RTMNetworkResource> getNetworkResource() {
        if (networkResource == null) {
            networkResource = new ArrayList<RTMNetworkResource>();
        }
        return this.networkResource;
    }

}
