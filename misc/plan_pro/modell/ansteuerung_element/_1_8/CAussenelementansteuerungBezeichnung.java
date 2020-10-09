//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.ansteuerung_element._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CAussenelementansteuerung_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CAussenelementansteuerung_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_AEA" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}TCBezeichnung_AEA"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CAussenelementansteuerung_Bezeichnung", propOrder = {
    "bezeichnungAEA"
})
public class CAussenelementansteuerungBezeichnung {

    @XmlElement(name = "Bezeichnung_AEA", required = true)
    protected TCBezeichnungAEA bezeichnungAEA;

    /**
     * Ruft den Wert der bezeichnungAEA-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungAEA }
     *     
     */
    public TCBezeichnungAEA getBezeichnungAEA() {
        return bezeichnungAEA;
    }

    /**
     * Legt den Wert der bezeichnungAEA-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungAEA }
     *     
     */
    public void setBezeichnungAEA(TCBezeichnungAEA value) {
        this.bezeichnungAEA = value;
    }

}
