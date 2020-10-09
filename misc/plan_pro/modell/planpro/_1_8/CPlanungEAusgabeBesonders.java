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
 * <p>Java-Klasse f�r CPlanung_E_Ausgabe_Besonders complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPlanung_E_Ausgabe_Besonders">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Referenz_Vergleich_Besonders" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCReferenz_Vergleich_Besonders"/>
 *         &lt;element name="Vergleich_Ausgabestand_Basis" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCVergleich_Ausgabestand_Basis"/>
 *         &lt;element name="Vergleichstyp_Besonders" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCVergleichstyp_Besonders"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPlanung_E_Ausgabe_Besonders", propOrder = {
    "referenzVergleichBesonders",
    "vergleichAusgabestandBasis",
    "vergleichstypBesonders"
})
public class CPlanungEAusgabeBesonders {

    @XmlElement(name = "Referenz_Vergleich_Besonders", required = true)
    protected TCReferenzVergleichBesonders referenzVergleichBesonders;
    @XmlElement(name = "Vergleich_Ausgabestand_Basis", required = true)
    protected TCVergleichAusgabestandBasis vergleichAusgabestandBasis;
    @XmlElement(name = "Vergleichstyp_Besonders", required = true)
    protected TCVergleichstypBesonders vergleichstypBesonders;

    /**
     * Ruft den Wert der referenzVergleichBesonders-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCReferenzVergleichBesonders }
     *     
     */
    public TCReferenzVergleichBesonders getReferenzVergleichBesonders() {
        return referenzVergleichBesonders;
    }

    /**
     * Legt den Wert der referenzVergleichBesonders-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCReferenzVergleichBesonders }
     *     
     */
    public void setReferenzVergleichBesonders(TCReferenzVergleichBesonders value) {
        this.referenzVergleichBesonders = value;
    }

    /**
     * Ruft den Wert der vergleichAusgabestandBasis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVergleichAusgabestandBasis }
     *     
     */
    public TCVergleichAusgabestandBasis getVergleichAusgabestandBasis() {
        return vergleichAusgabestandBasis;
    }

    /**
     * Legt den Wert der vergleichAusgabestandBasis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVergleichAusgabestandBasis }
     *     
     */
    public void setVergleichAusgabestandBasis(TCVergleichAusgabestandBasis value) {
        this.vergleichAusgabestandBasis = value;
    }

    /**
     * Ruft den Wert der vergleichstypBesonders-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVergleichstypBesonders }
     *     
     */
    public TCVergleichstypBesonders getVergleichstypBesonders() {
        return vergleichstypBesonders;
    }

    /**
     * Legt den Wert der vergleichstypBesonders-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVergleichstypBesonders }
     *     
     */
    public void setVergleichstypBesonders(TCVergleichstypBesonders value) {
        this.vergleichstypBesonders = value;
    }

}
