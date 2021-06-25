//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CVz_Sperrstrecke_Schranke complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CVz_Sperrstrecke_Schranke">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Raeumstrecke" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCRaeumstrecke"/>
 *         &lt;element name="Teilsperrstrecke" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCTeilsperrstrecke"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CVz_Sperrstrecke_Schranke", propOrder = {
    "raeumstrecke",
    "teilsperrstrecke"
})
public class CVzSperrstreckeSchranke {

    @XmlElement(name = "Raeumstrecke", required = true)
    protected TCRaeumstrecke raeumstrecke;
    @XmlElement(name = "Teilsperrstrecke", required = true)
    protected TCTeilsperrstrecke teilsperrstrecke;

    /**
     * Ruft den Wert der raeumstrecke-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRaeumstrecke }
     *     
     */
    public TCRaeumstrecke getRaeumstrecke() {
        return raeumstrecke;
    }

    /**
     * Legt den Wert der raeumstrecke-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRaeumstrecke }
     *     
     */
    public void setRaeumstrecke(TCRaeumstrecke value) {
        this.raeumstrecke = value;
    }

    /**
     * Ruft den Wert der teilsperrstrecke-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTeilsperrstrecke }
     *     
     */
    public TCTeilsperrstrecke getTeilsperrstrecke() {
        return teilsperrstrecke;
    }

    /**
     * Legt den Wert der teilsperrstrecke-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTeilsperrstrecke }
     *     
     */
    public void setTeilsperrstrecke(TCTeilsperrstrecke value) {
        this.teilsperrstrecke = value;
    }

}
