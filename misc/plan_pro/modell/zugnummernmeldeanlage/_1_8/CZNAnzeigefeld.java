//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.zugnummernmeldeanlage._1_8;

import modell.basisobjekte._1_8.CBasisObjekt;
import modell.verweise._1_8.TCIDGleisAbschnitt;
import modell.verweise._1_8.TCIDZLVBus;
import modell.verweise._1_8.TCIDZN;
import modell.verweise._1_8.TCIDZNAnzeigefeld;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Objekt, welches die Funktionalit�ten der ZN auf der Bedienoberfl�che abbildet. F�r jedes Gleis, in denen die ZN-Anlage Zugnummern verwalten und/oder anzeigen soll, ist mindestens ein ZN-Anzeigefeld zu definieren. Hinsichtlich der Besonderheiten bei der Bezeichnug wird auf die Ausf�hrungen auf der Seite Bezeichnung ZN-Anzeigefeld verwiesen. DB-Regelwerk 819.0731 6 (1) bis (15) sowie (19) ff 
 * 
 * <p>Java-Klasse f�r CZN_Anzeigefeld complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZN_Anzeigefeld">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ID_Gleis_Abschnitt" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Gleis_Abschnitt" minOccurs="0"/>
 *         &lt;element name="ID_ZLV_Bus" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_ZLV_Bus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_ZN" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_ZN"/>
 *         &lt;element name="ID_ZN_Anzeigefeld" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_ZN_Anzeigefeld" minOccurs="0"/>
 *         &lt;element name="ZN_Anzeigefeld_Allg" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}CZN_Anzeigefeld_Allg" minOccurs="0"/>
 *         &lt;element name="ZN_Anzeigefeld_Bezeichnung" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}CZN_Anzeigefeld_Bezeichnung"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZN_Anzeigefeld", propOrder = {
    "idGleisAbschnitt",
    "idzlvBus",
    "idzn",
    "idznAnzeigefeld",
    "znAnzeigefeldAllg",
    "znAnzeigefeldBezeichnung"
})
public class CZNAnzeigefeld
    extends CBasisObjekt
{

    @XmlElement(name = "ID_Gleis_Abschnitt")
    protected TCIDGleisAbschnitt idGleisAbschnitt;
    @XmlElement(name = "ID_ZLV_Bus")
    protected List<TCIDZLVBus> idzlvBus;
    @XmlElement(name = "ID_ZN", required = true)
    protected TCIDZN idzn;
    @XmlElement(name = "ID_ZN_Anzeigefeld")
    protected TCIDZNAnzeigefeld idznAnzeigefeld;
    @XmlElement(name = "ZN_Anzeigefeld_Allg")
    protected CZNAnzeigefeldAllg znAnzeigefeldAllg;
    @XmlElement(name = "ZN_Anzeigefeld_Bezeichnung", required = true)
    protected CZNAnzeigefeldBezeichnung znAnzeigefeldBezeichnung;

    /**
     * Ruft den Wert der idGleisAbschnitt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDGleisAbschnitt }
     *     
     */
    public TCIDGleisAbschnitt getIDGleisAbschnitt() {
        return idGleisAbschnitt;
    }

    /**
     * Legt den Wert der idGleisAbschnitt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDGleisAbschnitt }
     *     
     */
    public void setIDGleisAbschnitt(TCIDGleisAbschnitt value) {
        this.idGleisAbschnitt = value;
    }

    /**
     * Gets the value of the idzlvBus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idzlvBus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDZLVBus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDZLVBus }
     * 
     * 
     */
    public List<TCIDZLVBus> getIDZLVBus() {
        if (idzlvBus == null) {
            idzlvBus = new ArrayList<TCIDZLVBus>();
        }
        return this.idzlvBus;
    }

    /**
     * Ruft den Wert der idzn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZN }
     *     
     */
    public TCIDZN getIDZN() {
        return idzn;
    }

    /**
     * Legt den Wert der idzn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZN }
     *     
     */
    public void setIDZN(TCIDZN value) {
        this.idzn = value;
    }

    /**
     * Ruft den Wert der idznAnzeigefeld-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZNAnzeigefeld }
     *     
     */
    public TCIDZNAnzeigefeld getIDZNAnzeigefeld() {
        return idznAnzeigefeld;
    }

    /**
     * Legt den Wert der idznAnzeigefeld-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZNAnzeigefeld }
     *     
     */
    public void setIDZNAnzeigefeld(TCIDZNAnzeigefeld value) {
        this.idznAnzeigefeld = value;
    }

    /**
     * Ruft den Wert der znAnzeigefeldAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZNAnzeigefeldAllg }
     *     
     */
    public CZNAnzeigefeldAllg getZNAnzeigefeldAllg() {
        return znAnzeigefeldAllg;
    }

    /**
     * Legt den Wert der znAnzeigefeldAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZNAnzeigefeldAllg }
     *     
     */
    public void setZNAnzeigefeldAllg(CZNAnzeigefeldAllg value) {
        this.znAnzeigefeldAllg = value;
    }

    /**
     * Ruft den Wert der znAnzeigefeldBezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CZNAnzeigefeldBezeichnung }
     *     
     */
    public CZNAnzeigefeldBezeichnung getZNAnzeigefeldBezeichnung() {
        return znAnzeigefeldBezeichnung;
    }

    /**
     * Legt den Wert der znAnzeigefeldBezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CZNAnzeigefeldBezeichnung }
     *     
     */
    public void setZNAnzeigefeldBezeichnung(CZNAnzeigefeldBezeichnung value) {
        this.znAnzeigefeldBezeichnung = value;
    }

}
