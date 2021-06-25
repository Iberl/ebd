//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CFT_ZBS_Merkmale complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFT_ZBS_Merkmale">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FT_Hinweis_Funktion" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCFT_Hinweis_Funktion" minOccurs="0"/>
 *         &lt;element name="FT_ZBS_Merkmale_La" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CFT_ZBS_Merkmale_La" maxOccurs="4" minOccurs="0"/>
 *         &lt;element name="FT_ZBS_Typ" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCFT_ZBS_Typ"/>
 *         &lt;element name="Laenge_1" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCLaenge_1" minOccurs="0"/>
 *         &lt;element name="LM_G" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCLM_G"/>
 *         &lt;element name="Massgebende_Neig_1" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCMassgebende_Neig_1" minOccurs="0"/>
 *         &lt;element name="Massgebende_Neig_Schutzstrecke" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCMassgebende_Neig_Schutzstrecke" minOccurs="0"/>
 *         &lt;element name="Mastschild" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCMastschild"/>
 *         &lt;element name="Schutzstrecke_Erforderlich" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCSchutzstrecke_Erforderlich" minOccurs="0"/>
 *         &lt;element name="Schutzstrecke_Vorhanden" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCSchutzstrecke_Vorhanden" minOccurs="0"/>
 *         &lt;element name="Telegrammnummer" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCTelegrammnummer"/>
 *         &lt;element name="V_Befehl_R" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCV_Befehl_R" minOccurs="0"/>
 *         &lt;element name="V_Befehl_Z" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCV_Befehl_Z" minOccurs="0"/>
 *         &lt;element name="V_Frei" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCV_Frei" minOccurs="0"/>
 *         &lt;element name="V_Zul_Strecke" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCV_Zul_Strecke" minOccurs="0"/>
 *         &lt;element name="VGR_1" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCVGR_1" minOccurs="0"/>
 *         &lt;element name="VGR_2" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCVGR_2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFT_ZBS_Merkmale", propOrder = {
    "ftHinweisFunktion",
    "ftzbsMerkmaleLa",
    "ftzbsTyp",
    "laenge1",
    "lmg",
    "massgebendeNeig1",
    "massgebendeNeigSchutzstrecke",
    "mastschild",
    "schutzstreckeErforderlich",
    "schutzstreckeVorhanden",
    "telegrammnummer",
    "vBefehlR",
    "vBefehlZ",
    "vFrei",
    "vZulStrecke",
    "vgr1",
    "vgr2"
})
public class CFTZBSMerkmale {

    @XmlElement(name = "FT_Hinweis_Funktion")
    protected TCFTHinweisFunktion ftHinweisFunktion;
    @XmlElement(name = "FT_ZBS_Merkmale_La")
    protected List<CFTZBSMerkmaleLa> ftzbsMerkmaleLa;
    @XmlElement(name = "FT_ZBS_Typ", required = true)
    protected TCFTZBSTyp ftzbsTyp;
    @XmlElement(name = "Laenge_1")
    protected TCLaenge1 laenge1;
    @XmlElement(name = "LM_G", required = true)
    protected TCLMG lmg;
    @XmlElement(name = "Massgebende_Neig_1")
    protected TCMassgebendeNeig1 massgebendeNeig1;
    @XmlElement(name = "Massgebende_Neig_Schutzstrecke")
    protected TCMassgebendeNeigSchutzstrecke massgebendeNeigSchutzstrecke;
    @XmlElement(name = "Mastschild", required = true)
    protected TCMastschild mastschild;
    @XmlElement(name = "Schutzstrecke_Erforderlich")
    protected TCSchutzstreckeErforderlich schutzstreckeErforderlich;
    @XmlElement(name = "Schutzstrecke_Vorhanden")
    protected TCSchutzstreckeVorhanden schutzstreckeVorhanden;
    @XmlElement(name = "Telegrammnummer", required = true)
    protected TCTelegrammnummer telegrammnummer;
    @XmlElement(name = "V_Befehl_R")
    protected TCVBefehlR vBefehlR;
    @XmlElement(name = "V_Befehl_Z")
    protected TCVBefehlZ vBefehlZ;
    @XmlElement(name = "V_Frei")
    protected TCVFrei vFrei;
    @XmlElement(name = "V_Zul_Strecke")
    protected TCVZulStrecke vZulStrecke;
    @XmlElement(name = "VGR_1")
    protected TCVGR1 vgr1;
    @XmlElement(name = "VGR_2")
    protected TCVGR2 vgr2;

    /**
     * Ruft den Wert der ftHinweisFunktion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFTHinweisFunktion }
     *     
     */
    public TCFTHinweisFunktion getFTHinweisFunktion() {
        return ftHinweisFunktion;
    }

    /**
     * Legt den Wert der ftHinweisFunktion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFTHinweisFunktion }
     *     
     */
    public void setFTHinweisFunktion(TCFTHinweisFunktion value) {
        this.ftHinweisFunktion = value;
    }

    /**
     * Gets the value of the ftzbsMerkmaleLa property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ftzbsMerkmaleLa property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFTZBSMerkmaleLa().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFTZBSMerkmaleLa }
     * 
     * 
     */
    public List<CFTZBSMerkmaleLa> getFTZBSMerkmaleLa() {
        if (ftzbsMerkmaleLa == null) {
            ftzbsMerkmaleLa = new ArrayList<CFTZBSMerkmaleLa>();
        }
        return this.ftzbsMerkmaleLa;
    }

    /**
     * Ruft den Wert der ftzbsTyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFTZBSTyp }
     *     
     */
    public TCFTZBSTyp getFTZBSTyp() {
        return ftzbsTyp;
    }

    /**
     * Legt den Wert der ftzbsTyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFTZBSTyp }
     *     
     */
    public void setFTZBSTyp(TCFTZBSTyp value) {
        this.ftzbsTyp = value;
    }

    /**
     * Ruft den Wert der laenge1-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLaenge1 }
     *     
     */
    public TCLaenge1 getLaenge1() {
        return laenge1;
    }

    /**
     * Legt den Wert der laenge1-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLaenge1 }
     *     
     */
    public void setLaenge1(TCLaenge1 value) {
        this.laenge1 = value;
    }

    /**
     * Ruft den Wert der lmg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLMG }
     *     
     */
    public TCLMG getLMG() {
        return lmg;
    }

    /**
     * Legt den Wert der lmg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLMG }
     *     
     */
    public void setLMG(TCLMG value) {
        this.lmg = value;
    }

    /**
     * Ruft den Wert der massgebendeNeig1-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCMassgebendeNeig1 }
     *     
     */
    public TCMassgebendeNeig1 getMassgebendeNeig1() {
        return massgebendeNeig1;
    }

    /**
     * Legt den Wert der massgebendeNeig1-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCMassgebendeNeig1 }
     *     
     */
    public void setMassgebendeNeig1(TCMassgebendeNeig1 value) {
        this.massgebendeNeig1 = value;
    }

    /**
     * Ruft den Wert der massgebendeNeigSchutzstrecke-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCMassgebendeNeigSchutzstrecke }
     *     
     */
    public TCMassgebendeNeigSchutzstrecke getMassgebendeNeigSchutzstrecke() {
        return massgebendeNeigSchutzstrecke;
    }

    /**
     * Legt den Wert der massgebendeNeigSchutzstrecke-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCMassgebendeNeigSchutzstrecke }
     *     
     */
    public void setMassgebendeNeigSchutzstrecke(TCMassgebendeNeigSchutzstrecke value) {
        this.massgebendeNeigSchutzstrecke = value;
    }

    /**
     * Ruft den Wert der mastschild-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCMastschild }
     *     
     */
    public TCMastschild getMastschild() {
        return mastschild;
    }

    /**
     * Legt den Wert der mastschild-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCMastschild }
     *     
     */
    public void setMastschild(TCMastschild value) {
        this.mastschild = value;
    }

    /**
     * Ruft den Wert der schutzstreckeErforderlich-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSchutzstreckeErforderlich }
     *     
     */
    public TCSchutzstreckeErforderlich getSchutzstreckeErforderlich() {
        return schutzstreckeErforderlich;
    }

    /**
     * Legt den Wert der schutzstreckeErforderlich-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSchutzstreckeErforderlich }
     *     
     */
    public void setSchutzstreckeErforderlich(TCSchutzstreckeErforderlich value) {
        this.schutzstreckeErforderlich = value;
    }

    /**
     * Ruft den Wert der schutzstreckeVorhanden-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSchutzstreckeVorhanden }
     *     
     */
    public TCSchutzstreckeVorhanden getSchutzstreckeVorhanden() {
        return schutzstreckeVorhanden;
    }

    /**
     * Legt den Wert der schutzstreckeVorhanden-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSchutzstreckeVorhanden }
     *     
     */
    public void setSchutzstreckeVorhanden(TCSchutzstreckeVorhanden value) {
        this.schutzstreckeVorhanden = value;
    }

    /**
     * Ruft den Wert der telegrammnummer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTelegrammnummer }
     *     
     */
    public TCTelegrammnummer getTelegrammnummer() {
        return telegrammnummer;
    }

    /**
     * Legt den Wert der telegrammnummer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTelegrammnummer }
     *     
     */
    public void setTelegrammnummer(TCTelegrammnummer value) {
        this.telegrammnummer = value;
    }

    /**
     * Ruft den Wert der vBefehlR-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVBefehlR }
     *     
     */
    public TCVBefehlR getVBefehlR() {
        return vBefehlR;
    }

    /**
     * Legt den Wert der vBefehlR-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVBefehlR }
     *     
     */
    public void setVBefehlR(TCVBefehlR value) {
        this.vBefehlR = value;
    }

    /**
     * Ruft den Wert der vBefehlZ-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVBefehlZ }
     *     
     */
    public TCVBefehlZ getVBefehlZ() {
        return vBefehlZ;
    }

    /**
     * Legt den Wert der vBefehlZ-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVBefehlZ }
     *     
     */
    public void setVBefehlZ(TCVBefehlZ value) {
        this.vBefehlZ = value;
    }

    /**
     * Ruft den Wert der vFrei-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVFrei }
     *     
     */
    public TCVFrei getVFrei() {
        return vFrei;
    }

    /**
     * Legt den Wert der vFrei-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVFrei }
     *     
     */
    public void setVFrei(TCVFrei value) {
        this.vFrei = value;
    }

    /**
     * Ruft den Wert der vZulStrecke-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVZulStrecke }
     *     
     */
    public TCVZulStrecke getVZulStrecke() {
        return vZulStrecke;
    }

    /**
     * Legt den Wert der vZulStrecke-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVZulStrecke }
     *     
     */
    public void setVZulStrecke(TCVZulStrecke value) {
        this.vZulStrecke = value;
    }

    /**
     * Ruft den Wert der vgr1-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVGR1 }
     *     
     */
    public TCVGR1 getVGR1() {
        return vgr1;
    }

    /**
     * Legt den Wert der vgr1-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVGR1 }
     *     
     */
    public void setVGR1(TCVGR1 value) {
        this.vgr1 = value;
    }

    /**
     * Ruft den Wert der vgr2-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVGR2 }
     *     
     */
    public TCVGR2 getVGR2() {
        return vgr2;
    }

    /**
     * Legt den Wert der vgr2-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVGR2 }
     *     
     */
    public void setVGR2(TCVGR2 value) {
        this.vgr2 = value;
    }

}
