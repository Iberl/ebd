//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basisobjekte._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDTOPKante;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CPunkt_Objekt_TOP_Kante complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPunkt_Objekt_TOP_Kante">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Abstand" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}TCAbstand"/>
 *         &lt;element name="ID_TOP_Kante" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_TOP_Kante"/>
 *         &lt;element name="Wirkrichtung" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}TCWirkrichtung" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="Seitliche_Lage" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}TCSeitliche_Lage" minOccurs="0"/>
 *           &lt;element name="Seitlicher_Abstand" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}TCSeitlicher_Abstand" minOccurs="0"/>
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
@XmlType(name = "CPunkt_Objekt_TOP_Kante", propOrder = {
    "abstand",
    "idtopKante",
    "wirkrichtung",
    "seitlicheLage",
    "seitlicherAbstand"
})
public class CPunktObjektTOPKante {

    @XmlElement(name = "Abstand", required = true)
    protected TCAbstand abstand;
    @XmlElement(name = "ID_TOP_Kante", required = true)
    protected TCIDTOPKante idtopKante;
    @XmlElement(name = "Wirkrichtung")
    protected TCWirkrichtung wirkrichtung;
    @XmlElement(name = "Seitliche_Lage")
    protected TCSeitlicheLage seitlicheLage;
    @XmlElement(name = "Seitlicher_Abstand")
    protected TCSeitlicherAbstand seitlicherAbstand;

    /**
     * Ruft den Wert der abstand-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAbstand }
     *     
     */
    public TCAbstand getAbstand() {
        return abstand;
    }

    /**
     * Legt den Wert der abstand-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAbstand }
     *     
     */
    public void setAbstand(TCAbstand value) {
        this.abstand = value;
    }

    /**
     * Ruft den Wert der idtopKante-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDTOPKante }
     *     
     */
    public TCIDTOPKante getIDTOPKante() {
        return idtopKante;
    }

    /**
     * Legt den Wert der idtopKante-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDTOPKante }
     *     
     */
    public void setIDTOPKante(TCIDTOPKante value) {
        this.idtopKante = value;
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

    /**
     * Ruft den Wert der seitlicheLage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSeitlicheLage }
     *     
     */
    public TCSeitlicheLage getSeitlicheLage() {
        return seitlicheLage;
    }

    /**
     * Legt den Wert der seitlicheLage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSeitlicheLage }
     *     
     */
    public void setSeitlicheLage(TCSeitlicheLage value) {
        this.seitlicheLage = value;
    }

    /**
     * Ruft den Wert der seitlicherAbstand-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSeitlicherAbstand }
     *     
     */
    public TCSeitlicherAbstand getSeitlicherAbstand() {
        return seitlicherAbstand;
    }

    /**
     * Legt den Wert der seitlicherAbstand-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSeitlicherAbstand }
     *     
     */
    public void setSeitlicherAbstand(TCSeitlicherAbstand value) {
        this.seitlicherAbstand = value;
    }

}
