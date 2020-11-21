//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.schluesselabhaengigkeiten._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDWKrGspElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSchloss_W complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchloss_W">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_W_Kr_Element" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_W_Kr_Gsp_Element"/>
 *         &lt;element name="Schloss_Art" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}TCSchloss_Art"/>
 *         &lt;element name="Verschluss_Herzstueck" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}TCVerschluss_Herzstueck" minOccurs="0"/>
 *         &lt;element name="W_Anbaulage" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}TCW_Anbaulage"/>
 *         &lt;element name="W_Lage" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}TCW_Lage"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSchloss_W", propOrder = {
    "idwKrElement",
    "schlossArt",
    "verschlussHerzstueck",
    "wAnbaulage",
    "wLage"
})
public class CSchlossW {

    @XmlElement(name = "ID_W_Kr_Element", required = true)
    protected TCIDWKrGspElement idwKrElement;
    @XmlElement(name = "Schloss_Art", required = true)
    protected TCSchlossArt schlossArt;
    @XmlElement(name = "Verschluss_Herzstueck")
    protected TCVerschlussHerzstueck verschlussHerzstueck;
    @XmlElement(name = "W_Anbaulage", required = true)
    protected TCWAnbaulage wAnbaulage;
    @XmlElement(name = "W_Lage", required = true)
    protected TCWLage wLage;

    /**
     * Ruft den Wert der idwKrElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public TCIDWKrGspElement getIDWKrElement() {
        return idwKrElement;
    }

    /**
     * Legt den Wert der idwKrElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public void setIDWKrElement(TCIDWKrGspElement value) {
        this.idwKrElement = value;
    }

    /**
     * Ruft den Wert der schlossArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSchlossArt }
     *     
     */
    public TCSchlossArt getSchlossArt() {
        return schlossArt;
    }

    /**
     * Legt den Wert der schlossArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSchlossArt }
     *     
     */
    public void setSchlossArt(TCSchlossArt value) {
        this.schlossArt = value;
    }

    /**
     * Ruft den Wert der verschlussHerzstueck-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVerschlussHerzstueck }
     *     
     */
    public TCVerschlussHerzstueck getVerschlussHerzstueck() {
        return verschlussHerzstueck;
    }

    /**
     * Legt den Wert der verschlussHerzstueck-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVerschlussHerzstueck }
     *     
     */
    public void setVerschlussHerzstueck(TCVerschlussHerzstueck value) {
        this.verschlussHerzstueck = value;
    }

    /**
     * Ruft den Wert der wAnbaulage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWAnbaulage }
     *     
     */
    public TCWAnbaulage getWAnbaulage() {
        return wAnbaulage;
    }

    /**
     * Legt den Wert der wAnbaulage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWAnbaulage }
     *     
     */
    public void setWAnbaulage(TCWAnbaulage value) {
        this.wAnbaulage = value;
    }

    /**
     * Ruft den Wert der wLage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWLage }
     *     
     */
    public TCWLage getWLage() {
        return wLage;
    }

    /**
     * Legt den Wert der wLage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWLage }
     *     
     */
    public void setWLage(TCWLage value) {
        this.wLage = value;
    }

}
