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
 * <p>Java-Klasse f�r CDP_Typ_GTrans complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CDP_Typ_GTrans">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DP_Typ_Trans" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDP_Typ_Trans"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CDP_Typ_GTrans", propOrder = {
    "dpTypTrans"
})
public class CDPTypGTrans {

    @XmlElement(name = "DP_Typ_Trans", required = true)
    protected TCDPTypTrans dpTypTrans;

    /**
     * Ruft den Wert der dpTypTrans-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDPTypTrans }
     *     
     */
    public TCDPTypTrans getDPTypTrans() {
        return dpTypTrans;
    }

    /**
     * Legt den Wert der dpTypTrans-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDPTypTrans }
     *     
     */
    public void setDPTypTrans(TCDPTypTrans value) {
        this.dpTypTrans = value;
    }

}
