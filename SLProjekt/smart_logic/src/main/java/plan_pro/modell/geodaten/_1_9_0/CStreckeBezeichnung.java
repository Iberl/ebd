//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CStrecke_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CStrecke_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_Strecke" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCBezeichnung_Strecke"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CStrecke_Bezeichnung", propOrder = {
    "bezeichnungStrecke"
})
public class CStreckeBezeichnung {

    @XmlElement(name = "Bezeichnung_Strecke", required = true)
    protected TCBezeichnungStrecke bezeichnungStrecke;

    /**
     * Ruft den Wert der bezeichnungStrecke-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungStrecke }
     *     
     */
    public TCBezeichnungStrecke getBezeichnungStrecke() {
        return bezeichnungStrecke;
    }

    /**
     * Legt den Wert der bezeichnungStrecke-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungStrecke }
     *     
     */
    public void setBezeichnungStrecke(TCBezeichnungStrecke value) {
        this.bezeichnungStrecke = value;
    }

}
