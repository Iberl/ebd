//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ansteuerung_element._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CAEA_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CAEA_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Aussenelementansteuerung_Art" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCAussenelementansteuerung_Art"/>
 *         &lt;element name="Bauart" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCBauart" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CAEA_Allg", propOrder = {
    "aussenelementansteuerungArt",
    "bauart"
})
public class CAEAAllg {

    @XmlElement(name = "Aussenelementansteuerung_Art", required = true)
    protected TCAussenelementansteuerungArt aussenelementansteuerungArt;
    @XmlElement(name = "Bauart")
    protected TCBauart bauart;

    /**
     * Ruft den Wert der aussenelementansteuerungArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAussenelementansteuerungArt }
     *     
     */
    public TCAussenelementansteuerungArt getAussenelementansteuerungArt() {
        return aussenelementansteuerungArt;
    }

    /**
     * Legt den Wert der aussenelementansteuerungArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAussenelementansteuerungArt }
     *     
     */
    public void setAussenelementansteuerungArt(TCAussenelementansteuerungArt value) {
        this.aussenelementansteuerungArt = value;
    }

    /**
     * Ruft den Wert der bauart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBauart }
     *     
     */
    public TCBauart getBauart() {
        return bauart;
    }

    /**
     * Legt den Wert der bauart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBauart }
     *     
     */
    public void setBauart(TCBauart value) {
        this.bauart = value;
    }

}
