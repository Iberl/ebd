//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.medien_und_trassen._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CKabel_Verteilpunkt_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CKabel_Verteilpunkt_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung_Kabel_Verteilpunkt" type="{http://www.plan-pro.org/modell/Medien_und_Trassen/1.9.0.2}TCBezeichnung_Kabel_Verteilpunkt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CKabel_Verteilpunkt_Bezeichnung", propOrder = {
    "bezeichnungKabelVerteilpunkt"
})
public class CKabelVerteilpunktBezeichnung {

    @XmlElement(name = "Bezeichnung_Kabel_Verteilpunkt", required = true)
    protected TCBezeichnungKabelVerteilpunkt bezeichnungKabelVerteilpunkt;

    /**
     * Ruft den Wert der bezeichnungKabelVerteilpunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezeichnungKabelVerteilpunkt }
     *     
     */
    public TCBezeichnungKabelVerteilpunkt getBezeichnungKabelVerteilpunkt() {
        return bezeichnungKabelVerteilpunkt;
    }

    /**
     * Legt den Wert der bezeichnungKabelVerteilpunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezeichnungKabelVerteilpunkt }
     *     
     */
    public void setBezeichnungKabelVerteilpunkt(TCBezeichnungKabelVerteilpunkt value) {
        this.bezeichnungKabelVerteilpunkt = value;
    }

}
