//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bedienung._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBedien_Zentrale_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Zentrale_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bez_Bed_Zentrale" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}TCBez_Bed_Zentrale"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Zentrale_Bezeichnung", propOrder = {
    "bezBedZentrale"
})
public class CBedienZentraleBezeichnung {

    @XmlElement(name = "Bez_Bed_Zentrale", required = true)
    protected TCBezBedZentrale bezBedZentrale;

    /**
     * Ruft den Wert der bezBedZentrale-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezBedZentrale }
     *     
     */
    public TCBezBedZentrale getBezBedZentrale() {
        return bezBedZentrale;
    }

    /**
     * Legt den Wert der bezBedZentrale-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezBedZentrale }
     *     
     */
    public void setBezBedZentrale(TCBezBedZentrale value) {
        this.bezBedZentrale = value;
    }

}