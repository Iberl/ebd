//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.geodaten._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CGeschwindigkeitsprofil_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGeschwindigkeitsprofil_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Geschwindigkeit" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}TCGeschwindigkeit"/>
 *         &lt;element name="V_Profil_Art" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}TCV_Profil_Art"/>
 *         &lt;element name="Wirkrichtung" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}TCWirkrichtung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGeschwindigkeitsprofil_Allg", propOrder = {
    "geschwindigkeit",
    "vProfilArt",
    "wirkrichtung"
})
public class CGeschwindigkeitsprofilAllg {

    @XmlElement(name = "Geschwindigkeit", required = true)
    protected TCGeschwindigkeit geschwindigkeit;
    @XmlElement(name = "V_Profil_Art", required = true)
    protected TCVProfilArt vProfilArt;
    @XmlElement(name = "Wirkrichtung", required = true)
    protected TCWirkrichtung wirkrichtung;

    /**
     * Ruft den Wert der geschwindigkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGeschwindigkeit }
     *     
     */
    public TCGeschwindigkeit getGeschwindigkeit() {
        return geschwindigkeit;
    }

    /**
     * Legt den Wert der geschwindigkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGeschwindigkeit }
     *     
     */
    public void setGeschwindigkeit(TCGeschwindigkeit value) {
        this.geschwindigkeit = value;
    }

    /**
     * Ruft den Wert der vProfilArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVProfilArt }
     *     
     */
    public TCVProfilArt getVProfilArt() {
        return vProfilArt;
    }

    /**
     * Legt den Wert der vProfilArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVProfilArt }
     *     
     */
    public void setVProfilArt(TCVProfilArt value) {
        this.vProfilArt = value;
    }

    /**
     * Ruft den Wert der wirkrichtung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWirkrichtung }
     *     
     */
    public TCWirkrichtung getWirkrichtung() {
        return wirkrichtung;
    }

    /**
     * Legt den Wert der wirkrichtung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWirkrichtung }
     *     
     */
    public void setWirkrichtung(TCWirkrichtung value) {
        this.wirkrichtung = value;
    }

}
