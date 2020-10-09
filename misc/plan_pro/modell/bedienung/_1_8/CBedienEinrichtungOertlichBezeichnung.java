//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bedienung._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBedien_Einrichtung_Oertlich_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Einrichtung_Oertlich_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bedien_Einricht_Oertl_Bez" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}TCBedien_Einricht_Oertl_Bez"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Einrichtung_Oertlich_Bezeichnung", propOrder = {
    "bedienEinrichtOertlBez"
})
public class CBedienEinrichtungOertlichBezeichnung {

    @XmlElement(name = "Bedien_Einricht_Oertl_Bez", required = true)
    protected TCBedienEinrichtOertlBez bedienEinrichtOertlBez;

    /**
     * Ruft den Wert der bedienEinrichtOertlBez-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBedienEinrichtOertlBez }
     *     
     */
    public TCBedienEinrichtOertlBez getBedienEinrichtOertlBez() {
        return bedienEinrichtOertlBez;
    }

    /**
     * Legt den Wert der bedienEinrichtOertlBez-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBedienEinrichtOertlBez }
     *     
     */
    public void setBedienEinrichtOertlBez(TCBedienEinrichtOertlBez value) {
        this.bedienEinrichtOertlBez = value;
    }

}
