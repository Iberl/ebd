//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.planpro._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CUrObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Erm�glicht die globale Angabe und Zuordnung von Daten, die f�r alle Einzelplanungen einer Planungsgruppe gleicherma�en gelten. Dabei k�nnen in organisatorische und inhaltliche Angaben unterschieden werden. \r\n\rErg�nzende Beschreibung zum Umgang im PlanPro-Planungsprozess\r\n\rDie ~ muss vor Beginn der Erstellung nachfolgender Einzelplanungen festgelegt sein. \r\n\rEnth�lt Informationen zur Bezeichnung der Planungsgruppe, zum gesperrten Planungsbereich und zum notwendigen Betrachtungsbereich.\r\n\rBeim Anlegen der ~ erfolgt keine Festlegung der Anzahl der Einzelplanungen. Der erste Bauzustand ist entweder eine Neuplanung oder baut auf einer Bestandsdokumentationbzw. Bestandsdatenauf. Alle weiteren Bauzust�nde bauen auf der neutralisierten Bezugsplanung des jeweiligen Vorg�ngers auf.\r\n\rEine Planungsgruppe durchl�uft definierte Status. Sp�testens vor Abschluss einer ~ (sowie nach jeder Revision/Rev_letzte_Planung_E) werden neue Bestandsdaten erstellt.\r\n\r\nDB-Regelwerk\r\n\rBisher nicht abgebildet.
 * 
 * <p>Java-Klasse f�r CPlanPro_Schnittstelle complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPlanPro_Schnittstelle">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="PlanPro_Schnittstelle_Allg" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CPlanPro_Schnittstelle_Allg"/>
 *         &lt;choice>
 *           &lt;element name="LST_Planung" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CLST_Planung"/>
 *           &lt;element name="LST_Zustand" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CLST_Zustand"/>
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
    "lstPlanung",
    "lstZustand"
})
public class CPlanProSchnittstelle
    extends CUrObjekt
{

    @XmlElement(name = "PlanPro_Schnittstelle_Allg", required = true)
    protected CPlanProSchnittstelleAllg planProSchnittstelleAllg;
    @XmlElement(name = "LST_Planung")
    protected CLSTPlanung lstPlanung;
    @XmlElement(name = "LST_Zustand")
    protected CLSTZustand lstZustand;

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
     * Ruft den Wert der lstPlanung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CLSTPlanung }
     *     
     */
    public CLSTPlanung getLSTPlanung() {
        return lstPlanung;
    }

    /**
     * Legt den Wert der lstPlanung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CLSTPlanung }
     *     
     */
    public void setLSTPlanung(CLSTPlanung value) {
        this.lstPlanung = value;
    }

    /**
     * Ruft den Wert der lstZustand-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CLSTZustand }
     *     
     */
    public CLSTZustand getLSTZustand() {
        return lstZustand;
    }

    /**
     * Legt den Wert der lstZustand-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CLSTZustand }
     *     
     */
    public void setLSTZustand(CLSTZustand value) {
        this.lstZustand = value;
    }

}
