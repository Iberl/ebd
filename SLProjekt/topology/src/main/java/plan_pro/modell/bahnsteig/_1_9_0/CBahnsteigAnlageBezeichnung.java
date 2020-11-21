//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnsteig._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBahnsteig_Anlage_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBahnsteig_Anlage_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_Bahnsteig_Anlage" type="{http://www.plan-pro.org/modell/Bahnsteig/1.9.0.2}TCBezeichnung_Bahnsteig_Anlage"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBahnsteig_Anlage_Bezeichnung", propOrder = {
    "bezeichnungBahnsteigAnlage"
})
public class CBahnsteigAnlageBezeichnung {

    @XmlElement(name = "Bezeichnung_Bahnsteig_Anlage", required = true)
    protected TCBezeichnungBahnsteigAnlage bezeichnungBahnsteigAnlage;

    /**
     * Ruft den Wert der bezeichnungBahnsteigAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungBahnsteigAnlage }
     *     
     */
    public TCBezeichnungBahnsteigAnlage getBezeichnungBahnsteigAnlage() {
        return bezeichnungBahnsteigAnlage;
    }

    /**
     * Legt den Wert der bezeichnungBahnsteigAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungBahnsteigAnlage }
     *     
     */
    public void setBezeichnungBahnsteigAnlage(TCBezeichnungBahnsteigAnlage value) {
        this.bezeichnungBahnsteigAnlage = value;
    }

}
