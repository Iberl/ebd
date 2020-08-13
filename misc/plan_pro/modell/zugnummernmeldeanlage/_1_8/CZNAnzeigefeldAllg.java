//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.zugnummernmeldeanlage._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZN_Anzeigefeld_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZN_Anzeigefeld_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bedienbarkeit_Anzeigefeld" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCBedienbarkeit_Anzeigefeld"/>
 *         &lt;element name="Bf_Nr_ANB" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCBf_Nr_ANB" minOccurs="0"/>
 *         &lt;element name="Bf_Nr_ZN_A" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCBf_Nr_ZN_A"/>
 *         &lt;element name="Funktionalitaet_Anzeigefeld" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCFunktionalitaet_Anzeigefeld"/>
 *         &lt;element name="HOA" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCHOA" minOccurs="0"/>
 *         &lt;element name="Sichtbarkeit_Anzeigefeld" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCSichtbarkeit_Anzeigefeld"/>
 *         &lt;element name="Verzoegerung_Manuell_Loeschung" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCVerzoegerung_Manuell_Loeschung" minOccurs="0"/>
 *         &lt;element name="Vormeldestart" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCVormeldestart" minOccurs="0"/>
 *         &lt;element name="ZN_Anzeigefeld_Loeschkriterium" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCZN_Anzeigefeld_Loeschkriterium" minOccurs="0"/>
 *         &lt;element name="ZN_Feld_Ohne_Anzeige" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCZN_Feld_Ohne_Anzeige" minOccurs="0"/>
 *         &lt;element name="Zugvorbereitungsmeldung" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCZugvorbereitungsmeldung" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZN_Anzeigefeld_Allg", propOrder = {
    "bedienbarkeitAnzeigefeld",
    "bfNrANB",
    "bfNrZNA",
    "funktionalitaetAnzeigefeld",
    "hoa",
    "sichtbarkeitAnzeigefeld",
    "verzoegerungManuellLoeschung",
    "vormeldestart",
    "znAnzeigefeldLoeschkriterium",
    "znFeldOhneAnzeige",
    "zugvorbereitungsmeldung"
})
public class CZNAnzeigefeldAllg {

    @XmlElement(name = "Bedienbarkeit_Anzeigefeld", required = true)
    protected TCBedienbarkeitAnzeigefeld bedienbarkeitAnzeigefeld;
    @XmlElement(name = "Bf_Nr_ANB")
    protected TCBfNrANB bfNrANB;
    @XmlElement(name = "Bf_Nr_ZN_A", required = true)
    protected TCBfNrZNA bfNrZNA;
    @XmlElement(name = "Funktionalitaet_Anzeigefeld", required = true)
    protected TCFunktionalitaetAnzeigefeld funktionalitaetAnzeigefeld;
    @XmlElement(name = "HOA")
    protected TCHOA hoa;
    @XmlElement(name = "Sichtbarkeit_Anzeigefeld", required = true)
    protected TCSichtbarkeitAnzeigefeld sichtbarkeitAnzeigefeld;
    @XmlElement(name = "Verzoegerung_Manuell_Loeschung")
    protected TCVerzoegerungManuellLoeschung verzoegerungManuellLoeschung;
    @XmlElement(name = "Vormeldestart")
    protected TCVormeldestart vormeldestart;
    @XmlElement(name = "ZN_Anzeigefeld_Loeschkriterium")
    protected TCZNAnzeigefeldLoeschkriterium znAnzeigefeldLoeschkriterium;
    @XmlElement(name = "ZN_Feld_Ohne_Anzeige")
    protected TCZNFeldOhneAnzeige znFeldOhneAnzeige;
    @XmlElement(name = "Zugvorbereitungsmeldung")
    protected TCZugvorbereitungsmeldung zugvorbereitungsmeldung;

    /**
     * Ruft den Wert der bedienbarkeitAnzeigefeld-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBedienbarkeitAnzeigefeld }
     *     
     */
    public TCBedienbarkeitAnzeigefeld getBedienbarkeitAnzeigefeld() {
        return bedienbarkeitAnzeigefeld;
    }

    /**
     * Legt den Wert der bedienbarkeitAnzeigefeld-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBedienbarkeitAnzeigefeld }
     *     
     */
    public void setBedienbarkeitAnzeigefeld(TCBedienbarkeitAnzeigefeld value) {
        this.bedienbarkeitAnzeigefeld = value;
    }

    /**
     * Ruft den Wert der bfNrANB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBfNrANB }
     *     
     */
    public TCBfNrANB getBfNrANB() {
        return bfNrANB;
    }

    /**
     * Legt den Wert der bfNrANB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBfNrANB }
     *     
     */
    public void setBfNrANB(TCBfNrANB value) {
        this.bfNrANB = value;
    }

    /**
     * Ruft den Wert der bfNrZNA-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBfNrZNA }
     *     
     */
    public TCBfNrZNA getBfNrZNA() {
        return bfNrZNA;
    }

    /**
     * Legt den Wert der bfNrZNA-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBfNrZNA }
     *     
     */
    public void setBfNrZNA(TCBfNrZNA value) {
        this.bfNrZNA = value;
    }

    /**
     * Ruft den Wert der funktionalitaetAnzeigefeld-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFunktionalitaetAnzeigefeld }
     *     
     */
    public TCFunktionalitaetAnzeigefeld getFunktionalitaetAnzeigefeld() {
        return funktionalitaetAnzeigefeld;
    }

    /**
     * Legt den Wert der funktionalitaetAnzeigefeld-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFunktionalitaetAnzeigefeld }
     *     
     */
    public void setFunktionalitaetAnzeigefeld(TCFunktionalitaetAnzeigefeld value) {
        this.funktionalitaetAnzeigefeld = value;
    }

    /**
     * Ruft den Wert der hoa-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHOA }
     *     
     */
    public TCHOA getHOA() {
        return hoa;
    }

    /**
     * Legt den Wert der hoa-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHOA }
     *     
     */
    public void setHOA(TCHOA value) {
        this.hoa = value;
    }

    /**
     * Ruft den Wert der sichtbarkeitAnzeigefeld-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSichtbarkeitAnzeigefeld }
     *     
     */
    public TCSichtbarkeitAnzeigefeld getSichtbarkeitAnzeigefeld() {
        return sichtbarkeitAnzeigefeld;
    }

    /**
     * Legt den Wert der sichtbarkeitAnzeigefeld-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSichtbarkeitAnzeigefeld }
     *     
     */
    public void setSichtbarkeitAnzeigefeld(TCSichtbarkeitAnzeigefeld value) {
        this.sichtbarkeitAnzeigefeld = value;
    }

    /**
     * Ruft den Wert der verzoegerungManuellLoeschung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVerzoegerungManuellLoeschung }
     *     
     */
    public TCVerzoegerungManuellLoeschung getVerzoegerungManuellLoeschung() {
        return verzoegerungManuellLoeschung;
    }

    /**
     * Legt den Wert der verzoegerungManuellLoeschung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVerzoegerungManuellLoeschung }
     *     
     */
    public void setVerzoegerungManuellLoeschung(TCVerzoegerungManuellLoeschung value) {
        this.verzoegerungManuellLoeschung = value;
    }

    /**
     * Ruft den Wert der vormeldestart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVormeldestart }
     *     
     */
    public TCVormeldestart getVormeldestart() {
        return vormeldestart;
    }

    /**
     * Legt den Wert der vormeldestart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVormeldestart }
     *     
     */
    public void setVormeldestart(TCVormeldestart value) {
        this.vormeldestart = value;
    }

    /**
     * Ruft den Wert der znAnzeigefeldLoeschkriterium-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZNAnzeigefeldLoeschkriterium }
     *     
     */
    public TCZNAnzeigefeldLoeschkriterium getZNAnzeigefeldLoeschkriterium() {
        return znAnzeigefeldLoeschkriterium;
    }

    /**
     * Legt den Wert der znAnzeigefeldLoeschkriterium-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZNAnzeigefeldLoeschkriterium }
     *     
     */
    public void setZNAnzeigefeldLoeschkriterium(TCZNAnzeigefeldLoeschkriterium value) {
        this.znAnzeigefeldLoeschkriterium = value;
    }

    /**
     * Ruft den Wert der znFeldOhneAnzeige-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZNFeldOhneAnzeige }
     *     
     */
    public TCZNFeldOhneAnzeige getZNFeldOhneAnzeige() {
        return znFeldOhneAnzeige;
    }

    /**
     * Legt den Wert der znFeldOhneAnzeige-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZNFeldOhneAnzeige }
     *     
     */
    public void setZNFeldOhneAnzeige(TCZNFeldOhneAnzeige value) {
        this.znFeldOhneAnzeige = value;
    }

    /**
     * Ruft den Wert der zugvorbereitungsmeldung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZugvorbereitungsmeldung }
     *     
     */
    public TCZugvorbereitungsmeldung getZugvorbereitungsmeldung() {
        return zugvorbereitungsmeldung;
    }

    /**
     * Legt den Wert der zugvorbereitungsmeldung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZugvorbereitungsmeldung }
     *     
     */
    public void setZugvorbereitungsmeldung(TCZugvorbereitungsmeldung value) {
        this.zugvorbereitungsmeldung = value;
    }

}
