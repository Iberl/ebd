//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.flankenschutz._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDAnfordererElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFla_Schutz_Anforderer complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFla_Schutz_Anforderer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fahrt_Ueber" type="{http://www.plan-pro.org/modell/Flankenschutz/1.9.0.2}TCFahrt_Ueber" minOccurs="0"/>
 *         &lt;element name="ID_Anforderer_Element" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anforderer_Element"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFla_Schutz_Anforderer", propOrder = {
    "fahrtUeber",
    "idAnfordererElement"
})
public class CFlaSchutzAnforderer {

    @XmlElement(name = "Fahrt_Ueber")
    protected TCFahrtUeber fahrtUeber;
    @XmlElement(name = "ID_Anforderer_Element", required = true)
    protected TCIDAnfordererElement idAnfordererElement;

    /**
     * Ruft den Wert der fahrtUeber-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFahrtUeber }
     *     
     */
    public TCFahrtUeber getFahrtUeber() {
        return fahrtUeber;
    }

    /**
     * Legt den Wert der fahrtUeber-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFahrtUeber }
     *     
     */
    public void setFahrtUeber(TCFahrtUeber value) {
        this.fahrtUeber = value;
    }

    /**
     * Ruft den Wert der idAnfordererElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnfordererElement }
     *     
     */
    public TCIDAnfordererElement getIDAnfordererElement() {
        return idAnfordererElement;
    }

    /**
     * Legt den Wert der idAnfordererElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnfordererElement }
     *     
     */
    public void setIDAnfordererElement(TCIDAnfordererElement value) {
        this.idAnfordererElement = value;
    }

}
