//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ansteuerung_element._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Bezeichnung des Technikstandorts
 * 
 * <p>Java-Klasse f�r CTechnik_Standort_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CTechnik_Standort_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_TSO" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCBezeichnung_TSO"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTechnik_Standort_Bezeichnung", propOrder = {
    "bezeichnungTSO"
})
public class CTechnikStandortBezeichnung {

    @XmlElement(name = "Bezeichnung_TSO", required = true)
    protected TCBezeichnungTSO bezeichnungTSO;

    /**
     * Ruft den Wert der bezeichnungTSO-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungTSO }
     *     
     */
    public TCBezeichnungTSO getBezeichnungTSO() {
        return bezeichnungTSO;
    }

    /**
     * Legt den Wert der bezeichnungTSO-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungTSO }
     *     
     */
    public void setBezeichnungTSO(TCBezeichnungTSO value) {
        this.bezeichnungTSO = value;
    }

}
