//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.medien_und_trassen._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CKabel_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CKabel_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Ader_Reserve" type="{http://www.plan-pro.org/modell/Medien_und_Trassen/1.9.0.2}TCAder_Reserve"/>
 *         &lt;element name="Anzahl_Verseilelemente" type="{http://www.plan-pro.org/modell/Medien_und_Trassen/1.9.0.2}TCAnzahl_Verseilelemente"/>
 *         &lt;element name="Kabel_Art" type="{http://www.plan-pro.org/modell/Medien_und_Trassen/1.9.0.2}TCKabel_Art"/>
 *         &lt;element name="Kabel_Laenge" type="{http://www.plan-pro.org/modell/Medien_und_Trassen/1.9.0.2}TCKabel_Laenge"/>
 *         &lt;element name="Kabel_Typ" type="{http://www.plan-pro.org/modell/Medien_und_Trassen/1.9.0.2}TCKabel_Typ"/>
 *         &lt;element name="Verseilart" type="{http://www.plan-pro.org/modell/Medien_und_Trassen/1.9.0.2}TCVerseilart" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="Ader_Durchmesser" type="{http://www.plan-pro.org/modell/Medien_und_Trassen/1.9.0.2}TCAder_Durchmesser" minOccurs="0"/>
 *           &lt;element name="Ader_Querschnitt" type="{http://www.plan-pro.org/modell/Medien_und_Trassen/1.9.0.2}TCAder_Querschnitt" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CKabel_Allg", propOrder = {
    "aderReserve",
    "anzahlVerseilelemente",
    "kabelArt",
    "kabelLaenge",
    "kabelTyp",
    "verseilart",
    "aderDurchmesser",
    "aderQuerschnitt"
})
public class CKabelAllg {

    @XmlElement(name = "Ader_Reserve", required = true)
    protected TCAderReserve aderReserve;
    @XmlElement(name = "Anzahl_Verseilelemente", required = true)
    protected TCAnzahlVerseilelemente anzahlVerseilelemente;
    @XmlElement(name = "Kabel_Art", required = true)
    protected TCKabelArt kabelArt;
    @XmlElement(name = "Kabel_Laenge", required = true)
    protected TCKabelLaenge kabelLaenge;
    @XmlElement(name = "Kabel_Typ", required = true)
    protected TCKabelTyp kabelTyp;
    @XmlElement(name = "Verseilart")
    protected TCVerseilart verseilart;
    @XmlElement(name = "Ader_Durchmesser")
    protected TCAderDurchmesser aderDurchmesser;
    @XmlElement(name = "Ader_Querschnitt")
    protected TCAderQuerschnitt aderQuerschnitt;

    /**
     * Ruft den Wert der aderReserve-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAderReserve }
     *     
     */
    public TCAderReserve getAderReserve() {
        return aderReserve;
    }

    /**
     * Legt den Wert der aderReserve-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAderReserve }
     *     
     */
    public void setAderReserve(TCAderReserve value) {
        this.aderReserve = value;
    }

    /**
     * Ruft den Wert der anzahlVerseilelemente-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAnzahlVerseilelemente }
     *     
     */
    public TCAnzahlVerseilelemente getAnzahlVerseilelemente() {
        return anzahlVerseilelemente;
    }

    /**
     * Legt den Wert der anzahlVerseilelemente-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAnzahlVerseilelemente }
     *     
     */
    public void setAnzahlVerseilelemente(TCAnzahlVerseilelemente value) {
        this.anzahlVerseilelemente = value;
    }

    /**
     * Ruft den Wert der kabelArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKabelArt }
     *     
     */
    public TCKabelArt getKabelArt() {
        return kabelArt;
    }

    /**
     * Legt den Wert der kabelArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKabelArt }
     *     
     */
    public void setKabelArt(TCKabelArt value) {
        this.kabelArt = value;
    }

    /**
     * Ruft den Wert der kabelLaenge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKabelLaenge }
     *     
     */
    public TCKabelLaenge getKabelLaenge() {
        return kabelLaenge;
    }

    /**
     * Legt den Wert der kabelLaenge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKabelLaenge }
     *     
     */
    public void setKabelLaenge(TCKabelLaenge value) {
        this.kabelLaenge = value;
    }

    /**
     * Ruft den Wert der kabelTyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKabelTyp }
     *     
     */
    public TCKabelTyp getKabelTyp() {
        return kabelTyp;
    }

    /**
     * Legt den Wert der kabelTyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKabelTyp }
     *     
     */
    public void setKabelTyp(TCKabelTyp value) {
        this.kabelTyp = value;
    }

    /**
     * Ruft den Wert der verseilart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVerseilart }
     *     
     */
    public TCVerseilart getVerseilart() {
        return verseilart;
    }

    /**
     * Legt den Wert der verseilart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVerseilart }
     *     
     */
    public void setVerseilart(TCVerseilart value) {
        this.verseilart = value;
    }

    /**
     * Ruft den Wert der aderDurchmesser-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAderDurchmesser }
     *     
     */
    public TCAderDurchmesser getAderDurchmesser() {
        return aderDurchmesser;
    }

    /**
     * Legt den Wert der aderDurchmesser-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAderDurchmesser }
     *     
     */
    public void setAderDurchmesser(TCAderDurchmesser value) {
        this.aderDurchmesser = value;
    }

    /**
     * Ruft den Wert der aderQuerschnitt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAderQuerschnitt }
     *     
     */
    public TCAderQuerschnitt getAderQuerschnitt() {
        return aderQuerschnitt;
    }

    /**
     * Legt den Wert der aderQuerschnitt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAderQuerschnitt }
     *     
     */
    public void setAderQuerschnitt(TCAderQuerschnitt value) {
        this.aderQuerschnitt = value;
    }

}
