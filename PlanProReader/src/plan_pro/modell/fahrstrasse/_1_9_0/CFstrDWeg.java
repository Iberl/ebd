//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDFMAAnlage;
import plan_pro.modell.verweise._1_9_0.TCIDFstrFahrweg;
import plan_pro.modell.verweise._1_9_0.TCIDMarkanterPunkt;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Durchrutschweg oder Gefahrpunktabstand. Die Ausdehnung des Durchrutschwegs bzw. Gefahrpunktabstands wird mit dem Bereich Objekt Fstr Fahrweg festgelegt. Ein Durchrutschweg kann von mehreren Fahrstra�en genutzt werden. Ist die Attributgruppe Fstr_DWeg_Spezifisch nicht gef�llt, so handelt es sich um einen Gefahrpunktabstand. Ein Durchrutschweg der L�nge Null wird ebenfalls als Instanz von Fstr_DWeg abgebildet. In dem Fall wird mit Fstr Fahrweg ein Bereichsobjekt der L�nge Null mit Start und Ziel am Zielsignal der Fahrstra�e verwendet. Derartige Durchrutschwege sind zu planen: am realen Zielsignal, hinter denen ein (Wahl-)Durchrutschweg der L�nge Null vorgesehen ist, am fiktiven Zielsignal bei Stumpfgleiseinfahrt, am Zugdeckungssignal. Siehe hierzu auch Aufloesung Verzoegerung. DB-Regelwerk Durchrutschwegtabelle (eine Zeile)
 * 
 * <p>Java-Klasse f�r CFstr_DWeg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_DWeg">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}CFstr_DWeg_Bezeichnung" minOccurs="0"/>
 *         &lt;element name="Fstr_DWeg_Allg" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}CFstr_DWeg_Allg"/>
 *         &lt;element name="Fstr_DWeg_Spezifisch" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}CFstr_DWeg_Spezifisch" minOccurs="0"/>
 *         &lt;element name="ID_FMA_Anlage_Freimeldung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_FMA_Anlage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_Fstr_Fahrweg" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fstr_Fahrweg"/>
 *         &lt;element name="ID_PZB_Gefahrpunkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Markanter_Punkt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_DWeg", propOrder = {
    "bezeichnung",
    "fstrDWegAllg",
    "fstrDWegSpezifisch",
    "idfmaAnlageFreimeldung",
    "idFstrFahrweg",
    "idpzbGefahrpunkt"
})
public class CFstrDWeg
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung")
    protected CFstrDWegBezeichnung bezeichnung;
    @XmlElement(name = "Fstr_DWeg_Allg", required = true)
    protected CFstrDWegAllg fstrDWegAllg;
    @XmlElement(name = "Fstr_DWeg_Spezifisch")
    protected CFstrDWegSpezifisch fstrDWegSpezifisch;
    @XmlElement(name = "ID_FMA_Anlage_Freimeldung")
    protected List<TCIDFMAAnlage> idfmaAnlageFreimeldung;
    @XmlElement(name = "ID_Fstr_Fahrweg", required = true)
    protected TCIDFstrFahrweg idFstrFahrweg;
    @XmlElement(name = "ID_PZB_Gefahrpunkt")
    protected TCIDMarkanterPunkt idpzbGefahrpunkt;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFstrDWegBezeichnung }
     *     
     */
    public CFstrDWegBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFstrDWegBezeichnung }
     *     
     */
    public void setBezeichnung(CFstrDWegBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der fstrDWegAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFstrDWegAllg }
     *     
     */
    public CFstrDWegAllg getFstrDWegAllg() {
        return fstrDWegAllg;
    }

    /**
     * Legt den Wert der fstrDWegAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFstrDWegAllg }
     *     
     */
    public void setFstrDWegAllg(CFstrDWegAllg value) {
        this.fstrDWegAllg = value;
    }

    /**
     * Ruft den Wert der fstrDWegSpezifisch-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFstrDWegSpezifisch }
     *     
     */
    public CFstrDWegSpezifisch getFstrDWegSpezifisch() {
        return fstrDWegSpezifisch;
    }

    /**
     * Legt den Wert der fstrDWegSpezifisch-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFstrDWegSpezifisch }
     *     
     */
    public void setFstrDWegSpezifisch(CFstrDWegSpezifisch value) {
        this.fstrDWegSpezifisch = value;
    }

    /**
     * Gets the value of the idfmaAnlageFreimeldung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idfmaAnlageFreimeldung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDFMAAnlageFreimeldung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDFMAAnlage }
     * 
     * 
     */
    public List<TCIDFMAAnlage> getIDFMAAnlageFreimeldung() {
        if (idfmaAnlageFreimeldung == null) {
            idfmaAnlageFreimeldung = new ArrayList<TCIDFMAAnlage>();
        }
        return this.idfmaAnlageFreimeldung;
    }

    /**
     * Ruft den Wert der idFstrFahrweg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFstrFahrweg }
     *     
     */
    public TCIDFstrFahrweg getIDFstrFahrweg() {
        return idFstrFahrweg;
    }

    /**
     * Legt den Wert der idFstrFahrweg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFstrFahrweg }
     *     
     */
    public void setIDFstrFahrweg(TCIDFstrFahrweg value) {
        this.idFstrFahrweg = value;
    }

    /**
     * Ruft den Wert der idpzbGefahrpunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDMarkanterPunkt }
     *     
     */
    public TCIDMarkanterPunkt getIDPZBGefahrpunkt() {
        return idpzbGefahrpunkt;
    }

    /**
     * Legt den Wert der idpzbGefahrpunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDMarkanterPunkt }
     *     
     */
    public void setIDPZBGefahrpunkt(TCIDMarkanterPunkt value) {
        this.idpzbGefahrpunkt = value;
    }

}
