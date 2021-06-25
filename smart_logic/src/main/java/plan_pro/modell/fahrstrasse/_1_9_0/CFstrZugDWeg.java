//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDFstrDWeg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFstr_Zug_DWeg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_Zug_DWeg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DWeg_Vorzug" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCDWeg_Vorzug"/>
 *         &lt;element name="ID_Fstr_DWeg" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Fstr_DWeg"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_Zug_DWeg", propOrder = {
    "dWegVorzug",
    "idFstrDWeg"
})
public class CFstrZugDWeg {

    @XmlElement(name = "DWeg_Vorzug", required = true)
    protected TCDWegVorzug dWegVorzug;
    @XmlElement(name = "ID_Fstr_DWeg", required = true)
    protected TCIDFstrDWeg idFstrDWeg;

    /**
     * Ruft den Wert der dWegVorzug-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDWegVorzug }
     *     
     */
    public TCDWegVorzug getDWegVorzug() {
        return dWegVorzug;
    }

    /**
     * Legt den Wert der dWegVorzug-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDWegVorzug }
     *     
     */
    public void setDWegVorzug(TCDWegVorzug value) {
        this.dWegVorzug = value;
    }

    /**
     * Ruft den Wert der idFstrDWeg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFstrDWeg }
     *     
     */
    public TCIDFstrDWeg getIDFstrDWeg() {
        return idFstrDWeg;
    }

    /**
     * Legt den Wert der idFstrDWeg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFstrDWeg }
     *     
     */
    public void setIDFstrDWeg(TCIDFstrDWeg value) {
        this.idFstrDWeg = value;
    }

}
