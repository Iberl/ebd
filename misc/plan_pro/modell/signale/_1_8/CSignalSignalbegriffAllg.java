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
 * <p>Java-Klasse f�r CSignal_Signalbegriff_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSignal_Signalbegriff_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Anschaltdauer" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCAnschaltdauer" minOccurs="0"/>
 *         &lt;element name="Beleuchtet" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCBeleuchtet" minOccurs="0"/>
 *         &lt;element name="Geschaltet" type="{http://www.plan-pro.org/modell/Signale/1.8.0}TCGeschaltet" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSignal_Signalbegriff_Allg", propOrder = {
    "anschaltdauer",
    "beleuchtet",
    "geschaltet"
})
public class CSignalSignalbegriffAllg {

    @XmlElement(name = "Anschaltdauer")
    protected TCAnschaltdauer anschaltdauer;
    @XmlElement(name = "Beleuchtet")
    protected TCBeleuchtet beleuchtet;
    @XmlElement(name = "Geschaltet")
    protected TCGeschaltet geschaltet;

    /**
     * Ruft den Wert der anschaltdauer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAnschaltdauer }
     *     
     */
    public TCAnschaltdauer getAnschaltdauer() {
        return anschaltdauer;
    }

    /**
     * Legt den Wert der anschaltdauer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAnschaltdauer }
     *     
     */
    public void setAnschaltdauer(TCAnschaltdauer value) {
        this.anschaltdauer = value;
    }

    /**
     * Ruft den Wert der beleuchtet-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBeleuchtet }
     *     
     */
    public TCBeleuchtet getBeleuchtet() {
        return beleuchtet;
    }

    /**
     * Legt den Wert der beleuchtet-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBeleuchtet }
     *     
     */
    public void setBeleuchtet(TCBeleuchtet value) {
        this.beleuchtet = value;
    }

    /**
     * Ruft den Wert der geschaltet-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGeschaltet }
     *     
     */
    public TCGeschaltet getGeschaltet() {
        return geschaltet;
    }

    /**
     * Legt den Wert der geschaltet-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGeschaltet }
     *     
     */
    public void setGeschaltet(TCGeschaltet value) {
        this.geschaltet = value;
    }

}
