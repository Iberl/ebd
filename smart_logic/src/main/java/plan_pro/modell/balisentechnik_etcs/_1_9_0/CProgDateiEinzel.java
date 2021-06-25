//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basistypen._1_9_0.CEigenschaftenDatei;
import plan_pro.modell.verweise._1_9_0.TCIDBinaerdateiOhneProxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CProg_Datei_Einzel complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CProg_Datei_Einzel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Anzeigetext" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCAnzeigetext" minOccurs="0"/>
 *         &lt;element name="Eigenschaften_Binaerdatei" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}CEigenschaften_Datei"/>
 *         &lt;element name="Einzeldatei_Art" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCEinzeldatei_Art"/>
 *         &lt;element name="ID_Binaerdatei" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Binaerdatei_ohne_Proxy"/>
 *         &lt;element name="Konfigurationskennung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCKonfigurationskennung" minOccurs="0"/>
 *         &lt;element name="Verwendung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCVerwendung" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CProg_Datei_Einzel", propOrder = {
    "anzeigetext",
    "eigenschaftenBinaerdatei",
    "einzeldateiArt",
    "idBinaerdatei",
    "konfigurationskennung",
    "verwendung"
})
public class CProgDateiEinzel {

    @XmlElement(name = "Anzeigetext")
    protected TCAnzeigetext anzeigetext;
    @XmlElement(name = "Eigenschaften_Binaerdatei", required = true)
    protected CEigenschaftenDatei eigenschaftenBinaerdatei;
    @XmlElement(name = "Einzeldatei_Art", required = true)
    protected TCEinzeldateiArt einzeldateiArt;
    @XmlElement(name = "ID_Binaerdatei", required = true)
    protected TCIDBinaerdateiOhneProxy idBinaerdatei;
    @XmlElement(name = "Konfigurationskennung")
    protected TCKonfigurationskennung konfigurationskennung;
    @XmlElement(name = "Verwendung")
    protected TCVerwendung verwendung;

    /**
     * Ruft den Wert der anzeigetext-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAnzeigetext }
     *     
     */
    public TCAnzeigetext getAnzeigetext() {
        return anzeigetext;
    }

    /**
     * Legt den Wert der anzeigetext-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAnzeigetext }
     *     
     */
    public void setAnzeigetext(TCAnzeigetext value) {
        this.anzeigetext = value;
    }

    /**
     * Ruft den Wert der eigenschaftenBinaerdatei-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CEigenschaftenDatei }
     *     
     */
    public CEigenschaftenDatei getEigenschaftenBinaerdatei() {
        return eigenschaftenBinaerdatei;
    }

    /**
     * Legt den Wert der eigenschaftenBinaerdatei-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CEigenschaftenDatei }
     *     
     */
    public void setEigenschaftenBinaerdatei(CEigenschaftenDatei value) {
        this.eigenschaftenBinaerdatei = value;
    }

    /**
     * Ruft den Wert der einzeldateiArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEinzeldateiArt }
     *     
     */
    public TCEinzeldateiArt getEinzeldateiArt() {
        return einzeldateiArt;
    }

    /**
     * Legt den Wert der einzeldateiArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEinzeldateiArt }
     *     
     */
    public void setEinzeldateiArt(TCEinzeldateiArt value) {
        this.einzeldateiArt = value;
    }

    /**
     * Ruft den Wert der idBinaerdatei-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBinaerdateiOhneProxy }
     *     
     */
    public TCIDBinaerdateiOhneProxy getIDBinaerdatei() {
        return idBinaerdatei;
    }

    /**
     * Legt den Wert der idBinaerdatei-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBinaerdateiOhneProxy }
     *     
     */
    public void setIDBinaerdatei(TCIDBinaerdateiOhneProxy value) {
        this.idBinaerdatei = value;
    }

    /**
     * Ruft den Wert der konfigurationskennung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKonfigurationskennung }
     *     
     */
    public TCKonfigurationskennung getKonfigurationskennung() {
        return konfigurationskennung;
    }

    /**
     * Legt den Wert der konfigurationskennung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKonfigurationskennung }
     *     
     */
    public void setKonfigurationskennung(TCKonfigurationskennung value) {
        this.konfigurationskennung = value;
    }

    /**
     * Ruft den Wert der verwendung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVerwendung }
     *     
     */
    public TCVerwendung getVerwendung() {
        return verwendung;
    }

    /**
     * Legt den Wert der verwendung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVerwendung }
     *     
     */
    public void setVerwendung(TCVerwendung value) {
        this.verwendung = value;
    }

}
