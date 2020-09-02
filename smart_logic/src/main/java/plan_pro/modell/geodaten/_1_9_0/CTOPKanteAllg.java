//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CTOP_Kante_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CTOP_Kante_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TOP_Anschluss_A" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCTOP_Anschluss_A"/>
 *         &lt;element name="TOP_Anschluss_B" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCTOP_Anschluss_B"/>
 *         &lt;element name="TOP_Laenge" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCTOP_Laenge"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTOP_Kante_Allg", propOrder = {
    "topAnschlussA",
    "topAnschlussB",
    "topLaenge"
})
public class CTOPKanteAllg {

    @XmlElement(name = "TOP_Anschluss_A", required = true)
    protected TCTOPAnschlussA topAnschlussA;
    @XmlElement(name = "TOP_Anschluss_B", required = true)
    protected TCTOPAnschlussB topAnschlussB;
    @XmlElement(name = "TOP_Laenge", required = true)
    protected TCTOPLaenge topLaenge;

    /**
     * Ruft den Wert der topAnschlussA-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTOPAnschlussA }
     *     
     */
    public TCTOPAnschlussA getTOPAnschlussA() {
        return topAnschlussA;
    }

    /**
     * Legt den Wert der topAnschlussA-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTOPAnschlussA }
     *     
     */
    public void setTOPAnschlussA(TCTOPAnschlussA value) {
        this.topAnschlussA = value;
    }

    /**
     * Ruft den Wert der topAnschlussB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTOPAnschlussB }
     *     
     */
    public TCTOPAnschlussB getTOPAnschlussB() {
        return topAnschlussB;
    }

    /**
     * Legt den Wert der topAnschlussB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTOPAnschlussB }
     *     
     */
    public void setTOPAnschlussB(TCTOPAnschlussB value) {
        this.topAnschlussB = value;
    }

    /**
     * Ruft den Wert der topLaenge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTOPLaenge }
     *     
     */
    public TCTOPLaenge getTOPLaenge() {
        return topLaenge;
    }

    /**
     * Legt den Wert der topLaenge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTOPLaenge }
     *     
     */
    public void setTOPLaenge(TCTOPLaenge value) {
        this.topLaenge = value;
    }

}
