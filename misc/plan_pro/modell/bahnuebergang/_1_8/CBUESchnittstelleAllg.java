//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bahnuebergang._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="BUE_Nachlaufzeit" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}TCBUE_Nachlaufzeit" minOccurs="0"/>
 *         &lt;element name="BUE_Vorlaufzeit" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}TCBUE_Vorlaufzeit" minOccurs="0"/>
 *         &lt;element name="LFUE_Impuls" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}TCLFUE_Impuls" minOccurs="0"/>
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
    "lfueImpuls"
})
public class CBUESchnittstelleAllg {

    @XmlElement(name = "BUE_Nachlaufzeit")
    protected TCBUENachlaufzeit bueNachlaufzeit;
    @XmlElement(name = "BUE_Vorlaufzeit")
    protected TCBUEVorlaufzeit bueVorlaufzeit;
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
