//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.planpro._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CPlanung_G_Schriftfeld complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPlanung_G_Schriftfeld">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bauabschnitt" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCBauabschnitt" minOccurs="0"/>
 *         &lt;element name="Bezeichnung_Anlage" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCBezeichnung_Anlage" minOccurs="0"/>
 *         &lt;element name="Bezeichnung_Planung_Gruppe" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCBezeichnung_Planung_Gruppe" minOccurs="0"/>
 *         &lt;element name="Bezeichnung_Unteranlage" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCBezeichnung_Unteranlage" minOccurs="0"/>
 *         &lt;element name="LST_Fachplaner" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}CAkteur"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPlanung_G_Schriftfeld", propOrder = {
    "bauabschnitt",
    "bezeichnungAnlage",
    "bezeichnungPlanungGruppe",
    "bezeichnungUnteranlage",
    "lstFachplaner"
})
public class CPlanungGSchriftfeld {

    @XmlElement(name = "Bauabschnitt")
    protected TCBauabschnitt bauabschnitt;
    @XmlElement(name = "Bezeichnung_Anlage")
    protected TCBezeichnungAnlage bezeichnungAnlage;
    @XmlElement(name = "Bezeichnung_Planung_Gruppe")
    protected TCBezeichnungPlanungGruppe bezeichnungPlanungGruppe;
    @XmlElement(name = "Bezeichnung_Unteranlage")
    protected TCBezeichnungUnteranlage bezeichnungUnteranlage;
    @XmlElement(name = "LST_Fachplaner", required = true)
    protected CAkteur lstFachplaner;

    /**
     * Ruft den Wert der bauabschnitt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBauabschnitt }
     *     
     */
    public TCBauabschnitt getBauabschnitt() {
        return bauabschnitt;
    }

    /**
     * Legt den Wert der bauabschnitt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBauabschnitt }
     *     
     */
    public void setBauabschnitt(TCBauabschnitt value) {
        this.bauabschnitt = value;
    }

    /**
     * Ruft den Wert der bezeichnungAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungAnlage }
     *     
     */
    public TCBezeichnungAnlage getBezeichnungAnlage() {
        return bezeichnungAnlage;
    }

    /**
     * Legt den Wert der bezeichnungAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungAnlage }
     *     
     */
    public void setBezeichnungAnlage(TCBezeichnungAnlage value) {
        this.bezeichnungAnlage = value;
    }

    /**
     * Ruft den Wert der bezeichnungPlanungGruppe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungPlanungGruppe }
     *     
     */
    public TCBezeichnungPlanungGruppe getBezeichnungPlanungGruppe() {
        return bezeichnungPlanungGruppe;
    }

    /**
     * Legt den Wert der bezeichnungPlanungGruppe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungPlanungGruppe }
     *     
     */
    public void setBezeichnungPlanungGruppe(TCBezeichnungPlanungGruppe value) {
        this.bezeichnungPlanungGruppe = value;
    }

    /**
     * Ruft den Wert der bezeichnungUnteranlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungUnteranlage }
     *     
     */
    public TCBezeichnungUnteranlage getBezeichnungUnteranlage() {
        return bezeichnungUnteranlage;
    }

    /**
     * Legt den Wert der bezeichnungUnteranlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungUnteranlage }
     *     
     */
    public void setBezeichnungUnteranlage(TCBezeichnungUnteranlage value) {
        this.bezeichnungUnteranlage = value;
    }

    /**
     * Ruft den Wert der lstFachplaner-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CAkteur }
     *     
     */
    public CAkteur getLSTFachplaner() {
        return lstFachplaner;
    }

    /**
     * Legt den Wert der lstFachplaner-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CAkteur }
     *     
     */
    public void setLSTFachplaner(CAkteur value) {
        this.lstFachplaner = value;
    }

}
