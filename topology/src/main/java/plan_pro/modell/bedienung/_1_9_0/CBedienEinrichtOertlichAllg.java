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
 * <p>Java-Klasse f�r CBedien_Einricht_Oertlich_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Einricht_Oertlich_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bedien_Einricht_Bauart" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCBedien_Einricht_Bauart"/>
 *         &lt;element name="Hupe_Anschaltzeit" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCHupe_Anschaltzeit" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Einricht_Oertlich_Allg", propOrder = {
    "bedienEinrichtBauart",
    "hupeAnschaltzeit"
})
public class CBedienEinrichtOertlichAllg {

    @XmlElement(name = "Bedien_Einricht_Bauart", required = true)
    protected TCBedienEinrichtBauart bedienEinrichtBauart;
    @XmlElement(name = "Hupe_Anschaltzeit")
    protected TCHupeAnschaltzeit hupeAnschaltzeit;

    /**
     * Ruft den Wert der bedienEinrichtBauart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBedienEinrichtBauart }
     *     
     */
    public TCBedienEinrichtBauart getBedienEinrichtBauart() {
        return bedienEinrichtBauart;
    }

    /**
     * Legt den Wert der bedienEinrichtBauart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBedienEinrichtBauart }
     *     
     */
    public void setBedienEinrichtBauart(TCBedienEinrichtBauart value) {
        this.bedienEinrichtBauart = value;
    }

    /**
     * Ruft den Wert der hupeAnschaltzeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHupeAnschaltzeit }
     *     
     */
    public TCHupeAnschaltzeit getHupeAnschaltzeit() {
        return hupeAnschaltzeit;
    }

    /**
     * Legt den Wert der hupeAnschaltzeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHupeAnschaltzeit }
     *     
     */
    public void setHupeAnschaltzeit(TCHupeAnschaltzeit value) {
        this.hupeAnschaltzeit = value;
    }

}
