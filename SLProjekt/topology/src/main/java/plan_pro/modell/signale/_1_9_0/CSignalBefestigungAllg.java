//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.signale._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSignal_Befestigung_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSignal_Befestigung_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Befestigung_Art" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}TCBefestigung_Art"/>
 *         &lt;element name="Hoehe_Fundamentoberkante" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}TCHoehe_Fundamentoberkante" minOccurs="0"/>
 *         &lt;element name="Obere_Lichtpunkthoehe" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}TCObere_Lichtpunkthoehe" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSignal_Befestigung_Allg", propOrder = {
    "befestigungArt",
    "hoeheFundamentoberkante",
    "obereLichtpunkthoehe"
})
public class CSignalBefestigungAllg {

    @XmlElement(name = "Befestigung_Art", required = true)
    protected TCBefestigungArt befestigungArt;
    @XmlElement(name = "Hoehe_Fundamentoberkante")
    protected TCHoeheFundamentoberkante hoeheFundamentoberkante;
    @XmlElement(name = "Obere_Lichtpunkthoehe")
    protected TCObereLichtpunkthoehe obereLichtpunkthoehe;

    /**
     * Ruft den Wert der befestigungArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBefestigungArt }
     *     
     */
    public TCBefestigungArt getBefestigungArt() {
        return befestigungArt;
    }

    /**
     * Legt den Wert der befestigungArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBefestigungArt }
     *     
     */
    public void setBefestigungArt(TCBefestigungArt value) {
        this.befestigungArt = value;
    }

    /**
     * Ruft den Wert der hoeheFundamentoberkante-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHoeheFundamentoberkante }
     *     
     */
    public TCHoeheFundamentoberkante getHoeheFundamentoberkante() {
        return hoeheFundamentoberkante;
    }

    /**
     * Legt den Wert der hoeheFundamentoberkante-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHoeheFundamentoberkante }
     *     
     */
    public void setHoeheFundamentoberkante(TCHoeheFundamentoberkante value) {
        this.hoeheFundamentoberkante = value;
    }

    /**
     * Ruft den Wert der obereLichtpunkthoehe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCObereLichtpunkthoehe }
     *     
     */
    public TCObereLichtpunkthoehe getObereLichtpunkthoehe() {
        return obereLichtpunkthoehe;
    }

    /**
     * Legt den Wert der obereLichtpunkthoehe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCObereLichtpunkthoehe }
     *     
     */
    public void setObereLichtpunkthoehe(TCObereLichtpunkthoehe value) {
        this.obereLichtpunkthoehe = value;
    }

}
