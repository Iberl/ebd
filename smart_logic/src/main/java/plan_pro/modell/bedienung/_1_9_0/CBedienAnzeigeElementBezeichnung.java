//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBedien_Anzeige_Element_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Anzeige_Element_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bez_Bed_Anzeige_Element" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCBez_Bed_Anzeige_Element"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Anzeige_Element_Bezeichnung", propOrder = {
    "bezBedAnzeigeElement"
})
public class CBedienAnzeigeElementBezeichnung {

    @XmlElement(name = "Bez_Bed_Anzeige_Element", required = true)
    protected TCBezBedAnzeigeElement bezBedAnzeigeElement;

    /**
     * Ruft den Wert der bezBedAnzeigeElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezBedAnzeigeElement }
     *     
     */
    public TCBezBedAnzeigeElement getBezBedAnzeigeElement() {
        return bezBedAnzeigeElement;
    }

    /**
     * Legt den Wert der bezBedAnzeigeElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezBedAnzeigeElement }
     *     
     */
    public void setBezBedAnzeigeElement(TCBezBedAnzeigeElement value) {
        this.bezBedAnzeigeElement = value;
    }

}
