//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.block._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBlock_Anlage_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBlock_Anlage_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Schaltung" type="{http://www.plan-pro.org/modell/Block/1.8.0}TCSchaltung" minOccurs="0"/>
 *         &lt;element name="Schutzuebertrager" type="{http://www.plan-pro.org/modell/Block/1.8.0}TCSchutzuebertrager" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBlock_Anlage_Allg", propOrder = {
    "schaltung",
    "schutzuebertrager"
})
public class CBlockAnlageAllg {

    @XmlElement(name = "Schaltung")
    protected TCSchaltung schaltung;
    @XmlElement(name = "Schutzuebertrager")
    protected TCSchutzuebertrager schutzuebertrager;

    /**
     * Ruft den Wert der schaltung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSchaltung }
     *     
     */
    public TCSchaltung getSchaltung() {
        return schaltung;
    }

    /**
     * Legt den Wert der schaltung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSchaltung }
     *     
     */
    public void setSchaltung(TCSchaltung value) {
        this.schaltung = value;
    }

    /**
     * Ruft den Wert der schutzuebertrager-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSchutzuebertrager }
     *     
     */
    public TCSchutzuebertrager getSchutzuebertrager() {
        return schutzuebertrager;
    }

    /**
     * Legt den Wert der schutzuebertrager-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSchutzuebertrager }
     *     
     */
    public void setSchutzuebertrager(TCSchutzuebertrager value) {
        this.schutzuebertrager = value;
    }

}
