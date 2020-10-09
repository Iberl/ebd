//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.zugnummernmeldeanlage._1_8;

import modell.verweise._1_8.TCIDFstrZugRangier;
import modell.verweise._1_8.TCIDZLVBus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CTelegramm_85_Einzelne_Fstr complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CTelegramm_85_Einzelne_Fstr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_Fstr_Zug_Rangier" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Fstr_Zug_Rangier"/>
 *         &lt;element name="ID_ZLV_Bus" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_ZLV_Bus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTelegramm_85_Einzelne_Fstr", propOrder = {
    "idFstrZugRangier",
    "idzlvBus"
})
public class CTelegramm85EinzelneFstr {

    @XmlElement(name = "ID_Fstr_Zug_Rangier", required = true)
    protected TCIDFstrZugRangier idFstrZugRangier;
    @XmlElement(name = "ID_ZLV_Bus")
    protected TCIDZLVBus idzlvBus;

    /**
     * Ruft den Wert der idFstrZugRangier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDFstrZugRangier }
     *     
     */
    public TCIDFstrZugRangier getIDFstrZugRangier() {
        return idFstrZugRangier;
    }

    /**
     * Legt den Wert der idFstrZugRangier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDFstrZugRangier }
     *     
     */
    public void setIDFstrZugRangier(TCIDFstrZugRangier value) {
        this.idFstrZugRangier = value;
    }

    /**
     * Ruft den Wert der idzlvBus-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZLVBus }
     *     
     */
    public TCIDZLVBus getIDZLVBus() {
        return idzlvBus;
    }

    /**
     * Legt den Wert der idzlvBus-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZLVBus }
     *     
     */
    public void setIDZLVBus(TCIDZLVBus value) {
        this.idzlvBus = value;
    }

}
