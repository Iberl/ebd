//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * A signal aspect according to the IM regulations. Each aspect is given a unique identifier, a name, e.g. Vr-6 and description e.g. warning signal - expect stop (Vorsignal Halt erwarten). This element allows a generic classification of each aspect. The aspect can include speed information.
 * 
 * <p>Java-Klasse für GenericAspect complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GenericAspect">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="genericAspect" use="required" type="{https://www.railml.org/schemas/3.1}tGenericAspectList" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericAspect")
public class GenericAspect
    extends EntityIL
{

    @XmlAttribute(name = "genericAspect", required = true)
    protected TGenericAspectList genericAspect;

    /**
     * Ruft den Wert der genericAspect-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TGenericAspectList }
     *     
     */
    public TGenericAspectList getGenericAspect() {
        return genericAspect;
    }

    /**
     * Legt den Wert der genericAspect-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TGenericAspectList }
     *     
     */
    public void setGenericAspect(TGenericAspectList value) {
        this.genericAspect = value;
    }

}
