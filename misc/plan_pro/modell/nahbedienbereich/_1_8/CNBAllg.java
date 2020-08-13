//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.nahbedienbereich._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CNB_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CNB_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NB_Art" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}TCNB_Art"/>
 *         &lt;element name="NB_Bezeichnung" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}TCNB_Bezeichnung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CNB_Allg", propOrder = {
    "nbArt",
    "nbBezeichnung"
})
public class CNBAllg {

    @XmlElement(name = "NB_Art", required = true)
    protected TCNBArt nbArt;
    @XmlElement(name = "NB_Bezeichnung", required = true)
    protected TCNBBezeichnung nbBezeichnung;

    /**
     * Ruft den Wert der nbArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNBArt }
     *     
     */
    public TCNBArt getNBArt() {
        return nbArt;
    }

    /**
     * Legt den Wert der nbArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNBArt }
     *     
     */
    public void setNBArt(TCNBArt value) {
        this.nbArt = value;
    }

    /**
     * Ruft den Wert der nbBezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNBBezeichnung }
     *     
     */
    public TCNBBezeichnung getNBBezeichnung() {
        return nbBezeichnung;
    }

    /**
     * Legt den Wert der nbBezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNBBezeichnung }
     *     
     */
    public void setNBBezeichnung(TCNBBezeichnung value) {
        this.nbBezeichnung = value;
    }

}
