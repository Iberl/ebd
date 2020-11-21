//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ortung._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZugeinwirkung_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZugeinwirkung_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Zugeinwirkung_Art" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCZugeinwirkung_Art"/>
 *         &lt;element name="Zugeinwirkung_Typ" type="{http://www.plan-pro.org/modell/Ortung/1.9.0.2}TCZugeinwirkung_Typ" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZugeinwirkung_Allg", propOrder = {
    "zugeinwirkungArt",
    "zugeinwirkungTyp"
})
public class CZugeinwirkungAllg {

    @XmlElement(name = "Zugeinwirkung_Art", required = true)
    protected TCZugeinwirkungArt zugeinwirkungArt;
    @XmlElement(name = "Zugeinwirkung_Typ")
    protected TCZugeinwirkungTyp zugeinwirkungTyp;

    /**
     * Ruft den Wert der zugeinwirkungArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZugeinwirkungArt }
     *     
     */
    public TCZugeinwirkungArt getZugeinwirkungArt() {
        return zugeinwirkungArt;
    }

    /**
     * Legt den Wert der zugeinwirkungArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZugeinwirkungArt }
     *     
     */
    public void setZugeinwirkungArt(TCZugeinwirkungArt value) {
        this.zugeinwirkungArt = value;
    }

    /**
     * Ruft den Wert der zugeinwirkungTyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZugeinwirkungTyp }
     *     
     */
    public TCZugeinwirkungTyp getZugeinwirkungTyp() {
        return zugeinwirkungTyp;
    }

    /**
     * Legt den Wert der zugeinwirkungTyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZugeinwirkungTyp }
     *     
     */
    public void setZugeinwirkungTyp(TCZugeinwirkungTyp value) {
        this.zugeinwirkungTyp = value;
    }

}
