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
 * <p>Java-Klasse f�r CSchluessel_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchluessel_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Schluessel_Bartform" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}TCSchluessel_Bartform" minOccurs="0"/>
 *         &lt;element name="Schluessel_Gruppe" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}TCSchluessel_Gruppe"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSchluessel_Allg", propOrder = {
    "schluesselBartform",
    "schluesselGruppe"
})
public class CSchluesselAllg {

    @XmlElement(name = "Schluessel_Bartform")
    protected TCSchluesselBartform schluesselBartform;
    @XmlElement(name = "Schluessel_Gruppe", required = true)
    protected TCSchluesselGruppe schluesselGruppe;

    /**
     * Ruft den Wert der schluesselBartform-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSchluesselBartform }
     *     
     */
    public TCSchluesselBartform getSchluesselBartform() {
        return schluesselBartform;
    }

    /**
     * Legt den Wert der schluesselBartform-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSchluesselBartform }
     *     
     */
    public void setSchluesselBartform(TCSchluesselBartform value) {
        this.schluesselBartform = value;
    }

    /**
     * Ruft den Wert der schluesselGruppe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSchluesselGruppe }
     *     
     */
    public TCSchluesselGruppe getSchluesselGruppe() {
        return schluesselGruppe;
    }

    /**
     * Legt den Wert der schluesselGruppe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSchluesselGruppe }
     *     
     */
    public void setSchluesselGruppe(TCSchluesselGruppe value) {
        this.schluesselGruppe = value;
    }

}
