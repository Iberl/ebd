//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bahnuebergang._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBUE_Abhaengigkeit_Hp complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Abhaengigkeit_Hp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BUE_Betriebsartenstecker" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}TCBUE_Betriebsartenstecker"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Abhaengigkeit_Hp", propOrder = {
    "bueBetriebsartenstecker"
})
public class CBUEAbhaengigkeitHp {

    @XmlElement(name = "BUE_Betriebsartenstecker", required = true)
    protected TCBUEBetriebsartenstecker bueBetriebsartenstecker;

    /**
     * Ruft den Wert der bueBetriebsartenstecker-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBUEBetriebsartenstecker }
     *     
     */
    public TCBUEBetriebsartenstecker getBUEBetriebsartenstecker() {
        return bueBetriebsartenstecker;
    }

    /**
     * Legt den Wert der bueBetriebsartenstecker-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBUEBetriebsartenstecker }
     *     
     */
    public void setBUEBetriebsartenstecker(TCBUEBetriebsartenstecker value) {
        this.bueBetriebsartenstecker = value;
    }

}
