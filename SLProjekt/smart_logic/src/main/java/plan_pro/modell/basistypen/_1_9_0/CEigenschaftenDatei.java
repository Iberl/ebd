//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basistypen._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Basisattributgruppe zur Zuordnung von Metadaten zu einer Datei.
 * 
 * 
 * <p>Java-Klasse f�r CEigenschaften_Datei complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CEigenschaften_Datei">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Datum_Auslieferung" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}TCDatum_Auslieferung"/>
 *         &lt;element name="Pruefsumme" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}TCPruefsumme"/>
 *         &lt;element name="Pruefsumme_Art" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}TCPruefsumme_Art"/>
 *         &lt;element name="Version_Auslieferung" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}TCVersion_Auslieferung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CEigenschaften_Datei", propOrder = {
    "datumAuslieferung",
    "pruefsumme",
    "pruefsummeArt",
    "versionAuslieferung"
})
public class CEigenschaftenDatei {

    @XmlElement(name = "Datum_Auslieferung", required = true)
    protected TCDatumAuslieferung datumAuslieferung;
    @XmlElement(name = "Pruefsumme", required = true)
    protected TCPruefsumme pruefsumme;
    @XmlElement(name = "Pruefsumme_Art", required = true)
    protected TCPruefsummeArt pruefsummeArt;
    @XmlElement(name = "Version_Auslieferung", required = true)
    protected TCVersionAuslieferung versionAuslieferung;

    /**
     * Ruft den Wert der datumAuslieferung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDatumAuslieferung }
     *     
     */
    public TCDatumAuslieferung getDatumAuslieferung() {
        return datumAuslieferung;
    }

    /**
     * Legt den Wert der datumAuslieferung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDatumAuslieferung }
     *     
     */
    public void setDatumAuslieferung(TCDatumAuslieferung value) {
        this.datumAuslieferung = value;
    }

    /**
     * Ruft den Wert der pruefsumme-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPruefsumme }
     *     
     */
    public TCPruefsumme getPruefsumme() {
        return pruefsumme;
    }

    /**
     * Legt den Wert der pruefsumme-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPruefsumme }
     *     
     */
    public void setPruefsumme(TCPruefsumme value) {
        this.pruefsumme = value;
    }

    /**
     * Ruft den Wert der pruefsummeArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPruefsummeArt }
     *     
     */
    public TCPruefsummeArt getPruefsummeArt() {
        return pruefsummeArt;
    }

    /**
     * Legt den Wert der pruefsummeArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPruefsummeArt }
     *     
     */
    public void setPruefsummeArt(TCPruefsummeArt value) {
        this.pruefsummeArt = value;
    }

    /**
     * Ruft den Wert der versionAuslieferung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVersionAuslieferung }
     *     
     */
    public TCVersionAuslieferung getVersionAuslieferung() {
        return versionAuslieferung;
    }

    /**
     * Legt den Wert der versionAuslieferung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVersionAuslieferung }
     *     
     */
    public void setVersionAuslieferung(TCVersionAuslieferung value) {
        this.versionAuslieferung = value;
    }

}
