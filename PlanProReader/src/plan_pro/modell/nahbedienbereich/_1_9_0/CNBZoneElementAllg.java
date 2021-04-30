//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.nahbedienbereich._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CNB_Zone_Element_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CNB_Zone_Element_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Freie_Stellbarkeit" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}TCFreie_Stellbarkeit" minOccurs="0"/>
 *         &lt;element name="NB_Rueckgabevoraussetzung" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}TCNB_Rueckgabevoraussetzung" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CNB_Zone_Element_Allg", propOrder = {
    "freieStellbarkeit",
    "nbRueckgabevoraussetzung"
})
public class CNBZoneElementAllg {

    @XmlElement(name = "Freie_Stellbarkeit")
    protected TCFreieStellbarkeit freieStellbarkeit;
    @XmlElement(name = "NB_Rueckgabevoraussetzung")
    protected TCNBRueckgabevoraussetzung nbRueckgabevoraussetzung;

    /**
     * Ruft den Wert der freieStellbarkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFreieStellbarkeit }
     *     
     */
    public TCFreieStellbarkeit getFreieStellbarkeit() {
        return freieStellbarkeit;
    }

    /**
     * Legt den Wert der freieStellbarkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFreieStellbarkeit }
     *     
     */
    public void setFreieStellbarkeit(TCFreieStellbarkeit value) {
        this.freieStellbarkeit = value;
    }

    /**
     * Ruft den Wert der nbRueckgabevoraussetzung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNBRueckgabevoraussetzung }
     *     
     */
    public TCNBRueckgabevoraussetzung getNBRueckgabevoraussetzung() {
        return nbRueckgabevoraussetzung;
    }

    /**
     * Legt den Wert der nbRueckgabevoraussetzung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNBRueckgabevoraussetzung }
     *     
     */
    public void setNBRueckgabevoraussetzung(TCNBRueckgabevoraussetzung value) {
        this.nbRueckgabevoraussetzung = value;
    }

}
