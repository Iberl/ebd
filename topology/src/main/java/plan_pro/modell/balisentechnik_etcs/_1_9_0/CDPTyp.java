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


/**
 * <p>Java-Klasse f�r CDP_Typ complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CDP_Typ">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DP_Typ_Art" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDP_Typ_Art"/>
 *         &lt;choice>
 *           &lt;element name="DP_Typ_GESG" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CDP_Typ_GESG"/>
 *           &lt;element name="DP_Typ_GETCS" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CDP_Typ_GETCS"/>
 *           &lt;element name="DP_Typ_GGNT" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CDP_Typ_GGNT"/>
 *           &lt;element name="DP_Typ_GSonst" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CDP_Typ_GSonst"/>
 *           &lt;element name="DP_Typ_GTrans" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CDP_Typ_GTrans"/>
 *           &lt;element name="DP_Typ_GZBS" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}CDP_Typ_GZBS"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CDP_Typ", propOrder = {
    "dpTypArt",
    "dpTypGESG",
    "dpTypGETCS",
    "dpTypGGNT",
    "dpTypGSonst",
    "dpTypGTrans",
    "dpTypGZBS"
})
public class CDPTyp {

    @XmlElement(name = "DP_Typ_Art", required = true)
    protected TCDPTypArt dpTypArt;
    @XmlElement(name = "DP_Typ_GESG")
    protected CDPTypGESG dpTypGESG;
    @XmlElement(name = "DP_Typ_GETCS")
    protected CDPTypGETCS dpTypGETCS;
    @XmlElement(name = "DP_Typ_GGNT")
    protected CDPTypGGNT dpTypGGNT;
    @XmlElement(name = "DP_Typ_GSonst")
    protected CDPTypGSonst dpTypGSonst;
    @XmlElement(name = "DP_Typ_GTrans")
    protected CDPTypGTrans dpTypGTrans;
    @XmlElement(name = "DP_Typ_GZBS")
    protected CDPTypGZBS dpTypGZBS;

    /**
     * Ruft den Wert der dpTypArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDPTypArt }
     *     
     */
    public TCDPTypArt getDPTypArt() {
        return dpTypArt;
    }

    /**
     * Legt den Wert der dpTypArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDPTypArt }
     *     
     */
    public void setDPTypArt(TCDPTypArt value) {
        this.dpTypArt = value;
    }

    /**
     * Ruft den Wert der dpTypGESG-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CDPTypGESG }
     *     
     */
    public CDPTypGESG getDPTypGESG() {
        return dpTypGESG;
    }

    /**
     * Legt den Wert der dpTypGESG-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CDPTypGESG }
     *     
     */
    public void setDPTypGESG(CDPTypGESG value) {
        this.dpTypGESG = value;
    }

    /**
     * Ruft den Wert der dpTypGETCS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CDPTypGETCS }
     *     
     */
    public CDPTypGETCS getDPTypGETCS() {
        return dpTypGETCS;
    }

    /**
     * Legt den Wert der dpTypGETCS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CDPTypGETCS }
     *     
     */
    public void setDPTypGETCS(CDPTypGETCS value) {
        this.dpTypGETCS = value;
    }

    /**
     * Ruft den Wert der dpTypGGNT-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CDPTypGGNT }
     *     
     */
    public CDPTypGGNT getDPTypGGNT() {
        return dpTypGGNT;
    }

    /**
     * Legt den Wert der dpTypGGNT-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CDPTypGGNT }
     *     
     */
    public void setDPTypGGNT(CDPTypGGNT value) {
        this.dpTypGGNT = value;
    }

    /**
     * Ruft den Wert der dpTypGSonst-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CDPTypGSonst }
     *     
     */
    public CDPTypGSonst getDPTypGSonst() {
        return dpTypGSonst;
    }

    /**
     * Legt den Wert der dpTypGSonst-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CDPTypGSonst }
     *     
     */
    public void setDPTypGSonst(CDPTypGSonst value) {
        this.dpTypGSonst = value;
    }

    /**
     * Ruft den Wert der dpTypGTrans-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CDPTypGTrans }
     *     
     */
    public CDPTypGTrans getDPTypGTrans() {
        return dpTypGTrans;
    }

    /**
     * Legt den Wert der dpTypGTrans-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CDPTypGTrans }
     *     
     */
    public void setDPTypGTrans(CDPTypGTrans value) {
        this.dpTypGTrans = value;
    }

    /**
     * Ruft den Wert der dpTypGZBS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CDPTypGZBS }
     *     
     */
    public CDPTypGZBS getDPTypGZBS() {
        return dpTypGZBS;
    }

    /**
     * Legt den Wert der dpTypGZBS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CDPTypGZBS }
     *     
     */
    public void setDPTypGZBS(CDPTypGZBS value) {
        this.dpTypGZBS = value;
    }

}
