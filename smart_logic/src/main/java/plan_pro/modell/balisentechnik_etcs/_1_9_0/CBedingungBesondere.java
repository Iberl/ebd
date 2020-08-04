//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBedingung_Besondere complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedingung_Besondere">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Art_Bedingung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCArt_Bedingung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedingung_Besondere", propOrder = {
    "artBedingung"
})
public class CBedingungBesondere {

    @XmlElement(name = "Art_Bedingung", required = true)
    protected TCArtBedingung artBedingung;

    /**
     * Ruft den Wert der artBedingung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCArtBedingung }
     *     
     */
    public TCArtBedingung getArtBedingung() {
        return artBedingung;
    }

    /**
     * Legt den Wert der artBedingung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCArtBedingung }
     *     
     */
    public void setArtBedingung(TCArtBedingung value) {
        this.artBedingung = value;
    }

}
