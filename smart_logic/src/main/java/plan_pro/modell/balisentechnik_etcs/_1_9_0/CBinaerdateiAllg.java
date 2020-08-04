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
 * <p>Java-Klasse f�r CBinaerdatei_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBinaerdatei_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Dateiname" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDateiname" minOccurs="0"/>
 *         &lt;element name="Dateityp_Binaerdatei" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDateityp_Binaerdatei"/>
 *         &lt;element name="Daten" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDaten"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBinaerdatei_Allg", propOrder = {
    "dateiname",
    "dateitypBinaerdatei",
    "daten"
})
public class CBinaerdateiAllg {

    @XmlElement(name = "Dateiname")
    protected TCDateiname dateiname;
    @XmlElement(name = "Dateityp_Binaerdatei", required = true)
    protected TCDateitypBinaerdatei dateitypBinaerdatei;
    @XmlElement(name = "Daten", required = true)
    protected TCDaten daten;

    /**
     * Ruft den Wert der dateiname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDateiname }
     *     
     */
    public TCDateiname getDateiname() {
        return dateiname;
    }

    /**
     * Legt den Wert der dateiname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDateiname }
     *     
     */
    public void setDateiname(TCDateiname value) {
        this.dateiname = value;
    }

    /**
     * Ruft den Wert der dateitypBinaerdatei-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDateitypBinaerdatei }
     *     
     */
    public TCDateitypBinaerdatei getDateitypBinaerdatei() {
        return dateitypBinaerdatei;
    }

    /**
     * Legt den Wert der dateitypBinaerdatei-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDateitypBinaerdatei }
     *     
     */
    public void setDateitypBinaerdatei(TCDateitypBinaerdatei value) {
        this.dateitypBinaerdatei = value;
    }

    /**
     * Ruft den Wert der daten-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDaten }
     *     
     */
    public TCDaten getDaten() {
        return daten;
    }

    /**
     * Legt den Wert der daten-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDaten }
     *     
     */
    public void setDaten(TCDaten value) {
        this.daten = value;
    }

}
