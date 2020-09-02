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
 * <p>Java-Klasse f�r CSchrankenantrieb_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchrankenantrieb_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bez_Schrankenantrieb" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCBez_Schrankenantrieb"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSchrankenantrieb_Bezeichnung", propOrder = {
    "bezSchrankenantrieb"
})
public class CSchrankenantriebBezeichnung {

    @XmlElement(name = "Bez_Schrankenantrieb", required = true)
    protected TCBezSchrankenantrieb bezSchrankenantrieb;

    /**
     * Ruft den Wert der bezSchrankenantrieb-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezSchrankenantrieb }
     *     
     */
    public TCBezSchrankenantrieb getBezSchrankenantrieb() {
        return bezSchrankenantrieb;
    }

    /**
     * Legt den Wert der bezSchrankenantrieb-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezSchrankenantrieb }
     *     
     */
    public void setBezSchrankenantrieb(TCBezSchrankenantrieb value) {
        this.bezSchrankenantrieb = value;
    }

}
