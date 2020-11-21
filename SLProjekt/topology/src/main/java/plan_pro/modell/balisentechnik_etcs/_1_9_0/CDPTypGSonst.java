//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CDP_Typ_GSonst complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CDP_Typ_GSonst">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Anwendung_Sonst" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCAnwendung_Sonst"/>
 *         &lt;element name="DP_Typ_Sonst" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDP_Typ_Sonst"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CDP_Typ_GSonst", propOrder = {
    "anwendungSonst",
    "dpTypSonst"
})
public class CDPTypGSonst {

    @XmlElement(name = "Anwendung_Sonst", required = true)
    protected TCAnwendungSonst anwendungSonst;
    @XmlElement(name = "DP_Typ_Sonst", required = true)
    protected TCDPTypSonst dpTypSonst;

    /**
     * Ruft den Wert der anwendungSonst-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAnwendungSonst }
     *     
     */
    public TCAnwendungSonst getAnwendungSonst() {
        return anwendungSonst;
    }

    /**
     * Legt den Wert der anwendungSonst-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAnwendungSonst }
     *     
     */
    public void setAnwendungSonst(TCAnwendungSonst value) {
        this.anwendungSonst = value;
    }

    /**
     * Ruft den Wert der dpTypSonst-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDPTypSonst }
     *     
     */
    public TCDPTypSonst getDPTypSonst() {
        return dpTypSonst;
    }

    /**
     * Legt den Wert der dpTypSonst-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDPTypSonst }
     *     
     */
    public void setDPTypSonst(TCDPTypSonst value) {
        this.dpTypSonst = value;
    }

}
