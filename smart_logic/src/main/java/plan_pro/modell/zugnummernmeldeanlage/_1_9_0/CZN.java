//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Zugnummernmeldeanlage. Wird die ZN-Anlage zusammen mit dem ESTW geplant, gibt es keinen Verweis auf die Anh�nge, da die ZN bereits in der ESTW-Konfiguration ber�cksichtigt ist. Wird die ZN nachger�stet, sind die Verweise auf ESTW_Zentraleinheit und Anh�nge vorhanden. Kann eine ESTW-Bauform keine ZN ber�cksichtigen, dann gibt es keinen Verweis auf ESTW_Zentraleinheit. DB-Regelwerk 819.0731 
 * 
 * <p>Java-Klasse f�r CZN complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZN">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Anhang_ZN_Plan_Bedienraum" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang" minOccurs="0"/>
 *         &lt;element name="ID_Anhang_ZN_Plan_Rechnerraum" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang" minOccurs="0"/>
 *         &lt;element name="ID_Oertlichkeit" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Oertlichkeit"/>
 *         &lt;element name="ID_Stellwerk" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Stellwerk" minOccurs="0"/>
 *         &lt;element name="ID_Unterbringung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Unterbringung" minOccurs="0"/>
 *         &lt;element name="ID_ZN_Unterstation" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZN_Unterstation"/>
 *         &lt;element name="ZN_Allg" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}CZN_Allg"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZN", propOrder = {
    "idAnhangZNPlanBedienraum",
    "idAnhangZNPlanRechnerraum",
    "idOertlichkeit",
    "idStellwerk",
    "idUnterbringung",
    "idznUnterstation",
    "znAllg"
})
public class CZN
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Anhang_ZN_Plan_Bedienraum")
    protected TCIDAnhang idAnhangZNPlanBedienraum;
    @XmlElement(name = "ID_Anhang_ZN_Plan_Rechnerraum")
    protected TCIDAnhang idAnhangZNPlanRechnerraum;
    @XmlElement(name = "ID_Oertlichkeit", required = true)
    protected TCIDOertlichkeit idOertlichkeit;
    @XmlElement(name = "ID_Stellwerk")
    protected TCIDStellwerk idStellwerk;
    @XmlElement(name = "ID_Unterbringung")
    protected TCIDUnterbringung idUnterbringung;
    @XmlElement(name = "ID_ZN_Unterstation", required = true)
    protected TCIDZNUnterstation idznUnterstation;
    @XmlElement(name = "ZN_Allg", required = true)
    protected CZNAllg znAllg;

    /**
     * Ruft den Wert der idAnhangZNPlanBedienraum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangZNPlanBedienraum() {
        return idAnhangZNPlanBedienraum;
    }

    /**
     * Legt den Wert der idAnhangZNPlanBedienraum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangZNPlanBedienraum(TCIDAnhang value) {
        this.idAnhangZNPlanBedienraum = value;
    }

    /**
     * Ruft den Wert der idAnhangZNPlanRechnerraum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangZNPlanRechnerraum() {
        return idAnhangZNPlanRechnerraum;
    }

    /**
     * Legt den Wert der idAnhangZNPlanRechnerraum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangZNPlanRechnerraum(TCIDAnhang value) {
        this.idAnhangZNPlanRechnerraum = value;
    }

    /**
     * Ruft den Wert der idOertlichkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDOertlichkeit }
     *     
     */
    public TCIDOertlichkeit getIDOertlichkeit() {
        return idOertlichkeit;
    }

    /**
     * Legt den Wert der idOertlichkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDOertlichkeit }
     *     
     */
    public void setIDOertlichkeit(TCIDOertlichkeit value) {
        this.idOertlichkeit = value;
    }

    /**
     * Ruft den Wert der idStellwerk-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDStellwerk }
     *     
     */
    public TCIDStellwerk getIDStellwerk() {
        return idStellwerk;
    }

    /**
     * Legt den Wert der idStellwerk-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDStellwerk }
     *     
     */
    public void setIDStellwerk(TCIDStellwerk value) {
        this.idStellwerk = value;
    }

    /**
     * Ruft den Wert der idUnterbringung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDUnterbringung }
     *     
     */
    public TCIDUnterbringung getIDUnterbringung() {
        return idUnterbringung;
    }

    /**
     * Legt den Wert der idUnterbringung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDUnterbringung }
     *     
     */
    public void setIDUnterbringung(TCIDUnterbringung value) {
        this.idUnterbringung = value;
    }

    /**
     * Ruft den Wert der idznUnterstation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZNUnterstation }
     *     
     */
    public TCIDZNUnterstation getIDZNUnterstation() {
        return idznUnterstation;
    }

    /**
     * Legt den Wert der idznUnterstation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZNUnterstation }
     *     
     */
    public void setIDZNUnterstation(TCIDZNUnterstation value) {
        this.idznUnterstation = value;
    }

    /**
     * Ruft den Wert der znAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZNAllg }
     *     
     */
    public CZNAllg getZNAllg() {
        return znAllg;
    }

    /**
     * Legt den Wert der znAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZNAllg }
     *     
     */
    public void setZNAllg(CZNAllg value) {
        this.znAllg = value;
    }

}
