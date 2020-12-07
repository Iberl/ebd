//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDAnhang;
import plan_pro.modell.verweise._1_9_0.TCIDOertlichkeitProxy;
import plan_pro.modell.verweise._1_9_0.TCIDStrecke;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Betriebsleitstelle eines EIU, aus der die Leit- und Sicherungstechnik von zentral gesteuerten ESTW planm��ig bedient wird. Die Betriebsleitstelle kann eine Betriebszentrale (BZ) der DB Netz oder auch eine zentrale Bedienstelle der Regionalnetze sein. Da die Bedien_Zentrale nicht notwendigerweise in der N�he von Gleisen liegt, wird kein unmittelbarer Bezug zu einer Strecke hergestellt. Eine �rtlichkeit wird jedoch nach Ril 100 f�r den Standort festgelegt. In der Bedien_Zentrale sind die spezifischen Anh�nge dargestellt. Weitere Pl�ne aus dem PT I BZ, wie beispielsweise Belegungspl�ne f�r Bodentanks, Kabel�bersichtspl�ne, Verteilerbelegungspl�ne, Schrankpl�ne, H�heneinheiten und Patchfeldbelegungen in den Schr�nken f�r die BZ, werden als allgemeiner Anhang f�r die vererbten Eigenschaften aus dem Basisobjekt (Attribut Anhang) im Objekt Bedien_Zentrale angeh�ngt.
 * 
 * <p>Java-Klasse f�r CBedien_Zentrale complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Zentrale">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Anhang_Plan_Bedienraum" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang" minOccurs="0"/>
 *         &lt;element name="ID_Anhang_Plan_Rechnerraum" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang" minOccurs="0"/>
 *         &lt;element name="ID_Strecke" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Strecke" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}CBedien_Zentrale_Bezeichnung"/>
 *           &lt;element name="ID_Oertlichkeit" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Oertlichkeit_Proxy"/>
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
@XmlType(name = "CBedien_Zentrale", propOrder = {
    "idAnhangPlanBedienraum",
    "idAnhangPlanRechnerraum",
    "idStrecke",
    "bezeichnung",
    "idOertlichkeit"
})
public class CBedienZentrale
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Anhang_Plan_Bedienraum")
    protected TCIDAnhang idAnhangPlanBedienraum;
    @XmlElement(name = "ID_Anhang_Plan_Rechnerraum")
    protected TCIDAnhang idAnhangPlanRechnerraum;
    @XmlElement(name = "ID_Strecke")
    protected TCIDStrecke idStrecke;
    @XmlElement(name = "Bezeichnung")
    protected CBedienZentraleBezeichnung bezeichnung;
    @XmlElement(name = "ID_Oertlichkeit")
    protected TCIDOertlichkeitProxy idOertlichkeit;

    /**
     * Ruft den Wert der idAnhangPlanBedienraum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangPlanBedienraum() {
        return idAnhangPlanBedienraum;
    }

    /**
     * Legt den Wert der idAnhangPlanBedienraum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangPlanBedienraum(TCIDAnhang value) {
        this.idAnhangPlanBedienraum = value;
    }

    /**
     * Ruft den Wert der idAnhangPlanRechnerraum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangPlanRechnerraum() {
        return idAnhangPlanRechnerraum;
    }

    /**
     * Legt den Wert der idAnhangPlanRechnerraum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangPlanRechnerraum(TCIDAnhang value) {
        this.idAnhangPlanRechnerraum = value;
    }

    /**
     * Ruft den Wert der idStrecke-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDStrecke }
     *     
     */
    public TCIDStrecke getIDStrecke() {
        return idStrecke;
    }

    /**
     * Legt den Wert der idStrecke-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDStrecke }
     *     
     */
    public void setIDStrecke(TCIDStrecke value) {
        this.idStrecke = value;
    }

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedienZentraleBezeichnung }
     *     
     */
    public CBedienZentraleBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedienZentraleBezeichnung }
     *     
     */
    public void setBezeichnung(CBedienZentraleBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der idOertlichkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public TCIDOertlichkeitProxy getIDOertlichkeit() {
        return idOertlichkeit;
    }

    /**
     * Legt den Wert der idOertlichkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDOertlichkeitProxy }
     *     
     */
    public void setIDOertlichkeit(TCIDOertlichkeitProxy value) {
        this.idOertlichkeit = value;
    }

}
