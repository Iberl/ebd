//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDEnergieEingang;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CEV_Modul_Eingang complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CEV_Modul_Eingang">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Eingang_Gepuffert" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCEingang_Gepuffert"/>
 *         &lt;element name="Primaerquelle" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCPrimaerquelle"/>
 *         &lt;choice>
 *           &lt;element name="Energie_Eingang_Art" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCEnergie_Eingang_Art"/>
 *           &lt;element name="ID_Energie_Eingang" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Energie_Eingang"/>
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
@XmlType(name = "CEV_Modul_Eingang", propOrder = {
    "eingangGepuffert",
    "primaerquelle",
    "energieEingangArt",
    "idEnergieEingang"
})
public class CEVModulEingang {

    @XmlElement(name = "Eingang_Gepuffert", required = true)
    protected TCEingangGepuffert eingangGepuffert;
    @XmlElement(name = "Primaerquelle", required = true)
    protected TCPrimaerquelle primaerquelle;
    @XmlElement(name = "Energie_Eingang_Art")
    protected TCEnergieEingangArt energieEingangArt;
    @XmlElement(name = "ID_Energie_Eingang")
    protected TCIDEnergieEingang idEnergieEingang;

    /**
     * Ruft den Wert der eingangGepuffert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEingangGepuffert }
     *     
     */
    public TCEingangGepuffert getEingangGepuffert() {
        return eingangGepuffert;
    }

    /**
     * Legt den Wert der eingangGepuffert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEingangGepuffert }
     *     
     */
    public void setEingangGepuffert(TCEingangGepuffert value) {
        this.eingangGepuffert = value;
    }

    /**
     * Ruft den Wert der primaerquelle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPrimaerquelle }
     *     
     */
    public TCPrimaerquelle getPrimaerquelle() {
        return primaerquelle;
    }

    /**
     * Legt den Wert der primaerquelle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPrimaerquelle }
     *     
     */
    public void setPrimaerquelle(TCPrimaerquelle value) {
        this.primaerquelle = value;
    }

    /**
     * Ruft den Wert der energieEingangArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEnergieEingangArt }
     *     
     */
    public TCEnergieEingangArt getEnergieEingangArt() {
        return energieEingangArt;
    }

    /**
     * Legt den Wert der energieEingangArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEnergieEingangArt }
     *     
     */
    public void setEnergieEingangArt(TCEnergieEingangArt value) {
        this.energieEingangArt = value;
    }

    /**
     * Ruft den Wert der idEnergieEingang-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDEnergieEingang }
     *     
     */
    public TCIDEnergieEingang getIDEnergieEingang() {
        return idEnergieEingang;
    }

    /**
     * Legt den Wert der idEnergieEingang-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDEnergieEingang }
     *     
     */
    public void setIDEnergieEingang(TCIDEnergieEingang value) {
        this.idEnergieEingang = value;
    }

}
