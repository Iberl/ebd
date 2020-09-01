//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.zugnummernmeldeanlage._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZN_Akustik_Anzeigefeld complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZN_Akustik_Anzeigefeld">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Akustikdauer_Anb_Ann" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCAkustikdauer_Anb_Ann"/>
 *           &lt;element name="Akustikdauer_Sonst" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCAkustikdauer_Sonst"/>
 *           &lt;element name="Akustikdauer_Voranz" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCAkustikdauer_Voranz"/>
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
@XmlType(name = "CZN_Akustik_Anzeigefeld", propOrder = {
    "akustikdauerAnbAnn",
    "akustikdauerSonst",
    "akustikdauerVoranz"
})
public class CZNAkustikAnzeigefeld {

    @XmlElement(name = "Akustikdauer_Anb_Ann")
    protected TCAkustikdauerAnbAnn akustikdauerAnbAnn;
    @XmlElement(name = "Akustikdauer_Sonst")
    protected TCAkustikdauerSonst akustikdauerSonst;
    @XmlElement(name = "Akustikdauer_Voranz")
    protected TCAkustikdauerVoranz akustikdauerVoranz;

    /**
     * Ruft den Wert der akustikdauerAnbAnn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAkustikdauerAnbAnn }
     *     
     */
    public TCAkustikdauerAnbAnn getAkustikdauerAnbAnn() {
        return akustikdauerAnbAnn;
    }

    /**
     * Legt den Wert der akustikdauerAnbAnn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAkustikdauerAnbAnn }
     *     
     */
    public void setAkustikdauerAnbAnn(TCAkustikdauerAnbAnn value) {
        this.akustikdauerAnbAnn = value;
    }

    /**
     * Ruft den Wert der akustikdauerSonst-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAkustikdauerSonst }
     *     
     */
    public TCAkustikdauerSonst getAkustikdauerSonst() {
        return akustikdauerSonst;
    }

    /**
     * Legt den Wert der akustikdauerSonst-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAkustikdauerSonst }
     *     
     */
    public void setAkustikdauerSonst(TCAkustikdauerSonst value) {
        this.akustikdauerSonst = value;
    }

    /**
     * Ruft den Wert der akustikdauerVoranz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAkustikdauerVoranz }
     *     
     */
    public TCAkustikdauerVoranz getAkustikdauerVoranz() {
        return akustikdauerVoranz;
    }

    /**
     * Legt den Wert der akustikdauerVoranz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAkustikdauerVoranz }
     *     
     */
    public void setAkustikdauerVoranz(TCAkustikdauerVoranz value) {
        this.akustikdauerVoranz = value;
    }

}
