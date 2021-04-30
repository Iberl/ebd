//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CVerkehrszeichen_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CVerkehrszeichen_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_Verkehrszeichen" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBezeichnung_Verkehrszeichen"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CVerkehrszeichen_Bezeichnung", propOrder = {
    "bezeichnungVerkehrszeichen"
})
public class CVerkehrszeichenBezeichnung {

    @XmlElement(name = "Bezeichnung_Verkehrszeichen", required = true)
    protected TCBezeichnungVerkehrszeichen bezeichnungVerkehrszeichen;

    /**
     * Ruft den Wert der bezeichnungVerkehrszeichen-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungVerkehrszeichen }
     *     
     */
    public TCBezeichnungVerkehrszeichen getBezeichnungVerkehrszeichen() {
        return bezeichnungVerkehrszeichen;
    }

    /**
     * Legt den Wert der bezeichnungVerkehrszeichen-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungVerkehrszeichen }
     *     
     */
    public void setBezeichnungVerkehrszeichen(TCBezeichnungVerkehrszeichen value) {
        this.bezeichnungVerkehrszeichen = value;
    }

}
