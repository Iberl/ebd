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
 * <p>Java-Klasse f�r CGFR_Tripelspiegel_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGFR_Tripelspiegel_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_GFR_Tripelspiegel" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBezeichnung_GFR_Tripelspiegel"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGFR_Tripelspiegel_Bezeichnung", propOrder = {
    "bezeichnungGFRTripelspiegel"
})
public class CGFRTripelspiegelBezeichnung {

    @XmlElement(name = "Bezeichnung_GFR_Tripelspiegel", required = true)
    protected TCBezeichnungGFRTripelspiegel bezeichnungGFRTripelspiegel;

    /**
     * Ruft den Wert der bezeichnungGFRTripelspiegel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungGFRTripelspiegel }
     *     
     */
    public TCBezeichnungGFRTripelspiegel getBezeichnungGFRTripelspiegel() {
        return bezeichnungGFRTripelspiegel;
    }

    /**
     * Legt den Wert der bezeichnungGFRTripelspiegel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungGFRTripelspiegel }
     *     
     */
    public void setBezeichnungGFRTripelspiegel(TCBezeichnungGFRTripelspiegel value) {
        this.bezeichnungGFRTripelspiegel = value;
    }

}
