//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDQuellelement;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CEV_Modul_Virtuell complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CEV_Modul_Virtuell">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_Quellelement" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Quellelement"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CEV_Modul_Virtuell", propOrder = {
    "idQuellelement"
})
public class CEVModulVirtuell {

    @XmlElement(name = "ID_Quellelement", required = true)
    protected TCIDQuellelement idQuellelement;

    /**
     * Ruft den Wert der idQuellelement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDQuellelement }
     *     
     */
    public TCIDQuellelement getIDQuellelement() {
        return idQuellelement;
    }

    /**
     * Legt den Wert der idQuellelement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDQuellelement }
     *     
     */
    public void setIDQuellelement(TCIDQuellelement value) {
        this.idQuellelement = value;
    }

}
