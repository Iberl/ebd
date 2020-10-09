//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.schluesselabhaengigkeiten._1_8;

import modell.verweise._1_8.TCIDBUEAnlage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSchloss_BUE complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchloss_BUE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BUE_Lage" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.8.0}TCBUE_Lage"/>
 *         &lt;element name="ID_BUE_Anlage" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_BUE_Anlage"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSchloss_BUE", propOrder = {
    "bueLage",
    "idbueAnlage"
})
public class CSchlossBUE {

    @XmlElement(name = "BUE_Lage", required = true)
    protected TCBUELage bueLage;
    @XmlElement(name = "ID_BUE_Anlage", required = true)
    protected TCIDBUEAnlage idbueAnlage;

    /**
     * Ruft den Wert der bueLage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBUELage }
     *     
     */
    public TCBUELage getBUELage() {
        return bueLage;
    }

    /**
     * Legt den Wert der bueLage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBUELage }
     *     
     */
    public void setBUELage(TCBUELage value) {
        this.bueLage = value;
    }

    /**
     * Ruft den Wert der idbueAnlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDBUEAnlage }
     *     
     */
    public TCIDBUEAnlage getIDBUEAnlage() {
        return idbueAnlage;
    }

    /**
     * Legt den Wert der idbueAnlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDBUEAnlage }
     *     
     */
    public void setIDBUEAnlage(TCIDBUEAnlage value) {
        this.idbueAnlage = value;
    }

}
