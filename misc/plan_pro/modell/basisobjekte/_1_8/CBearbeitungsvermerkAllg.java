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
 * <p>Java-Klasse f�r CBearbeitungsvermerk_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBearbeitungsvermerk_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bearbeitungsvermerk_Kennung" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}TCBearbeitungsvermerk_Kennung" minOccurs="0"/>
 *         &lt;element name="Bearbeitungsvermerk_Rolle" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}TCBearbeitungsvermerk_Rolle"/>
 *         &lt;element name="Kommentar" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}TCKommentar"/>
 *         &lt;element name="Kurztext" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}TCKurztext" minOccurs="0"/>
 *         &lt;element name="Zeit_Bearbeitungsvermerk" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}TCZeit_Bearbeitungsvermerk"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBearbeitungsvermerk_Allg", propOrder = {
    "bearbeitungsvermerkKennung",
    "bearbeitungsvermerkRolle",
    "kommentar",
    "kurztext",
    "zeitBearbeitungsvermerk"
})
public class CBearbeitungsvermerkAllg {

    @XmlElement(name = "Bearbeitungsvermerk_Kennung")
    protected TCBearbeitungsvermerkKennung bearbeitungsvermerkKennung;
    @XmlElement(name = "Bearbeitungsvermerk_Rolle", required = true)
    protected TCBearbeitungsvermerkRolle bearbeitungsvermerkRolle;
    @XmlElement(name = "Kommentar", required = true)
    protected TCKommentar kommentar;
    @XmlElement(name = "Kurztext")
    protected TCKurztext kurztext;
    @XmlElement(name = "Zeit_Bearbeitungsvermerk", required = true)
    protected TCZeitBearbeitungsvermerk zeitBearbeitungsvermerk;

    /**
     * Ruft den Wert der bearbeitungsvermerkKennung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBearbeitungsvermerkKennung }
     *     
     */
    public TCBearbeitungsvermerkKennung getBearbeitungsvermerkKennung() {
        return bearbeitungsvermerkKennung;
    }

    /**
     * Legt den Wert der bearbeitungsvermerkKennung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBearbeitungsvermerkKennung }
     *     
     */
    public void setBearbeitungsvermerkKennung(TCBearbeitungsvermerkKennung value) {
        this.bearbeitungsvermerkKennung = value;
    }

    /**
     * Ruft den Wert der bearbeitungsvermerkRolle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBearbeitungsvermerkRolle }
     *     
     */
    public TCBearbeitungsvermerkRolle getBearbeitungsvermerkRolle() {
        return bearbeitungsvermerkRolle;
    }

    /**
     * Legt den Wert der bearbeitungsvermerkRolle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBearbeitungsvermerkRolle }
     *     
     */
    public void setBearbeitungsvermerkRolle(TCBearbeitungsvermerkRolle value) {
        this.bearbeitungsvermerkRolle = value;
    }

    /**
     * Ruft den Wert der kommentar-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKommentar }
     *     
     */
    public TCKommentar getKommentar() {
        return kommentar;
    }

    /**
     * Legt den Wert der kommentar-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKommentar }
     *     
     */
    public void setKommentar(TCKommentar value) {
        this.kommentar = value;
    }

    /**
     * Ruft den Wert der kurztext-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKurztext }
     *     
     */
    public TCKurztext getKurztext() {
        return kurztext;
    }

    /**
     * Legt den Wert der kurztext-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKurztext }
     *     
     */
    public void setKurztext(TCKurztext value) {
        this.kurztext = value;
    }

    /**
     * Ruft den Wert der zeitBearbeitungsvermerk-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZeitBearbeitungsvermerk }
     *     
     */
    public TCZeitBearbeitungsvermerk getZeitBearbeitungsvermerk() {
        return zeitBearbeitungsvermerk;
    }

    /**
     * Legt den Wert der zeitBearbeitungsvermerk-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZeitBearbeitungsvermerk }
     *     
     */
    public void setZeitBearbeitungsvermerk(TCZeitBearbeitungsvermerk value) {
        this.zeitBearbeitungsvermerk = value;
    }

}
