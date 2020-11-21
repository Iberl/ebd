//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CLEU_Modul_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CLEU_Modul_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Hersteller" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCHersteller" minOccurs="0"/>
 *         &lt;element name="LEU_Modul_Art" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCLEU_Modul_Art" minOccurs="0"/>
 *         &lt;element name="LEU_Modul_Typ" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCLEU_Modul_Typ" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLEU_Modul_Allg", propOrder = {
    "hersteller",
    "leuModulArt",
    "leuModulTyp"
})
public class CLEUModulAllg {

    @XmlElement(name = "Hersteller")
    protected TCHersteller hersteller;
    @XmlElement(name = "LEU_Modul_Art")
    protected TCLEUModulArt leuModulArt;
    @XmlElement(name = "LEU_Modul_Typ")
    protected TCLEUModulTyp leuModulTyp;

    /**
     * Ruft den Wert der hersteller-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHersteller }
     *     
     */
    public TCHersteller getHersteller() {
        return hersteller;
    }

    /**
     * Legt den Wert der hersteller-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHersteller }
     *     
     */
    public void setHersteller(TCHersteller value) {
        this.hersteller = value;
    }

    /**
     * Ruft den Wert der leuModulArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLEUModulArt }
     *     
     */
    public TCLEUModulArt getLEUModulArt() {
        return leuModulArt;
    }

    /**
     * Legt den Wert der leuModulArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLEUModulArt }
     *     
     */
    public void setLEUModulArt(TCLEUModulArt value) {
        this.leuModulArt = value;
    }

    /**
     * Ruft den Wert der leuModulTyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLEUModulTyp }
     *     
     */
    public TCLEUModulTyp getLEUModulTyp() {
        return leuModulTyp;
    }

    /**
     * Legt den Wert der leuModulTyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLEUModulTyp }
     *     
     */
    public void setLEUModulTyp(TCLEUModulTyp value) {
        this.leuModulTyp = value;
    }

}
