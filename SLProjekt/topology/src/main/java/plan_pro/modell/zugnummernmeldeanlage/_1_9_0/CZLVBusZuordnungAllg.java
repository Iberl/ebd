//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZLV_Bus_Zuordnung_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZLV_Bus_Zuordnung_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Anschlussnummer" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCAnschlussnummer" minOccurs="0"/>
 *         &lt;element name="Unterstation_Nr" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCUnterstation_Nr"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZLV_Bus_Zuordnung_Allg", propOrder = {
    "anschlussnummer",
    "unterstationNr"
})
public class CZLVBusZuordnungAllg {

    @XmlElement(name = "Anschlussnummer")
    protected TCAnschlussnummer anschlussnummer;
    @XmlElement(name = "Unterstation_Nr", required = true)
    protected TCUnterstationNr unterstationNr;

    /**
     * Ruft den Wert der anschlussnummer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAnschlussnummer }
     *     
     */
    public TCAnschlussnummer getAnschlussnummer() {
        return anschlussnummer;
    }

    /**
     * Legt den Wert der anschlussnummer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAnschlussnummer }
     *     
     */
    public void setAnschlussnummer(TCAnschlussnummer value) {
        this.anschlussnummer = value;
    }

    /**
     * Ruft den Wert der unterstationNr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUnterstationNr }
     *     
     */
    public TCUnterstationNr getUnterstationNr() {
        return unterstationNr;
    }

    /**
     * Legt den Wert der unterstationNr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUnterstationNr }
     *     
     */
    public void setUnterstationNr(TCUnterstationNr value) {
        this.unterstationNr = value;
    }

}
