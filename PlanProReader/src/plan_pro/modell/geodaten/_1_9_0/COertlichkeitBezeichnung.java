//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r COertlichkeit_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="COertlichkeit_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Oertlichkeit_Abkuerzung" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCOertlichkeit_Abkuerzung"/>
 *         &lt;element name="Oertlichkeit_Kurzname" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCOertlichkeit_Kurzname" minOccurs="0"/>
 *         &lt;element name="Oertlichkeit_Langname" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCOertlichkeit_Langname"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COertlichkeit_Bezeichnung", propOrder = {
    "oertlichkeitAbkuerzung",
    "oertlichkeitKurzname",
    "oertlichkeitLangname"
})
public class COertlichkeitBezeichnung {

    @XmlElement(name = "Oertlichkeit_Abkuerzung", required = true)
    protected TCOertlichkeitAbkuerzung oertlichkeitAbkuerzung;
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
