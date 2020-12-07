//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.planpro._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CAnhang;
import plan_pro.modell.basisobjekte._1_9_0.CUrObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDAusgabeFachdatenOhneProxy;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Oberstes Objekt, das in jeder Datei vorhanden ist. Damit jede Ausgabe in Form einer XML-Datei �ber die Identit�t von ~ eindeutig zu identifizieren ist, muss bei jeder Erzeugung einer XML-Ausgabe f�r eine Planung eine neue GUID f�r das Objekt PlanPro_Schnittstelle vergeben werden.
 * 
 * <p>Java-Klasse f�r CPlanung_Einzel complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPlanung_Einzel">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Anhang_Erlaeuterungsbericht" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CAnhang" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Anhang_Material_Besonders" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CAnhang" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Anhang_VzG" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CAnhang" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_Ausgabe_Fachdaten" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Ausgabe_Fachdaten_ohne_Proxy"/>
 *         &lt;element name="LST_Objekte_Planungsbereich" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CLST_Objekte_Planungsbereich" minOccurs="0"/>
 *         &lt;element name="Planung_E_Allg" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CPlanung_E_Allg"/>
 *         &lt;element name="Planung_E_Ausgabe_Besonders" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CPlanung_E_Ausgabe_Besonders" minOccurs="0"/>
 *         &lt;element name="Planung_E_Handlung" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}CPlanung_E_Handlung"/>
 *         &lt;element name="Referenz_Planung_Basis" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCReferenz_Planung_Basis" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPlanung_Einzel", propOrder = {
    "anhangErlaeuterungsbericht",
    "anhangMaterialBesonders",
    "anhangVzG",
    "idAusgabeFachdaten",
    "lstObjektePlanungsbereich",
    "planungEAllg",
    "planungEAusgabeBesonders",
    "planungEHandlung",
    "referenzPlanungBasis"
})
public class CPlanungEinzel
    extends CUrObjekt
{

    @XmlElement(name = "Anhang_Erlaeuterungsbericht")
    protected List<CAnhang> anhangErlaeuterungsbericht;
    @XmlElement(name = "Anhang_Material_Besonders")
    protected List<CAnhang> anhangMaterialBesonders;
    @XmlElement(name = "Anhang_VzG")
    protected List<CAnhang> anhangVzG;
    @XmlElement(name = "ID_Ausgabe_Fachdaten", required = true)
    protected TCIDAusgabeFachdatenOhneProxy idAusgabeFachdaten;
    @XmlElement(name = "LST_Objekte_Planungsbereich")
    protected CLSTObjektePlanungsbereich lstObjektePlanungsbereich;
    @XmlElement(name = "Planung_E_Allg", required = true)
    protected CPlanungEAllg planungEAllg;
    @XmlElement(name = "Planung_E_Ausgabe_Besonders")
    protected CPlanungEAusgabeBesonders planungEAusgabeBesonders;
    @XmlElement(name = "Planung_E_Handlung", required = true)
    protected CPlanungEHandlung planungEHandlung;
    @XmlElement(name = "Referenz_Planung_Basis")
    protected TCReferenzPlanungBasis referenzPlanungBasis;

    /**
     * Gets the value of the anhangErlaeuterungsbericht property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anhangErlaeuterungsbericht property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnhangErlaeuterungsbericht().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CAnhang }
     * 
     * 
     */
    public List<CAnhang> getAnhangErlaeuterungsbericht() {
        if (anhangErlaeuterungsbericht == null) {
            anhangErlaeuterungsbericht = new ArrayList<CAnhang>();
        }
        return this.anhangErlaeuterungsbericht;
    }

    /**
     * Gets the value of the anhangMaterialBesonders property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anhangMaterialBesonders property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnhangMaterialBesonders().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CAnhang }
     * 
     * 
     */
    public List<CAnhang> getAnhangMaterialBesonders() {
        if (anhangMaterialBesonders == null) {
            anhangMaterialBesonders = new ArrayList<CAnhang>();
        }
        return this.anhangMaterialBesonders;
    }

    /**
     * Gets the value of the anhangVzG property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anhangVzG property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnhangVzG().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CAnhang }
     * 
     * 
     */
    public List<CAnhang> getAnhangVzG() {
        if (anhangVzG == null) {
            anhangVzG = new ArrayList<CAnhang>();
        }
        return this.anhangVzG;
    }

    /**
     * Ruft den Wert der idAusgabeFachdaten-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAusgabeFachdatenOhneProxy }
     *     
     */
    public TCIDAusgabeFachdatenOhneProxy getIDAusgabeFachdaten() {
        return idAusgabeFachdaten;
    }

    /**
     * Legt den Wert der idAusgabeFachdaten-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAusgabeFachdatenOhneProxy }
     *     
     */
    public void setIDAusgabeFachdaten(TCIDAusgabeFachdatenOhneProxy value) {
        this.idAusgabeFachdaten = value;
    }

    /**
     * Ruft den Wert der lstObjektePlanungsbereich-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CLSTObjektePlanungsbereich }
     *     
     */
    public CLSTObjektePlanungsbereich getLSTObjektePlanungsbereich() {
        return lstObjektePlanungsbereich;
    }

    /**
     * Legt den Wert der lstObjektePlanungsbereich-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CLSTObjektePlanungsbereich }
     *     
     */
    public void setLSTObjektePlanungsbereich(CLSTObjektePlanungsbereich value) {
        this.lstObjektePlanungsbereich = value;
    }

    /**
     * Ruft den Wert der planungEAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CPlanungEAllg }
     *     
     */
    public CPlanungEAllg getPlanungEAllg() {
        return planungEAllg;
    }

    /**
     * Legt den Wert der planungEAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CPlanungEAllg }
     *     
     */
    public void setPlanungEAllg(CPlanungEAllg value) {
        this.planungEAllg = value;
    }

    /**
     * Ruft den Wert der planungEAusgabeBesonders-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CPlanungEAusgabeBesonders }
     *     
     */
    public CPlanungEAusgabeBesonders getPlanungEAusgabeBesonders() {
        return planungEAusgabeBesonders;
    }

    /**
     * Legt den Wert der planungEAusgabeBesonders-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CPlanungEAusgabeBesonders }
     *     
     */
    public void setPlanungEAusgabeBesonders(CPlanungEAusgabeBesonders value) {
        this.planungEAusgabeBesonders = value;
    }

    /**
     * Ruft den Wert der planungEHandlung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CPlanungEHandlung }
     *     
     */
    public CPlanungEHandlung getPlanungEHandlung() {
        return planungEHandlung;
    }

    /**
     * Legt den Wert der planungEHandlung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CPlanungEHandlung }
     *     
     */
    public void setPlanungEHandlung(CPlanungEHandlung value) {
        this.planungEHandlung = value;
    }

    /**
     * Ruft den Wert der referenzPlanungBasis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCReferenzPlanungBasis }
     *     
     */
    public TCReferenzPlanungBasis getReferenzPlanungBasis() {
        return referenzPlanungBasis;
    }

    /**
     * Legt den Wert der referenzPlanungBasis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCReferenzPlanungBasis }
     *     
     */
    public void setReferenzPlanungBasis(TCReferenzPlanungBasis value) {
        this.referenzPlanungBasis = value;
    }

}
