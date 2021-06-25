//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBUE_Gefahrraum_Eckpunkt_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Gefahrraum_Eckpunkt_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_BUE_GFR_Eckpunkt" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBezeichnung_BUE_GFR_Eckpunkt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Gefahrraum_Eckpunkt_Bezeichnung", propOrder = {
    "bezeichnungBUEGFREckpunkt"
})
public class CBUEGefahrraumEckpunktBezeichnung {

    @XmlElement(name = "Bezeichnung_BUE_GFR_Eckpunkt", required = true)
    protected TCBezeichnungBUEGFREckpunkt bezeichnungBUEGFREckpunkt;

    /**
     * Ruft den Wert der bezeichnungBUEGFREckpunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungBUEGFREckpunkt }
     *     
     */
    public TCBezeichnungBUEGFREckpunkt getBezeichnungBUEGFREckpunkt() {
        return bezeichnungBUEGFREckpunkt;
    }

    /**
     * Legt den Wert der bezeichnungBUEGFREckpunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungBUEGFREckpunkt }
     *     
     */
    public void setBezeichnungBUEGFREckpunkt(TCBezeichnungBUEGFREckpunkt value) {
        this.bezeichnungBUEGFREckpunkt = value;
    }

}
