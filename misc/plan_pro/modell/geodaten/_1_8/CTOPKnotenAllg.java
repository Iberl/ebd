//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.geodaten._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CTOP_Knoten_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CTOP_Knoten_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Art_Besonders" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}TCArt_Besonders" minOccurs="0"/>
 *         &lt;element name="Knotenname" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}TCKnotenname" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTOP_Knoten_Allg", propOrder = {
    "artBesonders",
    "knotenname"
})
public class CTOPKnotenAllg {

    @XmlElement(name = "Art_Besonders")
    protected TCArtBesonders artBesonders;
    @XmlElement(name = "Knotenname")
    protected TCKnotenname knotenname;

    /**
     * Ruft den Wert der artBesonders-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCArtBesonders }
     *     
     */
    public TCArtBesonders getArtBesonders() {
        return artBesonders;
    }

    /**
     * Legt den Wert der artBesonders-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCArtBesonders }
     *     
     */
    public void setArtBesonders(TCArtBesonders value) {
        this.artBesonders = value;
    }

    /**
     * Ruft den Wert der knotenname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKnotenname }
     *     
     */
    public TCKnotenname getKnotenname() {
        return knotenname;
    }

    /**
     * Legt den Wert der knotenname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKnotenname }
     *     
     */
    public void setKnotenname(TCKnotenname value) {
        this.knotenname = value;
    }

}
