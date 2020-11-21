//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDRBC;
import plan_pro.modell.verweise._1_9_0.TCIDSignal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CZUB_Bereichsgrenze_Nach_L2 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZUB_Bereichsgrenze_Nach_L2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Abstand_Grenze_Bereich_C" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCAbstand_Grenze_Bereich_C"/>
 *         &lt;element name="Baseline_SRS" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCBaseline_SRS"/>
 *         &lt;element name="Bgrenze_Nach_L2_Bed_Einstieg" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CBgrenze_Nach_L2_Bed_Einstieg" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Einstieg_Ohne_Rueckw_Sig" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCEinstieg_Ohne_Rueckw_Sig" minOccurs="0"/>
 *         &lt;element name="ID_RBC_Nach_Grenze" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_RBC"/>
 *         &lt;element name="ID_Signal_Zufahrtsicherung_L2oS" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Prioritaet" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCPrioritaet" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZUB_Bereichsgrenze_Nach_L2", propOrder = {
    "abstandGrenzeBereichC",
    "baselineSRS",
    "bgrenzeNachL2BedEinstieg",
    "einstiegOhneRueckwSig",
    "idrbcNachGrenze",
    "idSignalZufahrtsicherungL2OS",
    "prioritaet"
})
public class CZUBBereichsgrenzeNachL2 {

    @XmlElement(name = "Abstand_Grenze_Bereich_C", required = true)
    protected TCAbstandGrenzeBereichC abstandGrenzeBereichC;
    @XmlElement(name = "Baseline_SRS", required = true)
    protected TCBaselineSRS baselineSRS;
    @XmlElement(name = "Bgrenze_Nach_L2_Bed_Einstieg")
    protected List<CBgrenzeNachL2BedEinstieg> bgrenzeNachL2BedEinstieg;
    @XmlElement(name = "Einstieg_Ohne_Rueckw_Sig")
    protected TCEinstiegOhneRueckwSig einstiegOhneRueckwSig;
    @XmlElement(name = "ID_RBC_Nach_Grenze", required = true)
    protected TCIDRBC idrbcNachGrenze;
    @XmlElement(name = "ID_Signal_Zufahrtsicherung_L2oS")
    protected List<TCIDSignal> idSignalZufahrtsicherungL2OS;
    @XmlElement(name = "Prioritaet")
    protected TCPrioritaet prioritaet;

    /**
     * Ruft den Wert der abstandGrenzeBereichC-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAbstandGrenzeBereichC }
     *     
     */
    public TCAbstandGrenzeBereichC getAbstandGrenzeBereichC() {
        return abstandGrenzeBereichC;
    }

    /**
     * Legt den Wert der abstandGrenzeBereichC-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAbstandGrenzeBereichC }
     *     
     */
    public void setAbstandGrenzeBereichC(TCAbstandGrenzeBereichC value) {
        this.abstandGrenzeBereichC = value;
    }

    /**
     * Ruft den Wert der baselineSRS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBaselineSRS }
     *     
     */
    public TCBaselineSRS getBaselineSRS() {
        return baselineSRS;
    }

    /**
     * Legt den Wert der baselineSRS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBaselineSRS }
     *     
     */
    public void setBaselineSRS(TCBaselineSRS value) {
        this.baselineSRS = value;
    }

    /**
     * Gets the value of the bgrenzeNachL2BedEinstieg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bgrenzeNachL2BedEinstieg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBgrenzeNachL2BedEinstieg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBgrenzeNachL2BedEinstieg }
     * 
     * 
     */
    public List<CBgrenzeNachL2BedEinstieg> getBgrenzeNachL2BedEinstieg() {
        if (bgrenzeNachL2BedEinstieg == null) {
            bgrenzeNachL2BedEinstieg = new ArrayList<CBgrenzeNachL2BedEinstieg>();
        }
        return this.bgrenzeNachL2BedEinstieg;
    }

    /**
     * Ruft den Wert der einstiegOhneRueckwSig-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEinstiegOhneRueckwSig }
     *     
     */
    public TCEinstiegOhneRueckwSig getEinstiegOhneRueckwSig() {
        return einstiegOhneRueckwSig;
    }

    /**
     * Legt den Wert der einstiegOhneRueckwSig-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEinstiegOhneRueckwSig }
     *     
     */
    public void setEinstiegOhneRueckwSig(TCEinstiegOhneRueckwSig value) {
        this.einstiegOhneRueckwSig = value;
    }

    /**
     * Ruft den Wert der idrbcNachGrenze-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDRBC }
     *     
     */
    public TCIDRBC getIDRBCNachGrenze() {
        return idrbcNachGrenze;
    }

    /**
     * Legt den Wert der idrbcNachGrenze-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDRBC }
     *     
     */
    public void setIDRBCNachGrenze(TCIDRBC value) {
        this.idrbcNachGrenze = value;
    }

    /**
     * Gets the value of the idSignalZufahrtsicherungL2OS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idSignalZufahrtsicherungL2OS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDSignalZufahrtsicherungL2OS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDSignal }
     * 
     * 
     */
    public List<TCIDSignal> getIDSignalZufahrtsicherungL2OS() {
        if (idSignalZufahrtsicherungL2OS == null) {
            idSignalZufahrtsicherungL2OS = new ArrayList<TCIDSignal>();
        }
        return this.idSignalZufahrtsicherungL2OS;
    }

    /**
     * Ruft den Wert der prioritaet-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPrioritaet }
     *     
     */
    public TCPrioritaet getPrioritaet() {
        return prioritaet;
    }

    /**
     * Legt den Wert der prioritaet-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPrioritaet }
     *     
     */
    public void setPrioritaet(TCPrioritaet value) {
        this.prioritaet = value;
    }

}
