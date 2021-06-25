//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.planpro._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CAnhang;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CPlanung_G_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPlanung_G_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Anhang_BAST" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CAnhang" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Datum_Abschluss_Gruppe" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCDatum_Abschluss_Gruppe"/>
 *         &lt;element name="PlanPro_XSD_Version" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCPlanPro_XSD_Version"/>
 *         &lt;element name="Planung_G_Art_Besonders" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCPlanung_G_Art_Besonders" minOccurs="0"/>
 *         &lt;element name="Untergewerk_Art" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCUntergewerk_Art"/>
 *         &lt;element name="Verantwortliche_Stelle_DB" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCVerantwortliche_Stelle_DB" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPlanung_G_Allg", propOrder = {
    "anhangBAST",
    "datumAbschlussGruppe",
    "planProXSDVersion",
    "planungGArtBesonders",
    "untergewerkArt",
    "verantwortlicheStelleDB"
})
public class CPlanungGAllg {

    @XmlElement(name = "Anhang_BAST")
    protected List<CAnhang> anhangBAST;
    @XmlElement(name = "Datum_Abschluss_Gruppe", required = true)
    protected TCDatumAbschlussGruppe datumAbschlussGruppe;
    @XmlElement(name = "PlanPro_XSD_Version", required = true)
    protected TCPlanProXSDVersion planProXSDVersion;
    @XmlElement(name = "Planung_G_Art_Besonders")
    protected TCPlanungGArtBesonders planungGArtBesonders;
    @XmlElement(name = "Untergewerk_Art", required = true)
    protected TCUntergewerkArt untergewerkArt;
    @XmlElement(name = "Verantwortliche_Stelle_DB")
    protected TCVerantwortlicheStelleDB verantwortlicheStelleDB;

    /**
     * Gets the value of the anhangBAST property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anhangBAST property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnhangBAST().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CAnhang }
     * 
     * 
     */
    public List<CAnhang> getAnhangBAST() {
        if (anhangBAST == null) {
            anhangBAST = new ArrayList<CAnhang>();
        }
        return this.anhangBAST;
    }

    /**
     * Ruft den Wert der datumAbschlussGruppe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDatumAbschlussGruppe }
     *     
     */
    public TCDatumAbschlussGruppe getDatumAbschlussGruppe() {
        return datumAbschlussGruppe;
    }

    /**
     * Legt den Wert der datumAbschlussGruppe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDatumAbschlussGruppe }
     *     
     */
    public void setDatumAbschlussGruppe(TCDatumAbschlussGruppe value) {
        this.datumAbschlussGruppe = value;
    }

    /**
     * Ruft den Wert der planProXSDVersion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPlanProXSDVersion }
     *     
     */
    public TCPlanProXSDVersion getPlanProXSDVersion() {
        return planProXSDVersion;
    }

    /**
     * Legt den Wert der planProXSDVersion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPlanProXSDVersion }
     *     
     */
    public void setPlanProXSDVersion(TCPlanProXSDVersion value) {
        this.planProXSDVersion = value;
    }

    /**
     * Ruft den Wert der planungGArtBesonders-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPlanungGArtBesonders }
     *     
     */
    public TCPlanungGArtBesonders getPlanungGArtBesonders() {
        return planungGArtBesonders;
    }

    /**
     * Legt den Wert der planungGArtBesonders-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPlanungGArtBesonders }
     *     
     */
    public void setPlanungGArtBesonders(TCPlanungGArtBesonders value) {
        this.planungGArtBesonders = value;
    }

    /**
     * Ruft den Wert der untergewerkArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUntergewerkArt }
     *     
     */
    public TCUntergewerkArt getUntergewerkArt() {
        return untergewerkArt;
    }

    /**
     * Legt den Wert der untergewerkArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUntergewerkArt }
     *     
     */
    public void setUntergewerkArt(TCUntergewerkArt value) {
        this.untergewerkArt = value;
    }

    /**
     * Ruft den Wert der verantwortlicheStelleDB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVerantwortlicheStelleDB }
     *     
     */
    public TCVerantwortlicheStelleDB getVerantwortlicheStelleDB() {
        return verantwortlicheStelleDB;
    }

    /**
     * Legt den Wert der verantwortlicheStelleDB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVerantwortlicheStelleDB }
     *     
     */
    public void setVerantwortlicheStelleDB(TCVerantwortlicheStelleDB value) {
        this.verantwortlicheStelleDB = value;
    }

}
