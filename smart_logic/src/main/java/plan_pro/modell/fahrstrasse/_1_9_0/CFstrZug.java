//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDBUEEinschaltung;
import plan_pro.modell.verweise._1_9_0.TCIDSignal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CFstr_Zug complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_Zug">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Automatische_Einstellung" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCAutomatische_Einstellung" minOccurs="0"/>
 *         &lt;element name="Fstr_Vsigabstand_Verkuerzt" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCFstr_Vsigabstand_Verkuerzt"/>
 *         &lt;element name="Fstr_Zug_DWeg" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}CFstr_Zug_DWeg" minOccurs="0"/>
 *         &lt;element name="ID_BUE_Einschaltung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_BUE_Einschaltung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ID_Signal_Gruppenausfahrt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_Zug", propOrder = {
    "automatischeEinstellung",
    "fstrVsigabstandVerkuerzt",
    "fstrZugDWeg",
    "idbueEinschaltung",
    "idSignalGruppenausfahrt"
})
public class CFstrZug {

    @XmlElement(name = "Automatische_Einstellung")
    protected TCAutomatischeEinstellung automatischeEinstellung;
    @XmlElement(name = "Fstr_Vsigabstand_Verkuerzt", required = true)
    protected TCFstrVsigabstandVerkuerzt fstrVsigabstandVerkuerzt;
    @XmlElement(name = "Fstr_Zug_DWeg")
    protected CFstrZugDWeg fstrZugDWeg;
    @XmlElement(name = "ID_BUE_Einschaltung")
    protected List<TCIDBUEEinschaltung> idbueEinschaltung;
    @XmlElement(name = "ID_Signal_Gruppenausfahrt")
    protected TCIDSignal idSignalGruppenausfahrt;

    /**
     * Ruft den Wert der automatischeEinstellung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAutomatischeEinstellung }
     *     
     */
    public TCAutomatischeEinstellung getAutomatischeEinstellung() {
        return automatischeEinstellung;
    }

    /**
     * Legt den Wert der automatischeEinstellung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAutomatischeEinstellung }
     *     
     */
    public void setAutomatischeEinstellung(TCAutomatischeEinstellung value) {
        this.automatischeEinstellung = value;
    }

    /**
     * Ruft den Wert der fstrVsigabstandVerkuerzt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFstrVsigabstandVerkuerzt }
     *     
     */
    public TCFstrVsigabstandVerkuerzt getFstrVsigabstandVerkuerzt() {
        return fstrVsigabstandVerkuerzt;
    }

    /**
     * Legt den Wert der fstrVsigabstandVerkuerzt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFstrVsigabstandVerkuerzt }
     *     
     */
    public void setFstrVsigabstandVerkuerzt(TCFstrVsigabstandVerkuerzt value) {
        this.fstrVsigabstandVerkuerzt = value;
    }

    /**
     * Ruft den Wert der fstrZugDWeg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CFstrZugDWeg }
     *     
     */
    public CFstrZugDWeg getFstrZugDWeg() {
        return fstrZugDWeg;
    }

    /**
     * Legt den Wert der fstrZugDWeg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CFstrZugDWeg }
     *     
     */
    public void setFstrZugDWeg(CFstrZugDWeg value) {
        this.fstrZugDWeg = value;
    }

    /**
     * Gets the value of the idbueEinschaltung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idbueEinschaltung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDBUEEinschaltung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDBUEEinschaltung }
     * 
     * 
     */
    public List<TCIDBUEEinschaltung> getIDBUEEinschaltung() {
        if (idbueEinschaltung == null) {
            idbueEinschaltung = new ArrayList<TCIDBUEEinschaltung>();
        }
        return this.idbueEinschaltung;
    }

    /**
     * Ruft den Wert der idSignalGruppenausfahrt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignal }
     *     
     */
    public TCIDSignal getIDSignalGruppenausfahrt() {
        return idSignalGruppenausfahrt;
    }

    /**
     * Legt den Wert der idSignalGruppenausfahrt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignal }
     *     
     */
    public void setIDSignalGruppenausfahrt(TCIDSignal value) {
        this.idSignalGruppenausfahrt = value;
    }

}
