//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CUeberhoehungslinie_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CUeberhoehungslinie_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Plan_Quelle" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCPlan_Quelle"/>
 *         &lt;element name="Ueberhoehungslinie_Form" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCUeberhoehungslinie_Form"/>
 *         &lt;element name="Ueberhoehungslinie_Laenge" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCUeberhoehungslinie_Laenge"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CUeberhoehungslinie_Allg", propOrder = {
    "planQuelle",
    "ueberhoehungslinieForm",
    "ueberhoehungslinieLaenge"
})
public class CUeberhoehungslinieAllg {

    @XmlElement(name = "Plan_Quelle", required = true)
    protected TCPlanQuelle planQuelle;
    @XmlElement(name = "Ueberhoehungslinie_Form", required = true)
    protected TCUeberhoehungslinieForm ueberhoehungslinieForm;
    @XmlElement(name = "Ueberhoehungslinie_Laenge", required = true)
    protected TCUeberhoehungslinieLaenge ueberhoehungslinieLaenge;

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

    /**
     * Ruft den Wert der ueberhoehungslinieForm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUeberhoehungslinieForm }
     *     
     */
    public TCUeberhoehungslinieForm getUeberhoehungslinieForm() {
        return ueberhoehungslinieForm;
    }

    /**
     * Legt den Wert der ueberhoehungslinieForm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUeberhoehungslinieForm }
     *     
     */
    public void setUeberhoehungslinieForm(TCUeberhoehungslinieForm value) {
        this.ueberhoehungslinieForm = value;
    }

    /**
     * Ruft den Wert der ueberhoehungslinieLaenge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUeberhoehungslinieLaenge }
     *     
     */
    public TCUeberhoehungslinieLaenge getUeberhoehungslinieLaenge() {
        return ueberhoehungslinieLaenge;
    }

    /**
     * Legt den Wert der ueberhoehungslinieLaenge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUeberhoehungslinieLaenge }
     *     
     */
    public void setUeberhoehungslinieLaenge(TCUeberhoehungslinieLaenge value) {
        this.ueberhoehungslinieLaenge = value;
    }

}
