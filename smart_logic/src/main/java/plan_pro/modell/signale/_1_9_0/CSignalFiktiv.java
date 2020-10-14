//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.signale._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element name="Auto_Einstellung" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}TCAuto_Einstellung" minOccurs="0"/>
 *         &lt;element name="Fiktives_Signal_Funktion" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}TCFiktives_Signal_Funktion" maxOccurs="unbounded"/>
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
    protected List<TCFiktivesSignalFunktion> fiktivesSignalFunktion;

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
     * Gets the value of the fiktivesSignalFunktion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fiktivesSignalFunktion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFiktivesSignalFunktion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCFiktivesSignalFunktion }
     * 
     * 
     */
    public List<TCFiktivesSignalFunktion> getFiktivesSignalFunktion() {
        if (fiktivesSignalFunktion == null) {
            fiktivesSignalFunktion = new ArrayList<TCFiktivesSignalFunktion>();
        }
        return this.fiktivesSignalFunktion;
    }

}
