//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.signale._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSignal_Real complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSignal_Real">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Geltungsbereich" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}TCGeltungsbereich" minOccurs="0"/>
 *         &lt;element name="Signal_Befestigungsart" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}TCSignal_Befestigungsart"/>
 *         &lt;element name="Signal_Real_Aktiv" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}CSignal_Real_Aktiv" minOccurs="0"/>
 *         &lt;element name="Signal_Real_Aktiv_Schirm" type="{http://www.plan-pro.org/modell/Signale/1.9.0.2}CSignal_Real_Aktiv_Schirm" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSignal_Real", propOrder = {
    "geltungsbereich",
    "signalBefestigungsart",
    "signalRealAktiv",
    "signalRealAktivSchirm"
})
public class CSignalReal {

    @XmlElement(name = "Geltungsbereich")
    protected TCGeltungsbereich geltungsbereich;
    @XmlElement(name = "Signal_Befestigungsart", required = true)
    protected TCSignalBefestigungsart signalBefestigungsart;
    @XmlElement(name = "Signal_Real_Aktiv")
    protected CSignalRealAktiv signalRealAktiv;
    @XmlElement(name = "Signal_Real_Aktiv_Schirm")
    protected CSignalRealAktivSchirm signalRealAktivSchirm;

    /**
     * Ruft den Wert der geltungsbereich-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGeltungsbereich }
     *     
     */
    public TCGeltungsbereich getGeltungsbereich() {
        return geltungsbereich;
    }

    /**
     * Legt den Wert der geltungsbereich-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGeltungsbereich }
     *     
     */
    public void setGeltungsbereich(TCGeltungsbereich value) {
        this.geltungsbereich = value;
    }

    /**
     * Ruft den Wert der signalBefestigungsart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSignalBefestigungsart }
     *     
     */
    public TCSignalBefestigungsart getSignalBefestigungsart() {
        return signalBefestigungsart;
    }

    /**
     * Legt den Wert der signalBefestigungsart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSignalBefestigungsart }
     *     
     */
    public void setSignalBefestigungsart(TCSignalBefestigungsart value) {
        this.signalBefestigungsart = value;
    }

    /**
     * Ruft den Wert der signalRealAktiv-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSignalRealAktiv }
     *     
     */
    public CSignalRealAktiv getSignalRealAktiv() {
        return signalRealAktiv;
    }

    /**
     * Legt den Wert der signalRealAktiv-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSignalRealAktiv }
     *     
     */
    public void setSignalRealAktiv(CSignalRealAktiv value) {
        this.signalRealAktiv = value;
    }

    /**
     * Ruft den Wert der signalRealAktivSchirm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSignalRealAktivSchirm }
     *     
     */
    public CSignalRealAktivSchirm getSignalRealAktivSchirm() {
        return signalRealAktivSchirm;
    }

    /**
     * Legt den Wert der signalRealAktivSchirm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSignalRealAktivSchirm }
     *     
     */
    public void setSignalRealAktivSchirm(CSignalRealAktivSchirm value) {
        this.signalRealAktivSchirm = value;
    }

}
