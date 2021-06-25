//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.schluesselabhaengigkeiten._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDSchluesselsperre;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSchloss_Ssp complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchloss_Ssp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_Schluesselsperre" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Schluesselsperre"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSchloss_Ssp", propOrder = {
    "idSchluesselsperre"
})
public class CSchlossSsp {

    @XmlElement(name = "ID_Schluesselsperre", required = true)
    protected TCIDSchluesselsperre idSchluesselsperre;

    /**
     * Ruft den Wert der idSchluesselsperre-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDSchluesselsperre }
     *     
     */
    public TCIDSchluesselsperre getIDSchluesselsperre() {
        return idSchluesselsperre;
    }

    /**
     * Legt den Wert der idSchluesselsperre-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDSchluesselsperre }
     *     
     */
    public void setIDSchluesselsperre(TCIDSchluesselsperre value) {
        this.idSchluesselsperre = value;
    }

}
