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
 * <p>Java-Klasse f�r CLEU_Schaltkasten_Position complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CLEU_Schaltkasten_Position">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Position" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCPosition" minOccurs="0"/>
 *           &lt;element name="Position_Sonstige" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCPosition_Sonstige" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLEU_Schaltkasten_Position", propOrder = {
    "position",
    "positionSonstige"
})
public class CLEUSchaltkastenPosition {

    @XmlElement(name = "Position")
    protected TCPosition position;
    @XmlElement(name = "Position_Sonstige")
    protected TCPositionSonstige positionSonstige;

    /**
     * Ruft den Wert der position-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPosition }
     *     
     */
    public TCPosition getPosition() {
        return position;
    }

    /**
     * Legt den Wert der position-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPosition }
     *     
     */
    public void setPosition(TCPosition value) {
        this.position = value;
    }

    /**
     * Ruft den Wert der positionSonstige-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPositionSonstige }
     *     
     */
    public TCPositionSonstige getPositionSonstige() {
        return positionSonstige;
    }

    /**
     * Legt den Wert der positionSonstige-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPositionSonstige }
     *     
     */
    public void setPositionSonstige(TCPositionSonstige value) {
        this.positionSonstige = value;
    }

}
