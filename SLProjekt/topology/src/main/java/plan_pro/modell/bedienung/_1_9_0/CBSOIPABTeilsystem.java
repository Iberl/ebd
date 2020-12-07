//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBSO_IP_AB_Teilsystem complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBSO_IP_AB_Teilsystem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BSO_Teilsystem_Art" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCBSO_Teilsystem_Art"/>
 *         &lt;element name="IP_Adressblock_Blau" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCIP_Adressblock_Blau"/>
 *         &lt;element name="IP_Adressblock_Grau" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCIP_Adressblock_Grau"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBSO_IP_AB_Teilsystem", propOrder = {
    "bsoTeilsystemArt",
    "ipAdressblockBlau",
    "ipAdressblockGrau"
})
public class CBSOIPABTeilsystem {

    @XmlElement(name = "BSO_Teilsystem_Art", required = true)
    protected TCBSOTeilsystemArt bsoTeilsystemArt;
    @XmlElement(name = "IP_Adressblock_Blau", required = true)
    protected TCIPAdressblockBlau ipAdressblockBlau;
    @XmlElement(name = "IP_Adressblock_Grau", required = true)
    protected TCIPAdressblockGrau ipAdressblockGrau;

    /**
     * Ruft den Wert der bsoTeilsystemArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBSOTeilsystemArt }
     *     
     */
    public TCBSOTeilsystemArt getBSOTeilsystemArt() {
        return bsoTeilsystemArt;
    }

    /**
     * Legt den Wert der bsoTeilsystemArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBSOTeilsystemArt }
     *     
     */
    public void setBSOTeilsystemArt(TCBSOTeilsystemArt value) {
        this.bsoTeilsystemArt = value;
    }

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

}
