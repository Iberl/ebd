//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bedienung._1_8;

import modell.verweise._1_8.TCIDAnhang;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBedien_Oberflaeche_Anhaenge complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Oberflaeche_Anhaenge">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_Anhang_Monitoraufteilung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Anhang" minOccurs="0"/>
 *         &lt;element name="ID_Anhang_Richtungssinn" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Anhang" minOccurs="0"/>
 *         &lt;element name="ID_Anhang_Vorgabe_BELU" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Anhang" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Oberflaeche_Anhaenge", propOrder = {
    "idAnhangMonitoraufteilung",
    "idAnhangRichtungssinn",
    "idAnhangVorgabeBELU"
})
public class CBedienOberflaecheAnhaenge {

    @XmlElement(name = "ID_Anhang_Monitoraufteilung")
    protected TCIDAnhang idAnhangMonitoraufteilung;
    @XmlElement(name = "ID_Anhang_Richtungssinn")
    protected TCIDAnhang idAnhangRichtungssinn;
    @XmlElement(name = "ID_Anhang_Vorgabe_BELU")
    protected TCIDAnhang idAnhangVorgabeBELU;

    /**
     * Ruft den Wert der idAnhangMonitoraufteilung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangMonitoraufteilung() {
        return idAnhangMonitoraufteilung;
    }

    /**
     * Legt den Wert der idAnhangMonitoraufteilung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangMonitoraufteilung(TCIDAnhang value) {
        this.idAnhangMonitoraufteilung = value;
    }

    /**
     * Ruft den Wert der idAnhangRichtungssinn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangRichtungssinn() {
        return idAnhangRichtungssinn;
    }

    /**
     * Legt den Wert der idAnhangRichtungssinn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangRichtungssinn(TCIDAnhang value) {
        this.idAnhangRichtungssinn = value;
    }

    /**
     * Ruft den Wert der idAnhangVorgabeBELU-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAnhang }
     *     
     */
    public TCIDAnhang getIDAnhangVorgabeBELU() {
        return idAnhangVorgabeBELU;
    }

    /**
     * Legt den Wert der idAnhangVorgabeBELU-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAnhang }
     *     
     */
    public void setIDAnhangVorgabeBELU(TCIDAnhang value) {
        this.idAnhangVorgabeBELU = value;
    }

}
