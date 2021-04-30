//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.weichen_und_gleissperren._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZungenpaar complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZungenpaar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Elektrischer_Antrieb_Anzahl" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCElektrischer_Antrieb_Anzahl"/>
 *         &lt;element name="Elektrischer_Antrieb_Lage" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCElektrischer_Antrieb_Lage" minOccurs="0"/>
 *         &lt;element name="Geschwindigkeit_L" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCGeschwindigkeit_L"/>
 *         &lt;element name="Geschwindigkeit_R" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCGeschwindigkeit_R"/>
 *         &lt;element name="Herzstueck_Antriebe" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCHerzstueck_Antriebe" minOccurs="0"/>
 *         &lt;element name="Kreuzungsgleis" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCKreuzungsgleis" minOccurs="0"/>
 *         &lt;element name="Weichensignal" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCWeichensignal" minOccurs="0"/>
 *         &lt;element name="Zungenpruefkontakt_Anzahl" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCZungenpruefkontakt_Anzahl"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZungenpaar", propOrder = {
    "elektrischerAntriebAnzahl",
    "elektrischerAntriebLage",
    "geschwindigkeitL",
    "geschwindigkeitR",
    "herzstueckAntriebe",
    "kreuzungsgleis",
    "weichensignal",
    "zungenpruefkontaktAnzahl"
})
public class CZungenpaar {

    @XmlElement(name = "Elektrischer_Antrieb_Anzahl", required = true)
    protected TCElektrischerAntriebAnzahl elektrischerAntriebAnzahl;
    @XmlElement(name = "Elektrischer_Antrieb_Lage")
    protected TCElektrischerAntriebLage elektrischerAntriebLage;
    @XmlElement(name = "Geschwindigkeit_L", required = true)
    protected TCGeschwindigkeitL geschwindigkeitL;
    @XmlElement(name = "Geschwindigkeit_R", required = true)
    protected TCGeschwindigkeitR geschwindigkeitR;
    @XmlElement(name = "Herzstueck_Antriebe")
    protected TCHerzstueckAntriebe herzstueckAntriebe;
    @XmlElement(name = "Kreuzungsgleis")
    protected TCKreuzungsgleis kreuzungsgleis;
    @XmlElement(name = "Weichensignal")
    protected TCWeichensignal weichensignal;
    @XmlElement(name = "Zungenpruefkontakt_Anzahl", required = true)
    protected TCZungenpruefkontaktAnzahl zungenpruefkontaktAnzahl;

    /**
     * Ruft den Wert der elektrischerAntriebAnzahl-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCElektrischerAntriebAnzahl }
     *     
     */
    public TCElektrischerAntriebAnzahl getElektrischerAntriebAnzahl() {
        return elektrischerAntriebAnzahl;
    }

    /**
     * Legt den Wert der elektrischerAntriebAnzahl-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCElektrischerAntriebAnzahl }
     *     
     */
    public void setElektrischerAntriebAnzahl(TCElektrischerAntriebAnzahl value) {
        this.elektrischerAntriebAnzahl = value;
    }

    /**
     * Ruft den Wert der elektrischerAntriebLage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCElektrischerAntriebLage }
     *     
     */
    public TCElektrischerAntriebLage getElektrischerAntriebLage() {
        return elektrischerAntriebLage;
    }

    /**
     * Legt den Wert der elektrischerAntriebLage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCElektrischerAntriebLage }
     *     
     */
    public void setElektrischerAntriebLage(TCElektrischerAntriebLage value) {
        this.elektrischerAntriebLage = value;
    }

    /**
     * Ruft den Wert der geschwindigkeitL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGeschwindigkeitL }
     *     
     */
    public TCGeschwindigkeitL getGeschwindigkeitL() {
        return geschwindigkeitL;
    }

    /**
     * Legt den Wert der geschwindigkeitL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGeschwindigkeitL }
     *     
     */
    public void setGeschwindigkeitL(TCGeschwindigkeitL value) {
        this.geschwindigkeitL = value;
    }

    /**
     * Ruft den Wert der geschwindigkeitR-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGeschwindigkeitR }
     *     
     */
    public TCGeschwindigkeitR getGeschwindigkeitR() {
        return geschwindigkeitR;
    }

    /**
     * Legt den Wert der geschwindigkeitR-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGeschwindigkeitR }
     *     
     */
    public void setGeschwindigkeitR(TCGeschwindigkeitR value) {
        this.geschwindigkeitR = value;
    }

    /**
     * Ruft den Wert der herzstueckAntriebe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHerzstueckAntriebe }
     *     
     */
    public TCHerzstueckAntriebe getHerzstueckAntriebe() {
        return herzstueckAntriebe;
    }

    /**
     * Legt den Wert der herzstueckAntriebe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHerzstueckAntriebe }
     *     
     */
    public void setHerzstueckAntriebe(TCHerzstueckAntriebe value) {
        this.herzstueckAntriebe = value;
    }

    /**
     * Ruft den Wert der kreuzungsgleis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKreuzungsgleis }
     *     
     */
    public TCKreuzungsgleis getKreuzungsgleis() {
        return kreuzungsgleis;
    }

    /**
     * Legt den Wert der kreuzungsgleis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKreuzungsgleis }
     *     
     */
    public void setKreuzungsgleis(TCKreuzungsgleis value) {
        this.kreuzungsgleis = value;
    }

    /**
     * Ruft den Wert der weichensignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWeichensignal }
     *     
     */
    public TCWeichensignal getWeichensignal() {
        return weichensignal;
    }

    /**
     * Legt den Wert der weichensignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWeichensignal }
     *     
     */
    public void setWeichensignal(TCWeichensignal value) {
        this.weichensignal = value;
    }

    /**
     * Ruft den Wert der zungenpruefkontaktAnzahl-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZungenpruefkontaktAnzahl }
     *     
     */
    public TCZungenpruefkontaktAnzahl getZungenpruefkontaktAnzahl() {
        return zungenpruefkontaktAnzahl;
    }

    /**
     * Legt den Wert der zungenpruefkontaktAnzahl-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZungenpruefkontaktAnzahl }
     *     
     */
    public void setZungenpruefkontaktAnzahl(TCZungenpruefkontaktAnzahl value) {
        this.zungenpruefkontaktAnzahl = value;
    }

}
