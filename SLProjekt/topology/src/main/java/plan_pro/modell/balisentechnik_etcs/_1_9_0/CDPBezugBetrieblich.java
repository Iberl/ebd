//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDDPBezugspunkt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CDP_Bezug_Betrieblich complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CDP_Bezug_Betrieblich">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DP_Bezug_Betrieblich_Art" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDP_Bezug_Betrieblich_Art"/>
 *         &lt;element name="ID_DP_Bezugspunkt" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_DP_Bezugspunkt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CDP_Bezug_Betrieblich", propOrder = {
    "dpBezugBetrieblichArt",
    "iddpBezugspunkt"
})
public class CDPBezugBetrieblich {

    @XmlElement(name = "DP_Bezug_Betrieblich_Art", required = true)
    protected TCDPBezugBetrieblichArt dpBezugBetrieblichArt;
    @XmlElement(name = "ID_DP_Bezugspunkt")
    protected TCIDDPBezugspunkt iddpBezugspunkt;

    /**
     * Ruft den Wert der dpBezugBetrieblichArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDPBezugBetrieblichArt }
     *     
     */
    public TCDPBezugBetrieblichArt getDPBezugBetrieblichArt() {
        return dpBezugBetrieblichArt;
    }

    /**
     * Legt den Wert der dpBezugBetrieblichArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDPBezugBetrieblichArt }
     *     
     */
    public void setDPBezugBetrieblichArt(TCDPBezugBetrieblichArt value) {
        this.dpBezugBetrieblichArt = value;
    }

    /**
     * Ruft den Wert der iddpBezugspunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDDPBezugspunkt }
     *     
     */
    public TCIDDPBezugspunkt getIDDPBezugspunkt() {
        return iddpBezugspunkt;
    }

    /**
     * Legt den Wert der iddpBezugspunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDDPBezugspunkt }
     *     
     */
    public void setIDDPBezugspunkt(TCIDDPBezugspunkt value) {
        this.iddpBezugspunkt = value;
    }

}
