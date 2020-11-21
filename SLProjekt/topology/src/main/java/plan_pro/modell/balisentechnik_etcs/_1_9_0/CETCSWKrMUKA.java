//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CETCS_W_Kr_MUKA complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CETCS_W_Kr_MUKA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Gruppen_ID" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCGruppen_ID" minOccurs="0"/>
 *         &lt;element name="Untergruppen_ID" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCUntergruppen_ID" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CETCS_W_Kr_MUKA", propOrder = {
    "gruppenID",
    "untergruppenID"
})
public class CETCSWKrMUKA {

    @XmlElement(name = "Gruppen_ID")
    protected TCGruppenID gruppenID;
    @XmlElement(name = "Untergruppen_ID")
    protected TCUntergruppenID untergruppenID;

    /**
     * Ruft den Wert der gruppenID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGruppenID }
     *     
     */
    public TCGruppenID getGruppenID() {
        return gruppenID;
    }

    /**
     * Legt den Wert der gruppenID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGruppenID }
     *     
     */
    public void setGruppenID(TCGruppenID value) {
        this.gruppenID = value;
    }

    /**
     * Ruft den Wert der untergruppenID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUntergruppenID }
     *     
     */
    public TCUntergruppenID getUntergruppenID() {
        return untergruppenID;
    }

    /**
     * Legt den Wert der untergruppenID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUntergruppenID }
     *     
     */
    public void setUntergruppenID(TCUntergruppenID value) {
        this.untergruppenID = value;
    }

}
