//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.signale._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSignal_PZB complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSignal_PZB">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PZB_Schutzstrecke_Soll" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCPZB_Schutzstrecke_Soll"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSignal_PZB", propOrder = {
    "pzbSchutzstreckeSoll"
})
public class CSignalPZB {

    @XmlElement(name = "PZB_Schutzstrecke_Soll", required = true)
    protected TCPZBSchutzstreckeSoll pzbSchutzstreckeSoll;

    /**
     * Ruft den Wert der pzbSchutzstreckeSoll-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPZBSchutzstreckeSoll }
     *     
     */
    public TCPZBSchutzstreckeSoll getPZBSchutzstreckeSoll() {
        return pzbSchutzstreckeSoll;
    }

    /**
     * Legt den Wert der pzbSchutzstreckeSoll-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPZBSchutzstreckeSoll }
     *     
     */
    public void setPZBSchutzstreckeSoll(TCPZBSchutzstreckeSoll value) {
        this.pzbSchutzstreckeSoll = value;
    }

}
