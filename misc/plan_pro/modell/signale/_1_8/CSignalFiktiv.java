//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.signale._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSignal_Fiktiv complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSignal_Fiktiv">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Auto_Einstellung" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCAuto_Einstellung" minOccurs="0"/>
 *         &lt;element name="Fiktives_Signal_Funktion" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCFiktives_Signal_Funktion"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSignal_Fiktiv", propOrder = {
    "autoEinstellung",
    "fiktivesSignalFunktion"
})
public class CSignalFiktiv {

    @XmlElement(name = "Auto_Einstellung")
    protected TCAutoEinstellung autoEinstellung;
    @XmlElement(name = "Fiktives_Signal_Funktion", required = true)
    protected TCFiktivesSignalFunktion fiktivesSignalFunktion;

    /**
     * Ruft den Wert der autoEinstellung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAutoEinstellung }
     *     
     */
    public TCAutoEinstellung getAutoEinstellung() {
        return autoEinstellung;
    }

    /**
     * Legt den Wert der autoEinstellung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAutoEinstellung }
     *     
     */
    public void setAutoEinstellung(TCAutoEinstellung value) {
        this.autoEinstellung = value;
    }

    /**
     * Ruft den Wert der fiktivesSignalFunktion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFiktivesSignalFunktion }
     *     
     */
    public TCFiktivesSignalFunktion getFiktivesSignalFunktion() {
        return fiktivesSignalFunktion;
    }

    /**
     * Legt den Wert der fiktivesSignalFunktion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFiktivesSignalFunktion }
     *     
     */
    public void setFiktivesSignalFunktion(TCFiktivesSignalFunktion value) {
        this.fiktivesSignalFunktion = value;
    }

}
