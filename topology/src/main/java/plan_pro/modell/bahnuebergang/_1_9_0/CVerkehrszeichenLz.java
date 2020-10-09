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
 * <p>Java-Klasse f�r CVerkehrszeichen_Lz complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CVerkehrszeichen_Lz">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Akustik_Fussgaenger" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCAkustik_Fussgaenger" minOccurs="0"/>
 *         &lt;element name="Kontrastblende" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCKontrastblende" minOccurs="0"/>
 *         &lt;element name="Optik_Durchmesser" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCOptik_Durchmesser"/>
 *         &lt;element name="Optik_Symbolmaske" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCOptik_Symbolmaske" minOccurs="0"/>
 *         &lt;element name="Schaltgruppe" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCSchaltgruppe" minOccurs="0"/>
 *         &lt;element name="Tragkopf_Verstellbar" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCTragkopf_Verstellbar" minOccurs="0"/>
 *         &lt;element name="Vorgeschaltet" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCVorgeschaltet" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CVerkehrszeichen_Lz", propOrder = {
    "akustikFussgaenger",
    "kontrastblende",
    "optikDurchmesser",
    "optikSymbolmaske",
    "schaltgruppe",
    "tragkopfVerstellbar",
    "vorgeschaltet"
})
public class CVerkehrszeichenLz {

    @XmlElement(name = "Akustik_Fussgaenger")
    protected TCAkustikFussgaenger akustikFussgaenger;
    @XmlElement(name = "Kontrastblende")
    protected TCKontrastblende kontrastblende;
    @XmlElement(name = "Optik_Durchmesser", required = true)
    protected TCOptikDurchmesser optikDurchmesser;
    @XmlElement(name = "Optik_Symbolmaske")
    protected TCOptikSymbolmaske optikSymbolmaske;
    @XmlElement(name = "Schaltgruppe")
    protected TCSchaltgruppe schaltgruppe;
    @XmlElement(name = "Tragkopf_Verstellbar")
    protected TCTragkopfVerstellbar tragkopfVerstellbar;
    @XmlElement(name = "Vorgeschaltet")
    protected TCVorgeschaltet vorgeschaltet;

    /**
     * Ruft den Wert der akustikFussgaenger-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAkustikFussgaenger }
     *     
     */
    public TCAkustikFussgaenger getAkustikFussgaenger() {
        return akustikFussgaenger;
    }

    /**
     * Legt den Wert der akustikFussgaenger-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAkustikFussgaenger }
     *     
     */
    public void setAkustikFussgaenger(TCAkustikFussgaenger value) {
        this.akustikFussgaenger = value;
    }

    /**
     * Ruft den Wert der kontrastblende-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKontrastblende }
     *     
     */
    public TCKontrastblende getKontrastblende() {
        return kontrastblende;
    }

    /**
     * Legt den Wert der kontrastblende-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKontrastblende }
     *     
     */
    public void setKontrastblende(TCKontrastblende value) {
        this.kontrastblende = value;
    }

    /**
     * Ruft den Wert der optikDurchmesser-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCOptikDurchmesser }
     *     
     */
    public TCOptikDurchmesser getOptikDurchmesser() {
        return optikDurchmesser;
    }

    /**
     * Legt den Wert der optikDurchmesser-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCOptikDurchmesser }
     *     
     */
    public void setOptikDurchmesser(TCOptikDurchmesser value) {
        this.optikDurchmesser = value;
    }

    /**
     * Ruft den Wert der optikSymbolmaske-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCOptikSymbolmaske }
     *     
     */
    public TCOptikSymbolmaske getOptikSymbolmaske() {
        return optikSymbolmaske;
    }

    /**
     * Legt den Wert der optikSymbolmaske-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCOptikSymbolmaske }
     *     
     */
    public void setOptikSymbolmaske(TCOptikSymbolmaske value) {
        this.optikSymbolmaske = value;
    }

    /**
     * Ruft den Wert der schaltgruppe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSchaltgruppe }
     *     
     */
    public TCSchaltgruppe getSchaltgruppe() {
        return schaltgruppe;
    }

    /**
     * Legt den Wert der schaltgruppe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSchaltgruppe }
     *     
     */
    public void setSchaltgruppe(TCSchaltgruppe value) {
        this.schaltgruppe = value;
    }

    /**
     * Ruft den Wert der tragkopfVerstellbar-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTragkopfVerstellbar }
     *     
     */
    public TCTragkopfVerstellbar getTragkopfVerstellbar() {
        return tragkopfVerstellbar;
    }

    /**
     * Legt den Wert der tragkopfVerstellbar-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTragkopfVerstellbar }
     *     
     */
    public void setTragkopfVerstellbar(TCTragkopfVerstellbar value) {
        this.tragkopfVerstellbar = value;
    }

    /**
     * Ruft den Wert der vorgeschaltet-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVorgeschaltet }
     *     
     */
    public TCVorgeschaltet getVorgeschaltet() {
        return vorgeschaltet;
    }

    /**
     * Legt den Wert der vorgeschaltet-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVorgeschaltet }
     *     
     */
    public void setVorgeschaltet(TCVorgeschaltet value) {
        this.vorgeschaltet = value;
    }

}
