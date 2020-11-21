//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBedingung_Sonstige complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedingung_Sonstige">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Anlagenteil_Sonstige" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCAnlagenteil_Sonstige"/>
 *         &lt;element name="Text_Bedingung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCText_Bedingung" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedingung_Sonstige", propOrder = {
    "anlagenteilSonstige",
    "textBedingung"
})
public class CBedingungSonstige {

    @XmlElement(name = "Anlagenteil_Sonstige", required = true)
    protected TCAnlagenteilSonstige anlagenteilSonstige;
    @XmlElement(name = "Text_Bedingung")
    protected TCTextBedingung textBedingung;

    /**
     * Ruft den Wert der anlagenteilSonstige-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAnlagenteilSonstige }
     *     
     */
    public TCAnlagenteilSonstige getAnlagenteilSonstige() {
        return anlagenteilSonstige;
    }

    /**
     * Legt den Wert der anlagenteilSonstige-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAnlagenteilSonstige }
     *     
     */
    public void setAnlagenteilSonstige(TCAnlagenteilSonstige value) {
        this.anlagenteilSonstige = value;
    }

    /**
     * Ruft den Wert der textBedingung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTextBedingung }
     *     
     */
    public TCTextBedingung getTextBedingung() {
        return textBedingung;
    }

    /**
     * Legt den Wert der textBedingung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTextBedingung }
     *     
     */
    public void setTextBedingung(TCTextBedingung value) {
        this.textBedingung = value;
    }

}
