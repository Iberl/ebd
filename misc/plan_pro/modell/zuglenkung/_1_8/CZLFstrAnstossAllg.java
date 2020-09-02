//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.zuglenkung._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZL_Fstr_Anstoss_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZL_Fstr_Anstoss_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GKZSS" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}TCGKZSS" minOccurs="0"/>
 *         &lt;element name="Vmax_Annaeherung" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}TCVmax_Annaeherung" minOccurs="0"/>
 *         &lt;element name="ZL_Fstr_Zuschlag" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}TCZL_Fstr_Zuschlag" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZL_Fstr_Anstoss_Allg", propOrder = {
    "gkzss",
    "vmaxAnnaeherung",
    "zlFstrZuschlag"
})
public class CZLFstrAnstossAllg {

    @XmlElement(name = "GKZSS")
    protected TCGKZSS gkzss;
    @XmlElement(name = "Vmax_Annaeherung")
    protected TCVmaxAnnaeherung vmaxAnnaeherung;
    @XmlElement(name = "ZL_Fstr_Zuschlag")
    protected TCZLFstrZuschlag zlFstrZuschlag;

    /**
     * Ruft den Wert der gkzss-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGKZSS }
     *     
     */
    public TCGKZSS getGKZSS() {
        return gkzss;
    }

    /**
     * Legt den Wert der gkzss-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGKZSS }
     *     
     */
    public void setGKZSS(TCGKZSS value) {
        this.gkzss = value;
    }

    /**
     * Ruft den Wert der vmaxAnnaeherung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVmaxAnnaeherung }
     *     
     */
    public TCVmaxAnnaeherung getVmaxAnnaeherung() {
        return vmaxAnnaeherung;
    }

    /**
     * Legt den Wert der vmaxAnnaeherung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVmaxAnnaeherung }
     *     
     */
    public void setVmaxAnnaeherung(TCVmaxAnnaeherung value) {
        this.vmaxAnnaeherung = value;
    }

    /**
     * Ruft den Wert der zlFstrZuschlag-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZLFstrZuschlag }
     *     
     */
    public TCZLFstrZuschlag getZLFstrZuschlag() {
        return zlFstrZuschlag;
    }

    /**
     * Legt den Wert der zlFstrZuschlag-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZLFstrZuschlag }
     *     
     */
    public void setZLFstrZuschlag(TCZLFstrZuschlag value) {
        this.zlFstrZuschlag = value;
    }

}
