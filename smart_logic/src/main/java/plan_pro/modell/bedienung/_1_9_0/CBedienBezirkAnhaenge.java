//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDAnhang;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBedien_Bezirk_Anhaenge complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Bezirk_Anhaenge">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_Anhang_Anbindung_IB2" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang" minOccurs="0"/>
 *         &lt;element name="ID_Anhang_Anbindung_IB3" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang" minOccurs="0"/>
 *         &lt;element name="ID_Anhang_Steuerbez_Uebersicht" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Anhang" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Bezirk_Anhaenge", propOrder = {
    "idAnhangAnbindungIB2",
    "idAnhangAnbindungIB3",
    "idAnhangSteuerbezUebersicht"
})
public class CBedienBezirkAnhaenge {

    @XmlElement(name = "ID_Anhang_Anbindung_IB2")
    protected TCIDAnhang idAnhangAnbindungIB2;
    @XmlElement(name = "ID_Anhang_Anbindung_IB3")
    protected TCIDAnhang idAnhangAnbindungIB3;
    @XmlElement(name = "ID_Anhang_Steuerbez_Uebersicht")
    protected TCIDAnhang idAnhangSteuerbezUebersicht;

    /**
     * Ruft den Wert der idAnhangAnbindungIB2-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangAnbindungIB2() {
        return idAnhangAnbindungIB2;
    }

    /**
     * Legt den Wert der idAnhangAnbindungIB2-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangAnbindungIB2(TCIDAnhang value) {
        this.idAnhangAnbindungIB2 = value;
    }

    /**
     * Ruft den Wert der idAnhangAnbindungIB3-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangAnbindungIB3() {
        return idAnhangAnbindungIB3;
    }

    /**
     * Legt den Wert der idAnhangAnbindungIB3-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangAnbindungIB3(TCIDAnhang value) {
        this.idAnhangAnbindungIB3 = value;
    }

    /**
     * Ruft den Wert der idAnhangSteuerbezUebersicht-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangSteuerbezUebersicht() {
        return idAnhangSteuerbezUebersicht;
    }

    /**
     * Legt den Wert der idAnhangSteuerbezUebersicht-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangSteuerbezUebersicht(TCIDAnhang value) {
        this.idAnhangSteuerbezUebersicht = value;
    }

}
