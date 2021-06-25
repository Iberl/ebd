//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.schluesselabhaengigkeiten._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSchluessel_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchluessel_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_Schluessel" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}TCBezeichnung_Schluessel"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSchluessel_Bezeichnung", propOrder = {
    "bezeichnungSchluessel"
})
public class CSchluesselBezeichnung {

    @XmlElement(name = "Bezeichnung_Schluessel", required = true)
    protected TCBezeichnungSchluessel bezeichnungSchluessel;

    /**
     * Ruft den Wert der bezeichnungSchluessel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungSchluessel }
     *     
     */
    public TCBezeichnungSchluessel getBezeichnungSchluessel() {
        return bezeichnungSchluessel;
    }

    /**
     * Legt den Wert der bezeichnungSchluessel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungSchluessel }
     *     
     */
    public void setBezeichnungSchluessel(TCBezeichnungSchluessel value) {
        this.bezeichnungSchluessel = value;
    }

}
