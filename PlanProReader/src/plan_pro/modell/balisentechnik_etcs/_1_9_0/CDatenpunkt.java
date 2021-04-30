//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CPunktObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDMarkanterPunkt;
import plan_pro.modell.verweise._1_9_0.TCIDRBC;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Beeinflussungspunkt bestehend aus einer Einzelbalise oder Balisengruppe und ggf. einer LEU. In europ�ischen Spezifikationen wird der Begriff \"Balisengruppe\" auch synonym f�r \"Datenpunkt\" verwendet. Ein ungesteuerter Datenpunkt besteht ausschlie�lich aus ungesteuerten Balisen (Festdatenbalisen). Die Attributgruppe darf nur ausgew�hlt werden, wenn ausschlie�lich ESG-Telegramme enthalten sind.
 * 
 * <p>Java-Klasse f�r CDatenpunkt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CDatenpunkt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CPunkt_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Datenpunkt_Allg" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CDatenpunkt_Allg"/>
 *         &lt;element name="DP_Bezug_Betrieblich" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CDP_Bezug_Betrieblich" minOccurs="0"/>
 *         &lt;element name="DP_ETCS_Adresse" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CDP_ETCS_Adresse" minOccurs="0"/>
 *         &lt;element name="DP_Typ" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CDP_Typ" maxOccurs="unbounded"/>
 *         &lt;element name="ID_Einmesspunkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Markanter_Punkt" minOccurs="0"/>
 *         &lt;element name="ID_RBC" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_RBC" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LEU_Steuernde" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CLEU_Steuernde" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="DP_Telegramm" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CDP_Telegramm" maxOccurs="unbounded"/>
 *           &lt;element name="DP_Telegramm_ESG" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CDP_Telegramm_ESG" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CDatenpunkt", propOrder = {
    "datenpunktAllg",
    "dpBezugBetrieblich",
    "dpetcsAdresse",
    "dpTyp",
    "idEinmesspunkt",
    "idrbc",
    "leuSteuernde",
    "dpTelegramm",
    "dpTelegrammESG"
})
public class CDatenpunkt
    extends CPunktObjekt
{

    @XmlElement(name = "Datenpunkt_Allg", required = true)
    protected CDatenpunktAllg datenpunktAllg;
    @XmlElement(name = "DP_Bezug_Betrieblich")
    protected CDPBezugBetrieblich dpBezugBetrieblich;
    @XmlElement(name = "DP_ETCS_Adresse")
    protected CDPETCSAdresse dpetcsAdresse;
    @XmlElement(name = "DP_Typ", required = true)
    protected List<CDPTyp> dpTyp;
    @XmlElement(name = "ID_Einmesspunkt")
    protected TCIDMarkanterPunkt idEinmesspunkt;
    @XmlElement(name = "ID_RBC")
    protected List<TCIDRBC> idrbc;
    @XmlElement(name = "LEU_Steuernde")
    protected CLEUSteuernde leuSteuernde;
    @XmlElement(name = "DP_Telegramm")
    protected List<CDPTelegramm> dpTelegramm;
    @XmlElement(name = "DP_Telegramm_ESG")
    protected List<CDPTelegrammESG> dpTelegrammESG;

    /**
     * Ruft den Wert der datenpunktAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CDatenpunktAllg }
     *     
     */
    public CDatenpunktAllg getDatenpunktAllg() {
        return datenpunktAllg;
    }

    /**
     * Legt den Wert der datenpunktAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CDatenpunktAllg }
     *     
     */
    public void setDatenpunktAllg(CDatenpunktAllg value) {
        this.datenpunktAllg = value;
    }

    /**
     * Ruft den Wert der dpBezugBetrieblich-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CDPBezugBetrieblich }
     *     
     */
    public CDPBezugBetrieblich getDPBezugBetrieblich() {
        return dpBezugBetrieblich;
    }

    /**
     * Legt den Wert der dpBezugBetrieblich-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CDPBezugBetrieblich }
     *     
     */
    public void setDPBezugBetrieblich(CDPBezugBetrieblich value) {
        this.dpBezugBetrieblich = value;
    }

    /**
     * Ruft den Wert der dpetcsAdresse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CDPETCSAdresse }
     *     
     */
    public CDPETCSAdresse getDPETCSAdresse() {
        return dpetcsAdresse;
    }

    /**
     * Legt den Wert der dpetcsAdresse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CDPETCSAdresse }
     *     
     */
    public void setDPETCSAdresse(CDPETCSAdresse value) {
        this.dpetcsAdresse = value;
    }

    /**
     * Gets the value of the dpTyp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dpTyp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDPTyp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CDPTyp }
     * 
     * 
     */
    public List<CDPTyp> getDPTyp() {
        if (dpTyp == null) {
            dpTyp = new ArrayList<CDPTyp>();
        }
        return this.dpTyp;
    }

    /**
     * Ruft den Wert der idEinmesspunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDMarkanterPunkt }
     *     
     */
    public TCIDMarkanterPunkt getIDEinmesspunkt() {
        return idEinmesspunkt;
    }

    /**
     * Legt den Wert der idEinmesspunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDMarkanterPunkt }
     *     
     */
    public void setIDEinmesspunkt(TCIDMarkanterPunkt value) {
        this.idEinmesspunkt = value;
    }

    /**
     * Gets the value of the idrbc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idrbc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDRBC().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDRBC }
     * 
     * 
     */
    public List<TCIDRBC> getIDRBC() {
        if (idrbc == null) {
            idrbc = new ArrayList<TCIDRBC>();
        }
        return this.idrbc;
    }

    /**
     * Ruft den Wert der leuSteuernde-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CLEUSteuernde }
     *     
     */
    public CLEUSteuernde getLEUSteuernde() {
        return leuSteuernde;
    }

    /**
     * Legt den Wert der leuSteuernde-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CLEUSteuernde }
     *     
     */
    public void setLEUSteuernde(CLEUSteuernde value) {
        this.leuSteuernde = value;
    }

    /**
     * Gets the value of the dpTelegramm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dpTelegramm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDPTelegramm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CDPTelegramm }
     * 
     * 
     */
    public List<CDPTelegramm> getDPTelegramm() {
        if (dpTelegramm == null) {
            dpTelegramm = new ArrayList<CDPTelegramm>();
        }
        return this.dpTelegramm;
    }

    /**
     * Gets the value of the dpTelegrammESG property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dpTelegrammESG property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDPTelegrammESG().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CDPTelegrammESG }
     * 
     * 
     */
    public List<CDPTelegrammESG> getDPTelegrammESG() {
        if (dpTelegrammESG == null) {
            dpTelegrammESG = new ArrayList<CDPTelegrammESG>();
        }
        return this.dpTelegrammESG;
    }

}
