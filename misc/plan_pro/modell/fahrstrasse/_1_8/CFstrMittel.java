//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.fahrstrasse._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFstr_Mittel complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_Mittel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fstr_Mittel_V_Aufwertung" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}TCFstr_Mittel_V_Aufwertung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_Mittel", propOrder = {
    "fstrMittelVAufwertung"
})
public class CFstrMittel {

    @XmlElement(name = "Fstr_Mittel_V_Aufwertung", required = true)
    protected TCFstrMittelVAufwertung fstrMittelVAufwertung;

    /**
     * Ruft den Wert der fstrMittelVAufwertung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFstrMittelVAufwertung }
     *     
     */
    public TCFstrMittelVAufwertung getFstrMittelVAufwertung() {
        return fstrMittelVAufwertung;
    }

    /**
     * Legt den Wert der fstrMittelVAufwertung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFstrMittelVAufwertung }
     *     
     */
    public void setFstrMittelVAufwertung(TCFstrMittelVAufwertung value) {
        this.fstrMittelVAufwertung = value;
    }

}
