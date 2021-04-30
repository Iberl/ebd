//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBUE_Anlage_Strasse_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Anlage_Strasse_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Baulast" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBaulast"/>
 *         &lt;element name="Fahrbahn_Befestigung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCFahrbahn_Befestigung"/>
 *         &lt;element name="Fahrbahn_Befestigung_Gleis" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCFahrbahn_Befestigung_Gleis"/>
 *         &lt;element name="Fahrbahn_Breite" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCFahrbahn_Breite"/>
 *         &lt;element name="Klassifizierung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCKlassifizierung"/>
 *         &lt;element name="Kreuzungswinkel" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCKreuzungswinkel"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Anlage_Strasse_Allg", propOrder = {
    "baulast",
    "fahrbahnBefestigung",
    "fahrbahnBefestigungGleis",
    "fahrbahnBreite",
    "klassifizierung",
    "kreuzungswinkel"
})
public class CBUEAnlageStrasseAllg {

    @XmlElement(name = "Baulast", required = true)
    protected TCBaulast baulast;
    @XmlElement(name = "Fahrbahn_Befestigung", required = true)
    protected TCFahrbahnBefestigung fahrbahnBefestigung;
    @XmlElement(name = "Fahrbahn_Befestigung_Gleis", required = true)
    protected TCFahrbahnBefestigungGleis fahrbahnBefestigungGleis;
    @XmlElement(name = "Fahrbahn_Breite", required = true)
    protected TCFahrbahnBreite fahrbahnBreite;
    @XmlElement(name = "Klassifizierung", required = true)
    protected TCKlassifizierung klassifizierung;
    @XmlElement(name = "Kreuzungswinkel", required = true)
    protected TCKreuzungswinkel kreuzungswinkel;

    /**
     * Ruft den Wert der baulast-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBaulast }
     *     
     */
    public TCBaulast getBaulast() {
        return baulast;
    }

    /**
     * Legt den Wert der baulast-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBaulast }
     *     
     */
    public void setBaulast(TCBaulast value) {
        this.baulast = value;
    }

    /**
     * Ruft den Wert der fahrbahnBefestigung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFahrbahnBefestigung }
     *     
     */
    public TCFahrbahnBefestigung getFahrbahnBefestigung() {
        return fahrbahnBefestigung;
    }

    /**
     * Legt den Wert der fahrbahnBefestigung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFahrbahnBefestigung }
     *     
     */
    public void setFahrbahnBefestigung(TCFahrbahnBefestigung value) {
        this.fahrbahnBefestigung = value;
    }

    /**
     * Ruft den Wert der fahrbahnBefestigungGleis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFahrbahnBefestigungGleis }
     *     
     */
    public TCFahrbahnBefestigungGleis getFahrbahnBefestigungGleis() {
        return fahrbahnBefestigungGleis;
    }

    /**
     * Legt den Wert der fahrbahnBefestigungGleis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFahrbahnBefestigungGleis }
     *     
     */
    public void setFahrbahnBefestigungGleis(TCFahrbahnBefestigungGleis value) {
        this.fahrbahnBefestigungGleis = value;
    }

    /**
     * Ruft den Wert der fahrbahnBreite-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFahrbahnBreite }
     *     
     */
    public TCFahrbahnBreite getFahrbahnBreite() {
        return fahrbahnBreite;
    }

    /**
     * Legt den Wert der fahrbahnBreite-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFahrbahnBreite }
     *     
     */
    public void setFahrbahnBreite(TCFahrbahnBreite value) {
        this.fahrbahnBreite = value;
    }

    /**
     * Ruft den Wert der klassifizierung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKlassifizierung }
     *     
     */
    public TCKlassifizierung getKlassifizierung() {
        return klassifizierung;
    }

    /**
     * Legt den Wert der klassifizierung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKlassifizierung }
     *     
     */
    public void setKlassifizierung(TCKlassifizierung value) {
        this.klassifizierung = value;
    }

    /**
     * Ruft den Wert der kreuzungswinkel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKreuzungswinkel }
     *     
     */
    public TCKreuzungswinkel getKreuzungswinkel() {
        return kreuzungswinkel;
    }

    /**
     * Legt den Wert der kreuzungswinkel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKreuzungswinkel }
     *     
     */
    public void setKreuzungswinkel(TCKreuzungswinkel value) {
        this.kreuzungswinkel = value;
    }

}
