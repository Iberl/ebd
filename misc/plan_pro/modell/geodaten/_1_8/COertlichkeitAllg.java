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
 * <p>Java-Klasse f�r COertlichkeit_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="COertlichkeit_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Oertlichkeit_Abkuerzung" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}TCOertlichkeit_Abkuerzung" minOccurs="0"/>
 *         &lt;element name="Oertlichkeit_Art" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}TCOertlichkeit_Art" minOccurs="0"/>
 *         &lt;element name="Oertlichkeit_Gueltig_Ab" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}TCOertlichkeit_Gueltig_Ab" minOccurs="0"/>
 *         &lt;element name="Oertlichkeit_Gueltig_Bis" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}TCOertlichkeit_Gueltig_Bis" minOccurs="0"/>
 *         &lt;element name="Oertlichkeit_Kurzname" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}TCOertlichkeit_Kurzname" minOccurs="0"/>
 *         &lt;element name="Oertlichkeit_Langname" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}TCOertlichkeit_Langname"/>
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
    "oertlichkeitAbkuerzung",
    "oertlichkeitArt",
    "oertlichkeitGueltigAb",
    "oertlichkeitGueltigBis",
    "oertlichkeitKurzname",
    "oertlichkeitLangname"
})
public class COertlichkeitAllg {

    @XmlElement(name = "Oertlichkeit_Abkuerzung")
    protected TCOertlichkeitAbkuerzung oertlichkeitAbkuerzung;
    @XmlElement(name = "Oertlichkeit_Art")
    protected TCOertlichkeitArt oertlichkeitArt;
    @XmlElement(name = "Oertlichkeit_Gueltig_Ab")
    protected TCOertlichkeitGueltigAb oertlichkeitGueltigAb;
    @XmlElement(name = "Oertlichkeit_Gueltig_Bis")
    protected TCOertlichkeitGueltigBis oertlichkeitGueltigBis;
    @XmlElement(name = "Oertlichkeit_Kurzname")
    protected TCOertlichkeitKurzname oertlichkeitKurzname;
    @XmlElement(name = "Oertlichkeit_Langname", required = true)
    protected TCOertlichkeitLangname oertlichkeitLangname;

    /**
     * Ruft den Wert der oertlichkeitAbkuerzung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCOertlichkeitAbkuerzung }
     *     
     */
    public TCOertlichkeitAbkuerzung getOertlichkeitAbkuerzung() {
        return oertlichkeitAbkuerzung;
    }

    /**
     * Legt den Wert der oertlichkeitAbkuerzung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCOertlichkeitAbkuerzung }
     *     
     */
    public void setOertlichkeitAbkuerzung(TCOertlichkeitAbkuerzung value) {
        this.oertlichkeitAbkuerzung = value;
    }

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

    /**
     * Ruft den Wert der oertlichkeitKurzname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCOertlichkeitKurzname }
     *     
     */
    public TCOertlichkeitKurzname getOertlichkeitKurzname() {
        return oertlichkeitKurzname;
    }

    /**
     * Legt den Wert der oertlichkeitKurzname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCOertlichkeitKurzname }
     *     
     */
    public void setOertlichkeitKurzname(TCOertlichkeitKurzname value) {
        this.oertlichkeitKurzname = value;
    }

    /**
     * Ruft den Wert der oertlichkeitLangname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCOertlichkeitLangname }
     *     
     */
    public TCOertlichkeitLangname getOertlichkeitLangname() {
        return oertlichkeitLangname;
    }

    /**
     * Legt den Wert der oertlichkeitLangname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCOertlichkeitLangname }
     *     
     */
    public void setOertlichkeitLangname(TCOertlichkeitLangname value) {
        this.oertlichkeitLangname = value;
    }

}
