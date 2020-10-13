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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The Restricted Area (RA) is an area of the yard that the interlocking can set aside from normal operation. Railway personnel typically take local control of a RA and the interlocking detects switches and signal such that regular trains cannot enter the RA. Typical Restricted Areas are local shunting areas, working area or possession areas. Local workers take over control of the RA from the interlocking. The type of RA defines the extent of control, i.e. what the interlocking allows local workers to do. E.g. regulations may allow local route setting in a shunting area but not in a working zone. Track workers may be allowed to operate individual switches in a working zone but they cannot set routes. Therefore, the interlocking must be aware of the RA type. This type datatype is abstract so the user is forced to specialize it.
 * 
 * <p>Java-Klasse für RestrictedArea complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RestrictedArea">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}TrackAsset">
 *       &lt;sequence>
 *         &lt;element name="isLimitedBy" type="{https://www.railml.org/schemas/3.1}EntityILref" maxOccurs="unbounded"/>
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
@XmlType(name = "RestrictedArea", propOrder = {
    "isLimitedBy"
})
@XmlSeeAlso({
    ShuntingZone.class,
    LocalOperationArea.class,
    WorkZone.class
})
public abstract class RestrictedArea
    extends TrackAsset
{

    @XmlElement(required = true)
    protected List<EntityILref> isLimitedBy;

    /**
     * Gets the value of the isLimitedBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the isLimitedBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIsLimitedBy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityILref }
     * 
     * 
     */
    public List<EntityILref> getIsLimitedBy() {
        if (isLimitedBy == null) {
            isLimitedBy = new ArrayList<EntityILref>();
        }
        return this.isLimitedBy;
    }

}
