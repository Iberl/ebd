//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBUE_Abhaengigkeit_Fue complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Abhaengigkeit_Fue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Auto_Het" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCAuto_Het" minOccurs="0"/>
 *         &lt;element name="Fue_Schaltfall" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCFue_Schaltfall" minOccurs="0"/>
 *         &lt;element name="Stoerhalt_Haltfall" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCStoerhalt_Haltfall" minOccurs="0"/>
 *         &lt;element name="Stoerhalt_Merkhinweis" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCStoerhalt_Merkhinweis" minOccurs="0"/>
 *         &lt;element name="Zeitueberschreitungsmeldung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCZeitueberschreitungsmeldung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Abhaengigkeit_Fue", propOrder = {
    "autoHet",
    "fueSchaltfall",
    "stoerhaltHaltfall",
    "stoerhaltMerkhinweis",
    "zeitueberschreitungsmeldung"
})
public class CBUEAbhaengigkeitFue {

    @XmlElement(name = "Auto_Het")
    protected TCAutoHet autoHet;
    @XmlElement(name = "Fue_Schaltfall")
    protected TCFueSchaltfall fueSchaltfall;
    @XmlElement(name = "Stoerhalt_Haltfall")
    protected TCStoerhaltHaltfall stoerhaltHaltfall;
    @XmlElement(name = "Stoerhalt_Merkhinweis")
    protected TCStoerhaltMerkhinweis stoerhaltMerkhinweis;
    @XmlElement(name = "Zeitueberschreitungsmeldung", required = true)
    protected TCZeitueberschreitungsmeldung zeitueberschreitungsmeldung;

    /**
     * Ruft den Wert der autoHet-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAutoHet }
     *     
     */
    public TCAutoHet getAutoHet() {
        return autoHet;
    }

    /**
     * Legt den Wert der autoHet-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAutoHet }
     *     
     */
    public void setAutoHet(TCAutoHet value) {
        this.autoHet = value;
    }

    /**
     * Ruft den Wert der fueSchaltfall-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFueSchaltfall }
     *     
     */
    public TCFueSchaltfall getFueSchaltfall() {
        return fueSchaltfall;
    }

    /**
     * Legt den Wert der fueSchaltfall-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFueSchaltfall }
     *     
     */
    public void setFueSchaltfall(TCFueSchaltfall value) {
        this.fueSchaltfall = value;
    }

    /**
     * Ruft den Wert der stoerhaltHaltfall-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCStoerhaltHaltfall }
     *     
     */
    public TCStoerhaltHaltfall getStoerhaltHaltfall() {
        return stoerhaltHaltfall;
    }

    /**
     * Legt den Wert der stoerhaltHaltfall-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCStoerhaltHaltfall }
     *     
     */
    public void setStoerhaltHaltfall(TCStoerhaltHaltfall value) {
        this.stoerhaltHaltfall = value;
    }

    /**
     * Ruft den Wert der stoerhaltMerkhinweis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCStoerhaltMerkhinweis }
     *     
     */
    public TCStoerhaltMerkhinweis getStoerhaltMerkhinweis() {
        return stoerhaltMerkhinweis;
    }

    /**
     * Legt den Wert der stoerhaltMerkhinweis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCStoerhaltMerkhinweis }
     *     
     */
    public void setStoerhaltMerkhinweis(TCStoerhaltMerkhinweis value) {
        this.stoerhaltMerkhinweis = value;
    }

    /**
     * Ruft den Wert der zeitueberschreitungsmeldung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZeitueberschreitungsmeldung }
     *     
     */
    public TCZeitueberschreitungsmeldung getZeitueberschreitungsmeldung() {
        return zeitueberschreitungsmeldung;
    }

    /**
     * Legt den Wert der zeitueberschreitungsmeldung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZeitueberschreitungsmeldung }
     *     
     */
    public void setZeitueberschreitungsmeldung(TCZeitueberschreitungsmeldung value) {
        this.zeitueberschreitungsmeldung = value;
    }

}
