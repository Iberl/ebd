//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDAnhang;
import plan_pro.modell.verweise._1_9_0.TCIDBedienBezirk;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Planung aller Parameter, die f�r die Darstellung der Gleisbenutzungstabelle (GBT) auf dem Bedienplatz f�r den Nutzer erforderlich sind.
 * 
 * <p>Java-Klasse f�r CBedien_GBT complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_GBT">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bedien_GBT_Allg" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}CBedien_GBT_Allg"/>
 *         &lt;element name="ID_Anhang_Vorgabe_GBT" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang" minOccurs="0"/>
 *         &lt;element name="ID_Bedien_Bezirk" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Bedien_Bezirk"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_GBT", propOrder = {
    "bedienGBTAllg",
    "idAnhangVorgabeGBT",
    "idBedienBezirk"
})
public class CBedienGBT
    extends CBasisObjekt
{

    @XmlElement(name = "Bedien_GBT_Allg", required = true)
    protected CBedienGBTAllg bedienGBTAllg;
    @XmlElement(name = "ID_Anhang_Vorgabe_GBT")
    protected TCIDAnhang idAnhangVorgabeGBT;
    @XmlElement(name = "ID_Bedien_Bezirk", required = true)
    protected TCIDBedienBezirk idBedienBezirk;

    /**
     * Ruft den Wert der bedienGBTAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBedienGBTAllg }
     *     
     */
    public CBedienGBTAllg getBedienGBTAllg() {
        return bedienGBTAllg;
    }

    /**
     * Legt den Wert der bedienGBTAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBedienGBTAllg }
     *     
     */
    public void setBedienGBTAllg(CBedienGBTAllg value) {
        this.bedienGBTAllg = value;
    }

    /**
     * Ruft den Wert der idAnhangVorgabeGBT-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangVorgabeGBT() {
        return idAnhangVorgabeGBT;
    }

    /**
     * Legt den Wert der idAnhangVorgabeGBT-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangVorgabeGBT(TCIDAnhang value) {
        this.idAnhangVorgabeGBT = value;
    }

    /**
     * Ruft den Wert der idBedienBezirk-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBedienBezirk }
     *     
     */
    public TCIDBedienBezirk getIDBedienBezirk() {
        return idBedienBezirk;
    }

    /**
     * Legt den Wert der idBedienBezirk-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBedienBezirk }
     *     
     */
    public void setIDBedienBezirk(TCIDBedienBezirk value) {
        this.idBedienBezirk = value;
    }

}
