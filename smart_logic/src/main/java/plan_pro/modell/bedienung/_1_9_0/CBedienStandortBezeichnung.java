//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBedien_Standort_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Standort_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_BSO" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCBezeichnung_BSO"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Standort_Bezeichnung", propOrder = {
    "bezeichnungBSO"
})
public class CBedienStandortBezeichnung {

    @XmlElement(name = "Bezeichnung_BSO", required = true)
    protected TCBezeichnungBSO bezeichnungBSO;

    /**
     * Ruft den Wert der bezeichnungBSO-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungBSO }
     *     
     */
    public TCBezeichnungBSO getBezeichnungBSO() {
        return bezeichnungBSO;
    }

    /**
     * Legt den Wert der bezeichnungBSO-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungBSO }
     *     
     */
    public void setBezeichnungBSO(TCBezeichnungBSO value) {
        this.bezeichnungBSO = value;
    }

}
