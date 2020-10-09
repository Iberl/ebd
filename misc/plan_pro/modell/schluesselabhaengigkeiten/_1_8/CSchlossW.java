//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.schluesselabhaengigkeiten._1_8;

import modell.verweise._1_8.TCIDWKrGspElement;
import modell.verweise._1_8.TCIDWKrGspKomponente;

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
 *         &lt;element name="Schloss_Art" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.8.0}TCSchloss_Art"/>
 *         &lt;element name="W_Anbaulage" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.8.0}TCW_Anbaulage"/>
 *         &lt;element name="W_Lage" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.8.0}TCW_Lage"/>
 *         &lt;choice>
 *           &lt;element name="ID_Kr_KrW_Element" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_W_Kr_Gsp_Element"/>
 *           &lt;element name="ID_W_Komponente" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_W_Kr_Gsp_Komponente"/>
 *         &lt;/choice>
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
    "schlossArt",
    "wAnbaulage",
    "wLage",
    "idKrKrWElement",
    "idwKomponente"
})
public class CSchlossW {

    @XmlElement(name = "Schloss_Art", required = true)
    protected TCSchlossArt schlossArt;
    @XmlElement(name = "W_Anbaulage", required = true)
    protected TCWAnbaulage wAnbaulage;
    @XmlElement(name = "W_Lage", required = true)
    protected TCWLage wLage;
    @XmlElement(name = "ID_Kr_KrW_Element")
    protected TCIDWKrGspElement idKrKrWElement;
    @XmlElement(name = "ID_W_Komponente")
    protected TCIDWKrGspKomponente idwKomponente;

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

    /**
     * Ruft den Wert der idKrKrWElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public TCIDWKrGspElement getIDKrKrWElement() {
        return idKrKrWElement;
    }

    /**
     * Legt den Wert der idKrKrWElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDWKrGspElement }
     *     
     */
    public void setIDKrKrWElement(TCIDWKrGspElement value) {
        this.idKrKrWElement = value;
    }

    /**
     * Ruft den Wert der idwKomponente-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDWKrGspKomponente }
     *     
     */
    public TCIDWKrGspKomponente getIDWKomponente() {
        return idwKomponente;
    }

    /**
     * Legt den Wert der idwKomponente-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDWKrGspKomponente }
     *     
     */
    public void setIDWKomponente(TCIDWKrGspKomponente value) {
        this.idwKomponente = value;
    }

}
