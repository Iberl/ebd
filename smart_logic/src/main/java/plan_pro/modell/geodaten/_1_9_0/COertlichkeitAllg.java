//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r COertlichkeit_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="COertlichkeit_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Oertlichkeit_Art" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCOertlichkeit_Art"/>
 *         &lt;element name="Oertlichkeit_Gueltig_Ab" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCOertlichkeit_Gueltig_Ab" minOccurs="0"/>
 *         &lt;element name="Oertlichkeit_Gueltig_Bis" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCOertlichkeit_Gueltig_Bis" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COertlichkeit_Allg", propOrder = {
    "oertlichkeitArt",
    "oertlichkeitGueltigAb",
    "oertlichkeitGueltigBis"
})
public class COertlichkeitAllg {

    @XmlElement(name = "Oertlichkeit_Art", required = true)
    protected TCOertlichkeitArt oertlichkeitArt;
    @XmlElement(name = "Oertlichkeit_Gueltig_Ab")
    protected TCOertlichkeitGueltigAb oertlichkeitGueltigAb;
    @XmlElement(name = "Oertlichkeit_Gueltig_Bis")
    protected TCOertlichkeitGueltigBis oertlichkeitGueltigBis;

    /**
     * Ruft den Wert der oertlichkeitArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCOertlichkeitArt }
     *     
     */
    public TCOertlichkeitArt getOertlichkeitArt() {
        return oertlichkeitArt;
    }

    /**
     * Legt den Wert der oertlichkeitArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCOertlichkeitArt }
     *     
     */
    public void setOertlichkeitArt(TCOertlichkeitArt value) {
        this.oertlichkeitArt = value;
    }

    /**
     * Ruft den Wert der oertlichkeitGueltigAb-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCOertlichkeitGueltigAb }
     *     
     */
    public TCOertlichkeitGueltigAb getOertlichkeitGueltigAb() {
        return oertlichkeitGueltigAb;
    }

    /**
     * Legt den Wert der oertlichkeitGueltigAb-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCOertlichkeitGueltigAb }
     *     
     */
    public void setOertlichkeitGueltigAb(TCOertlichkeitGueltigAb value) {
        this.oertlichkeitGueltigAb = value;
    }

    /**
     * Ruft den Wert der oertlichkeitGueltigBis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCOertlichkeitGueltigBis }
     *     
     */
    public TCOertlichkeitGueltigBis getOertlichkeitGueltigBis() {
        return oertlichkeitGueltigBis;
    }

    /**
     * Legt den Wert der oertlichkeitGueltigBis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCOertlichkeitGueltigBis }
     *     
     */
    public void setOertlichkeitGueltigBis(TCOertlichkeitGueltigBis value) {
        this.oertlichkeitGueltigBis = value;
    }

}
