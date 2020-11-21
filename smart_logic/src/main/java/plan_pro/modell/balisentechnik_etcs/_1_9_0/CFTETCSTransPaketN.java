//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFT_ETCS_Trans_Paket_N complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFT_ETCS_Trans_Paket_N">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ETCS_Paketnummer" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCETCS_Paketnummer"/>
 *         &lt;element name="ETCS_Par_Erlaeuterung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCETCS_Par_Erlaeuterung" minOccurs="0"/>
 *         &lt;element name="ETCS_Parametername" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCETCS_Parametername"/>
 *         &lt;element name="ETCS_Parameterwert" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCETCS_Parameterwert"/>
 *         &lt;element name="Rekursion_2_Nr" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCRekursion_2_Nr" minOccurs="0"/>
 *         &lt;element name="Rekursion_Nr" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCRekursion_Nr" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFT_ETCS_Trans_Paket_N", propOrder = {
    "etcsPaketnummer",
    "etcsParErlaeuterung",
    "etcsParametername",
    "etcsParameterwert",
    "rekursion2Nr",
    "rekursionNr"
})
public class CFTETCSTransPaketN {

    @XmlElement(name = "ETCS_Paketnummer", required = true)
    protected TCETCSPaketnummer etcsPaketnummer;
    @XmlElement(name = "ETCS_Par_Erlaeuterung")
    protected TCETCSParErlaeuterung etcsParErlaeuterung;
    @XmlElement(name = "ETCS_Parametername", required = true)
    protected TCETCSParametername etcsParametername;
    @XmlElement(name = "ETCS_Parameterwert", required = true)
    protected TCETCSParameterwert etcsParameterwert;
    @XmlElement(name = "Rekursion_2_Nr")
    protected TCRekursion2Nr rekursion2Nr;
    @XmlElement(name = "Rekursion_Nr")
    protected TCRekursionNr rekursionNr;

    /**
     * Ruft den Wert der etcsPaketnummer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCETCSPaketnummer }
     *     
     */
    public TCETCSPaketnummer getETCSPaketnummer() {
        return etcsPaketnummer;
    }

    /**
     * Legt den Wert der etcsPaketnummer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCETCSPaketnummer }
     *     
     */
    public void setETCSPaketnummer(TCETCSPaketnummer value) {
        this.etcsPaketnummer = value;
    }

    /**
     * Ruft den Wert der etcsParErlaeuterung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCETCSParErlaeuterung }
     *     
     */
    public TCETCSParErlaeuterung getETCSParErlaeuterung() {
        return etcsParErlaeuterung;
    }

    /**
     * Legt den Wert der etcsParErlaeuterung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCETCSParErlaeuterung }
     *     
     */
    public void setETCSParErlaeuterung(TCETCSParErlaeuterung value) {
        this.etcsParErlaeuterung = value;
    }

    /**
     * Ruft den Wert der etcsParametername-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCETCSParametername }
     *     
     */
    public TCETCSParametername getETCSParametername() {
        return etcsParametername;
    }

    /**
     * Legt den Wert der etcsParametername-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCETCSParametername }
     *     
     */
    public void setETCSParametername(TCETCSParametername value) {
        this.etcsParametername = value;
    }

    /**
     * Ruft den Wert der etcsParameterwert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCETCSParameterwert }
     *     
     */
    public TCETCSParameterwert getETCSParameterwert() {
        return etcsParameterwert;
    }

    /**
     * Legt den Wert der etcsParameterwert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCETCSParameterwert }
     *     
     */
    public void setETCSParameterwert(TCETCSParameterwert value) {
        this.etcsParameterwert = value;
    }

    /**
     * Ruft den Wert der rekursion2Nr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRekursion2Nr }
     *     
     */
    public TCRekursion2Nr getRekursion2Nr() {
        return rekursion2Nr;
    }

    /**
     * Legt den Wert der rekursion2Nr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRekursion2Nr }
     *     
     */
    public void setRekursion2Nr(TCRekursion2Nr value) {
        this.rekursion2Nr = value;
    }

    /**
     * Ruft den Wert der rekursionNr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRekursionNr }
     *     
     */
    public TCRekursionNr getRekursionNr() {
        return rekursionNr;
    }

    /**
     * Legt den Wert der rekursionNr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRekursionNr }
     *     
     */
    public void setRekursionNr(TCRekursionNr value) {
        this.rekursionNr = value;
    }

}
