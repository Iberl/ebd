//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.geodaten._1_8;

import modell.basisobjekte._1_8.CPunktObjekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Beschreibung sonstiger punktf�rmiger Objekte im Datenmodell. Diese werde durch Fremdsysteme bereitgestellt oder w�hrend einer Planung manuell erg�nzt. Sie dienen nur zur Information f�r planerische Entscheidungen.
 * 
 * <p>Java-Klasse f�r CTechnischer_Punkt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CTechnischer_Punkt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="TP_Art" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}TCTP_Art" minOccurs="0"/>
 *         &lt;element name="TP_Beschreibung" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}TCTP_Beschreibung"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTechnischer_Punkt", propOrder = {
    "tpArt",
    "tpBeschreibung"
})
public class CTechnischerPunkt
    extends CPunktObjekt
{

    @XmlElement(name = "TP_Art")
    protected TCTPArt tpArt;
    @XmlElement(name = "TP_Beschreibung", required = true)
    protected TCTPBeschreibung tpBeschreibung;

    /**
     * Ruft den Wert der tpArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTPArt }
     *     
     */
    public TCTPArt getTPArt() {
        return tpArt;
    }

    /**
     * Legt den Wert der tpArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTPArt }
     *     
     */
    public void setTPArt(TCTPArt value) {
        this.tpArt = value;
    }

    /**
     * Ruft den Wert der tpBeschreibung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTPBeschreibung }
     *     
     */
    public TCTPBeschreibung getTPBeschreibung() {
        return tpBeschreibung;
    }

    /**
     * Legt den Wert der tpBeschreibung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTPBeschreibung }
     *     
     */
    public void setTPBeschreibung(TCTPBeschreibung value) {
        this.tpBeschreibung = value;
    }

}
