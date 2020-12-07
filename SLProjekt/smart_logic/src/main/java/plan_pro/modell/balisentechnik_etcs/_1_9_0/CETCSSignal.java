//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDMarkanterPunkt;
import plan_pro.modell.verweise._1_9_0.TCIDRBC;
import plan_pro.modell.verweise._1_9_0.TCIDSignalOhneProxy;
import plan_pro.modell.verweise._1_9_0.TCIDTechnischerPunkt;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Zusatzangaben f�r Signale im Zusammenhang mit ETCS L2.
 * 
 * <p>Java-Klasse f�r CETCS_Signal complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CETCS_Signal">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="ETCS_Signal_Allg" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CETCS_Signal_Allg"/>
 *         &lt;element name="ETCS_Signal_DWeg" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CETCS_Signal_DWeg" minOccurs="0"/>
 *         &lt;element name="ETCS_Signal_TBV" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CETCS_Signal_TBV" minOccurs="0"/>
 *         &lt;element name="ID_ETCS_Gefahrpunkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Markanter_Punkt" minOccurs="0"/>
 *         &lt;element name="ID_HOA_FBOA" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Technischer_Punkt" minOccurs="0"/>
 *         &lt;element name="ID_RBC" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_RBC" maxOccurs="unbounded"/>
 *         &lt;element name="ID_Signal" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Signal_ohne_Proxy"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CETCS_Signal", propOrder = {
    "etcsSignalAllg",
    "etcsSignalDWeg",
    "etcsSignalTBV",
    "idetcsGefahrpunkt",
    "idhoafboa",
    "idrbc",
    "idSignal"
})
public class CETCSSignal
    extends CBasisObjekt
{

    @XmlElement(name = "ETCS_Signal_Allg", required = true)
    protected CETCSSignalAllg etcsSignalAllg;
    @XmlElement(name = "ETCS_Signal_DWeg")
    protected CETCSSignalDWeg etcsSignalDWeg;
    @XmlElement(name = "ETCS_Signal_TBV")
    protected CETCSSignalTBV etcsSignalTBV;
    @XmlElement(name = "ID_ETCS_Gefahrpunkt")
    protected TCIDMarkanterPunkt idetcsGefahrpunkt;
    @XmlElement(name = "ID_HOA_FBOA")
    protected TCIDTechnischerPunkt idhoafboa;
    @XmlElement(name = "ID_RBC", required = true)
    protected List<TCIDRBC> idrbc;
    @XmlElement(name = "ID_Signal", required = true)
    protected TCIDSignalOhneProxy idSignal;

    /**
     * Ruft den Wert der etcsSignalAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CETCSSignalAllg }
     *     
     */
    public CETCSSignalAllg getETCSSignalAllg() {
        return etcsSignalAllg;
    }

    /**
     * Legt den Wert der etcsSignalAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CETCSSignalAllg }
     *     
     */
    public void setETCSSignalAllg(CETCSSignalAllg value) {
        this.etcsSignalAllg = value;
    }

    /**
     * Ruft den Wert der etcsSignalDWeg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CETCSSignalDWeg }
     *     
     */
    public CETCSSignalDWeg getETCSSignalDWeg() {
        return etcsSignalDWeg;
    }

    /**
     * Legt den Wert der etcsSignalDWeg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CETCSSignalDWeg }
     *     
     */
    public void setETCSSignalDWeg(CETCSSignalDWeg value) {
        this.etcsSignalDWeg = value;
    }

    /**
     * Ruft den Wert der etcsSignalTBV-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CETCSSignalTBV }
     *     
     */
    public CETCSSignalTBV getETCSSignalTBV() {
        return etcsSignalTBV;
    }

    /**
     * Legt den Wert der etcsSignalTBV-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CETCSSignalTBV }
     *     
     */
    public void setETCSSignalTBV(CETCSSignalTBV value) {
        this.etcsSignalTBV = value;
    }

    /**
     * Ruft den Wert der idetcsGefahrpunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDMarkanterPunkt }
     *     
     */
    public TCIDMarkanterPunkt getIDETCSGefahrpunkt() {
        return idetcsGefahrpunkt;
    }

    /**
     * Legt den Wert der idetcsGefahrpunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDMarkanterPunkt }
     *     
     */
    public void setIDETCSGefahrpunkt(TCIDMarkanterPunkt value) {
        this.idetcsGefahrpunkt = value;
    }

    /**
     * Ruft den Wert der idhoafboa-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDTechnischerPunkt }
     *     
     */
    public TCIDTechnischerPunkt getIDHOAFBOA() {
        return idhoafboa;
    }

    /**
     * Legt den Wert der idhoafboa-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDTechnischerPunkt }
     *     
     */
    public void setIDHOAFBOA(TCIDTechnischerPunkt value) {
        this.idhoafboa = value;
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
     * Ruft den Wert der idSignal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSignalOhneProxy }
     *     
     */
    public TCIDSignalOhneProxy getIDSignal() {
        return idSignal;
    }

    /**
     * Legt den Wert der idSignal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSignalOhneProxy }
     *     
     */
    public void setIDSignal(TCIDSignalOhneProxy value) {
        this.idSignal = value;
    }

}
