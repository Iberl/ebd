//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBereichObjekt;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Beschreibung sonstiger bereichsf�rmiger Objekte im Datenmodell. Diese werde durch Fremdsysteme bereitgestellt oder w�hrend einer Planung manuell erg�nzt. Sie dienen nur zur Information f�r planerische Entscheidungen.
 * 
 * <p>Java-Klasse f�r CTechnischer_Bereich complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CTechnischer_Bereich">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBereich_Objekt">
 *       &lt;sequence>
 *         &lt;element name="TB_Art" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCTB_Art" minOccurs="0"/>
 *         &lt;element name="TB_Beschreibung" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCTB_Beschreibung"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTechnischer_Bereich", propOrder = {
    "tbArt",
    "tbBeschreibung"
})
public class CTechnischerBereich
    extends CBereichObjekt
{

    @XmlElement(name = "TB_Art")
    protected TCTBArt tbArt;
    @XmlElement(name = "TB_Beschreibung", required = true)
    protected TCTBBeschreibung tbBeschreibung;

    /**
     * Ruft den Wert der tbArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTBArt }
     *     
     */
    public TCTBArt getTBArt() {
        return tbArt;
    }

    /**
     * Legt den Wert der tbArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTBArt }
     *     
     */
    public void setTBArt(TCTBArt value) {
        this.tbArt = value;
    }

    /**
     * Ruft den Wert der tbBeschreibung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTBBeschreibung }
     *     
     */
    public TCTBBeschreibung getTBBeschreibung() {
        return tbBeschreibung;
    }

    /**
     * Legt den Wert der tbBeschreibung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTBBeschreibung }
     *     
     */
    public void setTBBeschreibung(TCTBBeschreibung value) {
        this.tbBeschreibung = value;
    }

}
