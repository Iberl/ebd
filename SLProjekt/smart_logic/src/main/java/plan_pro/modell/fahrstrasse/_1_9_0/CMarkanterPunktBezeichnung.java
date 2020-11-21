//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CMarkanter_Punkt_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CMarkanter_Punkt_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_Markanter_Punkt" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCBezeichnung_Markanter_Punkt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CMarkanter_Punkt_Bezeichnung", propOrder = {
    "bezeichnungMarkanterPunkt"
})
public class CMarkanterPunktBezeichnung {

    @XmlElement(name = "Bezeichnung_Markanter_Punkt", required = true)
    protected TCBezeichnungMarkanterPunkt bezeichnungMarkanterPunkt;

    /**
     * Ruft den Wert der bezeichnungMarkanterPunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungMarkanterPunkt }
     *     
     */
    public TCBezeichnungMarkanterPunkt getBezeichnungMarkanterPunkt() {
        return bezeichnungMarkanterPunkt;
    }

    /**
     * Legt den Wert der bezeichnungMarkanterPunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungMarkanterPunkt }
     *     
     */
    public void setBezeichnungMarkanterPunkt(TCBezeichnungMarkanterPunkt value) {
        this.bezeichnungMarkanterPunkt = value;
    }

}
