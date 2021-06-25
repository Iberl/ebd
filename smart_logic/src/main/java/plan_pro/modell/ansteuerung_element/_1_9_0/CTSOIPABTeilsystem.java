//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ansteuerung_element._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CTSO_IP_AB_Teilsystem complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CTSO_IP_AB_Teilsystem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IP_Adressblock_Blau" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCIP_Adressblock_Blau"/>
 *         &lt;element name="IP_Adressblock_Grau" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCIP_Adressblock_Grau"/>
 *         &lt;element name="TSO_Teilsystem_Art" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCTSO_Teilsystem_Art"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTSO_IP_AB_Teilsystem", propOrder = {
    "ipAdressblockBlau",
    "ipAdressblockGrau",
    "tsoTeilsystemArt"
})
public class CTSOIPABTeilsystem {

    @XmlElement(name = "IP_Adressblock_Blau", required = true)
    protected TCIPAdressblockBlau ipAdressblockBlau;
    @XmlElement(name = "IP_Adressblock_Grau", required = true)
    protected TCIPAdressblockGrau ipAdressblockGrau;
    @XmlElement(name = "TSO_Teilsystem_Art", required = true)
    protected TCTSOTeilsystemArt tsoTeilsystemArt;

    /**
     * Ruft den Wert der ipAdressblockBlau-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIPAdressblockBlau }
     *     
     */
    public TCIPAdressblockBlau getIPAdressblockBlau() {
        return ipAdressblockBlau;
    }

    /**
     * Legt den Wert der ipAdressblockBlau-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIPAdressblockBlau }
     *     
     */
    public void setIPAdressblockBlau(TCIPAdressblockBlau value) {
        this.ipAdressblockBlau = value;
    }

    /**
     * Ruft den Wert der ipAdressblockGrau-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIPAdressblockGrau }
     *     
     */
    public TCIPAdressblockGrau getIPAdressblockGrau() {
        return ipAdressblockGrau;
    }

    /**
     * Legt den Wert der ipAdressblockGrau-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIPAdressblockGrau }
     *     
     */
    public void setIPAdressblockGrau(TCIPAdressblockGrau value) {
        this.ipAdressblockGrau = value;
    }

    /**
     * Ruft den Wert der tsoTeilsystemArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTSOTeilsystemArt }
     *     
     */
    public TCTSOTeilsystemArt getTSOTeilsystemArt() {
        return tsoTeilsystemArt;
    }

    /**
     * Legt den Wert der tsoTeilsystemArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTSOTeilsystemArt }
     *     
     */
    public void setTSOTeilsystemArt(TCTSOTeilsystemArt value) {
        this.tsoTeilsystemArt = value;
    }

}
