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
 * <p>Java-Klasse f�r CZBS_Merkmale complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZBS_Merkmale">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DP_Link_Art" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDP_Link_Art"/>
 *         &lt;element name="ZBS_Reaktion" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCZBS_Reaktion"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZBS_Merkmale", propOrder = {
    "dpLinkArt",
    "zbsReaktion"
})
public class CZBSMerkmale {

    @XmlElement(name = "DP_Link_Art", required = true)
    protected TCDPLinkArt dpLinkArt;
    @XmlElement(name = "ZBS_Reaktion", required = true)
    protected TCZBSReaktion zbsReaktion;

    /**
     * Ruft den Wert der dpLinkArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDPLinkArt }
     *     
     */
    public TCDPLinkArt getDPLinkArt() {
        return dpLinkArt;
    }

    /**
     * Legt den Wert der dpLinkArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDPLinkArt }
     *     
     */
    public void setDPLinkArt(TCDPLinkArt value) {
        this.dpLinkArt = value;
    }

    /**
     * Ruft den Wert der zbsReaktion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZBSReaktion }
     *     
     */
    public TCZBSReaktion getZBSReaktion() {
        return zbsReaktion;
    }

    /**
     * Legt den Wert der zbsReaktion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZBSReaktion }
     *     
     */
    public void setZBSReaktion(TCZBSReaktion value) {
        this.zbsReaktion = value;
    }

}
