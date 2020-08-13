//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.nahbedienbereich._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CNB_Bedien_Anzeige_Funktionen complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CNB_Bedien_Anzeige_Funktionen">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Taste_ANF" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}TCTaste_ANF" minOccurs="0"/>
 *         &lt;element name="Taste_FGT" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}TCTaste_FGT" minOccurs="0"/>
 *         &lt;element name="Taste_WGT" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}TCTaste_WGT" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CNB_Bedien_Anzeige_Funktionen", propOrder = {
    "tasteANF",
    "tasteFGT",
    "tasteWGT"
})
public class CNBBedienAnzeigeFunktionen {

    @XmlElement(name = "Taste_ANF")
    protected TCTasteANF tasteANF;
    @XmlElement(name = "Taste_FGT")
    protected TCTasteFGT tasteFGT;
    @XmlElement(name = "Taste_WGT")
    protected TCTasteWGT tasteWGT;

    /**
     * Ruft den Wert der tasteANF-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTasteANF }
     *     
     */
    public TCTasteANF getTasteANF() {
        return tasteANF;
    }

    /**
     * Legt den Wert der tasteANF-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTasteANF }
     *     
     */
    public void setTasteANF(TCTasteANF value) {
        this.tasteANF = value;
    }

    /**
     * Ruft den Wert der tasteFGT-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTasteFGT }
     *     
     */
    public TCTasteFGT getTasteFGT() {
        return tasteFGT;
    }

    /**
     * Legt den Wert der tasteFGT-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTasteFGT }
     *     
     */
    public void setTasteFGT(TCTasteFGT value) {
        this.tasteFGT = value;
    }

    /**
     * Ruft den Wert der tasteWGT-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTasteWGT }
     *     
     */
    public TCTasteWGT getTasteWGT() {
        return tasteWGT;
    }

    /**
     * Legt den Wert der tasteWGT-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTasteWGT }
     *     
     */
    public void setTasteWGT(TCTasteWGT value) {
        this.tasteWGT = value;
    }

}
