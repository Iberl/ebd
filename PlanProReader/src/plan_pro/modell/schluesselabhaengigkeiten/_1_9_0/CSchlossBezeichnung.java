//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.schluesselabhaengigkeiten._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSchloss_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchloss_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_Schloss" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}TCBezeichnung_Schloss"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSchloss_Bezeichnung", propOrder = {
    "bezeichnungSchloss"
})
public class CSchlossBezeichnung {

    @XmlElement(name = "Bezeichnung_Schloss", required = true)
    protected TCBezeichnungSchloss bezeichnungSchloss;

    /**
     * Ruft den Wert der bezeichnungSchloss-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungSchloss }
     *     
     */
    public TCBezeichnungSchloss getBezeichnungSchloss() {
        return bezeichnungSchloss;
    }

    /**
     * Legt den Wert der bezeichnungSchloss-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungSchloss }
     *     
     */
    public void setBezeichnungSchloss(TCBezeichnungSchloss value) {
        this.bezeichnungSchloss = value;
    }

}
