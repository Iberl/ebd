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
 * <p>Java-Klasse f�r CLEU_Anlage_Moduleigenschaften complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CLEU_Anlage_Moduleigenschaften">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LEU_Ausgang_Nr" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCLEU_Ausgang_Nr" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLEU_Anlage_Moduleigenschaften", propOrder = {
    "leuAusgangNr"
})
public class CLEUAnlageModuleigenschaften {

    @XmlElement(name = "LEU_Ausgang_Nr")
    protected TCLEUAusgangNr leuAusgangNr;

    /**
     * Ruft den Wert der leuAusgangNr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLEUAusgangNr }
     *     
     */
    public TCLEUAusgangNr getLEUAusgangNr() {
        return leuAusgangNr;
    }

    /**
     * Legt den Wert der leuAusgangNr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLEUAusgangNr }
     *     
     */
    public void setLEUAusgangNr(TCLEUAusgangNr value) {
        this.leuAusgangNr = value;
    }

}
