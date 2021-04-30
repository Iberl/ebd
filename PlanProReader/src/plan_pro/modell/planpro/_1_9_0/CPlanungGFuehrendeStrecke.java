//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.planpro._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CPlanung_G_Fuehrende_Strecke complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPlanung_G_Fuehrende_Strecke">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Strecke_Abschnitt" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCStrecke_Abschnitt"/>
 *         &lt;element name="Strecke_Km" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCStrecke_Km"/>
 *         &lt;element name="Strecke_Nummer" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCStrecke_Nummer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPlanung_G_Fuehrende_Strecke", propOrder = {
    "streckeAbschnitt",
    "streckeKm",
    "streckeNummer"
})
public class CPlanungGFuehrendeStrecke {

    @XmlElement(name = "Strecke_Abschnitt", required = true)
    protected TCStreckeAbschnitt streckeAbschnitt;
    @XmlElement(name = "Strecke_Km", required = true)
    protected TCStreckeKm streckeKm;
    @XmlElement(name = "Strecke_Nummer", required = true)
    protected TCStreckeNummer streckeNummer;

    /**
     * Ruft den Wert der streckeAbschnitt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCStreckeAbschnitt }
     *     
     */
    public TCStreckeAbschnitt getStreckeAbschnitt() {
        return streckeAbschnitt;
    }

    /**
     * Legt den Wert der streckeAbschnitt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCStreckeAbschnitt }
     *     
     */
    public void setStreckeAbschnitt(TCStreckeAbschnitt value) {
        this.streckeAbschnitt = value;
    }

    /**
     * Ruft den Wert der streckeKm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCStreckeKm }
     *     
     */
    public TCStreckeKm getStreckeKm() {
        return streckeKm;
    }

    /**
     * Legt den Wert der streckeKm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCStreckeKm }
     *     
     */
    public void setStreckeKm(TCStreckeKm value) {
        this.streckeKm = value;
    }

    /**
     * Ruft den Wert der streckeNummer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCStreckeNummer }
     *     
     */
    public TCStreckeNummer getStreckeNummer() {
        return streckeNummer;
    }

    /**
     * Legt den Wert der streckeNummer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCStreckeNummer }
     *     
     */
    public void setStreckeNummer(TCStreckeNummer value) {
        this.streckeNummer = value;
    }

}
