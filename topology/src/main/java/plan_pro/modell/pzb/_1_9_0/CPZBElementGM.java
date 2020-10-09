//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.pzb._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CPZB_Element_GM complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPZB_Element_GM">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PZB_Abstand_GM" type="{http://www.plan-pro.org/modell/PZB/1.9.0.2}TCPZB_Abstand_GM" minOccurs="0"/>
 *         &lt;element name="PZB_INA" type="{http://www.plan-pro.org/modell/PZB/1.9.0.2}TCPZB_INA"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPZB_Element_GM", propOrder = {
    "pzbAbstandGM",
    "pzbina"
})
public class CPZBElementGM {

    @XmlElement(name = "PZB_Abstand_GM")
    protected TCPZBAbstandGM pzbAbstandGM;
    @XmlElement(name = "PZB_INA", required = true)
    protected TCPZBINA pzbina;

    /**
     * Ruft den Wert der pzbAbstandGM-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPZBAbstandGM }
     *     
     */
    public TCPZBAbstandGM getPZBAbstandGM() {
        return pzbAbstandGM;
    }

    /**
     * Legt den Wert der pzbAbstandGM-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPZBAbstandGM }
     *     
     */
    public void setPZBAbstandGM(TCPZBAbstandGM value) {
        this.pzbAbstandGM = value;
    }

    /**
     * Ruft den Wert der pzbina-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPZBINA }
     *     
     */
    public TCPZBINA getPZBINA() {
        return pzbina;
    }

    /**
     * Legt den Wert der pzbina-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPZBINA }
     *     
     */
    public void setPZBINA(TCPZBINA value) {
        this.pzbina = value;
    }

}
