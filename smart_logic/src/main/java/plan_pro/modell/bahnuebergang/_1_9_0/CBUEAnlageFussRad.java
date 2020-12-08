//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBUE_Anlage_Fuss_Rad complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Anlage_Fuss_Rad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fuss_Radweg_Art" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCFuss_Radweg_Art"/>
 *         &lt;element name="Fuss_Radweg_Seite" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCFuss_Radweg_Seite"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Anlage_Fuss_Rad", propOrder = {
    "fussRadwegArt",
    "fussRadwegSeite"
})
public class CBUEAnlageFussRad {

    @XmlElement(name = "Fuss_Radweg_Art", required = true)
    protected TCFussRadwegArt fussRadwegArt;
    @XmlElement(name = "Fuss_Radweg_Seite", required = true)
    protected TCFussRadwegSeite fussRadwegSeite;

    /**
     * Ruft den Wert der fussRadwegArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFussRadwegArt }
     *     
     */
    public TCFussRadwegArt getFussRadwegArt() {
        return fussRadwegArt;
    }

    /**
     * Legt den Wert der fussRadwegArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFussRadwegArt }
     *     
     */
    public void setFussRadwegArt(TCFussRadwegArt value) {
        this.fussRadwegArt = value;
    }

    /**
     * Ruft den Wert der fussRadwegSeite-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFussRadwegSeite }
     *     
     */
    public TCFussRadwegSeite getFussRadwegSeite() {
        return fussRadwegSeite;
    }

    /**
     * Legt den Wert der fussRadwegSeite-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFussRadwegSeite }
     *     
     */
    public void setFussRadwegSeite(TCFussRadwegSeite value) {
        this.fussRadwegSeite = value;
    }

}
