//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.flankenschutz._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDWKrGspElement;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFla_Schutz_W_Gsp complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFla_Schutz_W_Gsp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fla_W_Lage" type="{http://www.plan-pro.org/modell/Flankenschutz/1.9.0.2}TCFla_W_Lage" minOccurs="0"/>
 *         &lt;element name="ID_Fla_W_Gsp_Element" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_W_Kr_Gsp_Element"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFla_Schutz_W_Gsp", propOrder = {
    "flaWLage",
    "idFlaWGspElement"
})
public class CFlaSchutzWGsp {

    @XmlElement(name = "Fla_W_Lage")
    protected TCFlaWLage flaWLage;
    @XmlElement(name = "ID_Fla_W_Gsp_Element", required = true)
    protected TCIDWKrGspElement idFlaWGspElement;

    /**
     * Ruft den Wert der flaWLage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFlaWLage }
     *     
     */
    public TCFlaWLage getFlaWLage() {
        return flaWLage;
    }

    /**
     * Legt den Wert der flaWLage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFlaWLage }
     *     
     */
    public void setFlaWLage(TCFlaWLage value) {
        this.flaWLage = value;
    }

    /**
     * Ruft den Wert der idFlaWGspElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public TCIDWKrGspElement getIDFlaWGspElement() {
        return idFlaWGspElement;
    }

    /**
     * Legt den Wert der idFlaWGspElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public void setIDFlaWGspElement(TCIDWKrGspElement value) {
        this.idFlaWGspElement = value;
    }

}
