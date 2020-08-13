//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.ansteuerung_element._1_8;

import modell.verweise._1_8.TCIDAussenelementansteuerung;
import modell.verweise._1_8.TCIDEnergiePrimaer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CAEA_Energieversorgung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CAEA_Energieversorgung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Energieversorgung_Art_Ersatz" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}TCEnergieversorgung_Art_Ersatz" minOccurs="0"/>
 *           &lt;element name="ID_Energie_Sekundaer" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Aussenelementansteuerung" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element name="Energieversorgung_Art" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}TCEnergieversorgung_Art"/>
 *           &lt;element name="ID_Energie_Primaer" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Energie_Primaer"/>
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
@XmlType(name = "CAEA_Energieversorgung", propOrder = {
    "energieversorgungArtErsatz",
    "idEnergieSekundaer",
    "energieversorgungArt",
    "idEnergiePrimaer"
})
public class CAEAEnergieversorgung {

    @XmlElement(name = "Energieversorgung_Art_Ersatz")
    protected TCEnergieversorgungArtErsatz energieversorgungArtErsatz;
    @XmlElement(name = "ID_Energie_Sekundaer")
    protected TCIDAussenelementansteuerung idEnergieSekundaer;
    @XmlElement(name = "Energieversorgung_Art")
    protected TCEnergieversorgungArt energieversorgungArt;
    @XmlElement(name = "ID_Energie_Primaer")
    protected TCIDEnergiePrimaer idEnergiePrimaer;

    /**
     * Ruft den Wert der energieversorgungArtErsatz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEnergieversorgungArtErsatz }
     *     
     */
    public TCEnergieversorgungArtErsatz getEnergieversorgungArtErsatz() {
        return energieversorgungArtErsatz;
    }

    /**
     * Legt den Wert der energieversorgungArtErsatz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEnergieversorgungArtErsatz }
     *     
     */
    public void setEnergieversorgungArtErsatz(TCEnergieversorgungArtErsatz value) {
        this.energieversorgungArtErsatz = value;
    }

    /**
     * Ruft den Wert der idEnergieSekundaer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public TCIDAussenelementansteuerung getIDEnergieSekundaer() {
        return idEnergieSekundaer;
    }

    /**
     * Legt den Wert der idEnergieSekundaer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDAussenelementansteuerung }
     *     
     */
    public void setIDEnergieSekundaer(TCIDAussenelementansteuerung value) {
        this.idEnergieSekundaer = value;
    }

    /**
     * Ruft den Wert der energieversorgungArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEnergieversorgungArt }
     *     
     */
    public TCEnergieversorgungArt getEnergieversorgungArt() {
        return energieversorgungArt;
    }

    /**
     * Legt den Wert der energieversorgungArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEnergieversorgungArt }
     *     
     */
    public void setEnergieversorgungArt(TCEnergieversorgungArt value) {
        this.energieversorgungArt = value;
    }

    /**
     * Ruft den Wert der idEnergiePrimaer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDEnergiePrimaer }
     *     
     */
    public TCIDEnergiePrimaer getIDEnergiePrimaer() {
        return idEnergiePrimaer;
    }

    /**
     * Legt den Wert der idEnergiePrimaer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDEnergiePrimaer }
     *     
     */
    public void setIDEnergiePrimaer(TCIDEnergiePrimaer value) {
        this.idEnergiePrimaer = value;
    }

}
