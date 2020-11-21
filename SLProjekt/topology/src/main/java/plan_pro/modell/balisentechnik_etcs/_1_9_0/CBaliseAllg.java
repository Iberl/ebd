//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBalise_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBalise_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Anordnung_Im_DP" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCAnordnung_Im_DP"/>
 *         &lt;element name="Fabrikat" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCFabrikat" minOccurs="0"/>
 *         &lt;element name="Hersteller" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCHersteller" minOccurs="0"/>
 *         &lt;element name="Hinweis_Balisenbefestigung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCHinweis_Balisenbefestigung" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBalise_Allg", propOrder = {
    "anordnungImDP",
    "fabrikat",
    "hersteller",
    "hinweisBalisenbefestigung"
})
public class CBaliseAllg {

    @XmlElement(name = "Anordnung_Im_DP", required = true)
    protected TCAnordnungImDP anordnungImDP;
    @XmlElement(name = "Fabrikat")
    protected TCFabrikat fabrikat;
    @XmlElement(name = "Hersteller")
    protected TCHersteller hersteller;
    @XmlElement(name = "Hinweis_Balisenbefestigung")
    protected TCHinweisBalisenbefestigung hinweisBalisenbefestigung;

    /**
     * Ruft den Wert der anordnungImDP-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAnordnungImDP }
     *     
     */
    public TCAnordnungImDP getAnordnungImDP() {
        return anordnungImDP;
    }

    /**
     * Legt den Wert der anordnungImDP-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAnordnungImDP }
     *     
     */
    public void setAnordnungImDP(TCAnordnungImDP value) {
        this.anordnungImDP = value;
    }

    /**
     * Ruft den Wert der fabrikat-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFabrikat }
     *     
     */
    public TCFabrikat getFabrikat() {
        return fabrikat;
    }

    /**
     * Legt den Wert der fabrikat-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFabrikat }
     *     
     */
    public void setFabrikat(TCFabrikat value) {
        this.fabrikat = value;
    }

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
     * Ruft den Wert der hinweisBalisenbefestigung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHinweisBalisenbefestigung }
     *     
     */
    public TCHinweisBalisenbefestigung getHinweisBalisenbefestigung() {
        return hinweisBalisenbefestigung;
    }

    /**
     * Legt den Wert der hinweisBalisenbefestigung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHinweisBalisenbefestigung }
     *     
     */
    public void setHinweisBalisenbefestigung(TCHinweisBalisenbefestigung value) {
        this.hinweisBalisenbefestigung = value;
    }

}
