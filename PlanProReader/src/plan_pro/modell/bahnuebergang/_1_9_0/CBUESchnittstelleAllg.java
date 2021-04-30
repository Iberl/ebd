//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBUE_Schnittstelle_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Schnittstelle_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BUE_Nachlaufzeit" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBUE_Nachlaufzeit" minOccurs="0"/>
 *         &lt;element name="BUE_Vorlaufzeit" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBUE_Vorlaufzeit" minOccurs="0"/>
 *         &lt;element name="Hp_Ersatzstecker" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCHp_Ersatzstecker" minOccurs="0"/>
 *         &lt;element name="LFUE_Impuls" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCLFUE_Impuls" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Schnittstelle_Allg", propOrder = {
    "bueNachlaufzeit",
    "bueVorlaufzeit",
    "hpErsatzstecker",
    "lfueImpuls"
})
public class CBUESchnittstelleAllg {

    @XmlElement(name = "BUE_Nachlaufzeit")
    protected TCBUENachlaufzeit bueNachlaufzeit;
    @XmlElement(name = "BUE_Vorlaufzeit")
    protected TCBUEVorlaufzeit bueVorlaufzeit;
    @XmlElement(name = "Hp_Ersatzstecker")
    protected TCHpErsatzstecker hpErsatzstecker;
    @XmlElement(name = "LFUE_Impuls")
    protected TCLFUEImpuls lfueImpuls;

    /**
     * Ruft den Wert der bueNachlaufzeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBUENachlaufzeit }
     *     
     */
    public TCBUENachlaufzeit getBUENachlaufzeit() {
        return bueNachlaufzeit;
    }

    /**
     * Legt den Wert der bueNachlaufzeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBUENachlaufzeit }
     *     
     */
    public void setBUENachlaufzeit(TCBUENachlaufzeit value) {
        this.bueNachlaufzeit = value;
    }

    /**
     * Ruft den Wert der bueVorlaufzeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBUEVorlaufzeit }
     *     
     */
    public TCBUEVorlaufzeit getBUEVorlaufzeit() {
        return bueVorlaufzeit;
    }

    /**
     * Legt den Wert der bueVorlaufzeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBUEVorlaufzeit }
     *     
     */
    public void setBUEVorlaufzeit(TCBUEVorlaufzeit value) {
        this.bueVorlaufzeit = value;
    }

    /**
     * Ruft den Wert der hpErsatzstecker-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHpErsatzstecker }
     *     
     */
    public TCHpErsatzstecker getHpErsatzstecker() {
        return hpErsatzstecker;
    }

    /**
     * Legt den Wert der hpErsatzstecker-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHpErsatzstecker }
     *     
     */
    public void setHpErsatzstecker(TCHpErsatzstecker value) {
        this.hpErsatzstecker = value;
    }

    /**
     * Ruft den Wert der lfueImpuls-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLFUEImpuls }
     *     
     */
    public TCLFUEImpuls getLFUEImpuls() {
        return lfueImpuls;
    }

    /**
     * Legt den Wert der lfueImpuls-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLFUEImpuls }
     *     
     */
    public void setLFUEImpuls(TCLFUEImpuls value) {
        this.lfueImpuls = value;
    }

}
