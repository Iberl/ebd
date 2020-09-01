//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.fahrstrasse._1_8;

import modell.verweise._1_8.TCIDBUEEinschaltung;
import modell.verweise._1_8.TCIDSignal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Automatische_Einstellung" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}TCAutomatische_Einstellung" minOccurs="0"/>
 *         &lt;element name="Fstr_Vsigabstand_Verkuerzt" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}TCFstr_Vsigabstand_Verkuerzt"/>
 *         &lt;element name="Fstr_Zug_DWeg" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}CFstr_Zug_DWeg" minOccurs="0"/>
 *         &lt;element name="ID_BUE_Einschaltung" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_BUE_Einschaltung" minOccurs="0"/>
 *         &lt;element name="ID_Signal_Gruppenausfahrt" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Signal" minOccurs="0"/>
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
    protected TCIDBUEEinschaltung idbueEinschaltung;
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
     * Ruft den Wert der idbueEinschaltung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBUEEinschaltung }
     *     
     */
    public TCIDBUEEinschaltung getIDBUEEinschaltung() {
        return idbueEinschaltung;
    }

    /**
     * Legt den Wert der idbueEinschaltung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBUEEinschaltung }
     *     
     */
    public void setIDBUEEinschaltung(TCIDBUEEinschaltung value) {
        this.idbueEinschaltung = value;
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
