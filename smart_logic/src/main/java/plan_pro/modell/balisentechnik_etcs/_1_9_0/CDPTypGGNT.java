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
 * <p>Java-Klasse f�r CDP_Typ_GGNT complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CDP_Typ_GGNT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TCDP_Typ_GNT" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDP_Typ_GNT"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CDP_Typ_GGNT", propOrder = {
    "tcdpTypGNT"
})
public class CDPTypGGNT {

    @XmlElement(name = "TCDP_Typ_GNT", required = true)
    protected TCDPTypGNT tcdpTypGNT;

    /**
     * Ruft den Wert der tcdpTypGNT-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDPTypGNT }
     *     
     */
    public TCDPTypGNT getTCDPTypGNT() {
        return tcdpTypGNT;
    }

    /**
     * Legt den Wert der tcdpTypGNT-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDPTypGNT }
     *     
     */
    public void setTCDPTypGNT(TCDPTypGNT value) {
        this.tcdpTypGNT = value;
    }

}
