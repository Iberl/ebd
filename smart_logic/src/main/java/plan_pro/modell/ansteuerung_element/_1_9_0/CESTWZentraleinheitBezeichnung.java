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
 * <p>Java-Klasse f�r CESTW_Zentraleinheit_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CESTW_Zentraleinheit_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_ESTW_ZE" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCBezeichnung_ESTW_ZE"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CESTW_Zentraleinheit_Bezeichnung", propOrder = {
    "bezeichnungESTWZE"
})
public class CESTWZentraleinheitBezeichnung {

    @XmlElement(name = "Bezeichnung_ESTW_ZE", required = true)
    protected TCBezeichnungESTWZE bezeichnungESTWZE;

    /**
     * Ruft den Wert der bezeichnungESTWZE-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungESTWZE }
     *     
     */
    public TCBezeichnungESTWZE getBezeichnungESTWZE() {
        return bezeichnungESTWZE;
    }

    /**
     * Legt den Wert der bezeichnungESTWZE-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungESTWZE }
     *     
     */
    public void setBezeichnungESTWZE(TCBezeichnungESTWZE value) {
        this.bezeichnungESTWZE = value;
    }

}
