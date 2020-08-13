//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.planpro._1_8;

import modell.basisobjekte._1_8.CUrObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Oberstes Objekt, das in jeder Datei vorhanden ist. Damit jede Ausgabe in Form einer XML-Datei �ber die Identit�t von ~ eindeutig zu identifizieren ist, muss bei jeder Erzeugung einer XML-Ausgabe f�r eine Planung eine neue GUID f�r das Objekt PlanPro_Schnittstelle vergeben werden.
 * 
 * <p>Java-Klasse f�r CPlanPro_Schnittstelle complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPlanPro_Schnittstelle">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="PlanPro_Schnittstelle_Allg" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CPlanPro_Schnittstelle_Allg"/>
 *         &lt;choice>
 *           &lt;element name="LST_Planung_Projekt" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CPlanung_Projekt"/>
 *           &lt;element name="LST_Zustand_Information" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CLST_Zustand"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPlanPro_Schnittstelle", propOrder = {
    "planProSchnittstelleAllg",
    "lstPlanungProjekt",
    "lstZustandInformation"
})
public class CPlanProSchnittstelle
    extends CUrObjekt
{

    @XmlElement(name = "PlanPro_Schnittstelle_Allg", required = true)
    protected CPlanProSchnittstelleAllg planProSchnittstelleAllg;
    @XmlElement(name = "LST_Planung_Projekt")
    protected CPlanungProjekt lstPlanungProjekt;
    @XmlElement(name = "LST_Zustand_Information")
    protected CLSTZustand lstZustandInformation;

    /**
     * Ruft den Wert der planProSchnittstelleAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CPlanProSchnittstelleAllg }
     *     
     */
    public CPlanProSchnittstelleAllg getPlanProSchnittstelleAllg() {
        return planProSchnittstelleAllg;
    }

    /**
     * Legt den Wert der planProSchnittstelleAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CPlanProSchnittstelleAllg }
     *     
     */
    public void setPlanProSchnittstelleAllg(CPlanProSchnittstelleAllg value) {
        this.planProSchnittstelleAllg = value;
    }

    /**
     * Ruft den Wert der lstPlanungProjekt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CPlanungProjekt }
     *     
     */
    public CPlanungProjekt getLSTPlanungProjekt() {
        return lstPlanungProjekt;
    }

    /**
     * Legt den Wert der lstPlanungProjekt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CPlanungProjekt }
     *     
     */
    public void setLSTPlanungProjekt(CPlanungProjekt value) {
        this.lstPlanungProjekt = value;
    }

    /**
     * Ruft den Wert der lstZustandInformation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CLSTZustand }
     *     
     */
    public CLSTZustand getLSTZustandInformation() {
        return lstZustandInformation;
    }

    /**
     * Legt den Wert der lstZustandInformation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CLSTZustand }
     *     
     */
    public void setLSTZustandInformation(CLSTZustand value) {
        this.lstZustandInformation = value;
    }

}
