//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.weichen_und_gleissperren._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Elektrischer_Antrieb_Anzahl" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}TCElektrischer_Antrieb_Anzahl"/>
 *         &lt;element name="Geschwindigkeit_L" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}TCGeschwindigkeit_L"/>
 *         &lt;element name="Geschwindigkeit_R" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}TCGeschwindigkeit_R"/>
 *         &lt;element name="Herzstueck_Antriebe" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}TCHerzstueck_Antriebe" minOccurs="0"/>
 *         &lt;element name="Kreuzungsgleis" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}TCKreuzungsgleis" minOccurs="0"/>
 *         &lt;element name="Radius_L" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}TCRadius_L" minOccurs="0"/>
 *         &lt;element name="Radius_R" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}TCRadius_R" minOccurs="0"/>
 *         &lt;element name="Weichensignal" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}TCWeichensignal"/>
 *         &lt;element name="Zungenpruefkontakt_Anzahl" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}TCZungenpruefkontakt_Anzahl"/>
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
    "geschwindigkeitL",
    "geschwindigkeitR",
    "herzstueckAntriebe",
    "kreuzungsgleis",
    "radiusL",
    "radiusR",
    "weichensignal",
    "zungenpruefkontaktAnzahl"
})
public class CZungenpaar {

    @XmlElement(name = "Elektrischer_Antrieb_Anzahl", required = true)
    protected TCElektrischerAntriebAnzahl elektrischerAntriebAnzahl;
    @XmlElement(name = "Geschwindigkeit_L", required = true)
    protected TCGeschwindigkeitL geschwindigkeitL;
    @XmlElement(name = "Geschwindigkeit_R", required = true)
    protected TCGeschwindigkeitR geschwindigkeitR;
    @XmlElement(name = "Herzstueck_Antriebe")
    protected TCHerzstueckAntriebe herzstueckAntriebe;
    @XmlElement(name = "Kreuzungsgleis")
    protected TCKreuzungsgleis kreuzungsgleis;
    @XmlElement(name = "Radius_L")
    protected TCRadiusL radiusL;
    @XmlElement(name = "Radius_R")
    protected TCRadiusR radiusR;
    @XmlElement(name = "Weichensignal", required = true)
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
     * Ruft den Wert der radiusL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRadiusL }
     *     
     */
    public TCRadiusL getRadiusL() {
        return radiusL;
    }

    /**
     * Legt den Wert der radiusL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRadiusL }
     *     
     */
    public void setRadiusL(TCRadiusL value) {
        this.radiusL = value;
    }

    /**
     * Ruft den Wert der radiusR-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRadiusR }
     *     
     */
    public TCRadiusR getRadiusR() {
        return radiusR;
    }

    /**
     * Legt den Wert der radiusR-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRadiusR }
     *     
     */
    public void setRadiusR(TCRadiusR value) {
        this.radiusR = value;
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
