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
 * <p>Java-Klasse f�r CFT_ETCS_L2_Merkmale complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFT_ETCS_L2_Merkmale">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FT_ETCS_L2_Typ" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCFT_ETCS_L2_Typ"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFT_ETCS_L2_Merkmale", propOrder = {
    "ftetcsl2Typ"
})
public class CFTETCSL2Merkmale {

    @XmlElement(name = "FT_ETCS_L2_Typ", required = true)
    protected TCFTETCSL2Typ ftetcsl2Typ;

    /**
     * Ruft den Wert der ftetcsl2Typ-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFTETCSL2Typ }
     *     
     */
    public TCFTETCSL2Typ getFTETCSL2Typ() {
        return ftetcsl2Typ;
    }

    /**
     * Legt den Wert der ftetcsl2Typ-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFTETCSL2Typ }
     *     
     */
    public void setFTETCSL2Typ(TCFTETCSL2Typ value) {
        this.ftetcsl2Typ = value;
    }

}
