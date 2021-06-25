//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.fahrstrasse._1_9_0;

import javax.xml.bind.annotation.*;


/**
 * <p>Java-Klasse f�r CFstr_DWeg_W_Kr_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_DWeg_W_Kr_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fstr_DWeg_W_Kr" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.9.0.2}TCFstr_DWeg_W_Kr"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_DWeg_W_Kr_Allg", propOrder = {
    "fstrDWegWKr"
})
@XmlSeeAlso({
    CFstrDWegWKrAllgChild.class
})
public class CFstrDWegWKrAllg {

    @XmlElement(name = "Fstr_DWeg_W_Kr", required = true)
    protected TCFstrDWegWKr fstrDWegWKr;

    /**
     * Ruft den Wert der fstrDWegWKr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFstrDWegWKr }
     *     
     */
    public TCFstrDWegWKr getFstrDWegWKr() {
        return fstrDWegWKr;
    }

    /**
     * Legt den Wert der fstrDWegWKr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFstrDWegWKr }
     *     
     */
    public void setFstrDWegWKr(TCFstrDWegWKr value) {
        this.fstrDWegWKr = value;
    }

}
