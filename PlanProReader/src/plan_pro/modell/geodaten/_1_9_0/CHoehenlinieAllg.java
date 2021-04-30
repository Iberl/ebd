//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CHoehenlinie_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CHoehenlinie_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Hoehenlinie_Form" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCHoehenlinie_Form"/>
 *         &lt;element name="Hoehenlinie_Laenge" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCHoehenlinie_Laenge"/>
 *         &lt;element name="Plan_Quelle" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCPlan_Quelle"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHoehenlinie_Allg", propOrder = {
    "hoehenlinieForm",
    "hoehenlinieLaenge",
    "planQuelle"
})
public class CHoehenlinieAllg {

    @XmlElement(name = "Hoehenlinie_Form", required = true)
    protected TCHoehenlinieForm hoehenlinieForm;
    @XmlElement(name = "Hoehenlinie_Laenge", required = true)
    protected TCHoehenlinieLaenge hoehenlinieLaenge;
    @XmlElement(name = "Plan_Quelle", required = true)
    protected TCPlanQuelle planQuelle;

    /**
     * Ruft den Wert der hoehenlinieForm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHoehenlinieForm }
     *     
     */
    public TCHoehenlinieForm getHoehenlinieForm() {
        return hoehenlinieForm;
    }

    /**
     * Legt den Wert der hoehenlinieForm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHoehenlinieForm }
     *     
     */
    public void setHoehenlinieForm(TCHoehenlinieForm value) {
        this.hoehenlinieForm = value;
    }

    /**
     * Ruft den Wert der hoehenlinieLaenge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHoehenlinieLaenge }
     *     
     */
    public TCHoehenlinieLaenge getHoehenlinieLaenge() {
        return hoehenlinieLaenge;
    }

    /**
     * Legt den Wert der hoehenlinieLaenge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHoehenlinieLaenge }
     *     
     */
    public void setHoehenlinieLaenge(TCHoehenlinieLaenge value) {
        this.hoehenlinieLaenge = value;
    }

    /**
     * Ruft den Wert der planQuelle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPlanQuelle }
     *     
     */
    public TCPlanQuelle getPlanQuelle() {
        return planQuelle;
    }

    /**
     * Legt den Wert der planQuelle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPlanQuelle }
     *     
     */
    public void setPlanQuelle(TCPlanQuelle value) {
        this.planQuelle = value;
    }

}
