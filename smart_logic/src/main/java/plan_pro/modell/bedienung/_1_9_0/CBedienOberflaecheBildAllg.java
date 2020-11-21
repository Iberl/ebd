//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBedien_Oberflaeche_Bild_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Oberflaeche_Bild_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Oberflaeche_Bildart" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCOberflaeche_Bildart" minOccurs="0"/>
 *         &lt;element name="Oberflaeche_Zustaendigkeit" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCOberflaeche_Zustaendigkeit" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Oberflaeche_Bild_Allg", propOrder = {
    "oberflaecheBildart",
    "oberflaecheZustaendigkeit"
})
public class CBedienOberflaecheBildAllg {

    @XmlElement(name = "Oberflaeche_Bildart")
    protected TCOberflaecheBildart oberflaecheBildart;
    @XmlElement(name = "Oberflaeche_Zustaendigkeit")
    protected TCOberflaecheZustaendigkeit oberflaecheZustaendigkeit;

    /**
     * Ruft den Wert der oberflaecheBildart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCOberflaecheBildart }
     *     
     */
    public TCOberflaecheBildart getOberflaecheBildart() {
        return oberflaecheBildart;
    }

    /**
     * Legt den Wert der oberflaecheBildart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCOberflaecheBildart }
     *     
     */
    public void setOberflaecheBildart(TCOberflaecheBildart value) {
        this.oberflaecheBildart = value;
    }

    /**
     * Ruft den Wert der oberflaecheZustaendigkeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCOberflaecheZustaendigkeit }
     *     
     */
    public TCOberflaecheZustaendigkeit getOberflaecheZustaendigkeit() {
        return oberflaecheZustaendigkeit;
    }

    /**
     * Legt den Wert der oberflaecheZustaendigkeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCOberflaecheZustaendigkeit }
     *     
     */
    public void setOberflaecheZustaendigkeit(TCOberflaecheZustaendigkeit value) {
        this.oberflaecheZustaendigkeit = value;
    }

}
