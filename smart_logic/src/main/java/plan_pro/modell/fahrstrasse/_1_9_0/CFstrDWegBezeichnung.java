//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFstr_DWeg_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_DWeg_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_Fstr_DWeg" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCBezeichnung_Fstr_DWeg"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_DWeg_Bezeichnung", propOrder = {
    "bezeichnungFstrDWeg"
})
public class CFstrDWegBezeichnung {

    @XmlElement(name = "Bezeichnung_Fstr_DWeg", required = true)
    protected TCBezeichnungFstrDWeg bezeichnungFstrDWeg;

    /**
     * Ruft den Wert der bezeichnungFstrDWeg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungFstrDWeg }
     *     
     */
    public TCBezeichnungFstrDWeg getBezeichnungFstrDWeg() {
        return bezeichnungFstrDWeg;
    }

    /**
     * Legt den Wert der bezeichnungFstrDWeg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungFstrDWeg }
     *     
     */
    public void setBezeichnungFstrDWeg(TCBezeichnungFstrDWeg value) {
        this.bezeichnungFstrDWeg = value;
    }

}
