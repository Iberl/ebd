//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.zugnummernmeldeanlage._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CZN_Unterstation_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZN_Unterstation_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bf_Kennung" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCBf_Kennung"/>
 *         &lt;element name="Koppelunterstation" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCKoppelunterstation"/>
 *         &lt;element name="ZBS_Adresse" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCZBS_Adresse" minOccurs="0"/>
 *         &lt;element name="ZBS_Anbindung" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCZBS_Anbindung"/>
 *         &lt;element name="ZN_Unterstation_Bf_Nr" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}CZN_Unterstation_Bf_Nr" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZN_Unterstation_Allg", propOrder = {
    "bfKennung",
    "koppelunterstation",
    "zbsAdresse",
    "zbsAnbindung",
    "znUnterstationBfNr"
})
public class CZNUnterstationAllg {

    @XmlElement(name = "Bf_Kennung", required = true)
    protected TCBfKennung bfKennung;
    @XmlElement(name = "Koppelunterstation", required = true)
    protected TCKoppelunterstation koppelunterstation;
    @XmlElement(name = "ZBS_Adresse")
    protected TCZBSAdresse zbsAdresse;
    @XmlElement(name = "ZBS_Anbindung", required = true)
    protected TCZBSAnbindung zbsAnbindung;
    @XmlElement(name = "ZN_Unterstation_Bf_Nr", required = true)
    protected List<CZNUnterstationBfNr> znUnterstationBfNr;

    /**
     * Ruft den Wert der bfKennung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBfKennung }
     *     
     */
    public TCBfKennung getBfKennung() {
        return bfKennung;
    }

    /**
     * Legt den Wert der bfKennung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBfKennung }
     *     
     */
    public void setBfKennung(TCBfKennung value) {
        this.bfKennung = value;
    }

    /**
     * Ruft den Wert der koppelunterstation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKoppelunterstation }
     *     
     */
    public TCKoppelunterstation getKoppelunterstation() {
        return koppelunterstation;
    }

    /**
     * Legt den Wert der koppelunterstation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKoppelunterstation }
     *     
     */
    public void setKoppelunterstation(TCKoppelunterstation value) {
        this.koppelunterstation = value;
    }

    /**
     * Ruft den Wert der zbsAdresse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZBSAdresse }
     *     
     */
    public TCZBSAdresse getZBSAdresse() {
        return zbsAdresse;
    }

    /**
     * Legt den Wert der zbsAdresse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZBSAdresse }
     *     
     */
    public void setZBSAdresse(TCZBSAdresse value) {
        this.zbsAdresse = value;
    }

    /**
     * Ruft den Wert der zbsAnbindung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZBSAnbindung }
     *     
     */
    public TCZBSAnbindung getZBSAnbindung() {
        return zbsAnbindung;
    }

    /**
     * Legt den Wert der zbsAnbindung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZBSAnbindung }
     *     
     */
    public void setZBSAnbindung(TCZBSAnbindung value) {
        this.zbsAnbindung = value;
    }

    /**
     * Gets the value of the znUnterstationBfNr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the znUnterstationBfNr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZNUnterstationBfNr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZNUnterstationBfNr }
     * 
     * 
     */
    public List<CZNUnterstationBfNr> getZNUnterstationBfNr() {
        if (znUnterstationBfNr == null) {
            znUnterstationBfNr = new ArrayList<CZNUnterstationBfNr>();
        }
        return this.znUnterstationBfNr;
    }

}
