//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.basisobjekte._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CAnhang_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CAnhang_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Anhang_Art" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}TCAnhang_Art"/>
 *         &lt;element name="Dateiname" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}TCDateiname"/>
 *         &lt;element name="Dateityp" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}TCDateityp"/>
 *         &lt;element name="Daten" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}TCDaten"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CAnhang_Allg", propOrder = {
    "anhangArt",
    "dateiname",
    "dateityp",
    "daten"
})
public class CAnhangAllg {

    @XmlElement(name = "Anhang_Art", required = true)
    protected TCAnhangArt anhangArt;
    @XmlElement(name = "Dateiname", required = true)
    protected TCDateiname dateiname;
    @XmlElement(name = "Dateityp", required = true)
    protected TCDateityp dateityp;
    @XmlElement(name = "Daten", required = true)
    protected TCDaten daten;

    /**
     * Ruft den Wert der anhangArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAnhangArt }
     *     
     */
    public TCAnhangArt getAnhangArt() {
        return anhangArt;
    }

    /**
     * Legt den Wert der anhangArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAnhangArt }
     *     
     */
    public void setAnhangArt(TCAnhangArt value) {
        this.anhangArt = value;
    }

    /**
     * Ruft den Wert der dateiname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDateiname }
     *     
     */
    public TCDateiname getDateiname() {
        return dateiname;
    }

    /**
     * Legt den Wert der dateiname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDateiname }
     *     
     */
    public void setDateiname(TCDateiname value) {
        this.dateiname = value;
    }

    /**
     * Ruft den Wert der dateityp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDateityp }
     *     
     */
    public TCDateityp getDateityp() {
        return dateityp;
    }

    /**
     * Legt den Wert der dateityp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDateityp }
     *     
     */
    public void setDateityp(TCDateityp value) {
        this.dateityp = value;
    }

    /**
     * Ruft den Wert der daten-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDaten }
     *     
     */
    public TCDaten getDaten() {
        return daten;
    }

    /**
     * Legt den Wert der daten-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDaten }
     *     
     */
    public void setDaten(TCDaten value) {
        this.daten = value;
    }

}
