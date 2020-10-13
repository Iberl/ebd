//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * The list of all possible types being specific for this IM.
 * 
 * <p>Java-Klasse für GenericTypes complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GenericTypes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hasAspect" type="{https://www.railml.org/schemas/3.1}GenericAspect" maxOccurs="unbounded" minOccurs="2"/>
 *         &lt;element name="hasTVDresetStrategy" type="{https://www.railml.org/schemas/3.1}GenericResetStrategy" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="hasRouteType" type="{https://www.railml.org/schemas/3.1}GenericRouteType" maxOccurs="unbounded"/>
 *         &lt;element name="hasLevelCrossingType" type="{https://www.railml.org/schemas/3.1}LevelCrossingTypeList" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="hasElementGroupType" type="{https://www.railml.org/schemas/3.1}ElementGroupingTypes" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="hasDetectorTypes" type="{https://www.railml.org/schemas/3.1}DetectorTypes" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{https://www.railml.org/schemas/3.1}anyAttribute"/>
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericTypes", propOrder = {
    "hasAspect",
    "hasTVDresetStrategy",
    "hasRouteType",
    "hasLevelCrossingType",
    "hasElementGroupType",
    "hasDetectorTypes"
})
public class GenericTypes {

    @XmlElement(required = true)
    protected List<GenericAspect> hasAspect;
    protected List<GenericResetStrategy> hasTVDresetStrategy;
    @XmlElement(required = true)
    protected List<GenericRouteType> hasRouteType;
    protected List<LevelCrossingTypeList> hasLevelCrossingType;
    protected List<ElementGroupingTypes> hasElementGroupType;
    protected List<DetectorTypes> hasDetectorTypes;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the hasAspect property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasAspect property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasAspect().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericAspect }
     * 
     * 
     */
    public List<GenericAspect> getHasAspect() {
        if (hasAspect == null) {
            hasAspect = new ArrayList<GenericAspect>();
        }
        return this.hasAspect;
    }

    /**
     * Gets the value of the hasTVDresetStrategy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasTVDresetStrategy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasTVDresetStrategy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericResetStrategy }
     * 
     * 
     */
    public List<GenericResetStrategy> getHasTVDresetStrategy() {
        if (hasTVDresetStrategy == null) {
            hasTVDresetStrategy = new ArrayList<GenericResetStrategy>();
        }
        return this.hasTVDresetStrategy;
    }

    /**
     * Gets the value of the hasRouteType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasRouteType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasRouteType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericRouteType }
     * 
     * 
     */
    public List<GenericRouteType> getHasRouteType() {
        if (hasRouteType == null) {
            hasRouteType = new ArrayList<GenericRouteType>();
        }
        return this.hasRouteType;
    }

    /**
     * Gets the value of the hasLevelCrossingType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasLevelCrossingType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasLevelCrossingType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LevelCrossingTypeList }
     * 
     * 
     */
    public List<LevelCrossingTypeList> getHasLevelCrossingType() {
        if (hasLevelCrossingType == null) {
            hasLevelCrossingType = new ArrayList<LevelCrossingTypeList>();
        }
        return this.hasLevelCrossingType;
    }

    /**
     * Gets the value of the hasElementGroupType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasElementGroupType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasElementGroupType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementGroupingTypes }
     * 
     * 
     */
    public List<ElementGroupingTypes> getHasElementGroupType() {
        if (hasElementGroupType == null) {
            hasElementGroupType = new ArrayList<ElementGroupingTypes>();
        }
        return this.hasElementGroupType;
    }

    /**
     * Gets the value of the hasDetectorTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasDetectorTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasDetectorTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetectorTypes }
     * 
     * 
     */
    public List<DetectorTypes> getHasDetectorTypes() {
        if (hasDetectorTypes == null) {
            hasDetectorTypes = new ArrayList<DetectorTypes>();
        }
        return this.hasDetectorTypes;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
