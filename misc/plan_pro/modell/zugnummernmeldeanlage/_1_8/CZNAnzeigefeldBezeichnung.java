//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.zugnummernmeldeanlage._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZN_Anzeigefeld_Bezeichnung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZN_Anzeigefeld_Bezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ZN_A_Bedienbezeichner_Frei" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCZN_A_Bedienbezeichner_Frei" minOccurs="0"/>
 *         &lt;element name="ZN_A_Bezeichner" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCZN_A_Bezeichner"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZN_Anzeigefeld_Bezeichnung", propOrder = {
    "znaBedienbezeichnerFrei",
    "znaBezeichner"
})
public class CZNAnzeigefeldBezeichnung {

    @XmlElement(name = "ZN_A_Bedienbezeichner_Frei")
    protected TCZNABedienbezeichnerFrei znaBedienbezeichnerFrei;
    @XmlElement(name = "ZN_A_Bezeichner", required = true)
    protected TCZNABezeichner znaBezeichner;

    /**
     * Ruft den Wert der znaBedienbezeichnerFrei-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZNABedienbezeichnerFrei }
     *     
     */
    public TCZNABedienbezeichnerFrei getZNABedienbezeichnerFrei() {
        return znaBedienbezeichnerFrei;
    }

    /**
     * Legt den Wert der znaBedienbezeichnerFrei-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZNABedienbezeichnerFrei }
     *     
     */
    public void setZNABedienbezeichnerFrei(TCZNABedienbezeichnerFrei value) {
        this.znaBedienbezeichnerFrei = value;
    }

    /**
     * Ruft den Wert der znaBezeichner-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZNABezeichner }
     *     
     */
    public TCZNABezeichner getZNABezeichner() {
        return znaBezeichner;
    }

    /**
     * Legt den Wert der znaBezeichner-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZNABezeichner }
     *     
     */
    public void setZNABezeichner(TCZNABezeichner value) {
        this.znaBezeichner = value;
    }

}
