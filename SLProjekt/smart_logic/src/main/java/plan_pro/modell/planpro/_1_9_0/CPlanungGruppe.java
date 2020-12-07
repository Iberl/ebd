//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.planpro._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CUrObjekt;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Angabe und Zuordnung von Daten, die f�r eine Einzelplanung innerhalb einer definierten Planungsgruppe gelten. \r\n\r\nDie Attribute des Objekts Planung_Einzel werden zum Teil w�hrend der Erstellung der beauftragten Planung bef�llt. Mit der Weiterschaltung des jeweiligen Planungsstatus k�nnen im Rahmen nachfolgender Prozessschritte (z. B. Planpr�fung) weitere Attribute bef�llt werden.
 * 
 * <p>Java-Klasse f�r CPlanung_Gruppe complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPlanung_Gruppe">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Fuehrende_Oertlichkeit" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCFuehrende_Oertlichkeit"/>
 *         &lt;element name="LST_Planung_Einzel" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CPlanung_Einzel"/>
 *         &lt;element name="Planung_G_Allg" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CPlanung_G_Allg"/>
 *         &lt;element name="Planung_G_Fuehrende_Strecke" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CPlanung_G_Fuehrende_Strecke" minOccurs="0"/>
 *         &lt;element name="Planung_G_Schriftfeld" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CPlanung_G_Schriftfeld" minOccurs="0"/>
 *         &lt;element name="Polygone_Betrachtungsbereich" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CPolygone_Betrachtungsbereich" minOccurs="0"/>
 *         &lt;element name="Polygone_Planungsbereich" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CPolygone_Planungsbereich" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPlanung_Gruppe", propOrder = {
    "fuehrendeOertlichkeit",
    "lstPlanungEinzel",
    "planungGAllg",
    "planungGFuehrendeStrecke",
    "planungGSchriftfeld",
    "polygoneBetrachtungsbereich",
    "polygonePlanungsbereich"
})
public class CPlanungGruppe
    extends CUrObjekt
{

    @XmlElement(name = "Fuehrende_Oertlichkeit", required = true)
    protected TCFuehrendeOertlichkeit fuehrendeOertlichkeit;
    @XmlElement(name = "LST_Planung_Einzel", required = true)
    protected CPlanungEinzel lstPlanungEinzel;
    @XmlElement(name = "Planung_G_Allg", required = true)
    protected CPlanungGAllg planungGAllg;
    @XmlElement(name = "Planung_G_Fuehrende_Strecke")
    protected CPlanungGFuehrendeStrecke planungGFuehrendeStrecke;
    @XmlElement(name = "Planung_G_Schriftfeld")
    protected CPlanungGSchriftfeld planungGSchriftfeld;
    @XmlElement(name = "Polygone_Betrachtungsbereich")
    protected CPolygoneBetrachtungsbereich polygoneBetrachtungsbereich;
    @XmlElement(name = "Polygone_Planungsbereich")
    protected CPolygonePlanungsbereich polygonePlanungsbereich;

    /**
     * Ruft den Wert der fuehrendeOertlichkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFuehrendeOertlichkeit }
     *     
     */
    public TCFuehrendeOertlichkeit getFuehrendeOertlichkeit() {
        return fuehrendeOertlichkeit;
    }

    /**
     * Legt den Wert der fuehrendeOertlichkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFuehrendeOertlichkeit }
     *     
     */
    public void setFuehrendeOertlichkeit(TCFuehrendeOertlichkeit value) {
        this.fuehrendeOertlichkeit = value;
    }

    /**
     * Ruft den Wert der lstPlanungEinzel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CPlanungEinzel }
     *     
     */
    public CPlanungEinzel getLSTPlanungEinzel() {
        return lstPlanungEinzel;
    }

    /**
     * Legt den Wert der lstPlanungEinzel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CPlanungEinzel }
     *     
     */
    public void setLSTPlanungEinzel(CPlanungEinzel value) {
        this.lstPlanungEinzel = value;
    }

    /**
     * Ruft den Wert der planungGAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CPlanungGAllg }
     *     
     */
    public CPlanungGAllg getPlanungGAllg() {
        return planungGAllg;
    }

    /**
     * Legt den Wert der planungGAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CPlanungGAllg }
     *     
     */
    public void setPlanungGAllg(CPlanungGAllg value) {
        this.planungGAllg = value;
    }

    /**
     * Ruft den Wert der planungGFuehrendeStrecke-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CPlanungGFuehrendeStrecke }
     *     
     */
    public CPlanungGFuehrendeStrecke getPlanungGFuehrendeStrecke() {
        return planungGFuehrendeStrecke;
    }

    /**
     * Legt den Wert der planungGFuehrendeStrecke-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CPlanungGFuehrendeStrecke }
     *     
     */
    public void setPlanungGFuehrendeStrecke(CPlanungGFuehrendeStrecke value) {
        this.planungGFuehrendeStrecke = value;
    }

    /**
     * Ruft den Wert der planungGSchriftfeld-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CPlanungGSchriftfeld }
     *     
     */
    public CPlanungGSchriftfeld getPlanungGSchriftfeld() {
        return planungGSchriftfeld;
    }

    /**
     * Legt den Wert der planungGSchriftfeld-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CPlanungGSchriftfeld }
     *     
     */
    public void setPlanungGSchriftfeld(CPlanungGSchriftfeld value) {
        this.planungGSchriftfeld = value;
    }

    /**
     * Ruft den Wert der polygoneBetrachtungsbereich-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CPolygoneBetrachtungsbereich }
     *     
     */
    public CPolygoneBetrachtungsbereich getPolygoneBetrachtungsbereich() {
        return polygoneBetrachtungsbereich;
    }

    /**
     * Legt den Wert der polygoneBetrachtungsbereich-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CPolygoneBetrachtungsbereich }
     *     
     */
    public void setPolygoneBetrachtungsbereich(CPolygoneBetrachtungsbereich value) {
        this.polygoneBetrachtungsbereich = value;
    }

    /**
     * Ruft den Wert der polygonePlanungsbereich-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CPolygonePlanungsbereich }
     *     
     */
    public CPolygonePlanungsbereich getPolygonePlanungsbereich() {
        return polygonePlanungsbereich;
    }

    /**
     * Legt den Wert der polygonePlanungsbereich-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CPolygonePlanungsbereich }
     *     
     */
    public void setPolygonePlanungsbereich(CPolygonePlanungsbereich value) {
        this.polygonePlanungsbereich = value;
    }

}
