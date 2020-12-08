//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDFTAnschaltbedingung;
import plan_pro.modell.verweise._1_9_0.TCIDFachtelegramm;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CDP_Telegramm complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CDP_Telegramm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_Fachtelegramm" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fachtelegramm" maxOccurs="unbounded"/>
 *         &lt;element name="ID_FT_Anschaltbedingung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_FT_Anschaltbedingung" maxOccurs="unbounded"/>
 *         &lt;element name="SRS_Unterversion" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCSRS_Unterversion"/>
 *         &lt;element name="SRS_Version" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCSRS_Version"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CDP_Telegramm", propOrder = {
    "idFachtelegramm",
    "idftAnschaltbedingung",
    "srsUnterversion",
    "srsVersion"
})
public class CDPTelegramm {

    @XmlElement(name = "ID_Fachtelegramm", required = true)
    protected List<TCIDFachtelegramm> idFachtelegramm;
    @XmlElement(name = "ID_FT_Anschaltbedingung", required = true)
    protected List<TCIDFTAnschaltbedingung> idftAnschaltbedingung;
    @XmlElement(name = "SRS_Unterversion", required = true)
    protected TCSRSUnterversion srsUnterversion;
    @XmlElement(name = "SRS_Version", required = true)
    protected TCSRSVersion srsVersion;

    /**
     * Gets the value of the idFachtelegramm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idFachtelegramm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDFachtelegramm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDFachtelegramm }
     * 
     * 
     */
    public List<TCIDFachtelegramm> getIDFachtelegramm() {
        if (idFachtelegramm == null) {
            idFachtelegramm = new ArrayList<TCIDFachtelegramm>();
        }
        return this.idFachtelegramm;
    }

    /**
     * Gets the value of the idftAnschaltbedingung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idftAnschaltbedingung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDFTAnschaltbedingung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDFTAnschaltbedingung }
     * 
     * 
     */
    public List<TCIDFTAnschaltbedingung> getIDFTAnschaltbedingung() {
        if (idftAnschaltbedingung == null) {
            idftAnschaltbedingung = new ArrayList<TCIDFTAnschaltbedingung>();
        }
        return this.idftAnschaltbedingung;
    }

    /**
     * Ruft den Wert der srsUnterversion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSRSUnterversion }
     *     
     */
    public TCSRSUnterversion getSRSUnterversion() {
        return srsUnterversion;
    }

    /**
     * Legt den Wert der srsUnterversion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSRSUnterversion }
     *     
     */
    public void setSRSUnterversion(TCSRSUnterversion value) {
        this.srsUnterversion = value;
    }

    /**
     * Ruft den Wert der srsVersion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSRSVersion }
     *     
     */
    public TCSRSVersion getSRSVersion() {
        return srsVersion;
    }

    /**
     * Legt den Wert der srsVersion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSRSVersion }
     *     
     */
    public void setSRSVersion(TCSRSVersion value) {
        this.srsVersion = value;
    }

}
