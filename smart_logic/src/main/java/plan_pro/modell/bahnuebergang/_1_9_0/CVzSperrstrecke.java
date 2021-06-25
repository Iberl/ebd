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
 * <p>Java-Klasse f�r CVz_Sperrstrecke complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CVz_Sperrstrecke">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Vz_Sperrstrecke_Vorgeschaltet" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CVz_Sperrstrecke_Vorgeschaltet" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="Sperrstrecke" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCSperrstrecke"/>
 *           &lt;element name="Sperrstrecke_Fussgaenger" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCSperrstrecke_Fussgaenger"/>
 *           &lt;element name="Vz_Sperrstrecke_Schranke" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CVz_Sperrstrecke_Schranke"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CVz_Sperrstrecke", propOrder = {
    "vzSperrstreckeVorgeschaltet",
    "sperrstrecke",
    "sperrstreckeFussgaenger",
    "vzSperrstreckeSchranke"
})
public class CVzSperrstrecke {

    @XmlElement(name = "Vz_Sperrstrecke_Vorgeschaltet")
    protected CVzSperrstreckeVorgeschaltet vzSperrstreckeVorgeschaltet;
    @XmlElement(name = "Sperrstrecke")
    protected TCSperrstrecke sperrstrecke;
    @XmlElement(name = "Sperrstrecke_Fussgaenger")
    protected TCSperrstreckeFussgaenger sperrstreckeFussgaenger;
    @XmlElement(name = "Vz_Sperrstrecke_Schranke")
    protected CVzSperrstreckeSchranke vzSperrstreckeSchranke;

    /**
     * Ruft den Wert der vzSperrstreckeVorgeschaltet-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CVzSperrstreckeVorgeschaltet }
     *     
     */
    public CVzSperrstreckeVorgeschaltet getVzSperrstreckeVorgeschaltet() {
        return vzSperrstreckeVorgeschaltet;
    }

    /**
     * Legt den Wert der vzSperrstreckeVorgeschaltet-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CVzSperrstreckeVorgeschaltet }
     *     
     */
    public void setVzSperrstreckeVorgeschaltet(CVzSperrstreckeVorgeschaltet value) {
        this.vzSperrstreckeVorgeschaltet = value;
    }

    /**
     * Ruft den Wert der sperrstrecke-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSperrstrecke }
     *     
     */
    public TCSperrstrecke getSperrstrecke() {
        return sperrstrecke;
    }

    /**
     * Legt den Wert der sperrstrecke-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSperrstrecke }
     *     
     */
    public void setSperrstrecke(TCSperrstrecke value) {
        this.sperrstrecke = value;
    }

    /**
     * Ruft den Wert der sperrstreckeFussgaenger-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSperrstreckeFussgaenger }
     *     
     */
    public TCSperrstreckeFussgaenger getSperrstreckeFussgaenger() {
        return sperrstreckeFussgaenger;
    }

    /**
     * Legt den Wert der sperrstreckeFussgaenger-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSperrstreckeFussgaenger }
     *     
     */
    public void setSperrstreckeFussgaenger(TCSperrstreckeFussgaenger value) {
        this.sperrstreckeFussgaenger = value;
    }

    /**
     * Ruft den Wert der vzSperrstreckeSchranke-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CVzSperrstreckeSchranke }
     *     
     */
    public CVzSperrstreckeSchranke getVzSperrstreckeSchranke() {
        return vzSperrstreckeSchranke;
    }

    /**
     * Legt den Wert der vzSperrstreckeSchranke-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CVzSperrstreckeSchranke }
     *     
     */
    public void setVzSperrstreckeSchranke(CVzSperrstreckeSchranke value) {
        this.vzSperrstreckeSchranke = value;
    }

}
