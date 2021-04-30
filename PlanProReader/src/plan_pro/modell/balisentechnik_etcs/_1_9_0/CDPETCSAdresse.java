//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CDP_ETCS_Adresse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CDP_ETCS_Adresse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ETCS_Adresse_Kennung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCETCS_Adresse_Kennung"/>
 *         &lt;element name="ETCS_Adresse_NID_BG" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCETCS_Adresse_NID_BG"/>
 *         &lt;element name="ETCS_Adresse_NID_C" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCETCS_Adresse_NID_C"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CDP_ETCS_Adresse", propOrder = {
    "etcsAdresseKennung",
    "etcsAdresseNIDBG",
    "etcsAdresseNIDC"
})
public class CDPETCSAdresse {

    @XmlElement(name = "ETCS_Adresse_Kennung", required = true)
    protected TCETCSAdresseKennung etcsAdresseKennung;
    @XmlElement(name = "ETCS_Adresse_NID_BG", required = true)
    protected TCETCSAdresseNIDBG etcsAdresseNIDBG;
    @XmlElement(name = "ETCS_Adresse_NID_C", required = true)
    protected TCETCSAdresseNIDC etcsAdresseNIDC;

    /**
     * Ruft den Wert der etcsAdresseKennung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCETCSAdresseKennung }
     *     
     */
    public TCETCSAdresseKennung getETCSAdresseKennung() {
        return etcsAdresseKennung;
    }

    /**
     * Legt den Wert der etcsAdresseKennung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCETCSAdresseKennung }
     *     
     */
    public void setETCSAdresseKennung(TCETCSAdresseKennung value) {
        this.etcsAdresseKennung = value;
    }

    /**
     * Ruft den Wert der etcsAdresseNIDBG-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCETCSAdresseNIDBG }
     *     
     */
    public TCETCSAdresseNIDBG getETCSAdresseNIDBG() {
        return etcsAdresseNIDBG;
    }

    /**
     * Legt den Wert der etcsAdresseNIDBG-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCETCSAdresseNIDBG }
     *     
     */
    public void setETCSAdresseNIDBG(TCETCSAdresseNIDBG value) {
        this.etcsAdresseNIDBG = value;
    }

    /**
     * Ruft den Wert der etcsAdresseNIDC-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCETCSAdresseNIDC }
     *     
     */
    public TCETCSAdresseNIDC getETCSAdresseNIDC() {
        return etcsAdresseNIDC;
    }

    /**
     * Legt den Wert der etcsAdresseNIDC-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCETCSAdresseNIDC }
     *     
     */
    public void setETCSAdresseNIDC(TCETCSAdresseNIDC value) {
        this.etcsAdresseNIDC = value;
    }

}
