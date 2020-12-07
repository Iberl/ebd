//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.gleis._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CGleis_Bezeichnung_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGleis_Bezeichnung_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bez_Gleis_Bezeichnung" type="{http://www.plan-pro.org/modell/Gleis/1.9.0.2}TCBez_Gleis_Bezeichnung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGleis_Bezeichnung_Bezeichnung", propOrder = {
    "bezGleisBezeichnung"
})
public class CGleisBezeichnungBezeichnung {

    @XmlElement(name = "Bez_Gleis_Bezeichnung", required = true)
    protected TCBezGleisBezeichnung bezGleisBezeichnung;

    /**
     * Ruft den Wert der bezGleisBezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezGleisBezeichnung }
     *     
     */
    public TCBezGleisBezeichnung getBezGleisBezeichnung() {
        return bezGleisBezeichnung;
    }

    /**
     * Legt den Wert der bezGleisBezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezGleisBezeichnung }
     *     
     */
    public void setBezGleisBezeichnung(TCBezGleisBezeichnung value) {
        this.bezGleisBezeichnung = value;
    }

}
