//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.nahbedienbereich._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CNB_Zone_Reihenfolgezwang complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CNB_Zone_Reihenfolgezwang">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Rang" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}TCRang" minOccurs="0"/>
 *         &lt;element name="Reihenfolgezwang_Zu_Abschalt" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}TCReihenfolgezwang_Zu_Abschalt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CNB_Zone_Reihenfolgezwang", propOrder = {
    "rang",
    "reihenfolgezwangZuAbschalt"
})
public class CNBZoneReihenfolgezwang {

    @XmlElement(name = "Rang")
    protected TCRang rang;
    @XmlElement(name = "Reihenfolgezwang_Zu_Abschalt")
    protected TCReihenfolgezwangZuAbschalt reihenfolgezwangZuAbschalt;

    /**
     * Ruft den Wert der rang-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRang }
     *     
     */
    public TCRang getRang() {
        return rang;
    }

    /**
     * Legt den Wert der rang-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRang }
     *     
     */
    public void setRang(TCRang value) {
        this.rang = value;
    }

    /**
     * Ruft den Wert der reihenfolgezwangZuAbschalt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCReihenfolgezwangZuAbschalt }
     *     
     */
    public TCReihenfolgezwangZuAbschalt getReihenfolgezwangZuAbschalt() {
        return reihenfolgezwangZuAbschalt;
    }

    /**
     * Legt den Wert der reihenfolgezwangZuAbschalt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCReihenfolgezwangZuAbschalt }
     *     
     */
    public void setReihenfolgezwangZuAbschalt(TCReihenfolgezwangZuAbschalt value) {
        this.reihenfolgezwangZuAbschalt = value;
    }

}
