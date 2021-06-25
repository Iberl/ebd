//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.schluesselabhaengigkeiten._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDSchlosskombination;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSchloss_Sk complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchloss_Sk">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Hauptschloss" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.9.0.2}TCHauptschloss"/>
 *         &lt;element name="ID_Schlosskombination" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Schlosskombination"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSchloss_Sk", propOrder = {
    "hauptschloss",
    "idSchlosskombination"
})
public class CSchlossSk {

    @XmlElement(name = "Hauptschloss", required = true)
    protected TCHauptschloss hauptschloss;
    @XmlElement(name = "ID_Schlosskombination", required = true)
    protected TCIDSchlosskombination idSchlosskombination;

    /**
     * Ruft den Wert der hauptschloss-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHauptschloss }
     *     
     */
    public TCHauptschloss getHauptschloss() {
        return hauptschloss;
    }

    /**
     * Legt den Wert der hauptschloss-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHauptschloss }
     *     
     */
    public void setHauptschloss(TCHauptschloss value) {
        this.hauptschloss = value;
    }

    /**
     * Ruft den Wert der idSchlosskombination-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSchlosskombination }
     *     
     */
    public TCIDSchlosskombination getIDSchlosskombination() {
        return idSchlosskombination;
    }

    /**
     * Legt den Wert der idSchlosskombination-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSchlosskombination }
     *     
     */
    public void setIDSchlosskombination(TCIDSchlosskombination value) {
        this.idSchlosskombination = value;
    }

}
