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
 * Erm�glicht die globale Angabe und Zuordnung von organisatorischen und inhaltlichen Daten, die f�r alle Planungsgruppen eines Planungsprojekts gleicherma�en gelten. 
 * 
 * Ein ~ enth�lt mindestens eine Planungsgruppe.
 * 
 * DB-Regelwerk
 * 
 * Bisher keine eindeutige Abbildung als Schriftfeldeintrag gem�� Ril 819.0103.
 * 
 * <p>Java-Klasse f�r CPlanung_Projekt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPlanung_Projekt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="LST_Planung_Gruppe" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CPlanung_Gruppe"/>
 *         &lt;element name="Planung_P_Allg" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CPlanung_P_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPlanung_Projekt", propOrder = {
    "lstPlanungGruppe",
    "planungPAllg"
})
public class CPlanungProjekt
    extends CUrObjekt
{

    @XmlElement(name = "LST_Planung_Gruppe", required = true)
    protected CPlanungGruppe lstPlanungGruppe;
    @XmlElement(name = "Planung_P_Allg", required = true)
    protected CPlanungPAllg planungPAllg;

    /**
     * Ruft den Wert der lstPlanungGruppe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CPlanungGruppe }
     *     
     */
    public CPlanungGruppe getLSTPlanungGruppe() {
        return lstPlanungGruppe;
    }

    /**
     * Legt den Wert der lstPlanungGruppe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CPlanungGruppe }
     *     
     */
    public void setLSTPlanungGruppe(CPlanungGruppe value) {
        this.lstPlanungGruppe = value;
    }

    /**
     * Ruft den Wert der planungPAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CPlanungPAllg }
     *     
     */
    public CPlanungPAllg getPlanungPAllg() {
        return planungPAllg;
    }

    /**
     * Legt den Wert der planungPAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CPlanungPAllg }
     *     
     */
    public void setPlanungPAllg(CPlanungPAllg value) {
        this.planungPAllg = value;
    }

}
