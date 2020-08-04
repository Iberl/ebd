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
import java.util.ArrayList;
import java.util.List;


/**
 * Erm�glicht die globale Angabe und Zuordnung von organisatorischen und inhaltlichen Daten, die f�r alle Planungsgruppen eines Planungsprojekts gleicherma�en gelten. \r\n\r\nEin ~ enth�lt mindestens eine Planungsgruppe.\r\n\r\nDB-Regelwerk\r\nBisher keine eindeutige Abbildung als Schriftfeldeintrag gem�� Ril 819.0103.
 * 
 * <p>Java-Klasse f�r CPlanung_Projekt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPlanung_Projekt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="LST_Planung_Gruppe" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CPlanung_Gruppe" maxOccurs="unbounded"/>
 *         &lt;element name="Planung_P_Allg" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CPlanung_P_Allg"/>
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
    protected List<CPlanungGruppe> lstPlanungGruppe;
    @XmlElement(name = "Planung_P_Allg", required = true)
    protected CPlanungPAllg planungPAllg;

    /**
     * Gets the value of the lstPlanungGruppe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lstPlanungGruppe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLSTPlanungGruppe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CPlanungGruppe }
     * 
     * 
     */
    public List<CPlanungGruppe> getLSTPlanungGruppe() {
        if (lstPlanungGruppe == null) {
            lstPlanungGruppe = new ArrayList<CPlanungGruppe>();
        }
        return this.lstPlanungGruppe;
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
