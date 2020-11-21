//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBedien_Oertlichkeit_Kennzahlen complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Oertlichkeit_Kennzahlen">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Betriebsstellenbezeichner" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCBetriebsstellenbezeichner"/>
 *         &lt;element name="Kennzahl" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCKennzahl"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Oertlichkeit_Kennzahlen", propOrder = {
    "betriebsstellenbezeichner",
    "kennzahl"
})
public class CBedienOertlichkeitKennzahlen {

    @XmlElement(name = "Betriebsstellenbezeichner", required = true)
    protected TCBetriebsstellenbezeichner betriebsstellenbezeichner;
    @XmlElement(name = "Kennzahl", required = true)
    protected TCKennzahl kennzahl;

    /**
     * Ruft den Wert der betriebsstellenbezeichner-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBetriebsstellenbezeichner }
     *     
     */
    public TCBetriebsstellenbezeichner getBetriebsstellenbezeichner() {
        return betriebsstellenbezeichner;
    }

    /**
     * Legt den Wert der betriebsstellenbezeichner-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBetriebsstellenbezeichner }
     *     
     */
    public void setBetriebsstellenbezeichner(TCBetriebsstellenbezeichner value) {
        this.betriebsstellenbezeichner = value;
    }

    /**
     * Ruft den Wert der kennzahl-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKennzahl }
     *     
     */
    public TCKennzahl getKennzahl() {
        return kennzahl;
    }

    /**
     * Legt den Wert der kennzahl-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKennzahl }
     *     
     */
    public void setKennzahl(TCKennzahl value) {
        this.kennzahl = value;
    }

}
