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
 * <p>Java-Klasse f�r CBUE_Einschaltung_Hp complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Einschaltung_Hp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Einschaltverz_Errechnet" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCEinschaltverz_Errechnet"/>
 *         &lt;element name="Einschaltverz_Gewaehlt" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCEinschaltverz_Gewaehlt"/>
 *         &lt;element name="Kurzzugschaltung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCKurzzugschaltung" minOccurs="0"/>
 *         &lt;element name="Signalverz_Errechnet" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCSignalverz_Errechnet" minOccurs="0"/>
 *         &lt;element name="Signalverz_Gewaehlt" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCSignalverz_Gewaehlt" minOccurs="0"/>
 *         &lt;element name="Teilvorgabezeit" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCTeilvorgabezeit" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Einschaltung_Hp", propOrder = {
    "einschaltverzErrechnet",
    "einschaltverzGewaehlt",
    "kurzzugschaltung",
    "signalverzErrechnet",
    "signalverzGewaehlt",
    "teilvorgabezeit"
})
public class CBUEEinschaltungHp {

    @XmlElement(name = "Einschaltverz_Errechnet", required = true)
    protected TCEinschaltverzErrechnet einschaltverzErrechnet;
    @XmlElement(name = "Einschaltverz_Gewaehlt", required = true)
    protected TCEinschaltverzGewaehlt einschaltverzGewaehlt;
    @XmlElement(name = "Kurzzugschaltung")
    protected TCKurzzugschaltung kurzzugschaltung;
    @XmlElement(name = "Signalverz_Errechnet")
    protected TCSignalverzErrechnet signalverzErrechnet;
    @XmlElement(name = "Signalverz_Gewaehlt")
    protected TCSignalverzGewaehlt signalverzGewaehlt;
    @XmlElement(name = "Teilvorgabezeit")
    protected TCTeilvorgabezeit teilvorgabezeit;

    /**
     * Ruft den Wert der einschaltverzErrechnet-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEinschaltverzErrechnet }
     *     
     */
    public TCEinschaltverzErrechnet getEinschaltverzErrechnet() {
        return einschaltverzErrechnet;
    }

    /**
     * Legt den Wert der einschaltverzErrechnet-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEinschaltverzErrechnet }
     *     
     */
    public void setEinschaltverzErrechnet(TCEinschaltverzErrechnet value) {
        this.einschaltverzErrechnet = value;
    }

    /**
     * Ruft den Wert der einschaltverzGewaehlt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEinschaltverzGewaehlt }
     *     
     */
    public TCEinschaltverzGewaehlt getEinschaltverzGewaehlt() {
        return einschaltverzGewaehlt;
    }

    /**
     * Legt den Wert der einschaltverzGewaehlt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEinschaltverzGewaehlt }
     *     
     */
    public void setEinschaltverzGewaehlt(TCEinschaltverzGewaehlt value) {
        this.einschaltverzGewaehlt = value;
    }

    /**
     * Ruft den Wert der kurzzugschaltung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKurzzugschaltung }
     *     
     */
    public TCKurzzugschaltung getKurzzugschaltung() {
        return kurzzugschaltung;
    }

    /**
     * Legt den Wert der kurzzugschaltung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKurzzugschaltung }
     *     
     */
    public void setKurzzugschaltung(TCKurzzugschaltung value) {
        this.kurzzugschaltung = value;
    }

    /**
     * Ruft den Wert der signalverzErrechnet-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSignalverzErrechnet }
     *     
     */
    public TCSignalverzErrechnet getSignalverzErrechnet() {
        return signalverzErrechnet;
    }

    /**
     * Legt den Wert der signalverzErrechnet-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSignalverzErrechnet }
     *     
     */
    public void setSignalverzErrechnet(TCSignalverzErrechnet value) {
        this.signalverzErrechnet = value;
    }

    /**
     * Ruft den Wert der signalverzGewaehlt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSignalverzGewaehlt }
     *     
     */
    public TCSignalverzGewaehlt getSignalverzGewaehlt() {
        return signalverzGewaehlt;
    }

    /**
     * Legt den Wert der signalverzGewaehlt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSignalverzGewaehlt }
     *     
     */
    public void setSignalverzGewaehlt(TCSignalverzGewaehlt value) {
        this.signalverzGewaehlt = value;
    }

    /**
     * Ruft den Wert der teilvorgabezeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTeilvorgabezeit }
     *     
     */
    public TCTeilvorgabezeit getTeilvorgabezeit() {
        return teilvorgabezeit;
    }

    /**
     * Legt den Wert der teilvorgabezeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTeilvorgabezeit }
     *     
     */
    public void setTeilvorgabezeit(TCTeilvorgabezeit value) {
        this.teilvorgabezeit = value;
    }

}
