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
 * <p>Java-Klasse f�r CDatenpunkt_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CDatenpunkt_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Anwendungssystem" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCAnwendungssystem"/>
 *         &lt;element name="Ausrichtung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCAusrichtung"/>
 *         &lt;element name="Datenpunkt_Beschreibung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDatenpunkt_Beschreibung" minOccurs="0"/>
 *         &lt;element name="Datenpunkt_Laenge" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDatenpunkt_Laenge"/>
 *         &lt;element name="Sonstige_Standortangabe" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCSonstige_Standortangabe" minOccurs="0"/>
 *         &lt;element name="Standortangabe_Balisenschild" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCStandortangabe_Balisenschild"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CDatenpunkt_Allg", propOrder = {
    "anwendungssystem",
    "ausrichtung",
    "datenpunktBeschreibung",
    "datenpunktLaenge",
    "sonstigeStandortangabe",
    "standortangabeBalisenschild"
})
public class CDatenpunktAllg {

    @XmlElement(name = "Anwendungssystem", required = true)
    protected TCAnwendungssystem anwendungssystem;
    @XmlElement(name = "Ausrichtung", required = true)
    protected TCAusrichtung ausrichtung;
    @XmlElement(name = "Datenpunkt_Beschreibung")
    protected TCDatenpunktBeschreibung datenpunktBeschreibung;
    @XmlElement(name = "Datenpunkt_Laenge", required = true)
    protected TCDatenpunktLaenge datenpunktLaenge;
    @XmlElement(name = "Sonstige_Standortangabe")
    protected TCSonstigeStandortangabe sonstigeStandortangabe;
    @XmlElement(name = "Standortangabe_Balisenschild", required = true)
    protected TCStandortangabeBalisenschild standortangabeBalisenschild;

    /**
     * Ruft den Wert der anwendungssystem-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAnwendungssystem }
     *     
     */
    public TCAnwendungssystem getAnwendungssystem() {
        return anwendungssystem;
    }

    /**
     * Legt den Wert der anwendungssystem-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAnwendungssystem }
     *     
     */
    public void setAnwendungssystem(TCAnwendungssystem value) {
        this.anwendungssystem = value;
    }

    /**
     * Ruft den Wert der ausrichtung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAusrichtung }
     *     
     */
    public TCAusrichtung getAusrichtung() {
        return ausrichtung;
    }

    /**
     * Legt den Wert der ausrichtung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAusrichtung }
     *     
     */
    public void setAusrichtung(TCAusrichtung value) {
        this.ausrichtung = value;
    }

    /**
     * Ruft den Wert der datenpunktBeschreibung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDatenpunktBeschreibung }
     *     
     */
    public TCDatenpunktBeschreibung getDatenpunktBeschreibung() {
        return datenpunktBeschreibung;
    }

    /**
     * Legt den Wert der datenpunktBeschreibung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDatenpunktBeschreibung }
     *     
     */
    public void setDatenpunktBeschreibung(TCDatenpunktBeschreibung value) {
        this.datenpunktBeschreibung = value;
    }

    /**
     * Ruft den Wert der datenpunktLaenge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDatenpunktLaenge }
     *     
     */
    public TCDatenpunktLaenge getDatenpunktLaenge() {
        return datenpunktLaenge;
    }

    /**
     * Legt den Wert der datenpunktLaenge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDatenpunktLaenge }
     *     
     */
    public void setDatenpunktLaenge(TCDatenpunktLaenge value) {
        this.datenpunktLaenge = value;
    }

    /**
     * Ruft den Wert der sonstigeStandortangabe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSonstigeStandortangabe }
     *     
     */
    public TCSonstigeStandortangabe getSonstigeStandortangabe() {
        return sonstigeStandortangabe;
    }

    /**
     * Legt den Wert der sonstigeStandortangabe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSonstigeStandortangabe }
     *     
     */
    public void setSonstigeStandortangabe(TCSonstigeStandortangabe value) {
        this.sonstigeStandortangabe = value;
    }

    /**
     * Ruft den Wert der standortangabeBalisenschild-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCStandortangabeBalisenschild }
     *     
     */
    public TCStandortangabeBalisenschild getStandortangabeBalisenschild() {
        return standortangabeBalisenschild;
    }

    /**
     * Legt den Wert der standortangabeBalisenschild-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCStandortangabeBalisenschild }
     *     
     */
    public void setStandortangabeBalisenschild(TCStandortangabeBalisenschild value) {
        this.standortangabeBalisenschild = value;
    }

}
