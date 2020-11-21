//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDGFRAnlageOhneProxy;
import plan_pro.modell.verweise._1_9_0.TCIDUnterbringungOhneProxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Detektor der GFR-Anlage (z. B. Radar). Elemente f�r eine Kamera-�berwachung sind  Bestandteil TK-Ausr�stung und werden daher nicht abgebildet.
 * 
 * <p>Java-Klasse f�r CGFR_Element complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGFR_Element">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}CGFR_Element_Bezeichnung"/>
 *         &lt;element name="ID_GFR_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_GFR_Anlage_ohne_Proxy"/>
 *         &lt;element name="ID_Unterbringung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Unterbringung_ohne_Proxy"/>
 *         &lt;choice>
 *           &lt;element name="BUE_Neigung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBUE_Neigung" minOccurs="0"/>
 *           &lt;element name="GFR_Neigung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCGFR_Neigung" minOccurs="0"/>
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
@XmlType(name = "CGFR_Element", propOrder = {
    "bezeichnung",
    "idgfrAnlage",
    "idUnterbringung",
    "bueNeigung",
    "gfrNeigung"
})
public class CGFRElement
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CGFRElementBezeichnung bezeichnung;
    @XmlElement(name = "ID_GFR_Anlage", required = true)
    protected TCIDGFRAnlageOhneProxy idgfrAnlage;
    @XmlElement(name = "ID_Unterbringung", required = true)
    protected TCIDUnterbringungOhneProxy idUnterbringung;
    @XmlElement(name = "BUE_Neigung")
    protected TCBUENeigung bueNeigung;
    @XmlElement(name = "GFR_Neigung")
    protected TCGFRNeigung gfrNeigung;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CGFRElementBezeichnung }
     *     
     */
    public CGFRElementBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CGFRElementBezeichnung }
     *     
     */
    public void setBezeichnung(CGFRElementBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der idgfrAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDGFRAnlageOhneProxy }
     *     
     */
    public TCIDGFRAnlageOhneProxy getIDGFRAnlage() {
        return idgfrAnlage;
    }

    /**
     * Legt den Wert der idgfrAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDGFRAnlageOhneProxy }
     *     
     */
    public void setIDGFRAnlage(TCIDGFRAnlageOhneProxy value) {
        this.idgfrAnlage = value;
    }

    /**
     * Ruft den Wert der idUnterbringung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDUnterbringungOhneProxy }
     *     
     */
    public TCIDUnterbringungOhneProxy getIDUnterbringung() {
        return idUnterbringung;
    }

    /**
     * Legt den Wert der idUnterbringung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDUnterbringungOhneProxy }
     *     
     */
    public void setIDUnterbringung(TCIDUnterbringungOhneProxy value) {
        this.idUnterbringung = value;
    }

    /**
     * Ruft den Wert der bueNeigung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBUENeigung }
     *     
     */
    public TCBUENeigung getBUENeigung() {
        return bueNeigung;
    }

    /**
     * Legt den Wert der bueNeigung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBUENeigung }
     *     
     */
    public void setBUENeigung(TCBUENeigung value) {
        this.bueNeigung = value;
    }

    /**
     * Ruft den Wert der gfrNeigung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGFRNeigung }
     *     
     */
    public TCGFRNeigung getGFRNeigung() {
        return gfrNeigung;
    }

    /**
     * Legt den Wert der gfrNeigung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGFRNeigung }
     *     
     */
    public void setGFRNeigung(TCGFRNeigung value) {
        this.gfrNeigung = value;
    }

}
